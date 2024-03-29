package com.telstra.jwt.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtility implements Serializable {
    private static  final long serialVersionUID = 876543212;
    public static final long JWT_TOKEN_VALIDITY = 5* 60 *60;
    @Value("${jwt.secret}")
    private String secretKey;


    public String getUsernameFromToken(String token){
        return  getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);

    }
    //retrieving any info from token we will need secret key
    private  Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
    }

    private Boolean isTokenExpred(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }
    //while creating the token
    //1. Define Claims of the token like issues, expiration,subject,
    //2.Sign the JWT using HS512 algorithm and secret key
    private String doGenerateToken(Map<String, Object> claims, String subject) {
     return Jwts.builder()
             .setClaims(claims)
             .setSubject(subject)
             .setIssuedAt(new Date(System.currentTimeMillis()))
             .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
             .signWith(SignatureAlgorithm.HS512,secretKey).compact();
    }

    //Validate token
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) &&!isTokenExpred(token));
    }
}


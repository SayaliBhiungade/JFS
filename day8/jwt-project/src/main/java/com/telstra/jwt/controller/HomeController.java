package com.telstra.jwt.controller;

import com.telstra.jwt.filter.JwtFilter;
import com.telstra.jwt.model.jwtRequest;
import com.telstra.jwt.model.jwtResponse;
import com.telstra.jwt.service.UserService;
import com.telstra.jwt.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    public JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){

        return "Home";
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public jwtResponse authenticate (@RequestBody jwtRequest jwtRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                )
        );

        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials",e);

        }
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtUtility.generateToken(userDetails);
        System.out.println("here.....");
        return new jwtResponse(token);
    }
}

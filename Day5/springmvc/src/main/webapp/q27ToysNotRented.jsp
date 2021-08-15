
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "baby_toy_company";
String userid = "root";
String password = "Sayali@123";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Toys which was not at all rented out 
</h1>
<table border="1">
<tr>
<td>Toy ID</td>
<td>Toy Name</td>
<td>Toy Type</td>
<td>Min Age</td>
<td>Max Age</td>
<td>Price</td>
<td>Quantity</td>
<td>Rental Amount</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="Select * from Toy where toy_id not in(select toy_id from Toy_Rental);";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("Toy_Id") %></td>
<td><%=resultSet.getString("Toy_Name") %></td>
<td><%=resultSet.getString("Toy_Type") %></td>
<td><%=resultSet.getInt("Min_Age") %></td>
<td><%=resultSet.getInt("Max_Age") %></td>
<td><%=resultSet.getDouble("Price") %></td>
<td><%=resultSet.getInt("Quantity") %></td>
<td><%=resultSet.getDouble("Rental_Amount") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
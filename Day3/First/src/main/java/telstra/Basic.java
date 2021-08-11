package telstra;

import java.io.*;
//import javax.servlet.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Basic extends HttpServlet{
	
	private String message;
	
	public void init() throws ServletException{
		message = "welcome to Servlet Response";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<h1>"+message+"</h1>");
		
	}
	
	public void destroy() {
		//do nothing
	}

}

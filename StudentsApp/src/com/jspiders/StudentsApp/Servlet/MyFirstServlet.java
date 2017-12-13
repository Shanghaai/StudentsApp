package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;



import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException
	{
		//Java code to generate current date and time
		Date dateRef = new Date();
		String curreDate = dateRef.toString(); //toString(); method has a functionality to display
		                                       // String representation of date and time object
		String htmlresp = //"<html>"
				         //+"<body>" 
			             "<h1>" 
				         +"Current Date and Time : "      
			             +"<font color = \"blue\">"
				         +curreDate
			             +"</font>"
				         +"</h1>";
				         //+"</body"
				         //+"</html>";
		
		/*//Java code to generate current date and time
				Date dateRef = new Date();
				String curreDate = dateRef.toString();
				*/
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter(); // for printing output in Browser
		out.println(htmlresp);

		String x1 = req.getParameter("fname");
		String x2 = req.getParameter("lname");
		out.println("First Name : "+x1);
		out.println("<br></br>");
		out.println("\nLast Name :"+x2);
		
		String xx = "<html>"
				   +"<body>"
				   +"<h1>" 
				   +"first name  X1 Value : "+x1
		           +"</h1>"
		           +"<h3>" 
		           +"Last name X2 Value : "+x2
		           +"</h3>"
				   +"</body"
           		   +"</html>";
		out.println(xx);
	}
}

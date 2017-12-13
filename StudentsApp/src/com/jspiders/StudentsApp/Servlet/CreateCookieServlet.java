package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Create Cookie
		String name = "myName";
		String value= "Praveen D";
		
		Cookie myNameCookie = new Cookie(name, value);
		resp.addCookie(myNameCookie);
		
		//Create Another Cookie	
		Cookie myLocationCookie = new Cookie("myLocation", "Bangalore");
		myLocationCookie.setMaxAge(7*24*60*60); //Time in Seconds
		resp.addCookie(myLocationCookie);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Created the Cookie ...");
		
	}//End of doGet
}//End of Class

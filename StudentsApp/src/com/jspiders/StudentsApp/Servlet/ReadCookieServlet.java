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

public class ReadCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Read Cookie from request
		Cookie[] receivedCookies = req.getCookies();
		
		if(receivedCookies==null)
		{
			out.println("No Cookies are Present in the Request !!!");
		}else{
			out.println("Cookies are Present in the Request ...");
			
			for(Cookie receivedCookie : receivedCookies)
			{
				String name = receivedCookie.getName();
				String value = receivedCookie.getValue();
				out.println(" Cookie-Name : "+name);
				out.println(" Cookie-Value : "+value);
				
			}//End of for
		}//End of if-else
	}//End of doGet
}//End of Class

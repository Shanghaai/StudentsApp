package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		
		//set the required attribute
		context.setAttribute("contextKey", new Object());
		req.setAttribute("requestKey", "Request Attribute");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("second");
		dispatcher.forward(req, resp);
		
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("Added the Context & Request Attributes ...");
		
	}//End of doGet
}//End of Class

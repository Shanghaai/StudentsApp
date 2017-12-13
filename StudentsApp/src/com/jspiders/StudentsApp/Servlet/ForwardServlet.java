package com.jspiders.StudentsApp.Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Do Not Handle the Request
		 * Instead Forward
		 */
//		Static Resource
//		String url = "index.html";
		
//		Static Resource
		String url = "/currentDate";
		
//		External Resource
//		String url = "http://www.gmail.com";
		
		//RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);//getting req dispatcher object via
																		 //servlet context N forwarding url
		dispatcher.forward(req, resp);
	}
}
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//	throws ServletException, IOException 
//			{
//				//String url = "currentDate";
//				String url = "index.html";		
//				  //getting req dispacher object via
//				 //req object
//				RequestDispatcher dispatcher = req.getRequestDispatcher(url);
//				dispatcher.forward(req, resp);
//			}
//}

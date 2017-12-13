package com.jspiders.StudentsApp.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Do Not Handle the Request
		 * Instead Redirect
		 */
		//External
//		String url = "http://www.gmail.com";
		String url = "http://www.facebook.com";
//		String url = "http://localhost:8080/studentsApp/currentDate";
//		String url = "http://localhost:8080/studentsApp/index.html";
//		String url = "currentDate";
		resp.sendRedirect(url);
	}
}

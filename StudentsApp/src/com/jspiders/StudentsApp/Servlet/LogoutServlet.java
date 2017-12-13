package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.StudentsApp.dao.StudentDAO;
import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Get the current Session
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			session.invalidate();
		}
		//Go to Login Page
		req.setAttribute("errInfo", "Successfuly Logged out of the Application ...");
		RequestDispatcher dispatcher = req.getRequestDispatcher("loginErr");
		dispatcher.forward(req, resp);
	}
}//End of Class

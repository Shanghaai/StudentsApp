package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginErrorServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String errInfo = (String)req.getAttribute("errInfo");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<font color=\"red\">");
		out.println(errInfo);
		out.println("</font>");
		out.println("</body>");
		out.println("</html>");
		
		out.println("<BR><BR>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
		dispatcher.include(req, resp);
	}//End of doPost()
}//End of Class

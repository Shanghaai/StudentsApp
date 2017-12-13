package com.jspiders.StudentsApp.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

class MyGenericServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Inside My Generic Servlet ...");
	}//End of service

}//End of Class


//all methods present in servlet interface
/*class ABC implements Servlet
{
	public void destroy() {}

	public ServletConfig getServletConfig() {}

	public String getServletInfo() {}

	public void init(ServletConfig arg0) throws ServletException {}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {}
	
}*/
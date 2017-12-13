package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		Object obj = context.getAttribute("contextKey");
		
		if(obj==null){
			out.println("No Context Attributes are Present !!!");
		}else{
			out.println("Context Attributes are Present ...<br></br>");
			out.println("Value is : "+obj.toString());
		}
		
		Object obj2 = req.getAttribute("requestKey");
		if(obj2==null){
			out.println("No Request Attributes are Present !!!");
		}else{
			out.println("<br></br>Request Attributes are Present !!!<br></br>");
			out.println("Value is : "+(String)obj2);
		}

		/*Object obj3 = req.getAttribute("requestKey");
		out.println("......NOW if we want to remove request obj then");
		*/
		req.removeAttribute("requestKey");
		Object x =req.getAttribute("requestKey");
		out.println("<br></br>Now Value of requestKey :"+x);
		if(x==null)
			out.println(" <br></br> we are done request Attribute gets removed");
		else 
			out.println(" it sucks");
//-------------------------------------------------------------------------------------------//		
	}//End of doGet
}//End of Class

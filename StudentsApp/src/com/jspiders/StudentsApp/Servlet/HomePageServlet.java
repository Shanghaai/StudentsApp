package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.DataLine;

import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class HomePageServlet extends HttpServlet 
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
		//Validate the Session
		//it will return existing session object only
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			//Invalid Session; Go to Login Page with error info
			req.setAttribute("errInfo", "In-Valid Session !!! Pls Login ...");
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginErr");
			dispatcher.forward(req, resp);
			
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			List<StudentInfoBean> dataList = (List<StudentInfoBean>)session.getAttribute("data");
			String isadmin = (String)session.getAttribute("isadmin");
			
			RequestDispatcher header = req.getRequestDispatcher("Header.html");
			header.include(req, resp);
			out.println("<BR><BR>");
			
			out.println("<html>								");
			out.println("<body>                             ");
			out.println("	<table>                         ");
			out.println("		<tr bgcolor=\"yellow\">		");
			out.println("			<td>Reg. No. </td>      ");
			out.println("			<td>First Name</td>     ");
			out.println("			<td>Middle Name</td>    ");
			out.println("			<td>Last Name</td>      ");
			out.println("			<td>G First Name</td>   ");
			out.println("			<td>G Middle Name</td>  ");
			out.println("			<td>G Last Name</td>    ");
			
			if(isadmin.equals("Y"))
			{
				out.println("			<td>Edit</td>  ");
				out.println("			<td>Delete</td>    ");
			}
			out.println("		</tr>                       ");
			
			for(StudentInfoBean bean : dataList)
			{
				out.println("	   <tr>                        ");
				out.println("			<td>"+bean.getRegno()+" </td>     ");
				out.println("			<td>"+bean.getFirstNM()+"</td>    ");
				out.println("			<td>"+bean.getMiddleNM()+"</td>   ");
				out.println("			<td>"+bean.getLastNM()+"</td>     ");
				out.println("			<td>"+bean.getGfirstNM()+"</td>   ");
				out.println("			<td>"+bean.getGmiddleNM()+"</td>  ");
				out.println("			<td>"+bean.getGlastNM()+"</td>    ");
				
				if(isadmin.equals("Y"))
				{
					out.println("<td><a href=\"./editDelete?action=edit&regno="+bean.getRegno()+"\">Edit</a></td>    ");
					out.println("<td><a href=\"./editDelete?action=delete&regno="+bean.getRegno()+"\">Delete</a></td>    ");
				}
				
				out.println("	   </tr>                       ");
			}
			
			out.println("	</table>                        ");
			out.println("</body>                            ");
			out.println("</html>");
			
			out.println("<BR><BR>");
			RequestDispatcher footer = req.getRequestDispatcher("Footer.html");
			footer.include(req, resp);
		}
	}//End of doPost()
}//End of Class

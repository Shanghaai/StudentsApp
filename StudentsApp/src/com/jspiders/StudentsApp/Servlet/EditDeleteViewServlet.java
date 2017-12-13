package com.jspiders.StudentsApp.Servlet;

	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.jspiders.StudentsApp.dao.StudentDAO;
	import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class EditDeleteViewServlet extends HttpServlet
	{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			StudentInfoBean bean = (StudentInfoBean)req.getAttribute("data");
			String action = (String)req.getAttribute("action");
			
			RequestDispatcher header = req.getRequestDispatcher("Header.html");
			header.include(req, resp);
			out.println("<BR><BR>");
			
			out.println("<html>																					");
			out.println("<body>                                                                                 ");
			out.println("	<form action=\"#\" method=\"post\">                                                     ");
			out.println("		<table>                                                                         ");
			out.println("			<tr>                                                                        ");
			out.println("				<td>Reg No</td>                                                         ");
			out.println("				<td><input type=\"text\" name=\"regno\" value=\""+bean.getRegno()+"\" readonly=\true\"></td>   ");
			out.println("			</tr>                                                                       ");
			out.println("			<tr>                                                                        ");
			out.println("				<td>First Name</td>                                                     ");
			if(action.equals("edit")){
				out.println("				<td><input type=\"text\" name=\"fnm\" value=\""+bean.getFirstNM()+"\"></td>                     ");	
			}else{
				out.println("				<td><input type=\"text\" name=\"fnm\" value=\""+bean.getFirstNM()+"\" readonly=\true\"></td>                     ");
			}
			
			out.println("			</tr>                                                                       ");
			out.println("			<tr>                                                                        ");
			out.println("				<td>Guardian First Name</td>                                            ");
			if(action.equals("edit")){
				out.println("				<td><input type=\"text\" name=\"gfnm\" value=\""+bean.getGfirstNM()+"\"></td>                    ");
			}else{
				out.println("				<td><input type=\"text\" name=\"gfnm\" value=\""+bean.getGfirstNM()+"\" readonly=\true\"></td>                    ");
			}
			
			out.println("			</tr>                                                                       ");
			out.println("			<tr>                                                                        ");
			out.println("				<td>Password</td>                                                       ");
			if(action.equals("edit")){
				out.println("				<td><input type=\"password\" name=\"pass\" value=\""+bean.getPassword()+"\"></td>                    ");		
			}else{
				out.println("				<td><input type=\"password\" name=\"pass\" value=\""+bean.getPassword()+"\" readonly=\true\"></td>                    ");
			}
		
			out.println("			</tr>                                                                       ");
			out.println("		</table>                                                                        ");
			out.println("		<BR> <BR>                                                                       ");
			if(action.equals("edit")){
				out.println("		<input type=\"hidden\" name=\"action\" value=\"edit\" />   ");
			}else{
				out.println("		<input type=\"hidden\" name=\"action\" value=\"delete\" />   ");	
			}
			if(action.equals("edit")){
				out.println("		<input type=\"submit\" value=\"Edit\" />   ");
			}else{
				out.println("		<input type=\"submit\" value=\"Delete\" />   ");	
			}
			
			out.println("	</form>");
			out.println("</body>");
			out.println("</html>");
			
			out.println("<BR><BR>");
			RequestDispatcher footer = req.getRequestDispatcher("Footer.html");
			footer.include(req, resp);
			
		}
}//End of Class

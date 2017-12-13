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

public class EditDeleteControllerServlet
extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Validate the Session
		HttpSession session = req.getSession(false);
		if(session==null){
			//Invalid Session; Go to Login Page
			req.setAttribute("errInfo", "In-Valid Session !!! Pls Login ...");
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginErr");
			dispatcher.forward(req, resp);
		}else{
			//Valid Session; Generate the Response
			//Get the Data
			String regno = req.getParameter("regno");
			String action = req.getParameter("action");
			
			//Interact with DB
			StudentDAO dao = new StudentDAO();
			StudentInfoBean bean = dao.getStudentInfo(regno);
			
			//Forward the request to View by Passing the Data
			req.setAttribute("data", bean);
			req.setAttribute("action", action);
			RequestDispatcher dispatcher = req.getRequestDispatcher("editDeleteView");
			dispatcher.forward(req, resp);
		}
		
		
	}
}//End of Class

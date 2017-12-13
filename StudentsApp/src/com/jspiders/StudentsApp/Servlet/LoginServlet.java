package com.jspiders.StudentsApp.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.StudentsApp.common.StudentsAppUtil;
import com.jspiders.StudentsApp.dao.StudentDAO;
import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class LoginServlet extends HttpServlet
{
	/*	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
		throws ServletException, IOException { to make a single threaded model 
											// uh need to synchronized service method	
											 * or implement SingleThreadModel interface
											 * that is already depricated
		synchronized (this) {
			
		}
		// TODO Auto-generated method stub
	super.service(arg0, arg1);
	}*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//1. Get the Form Data
		String regno    = req.getParameter("regno");
		String password = req.getParameter("pass");
		
		//2. Validate the Form Data
		StudentsAppUtil util = new StudentsAppUtil();
		boolean isValid = util.validate(regno, password);
		
		if(isValid)
		{
			//3. Authenticate by Interacting with DB
			StudentDAO dao = new StudentDAO();
			StudentInfoBean bean = dao.authenticate(regno, password);
			
			if(bean==null) 
			{
				//4. In-Valid Credentials
				req.setAttribute("errInfo", "In-Valid User Name OR Password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("loginErr");
				dispatcher.forward(req, resp);
				
			}
			else{
				//5. Create a Session for the First Time, means one user is logged-in 
				HttpSession session = req.getSession(true);

				//6. Valid Credentials
				List<StudentInfoBean> dataList = null;
				
				if(bean.getIsadmin().equals("Y"))
				{
					//7. Admin User
					dataList = dao.getAllStudents();
				}
				else
				{
					//8. Normal User
					dataList = new ArrayList<StudentInfoBean>();
					dataList.add(bean);
				}
				session.setAttribute("data", dataList);
				session.setAttribute("isadmin", bean.getIsadmin());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home");
				dispatcher.forward(req, resp);
			}
			
		}
		else
		{
			//9. In-Valid Form Data
			req.setAttribute("errInfo", "In-Valid User Name OR Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginErr");
			dispatcher.forward(req, resp);
		}//End of Validation
		
	}//End of doPost
	
}//End of Class

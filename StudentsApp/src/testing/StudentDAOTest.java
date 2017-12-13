package testing;

import java.util.Iterator;

import com.jspiders.StudentsApp.dao.StudentDAO;
import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class StudentDAOTest 
{
	public static void main(String[] args) {
	StudentDAO bean =  new StudentDAO();
	StudentInfoBean data = bean.getStudentInfo("2");
	
	if(data != null && data.getFirstNM().equalsIgnoreCase("sahil"))
	{
			 System.out.println(data.getFirstNM()+"--"+data.getLastNM());
			 System.out.println(data.getMiddleNM());
			 System.out.println(data.getFullName());
			 System.out.println(data.getIsadmin());
			 System.out.println(data.getRegno());
		 }
	}
}

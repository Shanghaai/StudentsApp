package testing;

import com.jspiders.StudentsApp.common.StudentsAppUtil;

public class StudentsAppUtilTest 
{
	
	public static void main(String[] args)
	{
		StudentsAppUtil utility  = new StudentsAppUtil();
		boolean isValid  = utility.validate("222", "SAHIL");
		System.out.println(isValid);
	}
}

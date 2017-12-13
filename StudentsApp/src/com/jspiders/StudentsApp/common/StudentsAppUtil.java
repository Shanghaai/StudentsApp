package com.jspiders.StudentsApp.common;

public class StudentsAppUtil 
{
		public boolean validate(String regno, String password)
		{
			if(regno==null || regno.trim().isEmpty())
			{
				return false;
			}
			else if(password==null || password.trim().isEmpty())
			{
				return false;
			}
			else
			{
				try 
				{
					Integer.parseInt(regno);
					return true;
				} 
				catch (NumberFormatException e) 
				{
					return false;
				}
			}//End of if-else
		}//End of validate
}//End of Class

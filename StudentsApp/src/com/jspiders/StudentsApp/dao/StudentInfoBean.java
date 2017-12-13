package com.jspiders.StudentsApp.dao;

import java.util.Iterator;

public class StudentInfoBean implements Iterable<Object>
	{
		private int regno;
		private String firstNM;
		private String middleNM;
		private String lastNM;
		
		private String gfirstNM;
		private String gmiddleNM;
		private String glastNM;
		
		private String isadmin;
		private String password;
		
		public int getRegno() 
		{
			return regno;
		}
		public void setRegno(int regno) 
		{
			this.regno = regno;
		}
		public String getFirstNM() 
		{
			return firstNM;
		}
		public void setFirstNM(String firstNM) 
		{
			this.firstNM = firstNM;
		}
		public String getMiddleNM() 
		{
			return middleNM;
		}
		public void setMiddleNM(String middleNM) 
		{
			this.middleNM = middleNM;
		}
		public String getLastNM() {
			return lastNM;
		}
		public void setLastNM(String lastNM) 
		{
			this.lastNM = lastNM;
		}
		public String getGfirstNM() 
		{
			return gfirstNM;
		}
		public void setGfirstNM(String gfirstNM) 
		{
			this.gfirstNM = gfirstNM;
		}
		public String getGmiddleNM() 
		{
			return gmiddleNM;
		}
		public void setGmiddleNM(String gmiddleNM) 
		{
			this.gmiddleNM = gmiddleNM;
		}
		public String getGlastNM() 
		{
			return glastNM;
		}
		public void setGlastNM(String glastNM) 
		{
			this.glastNM = glastNM;
		}
		public String getIsadmin() 
		{
			return isadmin;
		}
		public void setIsadmin(String isadmin) 
		{
			this.isadmin = isadmin;
		}
		public String getPassword() 
		{
			return password;
		}
		public void setPassword(String password) 
		{
			this.password = password;
		}
		public String getFullName()
		{
			return firstNM+middleNM+lastNM;
		}
		public Iterator<Object> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}

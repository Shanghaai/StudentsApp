package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jspiders.StudentsApp.dao.StudentDAO;
import com.jspiders.StudentsApp.dao.StudentInfoBean;

public class getStudentsTest {

	@Test
	public void test() {
		
		StudentDAO dao  = new StudentDAO();
		StudentInfoBean bean = dao.getStudentInfo("1");
		
		assertEquals(1, bean.getRegno());
		assertEquals("Shameem", bean.getFirstNM());
		assertEquals("Siddiqui", bean.getMiddleNM());
		assertEquals("NA",bean.getLastNM());
		assertEquals("Mohd",bean.getGfirstNM());
		assertEquals("Saleem", bean.getGmiddleNM());
		assertEquals("Siddiqui", bean.getGlastNM());
		
	}
}

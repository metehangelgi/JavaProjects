package courses;

import faculty.Department;
import university.Student;

public class CouseTest {
	
	public static void main(String[] args) {
		
		
		
		Student Alpay=new Student("Alpay", 04500, "Spring", 2007);
		Student Asma= new Student("Asma", 04111, "Fall", 2014);
		Student Elif=new Student("Elif", 4569, "Summer", 2015);
		Student Waris=new Student("Waris", 4991, "Fall", 2014);
		
		
		Department comp=new Department("Computer Engineering" , "Engineering");
		
		Course course=new Course("Advanced Programming", "Attila Gursoy",comp);
		
		
		course.registerStudent(Asma);
		course.registerStudent(Alpay);
		course.registerStudent(Elif);
		course.registerStudent(Waris);
		
		
		try {
			course.registerStudent(Asma);
		} catch(IllegalArgumentException e) {
			System.out.printf("%nException while adding student Asma again %s%n", e.getMessage());
		}
		
		
		System.out.println(course);
		
		System.out.println(comp);
		
		
		
		
	}

	
	
	
	
	
	
	
}
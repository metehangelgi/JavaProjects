package courses;

import university.Student;
import university.faculty.Department;


public class TestCourse {

	public static void main(String[] args) {
		
		// create students
		Student s1 = new Student("Alpay", 4500, "Spring", 2007); 
		Student s2 = new Student("Asma", 4111, "Fall", 2014);
		Student s3 = new Student("Elif", 4569, "Summer", 2015);
		Student s4 = new Student("Waris", 4991, "Fall", 2014);
		
		// create department
		Department dept = new Department("Computer Engineering", "Engineering");
		
		// create course
		Course course = new Course("Advanced Programming", "Attila Gursoy",dept);
		
		// add students:
		
		course.registerStudent(s1);
		course.registerStudent(s2);
		course.registerStudent(s3);
		course.registerStudent(s4);
		


		try {
			course.registerStudent(s1);
		}
		catch (IllegalArgumentException e) {
			System.out.printf("%nException while adding student s1 again: %s%n",e.getMessage());
		}
		
		// print course info
		System.out.println(course);
		
		// print department info
		System.out.println(dept);
		
	}

}

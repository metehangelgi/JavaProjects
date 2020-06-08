// this class belongs to package "university.faculty"
package university.faculty;

// import university package to use Student class
import university.Student;

public class TestDepartment {

	public static void main(String[] args) {

		// create a new department
		Department comp = new Department("COMP", "Faculty of Engineering");
		
		// create 4 students
		Student murat = new Student("MURAT", 4654, "Fall", 2009);
		Student deniz = new Student("DENIZ", 4914, "Spring", 1998);
		Student aysenur = new Student("AYSENUR", 4002, "Summer", 2015);
		Student songur = new Student("SONGUR", 4999, "Fall", 2013);
		
		// add two of them into the department
		comp.appendStudent(murat);
		comp.appendStudent(songur);
		
		// print department
		System.out.println("Department with two students: \n" + comp);
		
		// add the rest into the department
		comp.appendStudent(deniz);
		comp.appendStudent(aysenur);
		
		// print department again
		System.out.println("Department with all students: \n" + comp);
	}
}

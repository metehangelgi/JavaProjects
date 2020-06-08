// this class belongs to package "university.faculty"
package faculty;

// import ArrayList utility to use ArrayList class
import java.util.ArrayList;

// import university package in order to use the Student class
import university.Student;

// begin class definition
public class Department {

	// deptName field
	private String deptName;

	// facultyName field
	private String facultyName;

	// array list of student objects. Initially empty
	private ArrayList<Student> students = new ArrayList<Student>();
	/**
	 * A two-argument constructor
	 * @param deptName the name of department
	 * @param facultyName the name of faculty
	 */
	public Department(String deptName, String facultyName) {
		this.deptName = deptName;
		this.facultyName = facultyName;
	}

	/**
	 * Appends a new student to the ArrayList students
	 * @param st a new student
	 */
	public void appendStudent(Student st) {
		students.add(st);
	}

	/**
	 * The toString method. It prints all the students information
	 */
	public String toString() {
		String temp = "Department: " + getDeptName();
		temp += "\nFaculty: " + getFacultyName() +"\n";

		// append student information
		
	    for (Student st : students) {
	    	temp += st.toString()+"\n";
	    }

	    // return everything as a string
	    return temp;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

}

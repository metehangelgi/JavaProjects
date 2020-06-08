package courses;

import java.util.ArrayList;
import java.util.Arrays;

import university.Student;
import university.faculty.Department;

public class Course {
	
	Department department;
	ArrayList<Student> registeredStudents = new ArrayList<Student>();
	String name = "";
	String instructorName = "";
	
	public Course() {
		// Empty Constructor
	}
	
	public Course(String name, String instructorName, Department department) {
		this.department = department;
		this.name = name;
		this.instructorName = instructorName;
	}

	public Department getDepartment() {
		return department;
	}

	public String getName() {
		return name;
	}

	public String getInstructorName() {
		return instructorName;
	}
	public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
		this.registeredStudents=registeredStudents;
	}
	
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}	
	
	public void registerStudent(Student student) {
		if(registeredStudents.contains(student)) {
			throw new IllegalArgumentException("This student is already registered: "+student.toString());
		}else {
		this.registeredStudents.add(student);
		}
	}
	
	/* public String toString() {
		return 
				"Course " + this.name + " details:\n" +
				"Instructor name: "+ this.instructorName + "\n" +
				"Department: " + this.department + "\n" +
				"Registered students: " + Arrays.toString(this.registeredStudents.toArray());
	}*/

    // toStringf using String.format and inserting newline  between students
    public String toString() {
		String studentLine="";
		for(Student s : registeredStudents) 
		    studentLine += String.format("%s%n",s);
		return  String.format("Course %s details%nInstructor name: %s%nDepartment: %s%nRegistered students: %n%s",
		                       name,instructorName,department,studentLine);
        }

	
}

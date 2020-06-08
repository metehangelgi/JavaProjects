package courses;

import java.util.ArrayList;

import faculty.Department;
import university.Student;


public class Course {

	
	
	private Department department;
	
	private ArrayList<Student> registeredStudents= new ArrayList<Student>();
	
	private String name;
	
	private String InstructorName;
	
	
	
	public Course(String name,String instructorName,Department department){
		this.name=name;
		this.InstructorName=instructorName;
		this.department=department;
		
		
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public ArrayList<Student> getRegisteredStudents() {
		return registeredStudents;
	}



	public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getInstructorName() {
		return InstructorName;
	}



	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}
	
	public void registerStudent(Student st){
		if(!registeredStudents.contains(st)){
			registeredStudents.add(st); 
		}else{
			throw new IllegalArgumentException();
		}
		
		
	}
	
	
	public String toString() {
		String temp = "Name: " + getName();
		temp += "\nInstructorName: " + getInstructorName() +"\n";
		temp += "Department Name:" + getDepartment() +"\n";

		
		// append student information
	    for (Student st : registeredStudents) {
	    	temp += st.toString()+"\n";
	    }

	    // return everything as a string
	    return temp;
	}
	
	
	
}
/*
 * File: StudentTest.java
 * ----------------------
 * Simple test of the Student class.
 */

import acm.program.*;

public class StudentTest extends ConsoleProgram {

	public void run() {
		
//		Student mete=new Student();
//		
//		println(mete);
		
		
		
		Student diligentStudent = new Student("Hermione Granger", 314159);
		diligentStudent.setUnits(97);
		diligentStudent.setPaidUp(true);
		Student weakStudent = new Student("Vincent Crabbe", 271828);
		weakStudent.setUnits(17);
		weakStudent.setPaidUp(true);
		Student impoverishedStudent = new Student("Ron Weasley", 161803);
		impoverishedStudent.setUnits(32);
		testEligibility(diligentStudent);
		testEligibility(weakStudent);
		testEligibility(impoverishedStudent);
	}

	private void testEligibility(Student student) {
		String verb = (isEligibleToGraduate(student)) ? "is" : "is not";
		println(student + " " + verb + " eligible to graduate.");
	}

	private boolean isEligibleToGraduate(Student student) {
		return student.getUnits() >= Student.UNITS_TO_GRADUATE
				&& student.isPaidUp();
	}

}

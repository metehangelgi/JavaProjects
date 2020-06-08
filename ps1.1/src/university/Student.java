// package name where this class belongs
package university;

import java.util.Calendar;

// beginning of class definition
public class Student {

	private static final int DEFAULT_YEAR = 2000;
	private static final int MIN_ID=4001;
	private static final int MAX_ID=4999;

	// a private variable "name", the name of student
	private String name;

	// student ID
	private int ID;

	// semester in which student joined
	private String semester;

	// year the student joined
	private int year;

	// student status
	private boolean active;

	// current year. setting to current year
	static private int currentYear =
	    Calendar.getInstance().get(Calendar.YEAR);

	// current semester (1 - for spring)
	static private int currentSemester = 1;


	/**
	 * A two argument Constructor
	 */
	public Student(String name, int id) {
		// set name
		this.name = name;
		this.ID = (id >= MIN_ID && id <= MAX_ID) ? id : MIN_ID;
		semester = "Fall";
		year = DEFAULT_YEAR;
		active = true;
	}

	/**
	 * 	A four argument constructor
	 */
	public Student(String name, int ID, String semester, int year) {

		// Re-use the two argument constructor to set name and ID
		this(name, ID);

		// set semester. Use the setter "setSemester"
		this.setSemester(semester);

		// set year. Use the setter "setYear"
		this.setYear(year);
	}
	
	
	
	/**
	 *  A getter for the "name" field.
	 *  Returns the name of student
	 */
	public String getName() {
		return name;
	}

	/**
	 *  A getter for the "ID" field.
	 *  Returns the ID of student
	 */
	public int getID() {
		return ID;
	}

	/**
	 *  A getter for the "semester" field.
	 *  Returns the semester the student joined the university
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 *  A getter for the "year" field.
	 *  Returns the year the student joined the university
	 */
	public int getYear() {
		return year;
	}

	/**
	 *  A predicate method for the field "active".
	 *  Returns true if the student is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Returns the current year
	 */
	public static int getCurrentYear() {
		return currentYear;
	}

	/**
	 * Returns the current semester as an integer (0-for fall,
	 * 1 - for spring and 2 for summer)
	 * @return currentSemester
	 */
	public static int getCurrentSemester() {
		return currentSemester;
	}

	/**
	 *  A setter for the "semester" field.
	 *  Assigns semester to a new value. If the new value is empty or
	 *  null, "semester" is assigned to default value. If the new value is
	 *  other than "Fall", "Spring", or "Summer", "semester" is assigned
	 *  to default value.
	 */
	public void setSemester(String semester) {
		if (semester == null || semester.isEmpty()) { // if null or empty
			this.semester = "Fall"; // to me, fall is the default.
        } else if ( semester.equals("Fall")   ||
		            semester.equals("Spring") ||
			    	semester.equals("Summer") ) { // otherwise, everything is OK
			this.semester = semester;
		} else {
			this.semester = "Fall"; // to me, fall is the default.
		}
	}

	/**
	 *  A setter for the year field.
	 *  Assigns year to a new value.
	 *  Just for validation purposes, no year should be negative.
	 *  The default year is DEAFULT_YEAR
	 */
	public void setYear(int year) {
		if (year < 0) {
			this.year = DEFAULT_YEAR;
		} else {
			this.year = year;
		}
	}

	/*
	 *  A setter for the active field.
	 */
	public void setActive(boolean status) {
		active = status;
	}

	/**
	 * This method sets the current year to a new year.
	 * new year should be non-negative
	 */
	public static void setCurrentYear(int currentYear) {
		if (currentYear > 0) {
			Student.currentYear = currentYear;
		} else {
			Student.currentYear = DEFAULT_YEAR;
		}
	}

	/**
	 * Assigns current semester to a new semester.
	 * @param currentSemester should be between 0 and 2 inclusive.
	 */
	public static void setCurrentSemester(int currentSemester) {
		if (currentSemester >= 0 && currentSemester <= 2) {
			Student.currentSemester = currentSemester;
		} else {
			Student.currentSemester = 0; // default
		}
	}

	

	/**
	 * The toString method returns the string representation of a student
	 */
	public String toString() {
		//return semester + " " + year + " Student " + name + " - ID: " + String.format("%07d", ID);
		return String.format("Student %-20s ID: %07d %4d %s",name,ID,year,semester);
	}

} // end of class definition

/*
 * File: TransferStudent.java
 * ------------------
 * This file defines the TransferStudent subclass.
 */

/**
 * The TransferStudent class extends (is a subclass of) Student class.
 * Hence Student class is super class of TransferStudent.
 */

public class TransferStudent extends Student{


	/* Private instance variables */

	private String initialUniversity; /* The student's name          */
    private int unitsTransferred;
	
		/**
	 * Creates a new TransferStudent object with the specified name, ID and initial university.
	 * @param name The student's name as a String
	 * @param id The student's ID number as an int
	 * @param initialUniversity The student's initialUniversity as a String
	 */
	public TransferStudent(String name, int id, String initialUniversity) {
		// Your code starts here
        
		// Your code ends here
	}

	/**
	 * Gets the initial university of this student.
	 * @return The initial university of this student
	 */
	public String getInitialUniversity() {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Gets the units transferred for this student.
	 * @return The units transferred for this student
	 */
	public int getUnitsTransferred() {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Sets the number units transferred.
	 * @param unitsTransferred The number of units transferred
	 */
	public void setUnitsTransferred(int unitsTransferred) {
		// Your code starts here
		
		// Your code ends here
	}
    
    /**
	 * Sets the initial university.
	 * @param initialUniversity The initial university of this student
	 */
    public void setInitialUniversity(String initialUniversity) {
		// Your code starts here
		
		// Your code ends here
	}

	/**
	 * Creates a string identifying this student.
	 * @return The string used to display this student
	 */
	public String toString() {
		return getName() + " (#" + getID() + ")" + " " + initialUniversity;
	}
}

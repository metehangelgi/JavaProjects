public class Student {

	private String name;
	private String id;
	private double comp130;
	private double math203;

	/* Constructor: it takes a string for students name, a string for students id, a double
	 * for comp130 grade and a double for math203 grade.
	 */
	public Student(String s_name, String s_id, double total_comp130, double total_math203) {
		// Your code starts here
		name = s_name;
		id = s_id;
		comp130 = total_comp130;
		math203 = total_math203;
		// Your code ends here
	}

	/* getStudentName: returns student's name */
	public String getStudentName() {
		// Your code starts here
		return name;
		// Your code ends here
	}

	/* getStudentId: returns student's id */
	public String getStudentId() {
		// Your code starts here
		return id;
		// Your code ends here
	}

	/* getComp130Grade: returns letter grade for comp130 */
	public String getComp130Grade() {
		// Your code starts here
		return letterGrade(comp130);
		// Your code ends here
	}

	/* getMath203Grade: returns letter grade for math203 */
	public String getMath203Grade() {
		// Your code starts here
		return letterGrade(math203);
		// Your code ends here
	}

	/* letterGrade: returns letter grade for given score
	 * 90 <= score        -> A
	 * 80 <= score <   90 -> B
	 * 70 <= score <   80 -> C
	 * 60 <= score <   70 -> D
	 *       score <   60 -> F
	 */
	private String letterGrade(double score) {
		// Your code starts here
		if (score >= 90.0)
			return "A";
		else if (score >= 80.0)
			return "B";
		else if (score >= 70.0)
			return "C";
		else if (score >= 60.0)
			return "D";
		else
			return "F";
		// Your code ends here
	}
}

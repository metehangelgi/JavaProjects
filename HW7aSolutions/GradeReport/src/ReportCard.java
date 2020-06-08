import acm.graphics.*;

public class ReportCard extends GCompound {

	/* Constructor: it take a Student s and adds GLabels for student's
	 * name, id, comp130 and math203 grade. It also puts a GRect around
	 * the labels.
	 */
	public ReportCard(Student s) {
		// Your code starts here
		GLabel name = new GLabel(s.getStudentName()); 
		GLabel id = new GLabel(s.getStudentId());
		GLabel comp130grade = new GLabel("COMP. 130: " + s.getComp130Grade()); 
		GLabel math203grade = new GLabel("MATH. 203: " + s.getMath203Grade());
		GRect frame = new GRect(100, 120);
		add(name, 5, 20);
		add(id, 5, 40);
		add(comp130grade, 5, 60);
		add(math203grade, 5, 80);
		add(frame, 0, 0);
		// Your code ends here
	}
}

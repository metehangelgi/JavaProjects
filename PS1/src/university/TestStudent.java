// this class belong to package "university"
package university;

// beginning of class definition
public class TestStudent {

	// the main method. it should be public static, and void
	// its arguments are command line parameters
	@SuppressWarnings("static-access")
	public static void main(String [] args) {

		// create first student using two argument constructor
		Student elif = new Student("Elif", 4002);
		
		Student e = new Student("Elif", 12345, "Fall", 2018);
		System.out.println(e);

		// print information about merve by implicitly calling "toString"
		// You should see: Student Elif                 ID: 0004002 2000 Fall
		System.out.println(elif);

		elif.setSemester("Summer"); // set semester to Summer
		elif.setYear(2015); // set year to 2015

		// print only student ID, semester and year
		// You should see ID: 4002 Semester: Summer Year: 2015
		System.out.println("ID: " + elif.getID() + " Semester: " + elif.getSemester() + " Year: " + elif.getYear());

		// create a second student with 4 argument constructor
		Student alpay = new Student("Alpay", 5001, "Fall", 2011);

		// print information about Alpay: Student Alpay                ID: 0004001 2011 Fall
		// noticed? since 5001 is not between 4001 and 4999, ID is set to 4001
		System.out.println(alpay);

		// set current year to 2014
		alpay.setCurrentYear(2014);

		// print Alpay again
		// Student Alpay                ID: 0004001 2011 Fall
		System.out.println(alpay);

		// print Elif
		// Student Elif                 ID: 0004002 2015 Summer
		// Notice Current year: 2014. Why?? because currentYear is static
		System.out.print(elif + "\t ");
		System.out.print("Current Year:" + Student.getCurrentYear());
	}

} // end of class definition

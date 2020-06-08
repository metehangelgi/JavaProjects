import java.util.ArrayList;

/*
 * File: Movie.java
 * ------------------------------
 * Creates a Movie object with name,year,rating and cast members. Enables user to get cast info. and review about the film.
 */

public class Movie {

	private String movieName;
	private String year;
	private double rating;
	private ArrayList<String> cast;
	
	public Movie(String movieName, String year, double rating, ArrayList<String> cast){
		// Your code starts here
		this.movieName = movieName;
		this.year = year;
		this.rating = rating;
		// Your code ends here
		this.cast = cast;
	}

	public String getMovieName(){
		// Your code starts here
		return movieName;
		// Your code ends here
	}

	public String getYear(){
		// Your code starts here
		return year;
		// Your code ends here
	}
	
	public double getRating(){
		// Your code starts here
		return rating;
		// Your code ends here
	}
	
	public ArrayList<String> getCast(){
		// Your code starts here
		return cast;
		// Your code ends here
	}

	public String getReview(){
		// Your code starts here
		if(9 <= this.rating && 10 >= this.rating){
			return "Excellent";
		}
		else if(7 <= this.rating && 9 > this.rating){
			return "Good";
		}
		else if(5 <= this.rating && 7 > this.rating){
			return "Average";
		}
		else if(3 <= this.rating && 5 > this.rating){
			return "Below Average";
		}
		else if(0 <= this.rating && 3 > this.rating){
			return "Poor";
		}
		else{
			return "N/A";
		}
		// Your code ends here
	}

	public boolean inCast(String castName){
		// Your code starts here
		for(int i = 0; i < cast.size(); i++){
			String name = cast.get(i);
			if(name.equalsIgnoreCase(castName)) return true; 
		}
		return false;
		// Your code ends here
	}

}

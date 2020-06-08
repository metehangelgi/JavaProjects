package pa2;

import java.util.ArrayList;
import java.util.List;

public class Movies {

	private String moviename;
	private int releaseYear;
	private List<Actor> cast;

	public Movies(String moviename, int releaseYear, List<Actor> listActors) {
		this.moviename = moviename;
		this.releaseYear = releaseYear;
		cast = new ArrayList<Actor>();
		addAllActors(listActors);

	}

	public Movies(String moviename, int releaseYear) {
		this.moviename = moviename;
		this.releaseYear = releaseYear;
	}

	public void setMovieName(String movieName) {
		this.moviename = movieName;
	}

	public String getMovieName() {
		return this.moviename;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getReleaseYear() {
		return this.releaseYear;
	}

	public void addAllActors(List<Actor> listActors) {
		for (Actor actor : listActors) {
			cast.add(actor);
		}

	}

	public List<Actor> getAllActorsInMovie() {
		return this.cast;
	}

	public String toString() {
		String result = "";

		result = this.moviename + "(" + this.releaseYear + ") ";
		return result;
	}

}

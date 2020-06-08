package pa2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	static Map<String, List<Movies>> MoviesOfSelectedActor;
	static List<Movies> AllMovies;
	private static String MovieNameRegex = ".*\\(";
	private static String fileName = "movies_sample.txt";
	private static String ReleaseYearRegex = "[0-9]{4}";
	private static String ActorNameSurname = "\\/([A-Za-z]\\.?)*\\,\\s([A-Za-z]\\.?\\s?)*";

	public static void main(String[] args) {
		Pattern MovieNamePatter = Pattern.compile(MovieNameRegex);
		Pattern ReleaseYearPattern = Pattern.compile(ReleaseYearRegex);
		Pattern ActorNameSurnamePatter = Pattern.compile(ActorNameSurname);
		MoviesOfSelectedActor = new HashMap<String, List<Movies>>();
		AllMovies = new ArrayList<Movies>();
		try (Scanner input = new Scanner(Paths.get("./src/pa2/" + fileName));

		) {
			while (input.hasNext()) {
				List<Actor> listActors = new ArrayList<Actor>();
				String movie = input.nextLine();
				String movieName = null;
				int releaseYear = 0;
				Movies Inputmovie;
				Movies FinalFormOfMovie;
				Matcher MovieNameMatcher = MovieNamePatter.matcher(movie);
				Matcher ReleaseYearMatcher = ReleaseYearPattern.matcher(movie);
				Matcher ActorNameSurnameMatcher = ActorNameSurnamePatter.matcher(movie);

				if (MovieNameMatcher.find()) {

					movieName = MovieNameMatcher.group().substring(0, MovieNameMatcher.group().length() - 1);

				}

				if (ReleaseYearMatcher.find()) {
					releaseYear = Integer.parseInt(ReleaseYearMatcher.group());

				}

				while (ActorNameSurnameMatcher.find()) {
					String actorSurnameName = ActorNameSurnameMatcher.group().substring(1,
							ActorNameSurnameMatcher.group().length());
					String[] str = actorSurnameName.split(", ");
					String name = str[1];
					String surname = str[0];
					Actor PreActor = new Actor(name, surname);
					listActors.add(PreActor);
					Inputmovie = new Movies(movieName, releaseYear);

					if (MoviesOfSelectedActor.containsKey(name + " " + surname)) {
						List<Movies> moviesOfActor = new ArrayList<Movies>();
						moviesOfActor = MoviesOfSelectedActor.get(name + " " + surname);
						moviesOfActor.add(Inputmovie);

						MoviesOfSelectedActor.put(name + " " + surname, moviesOfActor);
					} else {
						List<Movies> moviesOfActor = new ArrayList<Movies>();
						moviesOfActor.add(Inputmovie);
						MoviesOfSelectedActor.put(name + " " + surname, moviesOfActor);
					}
				}

				FinalFormOfMovie = new Movies(movieName, releaseYear, listActors);

				AllMovies.add(FinalFormOfMovie);

			}

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		List<String> commonElements = Utils.question1(MoviesOfSelectedActor);

		commonElements.stream().sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);

		System.out.println("-----");
		Utils.question2(AllMovies);
		Utils.question3(MoviesOfSelectedActor);
		Utils.question4(AllMovies);
		Utils.question5(MoviesOfSelectedActor);

	}
}

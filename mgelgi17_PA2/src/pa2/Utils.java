package pa2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {

	static Scanner input = new Scanner(System.in);

	public Utils() {

	}

	public static List<String> question1(Map<String, List<Movies>> MoviesOfSelectedActor) {
		System.out.println("Enter the name and surname of the actor separated by comma (without a space):");

		String twoActors = input.nextLine();
		String[] str = twoActors.split(",");
		List<Movies> Moviesactor1 = null;
		List<Movies> Moviesactor2 = null;
		List<String> commonElements = null;
		while (commonElements == null) {
			try {
				Moviesactor1 = MoviesOfSelectedActor.get(str[0]);
				Moviesactor2 = MoviesOfSelectedActor.get(str[1]);

				List<String> actor1 = Moviesactor1.stream().map(Movies::getMovieName).collect(Collectors.toList());
				List<String> actor2 = Moviesactor2.stream().map(Movies::getMovieName).collect(Collectors.toList());
				commonElements = new ArrayList<>(actor1);
				commonElements.retainAll(new ArrayList<>(actor2));
			} catch (NullPointerException e) {
				System.out.println("there is no actor with these name");
				System.out.println("Please Enter Avaible Actors \n");
				twoActors = input.nextLine();
				str = twoActors.split(",");
			}
		}
		
		List<String> returnList = commonElements.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());

		System.out.printf("%s and %s had co-starred in %s movie:\n ", str[0], str[1],
				commonElements.size() == 1 ? "one" : "more than one");

		return returnList;

	}

	public static void question2(List<Movies> AllMovies) {
		System.out.println("Enter the first character and ordering type(i.e. (A descending)):");

		String CharAndType = input.nextLine();
		String[] str = CharAndType.split(" ");
		String CharOfMovie = str[0].toUpperCase();
		System.out.println("-----");
		String orderType = str[1].toLowerCase();
		List<String> AllMoviesString = new ArrayList<String>();
		AllMoviesString = AllMovies.stream().map(Movies::getMovieName).collect(Collectors.toCollection(ArrayList::new));

		String[] moviesToFilter = new String[AllMovies.size()];
		AllMoviesString.toArray(moviesToFilter);
		List<String> AllMoviesToFilter = Arrays.stream(moviesToFilter).filter(name -> name.startsWith(CharOfMovie))
				.sorted(orderType.equals("descending") ? String.CASE_INSENSITIVE_ORDER.reversed()
						: String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		AllMoviesToFilter.forEach((e) -> {
			System.out.println(e);
		});
	}

	public static void question3(Map<String, List<Movies>> MoviesOfSelectedActor) {
		System.out.println("Search movies by first name, please enter the actor’s first name: ");

		String firstName = input.nextLine();

		System.out.println("Movies played by actors with first name" + firstName + ": \n");
		System.out.println("Actor’s Name/Surname    Movie(s) Title(s)        \n");
		System.out.println("-----------------    ---------------------        \n");
		Pattern patternName = Pattern.compile("\\S{0}\\s{0}" + firstName + ".*");
		Function<Movies, Integer> ByReleaseYear = Movies::getReleaseYear;

		MoviesOfSelectedActor.entrySet().stream()
				.filter(s -> patternName.matcher(s.getKey()).find()
						&& s.getKey().substring(0, firstName.length()).equals(firstName))
				.forEach(
						s -> System.out
								.println(
										s.getKey() + "\t\t"
												+ s.getValue().stream().sorted(Comparator.comparing(ByReleaseYear))
														.map(Movies::toString).collect(Collectors.joining(","))
												+ "\n"));

	}

	public static void question4(List<Movies> AllMovies) {
		System.out.println("Search movies by release date."
				+ " Please enter the start year and end year of the period you want to search for separated by a space: ");

		String Years = input.nextLine();
		String[] str = Years.split(" ");
		int preYear = Integer.parseInt(str[0]);
		int pastYear = Integer.parseInt(str[1]);

		System.out.printf("Movies released between %d-%d \n", preYear, pastYear);

		Function<Movies, Integer> ByReleaseYear = Movies::getReleaseYear;

		Comparator<Movies> CompareByYear = Comparator.comparing(ByReleaseYear);

		AllMovies.stream().filter(Movie -> compare(preYear, pastYear, Movie)).sorted(CompareByYear).distinct()
				.forEach(movie -> System.out.printf("%s (%d) \n", movie.getMovieName(), movie.getReleaseYear()));

		input.close();

	}

	private static boolean compare(int preYear, int pastYear, Movies movie) {
		return preYear <= movie.getReleaseYear() && movie.getReleaseYear() <= pastYear;
	}

	public static void question5(Map<String, List<Movies>> MoviesOfSelectedActor) {

		Map<String, Integer> ToGetSize = MoviesOfSelectedActor.entrySet().stream()
				.collect(Collectors.toMap(actor -> actor.getKey(), movies -> movies.getValue().size()));

		Entry<String, Integer> ActorNameMaxMovie = ToGetSize.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get();

		Entry<String, List<Movies>> EntryOfPerson = Test.MoviesOfSelectedActor.entrySet().stream()
				.filter(map -> map.getKey().equals(ActorNameMaxMovie.getKey())).findFirst().get();

		Map<Integer, Long> countYear = EntryOfPerson.getValue().stream()
				.collect(Collectors.groupingBy(Movies::getReleaseYear, Collectors.counting()));

		long maxNumberOFTimes = countYear.entrySet().stream().sorted(Comparator.comparing(map -> map.getValue()))
				.findFirst().get().getValue();

		List<Integer> testYears = countYear.entrySet().stream().filter(map -> map.getValue().equals(maxNumberOFTimes))
				.map(map -> map.getKey()).collect(Collectors.toList());

		System.out.println("\nThe actor with the maximum number of movies played in is " + ActorNameMaxMovie.getKey()
				+ " who played in " + ActorNameMaxMovie.getValue() + " movies. \n");

		testYears.forEach(a -> System.out.print(a + " "));
		System.out.println("were his/her most productive years with " + maxNumberOFTimes + " movies in each. \n");

	}

}

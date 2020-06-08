
import acm.program.*;
import java.util.*;
import java.io.*;

public class FavoriteMovies extends ConsoleProgram {

	public void run() {
		// m is a HashMap with key = person name and value = ArrayList of movie names
		HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("favoriteMovies.txt"));
			// TODO:
			// 1. Read each line from the BufferedReader br.
			// 2. Split the line into person and movie.
			// 3. Check to see if the person exists in m.
			// 4. If not put the person with an empty ArrayList to m.
			// 5. Add the movie to the person's ArrayList.
			// Your code starts here
			while(true){
				String line=br.readLine();
				if(line==null) break;
				StringTokenizer st=new StringTokenizer(line);
				String person=st.nextToken();
				String movie=st.nextToken();
				ArrayList<String> list=m.get(person);
				if(list==null) {
					list=new ArrayList<String>();
					m.put(person, list);
				}
				list.add(movie);
			}
			// Your code ends here
			br.close();
		} catch (Exception e) {
			println(e);
		}
		println("favoriteMovies.txt loaded.");
		
		// TODO:
		// 1. Ask for a person name from the user.
		// 2. If the name is empty, break.
		// 3. Look the person up in HashMap m.
		// 4. If not found say so.
		// 5. Otherwise print the favorite movies of the person and repeat.
		// Your code starts here
		
		// Your code ends here
		println("bye.");
	}	
}
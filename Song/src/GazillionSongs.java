import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GazillionSongs {
    public static void main(String[] args){
        try {
            //Prompt user to enter a file
            System.out.println("This will filter and sort songs.");
            Scanner input = new Scanner(System.in);
            //Stores file in arraylist
            Scanner f = new Scanner(new File("agazillionsongs.txt"));
            //makes array of songs
            ArrayList<Song> list = new ArrayList<Song>();
            //songcollection object
            SongCollection songs = new SongCollection(list);
            //stores songs in arraylist
            while (f.hasNextLine()) {
                Song song = new Song();
                song.parse(f.nextLine());
                list.add(song); 
            }
            //Filters
            System.out.println("Choose a filter. Year, rank, artist, or title?");
            String userInput = input.nextLine();
            //filters By year
            if (userInput.equals("year")){
                System.out.println("Enter a year or range:");
                String year = input.nextLine();
                songs.filterYear(Range.parse(year));
                songs.print();
                //filters by rank   
            } else if(userInput.equals("rank")) {
                System.out.println("Enter a rank or range:");
                String rank = input.nextLine();
                songs.filterRank(Range.parse(rank));
                songs.print();
                //filters by artist 
            } else if(userInput.equals("artist")) {
                System.out.println("Enter an artist");
                String artist = input.nextLine();
                songs.filterArtist(artist);
                songs.print();
                //filters by title  
            } else if(userInput.equals("title")) {
                System.out.println("Enter a title");
                String title = input.nextLine();
                songs.filterTitle(title);
                songs.print();
            } else if(userInput.equals("year and rank")) {
                System.out.println("Enter a year and rank");
                String year = input.next();
                String and = input.next();
                String rank = input.next();
                songs.filterYear(Range.parse(year));
                songs.filterRank(Range.parse(rank));
                songs.print();
            } else if(userInput.equals("artist and title")) {
                System.out.println("Enter artist and title");
                String artist = input.next();
                String and = input.next();
                String title = input.next();
                songs.filterArtist(artist);
                songs.filterTitle(title);
                songs.print();
            } else if(userInput.equals("year and title")) {
                System.out.println("Enter year and title");
                String year = input.next();
                String and = input.next();
                String title = input.next();
                songs.filterYear(Range.parse(year));
                songs.filterTitle(title);
                songs.print();
            } else if(userInput.equals("year and artist")) {
                System.out.println("Enter year and artist");
                String year = input.next();
                String and = input.next();
                String artist = input.next();
                songs.filterYear(Range.parse(year));
                songs.filterArtist(artist);
                songs.print();
            }
            //sorting
            System.out.println("Sort by what?");
            String sortInput = input.next();
            if(sortInput.equals("year")) {
                songs.sortY();
                songs.print();
            } else if (sortInput.equals("rank")) {
                songs.sortR();
                songs.print();
            } else if (sortInput.equals("artist")) {
                songs.sortA();
                songs.print();
            } else if (sortInput.equals("title")) {
                songs.sortT();
                songs.print();
            }
            //file not found
        } catch (FileNotFoundException e) { 
            System.out.println("File not found"); 
        }
    }
}
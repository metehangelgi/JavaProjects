import java.util.StringTokenizer;

public class Song {
    //fields
    public int year;
    public int rank;
    public String artist;
    public String title;
    //constructor
    public Song(int y, int r, String a, String t) {
        year = y;
        rank = r;
        artist = a;
        title = t;
    }
    public Song() {
        // TODO Auto-generated constructor stub
    }
    //parsing
    public Song parse(String s){
        //tokenizer
        StringTokenizer parse = new StringTokenizer(s, "\t");
        //year
        String yr = parse.nextToken();
        year = Integer.parseInt(yr);
        //rank
        String rk = parse.nextToken();
        rank = Integer.parseInt(rk);
        //artist
        artist = parse.nextToken();
        //title
        title = parse.nextToken();
        //song object
        Song song = new Song(year, rank, artist, title);
        return song;
    }
    //getters
    public int getYear(){
        return year;
    }
    public int getRank(){
        return rank;
    }
    public String getArtist(){
        return artist;
    }
    public String getTitle(){
        return title;
    }
    //tostring method
    public String toString(){
        return String.format(year + " " + rank + " " + artist + " - " + title + "\n");
    }
}
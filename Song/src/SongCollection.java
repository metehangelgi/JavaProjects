import java.util.ArrayList;
import java.util.Collections;

public class SongCollection {
    //arraylist
    public ArrayList<Song> list;
    //constructor
    public SongCollection(ArrayList<Song> songs) {
        list = songs;
    }
    
    
    
    
    //filters by year
    public void filterYear(Range r) {
    	for(int i=list.size()-1 ;i>=0;i--) {
    		if(!r.contains(list.get(i).getYear())) {
    			list.remove(i);
    		}
    	}
    }
    
    //filters by rank
    public void filterRank(Range r) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!r.contains(list.get(i).getRank())) {
                list.remove(i);
            }
        }
    }
    //filters by artist
    public void filterArtist(String s) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get(i).getArtist().contains(s)) {
                list.remove(i);
            }
        }
    }
    //filters by title
    public void filterTitle(String s) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get(i).getTitle().contains(s)) {
                list.remove(i);
            }
        }
    }
    //sorts by year
    public void sortYear(Song[] song){
        int in, out;

        for (out = 1; out < song.length; out++) {
            Song temp = song[out];
            in = out;

            while (in > 0 && song[in - 1].getYear() > 0) {
                song[in] = song[in - 1];
                --in;
            }
            song[in] = temp;
        }
    }
    //sorts by rank
    public void sortRank(Song[] song) {
        //insertion sort
        int in, out;

        for (out = 1; out < song.length; out++) {
            Song temp = song[out];
            in = out;

            while (in > 0 && song[in - 1].getRank() > 0) {
                song[in] = song[in - 1];
                --in;
            }
            song[in] = temp;
        }
    }
    //sorts by artist
    public void sortArtist(Song[] song) {
        //insertion sort
        int in, out;

        for (out = 1; out < song.length; out++) {
            Song temp = song[out];
            in = out;

            while (in > 0 && song[in - 1].getArtist().compareTo(temp.getArtist()) > 0) {
                song[in] = song[in - 1];
                --in;
            }
            song[in] = temp;
        }
    }
    //sort by title
    public void sortTitle(Song[] song) {
        //insertion sort
        int in, out;

        for (out = 1; out < song.length; out++) {
            Song temp = song[out];
            in = out;

            while (in > 0 && song[in - 1].getTitle().compareTo(temp.getTitle()) > 0) {
                song[in] = song[in - 1];
                --in;
            }
            song[in] = temp;
        }
    }
    // prints the songs
    public void print() {
        for (int i = 0; i < list.size(); i++) {
            Song song = list.get(i);
            System.out.print(song.toString());
        }
    }
    public void sortY() {
        Song[] arr = list.toArray(new Song[list.size()]);
        sortYear(arr);
    }
    public void sortR() {
        Song[] arr = list.toArray(new Song[list.size()]);
        sortRank(arr);
    }
    public void sortA() {
        Song[] arr = list.toArray(new Song[list.size()]);
        sortArtist(arr);
    }
    public void sortT() {
        Song[] arr = list.toArray(new Song[list.size()]);
        sortTitle(arr);
    }
}
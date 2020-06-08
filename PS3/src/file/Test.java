package file;

import java.util.ArrayList;

public class Test {

	
	

	public static void main(String[] args) {
		ExecutableFile chrome=new ExecutableFile("chrome.exe",824000,true,"Mac on Intel");
		HTMLFile aboutme=new HTMLFile( "aboutme.html",5000,"Unicode encoding",5,chrome,null);
		HTMLFile publications=new HTMLFile( "publications.html",5000,"Unicode encoding",5,chrome,null);
		
		ArrayList<HTMLFile> myPageLinks = new ArrayList<HTMLFile>();
		myPageLinks.add(aboutme);
		myPageLinks.add(publications);
		
		
		HTMLFile myWebpage=new HTMLFile( "mywebpage.html",5000,"Unicode encoding",5,chrome,myPageLinks);
		
		File todos = new PlainTextFile("my todos", 3000, "ASCII",
		new String[]{"Do homework1", "Read the new paper", "Do homework2", "Go to gym"});
		
		ExecutableFile player = new ExecutableFile("vmplayer.exe", 160000, false, "Windows on Intel");
		
		File music = new DataFile("Walking On Air.mp3", 350000, true, "mp3", player);
		File movie = new DataFile("Up.mkv", 150000, false, "mkv", player);
		
		File[] files = new File[] {chrome, myWebpage, todos, player, music, movie};

		System.out.println("Calling toString methods:");
		for(File f: files) {
            System.out.println(f.toString());
        }
        
        System.out.println("Calling polymorphic methods:");
		File.callPolymorphicMethods(files);
		
		
		
	}

}

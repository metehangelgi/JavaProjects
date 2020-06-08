package bonus;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchFile {

	
	public static void main(String[] args) {
//		searchFile("Downloads/SS9_Solutions/");
	}
	
	public static String searchFile(String directory, String filename) {
		try {
			Path path =Paths.get(directory);
			if(path!=null) return find(path,filename).toAbsolutePath().toString();
			return null;
		} catch(IOException e) {
			return null;
		}
		
	}
	
	
	private static Path find(Path path, String filename) throws IOException{
		Path result=null;
		if(Files.isDirectory(path)) {
			DirectoryStream<Path> directoryStream=Files.newDirectoryStream(path);
			
			for(Path p:directoryStream) {
				result=find(p,filename);
				if(result!=null) break;
			}
			
			
		} else {
			if(path.getFileName().toString().equals(filename)) {
				result=path;
			}
			
		}
		return result;
	}
}

package reading;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class text {

	
	
	
	
	public static void main(String[] args) throws IOException {
		
		Path path= Paths.get("/Users/metehangelgi/eclipse-workspace/reading/metehan.txt");
		Path p=Paths.get(".");
		System.out.println(p.toAbsolutePath());
		System.out.println(p.isAbsolute());
			System.out.println(p.getRoot());
			System.out.println(p.startsWith("."));
			System.out.println(p.getParent());
		System.out.println(p.resolve(path));
		System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
		
		
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(0));
		
		Write write =new Write();
		ReadFile read= new ReadFile();
		
		write.Open();
		
		
		
		ArrayList<String> list= new ArrayList<String>();
		list.add("metehan ");
		list.add("gelgi ");
		list.add("9");
		list.add("ahmet ");
		list.add("kac ");
		list.add("10");
		
		
		
		Iterator iter= list.iterator();
		
		while(iter.hasNext()) {
			String name=(String) iter.next();
			String surname=(String) iter.next();
			String Age=(String) iter.next();
			int age=Integer.parseInt(Age);
			write.write(name,surname,age);
			
		}
		
		write.Close();
		
		read.openFile();
		read.Read();
		read.close();
		
		
		
		
		
	}

}

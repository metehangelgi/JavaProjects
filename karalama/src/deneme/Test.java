package deneme;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		
		String name="[a-z]*";
		String surname="[A-Z]{1}[a-z]*";
		String age="\\d{2}";
		String gradeandPoint="[0-9] {3}";
		
		Pattern namePat=Pattern.compile(name);
		Pattern surnamePat=Pattern.compile(surname);
		Pattern agePat=Pattern.compile(age);
		Pattern gradeandPointPat=Pattern.compile(gradeandPoint);
		
		
		Student empty=new Student();
		Student pol=new SecondYearSt();
		Student pol2=new FirstYearSt();
		Student pol3=new SecondYearSt("ahmet", "Mehmet", 19, 100);
		Student pol4=new FirstYearSt("mete", "Gelgi", 20, 530);
		
		
		Student mete[]=new Student[10];
		List<Student> newList=new ArrayList<Student>();
		List<Student> copylist=new ArrayList<Student>(Arrays.asList(mete));
		newList.add(empty);
		newList.add(pol);
		newList.add(pol2);
		newList.add(pol3);
		newList.add(pol4);
		newList.add(pol);
		newList.add(pol3);
		
		
		
		System.out.printf("%d \n",newList.size());
		
		
		List<Student> sonListe=new ArrayList<Student>();
		Set<Student> newSet=new HashSet<Student>();
		Set<Student> newTree=new TreeSet<Student>();
		
		
		newSet.addAll(newList);
		
		
		
		//newTree.addAll(newSet);
		
		
		try(Formatter format=new Formatter("./src/mete");
				Scanner scan =new Scanner(Paths.get("./src/mete"))) {
			
			
			for (Student student : newSet) {
				format.format("%s",student);
				format.format("\n");
			}
			
			newSet=newSet.stream().filter(student -> student.age>10 ).collect(Collectors.toSet());
			format.format("\n \n");
			for (Student student : newSet) {
				format.format("%s",student);
				format.format("\n");
			}
			
			
			
			
			
			
			
			
			while(scan.hasNextLine()) {
				String name1 = null;
				String surname1 = null;
				int age1 = 0;
				int point1 = 0;
				int grade1 = 0;
				int temp=0;
				scan.nextLine();
				
				String studentnew=scan.nextLine();
				System.out.println(studentnew);
				Matcher nameMatch=namePat.matcher(studentnew);
				Matcher surnameMatch=surnamePat.matcher(studentnew);
				Matcher ageMatch=agePat.matcher(studentnew);
				Matcher gradeandPointMatch=gradeandPointPat.matcher(studentnew);
				
				if(nameMatch.find()) name1=nameMatch.group();
				if(surnameMatch.find())  surname1=surnameMatch.group();
				if(ageMatch.find()) age1=Integer.parseInt(ageMatch.group());
				if(gradeandPointMatch.find()) {
					temp=Integer.parseInt(gradeandPointMatch.group());
					if(temp==100) grade1=temp;
					else point1=temp;	
				}
				if(grade1==0 && point1 ==0) {
					Student tempStudent=new Student(name1,surname1,age1);
					sonListe.add(tempStudent);
				} else if(grade1 !=0) {
					Student tempStudent=new SecondYearSt(name1,surname1,age1,grade1);
					sonListe.add(tempStudent);
				} else {
					Student tempStudent=new FirstYearSt(name1,surname1,age1,point1);
					sonListe.add(tempStudent);
				}
				
			}
			
			System.out.println(sonListe);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}

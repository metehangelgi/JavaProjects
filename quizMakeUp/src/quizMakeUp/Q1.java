package quizMakeUp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class Q1 {

	static String FileName="mete";
	
	public static void main(String[] args) {
		
		
		List<String> preList=new ArrayList<String>();
		
		preList=readFile(FileName);
		System.out.println("\n first list: ");
		System.out.println(preList);
		preList=replaceSpecialWords(preList);
		System.out.println(" \n after replaced Words:");
		System.out.println(preList);
		jarJarBinks(preList);
		writeFile("output",preList);
		
	}

	private static List<String> readFile(String fileName2) {
		String line;
		
		List<String> tempList=new ArrayList<String>();
		
		
		
		try(Scanner input=new Scanner(Paths.get("./src/mete"))) {
			while(input.hasNextLine()) {
				line=input.nextLine();
				tempList.add(line);
			}
			
			
		} catch(IOException e){
			System.out.println("exception is catched");
		}
		return tempList;
	}
	
	
	private static List<String> replaceSpecialWords(List<String> lines){
		
		for (String line : lines) {
			line=line.replaceAll("[a-z]{1,}\\d{1}[a-z]{1,}", "SW");
		}
		return lines;
		
	}
	private static void jarJarBinks(List<String> replacedLines) {
		
		List<String> temp = new ArrayList<>();
		char firstChar;
		String tempWord=null;
		
		/*
		for (String line : replacedLines) {
			String[] words=line.split(" ");
			line=null;
			for(int i=0;i<words.length;i++) {
				if(words[i].length()==1) {
					words[i]=words[i]+"ay";
				} else {
					firstChar=words[i].charAt(0);
					tempWord=words[i].substring(1);
					tempWord=tempWord+firstChar+"ay";
					words[i]=tempWord;
				}
				
				line+=words[i]+" ";
				System.out.println(line);
			}
			
			temp.add(line);
			
			
		}*/
		//
		//replacedLines=temp;
		//System.out.println("\n finally:");
		//System.out.println(replacedLines);
		
		
	}
	
	
	private static void writeFile(String outputName,List<String> jarjarBinksLines) {
		
		try(Formatter format =new Formatter("./src/"+outputName)){
			for (String string : jarjarBinksLines) {
				format.format("%s", string);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

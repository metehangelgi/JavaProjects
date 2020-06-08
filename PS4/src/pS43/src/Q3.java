

import java.util.Scanner;

public class Q3 {

	
	static int[] counter;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("please enter a text which you want to search");
		String text = scan.nextLine();

		System.out.println("please write which anagram word do you want");
		String anagram = scan.nextLine();

		compare(text, anagram);

	}

	public static void compare(String text, String anagram) {
		boolean test = true;
		counter = new int[text.length()];
		String counter2=null;

		char[] txt = text.toCharArray();
		char[] anagramChar = anagram.toCharArray();
		for (int c = 0; c < txt.length; c++) {
			
			int[] MAXtxt = new int[256000];
			int[] MAXanagram = new int[256000];
			for (int i = 0; i < anagramChar.length; i++) {
				MAXtxt[(int)txt[i + c]]++;
				MAXanagram[(int)anagramChar[i]]++;
			}
			for (int i = 0; i < MAXanagram.length; i++) {
				if (MAXtxt[i] != MAXanagram[i])
					test = false;

			}
			if (test) {
				counter2+=Integer.toString(c);
			}

		}
		System.out.println(counter2);
	}

}

/*File: StarTree.java*/

import acm.program.ConsoleProgram;

public class StarTree extends ConsoleProgram{
	public void run() {
	//TODO you should fill this in
		println("This program prints a tree fro stars with user provided height. ");
		
		int level= readInt("Enter the height of the tree: ");
		
		println();
		for(int i=0; i<level;i++) {
			for(int n=0;n<2*level;n++) {
				
				if(level-i ==n || level+i==n) print("*");
				else print(" ");
				
			}
			
			
			println();
		}
		
	}
}

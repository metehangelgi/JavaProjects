package com.home.simplexmethod;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class SimplexMethodParser {
	private ArrayList<Integer> arrayZ = new ArrayList<Integer>();
	private ArrayList<String> arrayConstraints = new ArrayList<String>();
	private ArrayList<Integer> arrayConstraintsTails = new ArrayList<Integer>();
	public void clear() {
		this.arrayZ.clear();
		this.arrayConstraints.clear();
		this.arrayConstraintsTails.clear();
	}
	public boolean isNumber(char ch) {
		if(ch == '1' || ch == '2'  || ch == '3' || ch == '4' || ch == '5' || ch == '6' || 
				ch == '7' || ch == '7' || ch == '8' || ch == '9' || ch == '0' || ch == '.')
			return true;
		return false;
	}
	public int getIntegerBeforeX(String eq, int position) {
		int startPosition = 0;
		if(position==0) {
				return 1;
		}
		if(position ==3) {
			if(eq.charAt(position-1) == ')') return -1;
		}
		for(int i=position-1;i>=0;i--) {
			if(!isNumber(eq.charAt(i)))
			{
				if(i+1 == position) 
				{
					if(eq.charAt(position-1) == ')')
						return -1;
					else
						return 1;
				}
				else
					startPosition = i+1;
				break;
			}
		}
		String num = eq.substring(startPosition, position);
		int n = Integer.parseInt(num);
		if(eq.charAt(startPosition-1) == ')') n*=-1;
		return n;
	}
	public int getIntegerAfterX(String eq, int position) {
		int endPosition = eq.length();
		for(int i=position+1;i<eq.length();i++) {
			if(!isNumber(eq.charAt(i)))
			{
				endPosition = i;
				break;
			}
		}
		String num = eq.substring(position+1, endPosition);
		int n = Integer.parseInt(num);
		return n;
	}
	public void parseZ(String eq) {
		for(int i=0;i<eq.length();i++) {
			if(eq.charAt(i) == 'x')
			{
				System.out.println("Found x at: "+i);
				int k = this.getIntegerBeforeX(eq, i);
				int kk = this.getIntegerAfterX(eq, i);
				System.out.println("Number before x: "+k+", after x: "+kk);
				arrayZ.add(k);
			}
		}
	}
	public void parseConstraint(String eq) {
		System.out.println("Parse Constraints Enter");
		int index = 0;
		String str = "";
		for(int i=0;i<eq.length();i++) {
			if(eq.charAt(i) == 'x')
			{
				System.out.println("Found x at: "+i);
				int k = this.getIntegerBeforeX(eq, i);
				int kk = this.getIntegerAfterX(eq, i);
				System.out.println("Number before x: "+k+", after x: "+kk);
				if(kk-index>1) {
					for(int j=index+1;j<kk;j++) {
						str = str.concat("0,");
					}
				}
				str = str.concat(String.valueOf(k)+",");
				index=kk;
			}
		}
		System.out.println(str);
		System.out.println("After sign: "+this.getNumberAfterGreaterSign(eq));
		arrayConstraints.add(str);
		arrayConstraintsTails.add(this.getNumberAfterGreaterSign(eq));
	}
	public int getNumberAfterGreaterSign(String eq) {
		int k = eq.indexOf("<=");
		int kk = this.getIntegerAfterX(eq, k+1);
		return kk;
	}
	public void writeToFile() {
		try{
			FileOutputStream writer = new FileOutputStream("/Users/metehangelgi/Desktop/sophomoresecond/indr262/BonusProject/text.txt");
			writer.write((new String()).getBytes());
			writer.close();
			FileWriter fstream = new FileWriter("/Users/metehangelgi/Desktop/sophomoresecond/indr262/BonusProject/text.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(new String());
			int k = arrayConstraints.size();
			out.write(k+1+" ");
			k = arrayZ.size();
			out.write(k+1+"\n");
			out.write("0 ");
			for(int i=0;i<arrayZ.size();i++) {
				out.write("-"+String.valueOf(arrayZ.get(i))+" ");
			}
			out.write("\n");
			String[] nums;
			for(int i=0;i<arrayConstraints.size();i++) {
				nums = arrayConstraints.get(i).split(",");
				out.write(arrayConstraintsTails.get(i)+" ");
				for(int j=0;j<nums.length;j++)
				{
					out.write(nums[j]+" ");
				}
				out.write("\n");
			}
			out.close();
			} catch (Exception e){
				System.err.println("Error: " + e.getMessage());
			}
	}
}

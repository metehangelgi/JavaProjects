/*
 * File: Quadratic.java
 * --------------------
 * This program is a stub for the Quadratic problem, which finds the
 * roots of the quadratic equation.
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("tihs code helps you to calculate your functions roots ax^2+bx+c=0 ");
		double a =readInt("Please enter a(Which is not Zero): ");
		double b =readInt("Please Enter b(Which is not Zero): ");
		double c =readInt("Please enter c(Which is not Zero): ");
		
		while (a==0 || b==0 || c== 0) {
			println("error");
			double a1 =readInt("Please enter a(Which is not Zero): ");
			double b1=readInt("Please Enter b(Which is not Zero): ");
			double c1 =readInt("Please enter c(Which is not Zero): ");
			
			
			a=a1;
			b=b1;
			c=c1;
		}
		
		

		 

			 
				 
				 if(findx(a,b,c)<0) {
					 println("there is no real Roots");
				 }
				 else {
					if  (findz1(a,b,c)==findz2(a,b,c)) {
						println("There is 2 real roots which is same "+findz1(a,b,c));
					} else {
						println("there is 2 real roots"+ findz1(a,b,c) + findz2(a,b,c));
					}
					}
				 

		// Your code ends here
	}

	public double rootsqr(double a,double b,double c) {
		
		double x=0;
		double j;
		 x=b*b-4*a*c;
		 j= Math.sqrt(x);
		 return j;
	}
	public double findx(double a,double b,double c) {
		
		double x=0;
		x=b*b-4*a*c;
		return x;
	}
	private double findz1(double a,double b,double c){
		double z1=0;
		double x;
		double j;
		x=b*b-4*a*c;
		j=rootsqr(a,b,c);
		z1=(-b+j)/2*a;
		return z1;
	}
	private double findz2(double a,double b,double c){
		double z2=0;
		double x=0;
		double j;
		j=rootsqr(a,b,c);
		z2=(-b-j)/2*a;
		return z2;
	}

}


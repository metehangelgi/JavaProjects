
/* STUDENT NAME:
 * File: KUisine.java
 */
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class KUisine extends ConsoleProgram {

	public void run() {
		// Your code starts here.
		for (int n=1;n<=CONTESTANT_NUM;n++) {
			println("NEW CONTESTANT");
			double ability=askAbility(n);
			int knowledge= askKnowledge(n);
			int special=askSpecialDish(n);
			boolean hasBook =hasBook();
			int point =pointCalculator(ability,knowledge,special,hasBook);
			
			
			/*
			 * I used this part to check my calculations true or not for every step
			 * println(" KuChef#"+n+" ability Point: "+ability+" Knowledge: "
					+knowledge+" Special: "+special+" Has a book probability: "+ hasBook+point);
			 */
			
			
			
						assignPoint(point);
						println("-----------------------------------------");
						currentChefID++;
						
						
		}
		
		comparator();
		println(" ");
		match();
		
		

		
		// Your code ends here.

	}

	// Required Methods of Part 1

	//Knife skill has to be between 2-6
	//Cooking Skill has to be between 5-15
	//gets cs and ks points and calculates them
	private double askAbility(int n) {
		
		// Your code starts here.
		double ability=0;
		
			int ks=readInt("Knife skil of KuChef#"+n+": ");
			while(ks<2 || ks>6) {
				println("please Change Your Chef, you can not join");
				ks=readInt("Knife skil of KuChef#"+n+": ");
			}
			int cs=readInt("Cooking skill of KuChef#"+n+": ");
			while(cs<5 || cs>15) {
				println("please Change Your Chef, you can not join");
				cs=readInt("Cooking skill of KuChef#"+n+": ");
			}
			ability = calculateAbility(ks,cs);
			
		
		
		return ability;
		// Your code ends here.
	}
	
	private double calculateAbility(int ks, int cs) {
		// Your code starts here.
		double abilityPoint;
		double division;
		division = (ks +cs)/10.0;
		double power = Math.pow(division,ks);
		abilityPoint=power+fibonacci(cs);
		return abilityPoint;
		// Your code ends here.
	}
	
	private int fibonacci(int n) { 
		 
        int t1 = 0, t2 = 1;
        int sum=0;
        for(int i=0;i<n;i++) {
        	 sum = t1 + t2;
             t1 = t2;
             t2 = sum;
        }
       
        
        return t1;
}
	//Education has to be between 2-4
	//gets e and c points and calculates them
	private int askKnowledge(int n) {
		// Your code starts here.
		int point=0;
		
		int e=readInt("Years of Education of KuChef#"+n+": ");
		while(e<2 || e>4) {
			println("please Change Your Chef, you can not join");
			e=readInt("Years of Education of KuChef#"+n+": ");
		}
		int c=readInt("Number of Cuisine of KuChef#"+n+": ");
		
		while(c<5 || c>15) {
			println("please Change Your Chef, you can not join");
			c=readInt("Number of Cuisine of KuChef#"+n+": ");
		}
		point = calculateKnowledge(e,c);
		
	
	
	return point;
		// Your code ends here.
	}
	//Cuisine has to between 5-10
	private int calculateKnowledge(int e, int c) {
		// Your code starts here.
		int knowledgePoint = c * factorial(e);
		
		return knowledgePoint;
		// Your code ends here.
	}
	// this part calculates factorial of e.
	private int factorial(int e) {
		int result=1;
		for(int i=2; i<=e;i++) {
			result *= i;
			
		}
		return result;
	}
	// Special dish has to be between 1-5
	private int askSpecialDish(int n) {
		// Your code starts here.
		int special=readInt("Number of KuChef# "+n+" Special's : ");
		while(special<1 || special>5) {
			println("please Change Your Chef, you can not join");
			special=readInt("Number of KuChef# "+n+" Special's : ");
		}
		return special;
		// Your code ends here.
	}

	private boolean hasBook() {
		// Your code starts here.
		boolean hasBook= rgen.nextBoolean();
		return hasBook;
		// Your code ends here.
	}
	

	
	private int pointCalculator(double ability, int knowledge, int special, boolean hasBook) {
		// Your code starts here.
		int totalPoint=0;
		double totalPointDouble=0;
		double multiplication =ability*special;
		double sqrt= Math.sqrt(multiplication);
		if(hasBook==true) {
			totalPointDouble=sqrt+(1.5*knowledge);
		} else {
			totalPointDouble=sqrt+(1.0*knowledge);
		}
		
		totalPoint=roundtoClosestInt(totalPointDouble);
		return totalPoint;
		// Your code ends here.
	}
	//in this method I rounded double to int(if it's double part>0.5 it rounded to next integer otherwise to the previous integer)
	private int roundtoClosestInt(double n) {
		double exstraPart=0;
		int roundedNumber=0;
		exstraPart=n-(int)n;
		
		if(exstraPart>=0.5) {
			roundedNumber=(int)n+1;
		} else {
			roundedNumber=(int)n;
		}
		
		return roundedNumber;
	}

	//I have just matched points and their chefs. 
	//to make easier print. I wrote println in this method
	private void assignPoint(int p) {
		// Your code starts here.
		int n=currentChefID;
		
		
		
		
		if(currentChefID==1) {
			totalPointOfKUchef1 =p;
			println("kuChef#"+n+" has reached: "+p+"points");
		} 

		else if(currentChefID==2) {
			totalPointOfKUchef2=p;
			println("kuChef#"+n+" has reached: "+p+"points");
		} 

		else if(currentChefID==3) {
			totalPointOfKUchef3=p;
			println("kuChef#"+n+" has reached: "+p+"points");
		} 

		else  {
			totalPointOfKUchef4=p;
			println("kuChef#"+n+" has reached: "+p+"points");
		} 
		
		
		
		// Your code ends here.
	}
	//this method works in three different parts to determine #1Chef , #2Chef ,#3Chef
	//I calculated sum of these points. Then "for" statement coming down from sum to the max point(who becomes #1)
	//then counter will be increased. This situation affects first "for" statement. and it will be over
	//second and third statements work in the same rule. But They start from previous Chef's point instead of sum(to do not take #1chef again) 
	
	private void comparator() {
		// Your code starts here.
		int count=0;
		int sum=totalPointOfKUchef1+totalPointOfKUchef2+totalPointOfKUchef3+totalPointOfKUchef4;
		
		for(int i=sum;count<1;i--){
			if(totalPointOfKUchef1==i){
				firstID=1;
				firstPoint=totalPointOfKUchef1;
				count++;
			}
			if(totalPointOfKUchef2==i){
				firstID=2;
				firstPoint=totalPointOfKUchef2;
				count++;
			}
			if(totalPointOfKUchef3==i){
				firstID=3;
				firstPoint=totalPointOfKUchef3;
				count++;
			}
			if(totalPointOfKUchef4==i){
				firstID=4;
				firstPoint=totalPointOfKUchef4;
				count++;
				}
			}
		for(int i=firstPoint-1;count<2;i--){
			if(totalPointOfKUchef1==i){
				secondID=1;
				secondPoint=totalPointOfKUchef1;
				count++;
			}
			if(totalPointOfKUchef2==i){
				secondID=2;
				secondPoint=totalPointOfKUchef2;
				count++;
			}
			if(totalPointOfKUchef3==i){
				secondID=3;
				secondPoint=totalPointOfKUchef3;
				count++;
			}
			if(totalPointOfKUchef4==i){
				secondID=4;
				secondPoint=totalPointOfKUchef4;
				count++;
				}
			}
		for(int i=secondPoint-1;count<3;i--){
				if(totalPointOfKUchef1==i){
					thirdID=1;
					thirdPoint=totalPointOfKUchef1;
					count++;
				}
				if(totalPointOfKUchef2==i){
					thirdID=2;
					thirdPoint=totalPointOfKUchef2;
					count++;
				}
				if(totalPointOfKUchef3==i){
					thirdID=3;
					thirdPoint=totalPointOfKUchef3;
					count++;
				}
				if(totalPointOfKUchef4==i){
					thirdID=4;
					thirdPoint=totalPointOfKUchef4;
				count++;
					}
				}
		
		println("KuChe#"+firstID+" becomes #1 with "+firstPoint+"points");
		println("KuChe#"+secondID+" becomes #2 with "+secondPoint+"points");
		println("KuChe#"+thirdID+" becomes #3 with "+thirdPoint+"points");
		
		
		// Your code ends here.
	}
	// Implement your own methods here
	// Your code starts here.
	private void match() {
		
		
		int numberOfGlory1=0;
		int numberOfGlory2=0;
		int numberOfGlory3=0;
		int winner=0;
		int preWinner=0;
		int preWinnerPoint=0;
	
		//matches 10000 times
		/* in every game would be in 6 part 1-2;2-3;1-3;1-2;2-3;1-3. But Generally in first three matches will determine the winner of the first tour(1/10.000)
		*That's why I used 3 part which is checked by another method(checkGlory) after every single game.
		*Assume that we couldn't determine the winner of tour because everyone got same count game(1-1-1). to solve it I used  
		*while(if we can not determine in first time. we can play more games with preserving old counters.) 
		*(not necessary note :) )Actually we will have 4 match at most (1+1+1)+1 any of one will be two.
		 */
		
		
		for(int i=0;i<10000;i++) {
			
			int count1=0;
			int count2=0;
			int count3=0;
			boolean checkGlory=true;
			while(checkGlory) {
				
				int a =rgen.nextInt(firstPoint+secondPoint);
				
				if(a<=firstPoint) {
					count1++;
				} else {
					count2++;
				}
				checkGlory=check(count1,count2,count3);
				
				int b =rgen.nextInt(secondPoint+thirdPoint);
				
				if(b<=secondPoint) {
					count2++;
				} else {
					count3++;
				}
				checkGlory=check(count1,count2,count3);
				int c =rgen.nextInt(thirdPoint+firstPoint);
				
				if(c<=thirdPoint) {
					count3++;
				} else {
					count1++;
				}
				checkGlory=check(count1,count2,count3);
			}
			
			if(count1==2) {
				numberOfGlory1++;
			} 
			else if(count2==2) { 
				numberOfGlory2++;
			}
			else {
				numberOfGlory3++;
			}

		}
				
				
				
				
								
		
		/*if there will be equality between GloryNumbers which is almost not possible , by this statement we can match one more 
		* game between these  equal chefs. Then winner will be determined.
		*/
		if(numberOfGlory1==numberOfGlory2 || numberOfGlory1==numberOfGlory3 || numberOfGlory2==numberOfGlory3) {
			if (numberOfGlory1==numberOfGlory2 ) {
					int a =rgen.nextInt(firstPoint+secondPoint);
				
				if(a<=firstPoint) {
					numberOfGlory1++;
				} else {
					numberOfGlory2++;
				}
			}
			if (numberOfGlory2==numberOfGlory3 ) {
				int b =rgen.nextInt(firstPoint+secondPoint);
			
			if(b<=secondPoint) {
				numberOfGlory2++;
			} else {
				numberOfGlory3++;
			}
		}
			if (numberOfGlory3==numberOfGlory1 ) {
				int c =rgen.nextInt(firstPoint+secondPoint);
			
			if(c<=thirdPoint) {
				numberOfGlory3++;
			} else {
				numberOfGlory1++;
			}
		}
			if(numberOfGlory1<numberOfGlory2) {
				preWinner= secondID;
				preWinnerPoint=numberOfGlory2;
			} else{
				preWinner=firstID;
				preWinnerPoint=numberOfGlory1;
			}
			if(preWinnerPoint<numberOfGlory3) {
				winner=thirdID;
			} else {
				winner=preWinner;
			}
			println("The is now Completed and the scores are as below");
			println(" ");
		//
		//I did this part two times because in this part we will have 10.001 matches. But if there is not equality we will have 10.000 matches
		//
			println("KuChef#"+firstID+": "+" won "+numberOfGlory1+"times in "+NTIMES+1+" games");
			println("KuChef#"+secondID+": "+" won "+numberOfGlory2+"times in "+NTIMES+1+" games");
			println("KuChef#"+thirdID+": "+" won "+numberOfGlory3+"times in "+NTIMES+1+" games");
			println(" ");
			println("CONGRATULATIONS KuChef#"+winner+" YOU ARE THE WINNER OF KUISINE");	
			
			
		}	
		//if there not equality my code will continue to here to determine winner.
		else {
			if(numberOfGlory1<numberOfGlory2) {
				preWinner= secondID;
				preWinnerPoint=numberOfGlory2;
			} else{
				preWinner=firstID;
				preWinnerPoint=numberOfGlory1;
			}
			if(preWinnerPoint<numberOfGlory3) {
				winner=thirdID;
			} else {
				winner=preWinner;
			}
			println("The is now Completed and the scores are as below");
			println(" ");
			
			println("KuChef#"+firstID+": "+" won "+numberOfGlory1+"times in "+NTIMES+" games");
			println("KuChef#"+secondID+": "+" won "+numberOfGlory2+"times in "+NTIMES+" games");
			println("KuChef#"+thirdID+": "+" won "+numberOfGlory3+"times in "+NTIMES+" games");
			println(" ");
			println("CONGRATULATIONS KuChef#"+winner+" YOU ARE THE WINNER OF KUISINE");	
			
			
		}
			
			
			
		
		
		}
	// this part helps to the match part. Because I used this method, we have to check that counters are equal to the 2 or not in every step.
	private boolean check(int count1 ,int count2 ,int count3) {
		boolean result = true;
		// Your code starts here
		if (count1==2 ||count2==2 ||count3==2) {
			result=false;
		}
		
		// Your code ends here
		return result;
	}
	
	
// Your code ends here.

int currentChefID = 1;

int totalPointOfKUchef1;
int totalPointOfKUchef2;
int totalPointOfKUchef3;
int totalPointOfKUchef4;

int firstID;
int secondID;
int thirdID;

int firstPoint;
int secondPoint;
int thirdPoint;

private final int CONTESTANT_NUM = 4;
private final int NTIMES = 10000;
static RandomGenerator rgen = new RandomGenerator();
}
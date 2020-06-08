
/*
 * File: PrimeNumer.java
 * ---------------------
 * This program displays the first 50 prime numbers
 */

import acm.program.*;

public class PrimeNumber extends ConsoleProgram {

	public void run() {

		println("The first 50 prime numbers are ");

		int number = 2; 
		int count = 0;
		while (count < NUMBER_OF_PRIMES) {

			boolean isPrime = true; 

			// Test if number is prime
			// Your code starts here
			
			// Your code ends here

			// Print the prime number and increase the count
			if (isPrime) {
				count++; // Increase the count

				if (count % 10 == 0) {
					println(number);
				} else {
					print(number + " ");
				}
			}	
			number++;
		}
	}

	private static final int NUMBER_OF_PRIMES = 50;

}


/*
 public void run() {

		println("The first 50 prime numbers are ");
 		int number = 2; 
		int count = 0;
 		while (count<= NUMBER_OF_PRIMES){
 		boolean isPrime= true;
 		isPrime= isPrime(num);
 		for (int divisor =2 ;divisor <=num ;divisor++){
 	if (num % divisor==0){
 		answer =false;
 		break;
 		}
 		//print the prime number
 		 if(isPrime){
 		 print(num);
 		 count++;
 		 }
 		 num++
 		}
 
 private boolean boolean isPrime(int num){
 boolean answer =true;
 
 for (int divisor =2 ;divisor <=num ;divisor++){
 	if (num % divisor==0){
 		answer =false;
 		break;
 	}
 
 }
 return answer;
 }
  
 */

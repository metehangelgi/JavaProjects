/*
 * File: Account.java
 * ------------------------------
 * Creates an Account object with a balance. Enables user to deposit and withdraw money.
 * Finally prints current balance.
 */

public class Account {

    private int accountId;
    private double balance;


    public Account(int accountId, double balance){
	// Your code starts here
	this.accountId = accountId;
	this.balance=balance;
	
	// Your code ends here
    }

    public int getId(){
	// Your code starts here
	return accountId;
	// Your code ends here
    }

    public double getBalance(){
	// Your code starts here
	return balance;
	// Your code ends here
    }

    public void deposit(double amount){
	// Your code starts here
	balance+= amount;
	// Your code ends here
    }

    public boolean withdraw(double amount){
	// Your code starts here
	if(balance< amount) return false;
	else {
		balance -=amount;
		return true;
	}
	// Your code ends here
    }

    public String toString(){
	return "Account " + accountId + " has " + balance + " TL in the bank.";

    }
}

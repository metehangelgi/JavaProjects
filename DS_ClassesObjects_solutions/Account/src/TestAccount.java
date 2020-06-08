import java.util.HashMap;
import acm.program.ConsoleProgram;

/*
 * Test Program for Account Class
 */

public class TestAccount extends ConsoleProgram {

    private HashMap<Integer,Account> accounts;

    public void run() {
	/*get number of account from user*/
	int numOfAccounts = readInt("Enter number of Accounts: ");

	/*create Account array*/
	accounts = new HashMap<Integer,Account>();

	int accountId;
	double balance;

	for(int i = 0; i < numOfAccounts; i++){
	    /*get account id and check if it is unique*/
	    accountId = readInt("Type a unique account id: ");
	    while(accounts.containsKey(accountId)){
		accountId = readInt("Type a unique account id: ");
	    }

	    /*get balance and check if it is negative*/
	    balance = readDouble("Type a balance for account " + accountId + ": ");
	    while(balance < 0){
		balance = readDouble("Type a balance for account " + accountId + ": ");
	    }

	    accounts.put(accountId,new Account(accountId,balance));

	}

	int choice;
	/*ask account id and do what user wants to do with it*/
	while(true){
	    println("\nMenu:\n1 - Display all accounts.\n2 - Deposit money.\n3 - Withdraw money.\n0 - Exit.");
	    choice = readInt("Enter an option: ");
	    switch(choice){
	    case 1: displayAccounts();
		break;
	    case 2: depositMoney();
		break;
	    case 3: withdrawMoney();
		break;
	    default: System.exit(0);
	    }
	}

    }

    public void displayAccounts(){
	for(Integer key: accounts.keySet()){
	    println(accounts.get(key).toString());
	}
    }

    public void depositMoney(){
	int accountId = readInt("Enter account id to deposit: ");

	if(!accounts.containsKey(accountId)){
	    println("Account id " + accountId + " does not exist.");
	    return;
	}

	Account a1 = accounts.get(accountId);
	double amount = readDouble("Enter the amount to deposit: ");

	a1.deposit(amount);
	println("Deposit successfully completed.");
    }

    public void withdrawMoney(){
	int accountId = readInt("Enter account id to withdraw: ");
	if(!accounts.containsKey(accountId)){
	    println("Account id " + accountId + " does not exist!!");
	    return;
	}

	Account a1 = accounts.get(accountId);
	double amount = readDouble("Enter the amount to withdraw: ");
	if(a1.withdraw(amount))
	    println("Withdraw successfully completed.");
	else
	    println("Account " + accountId + " does not have enough balance. Withdraw canceled.");
    }
}

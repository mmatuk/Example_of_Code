//************************************************************************
//	Bank.java 							Matt Matuk
// 	CSIT 210								Project 7.6 pg 376
//	This class is the driver class for the SavingsAccount class. The 
//	class will create and add all the accounts to the array. This class
//	will also deposit or withdraw any money from the accounts. 
//*************************************************************************	
 

public class Bank
{
	//-----------------------------------------------------------------
	// This method supplies and creates the information for all the 
	// accounts in the SavingsAccount class.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		//double debug = 1.0;
		
		BankSavingsAccount savAcct = new BankSavingsAccount();
		
		savAcct.addAccount("Matt Matuk", 10254, 500.00);
		savAcct.addAccount("Bob Smith", 56483, 1000.59);
		savAcct.addAccount("John Lake", 68975, 56.35);
		savAcct.addAccount("Sindy Miller", 89763, 52.45);
		savAcct.addAccount("NoOne Knows", 30258, 48.29);
		savAcct.addAccount("Somebody Else", 00015, 78.63);
		System.out.print(savAcct);
		
		//------------------debug-------------
		//savAcct.setAcctNum(00015, 10254);
		//------------------------------------
		
		System.out.println("Adding interest to all accounts. 3%");
		savAcct.addInterest();
		System.out.print(savAcct);
		
		System.out.println("Deposit of $500,000 to acct #10254");
		savAcct.deposit(10254, 500000.00);
		System.out.print(savAcct);

		System.out.println("Withdraw of $50 from acct #68975");
		savAcct.withdraw(68975,  50.00);
		System.out.print(savAcct);

		// Tries to deposit money into an account that does not exist
		System.out.println("Deposit of 50,000.11 to acct #00000");
		savAcct.deposit(00000,  50000.11);
		System.out.print(savAcct);
		
		//  Changes an account name
		System.out.println("Change account 68975 name to John Appleseed");
		savAcct.setAcctName(68975, "John Appleseed");
		System.out.print(savAcct);
		
		// tries to withdraw money from an account that does not exist
		System.out.println("Withdraw of 500.00 from acct #30258");
		savAcct.withdraw(30258, 500.00);
		//--------------------Debug---------------------------
		//savAcct.addAccount("Matt Matuk", 12345, 500.00);
		//debug = savAcct.deposite(12345, 400);
		//System.out.print(debug);
		//----------------------------------------------------
		System.out.println(savAcct);
	}
}
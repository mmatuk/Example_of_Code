//************************************************************************
//	BankSavingsAccount.java 							Matt Matuk
// 	CSIT 210								Project 7.6 pg 376
//	This class creates the array that will hold the savings account 
//	classes. The account will have methods to withdraw and deposit 
//	money into the individual accounts. This class will also add interest
//	too all the accounts when the addInterest method is called. 
//*************************************************************************	

import java.text.NumberFormat;

public class BankSavingsAccount
{
	protected SavingsAccount[] accounts;
	protected int numOfAcct;
	protected double totalAmount;
	protected double rate;
	protected double fee;
	
	//-----------------------------------------------------------------
	// creates an array of all the savings accounts and sets the 
	// variables
	//-----------------------------------------------------------------
	public BankSavingsAccount()
	{
		accounts = new SavingsAccount[30];
		numOfAcct = 0;
		totalAmount = 0.0;
		rate = .03;
		fee = 1.5;
	}
	
	//-----------------------------------------------------------------
	// Adds a SavingsAccount instance to the accounts array 
	//-----------------------------------------------------------------
	public void addAccount(String name, long num, double amount)
	{
		if (numOfAcct == accounts.length)
		{
			increaseSize();
		}
		
		boolean error = false;
		
		for (int count = 0; count < accounts.length; count++)
		{
			
			try
			{
				// error message if account already exists 
				if ((name.equalsIgnoreCase(accounts[count].getAcctName())) 
						|| (num == accounts[count].getAcctNum()))
				{
					System.out.println("Invalid Account. The account already "
							+"exists.");
					error = true;
				}
			} catch (Exception exception)
			{
				// catches the exception when the accounts[count] index
				// is empty
			}
		}
		
		
		if (error == false)
		{
			accounts[numOfAcct] = new SavingsAccount(name, num, amount);
			numOfAcct++;
		}
	}
	
	//-----------------------------------------------------------------
	// This method deposits money into an account with the number 
	// acctNum and displays a error message of no account can be 
	// found wiht that number
	//-----------------------------------------------------------------
	public double deposit(long acctNum, double amount)
	{
		boolean found = false;
		double tempBal = 0;
		
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				if (acctNum == accounts[count].getAcctNum())
				{
					tempBal = accounts[count].deposit(amount);
					found = true;
				}
				//-----------debug------------
				//System.out.println(count + "\t");
				//----------------------------
			}
			catch (Exception exception)
			{
				// If accounts[count] index is empty, then the 
				// the exception is caught.
			}
			
		}
		
		if (found == false)
		{
			// No acct found with the acctNum provided
			System.out.println("Invalid Account Number. No account found "
				+"with "+ acctNum +" as the account number.");
		}
		
		return tempBal;
	}
	
	//-----------------------------------------------------------------
	// This method withdraws money from the account with the number 
	// acctNum and displays an error message if not account exists
	// with that number. 
	//-----------------------------------------------------------------
	public double withdraw(long acctNum, double amount)
	{
		boolean found = false;
		double tempBal = 0;
		
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				if (acctNum == accounts[count].getAcctNum())
				{
					tempBal = accounts[count].withdraw(amount, fee);
					found = true;
				}
			} catch (Exception exception)
			{
				// Catches the exception thrown when the accounts[index]
				// is empty
			}
		}
		
		if (found == false)
		{
			System.out.println("No account with the number "+ acctNum 
					+" was found. No withdraw possible.");
		}
		
		return tempBal;
	}
	
	//-----------------------------------------------------------------
	// Adds all the balances from all active accounts a return the value
	//-----------------------------------------------------------------
	public double getTotalAmount()
	{
		totalAmount = 0.0;
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				totalAmount = totalAmount
						+ accounts[count].getAcctBalance();
			} catch (Exception exception)
			{
				// catches the exception thrown when the index for 
				// accounts is empty
			}
		}
		
		return totalAmount;
	}
	
	//-----------------------------------------------------------------
	// Sets the interest rate for that that account gain. Must be 
	// between 0 and 100 percent EX: 50% is .5
	//-----------------------------------------------------------------
	public double setRate(double interest)
	{
		if (interest > 0 || interest <= 1)
		{
			rate = interest;
		}
		else
		{
			System.out.println("Invalid Inerest Rate. The rate must "
					+"be between 0 and 1.");
		}
		return rate;
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public double setFee(double num)
	{
		fee = num;
		return fee;
	}
	
	public double getFee()
	{
		return fee;
	}
	
	public int getNumOfAcct()
	{
		return numOfAcct;
	}
	
	//-----------------------------------------------------------------
	// Adds the interest rate to all active accounts and return the 
	// totalAmount
	//-----------------------------------------------------------------
	public double addInterest()
	{
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				accounts[count].addInterest(rate);
			} catch (Exception exception)
			{
				// Catches the exception thrown when the accounts index
				// is empty
			}
			
		}
		return getTotalAmount();
	}
	
	//-----------------------------------------------------------------
	// Sets a new account name for an existing account and displays a
	// error message when no account can be found with the account 
	// number acctNum
	//-----------------------------------------------------------------
	public void setAcctName(long acctNum, String newName)
	{
		boolean found = false;
		
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				if (acctNum == accounts[count].getAcctNum())
				{
					accounts[count].setAcctName(newName);
					found = true;
				}
			} catch (Exception exception)
			{
				// Catches the exception thrown when the accounts[index]
				// is empty
			}
		}
		
		if (found == false)
		{
			System.out.println("Invalid Account Number. The account "
					+acctNum +" does not exist.");
		}
	}
	
	//-----------------------------------------------------------------
	// Set a new account number for an existing account and displays 
	// a error message when no account can be found with the 
	// account number acctNum
	//-----------------------------------------------------------------
	public void setAcctNum(long acctNum, long newNum)
	{
		boolean found = false;
		
		
		for (int count = 0; count < accounts.length; count++)
		{
			try
			{
				if (acctNum == accounts[count].getAcctNum())
				{
					for (int num = 0; num < accounts.length; num++)
					{
						if (newNum == accounts[num].getAcctNum())
						{
							System.out.println("Invalid New Account "
									+"Number. The number already exists.");
							found = true;
							break;
						}
					}
					// End the loop if newAcctNum already exists
					if (found = true)
					{
						break;
					}
					else
					{
					accounts[count].setAcctNum(newNum);
					found = true;
					break;
					//---------debug---------------------
					//System.out.println("Debug: new account new did not "
					//		+"work" + accounts[count]);
					//------------------------------------
					}
				}
			} catch (Exception exception)
			{
				// Catches the exception thrown when the accounts[index]
				// is empty
			}
		}
		
		if (found == false)
		{
			System.out.println("Invalid Account Number. The account "
					+acctNum +" does not exist.");
		}
	}
	
	//-----------------------------------------------------------------
	// this method will be called automatically when an account is 
	// trying to be added to the full accounts array. The method 
	// doubles the size of the accounts array.
	//-----------------------------------------------------------------
	protected void increaseSize()
	{
		SavingsAccount[] temp = new SavingsAccount[accounts.length * 2];
		
		for (int count = 0; count < accounts.length; count++)
		{
			temp[count] = accounts[count];
		}
		
		accounts = temp;
	}
	
	//-----------------------------------------------------------------
	// This method returns a nicely formated string with every account
	// in the accounts array.
	//-----------------------------------------------------------------
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String report = "~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	
		report = report + "Here is a list of all the accounts\n";
		report = report + "Number of accounts: " + numOfAcct +"\n";
		report = report + "Total amount of all accounts: " 
						+fmt.format(getTotalAmount()) + "\n";
		report = report + "\n";
		report = report + "Acct #\t\tOwner\t\t\tBalance\n";
		report = report + "-----------------------"
				+ "---------------------------------\n";
		
		for (int count = 0; count < accounts.length; count++)
		{
			if (accounts[count] == null)
			{
				//does nothing if accounts index is empty;
			}
			else
			{
				report = report + accounts[count].toString() + "\n";
			}
		}
		
		report = report +"\n";
		
		return report;
	}
}
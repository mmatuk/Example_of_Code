//************************************************************************
//	SavingsAccount.java 							Matt Matuk
// 	CSIT 210								Project 7.6 pg 376
//	This Class represents each person’s individual savings account. 
//	The class will store all the information about each account and 
//	allow each person to make withdraws and deposits. The class will 
//	also allow the bank to add interest to the account.  
//*************************************************************************	

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class SavingsAccount
{
	protected String name;
	protected long acctNum;
	protected double balance;
	
	//-----------------------------------------------------------------
	// This method creates an instance of SavignsAccount with a 
	// name, number and balance. 
	//-----------------------------------------------------------------
	public SavingsAccount(String owner, long num, double bal)
	{
		name = owner;
		acctNum = num;
		balance = bal;
	}
	
	//-----------------------------------------------------------------
	// Adds to the balance if the amount trying to be added is greater
	// than 0
	//-----------------------------------------------------------------
	public double deposit(double amount)
	{
		if (amount > 0)
		{
			balance = amount + balance;
		}
		else
		{
			System.out.println("Invalid amount. The deposite cannot "
					+"be a negative number.");
		}
		return balance;
	}
	
	//-----------------------------------------------------------------
	// withdraws money from the account and withdraws a fee is the 
	// withdraw amount and fee are greater than 0 and if there is 
	// enough money in the account
	//-----------------------------------------------------------------
	public double withdraw(double amount, double fee)
	{
		if ((amount + fee) < 0)
		{
			System.out.println("Invalid Withdraw. the withdraw amount "
					+"plus the fee cannot be negative.");
		}
		else 
		{
			if (balance > (amount + fee))
			{
				balance = balance - amount - fee;
			}
			else
			{
				System.out.println("Invalid Withdraw. Your account does "
						+"not have enough money.");
			}
			
		}
		return balance;
	}
	
	//-----------------------------------------------------------------
	// Adds the interest to the account
	//-----------------------------------------------------------------
	public double addInterest(double rate)
	{
		balance = balance + (balance * rate);
		return balance;
	}
	
	//-----------------------------------------------------------------
	// Sets the name to a new name for the account 
	//-----------------------------------------------------------------
	public void setAcctName(String owner)
	{
		name = owner;
	}
	
	public String getAcctName()
	{
		return name;
	}
	
	//-----------------------------------------------------------------
	// Sets the account number to a new number from 0 to 99999
	//-----------------------------------------------------------------
	public void setAcctNum(long num)
	{
		if (num < 0 || num > 99999)
		{
			System.out.println("Invalid Account Number.");
		}
		else 
		{
			acctNum = num;
		}
	}
	
	public long getAcctNum()
	{
		return acctNum;
	}
	
	public double getAcctBalance()
	{
		return balance;
	}
	
	//-----------------------------------------------------------------
	// Returns a nicely formated string containg all the account info
	//-----------------------------------------------------------------
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		DecimalFormat fmtAcctNum = new DecimalFormat("00000");
		
		String info;
		
		info = (fmtAcctNum.format(acctNum) +"\t\t"+ name +"\t\t"
				+ fmt.format(balance));
		
		return info;
	}
}
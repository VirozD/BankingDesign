/**
 * Class to represent a chequing account
 * @author Viroz D'Souza 
 * @course ICS4U
 * @date 2020/10/07
 */

public class ChequingAccount extends Account {
	
	//Attributes
	private double transactionFee = 1.50; 
	
	/**
	 * Constructor
	 * @param num
	 * @param name
	 * @param beginBalance
	 */
	public ChequingAccount(int accountNum, String name, double beginBalance) {
		super(accountNum, name, beginBalance);
	}
	
	/**
	 * Withdraw
	 * @param withdrawAmount
	 */
	public String withdraw(double withdrawAmount) {
		 this.balance = this.balance - withdrawAmount;
		 return "$" +withdrawAmount +" has been withdrawn to " +this.owner;
	}
	/**
	 * Deposit an amount 
	 * @param depositAmount
	 */
	public String deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		this.moneyInvested = this.moneyInvested + depositAmount;
		return "$" +depositAmount +" has been deposited to " +this.owner;
	}
	
	/**
	 * Complete a transaction
	 * @param amountForTransaction
	 * @param account
	 * @param time
	 */
	public String makeTransaction(double amount, Account accountTo, String time) {
		//Saving the information about Transaction
		this.transactions[numTransactions] = new Transaction(amount, this, accountTo, time);
		
		//Complete the transaction
		this.balance = this.balance - amount;
		accountTo.deposit(amount);
		this.numTransactions++;
		
		//$1.50 fee depending if the $1000 is sent
		if (amount > 1000) {
			this.totalServiceFees = this.totalServiceFees - this.transactionFee;
		}
		
		return"$" +amount+ " has been transferred to " +accountTo.owner;
	}
	
	/**
	 * Add money from interest to account balance
	 * @param interestRate
	 */
	public void setInterest(double newInterestRate) {
		this.interestRate = newInterestRate;
	}
	
}

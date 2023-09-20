/**
 * Class that is used to simulate an account in a banking system
 * @author Viroz D'Souza 
 * @course ICS4U
 * @date 2020/10/05
 */

public class Account {
	
	//Similar attributes for all of instances
	protected int accountNum;
	protected String owner;
	protected double balance;
	protected double interestRate;
	protected int numTransactions = 0;
	protected Transaction[] transactions = new Transaction[100];;
	protected double interestMoney = 0;
	protected double moneyInvested = 0;
	protected double totalServiceFees = 0;
	
	//CONSTRUCTOR
	public Account(int num, String name, double beginBalance) {
		this.accountNum = num;
		this.owner = name;
		this.balance = beginBalance;
	}
	
	/**
	 * Converting information into string
	 */
	public String toString() {
		String result = this.accountNum+","+this.owner+","+this.balance;
		return result;
	}
	
	/**
	 * Withdraw
	 * @param withdrawAmount
	 */
	public String withdraw(double withdrawAmount) {
		 this.balance = this.balance - withdrawAmount;
		 return "$" +withdrawAmount +" has been withdrawn";
	}
	/**
	 * Deposit an amount 
	 * @param depositAmount
	 */
	public String deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
		return "$" +depositAmount +" has been deposited";
	}
	
	/**
	 * Add money from interest to account balance
	 */
	public void setInterest() {
		
	}
	
	/**
	 * Add money from interest to account balance
	 */
	public void payInterest() {
		this.interestMoney = (this.balance * this.interestRate);
		this.balance = this.balance + this.interestMoney;
	}
	
}

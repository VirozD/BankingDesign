/**
 * Class that is used to simulate a transaction
 * @author Viroz D'Souza 
 * @course ICS4U
 * @date 2020/10/07
 */

public class Transaction {
	// Similar attributes for all of the accounts
	private double amount;
	private String time;
	private Account accountFrom;
	private Account accountTo;
	
	// CONSTRUCTOR
	public Transaction(double amount, Account accountFrom, Account accountTo, String time) {
		this.amount = amount;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.time = time;
	}
	
	/**
	 * Converting information into string
	 */
	public String toString () {
		String result = "$" +this.amount +" has been sent to " +this.accountTo +" from " +this.accountFrom +" at " +this.time;
		return result; 
	}

}

/**
 * Class that is used to simulate a bank in a banking system
 * @author Viroz D'Souza 
 * @course ICS4U
 * @date 2020/10/05
 */

public class Bank {
	//Similar attributes for all instances of banks
	public Account[] accounts;
	public  int numAccounts;
	private double totalMoneyInvested = 0;
	private String name; 
	private int numOfChequing = 0;
	private int numOfSavings = 0;
	private int numOfSeniorChild = 0;
	
	//CONSTRUCTOR
	public Bank(String name) {
		//Setting the parameters to variables
		this.name = name;
	}
	
	// Default Constructor 
	public Bank()
			{
				//Default attributes
				this.name = ("TD");
			}
	
	/**
	 * Generate a monthly report
	 */
	public void produceReport() {
		for (Account account : accounts) {
			
			//Set interest rates for separate type of accounts
			if(account instanceof ChequingAccount) {
				this.numOfChequing = this.numOfChequing + 1;
				this.totalMoneyInvested = this.totalMoneyInvested + account.moneyInvested;
			}
			
			else if(account instanceof SavingsAccount) {
				this.numOfSavings = this.numOfSavings + 1;
				this.totalMoneyInvested = this.totalMoneyInvested + account.moneyInvested;
			}
	
			else if(account instanceof SeniorChildAccount) {
				this.numOfSeniorChild = this.numOfSeniorChild + 1;
				this.totalMoneyInvested = this.totalMoneyInvested + account.moneyInvested;
			}				
		}
		
		//Print out report both money invested and number of each accounts
		System.out.println("$" +this.totalMoneyInvested +" has been invested in "+this.name );
		System.out.println("Chequing accounts: " +this.numOfChequing );
		System.out.println("Savings accounts: " +this.numOfSavings );
		System.out.println("Senior Child accounts: " +this.numOfSeniorChild );
	
	}
	
	/**
	 * Do the bank's monthly routine
	 * @param chequingInterestRate
	 * @param savingsInterestRate
	 * @param seniorChildInterestRate
	 */
	public String doMonthlyRoutine(double chequingInterestRate, double savingsInterestRate, double seniorChildInterestRate) {
		this.payInterest(chequingInterestRate, savingsInterestRate, seniorChildInterestRate);
		this.chargeServiceFees();
		
		return "The monthly routine is finished";
	}
	
	/**
	 * Pay the interest to the accounts
	 * @param chequingInterestRate
	 * @param savingsInterestRate
	 * @param seniorChildInterestRate
	 */
	private String payInterest(double chequingInterestRate, double savingsInterestRate, double seniorChildInterestRate) {
		for (int i = 0; i <= (this.numAccounts-1); i++) {
			
			//Set interest rates for separate type of accounts
			if(this.accounts[i] instanceof ChequingAccount) {
				((ChequingAccount)this.accounts[i]).setInterest(chequingInterestRate);
				this.accounts[i].payInterest();
			}
			
			else if(this.accounts[i] instanceof SavingsAccount) {
				((SavingsAccount)this.accounts[i]).setInterest(savingsInterestRate);
				this.accounts[i].payInterest();
			}
			
			else if(this.accounts[i] instanceof SeniorChildAccount) {
				((SeniorChildAccount)this.accounts[i]).setInterest(seniorChildInterestRate);
				this.accounts[i].payInterest();
			}
		}
		
		return "The interest has been paid to all accounts";
	}
	
	/**
	 * Charge the accounts service fees that were accumulated 
	 */
	private void chargeServiceFees() {
		for (Account account : accounts) {
			
			//Set interest rates for separate type of accounts
			if(account instanceof ChequingAccount) {
				account.balance = account.balance - account.totalServiceFees;
				System.out.println("$" +account.totalServiceFees +" has been deducted from " +account.owner);
			}
			
			else if(account instanceof SavingsAccount) {
				account.balance = account.balance - account.totalServiceFees;
				System.out.println("$" +account.totalServiceFees +" has been deducted from " +account.owner);
			}
			
			else if(account instanceof SeniorChildAccount) {
				account.balance = account.balance - account.totalServiceFees;
				System.out.println("$" +account.totalServiceFees +" has been deducted from " +account.owner);
			}
		}
	}
}

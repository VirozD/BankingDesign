import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Testing the Account Class
 * @author Viroz D'Souza 
 * @course ICS4U
 * @date 2020/10/07
 */

public class testAccount {

	public static void main(String[] args) throws Exception {
		//Create array to hold accounts
		Bank rbc = new Bank("RBC"); 
		rbc.accounts = new Account[100];
		rbc.numAccounts = 0;
		
		// Read Account from file
		Scanner sc = new Scanner(new FileReader("accountInfo.txt"));
		while (sc.hasNext()) {
			
			//CSV delimited data
			String line = sc.nextLine();
			String[] data =  line.split(",") ;
			
			//Create Account based on data given
			if (data[3].equals("chequing")) {
				rbc.accounts[rbc.numAccounts] = new ChequingAccount(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]));
			}
			
			else if (data[3].equals("savings")) {
				rbc.accounts[rbc.numAccounts] = new SavingsAccount(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]));
			}
			
			else if (data[3].equals("seniorchild")) {
				rbc.accounts[rbc.numAccounts] = new SeniorChildAccount(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]));
			}
			
			rbc.numAccounts++;
		}
		sc.close();
		System.out.println("Read "+rbc.numAccounts+" accounts");
		
		//Create a transaction from one account to another
		System.out.println(((ChequingAccount) rbc.accounts[0]).makeTransaction(200.0,rbc.accounts[1],"now"));
		
		System.out.println(rbc.accounts[2].deposit(100));
		
		System.out.println(((ChequingAccount) rbc.accounts[3]).makeTransaction(50.0,rbc.accounts[2],"later"));
		
		// Setup the input from keyboard
		Scanner input = new Scanner(System.in);
		
		//Entering Chequing Interest rate
		System.out.print("Enter Chequing Interest Rate: ");
		double ChequingInterest = input.nextDouble();
		
		//Entering Savings Interest rate
		System.out.print("Enter Savings Interest Rate: ");
		double SavingsInterest = input.nextDouble();
		
		//Entering Senior Child Interest rate
		System.out.print("Enter Senior Child Interest Rate: ");
		double SeniorChildInterest = input.nextDouble();
		
		input.close();
		
		System.out.println(rbc.doMonthlyRoutine(ChequingInterest,SavingsInterest,SeniorChildInterest));
		
		rbc.produceReport();
	}

}

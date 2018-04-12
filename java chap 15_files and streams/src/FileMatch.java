
import java.util.*;
public class FileMatch {
	
	private static Scanner oldMaster;
	private static Scanner transactionFile;
	private static Formatter newMaster;
	private static Formatter logFile;
	private static TransactionRecord transaction;
	private static AccountRecord account;
	
	public FileMatch() {
		transaction = new TransactionRecord();
		account = new AccountRecord();
	}
	
	public void openFile() {
		try {
			oldMaster = new Scanner("oldmast.txt");
			transactionFile = new Scanner("trans.txt");
			newMaster = new Formatter("newmast.txt");
			logFile = new Formatter("log.txt");
			
		}
		
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void proccessFiles() {
		
		int transactionAccountNumber;
		int accountNumber;
		
		try {
			transaction = getTransactionRecord();
			
			if(transaction == null)
				return;
			
			transactionAccountNumber = transaction.getAccount();
			
			account = getAccountRecord();
			
			if(account == null)
				return;
			
			accountNumber = transaction.getAccount();
			
			while(accountNumber != 0) {
				while(accountNumber < transactionAccountNumber) {
					newMaster.format("%d %s %s %.2f\r\n" ,account.getAccount(), account.getFirstName(), 
	                           account.getLastName(),account.getBalance());
					
					account = getAccountRecord();
					
					if(account == null)
						return;
					
					accountNumber = transaction.getAccount();
					

				}
				
				if(accountNumber == transactionAccountNumber) {
					account.combine(transaction);
					
					newMaster.format("%d %s %s %.2f\r\n" ,account.getAccount(), account.getFirstName(), 
	                           account.getLastName(),account.getBalance());
					
					transaction = getTransactionRecord();
					
					if(transaction == null)
						return;
					
					transactionAccountNumber = transaction.getAccount();
					
					account = getAccountRecord();
					
					if(account == null)
						return;
					
					accountNumber = transaction.getAccount();
				}
				
				while(transactionAccountNumber < accountNumber) {
					logFile.format("%s %d\n", " unmatched transaction record for account number", transactionAccountNumber);
					

					transaction = getTransactionRecord();
					
					if(transaction == null)
						return;
					
					transactionAccountNumber = transaction.getAccount();
					
					
				}
			}
			
			
		}
		
		catch(IllegalFormatException illegal) {
			System.err.println(illegal.getMessage());
			System.exit(1);
		}
		
		
	}
	
	public void closeFile() {
		
		try {
			if(transactionFile != null)
				transactionFile.close();
			if(newMaster != null)
				newMaster.close();
			if(oldMaster != null)
				oldMaster.close();
			if(logFile != null)
				logFile.close();
				
		}
		catch(Exception  exception) {
			System.err.println("error closing files");
			System.exit(1);
		}
	}
	
	private TransactionRecord getTransactionRecord() {
		
		try {
			if(transactionFile.hasNext()) {
				transaction.setAccount(transactionFile.nextInt());
				transaction.setTransAmount(transactionFile.nextDouble());
				return transaction;
			}
			
			else {
				while(oldMaster.hasNext()) {
					account.setAccount(oldMaster.nextInt());
					account.setFirstName(oldMaster.next());
					account.setLastName(oldMaster.next());
					account.setBalance(oldMaster.nextDouble());
					
					newMaster.format("%d %s %s %.2f\r\n" ,account.getAccount(), account.getFirstName(), 
	                           account.getLastName(),account.getBalance());
				}
			}
		}
		
		catch(IllegalFormatException illegal) {
			System.err.println(illegal.getMessage());
			System.exit(1);
		}
		
		return null;
	}
	
private AccountRecord getAccountRecord() {
		
		try {
			if(oldMaster.hasNext()) {
					account.setAccount(oldMaster.nextInt());
					account.setFirstName(oldMaster.next());
					account.setLastName(oldMaster.next());
					account.setBalance(oldMaster.nextDouble());
					
					return account;
					
			}
			else {
				logFile.format("%s %d\n", " unmatched transaction recor for account number", transaction.getAccount());
				
				
			}
			
			while(transactionFile.hasNext()) {
				transaction.setAccount(transactionFile.nextInt());
				transaction.setTransAmount(transactionFile.nextDouble());
				
			}
			
			
		}
		
		catch(IllegalFormatException illegal) {
			System.err.println(illegal.getMessage());
			System.exit(1);
		}
		
		return null;
	}

}

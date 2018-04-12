import java.io.FileNotFoundException;
import java.util.*;
public class CreateAccountTextFile {
private Formatter output;
	
	public void openFile() {
		try {
			output = new Formatter("oldmast.txt");
		}
		
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			
		}
	}
	public void addRecords() {
		AccountRecord accountRecord = new AccountRecord();
		Scanner input = new Scanner(System.in);
		System.out.printf("%s","Enter Account Number, first name, last name, balance" );
		
		while(input.hasNext()) {
			accountRecord.setAccount(input.nextInt());
			accountRecord.setFirstName(input.next());
			accountRecord.setLastName(input.next());
			accountRecord.setBalance(input.nextDouble());
			
			output.format("%d %s %s %.2f\r\n" ,accountRecord.getAccount(), accountRecord.getFirstName(), 
					                           accountRecord.getLastName(),accountRecord.getBalance());
			
			System.out.printf("%s","Enter Account Number, first name, last name, balance" );			
			
		}
		input.close();
	}
	
	
	public void closeFile() {
		if(output!=null)
			output.close();
	}
	
	
}



import java.io.FileNotFoundException;
import java.util.*;
public class CreateTransTextFile {

	private Formatter output;
	
	public void openFile() {
		try {
			output = new Formatter("trans.txt");
		}
		
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			
		}
	}
	public void addRecords() {
		TransactionRecord transRecord = new TransactionRecord();
		Scanner input = new Scanner(System.in);
		System.out.printf("%s %s","Enter Account Number", "Enter Transaction Amount" );
		
		while(input.hasNext()) {
			transRecord.setAccount(input.nextInt());
			transRecord.setTransAmount(input.nextDouble());
			
			output.format("%d %.2f\r\n", transRecord.getAccount(), transRecord.getTransAmount());
			
			System.out.printf("%s %s","Enter Account Number", "Enter Transaction Amount" );
			
			
		}
		input.close();
	}
	
	
	public void closeFile() {
		if(output!=null)
			output.close();
	}
	
	
}

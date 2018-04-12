
public class TransactionRecord {

	private int accountNumber;
	private double transAmount;
	
	
	public TransactionRecord() {
		this(0,0);
		
	}
	
	public TransactionRecord(int accNum, double transAmt) {
		setAccount(accNum);
		
		setTransAmount(transAmt);
	}
	
	public void setAccount(int accNum) {
		accNum=accountNumber;
	}
	
	public int getAccount() {
		return accountNumber;
	}
	

	public void setTransAmount(double transAmt) {
		transAmt=transAmount;
	}
	
	public double getTransAmount() {
		return transAmount;
	}


}

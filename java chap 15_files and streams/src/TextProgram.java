
public class TextProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateTransTextFile transFile = new CreateTransTextFile();
			
		
		transFile.openFile();
		transFile.addRecords();
		transFile.closeFile();

	}

}

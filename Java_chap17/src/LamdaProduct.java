interface UsedData {

    public double sproduct(double a, double b);
    
    
}

interface MyFunctionalInterface {

	//A method with no parameter
    public String sayHello();
}

public class LamdaProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsedData s = (a, b) -> a * b;
        System.out.println("Result: "+s.sproduct(5.0,4.0));
	
        MyFunctionalInterface msg = () -> {
    		return "Welcome to lamda";
    	};
        System.out.println(msg.sayHello());
	}

}

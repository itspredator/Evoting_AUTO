package pageobjects;

public class maindemo extends testdemo1{

	public maindemo(String e) {
		super(e);
	}

	public static void main(String[] args) {
	
	testdemo1 demo = create();

	
	System.out.println("DEMO : " + demo.getEven() );
	}

}

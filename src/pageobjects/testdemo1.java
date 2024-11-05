package pageobjects;

public class testdemo1 {
	
	public static String even;
	
	public testdemo1(String e) {
		this.even = e;
	}
	
	
	
	public static String getEven() {
		return even;
	}



	public static void setEven(String even) {
		testdemo1.even = even;
	}



	public static testdemo1 create() {
		
		even = "1234";
		testdemo1 demo = new testdemo1(even);
		System.out.println(demo.getEven());
		return demo;
	}

}

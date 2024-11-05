package pageobjects;

public class demo {
	public static void todaysdate()
	{
		 java.util.Date date = new java.util.Date();    
		    System.out.println(date);   
		    String datesepration=date.toString();
		    String seperator[]=datesepration.split(" ");
		    for(String s:seperator)
		    {
		    	System.out.println("seperated by value \t" +s);
		    }
		    if(seperator[1].equalsIgnoreCase("FEB"))
		    	
		    {
		    System.out.println("passed");
		    }
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub


demo.todaysdate();
			
	
}
	}
/*if(filename.substring(filename.indexOf("."), filename.length()).equals(".pdf")) {
			System.out.println("TRUE");
			System.out.println(filename.substring(filename.indexOf("."), filename.length()));
		}

	}

 */

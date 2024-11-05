package utility;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;


	public static Properties getProperties()
	{
		
		prop=new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\Pinkesh\\EVOTINGAUTOMATION\\configuration\\config.properties");
			prop.load(ip);
			ip.close();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		
		return prop;
	}
	
	public ConfigReader() {
		super();
		getProperties();
	}

	public static String getProprty(String key)
	{
		return prop.getProperty(key);
	}

}

package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import shr.createeven;

public class ConfigReader {

	private static final String CONFIG_FILE_PATH = "D:\\Pinkesh\\Evoting_Total\\src\\config.properties";
	private static Properties prop;

	public static Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream(CONFIG_FILE_PATH);
				prop.load(ip);

			} catch (IOException e) {

				System.err.println("Error reading config.properties: " + e.getMessage());
			}

			try {
				String myeven = createeven.extractionofeven;
				if (myeven != null && !myeven.isEmpty()) {
					System.out.println("Generated Event ID: " + myeven);
					prop.setProperty("evenId", myeven);
					saveProperties(); // Save to file
				}
			} catch (Exception e) {
				System.err.println("Error generating event ID: " + e.getMessage());
			}
		}
		return prop;
	}

	// Save the properties back to the file
	private static void saveProperties() {
		try (FileOutputStream out = new FileOutputStream(CONFIG_FILE_PATH)) {
			prop.store(out, "Updated config at runtime");
		} catch (IOException e) {
			System.err.println("Could not write to config.properties: " + e.getMessage());
		}
	}

	// Set a property and save it
	public static void setProperty(String key, String value) {
		getProperties().setProperty(key, value);
		saveProperties();
	}

	public ConfigReader() {
		super();
		getProperties();
	}

	public static String getProprty(String key) {
		return prop.getProperty(key);
	}

}

package utility;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DB2Connect {

	public static String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
	public static String url;
	public static String user;
	public static String password;
	public static Connection connection;


	// static Properties properties = new Properties();
	static InputStream inputStream = null;
	private static  ConfigReader configReader = new ConfigReader();
	static Properties prop;

	//Database credentials validated
	public static void databaseCredentials() throws IOException {

		prop = ConfigReader.getProperties();

		url = prop.getProperty("DATABASE_URL");
		user = prop.getProperty("DATABASE_USER");
		password = prop.getProperty("DATABASE_PASSWORD");
		System.out.println("URL"+url);
	}


	//Connecting application database db2 	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{

		try {
			databaseCredentials();

			Class.forName(jdbcClassName);
			connection = DriverManager.getConnection(url, user, password);

		} catch (IOException e) {
			e.printStackTrace();
		}			

		return connection;
	}

	//Database disconnected 
	public static void tearDownSQL() throws Exception{
		connection.close();
	}

}

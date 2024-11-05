package utility;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class otpauthenticator  extends DB2Connect{

			
	public static String otpAuth(String type) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException {
		Connection con = DB2Connect.getConnection();
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery("select OGT_OTP_VAL from otp_gen_tbl where ogt_user_id='" + type +  "' order by OGT_CRTD_TMST desc fetch first 1 rows only");
		// TODO Auto-generated method stub
		set.next();
		System.out.println(set.toString());
		return set.getObject("OGT_OTP_VAL").toString();
	}

}

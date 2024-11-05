package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.db2.jcc.am.el;

import utility.DB2Connect;

public class DatabaseServiceImpl implements DatabaseService{
	
	public static Connection connection;
	public static Statement statement;
	public static ResultSet resultSet;
	public static int status;

	public DatabaseServiceImpl() throws ClassNotFoundException, SQLException {
		super();
		connection = DB2Connect.getConnection();
	}



	public Details getDetails(String evenNo) throws SQLException {
	
		String query = 	"Select EDT_EV_ID,EDT_EV_ISIN,EDT_ENTITY_ID,EDT_RECORD_DT from evtng_dtls_tbl where edt_ev_id in('" +  evenNo + "')";
		System.out.println("Qry : " +  query);
		
		Details details = new Details();
		statement = (Statement) connection.createStatement();
		resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			details.setEDT_EV_ID(resultSet.getObject("EDT_EV_ID").toString());
			details.setEDT_EV_ISIN(resultSet.getObject("EDT_EV_ISIN").toString());
			details.setEDT_ENTITY_ID(resultSet.getObject("EDT_ENTITY_ID").toString());
			details.setEDT_RECORD_DT(resultSet.getObject("EDT_RECORD_DT").toString());
			
			System.out.println("DETAILS : " + details.toString());
		}

		return details;
	}
	
	public int isExists(String batchId) throws SQLException {

		String query = "select COUNT(*)  AS recordCount from btch_prcss_mst where btp_btch_id = '" + batchId + "'";
		System.out.println("Qry : " +  query);
		
		statement = (Statement) connection.createStatement();
		resultSet = statement.executeQuery(query);
		resultSet.next();

		return resultSet.getInt("recordCount");
	}



	@Override
	public String FetchShareHolderId(String Query) throws SQLException {
		statement = (Statement) connection.createStatement();
		resultSet = statement.executeQuery(Query);
		resultSet.next();
		return resultSet.getObject("sem_user_id").toString();

	}



	@Override
	public int UpdateCommonpassword(String Query) throws SQLException {
		statement = (Statement) connection.createStatement();
		status = statement.executeUpdate(Query);

		return status;
	}

}

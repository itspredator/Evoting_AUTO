package service;

import java.sql.SQLException;

public interface DatabaseService {

	
	public Details getDetails(String evenNo) throws SQLException;
	
	public int isExists(String batchId) throws SQLException;

	public String FetchShareHolderId(String Query) throws SQLException;
	
	public int UpdateCommonpassword(String Query) throws SQLException;
}

package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Item;

public class DataSourceManager {
	private DataSource ds;
	//싱글톤
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		try {
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getConnection() throws SQLException {
		return ds;
	}
	

	
}
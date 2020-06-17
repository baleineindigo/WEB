package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;


import utility.DataSourceManager;

public class ItemDao {
	private DataSource ds;
	private static ItemDao dao = new ItemDao();
	private ItemDao(){
		try {
			ds = DataSourceManager.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ItemDao getInstance() {
		return dao;
	}
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null) {
			closeAll(ps, conn);
		}
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (conn!=null) {
			closeAll(ps, conn);
		}			
	}
	public ArrayList<Item> getAllItem() throws SQLException {
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println("connected");
			String query="SELECT * FROM item";
			ps = conn.prepareStatement(query);
			rs= ps.executeQuery();
			System.out.println("get all item query executed");
			while (rs.next()) {
				list.add(new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs,ps,conn);
		}
		return list;
	}
	public ArrayList<Item> getItem(int itemnum) throws SQLException {
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) getConnection();
			String query="SELECT * FROM item WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1,  itemnum);
			rs= ps.executeQuery();
			while (rs.next()) {
				list.add(new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs,ps,conn);
		}
		return list;
	}
}

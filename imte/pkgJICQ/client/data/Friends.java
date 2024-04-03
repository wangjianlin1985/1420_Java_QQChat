package pkgJICQ.client.data;

import java.sql.*;
import java.util.ArrayList;

public class Friends {
	Connection conn = DBConnection.getConnection();
	Statement st = null;

	//查找好友
	public ResultSet selectFriends(String JICQ) {
		ResultSet rs = null;
		try {

			int qqNum = Integer.parseInt(JICQ);
			/*
			CallableStatement proc = conn
					.prepareCall("{call proc_selectFriends(?)}",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			proc.setInt(1, qqNum);

			rs = proc.executeQuery();
			*/
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sqlStr = "select JUsers.*,JFriends.JFriendID,JFriends.JFriendTypeID from JUsers,JFriends where  JFriends.JFriendID = JUsers.JICQ and  JFriends.JICQ=" + JICQ;
			rs = st.executeQuery(sqlStr);
			

			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	// --------------------------------------------------查询个人好友类型
	public ResultSet selectFriendTypes(String JICQ) {
		ResultSet rs = null;
		try {
			/*
			CallableStatement proc = conn
					.prepareCall("{call proc_selectFriendTypes(?)}",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			int qqNum = Integer.parseInt(JICQ);
			proc.setInt(1, qqNum);

			rs = proc.executeQuery();
			*/
			st = conn.createStatement();
			String sqlStr = "select * from JFriendType where JICQ=" + JICQ;
			rs = st.executeQuery(sqlStr);

			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	// --------------------------------------------------查询各类型人数

	public ResultSet selectFriendCounts(String JICQ) {
		ResultSet rs = null;
		try {
			/*
			CallableStatement proc = conn
					.prepareCall("{call proc_selectFriendCount(?)}",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			int qqNum = Integer.parseInt(JICQ);
			proc.setInt(1, qqNum);

			rs = proc.executeQuery();
			*/
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
			String sqlStr = "select JFriendTypeID,count(JFriendTypeID) as JFriendCount from JFriends where JICQ=" + JICQ + " group by JFriendTypeID";
			rs = st.executeQuery(sqlStr);


			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public int insertFriends(int JICQ, int hisJICQ, int FriendTypeID) {
		int flag = 0;
		try {
			/*
			CallableStatement proc = conn
					.prepareCall("{call proc_insertFriends(?,?,?)}");

			proc.setInt(1, JICQ);
			proc.setInt(2, hisJICQ);
			proc.setInt(3, FriendTypeID);
			

			flag = proc.executeUpdate();
			*/
			st = conn.createStatement();
			String sqlStr  =  "insert into JFriends(JICQ,JFriendID,JFriendTypeID) values (" + JICQ + "," + hisJICQ + "," + FriendTypeID + ")";
			System.out.println(sqlStr);
			flag = st.executeUpdate(sqlStr);
			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	// 查询好友或者本人资料-----------------------------------------------------
	public ResultSet selectAllDetail(String JICQ) {
		ResultSet rs = null;
		try {

			int qqNum = Integer.parseInt(JICQ);
			/*
			CallableStatement proc = conn
					.prepareCall("{call proc_selectAllDetail(?)}",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			proc.setInt(1, qqNum);

			rs = proc.executeQuery();
			*/
			st = conn.createStatement();
			String sqlStr = "select * from JUsers where JICQ=" + JICQ;
			rs = st.executeQuery(sqlStr);

			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static void main(String args[]) {
		try {
			//ResultSet rs = new Friends().selectAllDetail("10002");
			ResultSet rs = new Friends().selectAllDetail("1");
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2));
			}

		} catch (Exception ex) {
		}

	}

}
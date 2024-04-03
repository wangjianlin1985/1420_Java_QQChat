package pkgJICQ.client.data;

import java.sql.*;

public class LoginPic {
	Connection conn = DBConnection.getConnection();

	public String selectLoginPicID() {
		// ��ȡ��½��ʱ��ĵ�½�����ͼƬ
		ResultSet rs = null;
		String ID = "login10000.JPG";
		try {

			Statement stment = conn.createStatement();
			rs = stment
					.executeQuery("select LoginPicID,UpdateDate from LoginPic order by UpdateDate desc");
		
			    rs.next();
				ID = rs.getString(1);
				Date date = rs.getDate(2);

				java.util.Date now = new java.util.Date();
				if (date.before(now))
					ID = "login10000.JPG";
				System.out.println(date.getDate()+"="+now.getDate());
		
			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����� catch ��
					e.printStackTrace();
				}
			}
		}

		return ID;
	}

	public static void main(String[] args) {
		new LoginPic().selectLoginPicID();
	}
}
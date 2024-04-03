package pkgJICQ.server.data;
import java.sql.*;


public class s_Group
{
	Connection conn=DBConnection.getConnection();
	
	public ResultSet selectAllPerson(String JGroupID)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JGroupID);
			Statement stment= conn.createStatement();
			rs=stment.executeQuery("select JICQ from JGroup_Users where JGroupID="+qqNum);
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace(); }
		return rs;
	}
}
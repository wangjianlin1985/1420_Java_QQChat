package pkgJICQ.server.data;

import java.sql.*;
public class s_MyDetails
{
	Connection conn=DBConnection.getConnection();
	public ResultSet selectMyDetail(String JICQ)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JICQ);
			CallableStatement proc = conn.prepareCall("{call proc_selectMyDetails(?)}");
			proc.setInt(1,qqNum); 
			rs=proc.executeQuery();
			
			//conn.close();
		}catch(Exception ex){ex.printStackTrace();}
		return rs;
	}
	
	public int updateOnline(String JICQ,String IP,int status)
	{
		
		try{
			Statement stment=conn.createStatement();
			int up=stment.executeUpdate("update JUsers set JUserIP='"+IP+"',JStatus='"+status+"' where JICQ='"+JICQ+"'");
		
			return up;
			//conn.close();
		}catch(Exception ex){ex.printStackTrace();}
		return -1;
	}
	
	public boolean validateUserDetails(String JICQ,String Password)
	{
		ResultSet rs=null;
		try{
			int qqNum=Integer.parseInt(JICQ);
			CallableStatement proc = conn.prepareCall("{call proc_selectMyDetails(?)}");
			proc.setInt(1,qqNum); 
			rs=proc.executeQuery();
		/*	
			while(rs.next())
			{
				System.out.println(rs.getString(3)+"-"+rs.getString(4)+"-"+rs.getString(7)+"-"+rs.getString(8)+"-"+rs.getString(9));
			}
		*/	rs.next();
			String sqlPassword=rs.getString(2);
			conn.close();
			if(Password.equals(sqlPassword))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		return false;
	}
	
	public int insertNewGroup(String JICQ,String GroupName)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			Statement stment=conn.createStatement();
			int flag=stment.executeUpdate("insert into JFriendType values('"+GroupName+"','"+qqNum+"')");
			return flag;
		}catch(Exception ex){}
		return 0;
	}
	
	public int delOldGroup(String JICQ,String GroupName)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			Statement stment=conn.createStatement();
			String sql="delete from JFriendType where JICQ="+qqNum+" and JFriendTypeName='"+GroupName+"'";
			System.out.println(sql);
			int flag=stment.executeUpdate("delete from JFriendType where JICQ="+qqNum+" and JFriendTypeName='"+GroupName+"'");
			return flag;
		}catch(Exception ex){}
		return 0;
	}
	
	public int delFriend(String JICQ,String hisJICQ)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			int hisqqNum=Integer.parseInt(hisJICQ);
			Statement stment=conn.createStatement();
			int flag=stment.executeUpdate("delete from JFriends where JICQ="+qqNum+" and JFriendID="+hisqqNum);
			return flag;
		}catch(Exception ex){}
		return 0;
	}
	
	//查看数据库中是否有我的信息
	public ResultSet isHaveMessage(String JICQ)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			Statement stment=conn.createStatement();
			ResultSet rs=stment.executeQuery("select * from JMessages where FriendJICQ='"+qqNum+"'");
			
			return rs;
		}catch(Exception ex){ex.printStackTrace();}
		return null;
	}
	
	//删除数据库中已经查看过的旧信息
	public int delOldMessage(String JICQ)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			Statement stment=conn.createStatement();
			int flag=stment.executeUpdate("delete from JMessages where FriendJICQ="+qqNum);
			return flag;
		}catch(Exception ex){}
		return 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new s_MyDetails().delOldGroup("10002","1111"));
	}
}
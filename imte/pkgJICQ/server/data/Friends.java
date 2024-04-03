package pkgJICQ.server.data;

import java.sql.*;
public class Friends
{
	Connection conn=DBConnection.getConnection();
	Statement st = null;
	public ResultSet selectAddMePerson(String JICQ)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JICQ);
			/*
			CallableStatement proc = conn.prepareCall("{call proc_selectAddMePerson(?)}");
			proc.setInt(1,qqNum); 
			 
			rs=proc.executeQuery();*/
			st = conn.createStatement();
			String sqlStr = "select * from JFriends where JICQ=" + JICQ;
			rs = st.executeQuery(sqlStr);
		//	conn.close();
			
		}catch(Exception ex){ex.printStackTrace(); }
		return rs;
	}
	
	public boolean isOnline(String JICQ)
	{
		try{
			int qqNum=Integer.parseInt(JICQ);
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select JStatus from JUsers where JICQ='"+qqNum+"'");
			rs.next();
			int JStatus=rs.getInt("JStatus");
			if(JStatus==0)
			return false;
		}catch(Exception ex){ex.printStackTrace();}
		return true;
	}
	
	public int insertMessage(String myJICQ,String FriendJICQ,String MessageHead,String MessageContent,int isfriend)
	{
		try{
			int myNum=Integer.parseInt(myJICQ);
			int hisNum=Integer.parseInt(FriendJICQ);
			
			Statement st=conn.createStatement();
			String sqlStr = "insert into JMessages(MyJICQ,FriendJICQ,MessageHead,MessageContent,flag) values('"+myNum+"','"+hisNum+"','"+MessageHead+"','"+MessageContent+"',"+isfriend+")";
			System.out.println(sqlStr);
			int flag=st.executeUpdate(sqlStr);
			return flag;
		}catch(Exception ex){ex.printStackTrace();}
		return 0;
	}
	
	//添加好友---------------------------------------------------------------
	public int insertFriends(int JICQ,int hisJICQ,int FriendTypeID)
	{
		int flag=0;
		try{
			/*
			CallableStatement proc = conn.prepareCall("{call proc_insertFriends(?,?,?)}");

			proc.setInt(1,JICQ);
			proc.setInt(2,hisJICQ); 
			proc.setInt(3,FriendTypeID);
			 
			flag=proc.executeUpdate();*/
			Statement st=conn.createStatement();
			String sqlStr = "insert into JFriends(JICQ,JFriendID,JFriendTypeID) values('"+JICQ+"','"+hisJICQ+"','"+FriendTypeID+"')";
			System.out.println(sqlStr);
			flag=st.executeUpdate(sqlStr);
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return flag;
	}
	
	//查看是否已为好友
	public int IsFriend(int JICQ,int hisJICQ)
	{
		ResultSet rs=null;
		int flag=0;
		try{
			/*
			CallableStatement proc = conn.prepareCall("{call proc_IsFriend(?,?)}");

			proc.setInt(1,JICQ);
			proc.setInt(2,hisJICQ); 
			 
			rs=proc.executeQuery();*/
			st = conn.createStatement();
			String sqlStr = "select * from JFriends where JICQ=" + JICQ + " and JFriendID=" + hisJICQ;
			rs = st.executeQuery(sqlStr);
			
			while(rs.next())
			{
				flag++;
			}
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return flag;
	}
	
	
	
	public static void main(String [] args)
	{
		try{
			int flag=new Friends().IsFriend(10001,10000);
			if(flag==0)
				System.out.println("还没有加为好友");
			else
				System.out.println("已经加为好友");
		}catch(Exception ex){ex.printStackTrace();}
		
	}


}
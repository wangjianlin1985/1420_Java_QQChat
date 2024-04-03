package pkgJICQ.client.data;

import java.sql.*;
public class GroupDetail
{
	Connection conn=DBConnection.getConnection();
	
	public ResultSet selectMyGroups(String JICQ)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JICQ);
			Statement stment= conn.createStatement();
			rs=stment.executeQuery("select JGroupID,JGroupJICQ,JGroupName,JGroupType,JGroupBcast,JGroupInfo from JGroups where JGroupID in (select JGroupID from JGroup_Users where JICQ="+qqNum+")");
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace(); }
		return rs;
	}
	
	
	
	public int updateMyGroups(int JGroupID,String JGroupName,String JGroupType,String JGroupBcast,String JGroupInfo)
	{
		int flag=0;
		try{
			

			Statement stment= conn.createStatement();
			flag=stment.executeUpdate("update JGroups set JGroupName='"+JGroupName+"',JGroupType='"+JGroupType+"',JGroupBcast='"+JGroupBcast+"',JGroupInfo='"+JGroupInfo+"' where JGroupID="+JGroupID);
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace(); }
		return flag;
	}
	
	public ResultSet selectSingleGroup(String JGroupID)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JGroupID);
			Statement stment= conn.createStatement();
			rs=stment.executeQuery("select JGroupID,JGroupJICQ,JGroupName,JGroupType,JGroupBcast,JGroupInfo from JGroups where JGroupID ="+qqNum);
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace(); }
		return rs;
	}
	
	public ResultSet selectAllPerson(String JGroupID)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JGroupID);
			Statement stment= conn.createStatement();
			rs=stment.executeQuery("select JICQ,JGroupName from JGroup_Users where JGroupID="+qqNum);
			
		//	conn.close();
		}catch(Exception ex){ex.printStackTrace(); }
		return rs;
	}
	
	
	public static void main(String args[])
	{
		try{
			int flag=new GroupDetail().updateMyGroups(10000,"夕阳无限好","情感天地","这里可以诉说你的快乐忧愁请加入吧!","情感的自由天地感受孤独后的快乐");
		
			
		}catch(Exception ex){}
		
	}

}
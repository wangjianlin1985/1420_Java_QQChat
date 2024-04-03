package pkgJICQ.client.data;

import java.sql.*;
public class MyDetails
{
	Connection conn=DBConnection.getConnection();
	Statement st = null;
	public ResultSet selectMyDetail(String JICQ)
	{
		ResultSet rs=null;
		try{
			
			int qqNum=Integer.parseInt(JICQ);
			/*
			CallableStatement proc = conn.prepareCall("{call proc_selectMyDetails(?)}");
			proc.setInt(1,qqNum); 
			rs=proc.executeQuery();
			*/
			st = conn.createStatement();
			String sqlStr = "select * from JUsers where JICQ=" + JICQ;
			rs = st.executeQuery(sqlStr);
			
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
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成 catch 块
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	

	
	public int validateUserDetails(String JICQ,String Password)
	{
		ResultSet rs=null;
		Statement st = null;
		try{
			int qqNum=Integer.parseInt(JICQ);
			/*
			CallableStatement proc = conn.prepareCall("{call proc_validateMyDetails(?,?)}");
			proc.setInt(1,qqNum); 
			proc.setString(2,Password);
			rs=proc.executeQuery();
			*/
			
			String sqlStr2 = "select JStatus from JUsers where JICQ=" + JICQ;
			st = conn.createStatement();
			rs = st.executeQuery(sqlStr2);
			
			int status=-1;
			boolean flag=rs.next();
			if(flag==false)
				status=-1;
			else if(flag==true)
				status=rs.getInt("JStatus");
			//获取用户的状态
			
			return status;
		//	conn.close();
			
			
		}catch(Exception ex){ex.printStackTrace();}
		return -1;
	}
	

	public int upDataUser(int JICQ,String JShowName,String JTrueName,int JAge,String JSex,String JCountry,String JProvince,String JCity,String JEmail,String JUnderWrite,String JProfession,String JStar,String JXuexing,String JGradute,String JAddress,String JPostalcode,String JPersonalPage,String JPersonalInfo)
	{
		if(JAge<1||JAge>130)
		{
			return 3;
		}
		try{				
			Statement stment=conn.createStatement();
			int rs=stment.executeUpdate("update JUsers set JShowName='"+JShowName+"',JTrueName='"+JTrueName+"',JAge='"+JAge+"',JSex='"+JSex+"',JCountry='"+JCountry+"',JProvince='"+JProvince+"',JCity='"+JCity+"',JEmail='"+JEmail+"',JUnderWrite='"+JUnderWrite+"',JProfession='"+JProfession+"',JStar='"+JStar+"',JXuexing='"+JXuexing+"',JGradute='"+JGradute+"',JAddress='"+JAddress+"',JPostalcode='"+JPostalcode+"',JPersonalPage='"+JPersonalPage+"',JPersonalInfo='"+JPersonalInfo+"' where JICQ="+JICQ);
			return rs;
		}catch(Exception ex)
		{
			System.out.println(ex.toString());
		}return -1;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(new MyDetails().validateUserDetails("10000","123456"));
	}
}
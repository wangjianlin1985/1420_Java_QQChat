package pkgJICQ.server.data;

import java.sql.*;

public class DBConnection
{
	public static Connection getConnection()
	{
		Connection conn=null;
		try{
			
		//	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
			//String url="jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=JICQ";
			String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;DatabaseName=JICQ";
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"sa","123456");
		//	conn=DriverManager.getConnection("jdbc:odbc:dsJICQ","user","password");
					
		}catch(Exception ex){ex.printStackTrace();}
		return conn;
	}
	
	public static void main(String[] args)
	{
		try{
		
			Connection conn=DBConnection.getConnection();
			System.out.println("DataBase state:"+conn);
		}catch(Exception ex){ex.printStackTrace();}
	}
}
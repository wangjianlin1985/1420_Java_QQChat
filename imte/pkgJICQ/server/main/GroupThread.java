package pkgJICQ.server.main;
import pkgJICQ.server.data.*;
import java.sql.*;
import java.util.*;

public class GroupThread
{
	String GroupID=null;
	Vector PersonsVector;
	public GroupThread(String GroupID)
	{
		this.GroupID=GroupID;
		PersonsVector=new Vector(50);
		s_Group sg=new s_Group();
		try{
			ResultSet rs=sg.selectAllPerson(GroupID);
			while(rs.next())
			{
				PersonsVector.add(rs.getString("JICQ"));
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
}


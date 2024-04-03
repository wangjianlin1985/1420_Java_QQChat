package pkgJICQ.client.frame;

import java.util.*;
import java.io.*;

public class LeastPerson
{
	public static ArrayList PersonList=new ArrayList(10);
	String path = System.getProperty("user.dir");
	
	String usrdir=path+"\\data";
	String usrfile="";

	
	public LeastPerson(String JICQ)
	{
		System.out.println("path**"+path);
		usrfile=usrdir+"\\"+JICQ+"\\Person.hid";
		try{
			File dir=new File(usrdir+"\\"+JICQ); 
			File f=new File(usrdir+"\\"+JICQ+"\\Person.hid");
			if(dir.exists())
			{
				if(f.exists())
				{
					readFromFile();
				}		
				else
				{
					f.createNewFile();
				}
			}
			else
			{
				dir.mkdir();
				f.createNewFile();
			}
			
		
						
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	
	//从文件中读取最近联系人列表
	private void readFromFile()
	{
		try{
				FileReader fr=new FileReader(usrfile);
				BufferedReader br=new BufferedReader(fr);
				String str=br.readLine();
				while(str!=null)
				{
					PersonList.add(str);
					str=br.readLine();
				}
				fr.close();
				br.close();
			
			
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	public ArrayList readFromArrayList()
	{
		return PersonList;
	}
	
	//根据不同情况对列表进行操作
	public void writeToArrayList(String JICQ)
	{
		if(checkInArrayList(JICQ)>=0)
		{
			PersonList.remove(checkInArrayList(JICQ));
			PersonList.add(JICQ);
		}
		else if(checkInArrayList(JICQ)<0 && PersonList.size()<10)
		{
			PersonList.add(JICQ);
		}
		else
		{
			PersonList.remove(0);
			PersonList.add(JICQ);
		}
	}
	
	
	
	
	//检测列表中是否有该号码的好友
	private int checkInArrayList(String JICQ)
	{
		for(int i=0;i<PersonList.size();i++)
		{
			String listJICQ=(String)PersonList.get(i);
			if(listJICQ.equals(JICQ))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void writeToFile()
	{
		try{
			FileWriter fw=new FileWriter(usrfile);
			BufferedWriter bw=new BufferedWriter(fw);
			for(int i=0;i<PersonList.size();i++)
			{
				bw.write((String)PersonList.get(i));
				bw.newLine();
				bw.flush();
			}
			fw.close();
			bw.close();
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	
	
	public void listArrayList()
	{
		for(int i=0;i<PersonList.size();i++)
		{
			System.out.println((String)PersonList.get(i));
		}
	}
	
	
/*	public static void main(String[] args)
	{
		LeastPerson lp=new LeastPerson();
		lp.writeToArrayList("10004");
		lp.writeToArrayList("10005");
		
		lp.listArrayList();
		lp.writeToFile();
	}
*/
}
package pkgJICQ.server.main;

import  java.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.io.*;
import  java.util.*;


public class Chatserverthree implements Runnable
{  
	public static int PORT=7891;   
    protected ServerSocket listen; 
    static Vector connections;
    static Vector groups;
    Thread connect;
    
   public static void main(String args[])
    {  
    	new Chatserverthree();  
        System.out.println("Chat Server is starting!......");   
    } 
  
    public Chatserverthree()
    {  
    	try   
        {     
        	listen=new ServerSocket(PORT);        
        }
        catch(UnknownHostException e2) 
        {  System.err.println("erro:"+e2);   }
        catch(IOException  e)
        {  System.err.println("erro:"+e);   System.exit(1);   }
          
        groups=new Vector(100);
        connections=new Vector(100);   
        connect=new Thread(this);   
        connect.start();       //服务器端线程启动
    }
        
      
    public void run()
    {  
    	try
        {  
        	while(true)   //始终监听来自网络端口的信息
            {   
            	Socket client=listen.accept();

                PersonThread f=new PersonThread(client);
                f.setPriority(Thread.MIN_PRIORITY);  
                f.start();
                
            }
        }
        catch(IOException e)
        {  
        	System.err.println("Erro:"+e);
            System.exit(1);
        }
    }
       

    public static void broadcast(String msg,String hisJICQ)
    {   
    	System.out.println("into ChatServerThree broadcat() method"+msg);
    	int i;    
    	PersonThread you;
        for(i=0;i<connections.size();i++)
        {  
        	you=(PersonThread)Chatserverthree.connections.elementAt(i);
        	if(you.JICQ.equals(hisJICQ))
            	you.send(msg);                   
        }
    }
       
    //与好友交互信息  
    /*  
    public static void broadcast1(String msg)
    {   
    	int i;     
    	String s1,s2,s3;
        PersonThread you;     
        s1=new String("PEOPLE");
        s3=s1.concat(s2);
        for(i=0;i<connections.size();i++)
        {   
        	you=(PersonThread)connections.elementAt(i);
            if(s3.startsWith(you.name))
            {   
            	try
                {       
                	you.out.writeUTF(msg);         
               	}
                catch(IOException  e){} 
                
            }
        }
        
  	}
    */   
        
  }
 
                    	
                                 
                  
                 
               
        
       
         
    
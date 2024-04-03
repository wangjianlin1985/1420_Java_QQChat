package pkgJICQ.server.main;
import javax.swing.*;

public class ServerMain
{
	public static void main(String[] args)
	{
		try{
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
		//ServerPanel serverp=new ServerPanel();
		
		
	}
}
package pkgJICQ.client.frame;

import java.awt.*;

import javax.swing.*;

class MyCursor extends Cursor   
{   
	/**
	 * 
	 */
	private static final long serialVersionUID = 8179820050021675501L;
	static String path = System.getProperty("user.dir");//??user.dir代表了什么呢?
	//获取程序运行所在的根目录
    public MyCursor(int n)
    {   
         super(n);   
    }
    
    public static Cursor GetCursor(String name)   
  	{   
        Toolkit tk=Toolkit.getDefaultToolkit(); 
        Cursor ret=tk.createCustomCursor(new ImageIcon(name).getImage(),new Point(0,0),"Cursor");
        return ret;   
  	}
    public static void main(String[] args){
    	System.out.println(MyCursor.path);
    }
} 

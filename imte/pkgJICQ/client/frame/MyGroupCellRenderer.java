package pkgJICQ.client.frame; 
import java.awt.*; 
import java.io.*;  
import javax.swing.*;   
import javax.swing.tree.DefaultTreeCellRenderer;   
    
class MyGroupCellRenderer extends DefaultTreeCellRenderer
{   
     public MyGroupCellRenderer()
     {
       	//this.setOpenIcon(new ImageIcon(MyCursor.path+"\\picture\\pButton\\friendOpen.gif"));
       	//this.setClosedIcon(new ImageIcon(MyCursor.path+"\\picture\\pButton\\friendClose.gif"));
     }
       
     public Component getTreeCellRendererComponent
	 (JTree tree,Object value, boolean sel, boolean expanded, boolean leaf,int row, boolean hasFocus) 
	 {
	  	super.getTreeCellRendererComponent(tree, value, sel, expanded,leaf, row, hasFocus);
		if(leaf) 
		{
			setIcon(new ImageIcon(MyCursor.path+"\\picture\\pGroups\\myGroup.gif"));
		}
		
		return this;
	 }
		

}
		
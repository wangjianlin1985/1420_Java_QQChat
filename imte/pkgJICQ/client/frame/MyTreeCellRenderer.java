package pkgJICQ.client.frame;
import java.util.StringTokenizer;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

class MyTreeCellRenderer extends DefaultTreeCellRenderer {
	public MyTreeCellRenderer() {
		this.setOpenIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pButton\\friendOpen.gif"));
		this.setClosedIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pButton\\friendClose.gif"));
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		if (leaf) {
			setIcon(getLengthIcon(value.toString()));
		}
		// else
		// {
		// setIcon(new
		// ImageIcon(MyCursor.path+"\\picture\\pButton\\friendOpen.gif"));
		// }

		return this;
	}

	protected Icon getLengthIcon(String value) {
		ImageIcon ii;

		try {

			String picID = "";
			StringTokenizer stk = new StringTokenizer(value, "(");

			String name = (String) stk.nextElement();
			name = (String) stk.nextElement();
			stk = new StringTokenizer(name, ")");
			String ID = (String) stk.nextElement();
			int online = 0;
			for (int i = 0; i < MyPersonTree.alist.size(); i++) {
				Person p = (Person) MyPersonTree.alist.get(i);
				if (ID.equals(p.getID())) {
					picID = p.getpicID();
					if (p.getStatus() == 3)
						online = 3;
					else if (p.getStatus() == 2)
						online = 2;
					else
						online = 0;
					break;
				}
			}
			if (online == 3)
				ii = new ImageIcon(MyCursor.path + "\\picture\\pHead\\" + picID
						+ ".gif");
			else if (online == 2)
				ii = new ImageIcon(MyCursor.path + "\\picture\\pHead\\pLeft\\"
						+ picID + ".gif");
			else
				ii = new ImageIcon(MyCursor.path
						+ "\\picture\\pHead\\pUnOnline\\" + picID + ".gif");

			if (new File(
					(MyCursor.path + "\\picture\\pHead\\" + picID + ".gif"))
					.isFile() == false
					&& new File((MyCursor.path
							+ "\\picture\\pHead\\pUnOnline\\" + picID + ".gif"))
							.isFile() == false)
				// ii = new
				// ImageIcon(MyCursor.path+"\\picture\\pHead\\default.gif");
				ii = new ImageIcon(MyCursor.path
						+ "\\picture\\pButton\\friendClose.gif");
		} catch (Exception ex) {
			ex.toString();
			return new ImageIcon(MyCursor.path
					+ "\\picture\\pButton\\friendClose.gif");
		}
		return ii;
	}
}

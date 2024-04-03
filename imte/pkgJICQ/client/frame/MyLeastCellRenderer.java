package pkgJICQ.client.frame;

import java.util.StringTokenizer;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

class MyLeastCellRenderer extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		if (leaf) {
			setIcon(getLengthIcon(value.toString()));
		}

		return this;
	}

	protected Icon getLengthIcon(String value) {
		ImageIcon ii = null;

		try {

			String picID = "";
			StringTokenizer stk = new StringTokenizer(value, "(");

			String name = (String) stk.nextElement();
			name = (String) stk.nextElement();
			stk = new StringTokenizer(name, ")");
			String ID = (String) stk.nextElement();
			for (int i = 0; i < MyPersonTree.alist.size(); i++) {
				Person p = (Person) MyPersonTree.alist.get(i);
				if (ID.equals(p.getID())) {
					picID = p.getpicID();
					break;
				}
			}
			ii = new ImageIcon(MyCursor.path + "\\picture\\pHead\\" + picID
					+ ".gif");

		} catch (Exception ex) {
			ex.toString();
		}
		return ii;
	}
}

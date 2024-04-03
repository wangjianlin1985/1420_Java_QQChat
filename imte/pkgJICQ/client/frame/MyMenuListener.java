package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

class MyMenuListener implements ActionListener {
	MyListFrame lf;

	public MyMenuListener(MyListFrame lf) {
		this.lf = lf;
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem jMenu = (JMenuItem) e.getSource();
		if (jMenu == lf.showPerson)
			new UsersDetail().setAllDetail(new Friends()
					.selectAllDetail(MyPersonTree.myJICQ));
		else if (jMenu == lf.addGroup) {

			String str = JOptionPane
					.showInputDialog(lf, "请输入要添加的用户组名称:", "新组名");
			if (str != null && str != "" && validate(str, '<') == true)
				lf.pTree.client.send("ADDGROUP#" + MyPersonTree.myJICQ + "#"
						+ str);

		} else if (jMenu == lf.delGroup) {
			try {
				DefaultMutableTreeNode selectTreeNode = (DefaultMutableTreeNode) lf.pTree.jtr
						.getSelectionPath().getLastPathComponent();
				if (selectTreeNode != null && selectTreeNode.getLevel() == 1) {
					String NodeNames = (String) selectTreeNode.getUserObject();
					java.util.StringTokenizer stk = new java.util.StringTokenizer(
							NodeNames, "<");
					String GroupName = (String) stk.nextElement();
					if (GroupName != null && GroupName != "") {
						String str = JOptionPane.showInputDialog(lf,
								"请输入要删除的用户组名称:", GroupName);
						if (str != null && str != "")
							lf.pTree.client.send("DELGROUP#"
									+ MyPersonTree.myJICQ + "#" + str);
					}

				}
			} catch (Exception ex) {
				return;
			}

		} else if (jMenu == lf.delFriend) {
			try {
				DefaultMutableTreeNode selectTreeNode = (DefaultMutableTreeNode) lf.pTree.jtr
						.getSelectionPath().getLastPathComponent();
				if (selectTreeNode != null && selectTreeNode.getLevel() == 2) {
					Person pNode = (Person) selectTreeNode.getUserObject();
					// java.util.StringTokenizer stk=new
					// java.util.StringTokenizer(NodeNames,"<");
					String JICQ = (String) pNode.getID();
					// String GroupName=(String)stk.nextElement();
					if (JICQ != null && JICQ != "") {
						String hisJICQ = JOptionPane.showInputDialog(lf,
								"请输入要删除用户的JICQ号码:", JICQ);
						if (hisJICQ != null && hisJICQ != "")
							lf.pTree.client.send("DELFRIEND#"
									+ MyPersonTree.myJICQ + "#" + hisJICQ);
					}

				}
			} catch (Exception ex) {
				return;
			}
		}

		else if (jMenu == lf.onlineMenu) {
			if (MyPersonTree.myValue.getStatus() != 3) {
				lf.pTree.client.send("STATUS#" + MyPersonTree.myJICQ + "#3");
			}
		} else if (jMenu == lf.leftMenu) {
			if (MyPersonTree.myValue.getStatus() != 2) {
				lf.pTree.client.send("STATUS#" + MyPersonTree.myJICQ + "#2");
			}
		} else if (jMenu == lf.hideToMenu) {
			if (MyPersonTree.myValue.getStatus() != 1) {
				lf.pTree.client.send("STATUS#" + MyPersonTree.myJICQ + "#1");
			}
		}

		else if (jMenu == lf.optionMenu) {
			new UserUpdate().setAllDetail(new Friends()
					.selectAllDetail(MyPersonTree.myJICQ));
		}

		// 主要菜单
		else if (jMenu == lf.numMenu) {
			try {
				Runtime rt = Runtime.getRuntime();
				String file = "C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE"+" http://127.0.0.1:8080/zhuce/firsts.htm";
				rt.exec(file);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (jMenu == lf.myDetailMenu) {
			new UserUpdate().setAllDetail(new Friends()
					.selectAllDetail(MyPersonTree.myJICQ));
		} else if (jMenu == lf.pwdMenu) {
			try {
				Runtime rt = Runtime.getRuntime();
				String file = "C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE"+" http://127.0.0.1:8080/zhuce/JICQServerIndex.jsp";
				rt.exec(file);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public boolean validate(String stk, char c) {
		for (int i = 0; i < stk.length(); i++) {
			if (stk.charAt(i) == c) {
				return false;
			}
		}
		return true;
	}

}

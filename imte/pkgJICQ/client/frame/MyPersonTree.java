package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyPersonTree {
	JTree jtr = null;

	DefaultTreeModel defTreeModel = null;

	MyShowPanel msPanel = new MyShowPanel();//??

	public static String myJICQ = null;

	static MyValue myValue = null;//

	public static java.util.ArrayList alist = new java.util.ArrayList();//存放用户的相关信息

	public static java.util.Vector vector = new java.util.Vector(20);//存放打开的个人聊天窗口的相关信息

	public static java.util.Vector UnKonwVector = new java.util.Vector(20);//存放陌生人的聊天窗口的相关信息

	DefaultMutableTreeNode root, trFriend, trRelation, trUnKnow, trBlack;//不变的结点，默认的

	MyListFrame mlf;//

	Client client;

	public MyPersonTree(MyListFrame mlf) {
		System.out.println("into MyPersonTree%%%");
		jtr = new JTree();
		this.mlf = mlf;

		root = new DefaultMutableTreeNode();

	}

	public void createItem() // 创建好友类型列表
	{
		try {
			System.out.println("into MyPersonTree%%% createItem()method");
			int fcount = 0;
			Friends f = new Friends();
			ResultSet rsTypes = f.selectFriendTypes(myJICQ);//好友分类
			ResultSet rsCount = f.selectFriendCounts(myJICQ);
			ResultSet rsFriends = f.selectFriends(myJICQ);

			MyPersonTree.alist.clear(); // 清空列表内容
			root.removeAllChildren();

			while (rsTypes.next()) {//好友类型

				fcount = 0;
				while (rsCount.next()) {//好友数量

					if (rsTypes.getInt("JFriendTypeID") == rsCount
							.getInt("JFriendTypeID"))
						fcount = rsCount.getInt("JFriendCount");
				}
				trFriend = new DefaultMutableTreeNode(rsTypes
						.getString("JFriendTypeName")
						+ "<" + fcount + ">");//创建好友分类结点

				while (rsFriends.next()) {

					if (fcount != 0
							&& rsTypes.getInt("JFriendTypeID") == rsFriends
									.getInt("JFriendTypeID")) {
						String ID = rsFriends.getString("JFriendID");
						int friendType = rsFriends.getInt("JFriendTypeID");
						String name = rsFriends.getString("JShowName");
						int status = rsFriends.getInt("JStatus");
						String IP = rsFriends.getString("JUserIP");
						String picID = rsFriends.getString("JPICID");
						String showID = rsFriends.getString("JICQShowID");
						String underWrite = rsFriends.getString("JUnderWrite");

						Person p = new Person(ID, name, picID, underWrite,
								friendType, IP, showID, status);
						alist.add(p);
						DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
								p);
						trFriend.add(newNode);//在相应的好于组下添加用户结点

						System.out.println(name + "=" + friendType);
					}
				}

				root.add(trFriend);//在根结点下添加好友分组结点

				rsCount.first();
				rsFriends.first();
				rsCount.previous();
				rsFriends.previous();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void listPersonTree() // 刷新树信息
	{
		System.out.println("into MyPersonTree%%% listPersonTree() method");
		createItem();
		//此时的root
		defTreeModel = new DefaultTreeModel(root);

		jtr.setModel(defTreeModel);//设置将提供数据的 TreeModel
		jtr.setRootVisible(false);
		jtr.setRowHeight(57);
		jtr.repaint();
	}

	public JTree createPersonTree() {
		try {
			System.out.println("into MyPersonTree%%% createPersonTree");

			listPersonTree(); // 刷新树信息(重新生成新的树信息)
			
			jtr.addMouseMotionListener(new MouseMotionListener() {
				public void mouseMoved(MouseEvent e) {
					getToolTipText(e);
				}

				public void mouseDragged(MouseEvent e) {

				}
			});

			jtr.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					msPanel.setVisible(false);
				}

				public void mouseEntered(MouseEvent e) {

				}
			});

			// 节点双击事件,打开聊天窗口,如果对应的聊天窗口已经打开则不打开新窗口
			jtr.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						TreePath path = jtr.getPathForLocation(e.getX(), e
								.getY());
						if (path == null) {
							return;
						} else if (e.getClickCount() == 2) {
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
									.getLastPathComponent();//取得最深层的节点
							Person p = (Person) node.getUserObject();
							int isExistFrame = 0;
							for (int i = 0; i < vector.size(); i++) {
								JICQChatFrame jchatExist = (JICQChatFrame) vector
										.get(i);
								if (jchatExist.name.equals(p.getname())) {
									isExistFrame = 1;
									break;
								}
							}
							if (isExistFrame == 0) {

								JICQChatFrame jchat = new JICQChatFrame(p,
										client);
								vector.addElement(jchat);
							}

						}
					} catch (Exception ex) {
						return;
					}

				}
			});

			jtr.setCellRenderer(new MyTreeCellRenderer());
			jtr.setShowsRootHandles(true);
			jtr.putClientProperty("JTree.lineStyle", "Horizontal");
			ToolTipManager.sharedInstance().registerComponent(jtr);
			createMyPerson(myJICQ);//初始化自己的个人基本信息

			client = new Client(this);
			//与服务器简历连接 用来发送和接受消息等操作
			// Thread tt = new Thread(client);
			// System.out.println("*()))))))))))))))))))))))");
			// 登陆时候更新我的信息
			MyDetails mydata = new MyDetails();
			//更新个人的信息 主要是IP地址
			mydata.updateOnline(myJICQ, client.socket.getInetAddress()
					.getHostAddress(), 3);// 3代表上线
		System.out.println("client.socket.getInetAddress().getHostAddress()@@"+client.socket.getInetAddress().getHostAddress());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jtr;
	}

	private String getToolTipText(MouseEvent e) {
		try {
			TreePath path = jtr.getPathForLocation(e.getX(), e.getY());
			if (path == null) {
				msPanel.setVisible(false);
				return null;
			}
			msPanel.setVisible(false);
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			Person p = (Person) node.getUserObject();

			int startX = (int) (e.getX() + mlf.getLocationOnScreen().getX() + 150);
			int startY = (int) (e.getY() + mlf.getLocationOnScreen().getY() + 100);
			if (startX + 200 > 1000)
				msPanel.setBounds(
						(int) (mlf.getLocationOnScreen().getX()) - 240, startY,
						243, 167);
			else
				msPanel.setBounds(startX, startY, 243, 167);
			msPanel.setDetail(p.getpicID(), p.getname(), p.getID(), p.getIP(),
					p.getUnderWrite(), p.getStatus());
			msPanel.setVisible(true);

			return p.getname();
		} catch (Exception ex) {
			return null;
		}

	}

    //个人基本信息的初始化
	public void createMyPerson(String JICQ) {
		try {
			System.out.println("into MyPersonTree%%% createMyPerson");
			MyDetails mydata = new MyDetails();
			ResultSet rs = mydata.selectMyDetail(JICQ);
			rs.next();
			String ID = rs.getString("JICQ");
			String name = rs.getString("JShowName");
			int status = rs.getInt("JStatus");
			String IP = rs.getString("JUserIP");
			String picID = rs.getString("JPicID");

			String showID = rs.getString("JICQShowID");
			String underWrite = rs.getString("JUnderWrite");

			myValue = new MyValue(ID, name, picID, underWrite, IP, showID,
					status);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

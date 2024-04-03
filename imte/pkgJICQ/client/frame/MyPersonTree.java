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

	public static java.util.ArrayList alist = new java.util.ArrayList();//����û��������Ϣ

	public static java.util.Vector vector = new java.util.Vector(20);//��Ŵ򿪵ĸ������촰�ڵ������Ϣ

	public static java.util.Vector UnKonwVector = new java.util.Vector(20);//���İ���˵����촰�ڵ������Ϣ

	DefaultMutableTreeNode root, trFriend, trRelation, trUnKnow, trBlack;//����Ľ�㣬Ĭ�ϵ�

	MyListFrame mlf;//

	Client client;

	public MyPersonTree(MyListFrame mlf) {
		System.out.println("into MyPersonTree%%%");
		jtr = new JTree();
		this.mlf = mlf;

		root = new DefaultMutableTreeNode();

	}

	public void createItem() // �������������б�
	{
		try {
			System.out.println("into MyPersonTree%%% createItem()method");
			int fcount = 0;
			Friends f = new Friends();
			ResultSet rsTypes = f.selectFriendTypes(myJICQ);//���ѷ���
			ResultSet rsCount = f.selectFriendCounts(myJICQ);
			ResultSet rsFriends = f.selectFriends(myJICQ);

			MyPersonTree.alist.clear(); // ����б�����
			root.removeAllChildren();

			while (rsTypes.next()) {//��������

				fcount = 0;
				while (rsCount.next()) {//��������

					if (rsTypes.getInt("JFriendTypeID") == rsCount
							.getInt("JFriendTypeID"))
						fcount = rsCount.getInt("JFriendCount");
				}
				trFriend = new DefaultMutableTreeNode(rsTypes
						.getString("JFriendTypeName")
						+ "<" + fcount + ">");//�������ѷ�����

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
						trFriend.add(newNode);//����Ӧ�ĺ�����������û����

						System.out.println(name + "=" + friendType);
					}
				}

				root.add(trFriend);//�ڸ��������Ӻ��ѷ�����

				rsCount.first();
				rsFriends.first();
				rsCount.previous();
				rsFriends.previous();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void listPersonTree() // ˢ������Ϣ
	{
		System.out.println("into MyPersonTree%%% listPersonTree() method");
		createItem();
		//��ʱ��root
		defTreeModel = new DefaultTreeModel(root);

		jtr.setModel(defTreeModel);//���ý��ṩ���ݵ� TreeModel
		jtr.setRootVisible(false);
		jtr.setRowHeight(57);
		jtr.repaint();
	}

	public JTree createPersonTree() {
		try {
			System.out.println("into MyPersonTree%%% createPersonTree");

			listPersonTree(); // ˢ������Ϣ(���������µ�����Ϣ)
			
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

			// �ڵ�˫���¼�,�����촰��,�����Ӧ�����촰���Ѿ����򲻴��´���
			jtr.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					try {
						TreePath path = jtr.getPathForLocation(e.getX(), e
								.getY());
						if (path == null) {
							return;
						} else if (e.getClickCount() == 2) {
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
									.getLastPathComponent();//ȡ�������Ľڵ�
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
			createMyPerson(myJICQ);//��ʼ���Լ��ĸ��˻�����Ϣ

			client = new Client(this);
			//��������������� �������ͺͽ�����Ϣ�Ȳ���
			// Thread tt = new Thread(client);
			// System.out.println("*()))))))))))))))))))))))");
			// ��½ʱ������ҵ���Ϣ
			MyDetails mydata = new MyDetails();
			//���¸��˵���Ϣ ��Ҫ��IP��ַ
			mydata.updateOnline(myJICQ, client.socket.getInetAddress()
					.getHostAddress(), 3);// 3��������
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

    //���˻�����Ϣ�ĳ�ʼ��
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

package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class GroupChatFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3474389878383737285L;

	JPanel contentPane;

	BorderLayout borderLayout1 = new BorderLayout();

	JTabbedPane jTabbedPane1 = new JTabbedPane();//？？？

	JPanel jPanel1 = new JPanel();

	XYLayout xYLayout1 = new XYLayout();

	JPanel jPanel2 = new JPanel();

	XYLayout xYLayout2 = new XYLayout();

	JScrollPane jScrollPane1 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JPanel jPanel3 = new JPanel();

	JButton btChatContent = new JButton();

	JButton btClose = new JButton();

	JButton btSend = new JButton();

	JScrollPane jScrollPane2 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JLabel jLabel1 = new JLabel();

	JTextArea taBoard = new JTextArea();

	JTree jtrPerson = null;

	JTextPane tpMessage = new JTextPane();

	XYLayout xYLayout3 = new XYLayout();

	JLabel lbFont = new JLabel();

	JLabel lbFace = new JLabel();

	JLabel lbGroupName = new JLabel();

	JLabel lbGroupKind = new JLabel();

	JButton btOption = new JButton();

	JTextPane tpContent = new JTextPane();

	JScrollPane jScrollPane3 = new JScrollPane(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	MyGroup myGroup;

	Client client;

	public static int GroupID;

	// Construct the frame
	public GroupChatFrame(MyGroup myGroup, Client client) {
		this.myGroup = myGroup;
		this.client = client;
		GroupID = myGroup.getGroupID();

		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);

		jPanel1.setLayout(xYLayout1);

		jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 12));
		jPanel2.setLayout(xYLayout2);
		jPanel2.setBackground(Color.white);
		jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
		// jPanel1.setBackground(SystemColor.activeCaptionBorder);
		jPanel1.setFont(new java.awt.Font("Dialog", 0, 12));
		jPanel1.setAlignmentY((float) 0.5);
		jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
		jPanel1.setDebugGraphicsOptions(0);
		jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
		jPanel3.setLayout(xYLayout3);
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		btChatContent.setFont(new java.awt.Font("Dialog", 0, 12));
		btChatContent.setText("聊天记录");
		btClose.setFont(new java.awt.Font("Dialog", 0, 12));
		btClose.setText("关闭");
		btClose.addActionListener(this);
		btSend.setFont(new java.awt.Font("Dialog", 0, 12));
		btSend.setText("发送");
		btSend.addActionListener(this);
		jScrollPane2.setBorder(BorderFactory.createEtchedBorder());
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel1.setBorder(BorderFactory.createEtchedBorder());
		jLabel1.setText("群公告：");
		taBoard.setBorder(BorderFactory.createLoweredBevelBorder());
		taBoard.setEditable(false);
		btOption.addActionListener(this);

		// 生成树
		DefaultMutableTreeNode root, newNode;
		DefaultTreeModel defTreeModel = null;
		root = new DefaultMutableTreeNode("群的所有成员");
		defTreeModel = new DefaultTreeModel(root);

		java.sql.ResultSet rs = new GroupDetail().selectAllPerson(String
				.valueOf(GroupID));
		while (rs.next()) {
			int JICQ = rs.getInt("JICQ");
			String JGroupName = rs.getString("JGroupName");

			newNode = new DefaultMutableTreeNode(JGroupName + "(" + JICQ + ")");
			root.add(newNode);
		}

		jtrPerson = new JTree(root);
		jtrPerson.setBorder(BorderFactory.createLoweredBevelBorder());
		jtrPerson.setModel(defTreeModel);
		jtrPerson.setRowHeight(20);
		jtrPerson.setRootVisible(false);
		jtrPerson.putClientProperty("JTree.lineStyle", "Horizontal");
		jtrPerson.repaint();

		tpMessage.setFont(new java.awt.Font("Dialog", 0, 12));

		lbGroupName.setBackground(Color.white);
		lbGroupName.setEnabled(true);
		lbGroupName.setFont(new java.awt.Font("Dialog", 0, 15));
		lbGroupName.setForeground(SystemColor.windowText);
		lbGroupName.setBorder(BorderFactory.createEtchedBorder());

		lbGroupKind.setBackground(Color.white);
		lbGroupKind.setFont(new java.awt.Font("Dialog", 0, 12));
		lbGroupKind.setBorder(BorderFactory.createEtchedBorder());

		btOption.setFont(new java.awt.Font("Dialog", 0, 12));
		btOption.setBorder(BorderFactory.createEtchedBorder());
		btOption.setText("群资料设置");
		tpContent.setBorder(BorderFactory.createLoweredBevelBorder());
		tpContent.setEditable(false);
		contentPane.add(jTabbedPane1, BorderLayout.CENTER);
		jTabbedPane1.add(jPanel1, "群聊");
		jPanel1.add(jScrollPane1, new XYConstraints(4, 38, 349, 246));
		jScrollPane1.getViewport().add(tpContent, null);
		jPanel1.add(jPanel3, new XYConstraints(4, 286, 349, 29));
		jPanel3.add(lbFont, new XYConstraints(10, 2, 29, 26));
		jPanel3.add(lbFace, new XYConstraints(40, 2, 29, 26));
		jPanel1.add(jScrollPane2, new XYConstraints(5, 318, 349, 70));
		jScrollPane2.getViewport().add(tpMessage, null);
		jPanel1.add(jLabel1, new XYConstraints(360, 6, 138, 28));
		JScrollPane jScrollPane4 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane4.getViewport().add(taBoard, null);
		taBoard.setLineWrap(true);
		jPanel1.add(jScrollPane4, new XYConstraints(361, 39, 137, 117));
		jPanel1.add(btClose, new XYConstraints(165, 397, 82, 23));
		jPanel1.add(btSend, new XYConstraints(273, 398, 82, 23));
		jPanel1.add(btChatContent, new XYConstraints(5, 396, 92, 25));
		jPanel1.add(lbGroupName, new XYConstraints(4, 4, 205, 28));
		jPanel1.add(lbGroupKind, new XYConstraints(210, 5, 138, 26));
		jPanel1.add(btOption, new XYConstraints(362, 160, 136, 28));
		jPanel1.add(jScrollPane3, new XYConstraints(362, 194, 137, 227));
		jScrollPane3.getViewport().add(jtrPerson, null);
		jTabbedPane1.add(jPanel2, "BBS公告板");

		this.lbGroupKind.setText("JICQ群类型:" + myGroup.getGroupType());
		this.lbGroupName.setText("JICQ群名称:" + myGroup.getGroupName());
		this.taBoard.setText("    " + myGroup.GroupBcast());
		this.lbFont.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\font.gif"));
		this.lbFace.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\face.gif"));

		this.setResizable(false);
		this.setSize(new Dimension(518, 496));
		this.setTitle("JICQ群--" + this.myGroup.getGroupName() + "("
				+ this.GroupID + ")");
		this.setVisible(true);
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			removeFromGroupVector();
			this.dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btClose) {
			removeFromGroupVector();
			this.dispose();
		}
		if (e.getSource() == btSend) {
			java.util.Date now = new java.util.Date();
			String nowTime = now.getHours() + ":" + now.getMinutes() + ":"
					+ now.getSeconds();
			String msg = this.tpMessage.getText() + "\n\n";
			String headmsg = MyPersonTree.myValue.getname() + "("
					+ MyPersonTree.myJICQ + ") " + nowTime + "\n";
			client.send("MSGGROUP#" + this.GroupID + "#" + MyPersonTree.myJICQ
					+ "#" + headmsg + "#" + msg); // MSGGROUP+GroupID+MYJICQ+headmsg+msg
		}
		if (e.getSource() == btOption) {
			GroupFrame groupframe = new GroupFrame();
			groupframe.ShowGroup(new GroupDetail().selectSingleGroup(String
					.valueOf(GroupID)));
		}

	}

	public void removeFromGroupVector() {
		GroupChatFrame jchat = null;
		for (int i = 0; i < MyListFrame.GroupVector.size(); i++) {
			jchat = (GroupChatFrame) MyListFrame.GroupVector.get(i);
			if (jchat.GroupID == this.GroupID) {
				MyListFrame.GroupVector.remove(i);
				break;
			}
			jchat = null;
		}
	}

	// 显示聊天信息
	public void setMessage(String headmsg, String msg) {
		this.tpContent.setText(tpContent.getText() + " " + headmsg);
		this.tpContent.setText(tpContent.getText() + " " + msg);

		new PlayMusic().gomsg();

	}

}

package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import javax.swing.border.*;

public class JICQChatFrame extends JFrame implements ActionListener {
	public String name = "";

	public String JICQ = "";

	JPanel contentPane;

	MessageWindow mwin = null;//信息显示窗口

	JScrollBar jbar;

	XYLayout xYLayout1 = new XYLayout();

	JTextPane tpContent = new JTextPane();

	JTextPane tpMessage = new JTextPane();

	JButton btChatContent = new JButton();

	JButton btChatMedal = new JButton();

	JButton btClose = new JButton();

	JButton btSend = new JButton();

	JButton btHisShow = new JButton();

	JButton btMyShow = new JButton();

	TitledBorder titledBorder1;

	TitledBorder titledBorder2;

	TitledBorder titledBorder3;

	TitledBorder titledBorder4;

	JLabel lbImage = new JLabel();

	TitledBorder titledBorder5;

	JPanel jPanel1 = new JPanel();

	XYLayout xYLayout2 = new XYLayout();

	TitledBorder titledBorder6;

	TitledBorder titledBorder7;

	JLabel lbIP = new JLabel();

	JLabel lbVersion = new JLabel();

	Border border1;

	JLabel lbHisShow = new JLabel();

	JLabel lbMyShow = new JLabel();

	//JLabel lbVideo = new JLabel();

  // JLabel lbAudio = new JLabel();

	// JLabel lbGame = new JLabel();

	// JLabel lbFont = new JLabel();

	// JLabel lbFace = new JLabel();

	JEditorPane lbUnderWrite = new JEditorPane();

	// Construct the frame
	Person p;

	Client client;

	public JICQChatFrame(Person p, Client client) {
		this.p = p;
		this.client = client;

		// enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JICQChatFrame() {
		// TODO 自动生成构造函数存根
	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		titledBorder5 = new TitledBorder("");
		titledBorder6 = new TitledBorder("");
		titledBorder7 = new TitledBorder("");
		border1 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		contentPane.setLayout(xYLayout1);

		btChatContent.setFont(new java.awt.Font("Dialog", 0, 12));
		btChatContent.setIcon(null);
		btChatContent.setText("聊天记录");
		btChatContent.addActionListener(this);
		btChatMedal.setFont(new java.awt.Font("Dialog", 0, 12));
		btChatMedal.setFocusPainted(true);
		btChatMedal.setText("消息模式");
		btClose.setFont(new java.awt.Font("Dialog", 0, 12));
		btClose.setText("关闭");
		btClose.addActionListener(this);
		btSend.setFont(new java.awt.Font("Dialog", 0, 12));
		btSend.addActionListener(this);
		btSend.setText("发送");

		// 按下回车键
		tpMessage.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					SendMessage();
				}
			}
		});
		tpMessage.setBorder(BorderFactory.createLineBorder(Color.black));
		tpMessage.setText("");
		tpContent.setBorder(BorderFactory.createLineBorder(Color.black));
		tpContent.setText("");
		btHisShow.setFont(new java.awt.Font("Dialog", 0, 12));
		btHisShow.setBorder(null);
		btHisShow.setText("对方形象");
		btHisShow.setBorder(BorderFactory.createLineBorder(Color.black));
		btMyShow.setFont(new java.awt.Font("Dialog", 0, 12));
		btMyShow.setForeground(Color.black);
		btMyShow.setBorder(null);
		btMyShow.setText("MyJICQ秀");
		btMyShow.setBorder(BorderFactory.createLineBorder(Color.black));

		/*lbFont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new ScreenCapture();
			}
		});*/

		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setFont(new java.awt.Font("Dialog", 0, 12));
		contentPane.setAlignmentX((float) 0.5);
		contentPane.setBorder(BorderFactory.createLineBorder(Color.black));

		lbImage.setBackground(new Color(241, 239, 226));
		lbImage.setBorder(BorderFactory.createLineBorder(Color.black));
		lbImage.setText("");
		lbImage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					UsersDetail ud = new UsersDetail();
					ud.setAllDetail(new Friends().selectAllDetail(JICQ));
				}

			}
		});

		lbImage.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pHead\\pSmall\\1000.gif"));
		jPanel1.setBorder(null);
		jPanel1.setDebugGraphicsOptions(0);
		jPanel1.setDoubleBuffered(true);
		jPanel1.setMaximumSize(new Dimension(32767, 32767));
		jPanel1.setLayout(xYLayout2);
		lbIP.setFont(new java.awt.Font("Dialog", 0, 12));
		lbIP.setToolTipText("");
		lbIP.setText("对方IP:192.168.1.126");
		lbVersion.setFont(new java.awt.Font("Dialog", 0, 12));
		lbVersion.setToolTipText("");
		lbVersion.setText("版本号:<JICQ2023 Beta2 SP3>");
		lbHisShow.setBackground(Color.white);
		lbHisShow.setBorder(BorderFactory.createLineBorder(Color.black));
		lbHisShow.setText("lbHisShow");
		lbHisShow.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pShow\\HisShow.gif"));
		lbHisShow.addMouseListener(new JICQChatFrame_lbHisShow_mouseAdapter(
				this));
		lbMyShow.setBackground(Color.white);
		lbMyShow.setBorder(BorderFactory.createLineBorder(Color.black));
		lbMyShow.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pShow\\MyShow.gif"));
		lbMyShow.setText("lbMyShow");
		/*lbVideo.setEnabled(true);
		lbVideo.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\video.gif"));
		lbVideo.setFont(new java.awt.Font("Dialog", 0, 15));
		// lbVideo.setBorder(BorderFactory.createLineBorder(Color.black));
		lbVideo.setRequestFocusEnabled(true);
		lbVideo.setText("视频");
		lbVideo.setBorder(BorderFactory.createLineBorder(Color.black));
		lbVideo.addMouseListener(new JICQChatFrame_lbVideo_mouseAdapter(this));

		lbAudio.setText("游戏");
		lbAudio.setBorder(BorderFactory.createLineBorder(Color.black));
		lbAudio.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\game.gif"));
		lbAudio.setFont(new java.awt.Font("Dialog", 0, 15));
		// lbAudio.setBorder(BorderFactory.createLineBorder(Color.black));

		lbGame.setText("语音");
		lbGame.setBorder(BorderFactory.createLineBorder(Color.black));
		lbGame.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\audio.gif"));
		lbGame.setFont(new java.awt.Font("Dialog", 0, 15));
		// lbGame.setBorder(BorderFactory.createLineBorder(Color.black));
		// lbFont.setBorder(BorderFactory.createLineBorder(Color.black));
		lbFont.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\font.gif"));
		lbFont.setText("");
		// lbFace.setBorder(BorderFactory.createLineBorder(Color.black));
		lbFace.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\face.gif"));
		lbFace.setText("");*/

		lbUnderWrite.setBackground(Color.white);
		lbUnderWrite.setForeground(Color.black);
		lbUnderWrite.setEditable(false);
		JScrollPane jScrollPane2 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// jScrollPane2.setBorder(BorderFactory.createLineBorder(Color.black));
		jScrollPane2.getViewport().add(tpContent, null);
		jbar = jScrollPane2.getVerticalScrollBar();

		JScrollPane jScrollPane3 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
		jScrollPane3.getViewport().add(tpMessage, null);

		contentPane.add(jScrollPane2, new XYConstraints(10, 84, 308, 228));
		contentPane.add(jScrollPane3, new XYConstraints(9, 338, 308, 63));
		contentPane.add(btClose, new XYConstraints(193, 408, -1, 22));
		contentPane.add(btSend, new XYConstraints(260, 408, -1, 22));
		contentPane.add(btChatMedal, new XYConstraints(95, 408, 84, 22));
		contentPane.add(btChatContent, new XYConstraints(6, 408, -1, 22));
		contentPane.add(jPanel1, new XYConstraints(6, 7, 452, 37));
		jPanel1.add(lbIP, new XYConstraints(245, 1, 207, -1));
		jPanel1.add(lbVersion, new XYConstraints(245, 19, 209, 19));
		//jPanel1.add(lbGame, new XYConstraints(4, 1, 36, 36));
		//jPanel1.add(lbVideo, new XYConstraints(51, 1, 36, 36));
		//jPanel1.add(lbAudio, new XYConstraints(97, 1, 36, 36));
		contentPane.add(lbHisShow, new XYConstraints(327, 68, 127, 160));
		contentPane.add(btHisShow, new XYConstraints(326, 48, 130, 20));
		contentPane.add(lbMyShow, new XYConstraints(327, 270, 127, 160));
		contentPane.add(btMyShow, new XYConstraints(326, 250, 130, 20));

		JScrollPane jScrollPane1 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
		jScrollPane1.getViewport().add(lbUnderWrite, null);

		contentPane.add(jScrollPane1, new XYConstraints(50, 47, 268, 35));
		contentPane.add(lbImage, new XYConstraints(10, 47, 38, 35));
		//contentPane.add(lbFont, new XYConstraints(10, 313, 29, 26));
		//contentPane.add(lbFace, new XYConstraints(40, 313, 29, 26));

		/*
		 * this.getOwner().addMouseMotionListener(new MouseMotionListener() {
		 * public void mouseDragged(MouseEvent e) { int
		 * x=(int)getLocationOnScreen().getX(); int
		 * y=(int)(getLocationOnScreen().getY()+getSize().height);
		 * if(mwin!=null) mwin.setBounds(x,y, 473, 120); System.out.println(x+"
		 * "+y); } public void mouseMoved(MouseEvent e){} });
		 */

		this.addComponentListener(new ComponentAdapter() {
			public void componentMoved(ComponentEvent e) {
				int x = (int) getLocationOnScreen().getX();
				int y = (int) (getLocationOnScreen().getY() + getSize().height);
				if (mwin != null)
					mwin.setBounds(x, y, 471, 120);
			}
		});
/*
		lbAudio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				new AudioFrame(p.getIP());

			}
		});*/

		setFriendDetail();// 初始化界面
		this.setResizable(false);
		this.setBounds(200, 150, 471, 470);
		setIconImage(new ImageIcon(MyCursor.path
				+ "\\picture\\pLogin\\chat.gif").getImage());
		this.setSize(new Dimension(471, 470));
		this.setVisible(true);

	}

	public void setFriendDetail() {
		this.name = p.getname();
		this.JICQ = p.getID();
		this.lbImage.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pHead\\pSmall\\" + p.getpicID() + ".gif"));
		this.lbUnderWrite.setText(p.getname() + "(" + p.getID() + ")"
				+ p.getUnderWrite());
		this.lbHisShow.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pShow\\" + p.getShowID() + ".gif"));
		this.lbMyShow.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pShow\\" + MyPersonTree.myValue.getShowID()
				+ ".gif"));
		this.lbIP.setText("对方IP:" + p.getIP());
		this.setTitle("和" + p.getname() + "(" + p.getID() + ")聊天中");

	}

	// Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			for (int i = 0; i < MyPersonTree.vector.size(); i++) {
				JICQChatFrame jchatExist = (JICQChatFrame) MyPersonTree.vector
						.get(i);
				if (jchatExist.name.equals(p.getname())) {
					MyPersonTree.vector.remove(i);
					this.dispose();
					break;
				}
			}
			for (int i = 0; i < MyPersonTree.UnKonwVector.size(); i++) {
				JICQChatFrame jchatUnKonwExist = (JICQChatFrame) MyPersonTree.UnKonwVector
						.get(i);//
				if (jchatUnKonwExist.JICQ.equals(p.getID())) {
					MyPersonTree.UnKonwVector.remove(i);
					this.dispose();
					break;
				}
			}

			String chatcontent = tpContent.getText();
			if (chatcontent != "") {
				ChatRecord cr = new ChatRecord(MyPersonTree.myJICQ, this.JICQ);
				cr.writeChatContent(chatcontent);
			}
			if (mwin != null)
				mwin.dispose();

		}

	}

	void lbHisShow_mouseClicked(MouseEvent e) {

	}

	void lbVideo_mouseClicked(MouseEvent e) {
		this.lbHisShow.setText("");
	}

	// 聊天窗口关闭事件,从向量中移除已经打开的窗口
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btClose) {
			for (int i = 0; i < MyPersonTree.vector.size(); i++) {
				JICQChatFrame jchatExist = (JICQChatFrame) MyPersonTree.vector
						.get(i);
				if (jchatExist.JICQ.equals(p.getID())) {
					MyPersonTree.vector.remove(i);
					this.dispose();
					break;
				}

			}
			for (int i = 0; i < MyPersonTree.UnKonwVector.size(); i++) {
				JICQChatFrame jchatUnKonwExist = (JICQChatFrame) MyPersonTree.UnKonwVector
						.get(i);
				if (jchatUnKonwExist.JICQ.equals(p.getID())) {
					MyPersonTree.UnKonwVector.remove(i);
					this.dispose();
					break;
				}
			}

			String chatcontent = tpContent.getText();
			if (chatcontent != "") {
				ChatRecord cr = new ChatRecord(MyPersonTree.myJICQ, this.JICQ);
				cr.writeChatContent(chatcontent);
			}
			if (mwin != null)
				mwin.dispose();
		}
		if (e.getSource() == btSend) {
			SendMessage();
		}

		if (e.getSource() == btChatContent) {
			if (mwin != null) {
				mwin.dispose();
				mwin = null;
			} else {
				ChatRecord cr = new ChatRecord(MyPersonTree.myJICQ, this.JICQ);
				String str = cr.readChatContent();
				mwin = new MessageWindow(this.getLocation().getX(), this
						.getLocation().getY()
						+ this.getSize().height);
				mwin.jTextPane1.setText(str);
			}

		}
	}

	public void SendMessage() {
		java.util.Date now = new java.util.Date();
		String nowTime = now.getHours() + ":" + now.getMinutes() + ":"
				+ now.getSeconds();
		String msg = this.tpMessage.getText() + "\n\n";
		String headmsg = MyPersonTree.myValue.getname() + "("
				+ MyPersonTree.myJICQ + ") " + nowTime + "\n";
		client.send("MSGONE#" + this.JICQ + "#" + MyPersonTree.myJICQ + "#"
				+ headmsg + "#" + msg); // MSGONE+HISJICQ+MYJICQ+headmsg+msg
		
		System.out.println("into JICQChatFrame sendMessage() method");
		this.tpContent.setText(tpContent.getText() + " " + headmsg);
		this.tpContent.setText(tpContent.getText() + " " + msg);
		this.tpMessage.setText("");
		Client.lPerson.writeToArrayList(this.JICQ);
		jbar.setValue(jbar.getMaximum());
	}

	// 显示聊天信息
	public void setMessage(String headmsg, String msg) {
		this.tpContent.setText(tpContent.getText() + " " + headmsg);
		this.tpContent.setText(tpContent.getText() + " " + msg);

		new PlayMusic().gomsg();
		jbar.setValue(jbar.getMaximum());
		jbar.setValue(jbar.getMaximum());
	}

}

class JICQChatFrame_lbHisShow_mouseAdapter extends java.awt.event.MouseAdapter {
	JICQChatFrame adaptee;

	JICQChatFrame_lbHisShow_mouseAdapter(JICQChatFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void mouseClicked(MouseEvent e) {
		adaptee.lbHisShow_mouseClicked(e);
	}
}

class JICQChatFrame_lbVideo_mouseAdapter extends java.awt.event.MouseAdapter {
	JICQChatFrame adaptee;

	JICQChatFrame_lbVideo_mouseAdapter(JICQChatFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void mouseClicked(MouseEvent e) {
		adaptee.lbVideo_mouseClicked(e);
	}
}
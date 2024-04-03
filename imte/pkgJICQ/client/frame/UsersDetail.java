package pkgJICQ.client.frame;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class UsersDetail extends JFrame implements ActionListener {
	JPanel contentPane;//内容面板

	XYLayout xYLayout1 = new XYLayout();

	JTabbedPane jTabbedPane1 = new JTabbedPane();//p108

	JPanel jPanel1 = new JPanel();

	JPanel jPanel2 = new JPanel();

	XYLayout xYLayout3 = new XYLayout();

	XYLayout xYLayout4 = new XYLayout();

	JButton btAlter = new JButton("更新");

	JButton btCancel = new JButton("取消");

	JLabel jLabel1 = new JLabel();

	JLabel jLabel2 = new JLabel();

	JLabel jLabel3 = new JLabel();

	JLabel jLabel4 = new JLabel();

	JLabel jLabel5 = new JLabel();

	JLabel jLabel6 = new JLabel();

	JLabel jLabel7 = new JLabel();

	JLabel jLabel10 = new JLabel();

	JLabel jLabel13 = new JLabel();

	JLabel jLabel16 = new JLabel();

	JLabel jLabel110 = new JLabel();

	XYLayout xYLayout5 = new XYLayout();

	JLabel jLabel20 = new JLabel();

	JLabel jLabel21 = new JLabel();

	JLabel jLabel111 = new JLabel();

	JLabel jLabel112 = new JLabel();

	JLabel jLabel113 = new JLabel();

	JLabel jLabel114 = new JLabel();

	JLabel jLabel22 = new JLabel();

	JLabel jLabel115 = new JLabel();

	JLabel jLabel23 = new JLabel();

	JLabel jLabel116 = new JLabel();

	JLabel jLabel24 = new JLabel();

	JTextArea jTextArea2 = new JTextArea();

	JLabel jLabel117 = new JLabel();

	JPanel jPanel4 = new JPanel();

	JLabel jLabel25 = new JLabel();

	JLabel jLabel118 = new JLabel();

	JLabel jLabel26 = new JLabel();

	JLabel jLabel119 = new JLabel();

	JLabel jLabel120 = new JLabel();

	JLabel jLabel27 = new JLabel();

	JLabel jLabel121 = new JLabel();

	JLabel jLabel28 = new JLabel();

	JLabel jLabel210 = new JLabel();

	JLabel jLabel211 = new JLabel();

	JLabel jLabel17 = new JLabel();

	JLabel jLabel1110 = new JLabel();

	JLabel jLabel18 = new JLabel();

	JLabel jLabel1111 = new JLabel();

	JLabel jLabel122 = new JLabel();

	JLabel jLabel8 = new JLabel();

	JTextField jTextField1 = new JTextField();

	JTextField jTextField2 = new JTextField();

	JLabel jLabel9 = new JLabel();

	// Construct the frame
	public UsersDetail() {
		//enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();//设置一些属性
		contentPane.setBackground(new Color(241, 239, 226));
		contentPane.setOpaque(true);
		contentPane.setPreferredSize(new Dimension(0, 0));
		contentPane.setRequestFocusEnabled(true);
		contentPane.setLayout(xYLayout1);

		jPanel1.setLayout(xYLayout3);
		jPanel2.setLayout(xYLayout4);
		jPanel1.setBackground(Color.white);
		jPanel1.setFont(new java.awt.Font("Dialog", 0, 12));
		jPanel1.setBorder(null);
		jPanel1.setDebugGraphicsOptions(0);
		jTabbedPane1.setBackground(new Color(241, 239, 226));
		jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 15));
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel1.setAlignmentX((float) 0.0);
		jLabel1.setBorder(null);
		jLabel1.setDebugGraphicsOptions(0);
		jLabel1.setText("状态:");
		jLabel2.setText("");
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel2.setAlignmentX((float) 0.0);
		jLabel2.setBorder(null);
		jLabel2.setDebugGraphicsOptions(0);
		jLabel3.setText("星座:");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel3.setAlignmentX((float) 0.0);
		jLabel3.setBorder(null);
		jLabel3.setDebugGraphicsOptions(0);
		jLabel3.setRequestFocusEnabled(true);
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel4.setAlignmentX((float) 0.0);
		jLabel4.setBorder(null);
		jLabel4.setDebugGraphicsOptions(0);
		jLabel4.setText("");
		jLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel5.setAlignmentX((float) 0.0);
		jLabel5.setBorder(null);
		jLabel5.setDebugGraphicsOptions(0);
		jLabel5.setText("血型:");
		jLabel6.setText("");
		jLabel6.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel6.setAlignmentX((float) 0.0);
		jLabel6.setBorder(null);
		jLabel6.setDebugGraphicsOptions(0);
		jLabel6.setToolTipText("");
		jLabel7.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel7.setAlignmentX((float) 0.0);
		jLabel7.setBorder(null);
		jLabel7.setDebugGraphicsOptions(0);
		jLabel7.setToolTipText("");
		jLabel7.setText("毕业院校:");
		jLabel10.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel10.setAlignmentX((float) 0.0);
		jLabel10.setBorder(null);
		jLabel10.setDebugGraphicsOptions(0);
		jLabel10.setText("");
		jLabel13.setText("电子邮件:");
		jLabel13.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel13.setAlignmentX((float) 0.0);
		jLabel13.setBorder(null);
		jLabel13.setDebugGraphicsOptions(0);
		jLabel16.setText("");
		jLabel16.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel16.setAlignmentX((float) 0.0);
		jLabel16.setBorder(null);
		jLabel16.setDebugGraphicsOptions(0);
		jLabel110.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel110.setAlignmentX((float) 0.0);
		jLabel110.setBorder(null);
		jLabel110.setDebugGraphicsOptions(0);
		jLabel110.setText("联系地址:");
		jPanel2.setBackground(Color.white);
		jPanel2.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel20.setBorder(null);
		jLabel20.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel20.setText("");
		jLabel21.setText("");
		jLabel21.setBorder(null);
		jLabel21.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel111.setText("");
		jLabel111.setToolTipText("");
		jLabel111.setBorder(BorderFactory.createLineBorder(Color.black));
		jLabel112.setBorder(null);
		jLabel112.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel112.setText("");
		jLabel113.setBorder(null);
		jLabel113.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel113.setText("");
		jLabel114.setText("性别:");
		jLabel114.setBorder(null);
		jLabel114.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel22.setText("JICQ  号:");
		jLabel22.setBorder(null);
		jLabel22.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel115.setBorder(null);
		jLabel115.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel115.setText("国家/地区:");
		jLabel23.setBorder(null);
		jLabel23.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel23.setText("昵    称:");
		jLabel116.setText("");
		jLabel116.setBorder(null);
		jLabel116.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel24.setText("真实姓名:");
		jLabel24.setBorder(null);
		jLabel24.setFont(new java.awt.Font("Dialog", 0, 12));
		jTextArea2.setWrapStyleWord(false);
		jTextArea2.setLineWrap(true);
		jTextArea2.setText("");
		jTextArea2.setDisabledTextColor(Color.black);
		jTextArea2.setVerifyInputWhenFocusTarget(true);
		jTextArea2.setEnabled(false);
		jLabel117.setBorder(null);
		jLabel117.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel117.setVerifyInputWhenFocusTarget(true);
		jLabel117.setText("城市:");
		jPanel4.setBorder(null);
		jPanel4.setFont(new java.awt.Font("Dialog", 0, 12));
		jPanel4.setBackground(Color.white);
		jPanel4.setLayout(xYLayout5);
		jLabel25.setText("");
		jLabel25.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel25.setBorder(null);
		jLabel118.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel118.setBorder(null);
		jLabel118.setText("");
		jLabel26.setText("");
		jLabel26.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel26.setBorder(null);
		jLabel119.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel119.setBorder(null);
		jLabel119.setText("个性签名:");
		jLabel120.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel120.setBorder(null);
		jLabel120.setText("州/省:");
		jLabel27.setText("年龄:");
		jLabel27.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel27.setBorder(null);
		jLabel121.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel121.setBorder(null);
		jLabel121.setText("");
		jLabel28.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel28.setBorder(null);
		jLabel28.setText("备注:");
		jLabel210.setText("职业:");
		jLabel210.setDebugGraphicsOptions(0);
		jLabel210.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel210.setAlignmentX((float) 0.0);
		jLabel210.setBorder(null);
		jLabel211.setAlignmentX((float) 0.0);
		jLabel211.setBorder(null);
		jLabel211.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel211.setDebugGraphicsOptions(0);
		jLabel211.setText("");
		jLabel17.setDebugGraphicsOptions(0);
		jLabel17.setAlignmentX((float) 0.0);
		jLabel17.setBorder(null);
		jLabel17.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel17.setText("");
		jLabel1110.setText("邮政编码:");
		jLabel1110.setDebugGraphicsOptions(0);
		jLabel1110.setAlignmentX((float) 0.0);
		jLabel1110.setBorder(null);
		jLabel1110.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel18.setText("jLabel18");
		jLabel18.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel18.setAlignmentX((float) 0.0);
		jLabel18.setBorder(null);
		jLabel18.setDebugGraphicsOptions(0);

		btAlter.setFont(new java.awt.Font("Dialog", 0, 12));
		btCancel.setFont(new java.awt.Font("Dialog", 0, 12));
		btAlter.addActionListener(this);
		btCancel.addActionListener(this);

		jLabel1111.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel1111.setAlignmentX((float) 0.0);
		jLabel1111.setBorder(null);
		jLabel1111.setDebugGraphicsOptions(0);
		jLabel1111.setText("个人主页:");
		jLabel122.setDebugGraphicsOptions(0);
		jLabel122.setAlignmentX((float) 0.0);
		jLabel122.setBorder(null);
		jLabel122.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel122.setText("");
		jLabel8.setBorder(BorderFactory.createLineBorder(Color.black));
		jLabel8.setText("");
		jTextField1.setBackground(new Color(239, 239, 226));
		jTextField1.setBorder(null);
		jTextField1.setText("");
		jTextField2.setBackground(new Color(241, 239, 226));
		jTextField2.setFont(new java.awt.Font("Dialog", 0, 12));
		jTextField2.setAlignmentX((float) 0.5);
		jTextField2.setBorder(null);
		jTextField2.setToolTipText("");
		jTextField2.setText("个人说明");
		jTextField2.setEditable(false);

		jLabel9.setText("");
		btAlter.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\refresh.gif"));
		btCancel.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pChatPanel\\cancel.gif"));

		jPanel1.add(jLabel7, new XYConstraints(14, 115, 64, 24));
		jPanel1.add(jLabel3, new XYConstraints(14, 69, 49, 24));
		jPanel1.add(jLabel5, new XYConstraints(189, 69, 36, 24));
		jPanel1.add(jLabel6, new XYConstraints(226, 69, 88, 24));
		jPanel1.add(jLabel4, new XYConstraints(70, 70, 96, 24));
		jPanel1.add(jLabel2, new XYConstraints(70, 23, 94, 24));
		jPanel1.add(jLabel1, new XYConstraints(14, 24, 49, 24));
		jPanel1.add(jLabel210, new XYConstraints(188, 24, 37, 24));
		jPanel1.add(jLabel211, new XYConstraints(227, 24, 86, 24));
		jPanel1.add(jLabel13, new XYConstraints(12, 162, 61, 24));
		jPanel1.add(jLabel10, new XYConstraints(81, 115, 310, 24));
		jPanel1.add(jLabel110, new XYConstraints(12, 210, 61, 24));
		jPanel1.add(jLabel1110, new XYConstraints(12, 254, 61, 24));
		jPanel1.add(jLabel18, new XYConstraints(76, 254, 312, 24));
		jPanel1.add(jLabel17, new XYConstraints(79, 211, 312, 24));
		jPanel1.add(jLabel1111, new XYConstraints(11, 297, 61, 24));
		jPanel1.add(jLabel122, new XYConstraints(75, 297, 312, 24));
		jPanel1.add(jLabel16, new XYConstraints(76, 163, 312, 24));

		jPanel4.add(jLabel20, new XYConstraints(74, 115, 94, 24));
		jPanel4.add(jLabel22, new XYConstraints(14, 23, 49, 24));
		jPanel4.add(jLabel21, new XYConstraints(69, 69, 96, 24));
		jPanel4.add(jLabel111, new XYConstraints(360, 25, 62, 70));
		jPanel4.add(jLabel112, new XYConstraints(405, 115, 90, 24));
		jPanel4.add(jLabel24, new XYConstraints(14, 115, 56, 24));
		jPanel4.add(jLabel119, new XYConstraints(12, 212, -1, 24));
		jPanel4.add(jLabel25, new XYConstraints(73, 22, 92, 24));
		jPanel4.add(jLabel23, new XYConstraints(14, 69, 49, 24));
		jPanel4.add(jLabel121, new XYConstraints(224, 115, 90, 24));
		jPanel4.add(jLabel27, new XYConstraints(188, 115, 34, 24));
		jPanel4.add(jLabel28, new XYConstraints(189, 69, 36, 24));
		jPanel4.add(jLabel26, new XYConstraints(226, 69, 88, 24));
		jPanel4.add(jLabel114, new XYConstraints(350, 115, 34, 24));
		jPanel4.add(jLabel113, new XYConstraints(223, 162, 90, 24));
		jPanel4.add(jLabel115, new XYConstraints(13, 163, -1, 24));
		jPanel4.add(jLabel117, new XYConstraints(350, 161, 34, 24));
		jPanel4.add(jLabel116, new XYConstraints(385, 161, 90, 24));
		jPanel4.add(jTextArea2, new XYConstraints(70, 213, 348, 74));
		jPanel4.add(jLabel120, new XYConstraints(188, 162, 34, 24));
		jPanel4.add(jLabel118, new XYConstraints(72, 163, 89, 24));
		jPanel4.add(btAlter, new XYConstraints(220, 290, 89, 24));
		jPanel4.add(btCancel, new XYConstraints(350, 290, 89, 24));
        ///////////////////////////////////////////////添加三个标签
		jTabbedPane1.add(jPanel4, "个人资料");
		jTabbedPane1.add(jPanel1, "详细资料");
		jTabbedPane1.add(jPanel2, "我形我秀");

		jPanel2.add(jLabel8, new XYConstraints(18, 7, 146, 321));
		jPanel2.add(jTextField2, new XYConstraints(164, 7, 327, 25));
		jPanel2.add(jTextField1, new XYConstraints(163, 165, 335, 3));
		jPanel2.add(jLabel9, new XYConstraints(169, 34, 320, 118));
        /////几种面板的用法
		JScrollPane jScrollPane1 = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
		jScrollPane1.getViewport().add(jTabbedPane1, null);
		//将jTabbedPane1添加到jScrollPane1

		contentPane.add(jScrollPane1, new XYConstraints(9, 3, 497, 370));
		//讲jScrollPane1添加到contentPane
		this.setSize(new Dimension(523, 435));
		this.setState(Frame.NORMAL);
		this.setBounds(300, 200, 523, 435);
		this.setVisible(true);
	}

	// Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAlter) {

		} else if (e.getSource() == btCancel) {
			this.dispose();
		}
	}

	// 给所有资料传值
	public void setAllDetail(ResultSet rs) {
		try {
			while (rs.next()) {

				int JICQ = rs.getInt("JICQ");
				String JShowName = rs.getString("JShowName");
				String JTrueName = rs.getString("JTrueName");
				int JAge = rs.getInt("JAge");
				String JSex = rs.getString("JSex");
				String JCountry = rs.getString("JCountry");
				String JProvince = rs.getString("JProvince");
				String JCity = rs.getString("JCity");
				int JStatusID = rs.getInt("JStatus");
				String JStatus = "";

				if (JStatusID == 1)
					JStatus = "离开状态";
				else if (JStatusID == 3)
					JStatus = "在线状态";
				else
					JStatus = "下线状态";

				int JPicID = rs.getInt("JPicID");
				int JICQShowID = rs.getInt("JICQShowID");
				String JEmail = rs.getString("JEmail");
				String JUnderWrite = rs.getString("JUnderWrite");
				String JProfession = rs.getString("JProfession");
				String JStar = rs.getString("JStar");

				String JXuexing = rs.getString("JXuexing");
				String JGradute = rs.getString("JGradute");
				String JAddress = rs.getString("JAddress");
				String JPostalcode = rs.getString("JPostalcode");
				String JPersonalPage = rs.getString("JPersonalPage");
				String JPersonalInfo = rs.getString("JPersonalInfo");

				jLabel25.setText(JICQ + "");
				jLabel21.setText(JShowName);
				jLabel20.setText(JTrueName);
				jLabel121.setText(JAge + "");
				jLabel112.setText(JSex);
				jLabel118.setText(JCountry);
				jLabel113.setText(JProvince);
				jLabel116.setText(JCity);
				jTextArea2.setText(JUnderWrite);
				jLabel111.setIcon(new ImageIcon(MyCursor.path
						+ "\\picture\\pHead\\" + JPicID + ".gif"));
				// 2----------------
				jLabel4.setText(JStar);
				jLabel10.setText(JGradute);
				jLabel16.setText(JEmail);
				jLabel17.setText(JAddress);
				jLabel122.setText(JPersonalPage);
				jLabel211.setText(JProfession);
				jLabel6.setText(JXuexing);
				jLabel2.setText(JStatus);

				jLabel18.setText(JPostalcode);
				// 3---------------------
				jLabel9.setText(JPersonalInfo);
				jLabel8.setIcon(new ImageIcon(MyCursor.path
						+ "\\picture\\pShow\\" + JICQShowID + ".gif"));
				this.setTitle(JShowName + "的个人资料");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new UsersDetail();
	}

}
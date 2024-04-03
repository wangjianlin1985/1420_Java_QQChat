package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import com.borland.jbcl.layout.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;

public class MySearchFrame extends JFrame implements ItemListener,
		ActionListener, ChangeListener

{
	JPanel contentPane;

	XYLayout xYLayout1 = new XYLayout();

	JTabbedPane jTabbedPane1 = new JTabbedPane();

	JButton btSearch = new JButton();//查找

	JButton btClose = new JButton();//

	JLabel lbImage = new JLabel();

	JPanel pBasicSearch = new JPanel();//基本查找PANEL

	XYLayout xYLayout2 = new XYLayout();

	JPanel pHigh = new JPanel();//高级查找

	JPanel jPanel3 = new JPanel();//群用户查找

	JLabel jLabel2 = new JLabel();

	XYLayout xYLayout3 = new XYLayout();

	JTextField tfJICQ = new JTextField();

	JLabel jLabel3 = new JLabel();

	JTextField tfShowName = new JTextField();

	XYLayout xYLayout4 = new XYLayout();

	JPanel jPanel4 = new JPanel();//

	JCheckBox chbOnline = new JCheckBox();

	XYLayout xYLayout5 = new XYLayout();

	TitledBorder titledBorder1;

	JLabel jLabel4 = new JLabel();

	JTextField tfProvince = new JTextField();

	JLabel jLabel7 = new JLabel();

	JTextField tfCity = new JTextField();

	JLabel jLabel5 = new JLabel();

	JTextField tfAge1 = new JTextField();

	JLabel jLbTo = new JLabel();

	JTextField tfAge2 = new JTextField();

	JLabel jLabel6 = new JLabel();

	JComboBox cbSex = new JComboBox();

	JPanel pGroupSearch = new JPanel();//群用户查找

	XYLayout xYLayout6 = new XYLayout();

	JPanel jPanel6 = new JPanel();

	JRadioButton rbtKinds = new JRadioButton();

	XYLayout xYLayout7 = new XYLayout();

	JRadioButton rbtGroupSearch = new JRadioButton();

	JLabel jLabel8 = new JLabel();

	JComboBox cbKinds = new JComboBox();

	JLabel jLabel9 = new JLabel();

	JTextField tfKeys = new JTextField();

	JLabel jLabel10 = new JLabel();

	JLabel lbOnline = new JLabel();

	JPanel pFinally = new JPanel();

	XYLayout xYLayout8 = new XYLayout();

	JScrollPane jScrollPane1 = new JScrollPane();

	JLabel jLabel1 = new JLabel();

	JTable tableSearch = new JTable();

	ButtonGroup buttonGroup1 = new ButtonGroup();

	JRadioButton rbtOnline = new JRadioButton();

	JRadioButton rbtDetailSearch = new JRadioButton();

	JButton btAddFriend = new JButton();

	ButtonGroup buttonGroup2 = new ButtonGroup();

	JLabel lbCurrent = new JLabel();

	JButton btExamination = new JButton();

	JButton btOnpage = new JButton();

	JButton btNextpage = new JButton();

	private int Condition = 0;

	private int index = 0;

	Vector totalV = new Vector(100);

	int pageNum = 1;

	Vector vhead = new Vector(100);

	int totalPageNum;

	ListSelectionModel selectionMode = null;

	ListSelectionModel lsm;

	int userCount;

	MyListFrame mf;

	// Construct the frame
	public MySearchFrame(MyListFrame mf) {
		showuser();
		this.mf = mf;

		cbSex.addItem("不限");
		cbSex.addItem("男");
		cbSex.addItem("女");
		rbtOnline.setSelected(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		// tableSearch.getTableHeader().setReorderingAllowed(false);

		btClose.addActionListener(this);
		btSearch.addActionListener(this);
		rbtOnline.addActionListener(this);
		chbOnline.addItemListener(this);
		this.jTabbedPane1.addChangeListener(this);
		rbtDetailSearch.addActionListener(this);
		btNextpage.addActionListener(this);
		btOnpage.addActionListener(this);
		btExamination.addActionListener(this);
		btAddFriend.addActionListener(this);
		tableSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				if (ev.getSource() == tableSearch) {
					if (ev.getClickCount() == 2) {
						String hisJICQ = getJicq();
						if (hisJICQ != null || !hisJICQ.equals("")) {
							UsersDetail ud = new UsersDetail();
							ud.setAllDetail(new Friends()
									.selectAllDetail(hisJICQ));
						}

					}
				}

			}
		});

		// this.rbtOnline.setEnabled(false);

		if (this.rbtOnline.isSelected() == true) {
			this.jLabel2.setEnabled(false);
			this.jLabel3.setEnabled(false);
			this.tfJICQ.setEnabled(false);
			this.tfShowName.setEnabled(false);

		}
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ShowFindCondition();

	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		titledBorder1 = new TitledBorder("");
		contentPane.setLayout(xYLayout1);

		this.setTitle("查找用户");
		btSearch.setFont(new java.awt.Font("Dialog", 0, 14));
		btSearch.setBorder(BorderFactory.createLineBorder(Color.black));
		btSearch.setDebugGraphicsOptions(0);
		btSearch.setText("查找");
		btClose.setFont(new java.awt.Font("Dialog", 0, 14));
		btClose.setBorder(BorderFactory.createLineBorder(Color.black));
		btClose.setText("关闭");
		lbImage.setBorder(BorderFactory.createEtchedBorder());
		lbImage.setDoubleBuffered(false);
		jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 14));
		jTabbedPane1.setBorder(BorderFactory.createEtchedBorder());
		jTabbedPane1.setRequestFocusEnabled(true);
		pBasicSearch.setFont(new java.awt.Font("Dialog", 0, 12));
		pBasicSearch.setBorder(BorderFactory.createEtchedBorder());
		pBasicSearch.setLayout(xYLayout2);
		jPanel3.setBorder(BorderFactory.createEtchedBorder());
		jPanel3.setDebugGraphicsOptions(0);
		jPanel3.setLayout(xYLayout3);
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel2.setBorder(null);
		jLabel2.setText("对方账号 :");
		tfJICQ.setBorder(BorderFactory.createEtchedBorder());
		tfJICQ.setDebugGraphicsOptions(0);
		tfJICQ.setText("");
		jLabel3.setText("对方昵称 :");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel3.setBorder(null);
		tfShowName.setBorder(BorderFactory.createEtchedBorder());
		tfShowName.setText("");
		pHigh.setLayout(xYLayout4);
		jPanel4.setBorder(BorderFactory.createEtchedBorder());
		jPanel4.setDebugGraphicsOptions(0);
		jPanel4.setLayout(xYLayout5);
		chbOnline.setFont(new java.awt.Font("Dialog", 0, 12));
		chbOnline.setBorder(BorderFactory.createEtchedBorder());
		chbOnline.setText("在线用户");
		jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel4.setBorder(null);
		jLabel4.setText("省份 :");
		jLabel7.setText("城市 :");
		jLabel7.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel7.setBorder(null);
		jLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel5.setBorder(null);
		jLabel5.setText("年龄 :");

		jLbTo.setFont(new java.awt.Font("Dialog", 0, 12));
		jLbTo.setBorder(null);
		jLbTo.setText("至");

		jLabel6.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel6.setBorder(null);
		jLabel6.setText("性别: ");
		pGroupSearch.setLayout(xYLayout6);
		jPanel6.setBorder(BorderFactory.createLoweredBevelBorder());
		jPanel6.setBorder(BorderFactory.createEtchedBorder());
		jPanel6.setLayout(xYLayout7);
		rbtKinds.setFont(new java.awt.Font("Dialog", 0, 12));
		rbtKinds.setSelected(true);
		rbtKinds.setText("分类查找");
		rbtGroupSearch.setFont(new java.awt.Font("Dialog", 0, 12));
		rbtGroupSearch.setText("精确查找");
		jLabel8.setFont(new java.awt.Font("Dialog", 0, 13));
		jLabel8.setBorder(null);
		jLabel8.setText("分类 :");
		jLabel9.setFont(new java.awt.Font("Dialog", 0, 13));
		jLabel9.setBorder(null);
		jLabel9.setText("关键字:");
		tfKeys.setFont(new java.awt.Font("Dialog", 0, 13));
		tfKeys.setBorder(BorderFactory.createEtchedBorder());
		tfKeys.setDebugGraphicsOptions(0);
		tfKeys.setText("");
		//pGroupSearch.setBorder(BorderFactory.createEtchedBorder());
		//pGroupSearch.setDebugGraphicsOptions(0);
		cbKinds.setBorder(BorderFactory.createEtchedBorder());
		cbKinds.setDebugGraphicsOptions(0);
		tfProvince.setBorder(BorderFactory.createEtchedBorder());
		tfCity.setBorder(BorderFactory.createEtchedBorder());
		tfAge1.setBorder(BorderFactory.createEtchedBorder());
		tfAge2.setBorder(BorderFactory.createEtchedBorder());
		cbSex.setBorder(BorderFactory.createEtchedBorder());
		pHigh.setBorder(BorderFactory.createEtchedBorder());
		contentPane.setForeground(Color.black);
		contentPane.setBorder(null);
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		jLabel10.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel10.setText("当前在线人数 :");
		lbOnline.setFont(new java.awt.Font("Dialog", 0, 12));

		pFinally.setLayout(xYLayout8);
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel1.setText("查找的结果为:");
		rbtOnline.setFont(new java.awt.Font("Dialog", 0, 12));
		rbtOnline.setActionCommand("");

		rbtOnline.setText("看谁在线上");
		rbtDetailSearch.setFont(new java.awt.Font("Dialog", 0, 12));
		rbtDetailSearch.setText("模糊查找");
		btAddFriend.setText("添加");
		btAddFriend.setDebugGraphicsOptions(0);
		btAddFriend.setActionCommand("查找");
		btAddFriend.setBorder(BorderFactory.createLineBorder(Color.black));
		btAddFriend.setFont(new java.awt.Font("Dialog", 0, 14));
		lbCurrent.setFont(new java.awt.Font("Dialog", 0, 12));
		lbCurrent.setText("当前第一页");
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		btExamination.setFont(new java.awt.Font("Dialog", 0, 12));
		btExamination.setBorder(BorderFactory.createEtchedBorder());
		btExamination.setText("查看资料");
		btOnpage.setFont(new java.awt.Font("Dialog", 0, 12));
		btOnpage.setForeground(Color.black);
		btOnpage.setBorder(BorderFactory.createEtchedBorder());
		btOnpage.setFocusPainted(true);
		btOnpage.setText("上页");
		btNextpage.setFont(new java.awt.Font("Dialog", 0, 12));
		btNextpage.setBorder(BorderFactory.createEtchedBorder());
		btNextpage.setText("下页");
		contentPane.add(jTabbedPane1, new XYConstraints(161, 9, 363, 293));
		jPanel3.add(jLabel2, new XYConstraints(17, 9, 79, 26));
		jPanel3.add(tfJICQ, new XYConstraints(101, 9, 214, 27));
		jPanel3.add(tfShowName, new XYConstraints(102, 44, 213, 27));
		jPanel3.add(jLabel3, new XYConstraints(17, 47, 79, 26));
		pBasicSearch.add(jLabel10, new XYConstraints(16, 225, 81, 24));
		pBasicSearch.add(lbOnline, new XYConstraints(112, 224, 118, 26));
		pBasicSearch.add(jPanel3, new XYConstraints(13, 139, 331, 79));

		jPanel6.add(rbtKinds, new XYConstraints(13, 0, -1, 23));
		jPanel6.add(rbtGroupSearch, new XYConstraints(120, 3, 95, 21));

		pFinally.add(jScrollPane1, new XYConstraints(0, 25, 353, 207));
		jScrollPane1.getViewport().add(tableSearch, null);
		pFinally.add(jLabel1, new XYConstraints(5, 3, 131, 22));
		pFinally.add(lbCurrent, new XYConstraints(7, 231, 72, 26));
		//pGroupSearch.add(jLabel8, new XYConstraints(45, 69, 49, 26));
		//pGroupSearch.add(cbKinds, new XYConstraints(110, 68, 152, 26));
		//pGroupSearch.add(tfKeys, new XYConstraints(110, 118, 150, 24));
		//pGroupSearch.add(jLabel9, new XYConstraints(44, 118, 51, 25));
		//pGroupSearch.add(jPanel6, new XYConstraints(-2, 0, 360, 30));
		jTabbedPane1.add(pBasicSearch, "基本查找");
		jTabbedPane1.add(pHigh, "高级查找");
		//jTabbedPane1.add(pGroupSearch, "群用户查找");
		jTabbedPane1.add(pFinally, "结果显示");
		pHigh.add(jPanel4, new XYConstraints(-4, 0, 362, 42));
		jPanel4.add(chbOnline, new XYConstraints(17, 6, -1, -1));
		pHigh.add(tfProvince, new XYConstraints(120, 67, 156, 25));
		pHigh.add(tfCity, new XYConstraints(120, 108, 156, 24));
		pHigh.add(tfAge1, new XYConstraints(120, 150, 60, 24));
		pHigh.add(jLbTo, new XYConstraints(190, 151, 30, 23));
		pHigh.add(tfAge2, new XYConstraints(210, 150, 60, 24));
		pHigh.add(jLabel5, new XYConstraints(58, 151, 58, 23));
		pHigh.add(jLabel7, new XYConstraints(59, 110, 58, 22));
		pHigh.add(jLabel4, new XYConstraints(58, 67, 59, 25));
		pHigh.add(jLabel6, new XYConstraints(58, 189, 57, 24));
		pHigh.add(cbSex, new XYConstraints(119, 188, 156, 25));
		lbImage.setIcon(new ImageIcon(MyCursor.path
				+ "\\picture\\pSearch\\search.jpg"));
		contentPane.add(lbImage, new XYConstraints(8, 8, 140, 335));
		contentPane.add(btClose, new XYConstraints(438, 314, 81, -1));
		contentPane.add(btSearch, new XYConstraints(221, 315, 90, -1));
		buttonGroup1.add(rbtOnline);
		pBasicSearch.add(rbtOnline, new XYConstraints(117, 16, 105, 32));
		pBasicSearch.add(rbtDetailSearch, new XYConstraints(119, 65, 107, 35));
		contentPane.add(btAddFriend, new XYConstraints(329, 314, 90, -1));
		buttonGroup2.add(rbtKinds);
		buttonGroup2.add(rbtGroupSearch);
		buttonGroup1.add(rbtDetailSearch);
		pFinally.add(btExamination, new XYConstraints(103, 234, 88, 23));
		pFinally.add(btOnpage, new XYConstraints(245, 234, 49, 22));
		pFinally.add(btNextpage, new XYConstraints(302, 235, 48, 21));

		this.setBounds(300, 200, 537, 383);
		this.setIconImage(new ImageIcon(MyCursor.path
				+ "\\picture\\pSearch\\find.JPG").getImage());
		this.setVisible(true);
	}

	// Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
		}
	}

	// 判断是不是数字!

	public Boolean IsNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')

				return false;
		}
		return true;
	}

	// 显示数据
	public void showuser() {
		try {
			Connection conn;
			conn = DBConnection.getConnection();
			Statement stment = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from JUsers where JStatus='" + 3 + "'";
			ResultSet rs = null;
			rs = stment.executeQuery(sql);
			rs.last();
			userCount = rs.getRow();
			lbOnline.setText(userCount + "");
			stment.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void ShowUser() {
		Connection conn;
		try {

			conn = DBConnection.getConnection();
			Statement stment = conn.createStatement();
			String sql = null;
			if (index == 0) {
				if (Condition == 0) {
					System.out.println(Condition);
					sql = "select * from JUsers where JStatus='" + 3 + "'";
				}
				if (Condition == 1) {
					System.out.println(index);
					if (this.tfJICQ.getText().trim().length() > 0
							|| this.tfShowName.getText().trim().length() > 0) {

						int vJIcq = 0;
						if (IsNum(this.tfJICQ.getText().trim()) == true) {

							if (this.tfJICQ.getText().trim().length() > 0) {
								String vID = this.tfJICQ.getText().trim();
								vJIcq = Integer.parseInt(vID);
							}

						} else {
							JOptionPane.showMessageDialog(null,
									"      你输入的账号有误!请重新输入!", "请注意!",
									JOptionPane.CANCEL_OPTION);
							return;
						}
						String vShowName = null;
						vShowName = this.tfShowName.getText().trim();
						sql = "select * from JUsers where JICQ like '%" + vJIcq
								+ "%' and JShowName like '%" + vShowName + "%'";

					} else {
						JOptionPane.showMessageDialog(null, "      请输入条件",
								"请注意!", JOptionPane.CANCEL_OPTION);
						return;
					}

				}
			}
			if (index == 1) {
				String vJProvince = this.tfProvince.getText();
				String vJCity = this.tfCity.getText();
				String vJSex = this.cbSex.getSelectedItem().toString().trim();
				if (vJSex.equals("不限")) {
					vJSex = "";
				}
				int vJAge1 = 0;
				int vJAge2 = 0;
				if (this.tfAge1.getText().length() > 0
						&& this.tfAge2.getText().length() > 0) {
					if (IsNum(this.tfAge1.getText().trim()) == true
							&& IsNum(this.tfAge2.getText().trim()) == true) {
						vJAge1 = Integer.parseInt(this.tfAge1.getText().trim());
						vJAge2 = Integer.parseInt(this.tfAge2.getText().trim());
					} else {

						JOptionPane.showMessageDialog(null,
								"      你输入的年龄范围有误!请重新输入!", "请注意!",
								JOptionPane.CANCEL_OPTION);
						return;
					}

				}
				if (this.tfAge1.getText().length() == 0) {
					vJAge1 = 0;
				}
				if (this.tfAge2.getText().length() == 0) {
					vJAge2 = 1000;
				}
				if (Condition == 2) {

					sql = "select * from JUsers where JProvince like '%"
							+ vJProvince + "%' and JCity like '%" + vJCity
							+ "%' and  JAge >=" + vJAge1 + " and JAge <="
							+ vJAge2 + " and JSex like'%" + vJSex
							+ "%'  and JStatus='" + 3 + "'";

				}
				if (Condition == 3) {
					sql = "select * from JUsers where JProvince like '%"
							+ vJProvince + "%' and JCity like '%" + vJCity
							+ "%' and  JAge >=" + vJAge1 + " and JAge <="
							+ vJAge2 + " and JSex like'%" + vJSex + "%'";

				}
			}if(index==3){
				
			}

			ResultSet rs = null;
			System.out.println(sql);
			rs = stment.executeQuery(sql);
			vhead.removeAllElements();
			vhead.add("账号");
			vhead.add("昵称");
			vhead.add("性别");
			vhead.add("年龄");
			vhead.add("省份");
			vhead.add("城市");
			Vector data = new Vector(100);

			while (rs.next()) {
				String vJIcqID = rs.getString(1);
				String vJShowName = rs.getString(3);
				int vJAge = rs.getInt(5);
				String vJSex = rs.getString(6);
				String vJProvince = rs.getString(8);
				String vJCity = rs.getString(9);
				SearchMan sm = new SearchMan(vJIcqID, vJShowName, vJAge, vJSex,
						vJProvince, vJCity);
				Vector vdata = new Vector(100);
				vdata.add(sm.getJICQ());
				vdata.add(sm.getJShowName());
				vdata.add(sm.getJAge());
				vdata.add(sm.getJSex());
				vdata.add(sm.getJProvince());
				vdata.add(sm.getJCity());
				data.add(vdata);
			}
			pageNum = 1;
			totalV = data;
			Userpage();
			conn.close();
			// 行的事件
			selectionMode.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					// Ignore extra messages.
					if (e.getValueIsAdjusting())
						return;

					lsm = (ListSelectionModel) e.getSource();
					if (lsm.isSelectionEmpty()) {
					} else {

					}
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void Userpage() {
		lbCurrent.setText("当前第" + pageNum + "页");
		int totalSize = totalV.size();
		int countPerPage = 3;
		totalPageNum = totalSize / countPerPage;
		Vector currentPageV = new Vector(100);

		if (totalSize % countPerPage > 0) {
			totalPageNum = totalSize / countPerPage + 1;
		}

		for (int j = 0; j < totalV.size(); j++) {
			if ((j >= (pageNum - 1) * countPerPage)
					&& (j < pageNum * countPerPage)) {
				currentPageV.addElement(totalV.get(j));
			}
			if (currentPageV.size() == countPerPage) {

				break;
			}
			if (pageNum == 1) {
				this.btOnpage.setEnabled(false);
				this.btNextpage.setEnabled(true);
			}
			if (pageNum == totalPageNum) {
				this.btNextpage.setEnabled(false);
				this.btOnpage.setEnabled(true);

			}
			if (pageNum == 1 && pageNum == totalPageNum) {
				this.btNextpage.setEnabled(false);
				this.btOnpage.setEnabled(false);

			}

		}
		DefaultTableModel dt = new DefaultTableModel(currentPageV, vhead) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};

		selectionMode = tableSearch.getSelectionModel();
		selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSearch.setModel(dt);
		tableSearch.updateUI();
		this.jTabbedPane1.setSelectedIndex(2);

	}

	// 查找类型事件
	public void stateChanged(ChangeEvent e) {
		index = this.jTabbedPane1.getSelectedIndex();

		if (index == 0) {
			if (rbtOnline.isSelected() == true) {
				Condition = 0;
			}
			if (rbtDetailSearch.isSelected() == true) {
				Condition = 1;
			}
		}
		if (index == 1) {
			if (chbOnline.isSelected() == true) {
				Condition = 2;
			} else
				Condition = 3;
		}

		/*if(index==3){
			if(rbtKinds.isSelected()==true){
				Condition =4;
			}else{
				Condition=5;
			}
		}*/
	}

	// //高级查找条件事件
	public void itemStateChanged(ItemEvent e) {
		if (chbOnline.isSelected()) {
			Condition = 2;
		}
		if (chbOnline.isSelected() == false) {
			Condition = 3;
		}

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == rbtOnline) {
			this.jLabel2.setEnabled(false);
			this.jLabel3.setEnabled(false);
			this.tfJICQ.setEnabled(false);
			this.tfShowName.setEnabled(false);
			Condition = 0;
		}
		if (ev.getSource() == rbtDetailSearch) {
			this.jLabel2.setEnabled(true);
			this.jLabel3.setEnabled(true);
			this.tfJICQ.setEnabled(true);
			this.tfShowName.setEnabled(true);
			Condition = 1;
		}
		if (ev.getSource() == btSearch) {
			if (index == 2) {
				return;
			}

			ShowUser();
		}
		if (ev.getSource() == btOnpage) {
			if (pageNum != 1) {
				pageNum--;
				Userpage();
				this.btNextpage.setEnabled(true);
			}
		}
		if (ev.getSource() == btNextpage) {
			if (pageNum != totalPageNum) {
				pageNum++;
				Userpage();
				this.btOnpage.setEnabled(true);
			}

		}
		if (ev.getSource() == btExamination) {
			String hisJICQ = getJicq();
			if (hisJICQ != null) {
				UsersDetail ud = new UsersDetail();
				ud.setAllDetail(new Friends().selectAllDetail(hisJICQ));
			}
		}
		if (ev.getSource() == btClose) {
			this.dispose();
		}

		if (ev.getSource() == btAddFriend) {
			try {
				if (getJicq() != null) {
					int myJICQ = Integer.parseInt(mf.pTree.myJICQ);
					int hisJICQ = Integer.parseInt(getJicq());
					if (myJICQ != hisJICQ) {
						FriendAddFrame ff = new FriendAddFrame(mf, this);
						ff.setMessage();
					}

				}
			} catch (Exception ex) {
				return;
			}

		}
	}

	// 得到哪一行的ID
	public String getJicq() {
		if (tableSearch.getSelectedRow() >= 0) {
			int selectedRow = lsm.getMinSelectionIndex();
			String columns = tableSearch.getModel().getValueAt(selectedRow, 0)
					.toString();
			return columns;
		}
		return null;
	}

}

package pkgJICQ.client.frame;

import pkgJICQ.client.data.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import javax.swing.border.*;

public class FriendAddFrame extends JFrame implements ActionListener {
	JPanel contentPane;

	XYLayout xYLayout1 = new XYLayout();

	JPanel jPanel1 = new JPanel();

	XYLayout xYLayout2 = new XYLayout();

	JLabel lbShow = new JLabel();

	JLabel jLabel2 = new JLabel();

	JComboBox cbGroup = new JComboBox();

	JLabel jLabel3 = new JLabel();

	JTextField taCheck = new JTextField();

	JTextArea taRequest = new JTextArea();

	JLabel lbImage = new JLabel();

	JButton btEnter = new JButton();

	JButton btCancel = new JButton();

	JLabel lbCheck = new JLabel();

	TitledBorder titledBorder1;

	TitledBorder titledBorder2;

	JCheckBox chbYES = new JCheckBox();

	TitledBorder titledBorder3;

	TitledBorder titledBorder4;

	int hisJICQ = 0;

	int myJICQ = 0;

	java.util.Hashtable ht = new java.util.Hashtable();

	MyListFrame mf;

	MySearchFrame msf;

	public FriendAddFrame(MyListFrame mf, MySearchFrame msf) {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);

		this.mf = mf;
		this.msf = msf;
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		titledBorder1 = new TitledBorder("");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder("");
		titledBorder4 = new TitledBorder("");
		contentPane.setLayout(xYLayout1);

		jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		jPanel1.setLayout(xYLayout2);
		lbShow.setFont(new java.awt.Font("Dialog", 0, 14));
		lbShow.setText("�㽫���10000Ϊ����:");
		jLabel2.setFont(new java.awt.Font("DialogInput", 0, 12));
		jLabel2.setToolTipText("");
		jLabel2.setText("��ѡ����飺");
		jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
		jLabel3.setText("��֤�ַ�����");
		taCheck.setFont(new java.awt.Font("Dialog", 0, 12));
		taCheck.setBorder(BorderFactory.createLineBorder(Color.black));
		taCheck.setText("");
		taRequest.setFont(new java.awt.Font("MonoSpaced", 0, 12));
		taRequest.setBorder(BorderFactory.createLineBorder(Color.black));
		taRequest.setText("������д��������");
		lbImage.setBorder(BorderFactory.createLineBorder(Color.black));
		lbImage.setText("");
		btEnter.setFont(new java.awt.Font("Dialog", 0, 12));
		btEnter.setBorder(BorderFactory.createLineBorder(Color.black));
		btEnter.setText("ȷ�����");
		btEnter.addActionListener(this);
		btCancel.setText("ȡ��");
		btCancel.addActionListener(this);
		btCancel.setFont(new java.awt.Font("Dialog", 0, 12));
		btCancel.setBorder(BorderFactory.createLineBorder(Color.black));
		lbCheck.setEnabled(true);
		lbCheck.setFont(new java.awt.Font("Dialog", 1, 17));
		lbCheck.setForeground(Color.red);
		lbCheck.setBorder(titledBorder4);
		lbCheck.setText("8596");
		chbYES.setFont(new java.awt.Font("Dialog", 0, 12));
		chbYES.setActionCommand("����Է�����Ϊ����");
		chbYES.setSelected(true);
		chbYES.setText("����Է�����Ϊ����");
		cbGroup.setBackground(SystemColor.info);
		cbGroup.setFont(new java.awt.Font("Dialog", 0, 12));
		cbGroup.setForeground(UIManager
				.getColor("InternalFrame.inactiveTitleBackground"));
		cbGroup.setSelectedIndex(-1);
		jPanel1.add(jLabel2, new XYConstraints(10, 36, 81, 28));
		jPanel1.add(cbGroup, new XYConstraints(87, 38, 98, 18));
		jPanel1.add(taCheck, new XYConstraints(87, 66, 98, 18));
		jPanel1.add(jLabel3, new XYConstraints(9, 66, 80, 20));
		jPanel1.add(taRequest, new XYConstraints(8, 93, 316, 40));
		jPanel1.add(lbShow, new XYConstraints(8, 4, 210, 31));
		contentPane.add(jPanel1, new XYConstraints(11, 10, 337, 176));
		jPanel1.add(btCancel, new XYConstraints(257, 140, 68, 27));
		jPanel1.add(chbYES, new XYConstraints(8, 141, 137, 26));
		jPanel1.add(btEnter, new XYConstraints(152, 140, 91, 27));
		jPanel1.add(lbImage, new XYConstraints(266, 12, 59, 68));
		jPanel1.add(lbCheck, new XYConstraints(193, 63, 58, 22));

		this.setBounds(200, 200, 368, 234);
		this.setTitle("�������");
		this.setVisible(true);

	}

	public void setMessage() {
		try {
			hisJICQ = Integer.parseInt(msf.getJicq());
			myJICQ = Integer.parseInt(mf.pTree.myJICQ);
			lbShow.setText("�㽫���" + hisJICQ + "Ϊ����:");
			Friends f = new Friends();
			ResultSet rs = f.selectFriendTypes(String.valueOf(myJICQ));
			while (rs.next()) {
				String GroupName = rs.getString("JFriendTypeName");
				int GroupKey = rs.getInt("JFriendTypeID");
				cbGroup.addItem(GroupName);
				ht.put(GroupName, GroupKey);
			}
			rs = f.selectAllDetail(String.valueOf(hisJICQ));
			rs.next();
			int online = rs.getInt("JStatus");
			int picID = rs.getInt("JPicID");
			ImageIcon ii = null;
			if (online == 3)
				ii = new ImageIcon(MyCursor.path + "\\picture\\pHead\\" + picID
						+ ".gif");
			else
				ii = new ImageIcon(MyCursor.path
						+ "\\picture\\pHead\\pUnOnline\\" + picID + ".gif");
			lbImage.setIcon(ii);

			long rnd = (long) (Math.random() * (9999 - 1000 + 1) + 1000);
			lbCheck.setText(String.valueOf(rnd));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btEnter) {
			if (taCheck.getText().trim().equals(lbCheck.getText())) {
				Object cbKey = ht
						.get(String.valueOf(cbGroup.getSelectedItem()));
				int GroupKey = Integer.parseInt(cbKey.toString());
				System.out.println(GroupKey);
				mf.pTree.client.send("ADDFRIEND#" + hisJICQ + "#" + myJICQ
						+ "#" + GroupKey + "#" + taRequest.getText());// ���ͺ����������
				this.dispose();
			} else {
				long rnd = (long) (Math.random() * (9999 - 1000 + 1) + 1000);
				lbCheck.setText(String.valueOf(rnd));
				JOptionPane.showMessageDialog(null, "���������֤������,����������!", "��ע��!",
						JOptionPane.CANCEL_OPTION);
			}

		} else {
			this.dispose();
		}
	}

	// Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
		}
	}

	public static void main(String[] args) {

	}

}
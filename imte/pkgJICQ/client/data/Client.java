package pkgJICQ.client.data;

import pkgJICQ.client.frame.*;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Client implements Runnable {
	public static Socket socket;

	DataInputStream in;

	DataOutputStream out;

	Thread thread = null;

	MyPersonTree mt; 

	public static PlayMusic playMusic = new PlayMusic();

	public static LeastPerson lPerson = new LeastPerson(MyPersonTree.myJICQ);//�����ϵ��

	public Client(MyPersonTree mt) {
		this.mt = mt;
		try {
			System.out.println("into Client���캯��");
			//�Լ���ip��ַ
			socket = new Socket("127.0.0.1", 7891);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "��½ʧ�ܣ����������ڷ�������û�п�����������ԭ��!",
					"JICQ��ʾ", 1);
			ex.printStackTrace();
			System.exit(1);
		}

		if (thread == null) {
			System.out.println("client Thread == null new Thread");
			thread = new Thread(this);
			//�û���һ�ε�¼��ʱ������ѷ���������Ϣ
			send("PEOPLE#" + MyPersonTree.myJICQ);
			thread.setPriority(Thread.MIN_PRIORITY);
			thread.start();
		}
		// if((thread!=null)&&thread.isAlive()) //�ж��߳��Ƿ�������
		// { thread.interrupt(); thread=null; }

	}

	public void run() {
		try {
			String key = "";
			String line = "";
			while (true) {
				System.out.println("into Client run() method");
				line = in.readUTF();
				System.out.println(line);
				StringTokenizer stk = new StringTokenizer(line, "#"); // PEOPLE+"#"+JICQ
				if (stk.hasMoreElements())
					key = (String) stk.nextElement();
				if (key.equals("PEOPLE")) {
					try {
						//��ʾ��Ϣ �������ߵ�֮���
						String hisJICQ = (String) stk.nextElement();
						Person p = findPerson(hisJICQ);
						if (p != null) {
							MyShowPanel my = new MyShowPanel(); // (String
																// PicID,String
																// name,String
																// JICQ,String
																// IP,String
																// UnderWrite)
							my.setMessage(p.getpicID(), p.getname(), p.getID(),
									p.getIP(), p.getUnderWrite());
							my.setBounds(775, 565, 243, 167);

							my.setVisible(true);
							playMusic.goline();
							try {
								new ListPersonTree(mt).start(); // �������ʱ����Դ����ˢ��
								Thread.currentThread().sleep(2000);
								my.dispose();
							} catch (Exception ex) {
							}

						}

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} finally {
					}
				}

				if (key.equals("RELOG")) {
					try {
						JOptionPane.showMessageDialog(null,
								"���JICQ�����ڱ𴦵�½���㱻������!", "JICQ��ʾ", 1);
						this.in.close();
						this.out.close();
						this.socket.close();
						System.exit(1);
					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
					}
				}

				// MSGONE+HISJICQ+MYJICQ+headmsg+msg
				if (key.equals("MSGONE")) {
					try {
						String JICQ = (String) stk.nextElement();
						String hisJICQ = (String) stk.nextElement();
						String headmsg = (String) stk.nextElement();
						String msg = (String) stk.nextElement();

						Person p = null;
						for (int i = 0; i < MyPersonTree.alist.size(); i++) // �ж��ĸ����ѷ�����Ϣ
						{
							p = (Person) MyPersonTree.alist.get(i);
							if (p.getID().equals(hisJICQ))
								break;
							else
								p = null;
						}
						if (p != null) // ��������
						{
							JICQChatFrame jchatExist = null;
							int isExistFrame = 0;
							for (int i = 0; i < MyPersonTree.vector.size(); i++) // �жϴ����Ƿ񱻴�
							{
								jchatExist = (JICQChatFrame) MyPersonTree.vector
										.get(i);
								if (jchatExist.JICQ.equals(hisJICQ)) {
									isExistFrame = 1;
									break;
								}
							}
							if (isExistFrame == 0) {
								JICQChatFrame jchat = new JICQChatFrame(p, this);
								MyPersonTree.vector.addElement(jchat);
								jchat.setMessage(headmsg, msg);

							} else {
								jchatExist.setMessage(headmsg, msg);
							}

						} else // ���������Լ��������ͣ�û����ʾ��������Ϣ
						{
							JICQChatFrame jchatExist = null;
							int isExistFrame = 0;
							for (int i = 0; i < MyPersonTree.UnKonwVector
									.size(); i++) // �жϴ����Ƿ񱻴�
							{
								jchatExist = (JICQChatFrame) MyPersonTree.UnKonwVector
										.get(i);
								if (jchatExist.JICQ.equals(hisJICQ)) {
									isExistFrame = 1;
									break;
								}
							}
							if (isExistFrame == 0) {// (String ID,String
													// name,String picID,String
													// underWrite,int
													// friendType,String
													// IP,String showID,int
													// status)
								try {
									p = new Person(
											hisJICQ,
											"İ����"
													+ (MyPersonTree.UnKonwVector
															.size() + 1),
											"9999", "", 4, "δ֪IP", "9999", 3);
									int k = new Friends().insertFriends(Integer
											.parseInt(JICQ), Integer
											.parseInt(hisJICQ), 3);
									new ListPersonTree(mt).start(); // ˢ�º����б�
									JICQChatFrame jchat = new JICQChatFrame(p,
											this);
									MyPersonTree.UnKonwVector.addElement(jchat);
									jchat.setMessage(headmsg, msg);
								} catch (Exception ex) {
								}

							} else {
								jchatExist.setMessage(headmsg, msg);
							}
						}

						lPerson.writeToArrayList(hisJICQ);////?

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} catch (Exception ex) {
					}

				}

				if (key.equals("MSGGROUP")) // MSGGROUP+GroupID+MYJICQ+headmsg+msg
				{

					try {
						String GroupID = (String) stk.nextElement();
						String hisJICQ = (String) stk.nextElement();
						String headmsg = (String) stk.nextElement();
						String msg = (String) stk.nextElement();

						GroupChatFrame jchatExist = null;
						int isExistFrame = 0;

						for (int i = 0; i < MyListFrame.GroupVector.size(); i++) {
							jchatExist = (GroupChatFrame) MyListFrame.GroupVector
									.get(i);
							int ID = jchatExist.GroupID;
							if (String.valueOf(ID).equals(GroupID)) {
								isExistFrame = 1;
								break;
							}
						}
						if (isExistFrame == 0) {
							java.sql.ResultSet rs = new GroupDetail()
									.selectSingleGroup(GroupID);
							MyGroup myGroup = null;
							while (rs.next()) {
								int JGroupID = rs.getInt("JGroupID");
								String JGroupName = rs.getString("JGroupName");
								String JGroupType = rs.getString("JGroupType");
								String JGroupBcast = rs
										.getString("JGroupBcast");
								String JGroupInfo = rs.getString("JGroupInfo");
								myGroup = new MyGroup(JGroupID, JGroupName,
										JGroupType, JGroupBcast, JGroupInfo);
							}

							GroupChatFrame jchat = new GroupChatFrame(myGroup,
									this);
							MyListFrame.GroupVector.addElement(jchat);
						} else {
							jchatExist.setMessage(headmsg, msg);
						}

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} catch (Exception ex) {
					}

				}

				// �к������ߣ�ˢ����Ϣ
				if (key.equals("QUIT")) {
					new ListPersonTree(mt).start();
				}

				// ���Ӻ�����
				if (key.equals("ADDGROUP")) {
					try {
						String msg = (String) stk.nextElement();
						int flag = Integer.parseInt(msg);
						if (flag > 0) {

							playMusic.gosystem();
							try {

								JOptionPane.showMessageDialog(null, "����������ɹ�!",
										"JICQ��ʾ", 1);
								new ListPersonTree(mt).start(); // �������ʱ����Դ����ˢ��
							} catch (Exception ex) {
							}

						} else {
							playMusic.gosystem();
							JOptionPane.showMessageDialog(null,
									"��������ʧ�ܣq,��ȷ��������Ƿ���ȷ���Ժ�����!", "JICQ��ʾ", 1);
						}

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} finally {
					}
				}

				if (key.equals("ADDFRIEND")) {

					try {
						String myJICQ = (String) stk.nextElement();
						String hisJICQ = (String) stk.nextElement();
						String headmsg = (String) stk.nextElement();
						String reqmsg = (String) stk.nextElement();
						playMusic.gosystem();
						int k = JOptionPane.showConfirmDialog(null, hisJICQ
								+ "���㷢���������룺" + reqmsg + ",�Ƿ������������?", "��������",
								1, 1);

						if (k == JOptionPane.YES_OPTION) {
							this.send("COMFIRMADD#" + myJICQ + "#" + hisJICQ
									+ "#" + headmsg + "#1");
						} else if (k == JOptionPane.NO_OPTION) {
							this.send("COMFIRMADD#" + myJICQ + "#" + hisJICQ
									+ "#" + headmsg + "#0");
						}

					} catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					} catch (NullPointerException e) {
						e.printStackTrace();
					} finally {
					}
				}

				if (key.equals("COMFIRMADD")) {
					String JICQReceiver = (String) stk.nextElement();
					String JICQSender = (String) stk.nextElement();
					String headmsg = (String) stk.nextElement();
					int flag = Integer.parseInt((String) stk.nextElement());

					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "�Է��ܾ����������!",
								"JICQ��ʾ", 1); // �ܾ����ӵ�����
					} else {
						JOptionPane.showMessageDialog(null, "�Է�ͬ�����������!",
								"JICQ��ʾ", 1); // ���ӳɹ�������
						new ListPersonTree(mt).start();
					}
				}

				// ���Ӻ�����
				if (key.equals("DELGROUP")) {
					try {
						String msg = (String) stk.nextElement();
						int flag = Integer.parseInt(msg);
						if (flag > 0) {

							playMusic.gosystem();
							try {

								JOptionPane.showMessageDialog(null, "ɾ��������ɹ�!",
										"JICQ��ʾ", 1);
								new ListPersonTree(mt).start(); // �������ʱ����Դ����ˢ��
							} catch (Exception ex) {
							}

						} else {
							playMusic.gosystem();
							JOptionPane.showMessageDialog(null,
									"ɾ������ʧ�ܣq,��ȷ��������Ƿ���ȷ���Ժ�����!", "JICQ��ʾ", 1);
						}

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} finally {
					}
				}

				// ����ɾ������
				if (key.equals("DELFRIEND")) {
					try {
						String msg = (String) stk.nextElement();
						int flag = Integer.parseInt(msg);

						if (flag > 0) {

							playMusic.gosystem();
							try {

								JOptionPane.showMessageDialog(null, "ɾ�����ѳɹ�!",
										"JICQ��ʾ", 1);
								new ListPersonTree(mt).start(); // �������ʱ����Դ����ˢ��
							} catch (Exception ex) {
							}

						} else {
							playMusic.gosystem();
							JOptionPane.showMessageDialog(null,
									"ɾ������ʧ�ܣq,��ȷ��������Ƿ���ȷ���Ժ�����!", "JICQ��ʾ", 1);
						}

					} catch (ArrayIndexOutOfBoundsException e) {
					} catch (NullPointerException e) {
					} catch (Exception ex) {
					}
				}

				// �к��Ѹı�״̬
				if (key.equals("STATUS")) {
					new ListPersonTree(mt).start();
				}

			}// end while
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͨѶʧ�ܣ����������ڷ�������û�п�����������ԭ��!",
					"JICQ��ʾ", 1);
			System.exit(1);
		}

	}

	public Person findPerson(String hisJICQ) {
		Person p = null;
		for (int i = 0; i < MyPersonTree.alist.size(); i++) {
			p = (Person) MyPersonTree.alist.get(i);

			if (p.getID().equals(hisJICQ)) {
				break;
			}

		}
		return p;
	}

	public void send(String msg) {
		try {
			System.out.println("into Client send() method");
			out.writeUTF(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
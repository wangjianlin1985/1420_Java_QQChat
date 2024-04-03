package pkgJICQ.client.frame;
import pkgJICQ.client.data.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class JICQLogin extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 367127852483165147L;
	JLabel jname,jpassword,jimage;//���ñ�ǩ
	TextField tfName;//�����ı���
	TextField tfPassword;//����������
	//TextField jtf2;
	public JButton jbLogin,jbCancel,jb3,jb4;//���ð�ť
	//JCheckBox jcb1,jcb2;//���ø�ѡ��
	Container con;//�����������
	JPanel jp1,jp2,jp3,jp4;//�м�����
	MainFrame mf;
	public JICQLogin(MainFrame mf)
	{
		super("JICQ��½����");//���ñ���
		this.mf=mf;
		
		//thisָ�����õ�ǰ�����Ķ���,this=qq; 
		con=this.getContentPane();//�õ��������
		con.setLayout(new GridLayout(4,1));//GridLayout ����һ�����ִ����������Ծ���������ʽ��������������в���
		
		jname =new JLabel("JICQ����:");//�ֱ����ǩ��������
		jname.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		
		jpassword =new JLabel("JICQ����:");
		
		jpassword.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		
		jimage =new JLabel();
		LoginPic lpic=new LoginPic();
		String picname=lpic.selectLoginPicID();
		//System.out.println(picname);
		String pathPicname=MyCursor.path+"\\picture\\pLogin\\"+picname;
		Icon ii=new ImageIcon(pathPicname);
		
		//Icon һ��С�Ĺ̶���СͼƬ��ͨ������װ�����
	   //	ImageIcon�Ķ�����������ĳ��ͼƬ
	  //	System.out.println(this.getClass().getResource("log.jpg"));
		
		jimage.setIcon(ii);
		tfName=new TextField(15);//ָ���ı���ĳ���,15���ַ�
		tfPassword =new TextField(15);
		tfPassword.setEchoChar('*');//���������ֶ�
		
		jbLogin =new JButton("��½");
		jbLogin.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		
		jbLogin.addActionListener(this);
		jbLogin.setIcon(new ImageIcon(MyCursor.path+"\\picture\\pLogin\\confrm.gif"));
		
		jbCancel =new JButton("ȡ��");
		jbCancel.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		jbCancel.addActionListener(this);
		jbCancel.setIcon(new ImageIcon(MyCursor.path+"\\picture\\pLogin\\cancel.gif"));
		
		jb3 =new JButton("����");
		jb3.addActionListener(this);
		jb3.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		
		jb4 = new JButton("�߼����á�");
		//���û�м��¼�����,ֻ��Ϊ����ʾ�ÿ�����ô����
		jb4.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		
		/*jcb1 =new JCheckBox("�Զ���½");
		jcb1.setFont(new Font("����",Font.ROMAN_BASELINE,12));
		//ͬ��������Ҳû�м��¼�����
		jcb2 =new JCheckBox("�����½");
		//jcb2.addc
		jcb2.setFont(new Font("����",Font.ROMAN_BASELINE,12));*/
		
		jp1 =new JPanel();
		jp2 =new JPanel();
		jp3 =new JPanel();
		jp4 = new JPanel();
		
		jp1.add(jimage);//���ͼƬ
		jp2.setLayout(null);
		jp2.add(jname);
		jp2.add(tfName);
		jp2.add(jpassword);
		jp2.add(tfPassword);
		jp2.add(jb3);
		/*jp3.add(jcb1);
		jp3.add(jcb2);*/
		////////////////////////////////////////////////////
		jname.setBounds(50,5,80,30);//???�Ҳ����������
		tfName.setBounds(110,8,120,20);
		jpassword.setBounds(50,30,80,30);
		tfPassword.setBounds(110,35,120,20);
		//jcb1.setBounds(135,141,59,181);
		jb3.setBounds(240,8,60,20);
		//JPanel��Ĭ�ϲ��־�����ʽ����
		//JFrame��Ĭ�ϲ����Ǳ߽粼��
		jp4.add(jb4);
		jp4.add(jbLogin);
		jp4.add(jbCancel);
		jp4.setLayout(null);
		jb4.setBounds(18,18,100,22);
		jbLogin.setBounds(140,18,80,22);
		jbLogin.setFocusable(true);
		
		jbCancel.setBounds(230,18,78,22);
		this.setResizable(false);//��ֹ������󻯣���С���ɱ䣩	
		
		con.add(jp1);
		con.add(jp2);
		con.add(jp3);
		con.add(jp4);
		
	
		this.setBounds(300,200,330,250);
		this.setSize(330,240);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("into JICQLogin%%%");
		
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		String name=this.tfName.getText().trim();
		String password=this.tfPassword.getText().trim();
		try{
			if(event.getSource()==jb3)
			{
				try{
                        //////////////////////////					
						Runtime rt=Runtime.getRuntime();   
  						String file="C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE"+" http://127.0.0.1:8080/zhuce/firsts.htm";   
 						rt.exec(file);
				}catch(Exception ex){ex.printStackTrace();}
			}
			
			if(event.getSource()==jbCancel)
			{
				System.exit(1);
			}
			
			else if(event.getSource()==jbLogin)
			{
				
				if(name.length()<=0||password.length()<=0)
				{
					JOptionPane.showMessageDialog(this.mf.mlf,"JICQ����������벻��Ϊ��!","ϵͳ��ʾ",1);
					return;
				}
				if(validateString(name)==false)
				{
					JOptionPane.showMessageDialog(this.mf.mlf,"JICQ�������Ϊ���֣������!","ϵͳ��ʾ",1);
					return;
				}
				
				MyDetails mydata=new MyDetails();
				int flag=mydata.validateUserDetails(name,password);//��֤�û���������
				//-1��ʾʧ�� 3��ʾ������½???????
				if(flag!=-1)
				{
					if(flag!=3)
					{
						System.out.println("into JICQLogin ��¼");
						MyPersonTree.myJICQ=this.tfName.getText().trim();
						mf.mlf=new MyListFrame();
						System.out.println("��¼��");
						mf.mlf.setVisible(true);
						
						this.mf.mlf.combox.setEnabled(false);
						this.setVisible(false);
					}
					else
					{
						//JOptionPane.showMessageDialog(this.mf.mlf,"JICQ�����Ѿ��ڱ�ĵط���½!","ϵͳ��ʾ",1);
						System.out.println("into JICQLogin ��¼*********");
						MyPersonTree.myJICQ=this.tfName.getText().trim();
						mf.mlf=new MyListFrame();
						mf.mlf.setVisible(true);
						this.mf.mlf.combox.setEnabled(false);
						this.setVisible(false);
					}
					
				}
				else//��֤û��ͨ��
				{
					System.out.println("#"+tfName.getText()+"#"+tfPassword.getText()+"#");
					JOptionPane.showMessageDialog(this.mf.mlf,tfName.getText()+"#"+tfPassword.getText()+" "+MyCursor.path+" JICQ��������������벻��ȷ�������!","ϵͳ��ʾ",1);
				}
			}
			
			
		}catch(Exception ex){return;}
		
	}
	
	
	public boolean validateString(String str)
	{
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)<48 || str.charAt(i)>57)
			{
				return false;
			}
			
		}
		return true;
	}

	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
		}
	}
}
 
 
 

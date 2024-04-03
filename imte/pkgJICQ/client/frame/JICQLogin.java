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
	JLabel jname,jpassword,jimage;//设置标签
	TextField tfName;//设置文本区
	TextField tfPassword;//设置密码区
	//TextField jtf2;
	public JButton jbLogin,jbCancel,jb3,jb4;//设置按钮
	//JCheckBox jcb1,jcb2;//设置复选框
	Container con;//设置内容面板
	JPanel jp1,jp2,jp3,jp4;//中间容器
	MainFrame mf;
	public JICQLogin(MainFrame mf)
	{
		super("JICQ登陆界面");//设置标题
		this.mf=mf;
		
		//this指代调用当前方法的对象,this=qq; 
		con=this.getContentPane();//得到内容面板
		con.setLayout(new GridLayout(4,1));//GridLayout 类是一个布局处理器，它以矩形网格形式对容器的组件进行布置
		
		jname =new JLabel("JICQ号码:");//分别给标签设置名字
		jname.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		
		jpassword =new JLabel("JICQ密码:");
		
		jpassword.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		
		jimage =new JLabel();
		LoginPic lpic=new LoginPic();
		String picname=lpic.selectLoginPicID();
		//System.out.println(picname);
		String pathPicname=MyCursor.path+"\\picture\\pLogin\\"+picname;
		Icon ii=new ImageIcon(pathPicname);
		
		//Icon 一个小的固定大小图片，通常用于装饰组件
	   //	ImageIcon的对象用来代表某张图片
	  //	System.out.println(this.getClass().getResource("log.jpg"));
		
		jimage.setIcon(ii);
		tfName=new TextField(15);//指定文本域的长度,15个字符
		tfPassword =new TextField(15);
		tfPassword.setEchoChar('*');//设置密码字段
		
		jbLogin =new JButton("登陆");
		jbLogin.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		
		jbLogin.addActionListener(this);
		jbLogin.setIcon(new ImageIcon(MyCursor.path+"\\picture\\pLogin\\confrm.gif"));
		
		jbCancel =new JButton("取消");
		jbCancel.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		jbCancel.addActionListener(this);
		jbCancel.setIcon(new ImageIcon(MyCursor.path+"\\picture\\pLogin\\cancel.gif"));
		
		jb3 =new JButton("申请");
		jb3.addActionListener(this);
		jb3.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		
		jb4 = new JButton("高级设置↓");
		//这个没有加事件处理,只是为了显示好看才这么做的
		jb4.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		
		/*jcb1 =new JCheckBox("自动登陆");
		jcb1.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));
		//同样这两个也没有加事件处理
		jcb2 =new JCheckBox("隐身登陆");
		//jcb2.addc
		jcb2.setFont(new Font("宋体",Font.ROMAN_BASELINE,12));*/
		
		jp1 =new JPanel();
		jp2 =new JPanel();
		jp3 =new JPanel();
		jp4 = new JPanel();
		
		jp1.add(jimage);//添加图片
		jp2.setLayout(null);
		jp2.add(jname);
		jp2.add(tfName);
		jp2.add(jpassword);
		jp2.add(tfPassword);
		jp2.add(jb3);
		/*jp3.add(jcb1);
		jp3.add(jcb2);*/
		////////////////////////////////////////////////////
		jname.setBounds(50,5,80,30);//???找不到这个方法
		tfName.setBounds(110,8,120,20);
		jpassword.setBounds(50,30,80,30);
		tfPassword.setBounds(110,35,120,20);
		//jcb1.setBounds(135,141,59,181);
		jb3.setBounds(240,8,60,20);
		//JPanel的默认布局就是流式布局
		//JFrame的默认布局是边界布局
		jp4.add(jb4);
		jp4.add(jbLogin);
		jp4.add(jbCancel);
		jp4.setLayout(null);
		jb4.setBounds(18,18,100,22);
		jbLogin.setBounds(140,18,80,22);
		jbLogin.setFocusable(true);
		
		jbCancel.setBounds(230,18,78,22);
		this.setResizable(false);//禁止窗口最大化（大小不可变）	
		
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
					JOptionPane.showMessageDialog(this.mf.mlf,"JICQ号码或者密码不能为空!","系统提示",1);
					return;
				}
				if(validateString(name)==false)
				{
					JOptionPane.showMessageDialog(this.mf.mlf,"JICQ号码必须为数字，请检验!","系统提示",1);
					return;
				}
				
				MyDetails mydata=new MyDetails();
				int flag=mydata.validateUserDetails(name,password);//验证用户名和密码
				//-1表示失败 3表示正常登陆???????
				if(flag!=-1)
				{
					if(flag!=3)
					{
						System.out.println("into JICQLogin 登录");
						MyPersonTree.myJICQ=this.tfName.getText().trim();
						mf.mlf=new MyListFrame();
						System.out.println("登录中");
						mf.mlf.setVisible(true);
						
						this.mf.mlf.combox.setEnabled(false);
						this.setVisible(false);
					}
					else
					{
						//JOptionPane.showMessageDialog(this.mf.mlf,"JICQ号码已经在别的地方登陆!","系统提示",1);
						System.out.println("into JICQLogin 登录*********");
						MyPersonTree.myJICQ=this.tfName.getText().trim();
						mf.mlf=new MyListFrame();
						mf.mlf.setVisible(true);
						this.mf.mlf.combox.setEnabled(false);
						this.setVisible(false);
					}
					
				}
				else//验证没有通过
				{
					System.out.println("#"+tfName.getText()+"#"+tfPassword.getText()+"#");
					JOptionPane.showMessageDialog(this.mf.mlf,tfName.getText()+"#"+tfPassword.getText()+" "+MyCursor.path+" JICQ号码或者密码输入不正确，请检验!","系统提示",1);
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
 
 
 

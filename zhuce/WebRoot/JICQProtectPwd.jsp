<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="java.sql.*"%>
<HTML>
	<HEAD>
		<TITLE>JICQ�ʺŷ������ġ����뱣��</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="JICQProtectPwd.files/account.css" type=text/css
			rel=stylesheet>
		<SCRIPT language=JavaScript src="JICQProtectPwd.files/initial.js"></SCRIPT>

		<SCRIPT language=JavaScript src="JICQProtectPwd.files/common.js"></SCRIPT>

		<SCRIPT language=javascript>
function CheckForm()
{
	var ctrl,result;
	ctrl = document.getElementById("oldCardNo");
	if (ctrl.value == "")
	{
		alert("����д֤�����룡");
		return false;
	}
	
	ctrl = document.getElementById("oldKeyAnswer");
	if (ctrl.value == "")
	{
		alert("����д����𰸣�");
		return false;
	}
	
	ctrl = document.getElementById("oldEmail");
	if (ctrl.value == "")
	{
		alert("����д��ȫE-mail��");
		return false;
	}
	
	ctrl = document.getElementById("newquestion");
	if (ctrl.value == "")
	{
		alert("����д��������ʾ���⣡");
		return false;
	}
	
	ctrl = document.getElementById("newanswer");
	if (ctrl.value == "" )
	{
		alert("����д��������ʾ�𰸣�");
		return false;
	}

	ctrl = document.getElementById("confirmanswer");
	if (ctrl.value == "" )
	{
		alert("����дȷ����������ʾ�𰸣�");
		return false;
	}else
	{
		var answer = document.getElementById("newanswer");
		if (ctrl.value != answer.value)
		{
			alert("ȷ����������ʾ������������ʾ�𰸲�һ�£�");
			return false;		
		}
	}	
	disabledSubmit("btnSubmit");
    return true;
}

function resetPage()
{
	var ctrls = document.body.getElementsByTagName("Input");
	for(var i=0;i<=ctrls.length-1;i++)
	{
		if (ctrls[i].value != undefined && ctrls[i].value != null && ctrls[i].type != "button" && ctrls[i].type != "submit")
		{
			ctrls[i].value = "";
		}
	}
}

</SCRIPT>

		<META content="MSHTML 6.00.2900.3020" name=GENERATOR>
	</HEAD>
	<BODY>
		<%
			String JICQShowName = (String) session.getValue("JShowName");
			String JProtectPwdQuestions = (String) session
					.getValue("JProtectPwdQuestion");
			if (JICQShowName == null) {
				out
				.print("<script>alert('���ȵ�½JICQ�������ģ�');location.href='loginIn.jsp';</script>");
			}
		%>
		<FORM id=frm name=frm onsubmit="return CheckForm()"
			action="DoJICQPwdProtect.jsp" method=post autocomplete="off">
			<DIV align=center>
				<LINK href="JICQProtectPwd.files/account.css" type=text/css
					rel=stylesheet>
				<TABLE id=test2 cellSpacing=0 cellPadding=0 width=760 border=0>
					<TBODY>
						<TR>
							<TD>
								<TABLE id=dffdsd cellSpacing=0 cellPadding=0 width=760 border=0>
									<TBODY>
										<TR>
											<TD width=258>
												<IMG src="JICQProtectPwd.files/logo.gif">
											</TD>
											<TD vAlign=bottom>
												<TABLE id=test3 cellSpacing=0 cellPadding=0 width="100%"
													border=0>
													<TBODY>
														<TR>
															<TD width="100%" height=30 align=right class=Head>
																<font color="#990000"><b><%=JICQShowName%>
																</b>
																</font>���ã� ��ӭ������JICQ�ʺŷ������ģ�
																<A class=blue href="JICQServerIndex.jsp">�˳�</A>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD height=4></TD>
						</TR>
					</TBODY>
				</TABLE>
				<SCRIPT language=JavaScript src="JICQProtectPwd.files/menu.js"></SCRIPT>

				<SCRIPT language=javascript>

	var mainMenu = ["default","request","myAccount","found","help"];
	function ModifyMenu(number)
	{
		var ctrl = document.getElementById(mainMenu[number]+ "td");
		if (ctrl != null)
		{
			if (number == 0 || number == 1)
			{
				ctrl.background="/images/menu_btn_3.gif"
			}else
			{
				ctrl.background="/images/menu_btn_1.gif"
			}
		}
		var ctrl = document.getElementById(mainMenu[number]+ "lnk");
		if (ctrl != null)
		{
			ctrl.className=""
		}
	}
	
</SCRIPT>

				<TABLE id=test1 onmouseout=ChangeMenu(event,this) height=28
					cellSpacing=0 cellPadding=0 width=760
					background=JICQProtectPwd.files/menu_bg2.gif border=0>
					<TBODY>
						<TR>
							<TD width=3></TD>
							<TD id=defaulttd width=90>
								<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
									<A class=main_menu id=defaultlnk href="JICQServerIndex1.jsp">��
										ҳ</A>
								</DIV>
							</TD>
							<TD width=7>
								<IMG height=28 src="JICQProtectPwd.files/menu_bg1.gif" width=7>
							</TD>
							<TD id=requesttd width=90>
								<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
									<A class=main_menu id=requestlnk href="firsts.htm"
										target=_blank>�����ʺ�</A>
								</DIV>
							</TD>
							<TD width=7>
								<IMG height=28 src="JICQProtectPwd.files/menu_bg1.gif" width=7>
							</TD>
							<TD id=myAccounttd
								onmouseover="HideMenu();ShowMenu(this,'childMenu1');" width=90
								background=JICQProtectPwd.files/menu_btn_2.gif>
								<DIV class=main_menu_text>
									<A class=main_menu id=myAccountlnk href="myJICQ.jsp">�ҵ��ʺ�</A>
								</DIV>
							</TD>
							<TD width=7>
								<IMG height=28 src="JICQProtectPwd.files/menu_bg1.gif" width=7>
							</TD>
							<TD id=helptd width=90>
								<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
									<A class=main_menu id=foundlnk href="JICQFindPwd.jsp">�һغ���</A>
								</DIV>
							</TD>
							<TD width=292>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<DIV id=childMenu1
					style="DISPLAY: none; Z-INDEX: 999; WIDTH: 0px; POSITION: relative; HEIGHT: 0px"
					onmouseout=ChangeMenu(event,this);>
					<DIV class=menu_down_box
						style="Z-INDEX: 999; WIDTH: 91px; POSITION: absolute; HEIGHT: 50px">
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD class=menu_down_2 id=childMenu11
										onmouseover=ShowItemMenu(this.id,1)>
										<DIV id=dd style="TEXT-ALIGN: center">
											<A class=menu_down id=lnkmyAccountSafe href="myJICQ.jsp">���뱣��</A>&nbsp;
										</DIV>
									</TD>
								</TR>
								<TR>
									<TD class=menu_down_2 id=childMenu12
										onmouseover=ShowItemMenu(this.id,1)>
										<DIV id=dd style="TEXT-ALIGN: center">
											<A class=menu_down id=lnkmyAccountChange
												href="ChangeJICQPwd.jsp">�޸�����</A>&nbsp;
										</DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</DIV>
				</DIV>
				<DIV id=childMenu2
					style="DISPLAY: none; Z-INDEX: 999; WIDTH: 0px; POSITION: relative; HEIGHT: 0px"
					onmouseout=ChangeMenu(event,this);>
				</DIV>
				<TABLE height=8 cellSpacing=0 cellPadding=0 width=760 border=0>
					<TBODY>
						<TR>
							<TD></TD>
						</TR>
					</TBODY>
				</TABLE>

				<TABLE id=table6 cellSpacing=0 cellPadding=0 width=760 border=0>
					<TBODY>
						<TR>
							<TD vAlign=top width=145>
								<LINK href="/images/account.css" type=text/css rel=stylesheet>
								<LINK href="JICQProtectPwd.files/account.css" type=text/css
									rel=stylesheet>
								<TABLE cellSpacing=0 cellPadding=5 width="100%" align=center
									border=0>
									<TBODY>
										<TR>
											<TD class=menu_left_title id=menu1 colSpan=2>
												�ʺŰ�ȫ
											</TD>
										</TR>
										<TR>
											<TD class=menu_1_mouseoff id=menu2 colSpan=2>
												<A class=menu_left href="JICQProtectPwd.jsp">���뱣��</A>
											</TD>
										</TR>
										<TR>
											<TD class=menu_1_mouseoff id=menu3>
												<A class=menu_left href="ChangeJICQPwd.jsp" target=_blank>�޸�����</A>
											</TD>
										</TR>
										<TR>
											<TD id=menu3 background=JICQProtectPwd.files/menuleft_bg.gif
												height=90>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
							<TD vAlign=top width=15 rowSpan=2></TD>
							<TD vAlign=top rowSpan=2>
								<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
									<TBODY>
										<TR>
											<TD height=25>
												<SPAN class=Text_induct>�ҵ��ʺ� -&gt; ���뱣�� -&gt;
													�޸����뱣������ </SPAN>
											</TD>
										</TR>
										<TR>
											<TD vAlign=top>
												<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
													<TBODY>
														<TR>
															<TD bgColor=#c0d1e2 height=1></TD>
														</TR>
														<TR>
															<TD height=6></TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
								<TABLE id=table8 cellSpacing=0 cellPadding=0 width="100%"
									align=center border=0>
									<TBODY>
										<TR>
											<TD height=20>
												<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
													<TBODY>
														<TR>
															<TD>
																<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
																	<TBODY>
																		<TR>
																			<TD height=30>
																				<SPAN class=Title16><FONT class=Title_14>����д�ɵ����뱣������</FONT>
																				</SPAN>
																			</TD>
																		</TR>
																		<TR>
																			<TD>
																				<TABLE class=unnamed1 id=table25 cellSpacing=0
																					cellPadding=5 width="90%" border=0>
																					<TBODY>
																						<TR>
																							<TD width="30%">
																								<DIV align=right>
																									֤�����ͣ�
																								</DIV>
																							</TD>
																							<TD colSpan=2>
																								<SPAN class=Red><SELECT id=cardSelect
																										style="WIDTH: 180px" name=cardSelect>
																										<OPTION value=0 selected>
																											���֤
																										</OPTION>
																										<OPTION value=1>
																											����֤
																										</OPTION>
																										<OPTION value=2>
																											����
																										</OPTION>
																										<OPTION value=3>
																											����֤��
																										</OPTION>
																										<OPTION value=4>
																											�绰����
																										</OPTION>
																									</SELECT> *</SPAN>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									֤�����룺
																								</DIV>
																							</TD>
																							<TD colSpan=2>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=oldCardNo
																										style="WIDTH: 180px" maxLength=29 size=26
																										name=oldCardNo> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									������ʾ���⣺
																								</DIV>
																							</TD>
																							<TD colSpan=2>
																								<b><font color=#CC3300><%=JProtectPwdQuestions%>
																								</font>
																								</b>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									���Ļش�
																								</DIV>
																							</TD>
																							<TD colSpan=2>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=oldKeyAnswer
																										style="WIDTH: 180px" maxLength=39 size=26
																										name=oldKeyAnswer> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									��ȫ�����ʼ���ַ��
																								</DIV>
																							</TD>
																							<TD colSpan=2>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=oldEmail
																										style="WIDTH: 180px" maxLength=39 size=26
																										name=oldEmail> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																					</TBODY>
																				</TABLE>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
																<TABLE height=20 cellSpacing=0 cellPadding=0
																	width="100%" align=center border=0>
																	<TBODY>
																		<TR>
																			<TD vAlign=bottom>
																				<HR color=#c0d1e2 noShade SIZE=1>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
																<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
																	<TBODY>
																		<TR>
																			<TD height=30>
																				<FONT class=Title_14>����д�µ����뱣������</FONT>
																			</TD>
																		</TR>
																		<TR>
																			<TD>
																				<TABLE cellSpacing=0 cellPadding=5 width="90%"
																					border=0>
																					<TBODY>
																						<TR>
																							<TD width="30%">
																								<DIV align=right>
																									��������ʾ���⣺
																								</DIV>
																							</TD>
																							<TD>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=newquestion
																										style="WIDTH: 180px" maxLength=39 size=26
																										name=newquestion> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									��������ʾ�𰸣�
																								</DIV>
																							</TD>
																							<TD>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=newanswer
																										style="WIDTH: 180px" maxLength=39 size=26
																										name=newanswer> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																						<TR>
																							<TD>
																								<DIV align=right>
																									ȷ����������ʾ�𰸣�
																								</DIV>
																							</TD>
																							<TD>
																								<FONT color=#000080><INPUT
																										class=boxinputgrey id=confirmanswer
																										onkeydown='enterKeydown(event,"btnSubmit")'
																										style="WIDTH: 180px" maxLength=39 size=26
																										name=confirmanswer> <SPAN class=Red>*</SPAN>
																								</FONT>
																							</TD>
																						</TR>
																					</TBODY>
																				</TABLE>
																				<TABLE height=20 cellSpacing=0 cellPadding=0
																					width="100%" align=center border=0>
																					<TBODY>
																						<TR>
																							<TD vAlign=bottom>
																								<HR color=#c0d1e2 noShade SIZE=1>
																							</TD>
																						</TR>
																					</TBODY>
																				</TABLE>
																				<BR>
																				<TABLE cellSpacing=0 cellPadding=0 width="100%"
																					align=center border=0>
																					<TBODY>
																						<TR>
																							<TD>
																								<p style="text-align: center">
																									<SPAN style="TEXT-ALIGN: center">&nbsp;<INPUT
																											class=app_ImgBtn_Big id=btnSubmit type=submit
																											value="ȷ ��" name=btnSubmit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																										&nbsp;&nbsp;</SPAN>
																									<INPUT class=app_ImgBtn_Big
																										style="CURSOR: hand"
																										onclick="resetPage();return false;" tabIndex=7
																										type=submit value="ȡ ��" name=button>
																							</TD>
																						</TR>
																					</TBODY>
																				</TABLE>
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
												<TABLE height=20 cellSpacing=0 cellPadding=0 width="100%"
													border=0>
													<TBODY></TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD vAlign=bottom>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<BR>
				<BR>
				<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
					<TBODY>
						<TR>
							<TD bgColor=#c0d1e2 height=1></TD>
						</TR>
						<TR>
							<TD height=35>
								<TABLE cellSpacing=0 cellPadding=0 align=center border=0>
									<TBODY>
										<TR>
											<TD class=Foot>
												<TABLE cellSpacing=0 cellPadding=0 align=center border=0
													id="table26">
													<TBODY>
														<TR>
															<TD class=Foot>
																&copy; 2006-2024. All rights reserved&nbsp;
															</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</FORM>
	</BODY>
</HTML>

<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.sql.*"%>
<HEAD>
	<TITLE>JICQ帐号服务中心—我的帐号</TITLE>
	<META http-equiv=Content-Type content="text/html; charset=gb2312">
	<LINK href="myJICQ.files/account.css" type=text/css rel=stylesheet>
	<LINK href="myJICQ.files/account[1].css" type=text/css rel=stylesheet>
</head>
<BODY>
	<%
		String JICQShowName = (String) session.getValue("JShowName");
		if (JICQShowName == null) {
			out
			.print("<script>alert('请先登陆JICQ号码中心！');location.href='loginIn.jsp';</script>");
		}
	%>
	<DIV align=center>

		<LINK href="myJICQ.files/account[1].css" type=text/css rel=stylesheet>
		<TABLE id=test2 cellSpacing=0 cellPadding=0 width=760 border=0>
			<TBODY>
				<TR>
					<TD>
						<TABLE id=dffdsd cellSpacing=0 cellPadding=0 width=760 border=0>
							<TBODY>
								<TR>
									<TD width=258>
										<IMG src="myJICQ.files/logo[1].gif">
									</TD>
									<TD vAlign=bottom>
										<TABLE id=test3 cellSpacing=0 cellPadding=0 width="100%"
											border=0>
											<TBODY>
												<TR>
													<TD class=Head align=right colSpan=3 height=30>
														<font color="#990000"><b><%=JICQShowName%>
														</b>
														</font>您好， 欢迎您来到JICQ帐号服务中心！
														<A class=blue href="JICQServerIndex.jsp">退出</A>
													</TD>
												</TR>
												<TR>
													<TD class=Head align=right width="80%" height=30>
													</TD>
													<TD class=Head align=right width="20%">
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




		<TABLE id=test1 height=28 cellSpacing=0 cellPadding=0 width=760
			background="myJICQ.files/menu_bg2[1].gif" border=0>
			<TBODY>
				<TR>
					<TD width=3></TD>
					<TD id=defaulttd width=90>
						<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
							<A class=main_menu id=defaultlnk href="JICQServerIndex1.jsp">首
								页</A>
						</DIV>
					</TD>
					<TD width=7>
						<IMG height=28 src="myJICQ.files/menu_bg1[1].gif" width=7>
					</TD>
					<TD id=requesttd width=90>
						<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
							<A class=main_menu id=requestlnk href="firsts.htm" target=_blank>申请帐号</A>
						</DIV>
					</TD>
					<TD width=7>
						<IMG height=28 src="myJICQ.files/menu_bg1[1].gif" width=7>
					</TD>
					<TD id=myAccounttd width=90
						background="myJICQ.files/menu_btn_1[1].gif">
						<DIV class=main_menu_text>
							<A class="" id=myAccountlnk href="myJICQ.jsp">我的帐号</A>
						</DIV>
					</TD>
					<TD width=7>
						<IMG height=28 src="myJICQ.files/menu_bg1[1].gif" width=7>
					</TD>
					<TD width=7>
						<IMG height=28 src="myJICQ.files/menu_bg1[1].gif" width=7>
					</TD>
					<TD id=helptd width=90>
						<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
							<A class=main_menu id=foundlnk href="JICQFindPwd.jsp">找回号码</A>
						</DIV>
					</TD>
					<TD width=292>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<DIV id=childMenu1
			style="DISPLAY: none; Z-INDEX: 999; LEFT: -187px; WIDTH: 0px; POSITION: relative; TOP: 0px; HEIGHT: 0px">
			<DIV class=menu_down_box
				style="Z-INDEX: 999; WIDTH: 91px; POSITION: absolute; HEIGHT: 50px">
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
					<TBODY>
						<TR>
							<TD class=menu_down_2 id=childMenu11>
								<DIV id=dd style="TEXT-ALIGN: center">
									<A class=menu_down id=lnkmyAccountSafe href="myJICQ.jsp">密码保护</A>&nbsp;
								</DIV>
							</TD>
						</TR>
						<TR>
							<TD class=menu_down_1 id=childMenu12>
								<DIV id=dd style="TEXT-ALIGN: center">
									<A class=menu_down id=lnkmyAccountChange
										href="ChangeJICQPwd.jsp" target=_blank>修改密码</A>&nbsp;
								</DIV>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
		<DIV id=childMenu2
			style="DISPLAY: none; Z-INDEX: 999; LEFT: -91px; WIDTH: 0px; POSITION: relative; TOP: 0px; HEIGHT: 0px">
		</DIV>
		<TABLE height=8 cellSpacing=0 cellPadding=0 width=760 border=0>
			<TBODY>
				<TR>
					<TD></TD>
				</TR>
			</TBODY>
		</TABLE>




		<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
			<TBODY>
				<TR>
					<TD vAlign=top width=145>
						<LINK href="myJICQ.files/account[1].css" type=text/css
							rel=stylesheet>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" align=center
							border=0>
							<TBODY>
								<TR>
									<TD class=menu_left_title id=menu1 colSpan=2>
										帐号安全
									</TD>
								</TR>
								<TR>
									<TD class=menu_2_mouseoff id=menu2 colSpan=2>
										<A class=menu_left href="JICQProtectPwd.jsp">密码保护</A>
									</TD>
								</TR>
								<TR>
									<TD class=menu_1_mouseoff id=menu3>
										<A class=menu_left href="ChangeJICQPwd.jsp" target=_blank>修改密码</A>
									</TD>
								</TR>
								<TR>
									<TD id=menu3 background="myJICQ.files/menuleft_bg[1].gif"
										height=90>
									</TD>
								</TR>
							</TBODY>
						</TABLE>

					</TD>
					<TD vAlign=top width=15 rowSpan=2></TD>
					<TD vAlign=top rowSpan=2>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center
							border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
											<TBODY>
												<TR>
													<TD bgColor=#c0d1e2 height=1></TD>
												</TR>
											</TBODY>
										</TABLE>
										<BR>
										<TABLE cellSpacing=15 cellPadding=0 width="100%" border=0>
											<TBODY>
												<TR>
													<TD vAlign=top width=30>
														<IMG height=33 src="myJICQ.files/icon_safety1[1].gif"
															width=28>
													</TD>
													<TD>
														<TABLE cellSpacing=0 cellPadding=0 border=0>
															<TBODY>
																<TR>
																	<TD class=Title_14>
																		密码保护问题
																	</TD>
																</TR>
																<TR>
																	<TD class=Text_inside>
																		已设置
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
													<TD width="23%">
														【
														<A class=blackunderline12 id=xiugai
															href="JICQProtectPwd.jsp">修改</A>】
													</TD>
													<TD width="45%">
														密码保护问题是进行密码修改、密码保护信息变更的重要凭证。请牢记问题与答案。
													</TD>
												</TR>
												<TR>
													<TD height=5></TD>
												</TR>
												<TR>
													<TD vAlign=top>
														<IMG height=33 src="myJICQ.files/icon_safety1[1].gif"
															width=28>
													</TD>
													<TD>
														<TABLE cellSpacing=0 cellPadding=0 border=0>
															<TBODY>
																<TR>
																	<TD class=Title_14 noWrap>
																		安全电子邮件地址
																	</TD>
																</TR>
																<TR>
																	<TD class=Text_inside>
																		已设置
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
													<TD>
														【
														<A class=blackunderline12 href="JICQPwdEmailProtect.jsp">修改</A>】
													</TD>
													<TD width="45%">
														安全电子邮件地址用于接收JICQ帐号安全相关的电子邮件。
													</TD>
												</TR>
												<TR>
													<TD height=5></TD>
												</TR>
											</TBODY>
										</TABLE>
										<BR>
										<BR>
										<BR>
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
											id="table27">
											<TBODY>
												<TR>
													<TD class=Foot>
														<TABLE cellSpacing=0 cellPadding=0 align=center border=0
															id="table28">
															<TBODY>
																<TR>
																	<TD class=Foot>
																		&copy;2006-2024. All rights reserved&nbsp;
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
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>

















</BODY>

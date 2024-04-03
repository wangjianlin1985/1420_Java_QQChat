<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="java.sql.*"%>
<HTML>
	<HEAD>
		<TITLE>JICQ帐号服务中心</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="JICQServerIndex.files/account.css" type=text/css
			rel=stylesheet>


		<META content="MSHTML 6.00.2900.3020" name=GENERATOR>
	</HEAD>
	<BODY>

		<%
			String JICQShowName = (String) session.getValue("JShowName");
			if (JICQShowName == null) {
				out
				.print("<script>alert('请先登陆JICQ号码中心！');location.href='loginIn.jsp';</script>");
			}
		%>
		<DIV align=center>
			<LINK href="JICQServerIndex.files/account.css" type=text/css
				rel=stylesheet>
			<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
				<TBODY>
					<TR>
						<TD>
							<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
								<TBODY>
									<TR>
										<TD width=258>
											<IMG src="JICQServerIndex.files/logo.gif">
										</TD>
										<TD vAlign=bottom>
											<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
												<TBODY>
													<TR>
														<TD class=Head align=right>
															<font color="#990000"><b><%=JICQShowName%>
															</b>
															</font>欢迎您来到JICQ帐号服务中心！
															<A class=blue href="JICQServerIndex.jsp">退出</A>
															<INPUT id=QQNUM type=hidden name=QQNUM>
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
						<TD align=middle height=4></TD>
					</TR>
				</TBODY>
			</TABLE>
			<SCRIPT language=JavaScript src="JICQServerIndex.files/menu.js"></SCRIPT>


			<TABLE id=test1 onmouseout=ChangeMenu(event,this) height=28
				cellSpacing=0 cellPadding=0 width=760
				background=JICQServerIndex.files/menu_bg2.gif border=0>
				<TBODY>
					<TR>
						<TD width=3></TD>
						<TD id=defaulttd width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<a href="JICQServerIndex1.jsp">首 页</a>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="JICQServerIndex.files/menu_bg1.gif" width=7>
						</TD>
						<TD id=requesttd width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=requestlnk href="firsts.htm" target=_blank>申请帐号</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="JICQServerIndex.files/menu_bg1.gif" width=7>
						</TD>
						<TD id=myAccounttd
							onmouseover="HideMenu();ShowMenu(this,'childMenu1');" width=90
							background=JICQServerIndex.files/menu_btn_2.gif>
							<DIV class=main_menu_text>
								<A class=main_menu id=myAccountlnk href="myJICQ.jsp">我的帐号</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="JICQServerIndex.files/menu_bg1.gif" width=7>
						</TD>
						<TD id=defaulttd0 width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<a href="JICQFindPwd.jsp"><font color="#FFFFFF">找回密码</font>
								</a>
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
										<A class=menu_down id=lnkmyAccountSafe href="myJICQ.jsp">密码保护</A>&nbsp;
									</DIV>
								</TD>
							</TR>
							<TR>
								<TD class=menu_down_2 id=childMenu12
									onmouseover=ShowItemMenu(this.id,1)>
									<DIV id=dd style="TEXT-ALIGN: center">
										<A class=menu_down id=lnkmyAccountChange
											href="ChangeJICQPwd.jsp">修改密码</A>&nbsp;
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
				<DIV class=menu_down_box
					style="Z-INDEX: 999; WIDTH: 89px; POSITION: absolute; HEIGHT: 50px">
				</DIV>
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
						<TD vAlign=top rowSpan=2>
							<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TBODY>
									<TR>
										<TD></TD>
									</TR>
									<TR>
										<TD>
											<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
												<TBODY>
													<TR>
														<TD>
															<DIV align=left>
																<BR>
																<IMG height=99 src="JICQServerIndex.files/img_index.gif"
																	width=494 border=0>
																<BR>
																<BR>
															</DIV>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE cellSpacing=0 cellPadding=0 width=494 border=0>
												<TBODY>
													<TR>
														<TD vAlign=bottom height=25>
															<DIV style="PADDING-BOTTOM: 3px" align=left>
																如果您忘了密码或号码被盗：
															</DIV>
														</TD>
													</TR>
													<TR>
														<TD background=JICQServerIndex.files/index_bg_1.gif>
														</TD>
													</TR>
													<TR>
														<TD height=15>
															&nbsp;
														</TD>
													</TR>
												</TBODY>
											</TABLE>
											<TABLE cellSpacing=0 cellPadding=0 width="92%" border=0>
												<TBODY>
													<TR>
														<TD width="34%">
															<DIV align=left>
																<INPUT onclick="window.location.href='JICQFindPwd.jsp'"
																	type=image src="JICQServerIndex.files/main_qq_btn.gif"
																	name=B12>
															</DIV>
														</TD>
														<TD class=clew_text_1 width="66%">
															如果您记得密码保护问题的答案，且安全电子邮箱可用，可在这里自助找回帐号。
														</TD>
													</TR>
													<TR>
														<TD colSpan=2 height=30>
														</TD>
													</TR>
													<TR>
														<TD>
															<DIV align=left>
															</DIV>
														</TD>
														<TD>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
											<BR>
											<BR>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
						<TD bgColor=#b8d9e8></TD>
						<TD vAlign=top>
							<BR>
							<TABLE cellSpacing=5 cellPadding=5 width="100%" border=0>
								<TBODY>
									<TR>
										<TD vAlign=top>
											<DIV align=center>
												<a href="JICQServerIndex1.jsp"><IMG
														src="JICQServerIndex.files/btn_logo.gif" border=0>
												</a>
											</DIV>
										</TD>
									</TR>
									<TR>
										<TD>
											<TABLE cellSpacing=5 cellPadding=5 width="80%" align=right
												border=0>
												<TBODY>
													<TR>
														<TD>
															<SPAN class=Title_12>登录后，您可以：</SPAN>
															<BR>
														</TD>
													</TR>
													<TR>
														<TD>
															<IMG height=10 src="JICQServerIndex.files/icon_index.gif"
																width=7>
															<font color="#00CC66">申请密码保护</font>
														</TD>
													</TR>
													<TR>
														<TD>
															<IMG height=10 src="JICQServerIndex.files/icon_index.gif"
																width=7>
															<font color="#00CC66">修改密码保护</font>
														</TD>
													</TR>
													<TR>
														<TD>
															<IMG height=10 src="JICQServerIndex.files/icon_index.gif"
																width=7>
															<font color="#00CC66">修改帐号密码</font>
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
						<TD width=1 bgColor=#b8d9e8></TD>
						<TD vAlign=bottom width=220>
							<DIV style="HEIGHT: 30px" align=center>
								<a href="firsts.htm">申请新JICQ号</a>
							</DIV>
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
											&copy;2006-2024. All rights reserved&nbsp;
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
</HTML>

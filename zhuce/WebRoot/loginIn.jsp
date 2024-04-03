<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="java.sql.*"%>
<HEAD>
	<script language="javascript">
function loadimage(){
document.getElementById("randImage").src = "image.jsp?"+Math.random();
}
</script>

	<TITLE>欢迎您来到JICQ帐号服务中心</TITLE>
	<META http-equiv=Content-Type content="text/html; charset=gb2312">
	<LINK href="Login.files/account[1].css" type=text/css rel=stylesheet>

</HEAD>
<BODY>
	<FORM id=frm name=frm method=post action="CheckLogin.jsp">
		<DIV align=center>

			<LINK href="Login.files/account[1].css" type=text/css rel=stylesheet>
			<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
				<TBODY>
					<TR>
						<TD>
							<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
								<TBODY>
									<TR>
										<TD width=258>
											<IMG src="Login.files/logo[1].gif">
										</TD>
										<TD vAlign=bottom>
											<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
												<TBODY>
													<TR>
														<TD class=Head align=right>
															欢迎您来到JICQ帐号服务中心！
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




			<TABLE id=test1 height=28 cellSpacing=0 cellPadding=0 width=760
				background="Login.files/menu_bg2[1].gif" border=0>
				<TBODY>
					<TR>
						<TD width=3></TD>
						<TD id=defaulttd width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=defaultlnk href="JICQServerIndex.jsp">首
									页</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="Login.files/menu_bg1[1].gif" width=7>
						</TD>
						<TD id=requesttd width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=requestlnk href="firsts.htm" target=_blank>申请帐号</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="Login.files/menu_bg1[1].gif" width=7>
						</TD>
						<TD id=myAccounttd width=90
							background="Login.files/menu_btn_1[1].gif">
							<DIV class=main_menu_text>
								<A class="" id=myAccountlnk href="loginIn.jsp">我的帐号</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="Login.files/menu_bg1[1].gif" width=7>
						</TD>
						<TD id=helptd width=90>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<a href="JICQServerIndex.jsp"><font color="#FFFFFF">找回密码</font>
								</a>
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
					style="Z-INDEX: 999; WIDTH: 91px; POSITION: absolute; HEIGHT: 50px; left:344px; top:0px">
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD class=menu_down_1 id=childMenu11>
									<DIV id=dd style="TEXT-ALIGN: center">
										<A class=menu_down id=lnkmyAccountSafe href="loginIn.jsp">密码保护</A>&nbsp;
									</DIV>
								</TD>
							</TR>
							<TR>
								<TD class=menu_down_2 id=childMenu12>
									<DIV id=dd style="TEXT-ALIGN: center">
										<A class=menu_down id=lnkmyAccountChange href="loginIn.jsp">修改密码</A>&nbsp;
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
			<TABLE id=table5 height=300 cellSpacing=0 cellPadding=0 width=760
				border=0>
				<TBODY>
					<TR>
						<TD vAlign=top>
							<TABLE cellSpacing=3 cellPadding=0 width="100%" border=0>
								<TBODY>
									<TR>
										<TD width="4%" height=28>
											<IMG height=33 src="Login.files/icon_title2[1].gif" width=33>
										</TD>
										<TD width="96%">
											<SPAN class=Title_14>我的帐号</SPAN>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE id=table10 cellSpacing=0 cellPadding=0 width=760 border=0>
								<TBODY>
									<TR>
										<TD bgColor=#c0d1e2 height=1></TD>
									</TR>
								</TBODY>
							</TABLE>
							<BR>
							<TABLE cellSpacing=0 cellPadding=0 width=650 align=center
								border=0 id="table11">
								<TBODY>
									<TR>
										<TD>
											<DIV style="FLOAT: left")>
												<FIELDSET class=app_gimage>
													<LEGEND>
														<DIV
															style="FONT-WEIGHT: bold; FONT-SIZE: 14px; WIDTH: 100px; HEIGHT: 20px; TEXT-ALIGN: center">
															<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0
																id="table12">
																<TBODY>
																	<TR>
																		<TD width=33>
																			<IMG height=28 src="Login.files/icon_table3[1].gif"
																				width=28>
																		</TD>
																		<TD class=Title_14 width=100>
																			请登录
																		</TD>
																	</TR>
																</TBODY>
															</TABLE>
														</DIV>
													</LEGEND>
													<TABLE id=table13 height=75 cellSpacing=5 cellPadding=0
														width="100%" align=center border=0>
														<TBODY>
															<TR>
																<TD>
																	<TABLE cellSpacing=5 cellPadding=1 width="100%"
																		border=0 id="table14">
																		<TBODY>
																			<TR>
																				<TD>
																					<TABLE cellSpacing=3 cellPadding=3 width="100%"
																						align=center border=0 valign="top" id="table15">
																						<TBODY>
																							<TR>
																								<TD id=passwordTitle colSpan=3>
																									<DIV style="PADDING-LEFT: 170px">
																										<STRONG><BR>
																										</STRONG>
																									</DIV>
																									<DIV id=passwordTips
																										style="DISPLAY: none; Z-INDEX: 999; WIDTH: 0px; POSITION: relative; HEIGHT: 0px">
																									</DIV>
																								</TD>
																							</TR>
																							<TR>
																								<TD width="30%">
																									<DIV align=right>
																										QQ帐号：
																									</DIV>
																								</TD>
																								<TD align=left width="60%">
																									<DIV align=left>
																										<INPUT class=boxinput id=p
																											style="WIDTH: 180px" type="text" maxLength=16
																											size=24 value="" name=JICQNumber>
																										<SPAN class=Red>*</SPAN>
																									</DIV>
																								</TD>
																								<TD width="10%">
																								</TD>
																							</TR>
																							<TR>
																								<TD>
																									<DIV style="PADDING-BOTTOM: 12px" align=right>
																										QQ密码：
																									</DIV>
																								</TD>
																								<TD id=passwordtd align=left>
																									<INPUT class=boxinput id=userid
																										style="WIDTH: 180px" maxLength=16 size=24
																										name=JICQPwd>
																									<SPAN class=Red> *</SPAN>
																									<DIV style="PADDING-TOP: 2px">
																										<A class=blue tabIndex=-1
																											href="https://account.qq.com/cgi-bin/console_forgetPW?reLogin=true"
																											target=_blank>忘了密码？</A>
																									</DIV>
																								</TD>
																								<TD></TD>
																							</TR>
																							<TR>
																								<TD>
																									<DIV align=right noWrap>
																										验证图片：
																									</DIV>
																								</TD>
																								<TD vAlign=center align=left colSpan=2>
																									<TABLE cellSpacing=0 cellPadding=0 width="100%"
																										border=0 height="21" id="table16">
																										<TBODY>
																											<TR>
																												<TD>

																													<img alt="code..." name="randImage"
																														id="randImage" src="image.jsp" width="60"
																														height="20" border="1" align="absmiddle">
																													<a href="javascript:loadimage();"><font
																														class=pt95> <u>看不清点我</u>
																													</font>
																													</a>
																												</TD>
																											</TR>
																										</TBODY>
																									</TABLE>
																								</TD>
																							</TR>
																							<TR>
																								<TD vAlign=bottom>
																									<DIV style="PADDING-BOTTOM: 3px" align=right>
																										验证字符：
																									</DIV>
																								</TD>
																								<TD noWrap align=left>
																									请输入上图中字符，大小写忽略
																									<BR>
																									<INPUT class=boxinput id=code
																										style="WIDTH: 180px; COLOR: #666666"
																										maxLength=4 size=24 name=code>
																									<SPAN class=Red>*</SPAN>
																								</TD>
																								<TD></TD>
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
												</FIELDSET>
											</DIV>
										</TD>
									</TR>
									<TR>
										<TD height=50>
											<BR>
											<TABLE cellSpacing=5 cellPadding=0 width="60%" align=center
												border=0 id="table17">
												<TBODY>
													<TR>
														<TD>
															<DIV>
																<SPAN style="TEXT-ALIGN: center"><INPUT
																		class=app_ImgBtn_Big id=btnSubmit type=submit
																		value="登 录" name=btnSubmit> </SPAN>
															</DIV>
														</TD>
														<TD>
															<DIV align=center>
																<SPAN style="TEXT-ALIGN: center"><INPUT
																		class=app_ImgBtn_Big type=button value="取 消" border=0
																		name=button> </SPAN>
															</DIV>
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
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
	</FORM>















</BODY>

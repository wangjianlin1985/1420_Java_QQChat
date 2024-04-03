<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="java.sql.*"%>
<HTML>
	<HEAD>
		<TITLE>JICQ帐号服务中心—密码保护</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="JICQFindPwd.files/account.css" type=text/css
			rel=stylesheet>
		<SCRIPT language=JavaScript src="JICQFindPwd.files/common.js"></SCRIPT>

		<SCRIPT language=JavaScript src="JICQFindPwd.files/initial.js"></SCRIPT>

		<SCRIPT language=javascript>
function CheckForm()
{
	var ctrl,result;

	ctrl = document.getElementById("JICQNum");
	if (ctrl.value == "")
	{
		alert("请输入您要找回的JICQ号码！");
		return false;
	}
	
	disabledSubmit("btnSubmit");
    return true;
}

</SCRIPT>

		<META content="MSHTML 6.00.2900.3020" name=GENERATOR>
	</HEAD>
	<BODY>
		<script language=javascript>   
  <!--   
  history.forward()   
  //-->   
  </script>

		<DIV align=center>
			<LINK href="JICQFindPwd.files/account.css" type=text/css
				rel=stylesheet>
			<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
				<TBODY>
					<TR>
						<TD>
							<TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
								<TBODY>
									<TR>
										<TD width=258>
											<IMG src="JICQFindPwd.files/logo.gif">
										</TD>
										<TD vAlign=bottom>
											<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
												<TBODY>
													<TR>
														<TD class=Head colSpan=2 height=30>
															<font color="#990000">&nbsp;</font>欢迎您来到JICQ帐号服务中心！
															<INPUT type=hidden value=70 name=hidSecurity>
															<INPUT id=QQNUM type=hidden value=71775249 name=QQNUM>
														</TD>
													</TR>
													<TR>
														<TD class=Head style="DISPLAY: none" width=348 height=30>
														</TD>
														<TD style="DISPLAY: none" align=right width=154>
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
			<SCRIPT language=JavaScript src="JICQFindPwd.files/menu.js"></SCRIPT>

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
	
	function openHelp(URL)
	{
		var width = 275;
		var height = screen.height-60;
		var left = parseInt(screen.width)-width-10;
		var params = "height=" + height + ",width=" + width +",top=0,left="+  left +",status=no,location=no,toolbar=no,directories=no,menubar=no,resizable=yes,scrollbars=yes"
		window.open(URL,"",params);
	}
</SCRIPT>

			<TABLE id=test1 onmouseout=ChangeMenu(event,this) height=28
				cellSpacing=0 cellPadding=0 width=761
				background=JICQFindPwd.files/menu_bg2.gif border=0>
				<TBODY>
					<TR>
						<TD width=5></TD>
						<TD id=defaulttd width=89>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=defaultlnk href="JICQServerIndex1.jsp">首
									页</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="JICQFindPwd.files/menu_bg1.gif" width=7>
						</TD>
						<TD id=requesttd width=89>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=requestlnk href="firsts.htm" target=_blank>申请帐号</A>
							</DIV>
						</TD>
						<TD width=7>
							<IMG height=28 src="JICQFindPwd.files/menu_bg1.gif" width=7>
						</TD>
						<TD id=helptd width=89>
							<DIV style="PADDING-TOP: 3px; TEXT-ALIGN: center">
								<A class=main_menu id=foundlnk href="ClearSession.jsp">找回号码</A>
							</DIV>
						</TD>
						<TD width=385>
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
						<TD>
							<TABLE id=table24 height=49 cellSpacing=3 cellPadding=0
								width="100%" border=0>
								<TBODY>
									<TR>
										<TD vAlign=top>
											<IMG height=33 src="JICQFindPwd.files/icon_title5.gif"
												width=33>
										</TD>
										<TD width="683">
											<FONT class=Title_14>通过密码保护问题取回JICQ密码</FONT><SPAN
												class=clew_text_1><BR>请先正确回答如下密码保护问题并选择取回密码</SPAN>,保护密码的问题为用户在注册时候所设置的,根据提示来做回答,问题正确方可取回密码,如果对密码有遗忘请联系客服
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
								<TBODY>
									<TR>
										<TD bgColor=#c0d1e2 height=1></TD>
									</TR>
								</TBODY>
							</TABLE>
							<FORM id=frm name=frm onsubmit="return CheckForm()"
								action="DoFindPwdLogin.jsp" method=post autocomplete="off">
								<TABLE id=table6 cellSpacing=0 cellPadding=0 width="100%"
									border=0>
									<TR>
										<TD vAlign=top>
											<DIV style="FLOAT: left; WIDTH: 650px">
												<FIELDSET class=app_gimage>
													<LEGEND>
													</legend>
													<DIV
														style="FONT-WEIGHT: bold; FONT-SIZE: 14px; WIDTH: 210px; HEIGHT: 20px; TEXT-ALIGN: center">
														<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
															<TBODY>
																<TR>
																	<TD width=33>
																		<IMG height=28 src="JICQFindPwd.files/icon_table3.gif"
																			width=28>
																	</TD>
																	<TD width="208" class=Title_14>
																		<p>
																			输入您要找回的JICQ帐号
																		</p>
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</DIV>
													<BR>
													<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
														<TBODY>
															<TR>
																<TD width="30%">
																	<DIV align=right>
																		JICQ号码：
																	</DIV>
																</TD>
																<TD>
																	<FONT color=#000080> <INPUT class=boxinputgrey
																			id=JICQNum maxLength=39 size=26 name=JICQNum>
																	</FONT>
																</TD>
															</TR>
														</TBODY>
													</TABLE>
													<BR>
												</FIELDSET>
											</DIV>
										</TD>
									</TR>
									<TBODY>
										<TR>
											<TD vAlign=top>
												<BR>
												<TABLE cellSpacing=5 width="60%" align=center border=0>
													<TBODY>
														<TR>
															<TD>
																<DIV align=center>
																	<INPUT class=app_ImgBtn_Big id=btnSubmit type=submit
																		value=确定提交 name=btnSubmit>
																</DIV>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</FORM>
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
																			&copy; 2006-2024. All rights
						                                                    reserved&nbsp;
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
</HTML>

<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="java.sql.*"%>
<HTML>
	<HEAD>

		<script language="javascript">
function loadimage(){
document.getElementById("randImage").src = "image.jsp?"+Math.random();
}
</script>

		<meta http-equiv="Content-Language" content="zh-cn">
		<TITLE>修改JICQ密码</TITLE>

		<SCRIPT language=javascript src="ChangeJICQPwd.files/check.js"></SCRIPT>

		<META http-equiv=Content-Type content="text/html; charset=gb2312">


		<LINK href="ChangeJICQPwd.files/im[2].css" type=text/css
			rel=stylesheet>
		<LINK href="ChangeJICQPwd.files/mg[1].css" type=text/css
			rel=stylesheet>
		<LINK href="indexxxxx.css" type=text/css rel=stylesheet>


	</head>
	<BODY>
		<%
			String JICQNumbers = (String) session.getValue("JicqNumbers");
			if (JICQNumbers == null) {
				out
				.print("<script>alert('请先登陆JICQ号码中心！');location.href='loginIn.jsp';</script>");
			}
		%>
		<TABLE cellSpacing=0 cellPadding=0 width=750 align=center border=0>
			<TBODY>
				<TR>
					<TD colSpan=3>
						<IMG height=1 src="ChangeJICQPwd.files/imqq4_top01_01[1].gif"
							width=750>
					</TD>
				</TR>
				<TR>
					<TD>
						<IMG height=27 src="ChangeJICQPwd.files/imqq4_top01_02[1].gif"
							width=4>
					</TD>
					<TD width=742
						background="ChangeJICQPwd.files/imqq4_top01_03[4].gif" height=27>
					</TD>
					<TD>
						<IMG height=27 src="ChangeJICQPwd.files/imqq4_top01_04[1].gif"
							width=4>
					</TD>
				</TR>
				<TR>
					<TD colSpan=3>
						<IMG height=3 src="ChangeJICQPwd.files/imqq4_top01_05[1].gif"
							width=750>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		
		<TABLE cellSpacing=0 cellPadding=0 width=750 align=center border=0>
			<TBODY>
				<TR>
					<TD height=6></TD>
				</TR>
			</TBODY>
		</TABLE>
		<DIV id=base>
			<DIV id=main>
				<DIV id=main-bg>


					<DIV id=hint style="width: 422px; height: 232px">

						<b> <font color="#0000FF" size="7"> <img border="0"
									src="ChangeJICQPwd.files/icon-info[1].gif" width="29"
									height="29">《如何让您的号码更安全》</font>
						</b>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							1、请为您JICQ的号码设置一个不易被人猜到的密码。
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							2、在修改密码时请选用“安全模式”，以最大限度防止木马病毒截取您的密码。
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							3、及时为您的JICQ号码申请“密码保护”，“密码保护”可以帮您找回遗失的密码。
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							4、请您不要在 非官方网站以外的任何地方泄露您的的的的的的JICQ密码。
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							5、请对您的计算机进行经常/定期病毒扫描，防范木马等可能盗取密码的病毒。
					</DIV>
					<DIV>
						<DIV>
							<DIV id=activate style="width: 319px; height: 247px">
								<UL>
									<LI class=security>
										修改密码（安全模式）
									<LI class=row01>
										<DIV id=pass3>
											<DIV id=main-bottom>
												<TABLE cellSpacing=0 cellPadding=0 width=289 align=center
													border=0>
													<FORM id=form1 name=form1 onsubmit="return CheckForm()"
														action="DoChangePwd.jsp" method=post>
														<INPUT type=hidden value=name=tm>
														<INPUT type=hidden name=oldpwd>
														<INPUT type=hidden name=newpwd1>
														<INPUT type=hidden name=newpwd2>
														<INPUT type=hidden value=1 name=type>
														<INPUT type=hidden value=71775249 name=uin>
													<TBODY>
														<TR>
															<TD
																style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 8px; PADDING-TOP: 0px"
																width=269 colSpan=2>
																您要修改密码的号码为：
																<font color=#FF9933><b><%=JICQNumbers%>
																</b>
																</font>
																<BR>
															</TD>
														</TR>
														<INPUT id=c66f type=hidden value=7f20f82d name=ssi>
														<TR>
															<TD class=bluebo align=right width=88>
																旧密码：
															</TD>
															<TD align=left>
																<DIV id=pass1>
																	<input name="oldJICQPwd" type="text" id="oldJICQPwd"
																		maxlength="16">
																</DIV>
															</TD>
														</TR>
														<TR>
															<TD colSpan=2 height=8></TD>
														</TR>
														<TR>
															<TD class=bluebo align=right>
																新密码：
															</TD>
															<TD>
																<DIV id=pass4>
																	<input name="newJICQPwd" type="text" id="newJICQPwd"
																		maxlength="16">
																</DIV>
															</TD>
														</TR>
														<TR>
															<TD colSpan=2 height=3></TD>
														</TR>
														<TR>
															<TD class=bluebo align=right width=86>
																重复新密码：
															</TD>
															<TD>
																<input name="newJICQRePwd" type="text" id="newJICQRePwd"
																	maxlength="16">
															</TD>
														</TR>
														<TR>
															<TD></TD>
															<TD style="LINE-HEIGHT: 14px" align=left>
																密码由6-16个字符组成，区分大小写
																<BR>
																（不能是8位以下纯数字）
															</TD>
														</TR>
														<TR>
															<TD colSpan=2 height=8></TD>
														</TR>
														<TR>
															<TD class=bluebo align=right>
																验证图片：
															</TD>
															<TD>
																<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
																	<TBODY>
																		<TR>
																			<TD>

																				<img alt="code..." name="randImage" id="randImage"
																					src="image.jsp" width="60" height="20" border="1"
																					align="absmiddle">
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
															<TD colSpan=2 height=8></TD>
														</TR>
														<TR>
															<TD class=bluebo align=right>
																验证字符：
															</TD>
															<TD>
																<input type="text" name="code" size="20">
															</TD>
														</TR>
														<TD></TD>
														<TD>
															<INPUT
																style="FONT-WEIGHT: bold; WIDTH: 55px; HEIGHT: 24px"
																tabIndex=6 type=submit value="提 交" name=Submit1>
														</TD>
														</FORM>
													</TBODY>
												</TABLE>
												<DIV
													style="CLEAR: both; DISPLAY: block; FONT: 0px/0px sans-serif"></DIV>
											</DIV>
										</DIV>
										<DIV id=pass2>

										</DIV>
									</LI>
								</UL>
							</DIV>
						</DIV>
					</DIV>
				</DIV>
			</DIV>
		
	</BODY>
</HTML>

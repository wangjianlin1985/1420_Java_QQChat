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
		<TITLE>�޸�JICQ����</TITLE>

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
				.print("<script>alert('���ȵ�½JICQ�������ģ�');location.href='loginIn.jsp';</script>");
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
									height="29">����������ĺ������ȫ��</font>
						</b>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							1����Ϊ��JICQ�ĺ�������һ�����ױ��˲µ������롣
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							2�����޸�����ʱ��ѡ�á���ȫģʽ����������޶ȷ�ֹľ������ȡ�������롣
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							3����ʱΪ����JICQ�������롰���뱣�����������뱣�������԰����һ���ʧ�����롣
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							4��������Ҫ�� �ǹٷ���վ������κεط�й¶���ĵĵĵĵĵ�JICQ���롣
						</P>
						<P>
							<img border="0" src="ChangeJICQPwd.files/arrow-close[1].gif"
								width="14" height="14">
							5��������ļ�������о���/���ڲ���ɨ�裬����ľ��ȿ��ܵ�ȡ����Ĳ�����
					</DIV>
					<DIV>
						<DIV>
							<DIV id=activate style="width: 319px; height: 247px">
								<UL>
									<LI class=security>
										�޸����루��ȫģʽ��
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
																��Ҫ�޸�����ĺ���Ϊ��
																<font color=#FF9933><b><%=JICQNumbers%>
																</b>
																</font>
																<BR>
															</TD>
														</TR>
														<INPUT id=c66f type=hidden value=7f20f82d name=ssi>
														<TR>
															<TD class=bluebo align=right width=88>
																�����룺
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
																�����룺
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
																�ظ������룺
															</TD>
															<TD>
																<input name="newJICQRePwd" type="text" id="newJICQRePwd"
																	maxlength="16">
															</TD>
														</TR>
														<TR>
															<TD></TD>
															<TD style="LINE-HEIGHT: 14px" align=left>
																������6-16���ַ���ɣ����ִ�Сд
																<BR>
																��������8λ���´����֣�
															</TD>
														</TR>
														<TR>
															<TD colSpan=2 height=8></TD>
														</TR>
														<TR>
															<TD class=bluebo align=right>
																��֤ͼƬ��
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
																					class=pt95> <u>���������</u>
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
																��֤�ַ���
															</TD>
															<TD>
																<input type="text" name="code" size="20">
															</TD>
														</TR>
														<TD></TD>
														<TD>
															<INPUT
																style="FONT-WEIGHT: bold; WIDTH: 55px; HEIGHT: 24px"
																tabIndex=6 type=submit value="�� ��" name=Submit1>
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

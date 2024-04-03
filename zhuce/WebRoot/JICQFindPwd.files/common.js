/*加密控件长度与种子值*/
var RsaMaxLength = 316;
var RsaParamSeed = "01234567890123456789";

function checkKey(value,type)
{
	var result = 0;
	var reg;
	type = parseInt(type);
	if (value == "")
	{
		result = 2;
	}else if (type == 0) //数字
	{
		reg = /^\d{2,16}$/;
		if (reg.test(value))
		{
			result = 1;
		}
	}else if (type == 1)//中文英文
	{
		reg = /^([\u4e00-\u9fa5]{1,19}|[A-Za-z ]{2,38})$/;
		if (reg.test(value))
		{
			result = 1;
		}	
	}else if (type == 2)//日期
	{
	    var r = value.match(/^(\d{4})(\d{2})(\d{2})$/); 
	    if(r!=null)
	    {
			var year = parseInt(r[1]);
			var month =  new Number(r[2]);
			var day = new Number(r[3]);
			if(year>1900&&year<2100&&month>0&&month<13&&day>0&&day<32)
			{
				result = 1;
			}
	   	}
	}
	return result;
}

function checkPassword(value)
{
	var result;
	var reg = / /;
	if (value == "") //空
	{
		result = 2;
	}else if (value.search(reg) >=0) //非法字符
	{
		result = 0;
	}else if (value.length<6 || value.length >16) //长度错误
	{
		result = 0;
	}else //正确
	{
		result = 1;
	}
	return result;
}

function checkQQNumber(value)
{
	var result;
	var reg = /^[1-9]{1}\d{4,9}$/;
	if (value == "")
	{
		result = 2;
	}else if (reg.test(value))
	{
		result = 1;
	}else
	{
		result = 0;
	}
	return result;
}

// 检查是否为有效的手机号码
function checkMobile(str)
{
	if(str.search(/(^(13|15|18)(\d{9})$)/) >= 0){
		return true;
	}else{
		return false;
	}
}

// 检查是否为有效的手机号码
function checkPhoneNumber(phone)
{
	var result;
	var reg = /(^(13|15|18)(\d{9})$)/;
	if (phone == "") //空
	{
		result = 2;
	}else if (phone.search(reg) >=0) //正确
	{
		result = 1;
	}else //错误
	{
		result = 0;
	}
	return result;
}

function checkMail(email)
{
	var bCheck;
	if (email == "")
	{
		bCheck = 2;
	}
	else if(email.search(/^[\w._-]+@[0-9a-zA-Z-\.]+\.[A-Za-z]{2,3}$/) >= 0)
	{
		var number = document.getElementById("QQNUM");
		var address = number.value + "@qq.com";
		if (email.toLowerCase()== address)
		{
			bCheck = 3;	
		}else if (email.length >=41)
		{
			bCheck = 0;
		}
		else
		{
			bCheck = 1;	
		}
	}else
	{
		bCheck = 0;	
	}
	return bCheck;
}

function checkVerifyCode(code)
{
	var bCheck;
	if (code == "")
	{
		bCheck = 2;
	}else if (code.length == 4)
	{
		bCheck = 1;
	}else
	{
		bCheck = 0;
	}
	return bCheck;
}

function checkMobileCode(value)
{
	var bCheck;
	var reg = /^\d{8}$/;
	if (value == "")
	{
		bCheck = 2;
	}else if (reg.test(value))
	{
		bCheck = 1;
	}else
	{
		bCheck = 0;
	}
	return bCheck;
}

function checkName(name)
{
	var reg=/^([\u4e00-\u9fa5]|[A-Za-z])+$/;
	if (name == "")
	{
		bCheck = 2;
	}else if (reg.test(name))
	{
		bCheck = 1;
	}else
	{
		bCheck = 0;
	}
	return bCheck;
}

function checkPersonalCard(str) 
{ 
	var isIDCard1 = new Object();
	var isIDCard2 = new Object();
	
	//身份证正则表达式(15位) 
	isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
	
	//身份证正则表达式(18位) 
	isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9Xx]{1}$/; 
	
	if (isIDCard1.test(str)||isIDCard2.test(str))
	{    
		return true;
	}
	return false;

} 
function checkCardNo(cardNo,type)
{
	var reg=/^([A-Za-z0-9])+$/;
	if (cardNo == "")
	{
		bCheck = 2;
	}else if (reg.test(cardNo))
	{
		if (type == 1)
		{
			if (!checkPersonalCard(cardNo))
			{
				bCheck = 0;
			}else
			{
				bCheck = 1;
			}
		}else
		{
			bCheck = 1;
		}
	}else
	{
		bCheck = 0;
	}
	return bCheck;
}


//重新获取验证字符
function changeImg()
{
	var img = document.getElementById("imgVerify");
	img.src = "http://verify.qq.com/getimage?" + Math.random();
	var ctrl = document.getElementById("verifyCode");
	if (ctrl != null)
	{
		ctrl.focus();
	}
}

//重新获取验证字符
function nchangeImg()
{
	var img = document.getElementById("imgVerify");
	img.src = "http://nverify.qq.com/getimage?" + Math.random();
	var ctrl = document.getElementById("code");
	if (ctrl != null)
	{
		ctrl.focus();
	}else
	{
		ctrl = document.getElementById("verifyCode");
		if (ctrl != null)
		{
			ctrl.focus();
		}
	}
}

//重新获取中文验证字符
function cchangeImg()
{
	var img = document.getElementById("imgVerify");
	img.src = "http://cverify.qq.com/getimage?" + Math.random();
	var ctrl = document.getElementById("code");
	if (ctrl != null)
	{
		ctrl.focus();
	}else
	{
		ctrl = document.getElementById("verifyCode");
		if (ctrl != null)
		{
			ctrl.focus();
		}
	}
}

function setItemByValue(id,value)
{
	var ctrl = document.getElementById(id);
	for(var j=0;j<=ctrl.options.length-1;j++)
	{
		if (ctrl.options[j].value == value)
		{
			ctrl.options[j].selected = true;
			break;
		}
	}
}

/*
** 答案控件控制方法
*/
function isEncryptCtrl(id)
{
	var ctrl = document.getElementById(id);
	if( (ctrl == null) || (ctrl.Mode==null) || (typeof(ctrl.Mode)=="undefined") )
	{
		return false;
	}else
	{
		return true;
	}
}

function displayText(flag)
{
	var div = document.getElementById("passwordTips");
	if (flag == 1)
	{
		div.style.display = "block";
	}else
	{
		div.style.display = "none";
	}
	
}

function checkPassCtrl(id,safe,unsafe)
{
	 var header = document.getElementById(id + "Header");
	 var headertd = document.getElementById(id + "Headertd");
	 var container = document.getElementById(id + "Text");
	 var containerImg = document.getElementById(id + "Img");
	 var style = "color:#FF9400;position:relative;font-size:12px;";
	if (!isEncryptCtrl(id))
	{
		containerImg.innerHTML = "<div align=right valign=top><img src=\"/images/icon_20.gif\"></div>";
		
		var args=checkPassCtrl.arguments;
		var word = (args[3]=="Key")?"答案":"密码";
		
		
        container.innerHTML = "<div style=\"" + style + "\">无法输入" + word  +"？请"
			        		 + "<a href=\"/qqedit.exe\" onclick=\"clickDownload('" + id + "','" + safe + "','" + unsafe + "')\" class=blue>点击此处</a>"
			        		 + "安装安全<br>控件,然后<a href=\"" + safe + "\" class=blue>刷新</a>。"
			        	     + "<a href=\"#\" onclick=openHelp('/help/help_safecontrol_1.shtml') class=blue>什么是安全控件？</a>"
			        	     + "</div>";
		
        headertd.style.display = ''; 
		header.innerHTML	= "<div><strong>若安全控件安装失败请使用</strong>“<a href=\"" + unsafe + "\" onMouseOver=\"displayText(1)\" onMouseOut=\"displayText(0)\" class=blue><strong>普通模式</strong></a>”</div>"
							+  "<div id=\"passwordTips\" style=\"display:none;width:0px;height:0px;position:relative;z-index:999\">"
							+  "   <div id=\"why\" style=\"position:absolute;left:20px;width:200px;height:50px;z-index:999\">"
							+  "	  <table width=\"250\" border=\"0\" cellpadding=\"2\" cellspacing=\"2\" class=\"boxyellow\">"
							+  "		  	<tr><td>"
							+  "		  	您在“安全模式”下将使用“安全控件”，对您输入的密码进行加密处理，有效防止木马截取键盘记录。<br>"
							+  "		  	您可以点击该链接使用“普通模式”。"
							+  "		  	</td></tr>"
							+  "	  </table>"
							+  "      <iframe src=\"javascript:false\" style='position:absolute; visibility:inherit; top:0px; left:0px; width:200px; height:100px; z-index:-1; filter=progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0);'></iframe>"
							+  "   </div>"
							+  "</div>";
	}
}

function setupUnsafeTips(containerID,safe)
{
	var container = document.getElementById(containerID);
	if (container != null)
	{
		container.innerHTML = 	"<div align=\"left\"><img src='/images/key.jpg' border=0><a tabindex=-1 href=# onclick=\"javascript:window.top.location.href='" + safe +"'\" onMouseOver=\"displayText(1);\" onMouseOut=\"displayText(0)\" class=\"blue\"><strong>点这里使用安全模式</strong></a></div>"
							+   "       <div id=\"passwordTips\" style=\"display:none;width:0px;height:0px;position:relative;z-index:999\">"
							+	"		  <div id=\"why\" style=\"position:absolute;left:20px;width:200px;height:50px;z-index:999\">"
							+	"			  <table width=\"250\" border=\"0\" cellpadding=\"2\" cellspacing=\"2\" class=\"boxyellow\">"
							+	"			  	<tr><td>"
							+	"			  		<strong>为什么要使用“安全模式”？</strong><br>"
							+	"					您在“安全模式”下将使用“安全控件”，对您输入的密码进行加密处理，有效防止木马截取键盘记录。"
							+	"			  	</td></tr>"
							+	"			  </table>"
							+   "      		  <iframe src=\"javascript:false\" frameborder=\"0\" style='position:absolute; visibility:inherit; top:0px; left:0px; width:200px; height:100px; z-index:-1; filter=progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0);'></iframe>"
							+	"		  </div>"
							+	" </div>";
	}
}

function setupSafeTips()
{
	
}

function clickDownload(id,safe,unsafe)
{
	setCookie("dotFlag",1);
	
	checkPassCtrl(id,safe,unsafe);
}


function setAnswerInput(ctrlID,id)
{
	var ctrl = document.getElementById(ctrlID);
	ctrl.SetID(id);
}

function getEncryptData(control,seed)
{
	var encryptData;
	try
	{
		control.SetSalt(seed);
		control.SelectRsaKey(2);
		var shap = "0123456789012345678901234567890123456789";
		var rsap = control.GetRsaPassword ();
		encryptData = seed + shap + rsap;
	}catch(e)
	{
		encryptData = "throw Exception " + e.number+ " " +  e.description;
	}
	return encryptData;
}

function getEncryptKey(ctrl,seed)
{
	var encryptData;
	try{
		ctrl.SetSalt(seed);
		ctrl.SelectRsaKey(2);
		shap = "0123456789012345678901234567890123456789";
		rsap = ctrl.GetRsaPrivacy ();
		encryptData = seed + shap + rsap;
	}catch(e)
	{
		encryptData = "throw Exception " + e.number+ " " +  e.description;
	}
	return encryptData
}

/*
** 获取所有问题数组
*/
function getKeys()
{
	var keys = document.getElementById("keys");
	if (keys != null)
	{
		var aryKeys = keys.value.split(KeyOuterSplit);
		return aryKeys;
	}
	return null;
}

function getKeysMode()
{
	var aryKey = getKeys();
	var aryMode = new Array();
	for(var i=0;i<=aryKey.length-1;i++)
	{
		var key = aryKey[i];
		var aryField = key.split(KeyInnerSplit);
		aryMode[aryField[1]] = aryField[2];
	}
	return aryMode;
}

function JumpSetp()
{
	var mobile = document.getElementById("MobilePhone");
	window.location.href = "/cgi-bin/SetDNAQuestion?MobilePhone=" + mobile.value;
}

function CloseJump()
{
 	var jump = document.getElementById("imgJump");
  
  	jump.style.display = "none";
}

function initCardType()
{
	var cardType = document.getElementById("cardType");
	var aryCardType = cardType.value.split(KeyOuterSplit);
	var cardSelect = document.getElementById("cardSelect");
	cardSelect.length = 0;
	for(var i=0;i<=aryCardType.length-1;i++)
	{
		var aryCard = aryCardType[i].split(KeyInnerSplit);
		cardSelect.options.add(new Option(aryCard[0],aryCard[1]));
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


function help(id,type,sleep)
{
	var ctl = document.getElementById(id);
	if (type == 0)
	{
		ctl.SetEditFocus();
		ctl.SetEditFocus();
	}else if (type == 1)
	{
		ctl.SetEditFocus();
	}else if (type == 2)
	{
		if (sleep == undefined)
		{
			setTimeout("help('" + id + "',2,1);",200);
		}else{
			ctl.focus();
			ctl.focus();
		}
	}else if (type == 3)
	{
		ctl.focus();
	}
}

function resizeIframe(id)
{
	var iframe = document.getElementById(id);
	if (iframe.contentDocument && iframe.contentDocument.body.offsetHeight)
	{
		iframe.height = iframe.contentDocument.body.offsetHeight;
	}else if (iframe.Document && iframe.Document.body.scrollHeight)
	{
		iframe.height = iframe.Document.body.scrollHeight;
	}
}


function getCookie(key)
{
	var cookies = document.cookie.split("; ");
	for (var i=0; i < cookies.length; i++)
	{
		var data = cookies[i].split("=");
		if (key == data[0])
		{
			return unescape(data[1]);
		}
	}
	return null;
}

function removeCookie(key)
{
	document.cookie = key + "=" + escape("remove") + "; expires=Fri, 31 Dec 1999 23:59:59 GMT;";
}

function setCookie(key,value)
{
	document.cookie = key + "=" + escape(value);
}

function setFocus(id)
{
	var ctrl = document.getElementById(id);
	if (ctrl != null)
	{
		ctrl.focus();
	}
}

function clearControl(id)
{
	var ctrl = document.getElementById(id);
	if (ctrl != null)
	{
		if (ctrl.mode)
		{
			ctrl.ClearText();
		}else
		{
			ctrl.value = "";
		}
		removeLayer(ctrl.id);
	}
}

function clearKey()
{
	for(var i=0;i<=keyNames1.length-1;i++)
	{
		var ctrl = document.getElementById(keyNames1[i]);
		if (ctrl != null)
		{
			ctrl.value = defaultSelectValue;
		}
	}
	for(var i=0;i<=keyNames2.length-1;i++)
	{
		var ctrl = document.getElementById(keyNames2[i]);
		if (ctrl != null)
		{
			ctrl.value = defaultSelectValue;
		}
	}
}

function clearAnswer()
{
	clearControl("oldKeyAnswer");
	for(var i=0;i<=oldAnswerNames1.length-1;i++)
	{
		clearControl(oldAnswerNames1[i]);
	}
	for(var i=0;i<=oldAnswerNames2.length-1;i++)
	{
		clearControl(oldAnswerNames2[i]);
	}
	for(var i=0;i<=newAnswerNames1.length-1;i++)
	{
		clearControl(newAnswerNames1[i]);
	}
	for(var i=0;i<=newAnswerNames2.length-1;i++)
	{
		clearControl(newAnswerNames2[i]);
	}
}

function clearPassword()
{
	var ctrl;
	for(var i=0;i<=pssswordNames.length-1;i++)
	{
		clearControl(pssswordNames[i]);
	}
}

function clearOthers()
{
	for(var i=0;i<=otherNames.length-1;i++)
	{
		clearControl(otherNames[i]);
	}
}

function clearKeyAnswer()
{
	initSelectItem();
	clearAnswer();
	clearPassword();
	clearOthers();
	states = new Array();
	window.scrollTo(0,120);
}

function IsSelectKey(id)
{
	var number = id.replace(/[^\d]/g,'');
	var keyID = "keySelect" + number;
	var ctrl = document.getElementById(keyID);
	if (ctrl.value == defaultSelectValue)
	{
		return false;
	}
	return true;
}

function disabledSubmit(id)
{
	var ctrl = document.getElementById(id);
	if (ctrl != null)
	{
		ctrl.disabled = true;
	}
	return false;
}

/*
document.onmousemove=function()
{
	window.status = document.documentElement.scrollTop + event.clientY;
}
*/


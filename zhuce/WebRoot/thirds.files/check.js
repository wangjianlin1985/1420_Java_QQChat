function CheckForm()
{
	var ctrl,result;
	ctrl = document.getElementById("PwdAnswer");
	if (ctrl.value == "")
	{
		alert("请填写您的密码保护答案！");
		return false;
	}
	ctrl = document.getElementById("oldEmail");
	if (ctrl.value == "")
	{
		alert("请填写安全E-mail！");
		return false;
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

			if (email.length >=41)
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
	ctrl = document.getElementById("emailAddress");
	var result = checkMail(ctrl.value);
	if ( result == 0 || result == 2)
	{
		alert("请填写正确的安全E-mail！");
		return false;
	}

    disabledSubmit("imageField");
    return true;
}
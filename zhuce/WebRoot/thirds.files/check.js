function CheckForm()
{
	var ctrl,result;
	ctrl = document.getElementById("PwdAnswer");
	if (ctrl.value == "")
	{
		alert("����д�������뱣���𰸣�");
		return false;
	}
	ctrl = document.getElementById("oldEmail");
	if (ctrl.value == "")
	{
		alert("����д��ȫE-mail��");
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
		alert("����д��ȷ�İ�ȫE-mail��");
		return false;
	}

    disabledSubmit("imageField");
    return true;
}
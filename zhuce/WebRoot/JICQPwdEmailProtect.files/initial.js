Array.prototype.indexOf = function(value)
{
	for(var i=0;i<=this.length-1;i++)
	{
		if (this[i] == value)
		{
			return i;
		}
	}
	return -1;
}

function switchCode(e,source,target)
{
	if (e.srcElement.type == "text" || e.srcElement.type=="select-one" || e.srcElement.type=="password"
		|| e.srcElement.type=="radio")
	{
		var keyCode = (window.event)?e.keyCode:e.which;
		if (keyCode == source)
		{
			if (window.event)
			{
				e.keyCode = target;
			}else
			{
				e.which = target;
			}
		}
	}
}

function enterKeydown(e,id)
{
	var keyCode = (window.event)?e.keyCode:e.which;
	if (keyCode == 13)
	{
		enterClick(id);
	}
}

function enterClick(id,sleep)
{
	if (sleep == null || sleep == undefined)
	{
		setTimeout("enterClick('" + id + "',1)",50)
	}else
	{
		var but = document.getElementById(id);
		if (but != null)
		{
			but.click();
		}
	}
}


//附加问题光标更改项目.进入.离开校验事件
function attachKeyEvent()
{
	for(var i=0;i<=keyNames1.length-1;i++)
	{
		var ctrl = document.getElementById(keyNames1[i]);
		if (ctrl != null)
		{
			ctrl.onchange = new Function("changeSelectItem(this.id)");
			ctrl.onfocus = new Function('states["' + newAnswerNames1[i] + '"] = undefined;beginKey("' + newAnswerNames1[i] + '",true,0,false);states["' + newAnswerNames1[i] + '"] = undefined;');
			ctrl.onblur = new Function('beginKey("' + newAnswerNames1[i] + '",true,1,false);states["' + newAnswerNames1[i] + '"] = undefined;');
		}
	}
	for(var i=0;i<=keyNames2.length-1;i++)
	{
		var ctrl = document.getElementById(keyNames2[i]);
		if (ctrl != null)
		{
			ctrl.onChange = new Function("changeSelectItem(this.id)");
			ctrl.onfocus = new Function('states["' + newAnswerNames2[i] + '"] = undefined;beginKey("' + newAnswerNames2[i] + '",true,0,true);states["' + newAnswerNames2[i] + '"] = undefined;');
			ctrl.onblur = new Function('beginKey("' + newAnswerNames2[i] + '",true,1,true);states["' + newAnswerNames2[i] + '"] = undefined;');		
		}
	}
}


//附加答案光标进入.离开校验事件//
function attachAnswerEvent()
{
	var ctrl;
	
	ctrl = document.getElementById("oldKeyAnswer");
	if (ctrl != null)
	{
		ctrl.onfocus = new Function('beginKey("oldKeyAnswer",true,0,false)');
		ctrl.onblur  = new Function('beginKey("oldKeyAnswer",true,1,false)');
	}
	for(var i=0;i<=oldAnswerNames1.length-1;i++)
	{
		ctrl = document.getElementById(oldAnswerNames1[i]);
		if (ctrl != null)
		{
			ctrl.onfocus = new Function('beginKey("' + oldAnswerNames1[i] + '",true,0,false)');
			ctrl.onblur  = new Function('beginKey("' + oldAnswerNames1[i] + '",true,1,false)');
		}
	}
	for(var i=0;i<=oldAnswerNames2.length-1;i++)
	{
		ctrl = document.getElementById(oldAnswerNames2[i]);
		if (ctrl != null)
		{
			ctrl.onfocus = new Function('beginKey("' + oldAnswerNames2[i] + '",true,0,false)');
			ctrl.onblur  = new Function('beginKey("' + oldAnswerNames2[i] + '",true,1,false)');
		}
	}
	for(var i=0;i<=newAnswerNames1.length-1;i++)
	{
		ctrl = document.getElementById(newAnswerNames1[i]);
		if (ctrl != null)
		{
			ctrl.onfocus = new Function('beginKey("' + newAnswerNames1[i] + '",true,0,false)');
			ctrl.onblur  = new Function('beginKey("' + newAnswerNames1[i] + '",true,1,false)');
		}
	}
	for(var i=0;i<=newAnswerNames2.length-1;i++)
	{
		ctrl = document.getElementById(newAnswerNames2[i]);
		if (ctrl != null)
		{
			ctrl.onfocus = new Function('beginKey("' + newAnswerNames2[i] + '",true,0)');
			ctrl.onblur  = new Function('beginKey("' + newAnswerNames2[i] + '",true,1,true)');
		}
	}
}


//附加密码控件光标进入,离开事件//
function attachPwdEvent()
{
	var ctrl;
	for(var i=0;i<=pssswordNames.length-1;i++)
	{
		ctrl = document.getElementById(pssswordNames[i]);
		if (ctrl != null)
		{
			if (ctrl.mode)
			{
				ctrl.OnEditFocus = new Function('beginPassword("' + pssswordNames[i] + '",true,0)');
				ctrl.OnEditBlur  = new Function('beginPassword("' + pssswordNames[i] + '",true,1,false)');
			}else
			{
				ctrl.onfocus = new Function('beginPassword("' + pssswordNames[i] + '",true,0)');
				ctrl.onblur  = new Function('beginPassword("' + pssswordNames[i] + '",true,1,false)');				
			}
		}
	}	
}

/*初始化方法*/
function initialize()
{
	//给问题与答案附加事件
	attachKeyEvent();
	attachAnswerEvent();
	attachPwdEvent();
}

document.onkeydown = new Function("switchCode(event,13,9)");

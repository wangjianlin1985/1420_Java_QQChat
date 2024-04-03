// JavaScript Document
// By Julian 
// ˵��. ��������еĶ������������ǿ�FRAME������ 

function GetPosPx(pos){
	return Number(String(pos).replace(/px/, "")) ;
}

function GetObjById(id)
{	
	var obj ;
	if (typeof(id) == "string")
		obj = GetIdentifiedObj(id) ;
	else if (typeof(id) == "object")
		obj = id ;
	else
		{
			// ���²�ĺ�����Ӧ��DEBUG��� ,�÷���ֵ����
			// //DbgPrint("id is neither a string nor an object") ;
			return false ;
		}

	return obj ;
}

function IsParentOf(obj, objParent)
{
	while(!IsTopObj(obj))
	{
		if (obj == objParent)
			return true ; 
		obj = obj.parentNode ; 
	}
	return false ; 
}

function GetBrowser()
{
	if (document.all)
		return "IE" ;
	if (document.layers)
		return "NS" ;	
	return "OTHER" ;
}

function GetTopLayer()
{
	switch(GetBrowser())
	{
		case "IE":
			return "document.all" ;
		case "NS":
			return "document.layers" ;
		case "OTHER":
			return "document" ;
		default:
			return "document" ;
	}
}

function GetIdentifiedObj(id, d) 
{
	// By Julian, 
	// ������:
	// 	d: ���� id: ������	
	var i,x ;
	// ��ʼ������
	if(!d) d=document ;
	
	// ��IDΪ��ߵ����ȼ������з��� 
	if(!x && d.getElementById)
	{ 
		x=d.getElementById(id) ;
	}
	if (x)
		return x ;
		
//	//DbgPrint("Failed to find object by document.getElementById: " + id) ;	
	// ���ֱ���Ҳ����Ļ�. ��X����Ŀ����. 
	if(!(x=d[id])&&d.all) {
		x=d.all[id] ;
	}
	if (x)
		return x ;
	
	// ����Ǳ�Ԫ��. ��ͨ��FORMS���ҵ���	
	for (i=0 ; !x&&i<d.forms.length ; i++) 
	{
		x=d.forms[i][id] ;
	}	
	if (x)
		return x ;
		
	// �ݹ鵽ÿ��������ȥ��, ��һ��ֻ��NSϵ������. ��IE/FIREFOX�޹�
	for(i=0 ;!x && d.layers && i<d.layers.length ;i++)
		x=GetIdentifiedObj(id,d.layers[i].document) ;
	if (x)
		return x ;
		
	return false ;		
}

function GetObjText(id)
{
	var obj ;
	obj = GetObjById(id) 
	if (!obj)
	{
//		//DbgPrint("SetObjTextContent: Unable to get object") ;
		return false ;
	}
	
	if(GetBrowser() == "IE")
	{
		if (obj.innerText) 
		return obj.innerText ;
	}
	else // for FF, not tested on NS platform
	{
		if (obj.textContent)
			return obj.textContent ;
	}
	return "" ;
}


function SetObjAttribute(id, name, value) 
{
	var obj = GetObjById(id);
	if (!obj)
		return false ;
			
    obj.setAttribute(name, value) ;
		return true ;
	
	return false ;
}	
	
function GetObjAttribute(id, name) 
{
	var obj = GetObjById(id);
	if (!obj)
		return false ;
		
        if (name == "name" && id.name)
            return id.name ;
        if (obj.getAttribute)
		{
			return obj.getAttribute(name) ;
		}
		return false ;
}	

function IsTopObj(id)
{
	var obj = GetObjById(id) ;
	if (!obj)
		return false ;

    if (obj == document.body || obj == document.html || obj == document || obj == window)
        return false ;
	
	if (obj.parentNode && (obj.parentNode == document.body || obj.parentNode == document.html || obj.parentNode == document))
		return true ;
	
	return false ;
}

function FindFirstNamedObj(id,name)
{
	// ͨ���������Ҷ���, �����Ӷ���Ĺ���
	var parent = GetObjById(id);
	if (!parent)
		return false ;
	
	var retOjb = null ;
	var objFromChild = null ;
	
	for (var i = 0 ; i < parent.childNodes.length ; ++i)
	{
		if (GetObjAttribute(parent.childNodes[i], "name") == name)
		{
			return parent.childNodes[i] ;
		}
		objFromChild=FindFirstNamedObj(parent.childNodes[i], name);
		if(objFromChild)
			return objFromChild ;
	}
	return objFromChild ;
}

function GetObjStyle(id, prop) 
{
	var obj = GetObjById(id) ;		
	if (!obj) 
		return ("") ;
		
	if (prop == "left" || prop=="offsetLeft") return obj.offsetLeft ;
	else if (prop == "top" || prop=="offsetTop") return obj.offsetTop ;
	else if (prop == "width" || prop=="offsetWidth") return obj.offsetWidth ;
	else if (prop == "height" || prop=="offsetHeight") return obj.offsetHeight ;
			
	var inlineStyle = null ;
	// �Ȱ�xxxx-yyyyy��ΪxxxxYyyyy����ʽ, ���ڶ�����STYLE�����õ�.
	var ccProp = prop ;
	var dash = ccProp.indexOf("-") ;
	while (dash != -1)
	{
		ccProp = ccProp.substring(0, dash) + ccProp.substring(dash+1,dash+2).toUpperCase() + ccProp.substring(dash+2) ;
		dash = ccProp.indexOf("-") ;
	}
	
	// ���Ƕ���IE, ����Ҫ��floatת��styleFloat:
	if(ccProp == "float")
	{
		if (GetBrowser() == "IE") // IE support
			ccProp = "styleFloat" ;
		else 
			ccProp = "cssFloat" ;
		}
		
	inlineStyle = eval("obj." + ((GetBrowser()=="NS")?"":"style.")+ccProp) ;
	
	// �ҵ������:
	// ���ǻ����Ҳ����Ļ�. ������������ܻᱨ��.����������, ��Ϊ�����и�ֵ??!!
	if(typeof(inlineStyle) != "undefined" && inlineStyle != "") 
	{
		return inlineStyle ;
	}
		
	if (obj.currentStyle)
	{
			// �������һ�δ���� IE��Ч
			// //DbgPrint("currentStyle") ;
			if (prop == "float") inlineStyle = obj.currentStyle.float ;
			else if (prop == "position") inlineStyle = obj.currentStyle.position ;
			else if (prop == "zIndex") inlineStyle = obj.currentStyle.zIndex ;
			else if (prop == "visibility") inlineStyle = obj.currentStyle.visibility ;
			else if (prop == "display") inlineStyle = obj.currentStyle.display ;
	}
	else if(window.getComputedStyle) 
	{
		// ������FIREFOX��Ч
		// //DbgPrint("getComputedStyle") ;
		// !!!!!�ر�ע��, window.getComputedStyle(obj,null)����obj.style����!!!���ܿ������кܶ���ͬ�ĳ�Ա��
		if(prop == "float") inlineStyle = window.getComputedStyle(obj,null).getPropertyValue("float") ;
		else if (prop == "position") inlineStyle = window.getComputedStyle(obj,null).getPropertyValue("position") ;
		else if (prop == "zIndex") inlineStyle = window.getComputedStyle(obj,null).getPropertyValue("z-index") ;
		else if (prop == "visibility" ) inlineStyle = window.getComputedStyle(obj,null).getPropertyValue("visibility") ;
		else if ( prop== "display") inlineStyle = window.getComputedStyle(obj,null).getPropertyValue("display") ;
	}
	
	if(typeof(inlineStyle) != "undefined" && inlineStyle != "") 
	{
		return inlineStyle ;
	}
	
	// �Ҳ��������. ֻ�ܱ�����ʽ����. IE/NS������. ����IE��ǰ��Ĺ��̾Ϳ����ҵ���,��������NS/FF
	{	
		var ss = document.styleSheets ;
		for (var x = 0 ; x < ss.length ; x++) 	{		
			var rules = ss[x].rules ;
			if (!rules)
				continue ;
			for (var y = 0 ; y < rules.length ; y++) {			
				var z = rules[y].style ; 
				// ÿ�������е���ʽ��:�����ҵ���Ҫ�����
				// ͨ���Ķ��������뷢��, ��ʽӦ����������(����������Ų���)
				// '*[ID"'+ obj.id + '"]'
				if(z[prop] && (rules[y].selectorText == '*[ID"'+ obj.id + '"]')) {
					return z[prop] ;
				}			
			}		
		}	
	}

	return inlineStyle ;
}

function SetObjStyle(id, prop, new_value)
{
	var obj = GetObjById(id) ;
	if (!obj)
		return false ;
		
	if (!IsValidObj(obj))
		return false ;
		
	if (typeof(prop) != "string" || typeof(new_value) != "string")
	{
		//DbgPrint("invalid input") ;
		return false ;
	}
	
	if (!IsValidObj(obj))
	{
		//DbgPrint("SetObjStyle: not avalable object") ;
		return false ;
	}
		
	// �Ȱ�xxxx-yyyyy��ΪxxxxYyyyy����ʽ, ���ڶ�����STYLE�����õ�.
	var ccProp = prop ;
	var dash = ccProp.indexOf("-") ;
	while (dash != -1)
	{
		ccProp = ccProp.substring(0, dash) + ccProp.substring(dash+1,dash+2).toUpperCase() + ccProp.substring(dash+2) ;
		dash = ccProp.indexOf("-") ;
	}
	
	// ���Ƕ���IE, ����Ҫ��floatת��styleFloat:
	if(ccProp == "float")
	{
		if (GetBrowser() == "IE") // IE support
		{
			obj.style.styleFloat = new_value ;
			if (GetObjStyle(obj, "float") == new_value)
				return true ;
		}
		else // ����FF, ������CSSFLOAT
		{
			if(typeof(obj.style.cssFloat) != "undefined")
				obj.style.cssFloat = new_value ;
			if (GetObjStyle(obj, "float") == new_value)
				return true ;
		}
	}
	
	
	switch(ccProp)
	{	 
		case "left":
		case "top":
		case "width":
		case "height":
		case "offsetLeft":
		case "offsetTop" :
		case "offsetWidth":
		case "offsetHeight":
			// ���������Ĵ�����, ֻ����PX��%��ʽ�ı���
			if (new_value.search(/^[0-9]+[\%(px)]$/i) != -1)
			{
				// //DbgPrint("SetObjStyle msg: valid input -->" + new_value) ;
				break; 
			}
			// ����û��BREAK . ������:
		case "marginLeft":
		case "marginRight" :
		case "marginTop" :
		case "marginBottom" :
		case "paddingTop" :
		case "paddingBottom" :
		case "paddingLeft" :
		case "paddingRight" :
			// ����������ֵ, ������λ�����Ĭ�ϵ�PX ;
			if (String(Number(new_value)) == new_value && String(new_value) != "NaN")
			{
				// //DbgPrint("SetObjStyle msg: only numbers are input, add 'px' as a default action") ;
				new_value = new_value + "px" ;
				break ;
			}
			
			else {
				//DbgPrint("SetObjStyle error: invalid input: " + ccProp + " <-- " +  new_value) ;
				return false ;
			}
			break ;
		default:
			break ;
	}
	switch(ccProp)
	{
		case "offsetLeft":
			ccProp = "left" ;
			break ;
		case "offsetTop" :
			ccProp = "top" ;
			break ;
		case "offsetWidth":
			ccProp = "width" ;
			break ;
		case "offsetHeight":
			ccProp = "height" ;
			break ;
	}
	(GetBrowser() == "NS") ?
			(eval("obj." + ccProp+"=\""+ new_value+"\"")) :
			(eval("obj.style."+ ccProp+"=\""+ new_value+"\""));
	
	// ���һ��HTML����(���)��û�в��뵽DOCUMENT��. ��CURRENTSTYLE����ո����õĲ�һ��
	// ����������Ҳ��ȥ�����ֵ. ����һ�ɷ���TRUE, ���Ҫ�鿴��ȷ��.Ӧ�ڼ��غ����GETOBJSTYLE
	return true ; 
}
	
function SetObjText(id, new_text)
{
	var obj ;
	obj = GetObjById(id) 
	if (!obj)
	{
//		//DbgPrint("SetObjTextContent: Unable to get object") ;
		return false ;
	}
	if (typeof(new_text) != "string")
	{
//		//DbgPrint("SetObjTextContent: invalid input") ;
		return false ;
	}
	
	if(GetBrowser() == "IE")
	{
		obj.innerText =  new_text;		
		//obj.innerText =  eval("new_text.fontcolor('red');");		
		//obj.style.backgroundColor = 'red';
		return true ;
	}
	else // for FF, not tested on NS platform
	{
		obj.textContent = new_text ;
		return true ;
	}
	
}
	
function CaptureGlobleEvent(EventName, Func) 
{
	// �����������ȫ�ֵĻص����� , ����Ҫ, IE��Ϳ�����.
	switch(EventName)
	{
		case "MOUSEDOWN":
			document.onmousedown =  Func ;
			break ;
		case "MOUSEMOVE":
			document.onmousemove =  Func ;
			break ;
		case "MOUSEUP":
			document.onmouseup = Func ;
			break ;
		case "CLICK":
			document.onclick =  Func ;
			break ;
	}	
	
	if (GetBrowser() == "NS") {
		document.captureEvents(eval("Event."+ EventName)) ;			
	}
	
	return true ;
}

function CaptureEvent(id, EventName, Func) 
{
	var obj = GetObjById(id) ;
	if (!obj)
		return false ;
		
	// �����������ȫ�ֵĻص����� , ����Ҫ, IE��Ϳ�����.
	switch(EventName)
	{
		case "mousedown":
			EventName="MOUSEDOWN" ;
		case "MOUSEDOWN":
			obj.onmousedown =  Func ;
			if (GetBrowser() == "NS") 
			{
				obj.captureEvents(eval("Event."+ EventName)) ;			
			}
			break ;
			
		case "mousemove":
			EventName="MOUSEMOVE" ;
		case "MOUSEMOVE":
			obj.onmousemove =  Func ;
			if (GetBrowser() == "NS") 
			{
				obj.captureEvents(eval("Event."+ EventName)) ;			
			}
			break ;
			
		case "mouseup":
			EventName="MOUSEUP";
		case "MOUSEUP":
			obj.onmouseup = Func ;
			if (GetBrowser() == "NS") 
			{
				obj.captureEvents(eval("Event."+ EventName)) ;			
			}
			break ;
			
		case "click":
			EventName="CLICK" ;
		case "CLICK":
			obj.onclick =  Func ;
			if (GetBrowser() == "NS") 
			{
				obj.captureEvents(eval("Event."+ EventName)) ;			
			}
			break ;
			
		default:
			return false ;
	}	
	
	return true ;
}

function IsValidObj(id)
{
	var obj = GetObjById(id) ;
	if (!obj)
		return false ;
	
		// FF����������֪���������Ķ���. ������������, �п�����ֱ��BODY�µ��ı�. 
		// ������FF�������������̫����. û���ı�Ҳ���ⶫ��:(, ���Ҳ����ڿ���		
		if (obj.nodeName == "#text"|| obj.nodeName == "#comment")
			return false ;
			
		return true ;
}

// ���ĺ���д�����. :)
function GetEventSrc(eventObj)
{
	if (eventObj.srcElement)
		return eventObj.srcElement ;
		
	else if (eventObj.target) // for NS, which one does FF use?
		return eventObj.target ;
		
	else
		return false ;
}

function GetEvent(eventOwner) // eventOwner ֻ����NS/FIREFOX��
{		
	if (typeof(eventOwner) == "object")
		return eventOwner ;
		
	if (typeof(event) == "object")
		return event ;
		
	return false; 
}

function GetEventSrc(theEvent)
{	
	if (typeof(theEvent) != "object") 
	{
		//DbgPrint("GetEventSrc error: not an object") ;
		return false ;
	}
	
	if (typeof(theEvent.srcElement) != "undefined")
		return theEvent.srcElement ;
		
	if (typeof(theEvent.target) != "undefined")
		return theEvent.target ;
}
	
function GetEventToElement(theEvent)
{
	if (theEvent.toElement)
		return theEvent.toElement ;
	
	if (theEvent.explicitOriginalTarget)
		return theEvent.explicitOriginalTarget ;
}	
	
function GetMousePos(e)
{ 
  if((!e.pageX) || (!e.pageY))  // IE
  {
  	return PosClientToGlobal(GetEventSrc(e), e.offsetX, e.offsetY) ;
  }
  
  else 
  {  
		var mLoc = new Object ;
    mLoc.x = e.pageX ;
    mLoc.y = e.pageY ;
    return mLoc ;
  } 
}

function GetObjRect(id)
{
	var obj ;
	obj = GetObjById(id) 
		
	if (!obj)
	{
		//DbgPrint("GetWindowRect: Unable to get object") ;
		return false ;
	}	
		
	var _rect = new Object ;
	_rect.x = GetObjStyle(id, "left") ;
	_rect.y = GetObjStyle(id, "top") ;
	_rect.width = GetObjStyle(id, "width") ;
	_rect.height = GetObjStyle(id, "height") ;
	
	return _rect ;
} 

function GetTopParent(id)
{
	var obj = GetObjById(id) ;
	if (!obj)
		return false ;
	
	if (obj == document.body || obj == document.html || obj == document || obj==window)
	{
		// //DbgPrint("the object is document.body, no parent could be got") ;
		return false ;
	}
	
	while (!IsTopWindow(obj))
		obj = obj.parentNode ;
	
	return obj ;
}
	
	// window control
	function IsTopWindow(id)
	{
		return IsTopObj(id) ;
	}

	function CheckAndHideMenu(_Event, aParent)
	{
		var theEvent = GetEvent(_Event) ; 
		var theEventSrc = GetEventSrc(theEvent) ;
		var theEventTarget = GetEventToElement(theEvent) ; 
		
		
		if (IsParentOf(theEventTarget, aParent) )
			return ; 
		
	    if (GetTopParent(theEventTarget) == GetTopParent(__lastMenu))
		{ 
			return ; 
		}
		visible() ; 			
		return ;
	}


	var __lastMenu;
	var childMenus = ["childMenu1","childMenu2"];
	
	var childMenuItems1 = ["childMenu11","childMenu12"];
	var childMenuItems2 = ["childMenu21","childMenu22","childMenu23"];
	
	function ShowItemMenu(id,item)
	{
		if (item == 1)
		{
			for(var i=0;i<=childMenuItems1.length-1;i++)
			{
				var ctrl = document.getElementById(childMenuItems1[i]);
				ctrl.className = "menu_down_2";
			}
		}else if (item == 2)
		{
			for(var i=0;i<=childMenuItems2.length-1;i++)
			{
				var ctrl = document.getElementById(childMenuItems2[i]);
				ctrl.className = "menu_down_2";
			}	
		}
		var ctrl = document.getElementById(id);
		ctrl.className = "menu_down_1";
	}
	
	function GetPosition(parent,location)
	{	
		var iPos = 0;
		/*
	    while (parent!=null)  
	����{
		   iPos+=parent["offset" + location];
	       parent = parent.offsetParent
	    }
	    */
	    iPos+=parent["offset" + location];
	    return iPos
	 }
	 
	function ShowMenu(parent,childId)  
	{	
		var child = document.getElementById(childId);
		if (child != null)
		{
			__lastMenu = child;
			
			child.style.display=''; 
	        child.style.pixelLeft = GetPosition(parent,"Left")-381;
	        child.style.pixelTop = 0;
	    }
	}
	
	function ChangeMenu(_Event, aParent)
	{
		
		var theEvent = GetEvent(_Event) ; 
		var theEventSrc = GetEventSrc(theEvent) ;
		var theEventTarget = GetEventToElement(theEvent) ; 
		
		try
		{
			if (IsParentOf(theEventTarget, aParent) )
				return ;
				
			if (GetTopParent(theEventTarget) == GetTopParent(__lastMenu))
			{
				if (theEventTarget.id != "")
				{
					return ; 
				}
			}
		}catch(ex)
		{
		}
		
		HideMenu();
	}

	function HideMenu()
	{
		for(var i=0;i<=childMenus.length-1;i++)
		{
			var ctrl = document.getElementById(childMenus[i]);
			ctrl.style.display = "none";
		}
	}
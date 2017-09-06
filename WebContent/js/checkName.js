window.onload=function(){
	document.querySelector("#check_user").onclick=function(){
	var uname=document.querySelector("#uname").value;
	var XmlHttp=new XMLHttpRequest();
	XmlHttp.open("GET", "check.do?uname="+uname, true);
	XmlHttp.send(null);
	XmlHttp.onreadystatechange = function(){
		if(XmlHttp.readyState==4){
			if(XmlHttp.status==200){
				var data=XmlHttp.responseText;
				var sp=document.querySelector("#sp")
				if(data==1){
					sp.innerHTML="此账号已被注册";
					sp.style.color="red";
				}
				if(data==0){
					sp.innerHTML="此用户名可以使用";
					sp.style.color="green";
				}
			}
		}
	  }
	}
}
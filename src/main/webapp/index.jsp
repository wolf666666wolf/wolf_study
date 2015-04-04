<%@ page 
	language="java"
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<body>
<h2>Hello World123!</h2>
<%
String type =  request.getParameter("type");
if(type==null) type="";
out.println("aaaaaaaaaaaaa");

if(type.equals("1")){
	out.println("欢迎李阳");
}else if(type.equals("2")){
	out.println("欢迎宋艳");
}else{
	out.println("欢迎李阳宋艳");
}
%>
<br>
<img src="image/homelink_logo.gif" alt="自如网,品质合租房"  with="100px" height="100px" align="center"/>
</body>
</html>

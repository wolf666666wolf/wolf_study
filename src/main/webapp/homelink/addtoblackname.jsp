<%@ page import="com.study.open.htmlparser.*, com.study.open.htmlparser.bean.*, java.util.*" 
		 language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

<%
	String url = request.getParameter("url");
	String type = request.getParameter("type");
	
	if(url!=null && type!=null){
		HomeLinkService service = new HomeLinkService();
		//List<House> houList = service.addBlackName();
		BlackName blackName = new BlackName();
		blackName.setUrl(url);
		blackName.setAreaType(type);
		service.addBlackName(blackName);
%>

	<tr>
		<td><%=url %>  Delete Successfully</td>		
	</tr>
<% 	}%>		
</table>
<form method="post" action="addtoblackname.jsp">
   
	url:<input type="text" name="url">
	
	type:<input type="radio" name="type" value="C" checked>dislike communtiy
	<input type="radio" name="type" value="H">dislike house
	<input type="radio" name="type" value="D">dislike district
	<input type="radio" name="type" value="FC">favourate community
	<input type="radio" name="type" value="FH">favourate house
	
	<br>
	<input type="submit" name="submit" value="submit">
</form>
</body>
</html>
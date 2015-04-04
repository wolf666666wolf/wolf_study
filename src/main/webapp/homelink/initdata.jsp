<%@ page import="com.study.open.htmlparser.*, com.study.open.htmlparser.bean.*, java.util.*" 
		 language="java" contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%
//request.setCharacterEncoding("UTF-8");

	List subList = new ArrayList();
	String[] subdis = request.getParameterValues("subdis");
	System.out.println("subdis:"+subdis);
	if(subdis!=null){
	  subList = Arrays.asList(subdis);
	}
	HomeLinkService service = new HomeLinkService();
	service.initHouseBySubdis(subList);
		
%>

</table>
  success
</body>
</html>
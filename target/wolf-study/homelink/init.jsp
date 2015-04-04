<%@ page import="com.study.open.htmlparser.*, com.study.open.htmlparser.bean.*, java.util.*" 
	language="java"
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<html>
	<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<style type="text/css">
		body{font-size:12px;}
	</style>
	<script src="../js/jquery-1.7.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	  $("#SelectAll").click(function(){
	    var value = $("#SelectAll").attr("checked")=="checked"? true:false;
	 	$("input[type='checkbox']").attr("checked", value);
	  });
	});		
	</script>
	</head>
<body>
<form action="initdata.jsp" method="post" target="_blank">
<input type="checkbox" id="SelectAll">Select All
<%
//request.setCharacterEncoding("UTF-8");
HomeLinkService service = new HomeLinkService();
Distract dis1 = new Distract();
List<Distract> disList = service.getDistrict(dis1);
for(Distract dis: disList){
%>
	<div id="<%=dis.getName()%>">
	<input type="checkbox" value="<%=dis.getUrl()%>" name="dis"><a href="<%=dis.getUrl()%>"><%=dis.getName()%></a>&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;
<%	
	Distract cond = new Distract();
	cond.setPname(dis.getName());
	List<Distract> subDisList = service.getDistrict(cond);
	int i=0;
	for(Distract subdis: subDisList){
		i++;
		if(i%15==0){
			out.println("<br>&nbsp;&nbsp;&nbsp;");
		}
		
%>
	<input type="checkbox" value="<%=subdis.getUrl()%>" name="subdis"><a href="<%=subdis.getUrl()%>"><%=subdis.getName()%></a>&nbsp;&nbsp;
<%		
	}
%>
</div>
<%	
}
%>

<div>
	<input type="submit" name="initdata" value="initdata"> 
</div>

</form>
</body>
</html>

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
	<tr>
		<td>序号</td>
		<td>名称</td>
		<td>小区均价</td>
		<td>价格</td>
		<td>总价(万)</td>
		<td>面积(平米)</td>
		<td>操作</td>
		<br>
	</tr>
<%
//request.setCharacterEncoding("UTF-8");
	String min = request.getParameter("min")==null?"60":request.getParameter("min");
	String max = request.getParameter("max")==null?"100":request.getParameter("max");
	String minArea = request.getParameter("minArea")==null?"30":request.getParameter("minArea");
	String maxArea = request.getParameter("maxArea")==null?"120":request.getParameter("maxArea");
	String maxPrice = request.getParameter("maxPrice")==null?"120":request.getParameter("maxPrice");
	String percent = request.getParameter("percent")==null?"0.2":request.getParameter("percent");
	String rooms = request.getParameter("rooms")==null?"2室":request.getParameter("rooms");
	String pageNum = request.getParameter("page")==null?"1":request.getParameter("page");
	List subList = new ArrayList();
	String[] subdis = request.getParameterValues("subdis");
	System.out.println("###################:"+subdis);
	if(subdis!=null){
	  subList = Arrays.asList(subdis);
	}
	System.out.println("最小min:"+min +" max:"+max +" percent:"+percent);
	HousePara para = new HousePara();
	para.setMin(Integer.parseInt(min));
	para.setMax(Integer.parseInt(max));
	para.setMinArea(Integer.parseInt(minArea));
	para.setMaxArea(Integer.parseInt(maxArea));	
	para.setMaxPrice(Integer.parseInt(maxPrice));
	para.setPercent(Double.parseDouble(percent));
	para.setSubDisList(subList);
	para.setRooms(rooms);
	para.setPage(Integer.parseInt(pageNum));
	System.out.println("para:"+para.toString());	
	HomeLinkService service = new HomeLinkService();
	List<House> houList = service.getHouseList(para);
	int i=0;
	for(House hou: houList){
%>
	<tr>
		<td width="100px"><%=i++%></td>
		<td><a href="<%=hou.getUrl()%>" target="_blank"><%=hou.getName()%></a></td>
		<td width="100px"><%=hou.getCprice()%></td>
		<td width="100px"><%=hou.getPrice()%></td>
		<td width="100px"><%=hou.getValue()%></td>
		<td><%=hou.getArea()%></td>
		<td><a href="addtoblackname.jsp?url=<%=hou.getUrl()%>&type=H" target="_blank">AddToBlackName</a></td>
		
	</tr>	
<%
	}
%>
</table>

</body>
</html>
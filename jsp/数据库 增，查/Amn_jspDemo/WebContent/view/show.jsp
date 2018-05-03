<%@page import="com.ishops.DBmodel.AmnModel"%>
<%@page import="java.util.List"%>
<%@page import="com.ishops.DBmodel.MysqlDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示</title>
</head>
<body>
	<%
		MysqlDB mysql = new MysqlDB();
		mysql.getConn();
		List<AmnModel> list = mysql.show();		//获取赋值后的集合
	%>
	<table border="1">
		<tr>
			<td>name</td>
			<td>age</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {		//遍历
				AmnModel amn = new AmnModel();			//创建对象
				amn=list.get(i);						//将集合元素赋给对象
		%>
		<tr>
			<td><%=amn.getName() %></td>				<!-- 获取并打印 -->
			<td><%=amn.getAge() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
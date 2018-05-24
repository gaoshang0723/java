<%@page import="com.ishops.DBmodel.MysqlDB"%>
<%@page import="com.ishops.DBmodel.AmnModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="amn" class="com.ishops.DBmodel.AmnModel" scope="session"/>			<%--创建AmnModel对象,名叫amn 注意完整路径--%>
<jsp:setProperty name="amn" property="*"/>											<%--对象赋值，需要前台输入框的name与对象属性名一致--%>

<%-- 
	赋值方式2：
	<jsp:setProperty name="amn" property="name"  param="name"/>								
	<jsp:setProperty name="amn" property="age"  param="age"/>
	
--%>
										
<%--
<jsp:getProperty name="amn" property="age"/>      获取amn对象的age值,并打印 
<jsp:getProperty name="amn" Property="name"/> 	       获取amn对象的age值,并打印
 --%>

<%
	MysqlDB mysql = new MysqlDB();
	mysql.getConn();
	int status=mysql.insert(amn);
	if(status==1){
	
%>
<jsp:forward page="../view/show.jsp"/>
<%
	}
%>
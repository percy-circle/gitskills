<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.ContactDaoImpl"%>
<%@page import="dao.ContactDao"%>
<%@page import="beans.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通讯录</title>
</head>
<body>
	<div align='center'>网页版通讯录</div>
	<table align='center' border='1px' style='margin-top: 20px' width='700'>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>电话号码</th>
			<th>电子邮箱</th>
			<th>QQ号码</th>
			<th>操作</th>
		</tr>
         <c:forEach items="${PageBean.list}" var="contact">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.name}</td>
				<td>${contact.gender}</td>
				<td>${contact.age}</td>
				<td>${contact.phone}</td>
				<td>${contact.email}</td>
				<td>${contact.qq}</td>
				<td><a href='/Contact4.0/UpDate.jsp?id=${contact.id}'>修改</a>&nbsp;<a
					href='/Contact4.0/DelServlet?id=${contact.id}'>删除</a></td>
			</tr>
		</c:forEach>
	<!--  	<c:forEach items="${list}" var="contact">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.name}</td>
				<td>${contact.gender}</td>
				<td>${contact.age}</td>
				<td>${contact.phone}</td>
				<td>${contact.email}</td>
				<td>${contact.qq}</td>
				<td><a href='/Contact4.0/UpDate.jsp?id=${contact.id}'>修改</a>&nbsp;<a
					href='/Contact4.0/DelServlet?id=${contact.id}'>删除</a></td>
			</tr>
		</c:forEach>  -->
		<tr>
			<td colspan="8" align="center"><a href='/Contact4.0/add.jsp'>[添加联系人]</a></td>
		</tr>
	<tr>
		<td colspan="8" align="center">
		   <a href="/Contact4.0/IndexServlet?current=${1}">首页</a>
			 <c:if test="${PageBean.current>1}">
				<a href="/Contact4.0/IndexServlet?current=${PageBean.current-1}">上一页</a>
			</c:if>
			 <c:if test="${PageBean.current<PageBean.total}">
				<a href="/Contact4.0/IndexServlet?current=${PageBean.current+1}">下一页</a>
			</c:if> 
			<a href="/Contact4.0/IndexServlet?current=${PageBean.total}">尾页</a>
		</td>
	</tr>
	</table>
</body>
</html>
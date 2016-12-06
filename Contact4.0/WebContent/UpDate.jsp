<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<% 
	    request.setCharacterEncoding("UTF-8");
		ContactDao dao = new ContactDaoImpl();
		Contact contact = dao.searchByID(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("contact", contact);
	%>
	<div align="center">修改联系人</div>
	<form action="/Contact4.0/ToUpdateServlet" method="post">
		<table align="center" border="1px" style="margin-top: 20px"
			width="300">
			<tr align="center">
				<td><input type="hidden" name="id"
					value="${contact.id}"></td>
			</tr>
			<tr align="center">
				<td>姓&nbsp;&nbsp;名</td>
				<td><input type="text" name="name"
					value="${contact.name}" /></td>
			</tr>
			
				<c:if test="${contact.gender=='男'}">
				    <tr align="center">
					<td>性&nbsp;&nbsp;别:</td>
					<td><input type="radio" name="gender" value="男"
						checked="checked" />男&nbsp; <input type="radio" name="gender"
						value="女" />女</td></tr>
			</c:if>
			<c:if test="${contact.gender=='女'}">
			    <tr align="center">
				<td>性&nbsp;&nbsp;别:</td>
				<td><input type="radio" name="gender" value="男"
					checked="checked" />男&nbsp; <input type='radio' name="gender"
					value="女" checked="checked" />女</td>
				</tr>
			</c:if>
			<tr align="center">
				<td>年&nbsp;&nbsp;龄:</td>
				<td><input type="text" name="age"
					value="${contact.age}" /></td>
			</tr>
			<tr align="center">
				<td>电话号码:</td>
				<td><input type="text" name="phone"
					value="${contact.phone}" /></td>
			</tr>
			<tr align="center">
				<td>电子邮件:</td>
				<td><input type="text" name="email"
					value="${contact.email}" /></td>
			</tr>
			<tr align="center">
				<td>QQ&nbsp;号码:</td>
				<td><input type="text" name="qq" value="${contact.qq}" /></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />
		</div>
	</form>
</body>
</html>
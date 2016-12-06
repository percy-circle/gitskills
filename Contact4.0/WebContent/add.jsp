<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网页版通讯录</title>
</head>
<body>
 <div align="center" >添加联系人</div>
	  <form action="/Contact4.0/AddServlet" method="post">
	   <table align="center" border="1px" style="margin-top:20px"  width="300">
	      <tr align="center" >
		  <td ><input  type="hidden"/></td> </tr>
		  <tr align="center">
		  <td>姓&nbsp;&nbsp;名:</td><td><input  type="text" name="name"/></td></tr>
		   <tr align="center">
		  <td>性&nbsp;&nbsp;别:</td><td><input type="radio" name="gender" value="男"/>男&nbsp;&nbsp;<input  type="radio" name="gender" value="女"/>女</td></tr>
		   <tr align="center">
		  <td>年&nbsp;&nbsp;龄:</td><td><input  type="text" name="age"/></td></tr>
		   <tr align="center">
		  <td>电话号码:</td><td><input  type="text" name="phone"/></td></tr>
		   <tr align="center">
		  <td>电子邮件:</td><td><input  type="text" name="email"/></td></tr>
		   <tr align="center">
		  <td>QQ&nbsp;号码:</td><td><input type="text" name="qq"/></td></tr>
	   </table>
	   <div align="center" style="margin-top:10px"><input  type="submit" value="添加" ></div>
	    </form>
</body>
</html>
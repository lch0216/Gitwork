<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="header.jsp"%>
<title>北京出租房 ——用户注册</title>
<script type="text/javascript" src="js/reg.js"></script>
<%@include file="checklogin.jsp"%>
<form action=""  id="myform">
		<table align="center">
			<tr>
				<td>用户注册：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			<tr>
			<tr>
				<td>重复密码：</td>
				<td><input type="password"></td>
			<tr>
				<td><input type="button" value="注册" onclick="reg()" class="btn" >&nbsp;</td>
				<td><input type="reset" value="重置" class="btn"></td>
			</tr>
		</table>
	</form>
<%@include file="bottom.jsp"%>
	
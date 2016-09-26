<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="header.jsp" %>
<title>北京出租房 ——用户登录</title>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
	function login(){
		$.ajax({
			type : "post",
			url : "user_login",
			data:$("#myform").serialize(),
			dataType : "json",
			success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
				if ( data.code == 1 ) {
					location.href="index.jsp";	
				} 
			}
		});
	}
</script>
<%@include file="checklogin.jsp" %>
	<form id="myform">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
				</td>
			</tr>
			<tr>
				<td>用户登陆：</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>
				<input type="button" value="登陆" id="btn" onclick="login();"/>
				</td>
			</tr>
		</table>
	</form>

<%@include file="bottom.jsp"%>
	
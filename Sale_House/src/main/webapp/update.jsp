<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="header.jsp"%>
<title>房屋出租信息发布</title>
<script type="text/javascript" src="js/update.js"></script>
<%@include file="checklogin.jsp"%>
<form action=""  name="myform" >
		<input type="hidden" name="id" id ="id" value="n"/>
		<table>
			<tr>
				<td colspan="2"><hr/></td>
			</tr>
			<tr>
			  <td><strong>标题：</strong></td>
				<td><input type="text" name="title" id ="title"/></td>
			</tr>
			<tr>
			  <td><strong>区县：</strong></td>
				<td><select name="qxid" id="districtList" onChange="selectjd()">

				</select></td>
			</tr>
			<tr>
			  <td><strong>街道：</strong></td>
				<td><select name="jdid" id="streetList">
				</select></td>
			</tr>
			<tr>
			  <td><strong>租金：</strong></td>
				<td><input type="text" name="zj" id = "zj" value="3000"/>元/月</td>
			</tr>
			<tr>
			  <td><strong>面积：</strong></td>
				<td><input type="text" name="floorage" id = "floorage" value="200"/>平</td>
			</tr>
			<tr>
			  <td><strong>户型：</strong></td>
				<td><select name="houseType" id = "houseType">
				
				</select></td>
			</tr>
			<tr>
			  <td><strong>联系电话：</strong></td>
				<td><input type="text" name="contact" id ="contact" value="13789356789"></td>
			</tr>
			<tr>
			  <td><strong>房屋信息：</strong></td>
				<td><textarea name="fwxx" id ="fwxx" rows="5" cols="20">
				好好好
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<div align="center">
				<input type="button" value="提交" id="btn" />
				</div>				
			</td>
			</tr>
		</table>
	</form>
<%@include file="bottom.jsp"%>
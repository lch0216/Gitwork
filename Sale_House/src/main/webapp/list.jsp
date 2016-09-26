<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript" src="js/list.js"></script>
<script type="text/javascript" src="js/post.js"></script>
<script>
	function fswitch(id) {
		var o = document.getElementById(id);
		if (o) {
			if (o.style.display == "none") {
				o.style.display = "block";
			} else {
				o.style.display = "none";
			}
		}
	}
</script>
<form action="" name="myform">
	<input type="hidden" name="page" value="n" />
	<div style="text-align: left; width: 88%;">
		<input type="text" id="title" placeholder="请输入查询内容" value="" /> <input
			type="button" value="查询" id="search" class="btn"> <span
			onclick="fswitch('advSearch');" style="cursor: hand; color: blue;">高级搜索</span>
	</div>
	<table width="88%;" id="advSearch"
		style="border: solid 0px #000; display: none;">
		<tr>
			<td>区县：</td>
			<td><select name="qxid" id="districtList" onChange="selectjd()"
				style="width: 80">
			</select></td>
		</tr>
		<tr>
			<td><strong>街道：</strong></td>
			<td><select name="jdid" id="streetList" style="width: 80">
			</select></td>
		</tr>
		<tr>
			<td><strong>租金：</strong></td>
			<td><input type="text" id="minPrice" name="zj" size="5"
				class="unnamed1"> 至 <input type="text" name="zj1"
				id="maxPrice" size="5" class="unnamed1"> 元/月</td>
		</tr>
		<tr>
			<td><strong>面积：</strong></td>
			<td><input type="text" name="floorage" id="floorage" />平</td>
		</tr>
		<tr>
			<td><strong>户型：</strong></td>
			<td>
			<select name="houseType" id="houseType">
			</select>
			</td>
		</tr>
		<tr>
			<td><strong>联系电话：</strong></td>
			<td><input type="text" name="contact" id="contact"></td>
		</tr>
	</table>
</form>
<div id="houseList"></div>
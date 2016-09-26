$(function(){
	var index = location.href.lastIndexOf("?");
	var params = location.href.substring( index + 1);
	// 根据条件查询
	$.ajax({
		type : "post",
		url : "house_findHouseById",
		data: params,
		dataType : "json",
		success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
			if ( data.code == 1 ) {
				$("#detail").html( "" );	
				var htmlstr= '<table width="450">';
					htmlstr += '<tr><td id=listTitle>'+data.obj.title+'</td></tr>';
					htmlstr += '<tr><td id=listTitle><hr/></td></tr>';
					htmlstr += '<tr><td><strong>电话/手机：</strong>'+data.obj.contact+'</td></tr>';
					htmlstr += '<tr><td><strong>联系人：</strong>'+data.obj.user.name+'</td></tr>';
					htmlstr += '<tr><td><strong>户型：</strong>'+data.obj.houseType.name+'</td></tr>';
					htmlstr += '<tr><td><strong>价格：</strong>'+data.obj.price+'元</td></tr>';
					htmlstr += '<tr><td><strong>地段：</strong>'+data.obj.street.district.name+'区&nbsp;&nbsp;'+data.obj.street.name+'街道</td></tr>';
					htmlstr += '<tr><td><strong>发布时间：</strong> '+data.obj.pubdate+'</td></tr>';
					htmlstr += '<tr><td><hr></td></tr>';
					htmlstr += '<tr><td >'+data.obj.description+'</td></tr>';
					htmlstr += '<tr><td><input type="button" value="后退" class="btn" onclick="back()"></td></tr>';
					htmlstr += '</table>';
				$("#detail").html( htmlstr );		
			} 
		}
	});
});
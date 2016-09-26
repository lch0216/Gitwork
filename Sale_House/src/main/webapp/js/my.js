$(function(){
	gotopage();
});	

function gotopage( page ){
	$.ajax({
		type : "post",
		url : "house_findAll",
		data:{
			"currPage": page? page : 1,
		},
		dataType : "json",
		success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
			if ( data.code == 1 ) {
				$("#myhouseInfo").html( "" );	
				var htmlstr= '<table width="88%;" >';
				htmlstr += '<tr><td width="40">序号</td><td width="160">标题</td><td >租金</td><td>发布日期</td><td>操作</td></tr><hr/>';
				for( var i= 0;i < data.obj.houses.length;i++ ){
					var obj = data.obj.houses[i] ;
					htmlstr +='<tr><td>'+obj.id+'</td>';
					htmlstr += '<td ><a href="detail.jsp?house.id='+obj.id+'">'+obj.title+'</a></td>';
					htmlstr += '<td align="center">'+obj.price+'元</td>';
					htmlstr += '<td align="center">'+obj.pubdate+'</td>';
					htmlstr += '<td align="center"><a href="update.jsp?house.id='+obj.id+'">更新</a><a href="#" onclick="del('+obj.id+');return false;">删除</a></td></tr>';
				}
				htmlstr +='</table><hr/><div width"500" height:"100">';
				htmlstr +='总共有'+data.obj.totalRecord+'条记录   共'+data.obj.total+'页 每页'+data.obj.sizePage+'条记录';
				htmlstr +='当前所在页：'+data.obj.currPage+'';
				for(var j = 0; j< data.obj.total ;j ++ ){
					htmlstr +='<a href ="#" onclick = "gotopage('+(j+1)+');return false;">'+(j+1)+'</a>&nbsp;&nbsp;';
				}
				htmlstr +='</div>';
				$("#myhouseInfo").html( htmlstr );		
			} 
		}
	});
}

function del( id ){
	$.ajax({
		type : "post",
		url : "house_del",
		data:{ "house.id": id},
		dataType : "json",
		success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
			if ( data.code == 1 ) {
				alert("删除成功....");
			}
		}
	});
}

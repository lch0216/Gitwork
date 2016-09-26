$(function(){
	gotopage();
	$("#search").click(function(){
		var params = {
				'currPage': 1,
				'house.title':$("#title").val(),
		};
		if( document.getElementById("advSearch").style.display == 'block'){
			if( $("#streetList").val() != 0){
				params["house.street.id"] = $("#streetList").val();
			}
			if( $("#minPrice").val() != null &&  $("#minPrice").val() != 'undefined'){
				params["minPrice"] = $("#minPrice").val();
				params["maxPrice"] = $("#maxPrice").val();
			}
			if( $("#houseType").val() != 0){
				params["house.houseType.id"] = $("#houseType").val();
			}
		}
	// 根据条件查询
	$.ajax({
		type : "post",
		url : "house_search",
		data: params,
		dataType : "json",
		success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
			if ( data.code == 1 ) {
				$("#houseList").html( "" );	
				var htmlstr = '<table width="88%;" >';
				htmlstr += '<tr><td width="250">标题</td><td width="90" align="center" style="height: 30px;">租金</td><td>发布日期</td></tr>';
				for( var i= 0;i < data.obj.houses.length;i++ ){
					var obj = data.obj.houses[i] ;
					htmlstr += '<tr><td width="250"><a href="detail.jsp?house.id='+obj.id+'">'+obj.title+'</a></td>';
					htmlstr += '<td width="90" align="center" style="height: 30px;">'+obj.price+'元</td>';
					htmlstr += '<td align="center">'+obj.pubdate+'</td></tr>';
				}
				htmlstr +='<hr/><div>';
				for(var i=0;i<data.obj.total;i++){
					htmlstr +='<a href ="#" onclick = "gotopage('+(i+1)+');return false;">'+(i+1)+'</a></div>';
				}
				$("#houseList").html( htmlstr );		
			} 
		}
	
	
	
	});
});
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
				$("#houseList").html( "" );	
				var htmlstr = '<table width="88%;" >';
				htmlstr += '<tr><td width="250">标题</td><td width="90" align="center" style="height: 30px;">租金</td><td>发布日期</td></tr><hr/>';
				for( var i= 0;i < data.obj.houses.length;i++ ){
					var obj = data.obj.houses[i] ;
					htmlstr += '<tr><td width="250"><a href="detail.jsp?house.id='+obj.id+'">'+obj.title+'</a></td>';
					htmlstr += '<td width="90" align="center" style="height: 30px;">'+obj.price+'元</td>';
					htmlstr += '<td align="center">'+obj.pubdate+'</td></tr>';
				}
				htmlstr +='</table><hr/><div width"500" height:"100">';
				htmlstr +='总共有'+data.obj.totalRecord+'条记录   共'+data.obj.total+'页 每页'+data.obj.sizePage+'条记录';
				htmlstr +='当前所在页：'+data.obj.currPage+'&nbsp;&nbsp;';
				for(var j = 0; j< data.obj.total ;j++){
					htmlstr +='<a href ="#" onclick = "gotopage('+(j+1)+');return false;">'+(j+1)+'</a>&nbsp;&nbsp;';
				}
				htmlstr +='</div>';
				$("#houseList").html( htmlstr );		
			} 
		}
	});
}

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
				$("#id").val( data.obj.id );
				$("#title").val( data.obj.title );
				$("#zj").val( data.obj.price );
				$("#floorage").val( data.obj.floorage );
				$("#contact").val( data.obj.contact );
				$("#fwxx").val( data.obj.description );
				
				
				var count = $("#houseType option").length;
				for( var i=0;i<count;i++){
					if( $("#houseType").get[0].options[i].text == data.obj.houseType.name ){
						$("#houseType").get[0].options[i].selected = true;
						break;
					}
				}
				
				count = $("#districtList option").length;
				for( var i=0;i<count;i++){
					if( $("#districtList").get[0].options[i].text == data.obj.street.district.name ){
						$("#districtList").get[0].options[i].selected = true;
						break;
					}
				}
				$("#streetList").html('<option value="'+data.obj.street.id+'" >'+data.obj.street.name +'</option>');
				
			}
		}			
	});
	$("#btn").click(function(){
		$.ajax({
			type:'post',
			data:{
				'house.id':$("#id").val(),
				'house.title' : $("#title").val(),
				'house.street.id' : $("#streetList").val(),
				'house.price' : $("#zj").val(),
				'house.houseType.id' : $("#houseType").val(),
				'house.contact' : $("#contact").val(),
				'house.description' : $("#fwxx").val(),
				'house.floorage' : $("#floorage").val()
			},
			url:'house_update',
			dataType:"json",
			success:function (data){
				if(data.code == 1){
					alert('房屋信息修改成功...');
					window.location.href="my.jsp";
				}else{
					alert('房屋信息修改失败...');
				}
			}
		});
	});
	
	$.ajax({
			type : "post",
			url : "district_findAll",
			dataType : "json",
			success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
				if ( data.code == 1 ) {
					$("#districtList").html( "" );	
					var htmlstr= "<option value='0'>不限--</option>";
					for(var i= 0;i < data.obj.length;i++){
						var district = data.obj[i];
						var val = district.name ;
						htmlstr += '<option value="'+district.id+'" data="' ;
						for(var j = 0;j < district.streets.length;j++){
							var street =  district.streets[j];
							htmlstr += street.id +"_" + street.name+ " ";
						}
						htmlstr +='">'+val+'</option>';
					}
				}
					$("#districtList").html( htmlstr );
			}
		});
	$.ajax({
		type : "post",
		url : "houseType_findAll",
		dataType : "json",
		success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
			if ( data.code == 1 ) {
				$("#houseType").html( "" );	
				var htmlstr= '<option value="0" >不限---</option>';
				for( var i= 0;i < data.obj.length;i++ ){
					var obj = data.obj[i] ;
					htmlstr += '<option value="'+obj.id+'">'+obj.name+'</option>';
				}
				$("#houseType").html( htmlstr );		
			} 
		}
	});
});	

function selectjd() {
	var district = document.getElementById ("districtList");
	if(district.options[district.selectedIndex].data != 'undefined'){
		var htmlstr= "<option value='0'>不限--</option>";
		var value = district.options[district.selectedIndex].getAttribute("data");
		if(value.indexOf(" ") != null ){
			var temp = value.split(" ");
			for(var i=0 ; i < temp.length-1 ;i++){
				var t = temp[i];
				var arr = t.split("_");
				htmlstr += "<option value='"+arr[0]+"'>"+arr[1]+"</option>";
			}
			$("#streetList").html( htmlstr );
		}
		
	}
}

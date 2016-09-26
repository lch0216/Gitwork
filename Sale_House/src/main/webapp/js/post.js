$(function(){
	$("#btn").click(function(){
		$.ajax({
			type:'post',
			data:{
				'house.title' : $("#title").val(),
				'house.street.id' : $("#streetList").val(),
				'house.price' : $("#zj").val(),
				'house.houseType.id' : $("#houseType").val(),
				'house.contact' : $("#contact").val(),
				'house.description' : $("#fwxx").val(),
				'house.floorage' : $("#floorage").val()
			},
			url:'house_add',
			dataType:"json",
			success:function (data){
				if(data.code == 1){
					alert('房屋信息发布...');
					window.location.href="index.jsp";
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

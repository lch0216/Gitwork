function reg(){
		$.ajax({
			type : "post",
			url : "user_reg",
			data:$("#myform").serialize(),
			dataType : "json",
			success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
				if ( data.code == 1 ) {
					alert("注册成功....")
					window.location.href="login.jsp";		
				} 
			}
		});
	}	
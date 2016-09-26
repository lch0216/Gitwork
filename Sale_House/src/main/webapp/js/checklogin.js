$(function(){
		$.ajax({
			type : "post",
			url : "user_checklogin",
			dataType : "json",
			success : function(data) {//data为后台传送数据 即例如：servlet中out输出的内容
				var htmlstr = '';
				if ( data.code == 1 ) {
					htmlstr += '<table align="center"><tr><td width="150"><font color="red">当前用户：'+data.obj.username+'';
					htmlstr +='</font></td></tr><tr><td width="150"><a href="my.jsp">管理我的租房信息</a></td></tr>';
					htmlstr +='<tr><td width="100"><a href="post.jsp">发布租房信息</a></td></tr><tr><td><a href="index.jsp">返回首页</a></td></tr><tr><td width="100"><a href="#" onclick="logout();return false;">[注销]</a></td></tr></table>';		
					$("#loginstatus").html(htmlstr);
				} else{
					htmlstr +='<table align="center"><tr><td><a href="welcome.jsp">返回首页</a></td>';
					htmlstr +='</tr><tr><td><a href="reg.jsp">用户注册</a></td></tr></table>';
					$("#loginstatus").html(htmlstr);
				}
			}
		});
	});	

function logout (){
	$.ajax({
		type : "post",
		url : "user_logout",
		dataType : "json",
		success : function(data) {
			if(data.code == 1){
				var htmlstr ='<table align="center"><tr><td><a href="welcome.jsp">返回首页</a></td>';
				htmlstr +='</tr><tr><td><a href="reg.jsp">用户注册</a></td></tr></table>';
				$("#loginstatus").html(htmlstr);
			}
		}
	});
}


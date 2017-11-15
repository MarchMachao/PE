<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生体质健康数据</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        .b-wrapper{padding: 0 20px 50px; font-family: "微软雅黑";}
        .part1{padding-left: 20px;}
        .part1 h4{margin-left: 18%;}
        .part h4{height: 30px; margin-left: 5%; color: #375a5d; font-weight: bold;}
        .part-title{width: 140px; display: inline-block; text-align: justify; }
        .b-word{font-size: 18px; color: #333; padding-left: 130px;}
        .b-wrapper ul{margin-left: 115px;}
        .b-wrapper li{font-size: 18px; color: #333; padding-left: 15px;}
        .part{margin-top: 20px; padding-left: 20px;}
        .part2-title{display: inline-block; width: 230px;}
        .line{display: block; width: 90%; margin: 20px auto; height: 0; border: none; border-top: 1px solid #c2daee;}
        .part3 ul{width: 80%;}
        .btn-wrapper{padding-right: 15%; margin-top: 50px;}
        .pro-btn{padding: 8px 40px; box-shadow: 3px 3px 3px #275f8f; margin-left: 20px;}
        .form-control{width: 110px ; display: inline-block;}
        .modal-dialog {width: 600px; margin: 200px auto;}
        .modal-body {position: relative; padding: 15px 15px 15px 20%;}
    </style>
</head>
<body>
<div class="b-wrapper">
    <h2>
        <p class="text-center">学生体质健康数据</p>
    </h2>
    <div class="part part3">
        <h4>学生基本信息</h4>
        <ul class="list-unstyled row">
            <li class="col-md-6">
                <span class="part2-title">学号：</span><span>${item.id}</span>
            </li>
            <li class="col-md-6">
                <span class="part2-title">姓名：</span><span>${item.name}</span>
            </li>
            <li class="col-md-6">
                <span class="part2-title">性别：</span><span>${item.gender}</span>
            </li>
            <li class="col-md-6">
                <span class="part2-title">学院：</span><span>${item.school}</span>
            </li>
            <li class="col-md-6">
                <span class="part2-title">年级：</span><span>${item.grade}</span>
            </li>
            <li class="col-md-6" style="height: 25px;">
                <span class="part2-title">班级：</span><span id="changeclass-1">${item.classes}</span>
                <span id="changeclass-2" style="display: none;">
	                <select id="changeclass-2-select">
					</select>
					<a href="javascript:changeClass2()">保存</a>
                </span>
            </li>
            <li class="col-md-6">
                <span class="part2-title">学制：</span><span>${item.duration}</span>
            </li>
            <#if item.teacher != "学院">
				<li class="col-md-6">
	                <span class="part2-title">课程名：</span><span>${teacher.subjectName}</span>
	            </li>
	            <li class="col-md-6">
	                <span class="part2-title">课程教师：</span><span>${teacher.newTeacher}</span>
	            </li>
			</#if>
            
            <li class="col-md-6">
            	<span class="part2-title"><a href="javascript:changeClass1();" >修改班级</a></span>
            	<span class=""><a href="#" data-toggle="modal" data-target="#myModal">修改密码</a></span>
            </li>
        </ul>
        <i class="line"></i>
    </div>
    <div class="part part3">
        <h4>学生体质健康标准测试</h4>
    </div>
    <div class="part part3">
    <table class="table table-hover" id="grid" style="margin: 0 5%;width: 90%">
		  <tr>
				<th>年份</th>
				<th>身高</th>
				<th>体重</th>
				<th>肺活量</th>
				<th>50m跑</th>
				<th>立定跳远</th>
				<th>坐位体前屈</th>
				<th>800m</th>
				<th>1000m</th>
				<th>一分钟仰卧起坐</th>
				<th>引体向上</th>
				<th>评分</th>
		  </tr>
		</table>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改密码</h4>
      </div>
      <form method="post" action="" >
	      <div class="modal-body">
	      	<div class="form-group">
	        	<label class="col-md-3">原密码</label><input id="password" class="form-control" type="password" placeholder="请输入原密码"/>
	       	</div>
	        <div class="form-group">
	        	<label class="col-md-3">新密码</label><input id="pwd" class="form-control" type="password" placeholder="请输入新密码"/>
	       	</div>
	        <div class="form-group">
	        	<label class="col-md-3">确认新密码</label><input id="pwd2" class="form-control" type="password" placeholder="请再输一次"/>
	       	</div>
	      </div>
	      <div class="modal-footer">
	        <button id="closebtn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" onclick="updatePassword();">确认更改</button>
	      </div>
      </form>
    </div>
  </div>
</div>
</body>
<script>
	$.get("getAllDataById.do", function(data) {
		var $grid = $("#grid");
		$grid.find("tr:gt(0)").remove();
	
		var content = "";
		for(var i = 0; i < data.length; i++) {
			var eightmtemp = (data[i].eightm == null) ? "" : data[i].eightm;
			var tenmstemp = (data[i].tenm == null) ? "" : data[i].tenm;
			var sit_upstemp = (data[i].sit_ups == null) ? "" : data[i].sit_ups;
			var pull_upstemp = (data[i].pull_up == null) ? "" : data[i].pull_up;
			content += "<tr>" +
				"   <td>" + data[i].year + "</td>" +
				"   <td>" + data[i].height + "</td>" +
				"   <td>" + data[i].weight + "</td>" +
				"   <td>" + data[i].vital_capacity + "</td>" +
				"   <td>" + data[i].fivem + "</td>" +
				"   <td>" + data[i].long_jump + "</td>" +
				"   <td>" + data[i].reach + "</td>" +
				"   <td>" + eightmtemp + "</td>" +
				"   <td>" + tenmstemp + "</td>" +
				"   <td>" + sit_upstemp + "</td>" +
				"   <td>" + pull_upstemp + "</td>" +
				"   <td>" + data[i].score + "</td>" +
				"</tr>";
		}
		$grid.append(content);
	})
	
	function changeClass1(){
		$("#changeclass-1").css("display","none");
//		$.get(
//			"",
//			{grade:${item.grade}},
//			function(data){
//				var options = "";
//				for(i=0;i<data.length;i++){
//					options += "<option>"+data[i]+"</option>"
//				}
//				$("#changeclass-2-select").append(optins);
//			}
//		)
		$("#changeclass-2").css("display","inline");
	}
	
	function changeClass2(){
		$("#changeclass-2").css("display","none");
		$.post(
			"updateClass.do",
			{"classes":$("#changeclass-2-select").val()},
			function(data){
				if(data.success){
					alert(data.content);
				}else{
					location.href = "getStudentById.do";
				}
			}
		)
		
	}
	
	function updatePassword(){
		$.post("updateStuPassword.do",
			{
			"password":$("#password").val(),
			"pwd":$("#pwd").val(),
			"pwd2":$("#pwd2").val()
			},
			function(data){
				if(data.success){
					alert("修改成功！ "+data.content);
					$("#closebtn").click();
				}else{
					alert("修改失败！ "+data.content);
				}
			})
	}
</script>
</html>
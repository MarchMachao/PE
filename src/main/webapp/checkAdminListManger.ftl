<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生体质健康标准数据</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .b-wrapper{padding: 0 20px 50px; font-family: "微软雅黑";}
        .part1{padding-left: 20px;}
        .part1 h4{margin-left: 18%;}
        .part h4{height: 30px; color: #375a5d; font-weight: bold;}
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
        .table th, .table td{
        	font-size: 16px;
        	text-align: center;
        }
    </style>
</head>
<body>
<div class="b-wrapper">
    <h2>
        <p class="text-center">管理员数据审核</p>
    </h2>
    <!--
   	作者：759827866@qq.com
   	时间：2017-07-14
   	描述：教师
    -->
    <div style="width: 48%;float:left">
	    <div class="part part3">
	        <h4>教师以及提交状态</h4>
	    </div>
	    <div style="width:100%;margin: 0 auto;">
		     <table class="table table-hover" style="text-align: center;">
				  <tr>
						<th>教师</th>
						<th>审核状态</th>
						<th>操作</th>
				  </tr>
				  <#list adminTeacherList as check1>
						<tr>
							<td>${check1.teacher}</td>
							<td>${check1.second_check}</td>
							<td><button class="btn btn-info" onclick="window.location.href='turnToTeacherCheck.do?teacher=${check1.teacher}'">打开成绩表</button></td>
						</tr>
				 </#list>
			</table>
	   </div>
   </div>
   <!--
   	作者：759827866@qq.com
   	时间：2017-07-14
   	描述：学院
   -->
   <div style="width: 48%;float:right">
	   <div class="part part3">
	        <h4>学院以及提交状态</h4>
	    </div>
	    <div style="width: 100%;margin: 0 auto;">
		     <table class="table table-hover" style="text-align: center;">
				  <tr>
						<th>学院</th>
						<th>审核状态</th>
						<th>操作</th>
				  </tr>
				  <#list adminSchoolList as check2>
						<tr>
							<td>${check2.school}</td>
							<td>${check2.second_check}</td>
							<td><button class="btn btn-info" onclick="window.location.href='turnToSchoolCheck.do?school=${check2.school}'">打开成绩表</button></td>
						</tr>
				 </#list>
			</table>
	   </div>
   </div>
</div>
<script src="js/jquery-1.11.0.min.js"></script>

</body>
<script>
	function find(){
		$.get(".do",function(data){
			console.log();
		})
	}
	
	function deleteId(id) {
		console.log(id);
		$.get("deleteHome.do", {
			"id": id
		},function(data) {
				alert(data.content);
				find();
			}
		)
	}
</script>
</html>
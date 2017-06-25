<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生体质健康标准数据</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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
    </style>
</head>
<body>
<div class="b-wrapper">
    <h2>
        <p class="text-center">学生体质健康标准数据</p>
    </h2>
    <div class="part part3">
        <h4>学生基本信息</h4>
        <ul class="list-unstyled row">
            <li>
                <span class="part2-title">学号：</span><span id="land-1"></span>${item.id}
            </li>
            <li class="col-md-6">
                <span class="part2-title">姓名：</span><span id="land-2"></span>${item.name}
            </li>
            <li class="col-md-6">
                <span class="part2-title">性别：</span><span id="land-3"></span>${item.gender}
            </li>
            <li class="col-md-6">
                <span class="part2-title">学院：</span><span id="land-4"></span>${item.school}
            </li>
            <li class="col-md-6">
                <span class="part2-title">年级：</span><span id="land-5"></span>${item.grade}
            </li>
            <li class="col-md-6">
                <span class="part2-title">班级：</span><span id="land-6"></span>${item.classes}
            </li>
            <li class="col-md-6">
                <span class="part2-title">年制：</span><span id="land-7"></span>${item.duration}
            </li>
        </ul>
        <i class="line"></i>
    </div>
    <div class="part part3">
        <h4>学生体质健康标准测试</h4>
    </div>
    <div style="width: 85%;margin: 0 auto;">
    <table class="table table-hover" id="grid">
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
    <div class="text-right btn-wrapper">
        <button type="button" id="backToStuation" class="btn btn-primary pro-btn" onclick="javascript:location.href = 'toStuation.do?id=${projectId}'">情景设置</button>
        <button type="button" id="toResult" class="btn btn-primary pro-btn" onclick="javascript:;">情景模拟</button>
    </div>
</div>
<script src="js/jquery-1.11.0.min.js"></script>
</body>
<script>
		find();
		function find(){
			$.get("getAllDataById.do",function(data){
				var $grid = $("#grid");
				$grid.find("tr:gt(0)").remove();
				
				var content = "";
				for (var i = 0; i < data.length; i++) {
					content += "<tr>" 
					         + "   <td>" + data[i].year + "</td>"
					         + "   <td>" + data[i].height + "</td>"
					         + "   <td>" + data[i].weight + "</td>"
					         + "   <td>" + data[i].vital_capacity + "</td>"
					         + "   <td>" + data[i].fivem + "</td>"
					         + "   <td>" + data[i].long_jump + "</td>"
					         + "   <td>" + data[i].reach + "</td>"
					         + "   <td>" + data[i].eightm + "</td>"
					         + "   <td>" + data[i].tenm + "</td>"
					         + "   <td>" + data[i].sit_ups + "</td>"
					         + "   <td>" + data[i].pull_up + "</td>"
					         + "   <td>" + data[i].score + "</td>"
					         + "</tr>";
				}
				
				$grid.append(content);
				
				console.log(data);
			})
		}
</script>
</html>
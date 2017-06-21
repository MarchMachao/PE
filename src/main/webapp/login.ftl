<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>兰州大学学生健康标准数据管理平台</title>
<meta charset="UTF-8" />
<meta http-equiv=\X-UA-Compatible\ content=\IE=edge,chrome=1\ />
<meta name=\renderer\ content=\webkit\ />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/camera.css" />
<link rel="stylesheet" href="css/matrix-login.css" />
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<meta name="renderer" content="webkit">
</head>
<body>

	<div style="width: 100%; text-align: center; margin: 0 auto; position: absolute;">
		<div id="loginbox">
			<form action="login.do" method="POST" name="loginForm" id="loginForm">
				<div class="control-group normal_text">
					<h3>
						兰州大学学生体质健康标准数据管理平台
					</h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg"> <i> <img height="37"
									src="images/user.png" />
							</i>
							</span> <input type="text" name="userName" id="loginname" value=""
								placeholder="请输入用户名" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly"> <i> <img height="37"
									src="images/suo.png" />
							</i>
							</span> <input type="password" name="password" id="password"
								placeholder="请输入密码" value="" />
						</div>
						<div class="danger-error" >${backinfo}</div>
					</div>
				</div>
				<div class="form-actions">
					<div style="width: 86%; padding-left: 8%;">
						<span class="pull-left" style="padding-right: 3%;">
							<input type="reset" class="btn btn-success"/>
						</span>
						<span class="pull-right">
							<input type="submit" class="flip-link btn btn-info" value="登录"/>
						</span>
					</div>
				</div>
			</form>
			<div class="controls">
				<div class="main_input_box">
					<font color="white">
						<span id="nameerr">Copyright © 2017 兰州大学</span>
					</font>
				</div>
			</div>
		</div>
	</div>
	
	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<div data-src="images/banner_slide_01.jpg"></div>
			<div data-src="images/banner_slide_02.jpg"></div>
			<div data-src="images/banner_slide_03.jpg"></div>
		</div>
	</div>

	<script src="js/jquery-1.7.2.js"></script>
	<script src="js/camera.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/templatemo_script.js"></script>

</body>

</html>
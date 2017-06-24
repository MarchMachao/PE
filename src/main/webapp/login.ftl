<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>兰州大学学生体质健康标准数据管理平台</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/camera.css"/>
    <link rel="stylesheet" href="css/matrix-login.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<!--默认背景图-->
<div id="IEbg"></div>
<div id="loginbox">
        <form action="login.do" method="POST" name="loginForm" id="loginForm">
            <div class="control-group normal_text">
                <h3>
                    兰州大学学生体质健康标准数据管理平台
                </h3>
            </div>
            <div class="control-group">
                <div class="controls">
                    <label class="main_input_box">
                        <input type="text" name="userName" id="loginname" value="" placeholder="请输入用户名" class="login-input"/>
                        <span class="placeholder-span hide">请输入用户名</span>
                    </label>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <label class="main_input_box">
                        <input type="password" name="password" id="password" value="" placeholder="请输入密码" class="login-input"/>
                        <span class="placeholder-span hide">请输入密码</span>
                    </label>
                    <div class="danger-error">${backinfo}</div>
                </div>
            </div>
            <div class="form-actions">
                <div class="btn-wrapper clearfix">
                    <input type="reset" class="btn reset-btn pull-left"/>
                    <input type="submit" class="btn flip-link pull-right btn-login" value="登录"/>
                </div>
            </div>
        </form>
        <div class="controls">
            <div class="main_input_box">
                <span id="nameerr">Copyright © 兰州大学体育教研部</span>
            </div>
        </div>
    </div>
<div id="templatemo_banner_slide" class="container_wapper">
    <div class="camera_wrap camera_emboss" id="camera_slide">
        <div data-src="images/01.jpg"></div>
        <div data-src="images/02.jpg"></div>
        <div data-src="images/03.jpg"></div>
    </div>
</div>
<script src="js/jquery-1.7.2.js"></script>
<script src="js/camera.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/templatemo_script.js"></script>
</body>

</html>
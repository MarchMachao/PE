<!DOCTYPE html>
<html>
	<head>
		<title>学生健康标准数据平台</title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta charset="UTF-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	    <meta name="renderer" content="webkit"/>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.6 -->
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
		<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
		<style>
			#webcontent {
				width: 100%;
				border: none;
			}
			.content {
			    min-height: 250px;
			    padding: 0px;
			    margin-right: auto;
			    margin-left: auto;
			    padding-left: 0px;
			    padding-right: 0px;
			}
			.skin-blue-light .sidebar-menu>li:hover>a, .skin-blue-light .sidebar-menu>li.active>a {
			    color: #000;
			    background: #DCDCDC;
			}
			.skin-blue-light .sidebar-menu>li>.treeview-menu {
			    background: #EBEBEB;
			}
			.skin-blue-light .sidebar-menu>li.active {
			    border-left:7px solid #3c8dbc
			}
		</style>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="sidebar-mini wysihtml5-supported skin-blue-light">
		<div class="wrapper">

			<header class="main-header">
				<!-- Logo -->
				<a href="javascript:void(0);" class="logo">
					<!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><b>LZU</b></span>
					<!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><b>学生健康标准数据平台</b></span>
				</a>
				<!-- Header Navbar: style can be found in header.less -->
				<nav class="navbar navbar-static-top">
					<!-- Sidebar toggle button-->
					<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
						<span class="sr-only">Toggle navigation</span>
					</a>
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<!-- User Account: style can be found in dropdown.less -->
							<li class="user user-menu">
								<a href="logout.do" class="dropdown-toggle">
									<img src="images/logout.png" class="user-image" alt="logout">
									<span class="hidden-xs">退出</span>
								</a>
							</li>
						</ul>
					</div>
				</nav>
			</header>
			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="dist/img/user2-160x161.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>${nickName}</p>
							<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
						</div>
					</div>
					<!-- menu -->
					<ul class="sidebar-menu">
						<#list menulist as item>
							<li class="treeview">
								<a href="#">
									<i class="fa fa-link"></i>
									<span class="menuUrl" menuUrl="${item.menuUrl}">${item.menuName}</span>
									<span class="pull-right-container">
  							<i class="fa fa-angle-left pull-right"></i>
						</span>
								</a>
								<ul class="treeview-menu">
									<#list item.submenus as record>
										<li>
											<a href="javascript:void(0)" class="menuUrl" menuUrl="${record.menuUrl}">${record.menuName}</a>
										</li>
									</#list>
								</ul>
							</li>
						</#list>
					</ul>
					<!-- /menu -->

			</aside>

			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<section class="content">
					<iframe id="webcontent" src="welcome.html"></iframe>
				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->

			<div class="control-sidebar-bg"></div>
		</div>
		<!-- ./wrapper -->
		<!-- jQuery 2.2.3 -->
		<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- AdminLTE App -->
		<script src="dist/js/app.min.js"></script>
		<script type="text/javascript">
			$("#webcontent").attr("height", $(window).height()- 55);
			window.onresize = function() {
				$("#webcontent").attr("height", $(window).height()- 55);
			}
			$(".menuUrl").click(function() {
				var url = this.getAttribute("menuUrl");
				if(url != "none") {
					$("#webcontent").attr("src", url);
				}

			})
			$(".treeview").click(function(){
				var url = $(this).children("a").children(".menuUrl").attr("menuUrl");
				if(url != "none") {
					$("#webcontent").attr("src", url);
				}
			})
		</script>
	</body>

</html>
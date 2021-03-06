<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<script type="text/javascript" src="easyUI/jquery.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
<style>
	.l-btn-text{
		font-size: 18px;
	}
	.panel-body{
		font-size: 18px;
	}
	.textbox .textbox-text{
		font-size: 15px;
	}
	.panel-title{
		font-size: 15px;
	}
</style>
</head>

<body>
	<h2 style="text-align: center;">学院审核页面(管理员页面)</h2>
	<div class="hr" style="clear: both;"></div>
	<table id="dg" style="width: 100%; height: auto;"
		data-options="rownumbers:true,singleSelect:true,pagination:true,url:'findAdminCheckBySchool.do?school=${checkAdminSchool}',method:'get'"
		toolbar="#tb">
		<thead>
			<tr>
				<th data-options="field:'id',width:100,align:'center'">学号</th>
				<th data-options="field:'name',width:75,align:'center'">姓名</th>
				<th data-options="field:'gender',width:40,align:'center'">性别</th>
				<th data-options="field:'grade',width:60,align:'center'">年级</th>
				<th data-options="field:'school',width:150,align:'center'">学院</th>
				<th data-options="field:'year',width:70,align:'center'">年份</th>
				<th data-options="field:'height',width:80,align:'center'">身高</th>
				<th data-options="field:'weight',width:80,align:'center'">体重</th>
				<th data-options="field:'vital_capacity',width:80,align:'center'">肺活量</th>
				<th data-options="field:'fivem',width:80,align:'center'">50m</th>
				<th data-options="field:'long_jump',width:80,align:'center'">立定跳远</th>
				<th data-options="field:'reach',width:80,align:'center'">坐位体前屈</th>
				<th data-options="field:'eightm',width:80,align:'center'">800m</th>
				<th data-options="field:'tenm',width:80,align:'center'">1000m</th>
				<th data-options="field:'sit_ups',width:80,align:'center'">仰卧起坐</th>
				<th data-options="field:'pull_up',width:80,align:'center'">引体向上</th>
				<th data-options="field:'score',width:80,align:'center'">评分</th>
				<th data-options="field:'state',width:80,align:'center'">备注</th>
				<th data-options="field:'first_check',width:80,align:'center'">第一级审核</th>
				<th data-options="field:'second_check',width:80,align:'center'">第二级审核</th>
	</table>
	<div id="tb" style="width: auto;">
		<a href="javascript:void(0)" id="okCheck" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
		   onclick="alert('已通过审核！');window.location.href='updateAdminSchoolStateOk.do?school=${checkAdminSchool}';"  plain="true">通过审核</a>
		<a href="javascript:void(0)" id="noCheck" class="easyui-linkbutton" data-options="iconCls:'icon-no'" 
		   onclick="alert('未通过审核！');window.location.href='updateAdminSchoolStateNo.do?school=${checkAdminSchool}';" plain="true">未通过审核</a>
	</div>
	
	<div id="check" class="easyui-dialog" closed="true"
		buttons="#excel-button" title="未通过审核" style="width: 400px; height: 330px;">
		<form id="checkForm" method="post" enctype="multipart/form-data" style="margin:0;padding:10px 40px">
			<table cellpadding="5">
				<tr>
					<label>退回原因:</label>
	    			<td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:190px;width: 300px;"></input></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="excel-button">
		<a href="#" id="submitNo" class="easyui-linkbutton" iconCls="icon-ok" style="width:20%;height:32px">提交</a>
	</div>
	
	<script type="text/javascript">
		$(function() {
			var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
		})
		//完成退回原因
		/* $("#noCheck").click(function(){
			$('#checkForm').form('clear');
			$('#check').dialog('open').dialog('center');
		})
		
		$("#submitNo").click(function(){
			$('#check').dialog('close');
		}) */
		
		function update() {
			/* window.location.href=""; */
		/* 	$.messager.alert('提示', "请选中要增加成绩的学生", 'info'); */
			$.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){
			    if (r){
					alert('ok');
			    }
			});
		}
		
	</script>
	</body>
</html>
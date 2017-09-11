<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">

<style>
.paraDiv {
	margin-top: 10px;
	float: left;
	margin-left: 5px;
}
</style>
</head>

<body>
	<h2 style="text-align: center;">学生成绩(教师页面)</h2>
	<div>
		<div style="margin-bottom: 20px;">
			<div class="paraDiv">
				<span class="paraName">学生姓名:</span> <input class="easyui-textbox"
					id="name" name="name"
					style="width: 100px; height: 32px; marin-top: 10px;">
			</div>
			<div class="paraDiv">
				<span class="paraName">学号:</span> <input class="easyui-textbox"
					id="id" name="id"
					style="width: 100px; height: 32px; marin-top: 10px;">
			</div>
			<div class="paraDiv">
				<span class="paraName">学院:</span> 
				<select class="easyui-combobox" id="school" name="school" style="width:135px;height: 32px">
					<option value="">全部</option>
					<option value="文学院">文学院</option>
					<option value="新闻与传播学院">新闻与传播学院</option>
					<option value="历史文化学院">历史文化学院</option>
					<option value="经济学院">经济学院</option>
					<option value="管理学院">管理学院</option>
					<option value="哲学社会学院">哲学社会学院</option>
					<option value="外国语学院">外国语学院</option>
					<option value="法学院">法学院</option>
					<option value="政治与行政学院">政治与行政学院</option>
					<option value="艺术学院">艺术学院</option>
					<option value="教育学院">教育学院</option>
					<option value="数学与统计学院">数学与统计学院</option>
					<option value="信息科学与工程学院">信息科学与工程学院</option>
					<option value="物理科学与技术学院">物理科学与技术学院</option>
					<option value="土木工程与力学学院">土木工程与力学学院</option>
					<option value="核科学与技术学院">核科学与技术学院</option>
					<option value="化学化工学院">化学化工学院</option>
					<option value="生命科学学院">生命科学学院</option>
					<option value="资源环境学院">资源环境学院</option>
					<option value="大气科学学院">大气科学学院</option>
					<option value="草地农业科技学院">草地农业科技学院</option>
					<option value="基础医学院">基础医学院</option>
					<option value="公共卫生学院">公共卫生学院</option>
					<option value="口腔医学院">口腔医学院</option>
					<option value="药学院">药学院</option>
				</select>
			</div>
			<div class="paraDiv">
				<span class="paraName">学份:</span> <input class="easyui-textbox"
					id="year" name="year"
					style="width: 100px; height: 32px; marin-top: 10px;">
			</div>
		</div>
		<a href="javascript:void(0)" id="search_btn" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'"
			style="float: left; width: 70px; height: 30px; margin-top: 10px; margin-left: 10px;">查找</a>
		<a href="javascript:void(0)" id="export_btn" class="easyui-linkbutton"
			data-options="iconCls:'icon-redo'"
			style="float: right; width: 70px; height: 30px; margin-top: 10px; margin-left: 10px;">导出</a>
		<a href="javascript:void(0)" id="import_btn" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo'"
			style="float: right; width: 70px; height: 30px; margin-top: 10px; margin-left: 10px;">导入</a>
	</div>
	<div class="hr" style="clear: both;"></div>
	<table id="dg" style="width: 100%; height: auto;"
		data-options="rownumbers:true,singleSelect:true,pagination:true,url:'findStuFreshmanData.do?subjectname=${teacherSubject}',method:'get'"
		toolbar="#tb">
		<thead>
			<tr>
				<th data-options="field:'id',width:100,align:'center'">学号</th>
				<th data-options="field:'name',width:90,align:'center'">姓名</th>
				<th data-options="field:'gender',width:50,align:'center'">性别</th>
				<th data-options="field:'grade',width:90,align:'center'">年级</th>
				<th data-options="field:'school',width:150,align:'center'">学院</th>
				<th data-options="field:'year',width:90,align:'center'">年份</th>
				<th data-options="field:'height',width:90,align:'center'">身高</th>
				<th data-options="field:'weight',width:90,align:'center'">体重</th>
				<th data-options="field:'vital_capacity',width:90,align:'center'">肺活量</th>
				<th data-options="field:'fivem',width:90,align:'center'">50m</th>
				<th data-options="field:'long_jump',width:90,align:'center'">立定跳远</th>
				<th data-options="field:'reach',width:90,align:'center'">坐位体前屈</th>
				<th data-options="field:'eightm',width:90,align:'center'">800m</th>
				<th data-options="field:'tenm',width:90,align:'center'">1000m</th>
				<th data-options="field:'sit_ups',width:90,align:'center'">仰卧起坐</th>
				<th data-options="field:'pull_up',width:90,align:'center'">引体向上</th>
				<th data-options="field:'score',width:90,align:'center'">评分</th>
				<th data-options="field:'first_check',width:90,align:'center'">第一级审核</th>
				<th data-options="field:'second_check',width:90,align:'center'">第二级审核</th>
			</tr>
	</table>
	<div id="tb">
		<a href="javascript:void(0)" id="addCustomInfo" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" ">添加成绩</a>
		<a href="javascript:void(0)" id="editCustomInfo" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true">修改成绩</a>
	</div>

	<div id="addInfo" class="easyui-dialog" closed="true"
		buttons="#dlg-buttons" title="添加成绩" style="width: 400px; height: 500px;">
		<form id="editInfoForm" method="post" enctype="multipart/form-data" style="margin:0;padding:10px 40px">
			<table cellpadding="5">
				<tr>
					<td>学号:</td>
					<td><input class="easyui-textbox" type="text" name="id" readonly  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input class="easyui-textbox" type="text" name="name" readonly  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input class="easyui-textbox" type="text" name="gender" readonly  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>年级:</td>
					<td><input class="easyui-textbox" type="text" name="grade" readonly  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>年份:</td>
					<td><input class="easyui-textbox" type="text" name="year" readonly  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>身高:</td>
					<td><input class="easyui-textbox" type="text" name="height"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>体重:</td>
					<td><input class="easyui-textbox" type="text" name="weight"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>肺活量:</td>
					<td><input class="easyui-textbox" type="text" name="vital_capacity"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>50m:</td>
					<td><input class="easyui-textbox" type="text" name="fivem"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>立定跳远:</td>
					<td><input class="easyui-textbox" type="text" name="long_jump"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>坐位体前屈:</td>
					<td><input class="easyui-textbox" type="text" name="reach"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>800m:</td>
					<td><input class="easyui-textbox" type="text" name="eightm"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>1000m:</td>
					<td><input class="easyui-textbox" type="text" name="tenm"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>仰卧起坐:</td>
					<td><input class="easyui-textbox" type="text" name="sit_ups"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>引体向上:</td>
					<td><input class="easyui-textbox" type="text" name="pull_up"  style="width: 200px; height: 32px"></input></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" onclick="save();">保存</a>
	</div>

	<div id="exportInfo" class="easyui-dialog" closed="true"
		buttons="#excel-button" title="导出成绩" style="width: 400px; height: 280px;">
		<form id="exportInfoForm" method="post" enctype="multipart/form-data" style="margin:0;padding:10px 40px">
			<table cellpadding="5">
				<tr>
					<td>学号:</td>
					<td><input class="easyui-textbox" type="text" id="ExId" name="id"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input class="easyui-textbox" type="text" id="ExName" name="name"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>学院:</td>
					<td>
					<select class="easyui-combobox" id="ExSchool" name="school" style="width:100%; height: 32px">
							<option value="">全部</option>
							<option value="文学院">文学院</option>
							<option value="新闻与传播学院">新闻与传播学院</option>
							<option value="历史文化学院">历史文化学院</option>
							<option value="经济学院">经济学院</option>
							<option value="管理学院">管理学院</option>
							<option value="哲学社会学院">哲学社会学院</option>
							<option value="外国语学院">外国语学院</option>
							<option value="法学院">法学院</option>
							<option value="政治与行政学院">政治与行政学院</option>
							<option value="艺术学院">艺术学院</option>
							<option value="教育学院">教育学院</option>
							<option value="数学与统计学院">数学与统计学院</option>
							<option value="信息科学与工程学院">信息科学与工程学院</option>
							<option value="物理科学与技术学院">物理科学与技术学院</option>
							<option value="土木工程与力学学院">土木工程与力学学院</option>
							<option value="核科学与技术学院">核科学与技术学院</option>
							<option value="化学化工学院">化学化工学院</option>
							<option value="生命科学学院">生命科学学院</option>
							<option value="资源环境学院">资源环境学院</option>
							<option value="大气科学学院">大气科学学院</option>
							<option value="草地农业科技学院">草地农业科技学院</option>
							<option value="基础医学院">基础医学院</option>
							<option value="公共卫生学院">公共卫生学院</option>
							<option value="口腔医学院">口腔医学院</option>
							<option value="药学院">药学院</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>年份:</td>
					<td><input class="easyui-textbox" type="text" id="ExYear" name="year" style="width: 200px; height: 32px"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="excel-button">
		<a href="javascript:void(0)" id="exportExcel" class="easyui-linkbutton" >导出成绩单</a>
		<a href="javascript:void(0)" id="downPdf" class="easyui-linkbutton" onclick="">导出名单</a>
	</div>

	<div id="importInfo" class="easyui-dialog" closed="true"
		buttons="#import-excel-button" title="导入成绩" style="width: 400px; height: 220px;">
		<form id="importInfoForm" method="post" enctype="multipart/form-data" style="margin:0;padding:10px 40px">
			<table cellpadding="5">
				<tr>
					<td>年份:</td>
					<td><input class="easyui-textbox" type="text"  name="year" style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>成绩表:</td>
					<td><input class="easyui-filebox" type="text" name="file"  style="width: 200px; height: 32px"></input></td>
				</tr>
				<tr>
					<td>样表:</td>
					<td><a href="exampleTeacherAndAcademyExcel.do">下载</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="import-excel-button">
		<a href="javascript:void(0)" id="importExcel" class="easyui-linkbutton" onclick="importExcel();"> 导入成绩单</a>
	</div>
	<script type="text/javascript" src="easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
			var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
		
		$("#pic").click(function(){
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				searchCustomPic(row.id);
			} else {
				$.messager.alert('提示', "请选中要修改的客户信息", 'info');
			}
		})
		/*导出数据*/
		$("#export_btn").click(function(){
			$('#exportInfoForm').form('clear');
			$('#exportInfo').dialog('open').dialog('center');
		})
		/*导入数据*/
		$("#import_btn").click(function(){
			$('#importInfoForm').form('clear');
			$('#importInfo').dialog('open').dialog('center');
		})
		
		$("#exportExcel").click(function(){
			var id = $("#ExId").val();
			var name = $("#ExName").val();
			var school = $("#ExSchool").combobox("getValue");
			var teacher = $("#Exteacher").val();
			var year = $("#ExYear").val();
			location.href = "downTeacherFreshmanExcel.do?id=" + id
			+ "&name=" + name + "&school=" + school+"&teacher=" + teacher+"&year=" + year + "&subjectname=" + '${teacherSubject}'; 
			$('#exportInfo').dialog('close');
		})
		
		$("#downPdf").click(function(){
			var id = $("#ExId").val();
			var name = $("#ExName").val();
			var school = $("#ExSchool").combobox("getValue");
			var teacher = $("#Exteacher").val();
			var year = $("#ExYear").val();
			location.href = "downTeacherFreshmanPDF.do?id=" + id
			+ "&name=" + name + "&school=" + school+"&teacher=" + teacher+"&year=" + year + "&subjectname=" + '${teacherSubject}'; 
			$('#exportInfo').dialog('close');
		})
		/*筛选数据结束  */
		
		$("#addCustomInfo").click(function() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
// 				$('#editInfoForm').form('clear');
				$('#addInfo').dialog('open').dialog('center').dialog('setTitle','新增');
				$('#editInfoForm').form('load',row);
			} else {
				$.messager.alert('提示', "请选中要增加成绩的学生", 'info');
			}
		})

		$("#editCustomInfo").click(function() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
// 				$('#editInfoForm').form('clear');
				$('#addInfo').dialog('open').dialog('center').dialog('setTitle','修改');
				$('#editInfoForm').form('load',row);
			} else {
				$.messager.alert('提示', "请选中要修改成绩的学生", 'info');
			}
		})

		/*模糊查询*/
		$("#search_btn").click(function() {
			loadCustomInfo();
		})

		function loadCustomInfo() {
			var name = $("#name").val();
			var id = $("#id").val();
			var school = $("#school").combobox("getValue");
			var teacher = $("#teacher").val();
			var year = $("#year").val();
			$('#dg').datagrid('load', {
				name : name,
				id : id,
				school : school,
				teacher : teacher,
				year : year
			});
		}

		function save() {
			$('#editInfoForm').form({
				url : 'updateTeacherAndAcademy.do',
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					var obj = eval("(" + data + ")");
					$('#addInfo').dialog('close');
					$.messager.alert('提示', obj.content);
					$('#dg').datagrid('reload');
				}
			});
			$('#editInfoForm').submit();
		}

		function searchCustomPic(id) {
			$('#CustomPicDialog').dialog('open');
			$.get('findCustomPicById.do',{id:id},function(data){
				$("#doorPic").attr("src",data.doorPic);
				$("#roomPic").attr("src",data.roomPic);
			})
		}
		
		function importExcel(){
			$('#importInfoForm').form({
				url : 'uploadTeachersAndAcademyExcel.do',
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(data) {
					var obj = eval("(" + data + ")");
					$('#importInfo').dialog('close');
					$.messager.alert('提示', obj.content);
					$('#dg').datagrid('reload');
				}
			});
			$('#importInfoForm').submit();
		}
	</script>
	</body>
</html>
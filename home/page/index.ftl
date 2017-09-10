<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style mce_bogus="1" type="text/css">  
			@page{size:297mm 210mm;}
			body {font-family: SimHei; background:none;margin-left: auto;margin-right: auto;}  
			body,html,div,p{ font-size:14px; margin:0px; padding:0px;}  
		</style>  
	</head>
	<body>
		<div id="table" >
			<table width="1020" border="1px" cellpadding="0" cellspacing="0" style="text-align: center;table-layout:fixed; word-break: break-all;">
			  <tr>
			  	<th width="85px">学号</th>
			  	<th width="60px">姓名</th>
			  	<th width="35px">性别</th>
			  	<th width="80px">院系</th>
			  	<th width="45px">年级</th>
				<th width="45px">年份</th>
			  	<th>身高</th>
			  	<th>体重</th>
			  	<th>肺活量</th>
			  	<th>50m</th>
			  	<th>立定跳远</th>
			  	<th>坐位体<br />前屈</th>
			  	<th>800m</th>
			  	<th>1000m</th>
			  	<th>仰卧起坐</th>
			  	<th>引体向上</th>
			  	<th width="50px">备注</th>
			  </tr>
			  <#list list as item>
				<tr height="30px">
			  	<td>${item.id}</td>
			  	<td>${item.name}</td>
			  	<td>${item.gender}</td>
			  	<td>${item.school}</td>
			  	<td>${item.grade?c}</td>
				<td>${item.year?c}</td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td></td>
			  	<td>${item.state}</td>
			  </tr>
			  </#list>
			  
			</table>
		</div>
		
	</body>
</html>
<%@page pageEncoding="UTF-8" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title>系统管理</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/datagrid-detailview.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.form.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/app/wo.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/app/main.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/app/demo.js"></script>
	<script type="text/javascript">
		var url;
		function newRole(){
			$('#dlg-Role').dialog('open').dialog('setTitle','创建用户');
			$('#fm-Role').form('clear');
			url = '<%=basePath%>sys/role/create';
		}
		function editRole(){
			var row = $('#dg-Role').datagrid('getSelected');
			if (row){
				$('#dlg-Role').dialog('open').dialog('setTitle','Edit Role');
				$('#fm-Role').form('load',row);
				url = '<%=basePath%>sys/role/update';
			}
		}
		function saveRole(){
			$('#fm-Role').form('submit', {
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success == false){
						$.messager.show({
							title: 'Error',
							msg: result.message
						});
					} else {
						$('#dlg-Role').dialog('close');		// close the dialog
						$('#dg-Role').datagrid('reload');	// reload the Role data
					}
				}
			});
		}
		function destroyRole(){
			var row = $('#dg-Role').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','Are you sure you want to destroy this Role?',function(r){
					if (r){
						$.post('<%=basePath%>sys/role/delete',{id:row.id},function(result){
							if (result.success){
								$('#dg-Role').datagrid('reload');	// reload the Role data
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.message
								});
							}
						},'json');
					}
				});
			}
		}
	</script>
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
		.fitem input{
			width:160px;
		}
	</style>
</head>
<body>
	<table id="dg-Role" title="角色" class="easyui-datagrid" style="width:700px;height:250px"
			url="<%=basePath%>sys/role/list" toolbar="#toolbar-Role"
			pagination="true" rownumbers="true" fitColumns="true" singleSelect="true" idProperty="id">
		<thead>
			<tr>
				<th field="id" width="50">ID</th>
				<th field="description" width="50">描述</th>
				<th field="name" width="50">名字</th>
				<th field="type" width="50">类型</th>
				
			</tr>
		</thead>
	</table>
	<div id="toolbar-Role">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRole()">创建</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRole()">修改</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyRole()">删除</a>
	</div>
	<div id="dlg-Role" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons-Role">
		<div class="ftitle">Role Information</div>
		<form id="fm-Role" method="post" novalidate>
			<div class="fitem">
				<label>ID:</label>
				<input name="id" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>描述:</label>
				<input name="description" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>名字:</label>
				<input name="name" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>类型:</label>
				<input name="type" class="easyui-textbox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons-Role">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRole()" style="width:90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg-Role').dialog('close')" style="width:90px">取消</a>
	</div>
</body>
</html>
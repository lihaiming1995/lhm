<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<script type="text/javascript">
		var basePath = "../";
	</script>
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
<title>部门</title>
</head>
<body>
	<table id="dept" title="my dept" class="easyui-datagrid"
		style="width: 400px; height: 250px" url="<%=basePath%>sys/dept/list"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">id</th>
				<th field="deptName" width="50">部门</th>
				<th field="leader" width="50">负责人</th>

			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newDept()">新部门</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editDept()">编辑</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyDept()">删除</a>
	</div>
	<!-- 
		表单弹窗(dialog)	
	 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">部门信息</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>id:</label> <input name="id" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>部门:</label> <input name="deptName" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>负责人:</label> <input name="leader">
			</div>

		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
	<script type="text/javascript">
	var url;
	function newDept(){
		
		$('#dlg').dialog('open').dialog('setTitle','新部门');
		$('#fm-dept').form('clear');
		url ='<%=basePath%>/sys/dept/create';
		}
		function editDept() {
			var row = $('#dept').datagrid('getSelect');
			if (row) {

				$('#dlg').dialog('open').dialog("setTitle", "编辑用户");
				$('#fm').f
			}

		}
		function destroyDept(){
			var row=$('#dept').datagrid('getSelect');
			if(row){
				$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
					if (r){
						$.post('<%=basePath%>sys/dept/delete',{id:row.id},function(result){
							if (result.success){
								$('#dg-user').datagrid('reload');	// reload the user data
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
		function saveDept() {
			$('#fm-dept').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.success == false) {
						$.messager.show({
							title : 'Error',
							msg : result.message
						});
					} else {
						$('#dlg-dept').dialog('close'); // close the dialog
						$('#dg-dept').datagrid('reload'); // reload the user data
					}
				}

			})

		}
	</script>
	<style type="text/css">
<
style type ="text /css">#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
</body>
</html>
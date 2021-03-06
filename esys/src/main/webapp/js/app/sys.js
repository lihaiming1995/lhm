var Sys = {};
Sys.MenuGrid = function(options) {
	var tableId = 'woTable_' + options.woNodeId;
	// 在tabs上增加一个tabpanel
	$('#' + options.woTabId).tabs('add', {
		title : options.woNodeText,
		content : '<table id="' + tableId + '"></table>',
		closable : true
	});
	$('#' + tableId).wogrid({
		// table id
		woId : tableId,
		// 标题
		woTitle : options.woNodeText,
		// 类型：Tree,Standard,RowDetail
		woGridType : 'Tree',
		woDeleteUrl : 'sys/menu/delete',
		woCreateUrl : 'sys/menu/create',
		woUpdateUrl : 'sys/menu/update',
		// 上级ID字段
		parentField : 'parentId',
		// http://www.jeasyui.com/documentation/index.php# treegrid
		url : 'sys/menu/list',
		idField : 'id',
		treeField : 'name',
		textField : 'name',
		// pagination : true,
		singleSelect : true,
		columns : [ [ {
			field : 'id',
			title : 'ID',
			width : 50,
			hidden : true,
			// 该字段会在修改表单中出现
			woUpdate : {
				readonly : true
			}
		}, {
			field : 'name',
			title : '名称',
			width : 150,
			// 该字段会在创建表单中出现
			woCreate : {},
			// 该字段会在修改表单中出现
			woUpdate : {}
		}, {
			field : 'no',
			title : '编号',
			width : 50,
			hidden : true
		}, {
			field : 'icon',
			title : '图标',
			width : 50,
			woCreate : {},
			woUpdate : {}
		}, {
			field : 'resource',
			title : '资源',
			width : 150,
			woCreate : {},
			woUpdate : {}
		}, {
			field : 'resourceType',
			title : '资源类型',
			width : 150,
			woCreate : {},
			woUpdate : {}
		}, {
			field : 'parentId',
			title : '上级ID',
			width : 50,
			hidden : true,
			woCreate : {},
			woUpdate : {}
		}, {
			field : 'parentName',
			title : '上级名称',
			width : 100
		} ] ],
		// 创建表单字段和按钮配置
		woCreateForm : {
			// 字段
			woFields : [ {
				woType : 'combotree',
				woName : 'parentId',
				label : '上级',
				idField : 'id',
				textField : 'name',
				treeField : 'name',
				parentField : 'parentId',
				width : 200,
				panelWidth : 300,
				url : 'sys/menu/getChildren',
				woColSpan : 1,
				columns : [ [ {
					field : 'id',
					title : 'ID',
					width : 50
				}, {
					field : 'name',
					title : '名称',
					width : 100
				}, {
					field : 'parentId',
					title : '上级ID',
					width : 50
				} ] ]
			} ],
			// 按钮配置
			woButtons : [ {
				woButtonType : 'woSave'
			}, {
				woButtonType : 'woCancel'
			} ]
		},
		woUpdateForm : {
			woFields : [ {
				woType : 'combotree',
				woName : 'parentId',
				label : '上级',
				idField : 'id',
				textField : 'name',
				treeField : 'name',
				parentField : 'parentId',
				width : 200,
				panelWidth : 300,
				url : 'sys/menu/getChildren',
				woColSpan : 1,
				columns : [ [ {
					field : 'id',
					title : 'ID',
					width : 50
				}, {
					field : 'name',
					title : '名称',
					width : 100
				}, {
					field : 'parentId',
					title : '上级ID',
					width : 50
				} ] ]
			} ],
			woButtons : [ {
				woButtonType : 'woSave'
			}, {
				woButtonType : 'woCancel'
			} ]
		},
		// 列表按钮配置
		toolbar : [ {
			woButtonType : 'woCreate'
		}, {
			woButtonType : 'woEdit'
		}, {
			woButtonType : 'woDelete'
		}, {
			woButtonType : 'woClear'
		} ]
	});
};
//1.数据字典crud
Sys.DictionaryGrid = function(options) {
	var tableId = 'woTable_' + options.woNodeId;
	// 在tabs上增加一个tabpanel
	$('#' + options.woTabId).tabs('add', {
		title : options.woNodeText,
		content : '<table id="' + tableId + '"></table>',
		closable : true
	});
	$('#' + tableId).wogrid({
		// table id
		woId : tableId,
		// 标题
		woTitle : options.woNodeText,
		woGridType:'Standard',
		url:'sys/dictionary/list',
			woDeleteUrl : 'sys/menu/delete',
			woCreateUrl : 'sys/menu/create',
			woUpdateUrl : 'sys/menu/update',
			idField:'id',
			//配置列
			columns: [[
				{
					field : 'id',
					title : 'ID',
					width : 50,
					woUpdate:{
						readonly:true
					}
				},{
					field : 'val',
					title : '值',
					width : 50,
					//
					woCreate:{},
					woUpdate:{}
				},{
					field : 'name',
					title : '名称',
					width : 50,
					//
					woCreate:{},
					woUpdate:{}
				},{
					field : 'dicType',
					title : '类型',
					width : 50,
					//
					woCreate:{},
					woUpdate:{}
				},{
					field : 'description',
					title : '描述',
					width : 50,
					//
					woCreate:{},
					woUpdate:{}
				}
			]],
	//配置表单
	woCreateForm:{
		woButtons:[
			{woButtonType:'woSave'},
			{wobuttonType:'woCancel'}
			
		]
	},
	toolbar:[
		{woButtonType:'woCreate'},//创建
		{woButtonType:'woEdit'},//修改
		{woButtonType:'woDelete'},//删除
		{woButtonType:'woClear'},//清除
	]
	});
};

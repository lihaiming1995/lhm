<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——修改员工</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	//返回ajax对象
	function getAJAX() {
		var ajax = null;
		try {
			ajax = new ActiveXObject('microsoft.xmlhttp');
		} catch (e) {

			try {
				ajax = new XMLHttpRequest();
			} catch (e) {
				alert('换浏览器把...你out了...')
			}

		}
		return ajax;
	}
	
	//初始化的是我们的那个Jobs
	function initJobs(){
		//获取ajax
     	var ajax=getAJAX();
     	//准备发送请求
     	ajax.open("GET","${pageContext.request.contextPath}/EmployeeControll?method=getJobs");
     	//发送ajax请求
     	ajax.send(null);
     	ajax.onreadystatechange=function(){
     		//判断ajax返回的状态
     		if(ajax.readyState==4){  //说明服务器响应了...
     			if(ajax.status==200){ //说明服务器的响应是成功的...
     				//获取服务器返回的数据
     				var val=ajax.responseText;
     				//将string类型的数据转换成json对象
     				var jsonArray=eval("("+val+")");
     				
     				//获取操作job的这个容器
     				
     			    var jobSelects=document.getElementById('job_id');
     				//遍历jsonArray
     				for (var i=0;i<jsonArray.length;i++) {
     					var val1=jsonArray[i];
     					//下面是不是就要获取我们的select的这个容器
     					//向里面添加数据
    					var optionChild=document.createElement('option');
    					//向optionChild中写入数据
    					optionChild.value=val1.jId;
    					//向里面写数据
    					optionChild.innerText=val1.jName;
    					//添加进去Child
    					jobSelects.appendChild(optionChild);
     				}
     			}
     		}
     	}
	}
	//初始化部门
	function initDepts(){
	 	//获取ajax
    	var ajax=getAJAX();
    	//准备发送请求
    	ajax.open("GET","${pageContext.request.contextPath}/EmployeeControll?method=getDepts");
    	//发送ajax请求
    	ajax.send(null);
    	ajax.onreadystatechange=function(){
    		//判断ajax返回的状态
    		if(ajax.readyState==4){  //说明服务器响应了...
    			if(ajax.status==200){ //说明服务器的响应是成功的...
    				//获取服务器返回的数据
    				var val=ajax.responseText;
    				//将string类型的数据转换成json对象
    				var jsonArray=eval("("+val+")");
    				//找到select的容器对象
    				var deptSelects=document.getElementById('dept_id');
    				//遍历jsonArray
    				for (var i=0;i<jsonArray.length;i++) {
    					var val1=jsonArray[i];
    					//下面找到容器对象
    					//下面创建option对象
    					var optionChild=document.createElement('option');
    					//向value写入数据
    					optionChild.value=val1.dId;
    					optionChild.innerText=val1.dName;
    					//将生成的对象放到容器中
    					deptSelects.appendChild(optionChild);
    				}
    			}
    		}
    	}
	}
	
	 window.onload=function(){
     	initJobs();
     	initDepts();
     }
	
		
	
	
	 $(function(){
		// 控制文档加载完成以后 选中性别 
		$("#eGender").val("${employee.eGender}");
	  /*   $("#job_id").val("${employee.job.id}");  */
		
    	/** 员工表单提交 */
		$("#employeeForm").submit(function(){
		/* 	alert(1);
			var name = $("#name");
			var cardId = $("#cardId");
			var education = $("#education");
			var email = $("#email");
			var phone = $("#phone");
			var tel = $("#tel");
			var party = $("#party");
			var qqNum = $("#qqNum");
			var address = $("#address");
			var postCode = $("#postCode");
			var birthday = $("#birthday");
			var race = $("#race");
			var speciality = $("#speciality");
			var hobby = $("#hobby");
			var msg = "";
			if ($.trim(name.val()) == ""){
				msg = "姓名不能为空！";
				name.focus();
			}else if ($.trim(cardId.val()) == ""){
				msg = "身份证号码不能为空！";
				cardId.focus();
			}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(cardId.val()))){
				msg = "身份证号码格式不正确！";
				cardId.focus();
			}else if ($.trim(education.val()) == ""){
				msg = "学历不能为空！";
				education.focus();
			}else if ($.trim(email.val()) == ""){
				msg = "邮箱不能为空！";
				email.focus();
			}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(email.val()))){
				msg = "邮箱格式不正确！";
				email.focus();
			}else if ($.trim(phone.val()) == ""){
				msg = "手机号码不能为空！";
				phone.focus();
			}else if (!/^1[3|5|8]\d{9}$/.test($.trim(phone.val()))){
				msg = "手机号码格式不正确！";
				phone.focus();
			}else if ($.trim(tel.val()) == ""){
				msg = "电话号码不能为空！";
				tel.focus();
			}else if (!/^0\d{2,3}-?\d{7,8}$/.test($.trim(tel.val()))){
				msg = "电话号码格式不正确！";
				tel.focus();
			}else if ($.trim(party.val()) == ""){
				msg = "政治面貌不能为空！";
				party.focus();
			}else if ($.trim(qqNum.val()) == ""){
				msg = "QQ号码不能为空！";
				qqNum.focus();
			}else if (!/^\d{6,}$/.test($.trim(qqNum.val()))){
				msg = "QQ号码格式不正确！";
				qqNum.focus();
			}else if ($.trim(address.val()) == ""){
				msg = "地址不能为空！";
				address.focus();
			}else if ($.trim(postCode.val()) == ""){
				msg = "邮政编码不能为空！";
				postCode.focus();
			}else if (!/^[1-9]\d{5}$/.test($.trim(postCode.val()))){
				msg = "邮政编码格式不正确！";
				postCode.focus();
			}else if ($.trim(birthday.val()) == ""){
				msg = "出生日期不能为空！";
				birthday.focus();
			}else if (!birthday.val()){
					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
				msg = "出生日期格式不正确！";
				birthday.focus();
			}else if ($.trim(race.val()) == ""){
				msg = "民族不能为空！";
				race.focus();
			}else if ($.trim(speciality.val()) == ""){
				msg = "专业不能为空！";
				speciality.focus();
			}else if ($.trim(hobby.val()) == ""){
				msg = "爱好不能为空！";
				hobby.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			} */
			$("#employeeForm").submit();
		});
    });
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 修改员工</td>
	<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${pageContext.request.contextPath}/EmployeeControll" id="employeeForm" method="post">
			
			<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="method" value="updated">
    	 	<input type="hidden" name="flag" value="2">
			<input type="hidden" name="eId" value="${employee.eId }">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="eName" id="eName" size="20" value="${employee.eName }"/></td>
		    			<td class="font3 fftd">身份证号码：<input type="text" name="eIdCard" id="eIdCard" size="20" value="${employee.eIdCard}"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">性别：
								<select id="sex" name="sex" style="width:143px;">
									<option value="0">--请选择性别--</option>
									<option value="1">男</option>
									<option value="2">女</option>
					    		</select>
					    </td>
		    			<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 	<select id="job_id" name="jId" style="width:143px;">
					    			<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobs}" var="job">
					    				<%-- <option value="${job.jId }">${job.JName }</option> --%>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">学历：<input name="eStu" id="eStu" size="20" value="${employee.eStu }"/></td>
		    			<td class="font3 fftd">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="eEmail" id="eEmail" size="20" value="${employee.eEmail }"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">手机：<input name="eTelNum" id="eTelNum" size="20" value="${employee.eTelNum}"/></td>
		    			<td class="font3 fftd">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input name="eTelNum" id="eTelNum" size="20" value="${employee.eTelNum }"/></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
				<%-- 	政治面貌：<input name="party" id="party" size="40" value="${employee.party }"/>&nbsp;&nbsp; --%>
					QQ&nbsp;&nbsp;号码：<input name="eQQNum" id="eQQNum" size="20" value="${employee.eQQNum }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="eAddress" id="eAddress" size="40" value="${employee.eAddress }"/>&nbsp;&nbsp;
					邮政编码：<input name="ePostCode" id="ePostCode" size="20" value="${employee.ePostCode }"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					出生日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="birthday" id="birthday" size="40"/>&nbsp;&nbsp;
					<%-- 民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="race" id="race" size="20" value="${employee.race }"/> --%>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
				<%-- 	所学专业：<input  name="speciality" id="speciality" size="40" value="${employee.speciality }"/>&nbsp;&nbsp; --%>
					<%-- 爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="hobby" id="hobby" size="20" value="${employee.hobby }"/> --%>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="eDes" id="eDes" size="40" value="${employee.eDes}"/>
					&nbsp;&nbsp;所属部门：
					<select id="dept_id" name="dId" style="width:100px;">
						   <option value="0">--部门选择--</option>
						   <c:forEach items="${requestScope.depts}" var="dept">
						   		<c:choose>
			    					<c:when test="${employee.dept.dId == dept.dId }">
			    						<%-- <option value="${dept.id }" selected="selected">${dept.dName }</option> --%>
			    					</c:when>
			    					<c:otherwise>
			    						<%-- <option value="${dept.id }">${dept.dName }</option> --%>
			    					</c:otherwise>
			    				</c:choose>
			    			</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>
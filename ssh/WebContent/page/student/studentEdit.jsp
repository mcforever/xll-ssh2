<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<title>编辑学生信息</title>
<script language="javascript" src="ui/js/Calendar1.js"></script>
<script type="text/javascript">
function goBack(){
//	var url = "queryStudentPageAction.html";
//	document.form1.action = url;
//	document.form1.submit();
//	var studentID = document.getElementById("studentid").value;

	var url = "queryStudentPageAction.html";
	document.location.href = url;

}
function goSave(){
	
	var studentName = document.getElementById("studentName");
	var orientation = document.getElementById("orientation");
	var sex = document.getElementById("sex");
	var telephone = document.getElementById("telephone");
	var birthday = document.getElementById("birthday");
	var enrollDate = document.getElementById("enrollDate");
	var schooling = document.getElementById("schooling");
	var studyState = document.getElementById("studyState");
	var classesid = document.getElementById("classesid");
	var deptid = document.getElementById("deptid");

	if(studentName.value == null || studentName.value == ""){
		alert("学生姓名不能为空");
		studentName.focus();
		return false;
	}
	if(orientation.value == null){
		alert("政治面貌不能为空");
		orientation.focus();
		return false;
	}
	if(sex.value == null){
		alert("学生性别不能为空");
		sex.focus();
		return false;
	}
	if(telephone.value == null || telephone.value == ""){
		alert("联系电话不能为空");
		telephone.focus();
		return false;
	}
	if(birthday.value == null || birthday.value == ""){
		alert("出生日期不能为空");
		birthday.focus();
		return false;
	}
	if(enrollDate.value == null || enrollDate.value == ""){
		alert("入学时间不能为空");
		enrollDate.focus();
		return false;
	}
	if(schooling.value == null || schooling.value == ""){
		alert("学制不能为空");
		schooling.focus();
		return false;
	}
	if(studyState.value == null){
		alert("学习状态不能为空");
		studyState.focus();
		return false;
	}
	if(classesid.value == null){
		alert("所在班级不能为空");
		classesName.focus();
		return false;
	}
	if(deptid.value == null){
		alert("所在学院不能为空");
		deptid.focus();
		return false;
	}
	if(!isPhone(telephone.value)){
		alert("联系电话格式不对");
		telephone.focus();
		return false;
	}
	if(confirm("是否保存？")){	
		
		var url = "saveStudentAction.html";
		document.form1.action = url;
		document.form1.submit();
	}

	
}

//是否是电话号码
function isPhone(strPhone){
   	//是否为手机号 ,如不是,返回false
   	var s =strPhone; 
		var reg0 = /^13\d{5,9}$/;
		var reg1 = /^153\d{4,8}$/;
		var reg2 = /^159\d{4,8}$/;
		var reg3 = /^0\d{10,11}$/;
		var reg4 = /^15\d{5,9}$/;
		var reg5 = /^18\d{5,9}$/;
		var my = false;
	
		if (reg0.test(s))my=true;
		if (reg1.test(s))my=true;
		if (reg2.test(s))my=true;
		if (reg3.test(s))my=true;
		if (reg4.test(s))my=true;
		if (reg5.test(s))my=true;
		//alert("my="+my);
   	if(s!=""){
   	    if (!my){
   	        return false;
   	    }
   	    if(s.length!=11){
			return false;
   	   	}
   	}
        	
    return true;
}
</script>
</head>
<body>
<form id="form1" name="form1" action="" method="post">
	<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
		border="0">
		<tbody>
			<tr>
				<td noWrap background="images/img/th_bg.gif" height="25">
					<font color="#ffffff"><strong>编辑学生信息</strong></font>
				</td>
			</tr>
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>
							<td align="left"><input type="button" onclick="goSave()" value="保存" name="saveBtn" /></td>
							<td align="right"><input type="button" onclick="goBack()" value="返回" name="cancle" /></td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" cellspacing="1" cellpadding="0" border="0" width="100%" height="100%">
		<tr>
			<td nowrap align="center">学生姓名：<input type="text" name="student.studentName" id="studentName" value="${student.studentName }"/></td>
			<td nowrap align="center">政治面貌：
				<s:select id="orientation" name="student.orientation"
					list="orientationList" theme="simple" listKey="dataID"
					listValue="dataDescription" label="政治面貌：" headerKey=""
					headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
		</tr>
		<tr>
			<td nowrap align="center">学生性别：
				男<input type="radio" name="student.sex" id="sex" value="0"/>
				女<input type="radio" name="student.sex" id="sex" value="1"/></td>
			<td nowrap align="center">联系电话：<input type="text" name="student.telephone" id="telephone" value="${student.telephone }"/></td>
		</tr>
		<tr>
			<td nowrap align="center">出生日期：<input type="text" name="student.birthday" id="birthday" 
				value="<s:date name='student.birthday' format='yyyy-MM-dd' />" readonly="readonly" />
				<img src="images/img/calendar.gif" width="18" height="18" align="absmiddle"
					onclick="setday(this,document.getElementById('birthday'))" style="cursor: hand" /></td>
			<td nowrap align="center">入学时间：<input type="text" name="student.enrollDate" id="enrollDate" 
				value="<s:date name='student.enrollDate' format='yyyy-MM-dd' />" readonly="readonly" />
				<img src="images/img/calendar.gif" width="18" height="18" align="absmiddle"
					onclick="setday(this,document.getElementById('enrollDate'))" style="cursor: hand" /></td>
		</tr>
		<tr>
			<td nowrap align="center">学制(年)：<input type="text" name="student.schooling" id="schooling" value="${student.schooling }"/></td>
			<td nowrap align="center">学习状态：
				<s:select id="studyState" name="student.studyState"
					list="studyStateList" theme="simple" listKey="dataID"
					listValue="dataDescription" label="学习状态：" headerKey=""
					headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
		</tr>
		<tr>
			<td nowrap align="center">所在班级：
				<s:select id="classesid" name="student.classes.id"
					list="classesList" theme="simple" listKey="id"
					listValue="classesName" label="所在班级：" headerKey=""
					headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
			<td nowrap align="center">所在学院：
				<s:select id="deptid" name="student.dept.id"
					list="deptList" theme="simple" listKey="id"
					listValue="deptName" label="所在学院：" headerKey=""
					headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
		</tr>
	</table>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<title>编辑班级信息</title>

<script language="javascript" src="ui/js/Calendar1.js"></script>
<script type="text/javascript">
function goBack(){
	var url = "queryClassesPageAction.html";
	document.location.href = url;

}
function goSave(){
	if(confirm("是否保存？")){
		var classesName = document.getElementById("classesName");
		var createDate = document.getElementById("createDate");
		var teacherid = document.getElementById("teacherid");

		if(classesName.value.trim() == null || classesName.value.trim() == ""){
			alert("班级名称不能为空");
			classesName.focus();
			return false;
		}
		if(createDate.value.trim() == null || createDate.value.trim() == ""){
			alert("班级成立时间不能为空");
			createDate.focus();
			return false;
		}
		if(teacherid.value.trim() == null || teacherid.value.trim() == ""){
			alert("班级导员时间不能为空");
			teacherid.focus();
			return false;
		}
		var url = "saveClassesAction.html";
		document.form1.action = url;
		document.form1.submit();
	}
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
					<font color="#ffffff"><strong>编辑班级信息</strong></font>
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
			<td nowrap align="center">班级名称：<input type="text" name="classes.classesName" id="classesName" value="${classes.classesName }"/></td>
		</tr>
		<tr>
			<td nowrap align="center">成立时间：<input type="text" name="classes.createDate" id="createDate" 
				value="<s:date name='classes.createDate' format='yyyy-MM-dd' />" readonly="readonly" />
				<img src="images/img/calendar.gif" width="18" height="18" align="absmiddle"
					onclick="setday(this,document.getElementById('createDate'))" style="cursor: hand" /></td>
			
		</tr>
		<tr>
			<td nowrap align="center">班级导员：
				<s:select id="teacherid" name="classes.teacher.id"
						list="teacherList" theme="simple" listKey="id"
						listValue="teacherName" label="班级导员：" headerKey=""
						headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
		</tr>
	</table>
</form>

</body>
</html>
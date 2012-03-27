<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<title>查看学生详细信息</title>
<script type="text/javascript">
function goBack(){
	var studentID = document.getElementById("studentid");
	var url = "queryStudentPageAction.html?queryStudent.id=" + studentID.value;
	document.location.href = url;

}
</script>
</head>
<body>
<form id="form1" name="form1" action="" method="post">
	<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
		border="0">
		<tbody>
			<tr>
				<td noWrap background="images/img/th_bg.gif" height="25"><font
					color="#ffffff"><strong>学生信息查看：查看学生详细信息</strong></font></td>
			</tr>
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr align="right">
							<td><input type="button" onclick="goBack()" value="返回" name="cancle" /></td>
	
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" cellspacing="1" cellpadding="0" border="0" width="100%" height="100%">
		<tr>
			<td nowrap align="center">学生编号：<input type="text" name="student.id" id="studentid" value="${student.id }" readonly="readonly" /></td>
			<td nowrap align="center">学生姓名：<input type="text" name="student.studentName" id="studentName" value="${student.studentName }" readonly="readonly"/></td>
		</tr>
		<tr>
			<td nowrap align="center">学生性别：<input type="text" name="student.sex" id="sex" value="${student.sexStr }" readonly="readonly" /></td>
			<td nowrap align="center">联系电话：<input type="text" name="student.telephone" id="telephone" value="${student.telephone }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">出生日期：<input type="text" name="student.birthday" id="birthday" value="${student.birthdayStr }" readonly="readonly" /></td>
			<td nowrap align="center">入学时间：<input type="text" name="student.enrollDate" id="enrollDate" value="${student.enrollDateStr }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">学制(年)：<input type="text" name="student.schooling" id="schooling" value="${student.schooling }" readonly="readonly"/></td>
			<td nowrap align="center">学习状态：<input type="text" name="student.studyState" id="studyState" value="${student.studyStateStr }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">所在班级：<input type="text" name="student.classes.classesName" id="classesName" value="${student.classes.classesName }" readonly="readonly" /></td>
			<td nowrap align="center">所在学院：<input type="text" name="student.dept.deptName" id="deptName" value="${student.dept.deptName }" readonly="readonly" /></td>
		</tr>
	</table>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<link href="ui/css/admin/Admin_css.css" type=text/css rel=stylesheet>
<title>成绩录入</title>
<script type="text/javascript" src="ui/js/Admin.js"></script>

<script type="text/javascript">
function goBack(){
	var url = "queryGradePageAction.html";
	document.form1.action = url;
	document.form1.submit();
}
function saveGrade(){
	var gradeID = document.getElementById("gradeid");
	var url = "saveGradeAction.html?gradeid=" + gradeID.value;
	document.form1.action = url;
	document.form1.submit();
	
}
</script>
</head>
<s:actionmessage />
<body>
<form id="form1" name="form1" action="" method="post">
	<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
		border="0">
		<tbody>
			<tr>
				<td noWrap background="images/img/th_bg.gif" height="25"><font
					color="#ffffff"><strong>成绩管理：录入成绩</strong></font></td>
			</tr>
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr align="right">
							<td>
								<input type="button" onclick="saveGrade()" value="保存" name="cancle" />
								<input type="button" onclick="goBack()" value="返回" name="cancle" />
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</tbody>
	</table>
	<table align="center" cellspacing="1" cellpadding="0" border="0" width="100%" height="100%">
		<tr>
			<td nowrap align="center">学生姓名：
				<input type="text" name="grade.student.studentName" id="studentName" value="${grade.student.studentName }" readonly="readonly" />
				<input type="hidden" name="grade.id" id="gradeid" value="${grade.id }" /></td>
		</tr>
		<tr>
			<td nowrap align="center">课程名称：
			<input type="text" name="grade.course.courseName" id="courseName" value="${grade.course.courseName }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">期中成绩：<input type="text" name="grade.midScore" id="midScore" value="${grade.midScore }" /></td>
		</tr>
		<tr>
			<td nowrap align="center">期末成绩：<input type="text" name="grade.finalScore" id="finalScore" value="${grade.finalScore }" /></td>
		</tr>
	</table>
</form>

</body>
</html>
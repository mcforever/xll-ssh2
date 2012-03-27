<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<title>查看班级详细信息</title>
<script type="text/javascript">
function goBack(){
	var classesID = document.getElementById("classesid").value;
	var url = "queryClassesPageAction.html?classes.id=" + classesID;
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
					color="#ffffff"><strong>班级信息查看：查看班级详细信息</strong></font></td>
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
			<td nowrap align="center">班级编号：<input type="text" name="classes.id" id="classesid" value="${classes.id }" readonly="readonly" /></td>
			<td nowrap align="center">班级名称：<input type="text" name="classes.classesName" id="classesName" value="${classes.classesName }" readonly="readonly"/></td>
		</tr>
		<tr>
			<td nowrap align="center">成立时间：<input type="text" name="classes.createDateStr" id="createDate" value="${classes.createDateStr }" readonly="readonly" /></td>
			<td nowrap align="center">所属导员：<input type="text" name="classes.teacher.teacherName" id="teacherName" value="${classes.teacher.teacherName }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">班级最高分：<input type="text" name="classes.maxScore" id="maxScore" value="${classes.maxScore }" readonly="readonly" /></td>
			<td nowrap align="center">所属最低分：<input type="text" name="classes.minScore" id="minScore" value="${classes.minScore }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td nowrap align="center">班级平均成绩：<input type="text" name="classes.averageScore" id="averageScore" value="${classes.averageScore }" readonly="readonly" /></td>
		</tr>
		
	</table>
</form>

</body>
</html>
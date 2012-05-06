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
<title>查看学生信息</title>
<script type="text/javascript" src="ui/js/Admin.js"></script>
<script type="text/javascript">
function CheckOthers(form){
   for (var i=0;i<form.elements.length;i++){
      var e = form.elements[i];
      if (e.checked==false){
	     e.checked = true;
      }else{
	     e.checked = false;
      }
   }
}

//单击获取行数据
function selectValue(obj){
	document.getElementById("teacherid").value = obj.teacherid;
	document.getElementById("studentid").value = obj.value;
	document.getElementById("studyState").value = obj.studyState;
	
}

//双击显示某条记录的信息
function showDetail(){
	var studentID = document.getElementById("studentid").value;
	var url = "studentDetailAction.html?student.id=" + studentID;
	document.location.href = url;
}



function toedit(form,str){
    var userLevel = document.getElementById("userLevel");
    var studentID = document.getElementById("studentid");
	if(userLevel.value == 0 || userLevel.value == 2){
		alert("您无权限进行此操作");
		return false;
	}
	
	if(str == 'add'){
		var url = "studentEditAction.html?option=" + str;
		document.location.href = url;
	}else if(str == 'edit'){
		if(studentID.value == "" || studentID.value == null){
			alert("请先选择一条要修改的学生记录");
			return false;
		}else{
			var url = "studentEditAction.html?option=" + str + "&student.id=" + studentID.value;
			document.location.href = url;
		}
		
	}else if(str == 'delete'){
		if(studentID.value == "" || studentID.value == null){
			alert("请先选择一条要修改的学生记录");
			return false;
		}else{
			if(confirm("确认删除?")){
				var url = "studentDeleteAction.html?student.id=" + studentID.value;
				document.location.href = url;
			}
		}
	}
	
}

function updatestudyState(state){
	var userLevel = document.getElementById("userLevel");
    var studentID = document.getElementById("studentid");
    var teacherid = document.getElementById("teacherid");
    var userid = document.getElementById("userid");
    var studyState = document.getElementById("studyState");

    if(studentID.value == "" || studentID.value == null){
		alert("请先选择一个学生");
		return false;
    }
	if(userLevel.value == 0 || userLevel.value == 2 || userLevel.value == 3){
		alert("您的身份不是导员，无权限进行此操作");
		return false;
	}
	if(userid.value == teacherid.value){
		if(studyState.value == 0){
			if(state == 0){
				alert("该学生状态已为在读，无法进行此操作");
				return false;
			}

			if(confirm("确认要把该学生的状态修改为在读?")){
				var url = "updateStudyStateAction.html?student.id=" + studentID.value + "&student.studyState=1";
				document.location.href = url;
			}
		}
		if(studyState.value == 1){
			if(state == 1){
				alert("该学生状态已为休学，无法进行此操作");
				return false;
			}

			if(confirm("确认要把该学生的状态修改为在读?")){
				var url = "updateStudyStateAction.html?student.id=" + studentID.value + "&student.studyState=0";
				document.location.href = url;
			}
		}
		
	}else{
		alert("该学生不是您的学生，无权进行此操作");
		return false;
	}
}

function toSubmit(){
	var url = "queryStudentPageAction.html";
	document.formSearch.action = url;
	document.formSearch.submit();
	
}
</script>
</head>
<s:if test="msg != null && msg != ''">
	<s:if test="msg == 1">
		<script type="text/javascript">
			alert("学生信息新增成功！！！");
			document.location.href = "queryStudentPageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 2">
		<script type="text/javascript">
			alert("学生信息更新失败！！！");
			document.location.href = "queryStudentPageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 3">
		<script type="text/javascript">
			alert("学生信息修改成功！！！");
			document.location.href = "queryStudentPageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 5">
		<script type="text/javascript">
			alert("学生信息删除成功！！！");
			document.location.href = "queryStudentPageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 6">
		<script type="text/javascript">
			alert("成绩信息删除失败！！！");
			document.location.href = "queryStudentPageAction.html?msg=null";
		</script>
	</s:if>
</s:if>
<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>学生信息查看：管理学生</strong></font></td>
		</tr>
		<s:form id="formSearch" name="formSearch"
			action="" method="post">
			<input type="hidden" id="userLevel" name="userLevel" value="${sessionLevel }"/>
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>

							<td noWrap align="left">学生姓名：<input class="textfield"
								size="18" name="queryStudent.studentName" id="studentName" value="${queryStudent.studentName }"></td>
							<td>所在班级：<s:select id="classesid" name="queryStudent.classes.id"
								list="classesList" theme="simple" listKey="id"
								listValue="classesName" label="所在班级：" headerKey=""
								headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
							<td>学习状态：<s:select id="studyState" name="queryStudent.studyState"
								list="studyStateList" theme="simple" listKey="dataID"
								listValue="dataDescription" label="学习状态：" headerKey=""
								headerValue="请选择" cssStyle="width:100px;height:20px"></s:select></td>
							<td align="right"><input class="button" type="button"
								value="查询" name="submitSearch" onclick="toSubmit();"></td>

						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			
		</s:form>
	</tbody>
</table>

<table align="center" cellspacing="1" cellpadding="3" border="0"
	bgColor="#6298e1" width="99%" ; height="100%">
	<s:form id="form1" name="form1" action="" method="post">
	<input type="hidden" id="sessionLevel" name="sessionLevel" value="${sessionLevel }"/>
	<input type="hidden" id="userid" name="userid" value="${sessionUser.id }"/>
	<input type="hidden" id="teacherid" name="teacherid"/>
	<input type="hidden" id="studentid" name="studentid"/>
	<input type="hidden" id="studyState" name="studyState"/>
	
		<tr>
			<td noWrap align="left" bgColor="#ebf2f9" height="30">
			<table cellSpacing="0" width="99%" border="0">
				<tbody>
					<tr>
						<td><input type="button" id="button1" name="button1" value="新增" onclick="toedit(this.form,'add');" /></td>
						<td><input type="button" id="button1" name="button1" value="修改" onclick="toedit(this.form,'edit');" /></td>
						<td><input type="button" id="button1" name="button1" value="删除" onclick="toedit(this.form,'delete');" /></td>
						<c:if test="${sessionLevel == 1 }">
						<td><input type="button" id="button1" name="button1" value="休学" onclick="updatestudyState(1);" /></td>
						<td><input type="button" id="button1" name="button1" value="复学" onclick="updatestudyState(0);" /></td>	
						</c:if>
						
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
		<tr>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>学生姓名</strong></font></th>
			<th noWrap align="center" width="7%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>性别</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>出生日期</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>政治面貌</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>入学时间</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>联系电话</strong></font></th>
			<th noWrap align="center" width="8%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>学习状态</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>所在班级</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>所在学院</strong></font></th>
		</tr>
		<s:if test="page.result==null || page.result.size()==0">
	  		<td colspan="5" align="right">没有学生信息</td>
	 	</s:if>
		<s:iterator value="page.result" status="status">
			<tr onmouseover="this.style.backgroundColor = '#FFFFFF'"
				style="CURSOR: hand" onmouseout="this.style.backgroundColor = ''"
				bgColor="#ebf2f9" id="${id }" value="${id }" teacherid="${classes.teacher.id }" studyState="${studyState }"
				onclick="selectValue(this)">

				<td align="center"><a href="studentDetailAction.html?student.id=${id }"><s:property value="studentName" /></a></td>
				<td align="center"><s:property value="sexStr" /></td>
				<td align="center"><s:property value="birthdayStr" /></td>
				<td align="center"><s:property value="orientationStr" /></td>
				<td align="center"><s:property value="enrollDateStr" /></td>
				<td align="center"><s:property value="telephone" /></td>
				<td align="center"><s:property value="studyStateStr" /></td>
				<td align="center"><s:property value="classes.classesName" /></td>
				<td align="center"><s:property value="dept.deptName" /></td>

			</tr>
		</s:iterator>
	</s:form>
</table>

<table cellSpacing="0" width="99%" border="0">
	<tbody>
		<tr>
			<td align="right">当前是第${page.curPage }页,共有${page.pageCount}页，${page.resultCount }条记录<br />
			</td>
		</tr>
		<tr>
			<td align="right"><a
				href="queryStudentPageAction.html?page.curPage=1">第一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:if test="${page.curPage == page.pageCount}">
				<a
					href="queryStudentPageAction.html?page.curPage=${page.curPage - 1}">前一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <c:if test="${page.curPage == 1}">
				<a
					href="queryStudentPageAction.html?page.curPage=${page.curPage + 1}">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <a
				href="queryStudentPageAction.html?page.curPage=${page.pageCount}">最后一页</a>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>
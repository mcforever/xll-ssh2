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
<title>成绩管理</title>
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

//var gradeID;
//单击获取id
//function selectValue(obj){
//	gradeID = obj;
//	var temp = document.getElementById("selectID_" + obj).checked;
//	if(temp==true){
//		document.getElementById("selectID_" + obj).checked = true;
//	}else{
//		document.getElementById("selectID_" + obj).checked = false;
//	}
	
//}

function selectValue(obj){
	var objValue = obj.value;
	document.getElementById("gradeid").value = objValue;
	document.getElementById("teacherid").value = obj.teacherid;
	
}

function toSubmit(){
	var url = "queryGradePageAction.html";
	document.formSearch.action = url;
	document.formSearch.submit();
	
}

function toEnterScore(form){
	var userLevel = document.getElementById("sessionLevel");
	var teacherid = document.getElementById("teacherid");
	var userid = document.getElementById("userid");
	var gradeid = document.getElementById("gradeid")
	
	if(gradeid.value == null || gradeid.value == ""){
		alert("请先选择一条的成绩");
		return false;
	}else {
		if(userLevel.value == 1 || userLevel.value == 0 || userLevel.value == 3){   //只有讲师才能进行录入成绩
			alert("您无权限进行此操作");
			return false;
		}
		
		if(teacherid.value != userid.value){                                        //只有该课程讲师才能录入成绩
			alert("您无权限进行此操作");
			return false;
		}
		var url = "enterScoreAction.html?grade.id=" + gradeid.value;
		document.location.href = url;
	    
	}
}

function toedit(form){
	var userLevel = document.getElementById("sessionLevel");
	var gradeid = document.getElementById("gradeid")
	
	if(gradeid.value == null || gradeid.value == ""){
		alert("请先选择一条的成绩");
		return false;
	}else {
		if(userLevel.value == 3){   //只有讲师才能进行选课给学生录入成绩
			var url = "deleteGradeAction.html?grade.id=" + gradeid.value;
			document.location.href = url;
		}else{
			alert("只有管理员才有此权限");
			return false;
		}
		
		
	    
	}
}


</script>

</head>
<s:if test="msg != null && msg != ''">
	<s:if test="msg == 1">
		<script type="text/javascript">
			alert("成绩录入成功！！！");
			document.location.href = "queryGradePageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 2">
		<script type="text/javascript">
			alert("成绩录入失败！！！");
			document.location.href = "queryGradePageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 3">
		<script type="text/javascript">
			alert("成绩信息删除成功！！！");
			document.location.href = "queryGradePageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 4">
		<script type="text/javascript">
			alert("成绩信息删除失败！！！");
			document.location.href = "queryGradePageAction.html?msg=null";
		</script>
	</s:if>
</s:if>
<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>成绩信息查看：管理成绩</strong></font></td>
		</tr>
		<s:form id="formSearch" name="formSearch"
			action="" method="post">
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>

							<td noWrap align="left">学生姓名：<input class="text"
								size="18" name="studentname" id="studentname"></td>
							<td noWrap align="left">课程名称：<input class="text"
								size="18" name="coursename" id="coursename"></td>
							
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
	<input type="hidden" id="teacherid" name="teacherid" />
	<input type="hidden" id="gradeid" name="gradeid" />
		<tr>
			<td noWrap align="left" bgColor="#ebf2f9" height="30">
			<table cellSpacing="0" width="99%" border="0">
				<tbody>
					<tr>
						<td><input type="button" id="button1" name="button1" value="删除" onclick="toedit(this.form);" /></td>
						<td><input type="button" id="button1" name="button1" value="成绩录入" onclick="toEnterScore(this.form);" /></td>

						
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
		<tr>
<!--			<th noWrap align="center" width="50"-->
<!--				background="images/img/th_bg.gif"><input class="button"-->
<!--				id="submitOtherSelect" style="WIDTH: 30px; HEIGHT: 18px"-->
<!--				onclick="CheckOthers(this.form)" type="button" value="全选"-->
<!--				name="buttonOtherSelect"></th>-->
			<th noWrap align="center" width="7%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>学生姓名</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>课程名称</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>授课教师</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>期中成绩</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>期末成绩</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>最终成绩</strong></font></th>
			
		</tr>
		<s:if test="page.result==null || page.result.size()==0">
	  		<td colspan="5" align="right">没有成绩信息</td>
	 	</s:if>
		<s:iterator value="page.result" status="status">
			<tr onmouseover="this.style.backgroundColor = '#FFFFFF'"
				style="CURSOR: hand" onmouseout="this.style.backgroundColor = ''"
				bgColor="#ebf2f9" id="${id }" value="${id }" teacherid="${course.teacher.id }"
				onclick="selectValue(this)">

<!--				<td noWrap align="center"><input-->
<!--					style="width: 13px; height: 13px" type="checkbox" value="${id }"-->
<!--					name="selectID" id="selectID_${id }"></td>-->
				<td align="center"><s:property value="student.studentName" /></td>
				<td align="center"><s:property value="course.courseName" /></td>
				<td align="center"><s:property value="course.teacher.teacherName" /></td>
				<td align="center"><s:property value="midScore" /></td>
				<td align="center"><s:property value="finalScore" /></td>
				<td align="center"><s:property value="totalScore" /></td>
				
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
				href="queryGradePageAction.html?page.curPage=1">第一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:if test="${page.curPage == page.pageCount}">
				<a
					href="queryGradePageAction.html?page.curPage=${page.curPage - 1}">前一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <c:if test="${page.curPage == 1}">
				<a
					href="queryGradePageAction.html?page.curPage=${page.curPage + 1}">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <a
				href="queryGradePageAction.html?page.curPage=${page.pageCount}">最后一页</a>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>
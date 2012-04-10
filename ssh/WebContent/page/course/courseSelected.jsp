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
<title>学生已选课程</title>
<script type="text/javascript" src="ui/js/Admin.js"></script>
</head>

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

	var courseID;
	 
	//单击获取id
	function selectValue(obj){
		studentID = obj;
		var temp = document.getElementById("selectID_" + obj).checked;
		if(temp==true){
			document.getElementById("selectID_" + obj).checked = true;
		}else{
			document.getElementById("selectID_" + obj).checked = false;
		}
		
	}	

	function goBack(){
		var url = "queryCoursePageAction.html";
		document.location.href = url;

	}
</script>
<s:actionmessage />
<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>管理课程：学生已选课程</strong></font></td>
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

<table align="center" cellspacing="1" cellpadding="3" border="0"
	bgColor="#6298e1" width="99%" ; height="100%">
	<s:form id="form1" name="form1" action="" method="post">
	<input type="hidden" id="sessionLevel" name="sessionLevel" value="${sessionLevel }"/>
		<tr>
<!--			<th noWrap align="center" width="50"-->
<!--				background="images/img/th_bg.gif"><input class="button"-->
<!--				id="submitOtherSelect" style="WIDTH: 30px; HEIGHT: 18px"-->
<!--				onclick="CheckOthers(this.form)" type="button" value="全选"-->
<!--				name="buttonOtherSelect"></th>-->
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>课程编号</strong></font></th>
			<th noWrap align="center" width="7%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>课程名称</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>授课讲师</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>开课时间</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>所占学分</strong></font></th>
		</tr>
		<s:if test="page.result==null || page.result.size()==0">
	  		<td colspan="5" align="right">没有课程信息</td>
	 	</s:if>
		<s:iterator value="page.result" status="status">
			<tr onmouseover="this.style.backgroundColor = '#FFFFFF'"
				style="CURSOR: hand" onmouseout="this.style.backgroundColor = ''"
				bgColor="#ebf2f9" id="${course.id }" value="${course.id }"
				onclick="selectValue('${course.id}')">

<!--				<td noWrap align="center"><input-->
<!--					style="width: 13px; height: 13px" type="checkbox" value="${course.id }"-->
<!--					name="selectID" id="selectID_${course.id }"></td>-->
				<td align="center"><s:property value="course.id" /></td>
				<td align="center"><s:property value="course.courseName" /></td>
				<td align="center"><s:property value="course.teacher.teacherName" /></td>
				<td align="center"><s:property value="course.courseTimeStr" /></td>
				<td align="center"><s:property value="course.credit" /></td>
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
				href="queryCoursePageAction.html?page.curPage=1">第一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:if test="${page.curPage == page.pageCount}">
				<a
					href="queryCoursePageAction.html?page.curPage=${page.curPage - 1}">前一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <c:if test="${page.curPage == 1}">
				<a
					href="queryCoursePageAction.html?page.curPage=${page.curPage + 1}">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <a
				href="queryCoursePageAction.html?page.curPage=${page.pageCount}">最后一页</a>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>
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
<title>课程管理</title>
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

var courseID;
 
//单击获取id
function selectValue(obj){
	courseID = obj.value;
//	var temp = document.getElementById("selectID_" + obj).checked;
//	if(temp==true){
//		document.getElementById("selectID_" + obj).checked = true;
//	}else{
//		document.getElementById("selectID_" + obj).checked = false;
//	}
	
}

//双击显示某条记录的信息
//function showDetail(){
//	var url = "courseDetailAction.html?course.id=" + courseID;
//	document.location.href = url;
//}



function toedit(form,str){
	var userLevel = document.getElementById("sessionLevel");
	if(userLevel.value == 0 || userLevel.value == 2){
		alert("您无权限进行此操作");
		return false;
	}
	
	var courseIDs = new Array();
	var count = 0;
	
	for (var i=0;i<form.elements.length;i++){
      	var e = form.elements[i];
      	if (e.checked==true){
      		count = courseIDs.push(e.value);
      	}
      
    }
	
	if(str == 'add'){
		var url = "courseEditAction.html?option=" + str;
		document.location.href = url;
	}else if(str == 'edit'){
		if(count == 0){
			alert("请先选择一条想要修改的课程记录");
			return false;
		}else if(count == 1){
			for (var i=0;i<form.elements.length;i++){
		      	var e = form.elements[i];
		      	if (e.checked==true){
		      		count = courseIDs.push(e.value);
		      		courseID = e.value;
		      	}
		      
		    }
			var url = "courseEditAction.html?option=" + str + "&course.id=" + courseID;
			document.location.href = url;
		}else{
			alert("请先选择一条要修改的课程记录");
			return false;
		}
		
		
	}else if(str == 'delete'){
		if(count == 0){
			alert("请选择要删除的课程记录");
			return false;
		}else{
			if(confirm("确认删除?")){
				var url = "courseDeleteAction.html?courseids=" + courseIDs;
				document.location.href = url;
			}
		}
		
	}
	
}

function selectCourse(form){
	var userLevel = document.getElementById("sessionLevel");
	if(userLevel.value == 1 || userLevel.value == 2 || userLevel.value == 3){   //只有学生才能进行选课给学生选课
		alert("您无权限进行此操作");
		return false;
	}
	
    
	if(courseID == null || courseID == ""){
		alert("请先选择一条的课程记录");
		return false;
	}else {
//	    if(userLevel == 0){  //学生
//	    	var url = "studentSelectCourseViewAction.html?option=" + str + "&courseid=" + courseID + "&studentid=" + userid;
//		}
//	    if(userLevel == 3){  //管理员
//	    	var url = "studentSelectCourseViewAction.html?option=" + str + "&courseid=" + courseID;
//		}

		if(confirm("确认要选这门课程?")){
			var url = "studentSelectCourseAction.html?course.id=" + courseID;
			document.location.href = url;
		}
	    
	}
	
}

function existCourse(){
	var url = "selectedCourseAction.html";
	document.location.href = url;
}

function toSubmit(){
	var url = "queryCoursePageAction.html?msg=null";
	document.formSearch.action = url;
	document.formSearch.submit();
	
}
</script>
</head>
<s:if test="msg != null && msg != ''">
	<s:if test="msg == 1">
		<script type="text/javascript">
			alert("选课成功！");
			document.location.href = "queryCoursePageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 2">
		<script type="text/javascript">
			alert("选课失败！");
			document.location.href = "queryCoursePageAction.html?msg=null";
		</script>
	</s:if>
	<s:if test="msg == 3">
		<script type="text/javascript">
			alert("该门课程已选，不能重复选择！");
			document.location.href = "queryCoursePageAction.html?msg=null";
		</script>
	</s:if>
</s:if>

<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>课程信息查看：管理课程</strong></font></td>
		</tr>
		<s:form id="formSearch" name="formSearch"
			action="" method="post">
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>

							<td noWrap align="left">课程名称：<input class="textfield"
								size="18" name="coursename" id="coursename"></td>
							<td>授课讲师：<s:select id="teacherid" name="teacherid"
								list="teacherList" theme="simple" listKey="id"
								listValue="teacherName" label="授课讲师：" headerKey=""
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
		<tr>
			<td noWrap align="left" bgColor="#ebf2f9" height="30">
			<table cellSpacing="0" width="99%" border="0">
				<tbody>
					<tr>
<!--						<td><input type="button" id="button1" name="button1" value="新增" onclick="toedit(this.form,'add');" /></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="修改" onclick="toedit(this.form,'edit');" /></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="删除" onclick="toedit(this.form,'delete');" /></td>-->
						<td><input type="button" id="button1" name="button1" value="学生选课" onclick="selectCourse(this.form);" /></td>
						<c:if test="${sessionLevel == 0}">
						<td><input type="button" id="button1" name="button1" value="已选课程" onclick="existCourse();" /></td>
						</c:if>
						
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
				bgColor="#ebf2f9" id="${id }" value="${id }" 
				onclick="selectValue(this)">

<!--				<td noWrap align="center"><input-->
<!--					style="width: 13px; height: 13px" type="checkbox" value="${id }"-->
<!--					name="selectID" id="selectID_${id }"></td>-->
				<td align="center"><s:property value="id" /></td>
				<td align="center"><a href="courseDetailAction.html?course.id=${id }"><s:property value="courseName" /></a></td>
				<td align="center"><s:property value="teacher.teacherName" /></td>
				<td align="center"><s:property value="courseTimeStr" /></td>
				<td align="center"><s:property value="credit" /></td>
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
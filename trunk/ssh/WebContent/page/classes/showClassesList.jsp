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
<title>查看班级信息</title>
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

//单击获取获取行数据
function selectValue(obj){
	document.getElementById("classesid").value = obj.value;
}

//双击显示某条记录的信息
function showDetail(){
	var url = "classesDetailAction.html?classes.id=" + classesID;
	document.location.href = url;
}

function toedit(form,str){
	var userLevel = document.getElementById("userLevel");
	var classesid = document.getElementById("classesid");
	if(userLevel.value == 0 || userLevel.value == 1 || userLevel.value == 2){
		alert("您无权限进行此操作");
		return false;
	}
	
	if(str == 'add'){
		var url = "classesEditAction.html?option=" + str;
		document.location.href = url;
	}else if(str == 'edit'){
		if(classesid.value == null || classesid.value == ""){
			alert("请选择一条想要修改的班级记录");
			return false;
		}else {
			
			var url = "classesEditAction.html?option=" + str + "&classes.id=" + classesid.value;
			document.location.href = url;
		}
		
	}else if(str == 'delete'){
		if(classesid.value == null || classesid.value == ""){
			alert("请选择要删除的班级记录");
			return false;
		}else{
			if(confirm("确认删除?")){
				var url = "classesDeleteAction.html?classes.id=" + classesid.value;
				document.location.href = url;
			}
		}
		
	}
	
}

function toSubmit(){
	var url = "queryClassesPageAction.html";
	document.formSearch.action = url;
	document.formSearch.submit();
	
}
</script>
</head>
<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>班级信息查看：管理班级</strong></font></td>
		</tr>
		<s:form id="formSearch" name="formSearch" action="" method="post">
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>

							<td noWrap align="left">班级名称：<input class="text"
								size="18" name="queryClasses.classesName" id="classesName"></td>
							<td>导员：<s:select id="teacherid" name="queryClasses.teacher.id"
								list="teacherList" theme="simple" listKey="id"
								listValue="teacherName" headerKey=""
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
	<input type="hidden" name="classesid" id="classesid" />
<!--		<tr>-->
<!--			<td noWrap align="left" bgColor="#ebf2f9" height="30">-->
<!--			<table cellSpacing="0" width="99%" border="0">-->
<!--				<tbody>-->
<!--					<tr>-->
<!--						<td><input type="button" id="button1" name="button1" value="新增" onclick="toedit(this.form,'add');" /></td>-->
<!--						<td></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="修改" onclick="toedit(this.form,'edit');" /></td>-->
<!--						<td></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="删除" onclick="toedit(this.form,'delete');" /></td>-->
<!--						-->
<!--					</tr>-->
<!--				</tbody>-->
<!--			</table>-->
<!--			</td>-->
<!--		</tr>-->
		<tr>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>班级编号</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>班级名称</strong></font></th>
			<th noWrap align="center" width="20%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>成立时间</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>班级导员</strong></font></th>
		</tr>
		<s:iterator value="page.result" status="status">
			<tr onmouseover="this.style.backgroundColor = '#FFFFFF'"
				style="CURSOR: hand" onmouseout="this.style.backgroundColor = ''"
				bgColor="#ebf2f9" id="${id }" value="${id }"
				onclick="selectValue(this)">
				<td align="center"><s:property value="id" /></td>
				<td align="center"><a href="classesDetailAction.html?classes.id=${id }"><s:property value="classesName" /></a></td>
				<td align="center"><s:property value="createDateStr" /></td>
				<td align="center"><s:property value="teacher.teacherName" /></td>
			</tr>
		</s:iterator>
		<s:if test="page.result==null || page.result.size()==0">
	  		<td colspan="5" align="right">没有班级信息</td>
	 	</s:if>
	</s:form>
</table>

<table cellSpacing="0" width="99%" border="0">
	<tbody>
		<tr>
			<td align="right">
				当前是第${page.curPage }页&nbsp;&nbsp;&nbsp;&nbsp;共有${page.pageCount}页&nbsp;&nbsp;&nbsp;&nbsp;${page.resultCount }条记录<br /></td>
		</tr>
		<tr>
				<td align="right">
					<a href="queryClassesPageAction.html?page.curPage=1">第一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<c:if test="${page.curPage == page.pageCount}">
					<a href="queryClassesPageAction.html?page.curPage=${page.curPage - 1}">前一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> 
				<c:if test="${page.curPage == 1}">
					<a href="queryClassesPageAction.html?page.curPage=${page.curPage + 1}">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> 
					<a href="queryClassesPageAction.html?page.curPage=${page.pageCount}">最后一页</a>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>
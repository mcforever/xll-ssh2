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
<title>查看教师信息</title>
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

var teacherID;

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

//双击显示某条记录的信息
function showDetail(){
	var url = "teacherDetailAction.html?teacher.id=" + teacherID;
	document.location.href = url;
}



function toedit(form,str){
	var teacherIDs = new Array();
	var count = 0;
	
	for (var i=0;i<form.elements.length;i++){
      	var e = form.elements[i];
      	if (e.checked==true){
      		count = teacherIDs.push(e.value);
      	}
      
    }
	
	if(str == 'add'){
		var url = "teacherEditAction.html?option=" + str;
		document.location.href = url;
	}else if(str == 'edit'){
		if(count == 0){
			alert("请先选择一条想要修改的教师记录");
			return false;
		}else if(count == 1){
			for (var i=0;i<form.elements.length;i++){
		      	var e = form.elements[i];
		      	if (e.checked==true){
		      		count = teacherIDs.push(e.value);
		      		teacherID = e.value;
		      	}
		      
		    }
			var url = "teacherEditAction.html?option=" + str + "&teacher.id=" + teacherID;
			document.location.href = url;
		}else{
			alert("请先选择一条要删除的教师记录");
			return false;
		}
		
		
	}else if(str == 'delete'){
		if(count == 0){
			alert("请选择要删除的教师记录");
			return false;
		}else{
			if(confirm("确认删除?")){
				var url = "teacherDeleteAction.html?teacherids=" + teacherIDs;
				document.location.href = url;
			}
		}
		
	}
	
}

function toSubmit(){
	var url = "queryTeacherPageAction.html";
	document.formSearch.action = url;
	document.formSearch.submit();
	
}
</script>
</head>
<s:actionmessage />
<body>

<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>教师信息查看：管理教师</strong></font></td>
		</tr>
		<s:form id="formSearch" name="formSearch"
			action="" method="post">
			<tr>
				<td noWrap align="left" bgColor="#ebf2f9" height="30">
				<table cellSpacing="0" width="99%" border="0">
					<tbody>
						<tr>

							<td noWrap align="left">教师姓名：<input class="textfield"
								size="18" name="queryTeacher.teacherName" id="teacherName"></td>
								<td>教师职位：<s:select id="tposition" name="queryTeacher.tposition"
								list="tpositionList" theme="simple" listKey="dataID"
								listValue="dataDescription" label="教师职位：" headerKey=""
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
<!--		<tr>-->
<!--			<td noWrap align="left" bgColor="#ebf2f9" height="30">-->
<!--			<table cellSpacing="0" width="99%" border="0">-->
<!--				<tbody>-->
<!--					<tr>-->
<!--						<td><input type="button" id="button1" name="button1" value="新增" onclick="toedit(this.form,'add');" /></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="修改" onclick="toedit(this.form,'edit');" /></td>-->
<!--						<td><input type="button" id="button1" name="button1" value="删除" onclick="toedit(this.form,'delete');" /></td>-->
<!--						-->
<!--					</tr>-->
<!--				</tbody>-->
<!--			</table>-->
<!--			</td>-->
<!--		</tr>-->
		<tr>
<!--			<th noWrap align="center" width="50"-->
<!--				background="images/img/th_bg.gif"><input class="button"-->
<!--				id="submitOtherSelect" style="WIDTH: 30px; HEIGHT: 18px"-->
<!--				onclick="CheckOthers(this.form)" type="button" value="全选"-->
<!--				name="buttonOtherSelect"></th>-->
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>教师编号</strong></font></th>
			<th noWrap align="center" width="7%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>教师姓名</strong></font></th>
			<th noWrap align="center" width="15%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>教师职位</strong></font></th>
			<th noWrap align="center" width="10%"
				background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>所属学院</strong></font></th>
		</tr>
		<s:if test="page.result==null || page.result.size()==0">
	  		<td colspan="5" align="right">没有教师信息</td>
	 	</s:if>
		<s:iterator value="page.result" status="status">
			<tr onmouseover="this.style.backgroundColor = '#FFFFFF'"
				style="CURSOR: hand" onmouseout="this.style.backgroundColor = ''"
				bgColor="#ebf2f9" id="${id }" value="${id }"
				ondblclick="showDetail()" onclick="selectValue('${id}')">

<!--				<td noWrap align="center"><input-->
<!--					style="width: 13px; height: 13px" type="checkbox" value="${id }"-->
<!--					name="selectID" id="selectID_${id }"></td>-->
				<td align="center"><s:property value="id" /></td>
				<td align="center"><a href="teacherDetailAction.html?teacher.id=${id }"><s:property value="teacherName" /></a></td>
				<td align="center"><s:property value="tpositionStr" /></td>
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
				href="queryTeacherPageAction.html?page.curPage=1">第一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:if test="${page.curPage == page.pageCount}">
				<a
					href="queryTeacherPageAction.html?page.curPage=${page.curPage - 1}">前一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <c:if test="${page.curPage == 1}">
				<a
					href="queryTeacherPageAction.html?page.curPage=${page.curPage + 1}">下一页</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if> <a
				href="queryTeacherPageAction.html?page.curPage=${page.pageCount}">最后一页</a>
			</td>
		</tr>
	</tbody>
</table>


</body>
</html>
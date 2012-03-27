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
function goBack(){
	var url = "queryStudentPageAction.html";
	document.location.href = url;

}
</script>

</head>
<body>
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1"
	border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25"><font
				color="#ffffff"><strong>查询各个学年拿到学位、学历人数：管理学生</strong></font></td>
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
	<s:if test="page.result==null || page.result.size()==0">
	  	<tr><td colspan="5" align="right">没有信息</td></tr>	
	 </s:if>
	 <s:iterator value="degreeVoList" status="status">
	<tr>
		<td nowrap align="center">年份：</td>
		<td nowrap align="center"><input type="text" name="degreeVo.creatYear" id="creatYear" value="${creatYear }" readonly="readonly" /></td>
		<td nowrap align="center">总人数：</td>
		<td nowrap align="center"><input type="text" name="degreeVo.allNumber" id="allNumber" value="${allNumber }" readonly="readonly" /></td>
		<td nowrap align="center">获取学位人数</td>
		<td nowrap align="center"><input type="text" name="degreeVo.degreeNumber" id="degreeNumber" value="${degreeNumber }" readonly="readonly" /></td>
		<td nowrap align="center">获取学历人数</td>
		<td nowrap align="center"><input type="text" name="degreeVo.educationLevelNumber" id="educationLevelNumber" value="${educationLevelNumber }" readonly="readonly" /></td>
	</tr>
	</s:iterator>	
</table>


</body>
</html>
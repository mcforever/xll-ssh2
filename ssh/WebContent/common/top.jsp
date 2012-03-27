<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">

<title>top</title>
<link href="ui/css/admin/top.css" type=text/css rel=stylesheet>
</head>

<body class="frame_class">
<!-- 主菜单横向显示条 -->
<table cellSpacing="0" cellPadding="0" width="100%" border="0">
  <tbody>
  <tr>
    <td class="headTable">
      <div id="system_logo">
      	<img src="images/sys_logo.gif">
      </div>
      <div id="sysAnnounce">
      	<span id="NewAspAnnounce"></span>
      </div>
      <div class="topmenu" id="topmenu">
      	当前登陆用户：${sessionUser.userName }&nbsp;|&nbsp; 
      	<a href="modifyPasswordAction.html" target="mainFrame">修改密码</a>&nbsp;|&nbsp; 
      	<a onclick="return confirm('系统提示：您确定要退出学籍管理系统吗?')" href="logoutAction.html" target="_top">注销</a>&nbsp;&nbsp; 
      </div>
      <div style="CLEAR: both"></div>
      <div id="menuTabs">
      <ul>
        <c:forEach items="${moduleList}" var="module">
		<li onclick="return fullmenu('${ctx}/leftMenuAction.html?sysMenu.id=${module.id}')">
			<a target="mainFrame"><span>${module.menuName }</span></a>
		</li>
	</c:forEach>
      </ul>
      </div>
      <div style="CLEAR: both"></div>
      </td>
   </tr>
   </tbody>
</table>
<!-- 主菜单横向显示条 -->
<script type="text/javascript">
<!--
function fullmenu(url){
	if (url==null) {
		url = "left.jsp";
	}
	parent.leftFrame.location = url;
}
//-->

function modifyPassword(){
	url = "modifyPasswordAction.html";
	window.open(url,'newwindow','height=400,width=600,top=200,left=300,status=yes,resizable=yes');
}
</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<link href="ui/css/admin/left.css" type=text/css rel=stylesheet>
<title>left</title>
</head>
<script type="text/javascript">
function showsubmenu(sid) {
	var whichEl = document.getElementById("submenu" + sid);
	var menuTitle = document.getElementById("menuTitle" + sid);
	if (whichEl!=null) {
		if (whichEl.style.display == "none"){
			whichEl.style.display='';
			if (menuTitle!=null)
			menuTitle.className='menu_title';
		}else{
			whichEl.style.display='none';
			if (menuTitle!=null)
			menuTitle.className='menu_title2';
		}
	}
}
</script>
<body>
<table class="listflow" height="100%" cellSpacing="0" cellPadding="0">
  <tbody>  
  <tr>
    <td class="listbg" vAlign="top">
      <dl>
        <dt class="menu_title">${sysMenu.menuName }
        <dd id="submenu7">
        <ul>
			<c:forEach items="${sysMenu.childMenuList}" var="child">
				<li><a href="${child.url }" target=mainFrame>${child.menuName}</a></li>
			</c:forEach>
		</ul>
      </dd>
      </dl>
    </td>
  </tr>
  <tr>
    <td class="navbottom" style="BACKGROUND-REPEAT: no-repeat"></td>
  </tr>
  </tbody>
</table>
</body>
</html>

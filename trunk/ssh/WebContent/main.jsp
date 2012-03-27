<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content=no-cache">
<meta http-equiv="pragma" content=no-cache">
<title>学籍管理系统</title>
<link href="ui/css/admin/style.css" type="text/css" rel="stylesheet">
<style type="text/css">
html {
	BORDER-RIGHT: medium none; PADDING-RIGHT: 0px; BORDER-TOP: medium none; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; OVERFLOW: hidden; BORDER-LEFT: medium none; WIDTH: 100%; PADDING-TOP: 0px; BORDER-BOTTOM: medium none; HEIGHT: 100%
}
body {
	BORDER-RIGHT: medium none; PADDING-RIGHT: 0px; BORDER-TOP: medium none; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; OVERFLOW: hidden; BORDER-LEFT: medium none; WIDTH: 100%; PADDING-TOP: 0px; BORDER-BOTTOM: medium none; HEIGHT: 100%
}
table {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
td {
	FONT-SIZE: 12px; FONT-FAMILY: tahoma, 宋体, fantasy
}
</style>
<script type="text/javascript">
<!--
var status = 1;
function switchSysBar(){
     if (1 == window.status){
		  window.status = 0;
          switchPoint.innerHTML = '<img src="images/img/left.gif"/>';
          document.all("left_iframe").style.display="none"
		  document.all("left_table").style.display="none"
     }
     else{
		  window.status = 1;
          switchPoint.innerHTML = '<img src="images/img/right.gif"/>';
          document.all("left_iframe").style.display=""
		  document.all("left_table").style.display=""
     }
}
//-->
</script>
</head>
<body class="frame_class">
<table height="100%" cellSpacing="0" cellPadding="0" width="100%" border="0" style="background-color:transparent;">
  <tbody>
  <tr>
    <td id="head_iframe" colSpan="2" height="60"><iframe id="topFrame" name="topFrame" 
      src="mainMenuAction.html" frameBorder="no" noResize width="100%" 
      scrolling="no" height="100%"></iframe>
    </td>
  </tr>
  <tr>
    <td id="left_table" height="11"></td>
    <td class="topline" style="OVERFLOW: hidden; HEIGHT: 11px"></td>
  </tr>
  <tr>
    <td id="left_iframe" vAlign="top"><iframe id="leftFrame" 
      style="VISIBILITY: inherit; WIDTH: 188px; HEIGHT: 100%" name="leftFrame" 
      src="leftMenuAction.html" frameBorder="no" noResize 
      scrolling="no"></iframe></td>
    <td id="main_iframe" vAlign="top"><iframe id="mainFrame" 
      style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%;" 
      name="mainFrame" src="#" 
    frameBorder="no"></iframe></td></tr>

  </tbody>
</table>

</body>
</html>

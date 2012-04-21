<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<script type="text/javascript">
function goSave(){
	var password = document.getElementById("password");
	var oldPassword = document.getElementById("oldPassword");
	var newPassword = document.getElementById("newPassword");
	var againPassword = document.getElementById("againPassword");
	if(oldPassword.value == password.value){
		if(againPassword.value == "" || newPassword.value == ""){
			alert("新密码不能为空！！！");
			goNull();
			oldPassword.focus();
			return false;
		}
		if(againPassword.value == newPassword.value){
			if(confirm("确认修改密码?")){
			    var url = "savePasswordAction.html";
			    document.modifyPasswordform.action = url;
				document.modifyPasswordform.submit();
//			    form.submit();
		    }
		}else{
			alert("两次输入的密码不相同,请从新输入！！！");
			goNull();
			oldPassword.focus();
			return false;
		}
	}else{
		alert("原密码不正确，请从新输入！！！");
		goNull();
		oldPassword.focus();
		return false;
	}
}

function goNull(){
	document.getElementById("oldPassword").value="";
	document.getElementById("newPassword").value="";
	document.getElementById("againPassword").value="";
}

</script>

<c:if test="${msg == 1}">
	<script type="text/javascript">
		alert("密码保存成功");
	</script>
</c:if>
<c:if test="${msg == 2}">
	<script type="text/javascript">
		alert("密码保存失败");
	</script>
</c:if>
<body>
<form name="modifyPasswordform" method="post">
<table cellSpacing="1" cellPadding="3" width="99%" bgColor="#6298e1" border="0">
	<tbody>
		<tr>
			<td noWrap background="images/img/th_bg.gif" height="25">
				<font color="#ffffff"><strong>修改用户密码</strong></font>
			</td>
		</tr>
		<tr>
			<td noWrap align="left" bgColor="#ebf2f9" height="30">
			<table cellSpacing="0" width="99%" border="0">
				<tbody>
					<tr>
						<td align="left"><input type="button" onclick="goSave()" value="保存" name="saveBtn" /></td>
						<td align="right"><input type="button" onclick="goNull()" value="重置" name="cancle" /></td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</tbody>
</table>
<table width="100%" height="100%">
 <tr bgcolor=#E0EFFC height=100%><td>
  <table width=100% cellspacing="0" cellpadding="5" height=100%
	style="background-color:transparent;">
	
	<tr>
		<td width="20%" align="right">用户名：</td>
		<td width="30%"><input type="text" id="userName" name="sysUser.userName" value="${sessionUser.userName }" readonly="readonly" />
						<input type="hidden" id="id" name="sysUser.id" value="${sessionUser.id }" />
						<input type="hidden" id="password" name="sysUser.password" value="${sessionUser.password }" />
						<input type="hidden" id="userLevel" name="sysUser.userLevel" value="${sessionUser.userLevel }"/></td>
	</tr>
	<tr>
		<td width="20%" align="right">原密码：</td>
		<td width="30%"><input type="password" id="oldPassword" name="oldPassword" /></td>
	</tr>
	<tr>
		<td width="20%" align="right">新密码：</td>
		<td width="30%"><input type="password" id="newPassword" name="newPassword" /></td>
	</tr>
	<tr>
		<td width="20%" align="right">确认密码：</td>
		<td width="30%"><input type="password" id="againPassword" name="againPassword" /></td>
	</tr>
	
	
   </table>
 </td></tr>
</table>

	
</form>

</body>
</html>
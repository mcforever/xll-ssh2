<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台登录</title>
<style type="text/css">
	body{
		margin:0;
		background:url(images/bodybg.png);
		font-family:Verdana,"微软雅黑";
		font-size:14px;
		color:#fff;
		text-shadow: 1px 1px 2px #000;
	}
	.input {
		padding: 3px;
		font-size: 14px;
		text-shadow: 0px 1px 0px #fff;
		outline: none;
		background: -webkit-gradient(linear, left top, left bottom, from(#bcbcbe), to(#ffffff));
		background:#fff;
		-webkit-border-radius: 3px;
		-moz-border-radius: 3px;
		border-radius: 3px;
		border: 1px solid #7f9db9;
	}
	.input.fail {
		-webkit-box-shadow: 0px 0px 5px #ff4848;
		-moz-box-shadow: 0px 0px 5px #ff4848;
		box-shadow: 0px 0px 5px #ff4848;
	}	
	.input:focus {
		-webkit-box-shadow: 0px 0px 5px #000;
		-moz-box-shadow: 0px 0px 5px #000;
		box-shadow: 0px 0px 5px #000;
	}
	a, a:visited {
		color: #000;
		text-decoration: none;
		text-shadow: 0px 1px 0px #fff;
	}	
	a:hover {
		border-bottom: 1px dotted #fff;
	}
	.buttonlogin {
	    cursor: pointer;
		border:0px none;
		background:url(images/loginbtback.png) no-repeat;
		color:#fff;
		font-family:"微软雅黑";
		width:75px;
		height:24px;
	}
	</style>
	
	<script type="text/javascript">
	
	  /* 重置 */
	  function repeat(){
          var userNameStr = document.getElementById("sysUser.userName");
          var passwordStr = document.getElementById("sysUser.password");
          if(userNameStr != null){
             userNameStr.value = '';
          }
	      PasswordStr.value = '';
	  }
	  
	  /* 登录 */
	  function doLogin(){
  		var userNameStr = document.getElementById("sysUser.userName");
        var passwordStr = document.getElementById("sysUser.password");
		if(userNameStr.value == '' || userNameStr.value == null){
			alert("请输入用户名");
			return false;
		}
	    if(passwordStr.value == '' || passwordStr.value == null){
			alert("请输入密码");
			return false;
	    }
	  
         var loginform = document.getElementById("loginform");
	     loginform.action="${ctx}/doLoginAction.html";
	  	 loginform.submit();
	  }
	  
	  /* 获取登录密码 */
	  function getPassword(){
         var loginform = document.getElementById("loginform");
	     loginform.action="${ctx}/sms/getPasswordAction.html"
	  	 loginform.submit();
	  
	  }
	</script>
</head>
<body>

<form id="loginform" name="loginform" method="post" action="">
  
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="181" background="images/loginbg1.png">&nbsp;</td>
  </tr>
  <tr>
    <td height="238" background="images/laiyang.png">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="560">&nbsp;</td>
            <td>
            	<table width="378" border="0" cellpadding="6" cellspacing="0">
                  <tr>
                    <td align="right" nowrap="nowrap">&nbsp;</td>
                    <td align="left">&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="right" nowrap="nowrap">&nbsp;</td>
                    <td align="left">&nbsp;</td>
                  </tr>
                  <tr>
                  	<td align="right" nowrap="nowrap">登录身份：</td>
                        <td nowrap="nowrap">
	                    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	                            <tr>
	                              <td width="10">&nbsp;</td>
	                              <td><input type="radio" name="sysUser.userLevel" id="sysUser.userLevel" value="1" checked="checked"/></td>
	                              <td align="left">学生</td>
	                              <td width="10" align="left">&nbsp;</td>
	                              <td><input type="radio" name="sysUser.userLevel" id="sysUser.userLevel" value="2" /></td>
	                              <td align="left">教师</td>
	                              <td width="10" align="left">&nbsp;</td>
	                              <td><input type="radio" name="sysUser.userLevel" id="sysUser.userLevel" value="3" /></td>
	                              <td align="left">管理员</td>
	                              <td width="50">&nbsp;</td>
	                          </tr>
	                    	</table>                    
                    	</td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right" nowrap="nowrap">
                        <table width="100%" border="0" cellspacing="0" cellpadding="8">
                          <tr>
                            <td align="right" nowrap="nowrap">用户名：</td>
                            <td align="left"><input id="sysUser.userName" name="sysUser.userName" type="text" class="input" style="width:200px;" /></td>
                          </tr>
                          <tr>
                            <td align="right" nowrap="nowrap">密　码：</td>
                            <td align="left"><input id="sysUser.password" name="sysUser.password" type="password" class="input" style="width:200px;" onkeydown="if(event.keyCode==13) doLogin();"/></td>
                          </tr>
                        </table>
                    </td>
                  </tr>
                  <tr>
                  	<td align="left" >
				        <font color="red" style="font-size: 11">
				            	*
						</font>
                  	</td>
                    <td colspan="3" style="padding-left:0px;">
                      <input type="button" class ="buttonlogin" value=" 登  录 " onclick="doLogin();" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="reset" class ="buttonlogin" value=" 重  置 " onclick="repeat();"  />                    
                    </td>
                  </tr>
            	</table>
            </td>
          </tr>
        </table>
    </td>
  </tr>
  <tr>
    <td height="181" background="images/loginbg3.png">&nbsp;</td>
  </tr>
</table>  
</form>


 
</body>
</html>
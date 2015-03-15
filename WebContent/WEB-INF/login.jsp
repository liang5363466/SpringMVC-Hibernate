<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="shared/_layout_top.jsp" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>服装管理系统</title>
	<link href="<%=sys_res%>/css/login.css" rel="stylesheet" />
</head>
<body>
	<form id="loginForm" method="post" action="<%=webRoot%>/User/Login">
        <div class="main">
            <div class="title"></div>
            <div class="content">
                <div class="control">
                	<label><span>用户名：</span><input name="user.loginName" type="text" placeholder="请输入用户名" value="admin"/></label>
                </div>
                <div class="control">
                	<label><span>密码：</span><input name="user.password" type="password" placeholder="请输入密码" value="1234"/></label>
               	</div>    
                <div class="control">
                    <img id="btnSubmit" src="<%=sys_res%>/images/login_btn.png" alt=""/>
                </div>
            </div>
        </div>
    </form>
</body>
<%@include file="shared/_layout_bottom.jsp" %>
<script src="<%=sys_res%>/js/login.js"></script>
</html>
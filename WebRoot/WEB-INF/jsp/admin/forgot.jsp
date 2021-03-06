<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<html>
<head>
    <title>忘记密码</title>
    <link href="${webResourceUrl}/resource/login/css/login.css" rel="stylesheet" type="text/css">
    <link href="${webResourceUrl}/plugins/alert/alerta.css" rel="stylesheet" type="text/css">
    <script src="${webResourceUrl}/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${webResourceUrl}/resource/login/js/forgot.js" type="text/javascript"></script>
    <script src="${webResourceUrl}/plugins/alert/alerta.js" type="text/javascript"></script>
    <%@ include file="/commons/appConfig.jsp" %>
</head>

<body class="login">
<div id="mask_boxs">
    <div id="masks"></div>
    <div id="mcon"></div>
</div>
<div class="login_m">
    <div class="showP">
        <img class="showI" src="${webResourceUrl}/resource/login/images/l_p1.png">
    </div>
    <div class="login_boder">
        <form name="loginForm" id="loginForm">
            <div class="login_padding">
                <div class="welcomeC"><h1>忘记密码</h1></div>
                <br/>
                <input type="text" id="username" class="txt_input txt_input2" placeholder="请输入用户名">
                <br/>
                <input type="text" id="mobile" class="txt_input" placeholder="请输入负责人手机号">
                <div class="subDiv">
                    <input type="button" id="subBtn" value="找 回 密 码" class="subBtn">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

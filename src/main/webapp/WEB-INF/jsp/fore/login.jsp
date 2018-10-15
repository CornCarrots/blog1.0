<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/1
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">登录</li>
    </ul>
</div>
</nav>
<div class="login">
    <h3>Welcome To Your Blog</h3>
    <div style="display: none" class="errorDIV">
        用户名或密码错误，请重新输入
    </div>
    <form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
        <table class="loginTable">
            <tr>
                <td>
                    <span class="glyphicon glyphicon-user"></span>
                </td>
                <td>
                    <input class="form-control" type="text" placeholder="请输入你的用户名" id="loginName">
                </td>
            </tr>
            <tr>
                <td>
                    <span class="glyphicon glyphicon-lock"></span>
                </td>
                <td>
                    <input class="form-control" type="text" placeholder="请输入你的密码" id="loginPass">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <div class="btn btn-success loginButton" style="width: 100%">立即登录</div>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <a href="${pageContext.request.contextPath}/register/page">
                        <div class="btn btn-default" style="width: 100%">没有账号，立即注册</div>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>

<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/4
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">注册</li>
    </ul>
</div>
</nav>
<div class="register">
    <img src="${pageContext.request.contextPath}/img/site/registerSuccess.png" alt="">
    <span>恭喜您注册成功</span>
    <p class="successP">如果浏览器没有跳转，<a href="${pageContext.request.contextPath}/loginPage">请点击这里</a></p>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>

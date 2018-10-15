<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/6
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main">
    <div class="userInfo">
        <div class="userLeft pull-left">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active userLi"><a href="${pageContext.request.contextPath}/home/users/${user.id}">个人资料</a></li>
                <li role="presentation" class="userLi"><a href="${pageContext.request.contextPath}/home/users/${user.id}/articles">我的文章</a></li>
                <li role="presentation" class="userLi"><a href="${pageContext.request.contextPath}/home/users/${user.id}/create">创建文章</a></li>
            </ul>
        </div>
        <div class="userRight pull-left">

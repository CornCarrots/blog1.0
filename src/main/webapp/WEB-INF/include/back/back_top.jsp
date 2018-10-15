<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/21
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<header class="back_header">
    <span class="header_Bigtitle"><a href="${pageContext.request.contextPath}/admin/index">博客后台</a></span>
    <span class="btn bg-primary"><a href="${pageContext.request.contextPath}/home">前台</a></span>
    <div class="btn-group">
        <a class="btn btn-success  dropdown-toggle" data-toggle="dropdown" href="#">
            新建
            <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/admin/articles/page/add">文章</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/categories#insert">分类</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/tags/#insert">标签</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/notices/page/add">公告</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/links/page/add">链接</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/menus/page/add">菜单</a></li>
        </ul>
    </div>
    <span class="pull-right">
        <span>
            <img src="${pageContext.request.contextPath}/${user.userPhoto}" alt="" width="30px" height="30px">
            <span style="color: white">${user.userName}</span>
        </span>
    <span><a href="${pageContext.request.contextPath}/admin/logout">退出</a></span>
    </span>
    </span>
</header>

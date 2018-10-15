<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/3
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">文章归档</li>
    </ul>
</div>
</nav>
<div class="main">
    <%@include file="../../include/fore/fore_right.jsp" %>
    <div class="search">
        <c:forEach items="${articles}" var="art">
            <div class="search_context"><a href="${pageContext.request.contextPath}/home/articles/${art.id}" class="search_text">${art.articleTitle} </a><span class="search_date pull-right">${art.createDateDesc}</span></div>
        </c:forEach>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>


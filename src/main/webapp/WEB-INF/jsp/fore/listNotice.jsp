<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/8
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">所有公告</li>
    </ul>
</div>
</nav>
<div class="main">
    <%@include file="../../include/fore/fore_right.jsp" %>
    <div class="search">
        <c:forEach items="${notices}" var="not_">
            <div class="search_context"><a href="${pageContext.request.contextPath}/home/notices/${not_.id}"
                                           class="search_text">${not_.noticeTitle} </a><span
                    class="search_date pull-right">${not_.updateDateDesc()}</span></div>
        </c:forEach>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>

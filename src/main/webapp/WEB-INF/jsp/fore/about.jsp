<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/3
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">关于本站</li>
    </ul>
</div>
</nav>
<div class="main">
    <%@include file="../../include/fore/fore_right.jsp" %>
    <div class="test">
        <div class="MainText">
            <div class="text_main">
                <div class="text_main_title">${optionName.optionValue}</div>
                <div class="text_main_container">
                   ${optionDescribe.optionValue}
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>
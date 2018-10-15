<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/13
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<div style="position: relative; background:url('${pageContext.request.contextPath}/img/error/error_bg.jpg') repeat-x scroll 0 0 #67ACE4;">
<%@include file="../../include/fore/fore_top.jsp" %>
<!-- 代码 开始 -->
<div id="container"><img class="png" src="${pageContext.request.contextPath}/img/error/404.png"/> <img class="png msg" src="${pageContext.request.contextPath}/img/error/404_msg.png"/>
    <p><a href="${pageContext.request.contextPath}" target="_blank"><img class="png" src="${pageContext.request.contextPath}/img/error/404_to_index.png"/></a></p>
</div>
<div id="cloud" class="png"></div>
<!-- 代码 结束 -->
<div class="clearfix"></div>
</div>
<%@include file="../../include/fore/fore_footer.jsp" %>


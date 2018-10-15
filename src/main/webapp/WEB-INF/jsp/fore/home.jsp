<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/8
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">热门文章</li>
    </ul>
</div>
</nav>
<div class="main">
    <%@include file="../../include/fore/fore_right.jsp" %>
    <div class="myarticle">
        <c:forEach items="${articles}" var="art" varStatus="st1">
            <article class="mainContext">
                <div class="redBlock"></div>
                <c:if test="${st1.index eq 0}">
                    <div class="newBlock">new</div>
                </c:if>
                <div class="context_category">
                    <c:if test="${!empty art.children}">
                        <a href="${pageContext.request.contextPath}/home/categories/${art.children.id}">${art.children.categoryName}</a>
                    </c:if>
                </div>
                <a href="${pageContext.request.contextPath}/home/articles/${art.id}"><img
                        src="${pageContext.request.contextPath}/img/upload/category/${art.children.id}.jpg" alt=""
                        class="pull-left"></a>
                <div class="context_title"><a
                        href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a></div>
                <div class="context_text">
                        ${fn:substring(art.articleMdText.trim(),0 ,75 )}......
                </div>
                <div class="context_info">
                    <span class="context_time">${art.updateDateDesc()}</span>
                    <span class="context_view"><span
                            class="glyphicon glyphicon-eye-open"></span>${art.articleViews} views</span>
                    <span class="context_comment">
                <a href="${pageContext.request.contextPath}/home/articles/${art.id}#comment"> <span
                        class="glyphicon glyphicon-comment"></span>发表评论</a>
            </span>
                </div>
                <span class="context_button">
                    <a href="${pageContext.request.contextPath}/home/articles/${art.id}"><button>阅读全文</button></a>
            </span>
            </article>
            <%--<div class="clearfix"></div>--%>
        </c:forEach>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>


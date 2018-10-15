<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/8
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/home/users/${user.id}">我的空间</a></li>
        <li class="active">我的评论</li>
    </ul>
</div>
</nav>
<div class="main">
    <div class="userInfo">
        <div class="userLeft pull-left">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}">个人资料</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/articles">我的文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/create">创建文章</a></li>
                <li role="presentation" class="active userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/comments">评论</a></li>
            </ul>
        </div>
        <div class="userRight pull-left">
            <div class="comment">
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active">
                        <a href="#allComment" data-toggle="tab">
                            全部评论(${comments.size()})
                        </a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="allComment">
                        <table class="allComment_table table table-striped table-bordered table-hover  table-condensed">
                            <thead>
                            <tr>
                                <%--<th>id</th>--%>
                                <th>作者</th>
                                <th>评论内容</th>
                                <th class="comment_table_article">回复帖子</th>
                                <th>提交时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${comments}" var="com">
                                <c:if test="${com.user.id != user.id}">
                                    <tr class="allComment_tr">
                                        <td class="comment_table_author">
                                            <img src="${pageContext.request.contextPath}/${com.user.userPhoto}" alt=""
                                                 width="64px" height="64px">
                                            <span>
                                                    ${com.user.userNickName}
                                            </span>
                                        </td>
                                        <td class="allComment_table_text">

                                            <c:choose>
                                                <c:when test="${fn:length(com.commentMdText) > 30}">
                                                    ${fn:substring(com.commentMdText,0,30)}...
                                                </c:when>
                                                <c:otherwise>
                                                    ${com.commentMdText}
                                                </c:otherwise>
                                            </c:choose>
                                            <div class="allComment_table_edit" style="visibility:hidden">
                                                <c:if test="${com.commentStatus==1}">
                                                    <a href="${pageContext.request.contextPath}/home/users/${user.id}/comments/shield/${com.id}"
                                                       class="editComment">屏蔽</a><span class="separate">|</span>
                                                    <a href="${pageContext.request.contextPath}/home/users/${user.id}/comments/allow/${com.id}"
                                                       class="editComment">批准</a><span class="separate">|</span>
                                                </c:if>
                                                <c:if test="${com.commentStatus==2}">
                                                    <a href="${pageContext.request.contextPath}/home/users/${user.id}/comments/shield/${com.id}"
                                                       class="editComment">屏蔽</a><span class="separate">|</span>
                                                </c:if>
                                                <c:if test="${com.commentStatus==3}">
                                                    <a href="${pageContext.request.contextPath}/home/users/${user.id}/comments/allow/${com.id}"
                                                       class="editComment">批准</a><span class="separate">|</span>
                                                </c:if>
                                                <a href="${pageContext.request.contextPath}/home/users/${user.id}/comments/${com.id}">回复</a>
                                                    <%--<span class="separate">|</span>--%>
                                                    <%--<a href="${pageContext.request.contextPath}/admin/comments/${com.id}" class="deleteComment">删除</a>--%>
                                            </div>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${fn:length(com.article.articleTitle) > 37}">
                                                    <a href="${pageContext.request.contextPath}/home/articles/${com.article.id}">${fn:substring(com.article.articleTitle,0,37)}...</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="${pageContext.request.contextPath}/home/articles/${com.article.id}">${com.article.articleTitle}</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="comment_table_date">
                                                ${com.createDateDesc2()}
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../model/fore/fore_article_delete.jsp" %>
<%@include file="../../include/fore/fore_footer.jsp" %>

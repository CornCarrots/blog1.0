<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/27
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
        <li class="active">评论列表</li>
    </ul>
    <div class="comment">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active">
                <a href="#allComment" data-toggle="tab">
                    全部评论(${comments.size()})
                </a>
            </li>
            <li><a href="#waitComment" data-toggle="tab">待审评论(${waitComments.size()})</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="allComment">
                <table class="allComment_table table table-striped table-bordered table-hover  table-condensed">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th class="comment_table_article">回复帖子</th>
                        <th>提交时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${comments}" var="com">
                        <tr class="allComment_tr">
                            <td class="comment_table_id">
                                ${com.id}
                            </td>
                            <td class="comment_table_author">
                                <img src="${pageContext.request.contextPath}/${com.user.userPhoto}" alt="" width="64px" height="64px">
                                <span>
                                    ${com.user.userNickName}
                                </span>
                            </td>
                            <td class="allComment_table_text">
                                ${com.commentMdText}
                                <div class="allComment_table_edit" style="visibility:hidden">
                                    <c:if test="${com.commentStatus==1}">
                                        <a href="${pageContext.request.contextPath}/admin/comments/shield/${com.id}" class="editComment">屏蔽</a><span class="separate">|</span>
                                        <a href="${pageContext.request.contextPath}/admin/comments/allow/${com.id}" class="editComment">批准</a><span class="separate">|</span>
                                    </c:if>
                                    <c:if test="${com.commentStatus==2}">
                                        <a href="${pageContext.request.contextPath}/admin/comments/shield/${com.id}" class="editComment">屏蔽</a><span class="separate">|</span>
                                    </c:if>
                                    <c:if test="${com.commentStatus==3}">
                                        <a href="${pageContext.request.contextPath}/admin/comments/allow/${com.id}" class="editComment">批准</a><span class="separate">|</span>
                                    </c:if>
                                    <a href="${pageContext.request.contextPath}/admin/comments/refuse/${com.id}">回复</a><span class="separate">|</span>
                                    <a href="${pageContext.request.contextPath}/admin/comments/${com.id}" class="deleteComment">删除</a>
                                </div>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/home/articles/${com.article.id}">${com.article.articleTitle}</a>
                            </td>
                            <td class="comment_table_date">
                                ${com.createDateDesc()}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="waitComment">
                <table class="waitComment_table table table-striped table-bordered table-hover  table-condensed">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>作者</th>
                        <th>评论内容</th>
                        <th class="comment_table_article">回复帖子</th>
                        <th>提交时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${waitComments}" var="com">
                        <tr class="waitComment_tr">
                            <td class="comment_table_id">
                                    ${com.id}
                            </td>
                            <td class="comment_table_author">
                                <img src="${pageContext.request.contextPath}/${com.user.userPhoto}" alt="" width="64px" height="64px">
                                <span>
                                        ${com.user.userNickName}
                                </span>
                            </td>
                            <td class="waitComment_table_text">
                                    ${com.commentMdText}
                                <div class="waitComment_table_edit" style="visibility:hidden">
                                    <a href="${pageContext.request.contextPath}/admin/comments/shield/${com.id}" class="editComment">屏蔽</a><span class="separate">|</span>
                                    <a href="${pageContext.request.contextPath}/admin/comments/allow/${com.id}" class="editComment">批准</a><span class="separate">|</span>
                                    <a href="${pageContext.request.contextPath}/admin/comments/refuse/${com.id}">回复</a><span class="separate">|</span>
                                    <a href="${pageContext.request.contextPath}/admin/comments/${com.id}" class="deleteComment">删除</a>
                                </div>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/home/articles/${com.article.id}">${com.article.articleTitle}</a>
                            </td>
                            <td class="comment_table_date">
                                    ${com.createDateDesc}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
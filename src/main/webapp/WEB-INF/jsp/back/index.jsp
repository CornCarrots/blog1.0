<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/22
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp"%>
<%@include file="../../include/back/back_top.jsp"%>
<%@include file="../../include/back/back_navigation.jsp"%>
<div class="container">
    <div class="index_news">
        <div class="index_publish">
            <p>最近发布</p>
            <br>
            <div>
                <ul>
                    <c:forEach items="${articles}" var="art" varStatus="st">
                        <li><span class="index_publish_date">${art.updateDateDesc()}  </span><a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="index_comment">
            <p>近期评论</p>
            <c:forEach items="${comments}" var="com" varStatus="st">
                <div class="index_comment_textBlock">
                    <img src="${pageContext.request.contextPath}/${com.user.userPhoto}" alt="" width="60" height="60" class="pull-left">
                    <div class="index_comment_source">由${com.user.userNickName}发表在 <a href="${pageContext.request.contextPath}/home/articles/${com.aid}">${com.article.articleTitle}</a>
                        <c:if test="${com.commentStatus==1}"> <span class="label label-warning">${com.statusDesc()}</span></c:if>
                        <c:if test="${com.commentStatus==2}"> <span class="label label-success">${com.statusDesc()}</span></c:if>
                        <c:if test="${com.commentStatus==3}"> <span class="label label-danger">${com.statusDesc()}</span></c:if>
                    </div>
                    <div class="index_comment_text">${com.statusDesc()}</div>
                    <div class="index_comment_edit" style="visibility:hidden">
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
                </div>
                <div class="clearfix"></div>
            </c:forEach>
        </div>
    </div>
</div>
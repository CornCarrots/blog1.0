<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/6
  Time: 16:55
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
        <li class="active">我的文章</li>
    </ul>
</div>
</nav>
<div class="main">
    <div class="userInfo">
        <div class="userLeft pull-left">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}">个人资料</a></li>
                <li role="presentation" class="active userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/articles">我的文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/create">创建文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/comments">评论</a></li>
            </ul>
        </div>
        <div class="userRight pull-left">
            <div class="allArticle_contain">
                <ul id="myTab" class="nav nav-tabs">
                    <li <c:if test="${status eq 1}">class="active"</c:if>>
                        <a href="#published" data-toggle="tab">
                            已发布(${publishSum})
                        </a>
                    </li>
                    <li <c:if test="${status eq 2}">class="active"</c:if>>
                        <a href="#draft" data-toggle="tab">草稿(${draftSum})</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade <c:if test="${status eq 1}">in active</c:if>" id="published">
                        <table class="published_table table table-striped table-bordered table-hover  table-condensed">
                            <thead>
                            <tr>
                                <%--<th class="published_table_id">id</th>--%>
                                <th>标题</th>
                                <th>发布时间</th>
                                <th class="published_table_edit">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${publishArticles}" var="art" varStatus="st">
                                <tr>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                                    </td>
                                    <td>
                                            ${art.createDateDesc()}
                                    </td>
                                    <td class="article_table_edit">
                                        <a class="btn btn-default"
                                           href="${pageContext.request.contextPath}/fore/articles/${art.id}">编辑</a>
                                        <button class="btn btn-warning deleteArticleOne" data-toggle="modal"
                                                aid="${art.id}">删除
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="tab-pane fade <c:if test="${status eq 2}">in active</c:if>" id="draft">

                        <table class="draft_table table table-striped table-bordered table-hover  table-condensed">
                            <thead>
                            <tr>
                                <th>标题</th>
                                <th>发布时间</th>
                                <th class="draft_table_edit">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${draftArticles}" var="art" varStatus="st">
                                <tr>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                                    </td>
                                    <td>
                                            ${art.createDateDesc()}
                                    </td>
                                    <td class="article_table_edit">
                                        <a class="btn btn-default"
                                           href="${pageContext.request.contextPath}/fore/articles/${art.id}">编辑</a>
                                        <button class="btn btn-warning deleteArticleOne" data-toggle="modal"
                                                aid="${art.id}">删除
                                        </button>
                                    </td>
                                </tr>
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

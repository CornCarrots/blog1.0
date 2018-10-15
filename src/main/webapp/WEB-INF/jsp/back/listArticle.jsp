<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/22
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="allArticle">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="active">文章列表</li>
        </ul>
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
                    <div class="published_header">
                        <form class="form-search" action="${pageContext.request.contextPath}/admin/articles/search"
                              method="post">
                            <div class="input-append">
                                <input type="text" class="span2 search-query" name="key" value="">
                                <input type="hidden" name="status" value="1">
                                <button type="submit" class="btn btn-info">Search</button>
                            </div>
                        </form>
                        <span class="article_table_edit">
                            <button class="btn btn-warning deletePublishArticleAll" data-toggle="modal">批量删除</button>
                        </span>
                    </div>
                    <table class="published_table table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr>
                            <th id="published_table_checkAll">
                                <div class="checkbox checkbox-success checkbox-inline" style="margin: 5px">
                                    <input type="checkbox" class="styled" id="publishedCheck">
                                    <label for="publishedCheck"></label>
                                </div>
                            </th>
                            <th class="published_table_id">id</th>
                            <th>标题</th>
                            <th>所属分类</th>
                            <th>所带标签</th>
                            <th>发布时间</th>
                            <th class="published_table_edit">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${publishArticles}" var="art" varStatus="st">
                            <tr>
                                <td class="published_table_check">
                                    <div class="checkbox checkbox-success checkbox-inline" style="margin: 5px">
                                        <input type="checkbox" name="publishCheckBox" class="styled" value="${art.id}"
                                               id="${art.id}_check">
                                        <label for="${art.id}_check"></label>
                                    </div>
                                </td>
                                <td class="published_table_id">${art.id}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/home/categories/${art.parent.id}">${art.parent.categoryName}</a>
                                    <a href="${pageContext.request.contextPath}/home/categories/${art.children.id}">${art.children.categoryName}</a>
                                </td>
                                <td>
                                    <c:forEach items="${art.tags}" var="tag" varStatus="st2">
                                        <a href="${pageContext.request.contextPath}/home/tags/${tag.id}">${tag.tagName}</a>
                                    </c:forEach>
                                </td>
                                <td>
                                        ${art.createDateDesc()}
                                </td>
                                <td class="article_table_edit">
                                    <button class="btn"><a
                                            href="${pageContext.request.contextPath}/admin/articles/${art.id}">编辑</a>
                                    </button>
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
                    <div class="published_header">
                        <form class="form-search" action="${pageContext.request.contextPath}/admin/articles/search"
                              method="post">
                            <div class="input-append">
                                <input type="text" class="span2 search-query" name="key" value="">
                                <input type="hidden" name="status" value="2">
                                <button type="submit" class="btn btn-info">Search</button>
                            </div>
                        </form>
                        <span class="article_table_edit">
                            <button class="btn btn-warning deleteDraftArticleAll" data-toggle="modal">批量删除</button>
                        </span>
                    </div>
                    <table class="draft_table table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr>
                            <th id="draft_table_checkAll">
                                <div class="checkbox checkbox-success checkbox-inline" style="margin: 5px">
                                    <input type="checkbox" class="styled" id="draftCheck">
                                    <label for="draftCheck"></label>
                                </div>
                            </th>
                            <th class="draft_table_id">id</th>
                            <th>标题</th>
                            <th>所属分类</th>
                            <th>所带标签</th>
                            <th>发布时间</th>
                            <th class="draft_table_edit">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${draftArticles}" var="art" varStatus="st">
                            <tr>
                                <td class="draft_table_check">
                                    <div class="checkbox checkbox-success checkbox-inline" style="margin: 5px">
                                        <input type="checkbox" name="draftCheckBox" class="styled" value="${art.id}"
                                               id="${art.id}_check">
                                        <label for="${art.id}_check"></label>
                                    </div>
                                </td>
                                <td class="draft_table_id">${art.id}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/home/categories/${art.parent.id}">${art.parent.categoryName}</a>
                                    <a href="${pageContext.request.contextPath}/home/categories/${art.children.id}">${art.children.categoryName}</a>
                                </td>
                                <td>
                                    <c:forEach items="${art.tags}" var="tag" varStatus="st2">
                                        <a href="${pageContext.request.contextPath}/home/tags/${tag.id}">${tag.tagName}</a>
                                    </c:forEach>
                                </td>
                                <td>
                                        ${art.createDateDesc()}
                                </td>
                                <td class="article_table_edit">
                                    <a class="btn" href="${pageContext.request.contextPath}/admin/articles/${art.id}">编辑</a>
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
<%@include file="../../model/back/back_article_delete.jsp" %>


<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/25
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="tag">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/tags">文章列表</a></li>
            <li class="active">添加标签</li>
        </ul>
        <div class="myTag">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <thead>
                <tr>
                    <th class="myTag_id">id</th>
                    <th class="myTag_name">名称</th>
                    <th class="myTag_article">文章数</th>
                    <th class="myTag_status">状态</th>
                    <th class="myTag_edit">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tags}" var="tag">
                    <tr>
                        <td>
                            ${tag.id}
                        </td>
                        <td>
                            ${tag.tagName}
                        </td>
                        <td style="display: none">
                            ${tag.tagDescripe}
                        </td>
                        <td>
                            ${tag.articles.size()}
                        </td>
                        <td>
                            ${tag.tagStatusDesc()}
                        </td>
                        <td>
                            <button class="btn btn-default editOneTag" data-toggle="modal" tid="${tag.id}">编辑</button>
                            <button class="btn btn-warning deleteOneTag" tid="${pageContext.request.contextPath}/admin/tags/${tag.id}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="addTag">
            <div class="panel panel-success">
                <div class="panel-heading">添加标签</div>
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/admin/tags" method="post">
                        <table>
                            <tr>
                                <td>
                                    <label for="tagName">名称<span class="alarm">*</span></label>
                                </td>
                                <td>
                                    <input type="text" placeholder="请输入分类名称" id="tagName" name="tagName" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="tagDescripate">描述</label>
                                </td>
                                <td>
                                    <input type="text" placeholder="请输入标签描述" id="tagDescripate" name="tagDescripe" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center">
                                    <button type="submit" class="btn btn-success">提交</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<a name="insert"></a>
<%@include file="../../model/back/back_tag_edit.jsp" %>
<%@include file="../../model/back/back_tag_delete.jsp" %>
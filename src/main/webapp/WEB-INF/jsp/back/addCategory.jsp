<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/25
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="category">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li ><a href="${pageContext.request.contextPath}/admin/categories">分类列表</a></li>
            <li class="active">添加分类</li>
        </ul>
        <div class="myCategory">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <thead>
                <tr>
                    <th class="myCategory_id">id</th>
                    <th class="myCategory_pid">pid</th>
                    <th class="myCategory_name">名称</th>
                    <th class="myCategory_article">文章数</th>
                    <th class="myCategory_status">状态</th>
                    <th class="myCategory_status">图片</th>
                    <th class="myCategory_edit">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="cat">
                    <tr>
                        <td <c:if test="${cat.pid eq 0}">class="parentNode"</c:if>>
                            ${cat.id}
                        </td>
                        <td>
                            ${cat.pid}
                        </td>
                        <td style="display: none">
                            ${cat.categoryDescripe}
                        </td>
                        <td>
                            ${cat.categoryName}
                        </td>
                        <td>
                            ${cat.articles.size()}
                        </td>
                        <td>
                            ${cat.categoryStatusDesc()}
                        </td>
                        <td>
                            <img src="${pageContext.request.contextPath}/img/upload/category/${cat.id}" alt="" width="10px" height="10px">
                        </td>
                        <td>
                            <button class="btn btn-default editOneCategory" data-toggle="modal" cid="${cat.id}">编辑</button>
                            <button class="btn btn-warning deleteOneCategory" cid="${pageContext.request.contextPath}/admin/categories/${cat.id}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%@include file="../../include/back/BackPage.jsp" %>
        <div class="addCategory">
            <div class="panel panel-success">
                <div class="panel-heading">添加分类</div>
                <div class="panel-body" style="padding: 0">
                    <form action="${pageContext.request.contextPath}/admin/categories" method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td>
                                    <label for="categoryName">名称<span class="alarm">*</span></label>
                                </td>
                                <td>
                                    <input type="text" placeholder="请输入分类名称" name="categoryName" id="categoryName" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="categoryParent">父节点<span class="alarm">*</span></label>
                                </td>
                                <td>
                                    <select  class="selectpicker" data-style="btn-success" tabindex="-98" id="categoryParent" name="pid">
                                        <option value="0">无</option>
                                        <c:forEach items="${categories1}" var="cat">
                                            <option value="${cat.id}">${cat.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="categoryDescripate">描述</label>
                                </td>
                                <td>
                                    <input type="text" placeholder="请输入分类描述" id="categoryDescripate" class="form-control" name="categoryDescripe">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="categoryPic">图片</label>
                                </td>
                                <td>
                                    <input type="file" placeholder="请上传分类图片" id="categoryPic" class="form-control" name="image">
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
        <a name="insert"></a>
    </div>
</div>
<%@include file="../../model/back/back_category_edit.jsp" %>
<%@include file="../../model/back/back_category_delete.jsp" %>

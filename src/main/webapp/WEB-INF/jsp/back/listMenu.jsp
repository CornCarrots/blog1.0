<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/27
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="menuList">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="active">菜单列表</li>
        </ul>
        <div class="myMenu">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <thead>
                <tr>
                    <th class="menu_id">id</th>
                    <th class="menu_name">名称</th>
                    <th>URL</th>
                    <th class="menu_status">状态</th>
                    <th class="menu_edit">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${menus}" var="menu">
                    <tr>
                        <td>
                            ${menu.id}
                        </td>
                        <td>
                            <a href="${menu.menuLink}">${menu.menuName}</a>
                        </td>
                        <td>
                            ${menu.menuLink}
                        </td>
                        <td>
                            ${menu.menuStatusDesc()}
                        </td>
                        <td>
                            <a class="btn btn-default editMenu" href="${pageContext.request.contextPath}/admin/menus/${menu.id}">编辑</a>
                            <button class="btn btn-warning deleteMenuOne" data-toggle="modal"
                                    nid="${pageContext.request.contextPath}/admin/menus/${menu.id}">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="../../model/back/back_menu_edit.jsp" %>
<%@include file="../../model/back/back_menu_delete.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/27
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="menuAdd">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="active">添加菜单</li>
        </ul>
        <form action="${pageContext.request.contextPath}/admin/menus" method="post">
            <table>
                <tr>
                    <td>
                        名称 <span class="alarm">*</span>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="menuName">
                    </td>
                </tr>
                <tr>
                    <td>
                        URL <span class="alarm">*</span>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="menuLink">
                    </td>
                </tr>
                <tr>
                    <td>
                        icon <span class="alarm">*</span>
                    </td>
                    <td>
                        <input type="text" class="form-control" name="menuIcon">
                    </td>
                </tr>
                <tr>
                    <td>
                        位置 <span class="alarm">*</span>
                    </td>
                    <td>
                        <select class="selectpicker" data-style="btn-default" tabindex="-98" name="menuRole">
                                <option value="1">顶部菜单</option>
                                <option value="2">导航栏菜单</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <button class="btn btn-success" type="submit">添加</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

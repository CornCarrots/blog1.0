<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<<div class="container">
<div class="linkAdd">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
        <li class="active">链接列表</li>
    </ul>
    <form action="${pageContext.request.contextPath}/admin/links" method="post">
        <h5><b>编辑链接</b></h5>
        <table>
            <tr>
                <td>
                    名称 <span class="alarm">*</span>
                </td>
                <td>
                    <input type="text" class="form-control" name="linkName">
                </td>
            </tr>
            <tr>
                <td>
                    URL <span class="alarm">*</span>
                </td>
                <td>
                    <input type="text" class="form-control" name="linkUrl">
                </td>
            </tr>
            <tr>
                <td>
                    联系方式
                </td>
                <td>
                    <input type="text" class="form-control" name="linkDescribe">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <button class="btn btn-success" type="submit">添加</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</div>

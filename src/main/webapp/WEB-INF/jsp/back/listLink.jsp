<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/26
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="linkList">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="active">链接列表</li>
        </ul>
        <div class="myLink">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <thead>
                <tr>
                    <th>id</th>
                    <th>名称</th>
                    <th>URL</th>
                    <th>联系方式</th>
                    <th>创建时间</th>
                    <th>状态</th>
                    <th>编辑</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${links}" var="link">
                    <tr>
                        <td>
                            ${link.id}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/home/links/${link.id}">
                                ${link.linkName}
                            </a>
                        </td>
                        <td>
                            <a href="${link.linkUrl}">
                                ${link.linkUrl}
                            </a>
                        </td>
                        <td>
                            ${link.linkDescribe}
                        </td>
                        <td>
                            ${link.createDateDesc()}
                        </td>
                        <td>
                            ${link.linkStatusDesc()}
                        </td>
                        <td class="userEdit">
                            <a class="btn btn-default editLink" href="${pageContext.request.contextPath}/admin/links/${link.id}">编辑</a>
                            <button class="btn btn-warning deleteLinkOne" data-toggle="modal"
                                    nid="${pageContext.request.contextPath}/admin/links/${link.id}">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="../../model/back/back_link_edit.jsp" %>
<%@include file="../../model/back/back_link_delete.jsp" %>
</body>
</html>

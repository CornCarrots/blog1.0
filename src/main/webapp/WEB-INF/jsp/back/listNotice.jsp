<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/25
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <div class="noticeList">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
            <li class="active">公告列表</li>
        </ul>
        <div class="myNotice">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <thead>
                <tr>
                    <th class="noticeId">id</th>
                    <th>标题</th>
                    <th>内容</th>
                    <th>状态</th>
                    <th class="noticeEdit">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${notices}" var="notice">
                    <tr>
                        <td>
                            ${notice.id}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/home/notices/${notice.id}">${notice.noticeTitle}</a>
                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${fn:length(notice.noticeMdText) > 43}">
                                    ${fn:substring(notice.noticeMdText,0,40)}
                                    ...
                                </c:when>
                                <c:otherwise>
                                    ${notice.noticeMdText}
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>
                            ${notice.noticeStatusDesc()}
                        </td>
                        <td>
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/notices/${notice.id}">编辑</a>
                            <button class="btn btn-warning deleteNoticeOne" data-toggle="modal"
                                    nid="${pageContext.request.contextPath}/admin/notices/${notice.id}">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div><%@include file="../../model/back/back_notice_delete.jsp" %>
    </div>
</div>

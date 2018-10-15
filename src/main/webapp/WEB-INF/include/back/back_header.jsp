<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/21
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%--css文件--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/editormd.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/codemirror.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/dialog.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/matchesonscrollbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-select.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jcrop/jquery.Jcrop.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/article.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/categoryAndTag.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/comment.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/include.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/link.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/notice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/writeArticle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/option.css">
    <%--js文件--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-3.3.7.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jcrop/jquery.Jcrop.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/editormd.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/codemirror.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/modes.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/addons.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/marked.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/prettify.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/editormd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/Gulpfile.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/editormd.amd.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.md/editormd.amd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/include.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/writeArticle.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/comment.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/article.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/category.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/tag.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/notice.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/link.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/menu.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/user.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/option.js"></script>
</head>
<body>

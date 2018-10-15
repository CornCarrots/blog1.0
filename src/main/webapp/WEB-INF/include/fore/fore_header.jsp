<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/1
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/editormd.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/codemirror.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/dialog.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor.md/matchesonscrollbar.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-select.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/include/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/include/info.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/include/navigation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/include/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/context/article.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/context/search.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/context/text.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/context/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/context/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error/error.css">

    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-3.3.7.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-select.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.goup.min.js"></script>

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

    <script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>

    <script src="${pageContext.request.contextPath}/js/include/navigation.js"></script>
    <script src="${pageContext.request.contextPath}/js/back/include.js"></script>
    <script src="${pageContext.request.contextPath}/js/fore/register.js"></script>
    <script src="${pageContext.request.contextPath}/js/fore/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/fore/link.js"></script>
    <script src="${pageContext.request.contextPath}/js/fore/article.js"></script>
    <script src="${pageContext.request.contextPath}/js/fore/user.js"></script>
</head>
<body style="position: relative">
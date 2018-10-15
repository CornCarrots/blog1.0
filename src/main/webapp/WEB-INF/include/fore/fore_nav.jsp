<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/2
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav class="navigation">
    <div class="top_navigate">
        <div class="left_navigate">
            <c:forEach items="${parCategories}" var="cat" varStatus="st">
                <span <c:if test="${cat.id eq category.id}">class="myactive BigTitle"</c:if>>
                    <a href="${pageContext.request.contextPath}/home/categories/${cat.id}">${cat.categoryName}</a>
                </span>
            </c:forEach>
        </div>
        <div class="right_navigate pull-right">
            <form class="form-search" action="${pageContext.request.contextPath}/search" method="post">
                <div class="input-append">
                    <input type="text" class="span2 search-query" placeholder="搜索" name="key">
                    <button type="submit" class="btn">Go!</button>
                </div>
            </form>
        </div>
    </div>

    <div class="clearfix"></div>
    <div class="myHot">
        <span class="glyphicon glyphicon-volume-up">最新公告：</span>
        <span><a href="${pageContext.request.contextPath}/home/notices/${notice.id}">${notice.noticeTitle}</a></span>
    </div>

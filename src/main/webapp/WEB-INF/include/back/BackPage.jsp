<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lh.util.Page" %><%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 2018-08-02
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page">
    <nav>
        <ul class="pagination">
            <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                <a href="?start=0${page.param}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>
                <a href="?start=${page.start-page.count}${page.param}" aria-label="Previous">
                    <span aria-hidden="true">&lsaquo;</span>
                </a>
            </li>
            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <c:if test="${status.count*page.count-page.start<=20 && status.count*page.count-page.start>=-10}">
                <li>
                    <a href="?start=${status.index*page.count}${page.param}"
        <c:if test="${status.index*page.count==page.start}"> class="current"</c:if>>
                        ${status.count}
                     </a>
                </li>
                </c:if>
            </c:forEach>
            <%--<li <c:if test="${!page.hasPrevious()}">class="disabled"</c:if>>--%>
            <li <c:if test="${!page.hasNext()}">class="disabled"</c:if> >
                <a href="?page.start=${page.start+page.count}${page.param}" aria-label="Next">
                    <span aria-hidden="true">&rsaquo;</span>
                </a>
            </li>
            <li <c:if test="${!page.hasNext()}">class="disabled"</c:if> >
                <a href="?start=${page.last}${page.param}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>

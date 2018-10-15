<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/4
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">申请友链</li>
    </ul>
</div>
</nav>
<div class="link">
    <form action="${pageContext.request.contextPath}/home/links" method="post" id="linkForm">
        <table class="linkTable">
            <tr>
                <td>
                    名称 <span class="alarm">*</span>
                </td>
                <td>
                    <input type="text" class="form-control" id="linkName">
                </td>
            </tr>
            <tr>
                <td>
                    URL <span class="alarm">*</span>
                </td>
                <td>
                    <input type="text" class="form-control" id="linkUrl">
                </td>
            </tr>
            <tr>
                <td>
                    联系方式
                </td>
                <td>
                    <input type="text" class="form-control" id="linkDescribe">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <div style="width: 100%" class="btn btn-success" type="submit" id="addLink">添加</div>
                </td>
            </tr>
        </table>
    </form>

</div>

<div class="clearfix"></div>
<%@include file="../../model/fore/fore_link_add.jsp" %>
<%@include file="../../include/fore/fore_footer.jsp" %>

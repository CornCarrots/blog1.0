<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/26
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/notices">公告列表</a></li>
        <li class="active">编辑公告</li>
    </ul>
    <div class="editNotice">
        <form action="${pageContext.request.contextPath}/admin/notices/${notice.id}" method="post" id="editNoticeFrom">
            <table>
                <tr>
                    <td>
                        <label for="noticeTitle">标题<span class="alarm">*</span></label>
                    </td>
                    <td>
                        <input type="text" id="noticeTitle" name="noticeTitle" placeholder="请输入标题"
                               class="form-control" value="${notice.noticeTitle}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="my-editormd">内容<span class="alarm">*</span></label>
                    </td>
                    <td>
                        <div class="editormd" id="my-editormd">
                            <!-- 用于接受后台传递的数据 -->
                            <textarea class="editormd-markdown-textarea" name="my-editormd-markdown-do" id="my-editormd-markdown-do">${notice.noticeMdText}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td> &nbsp;
                    </td>
                    <td>
                        <button class="btn btn-success" type="button" id="editNoticeButton">修改</button>
                        <button class="btn btn-default" type="reset" id="resetNotice">重置</button>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>

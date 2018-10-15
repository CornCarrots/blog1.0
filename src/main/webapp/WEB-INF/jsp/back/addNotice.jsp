<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/26
  Time: 16:33
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
        <li class="active">添加公告</li>
    </ul>
    <div class="addNotice">
        <form action="${pageContext.request.contextPath}/admin/notices" method="post" id="addNoticeFrom">
            <table>
                <tr>
                    <td>
                        <label for="noticeTitle">标题<span class="alarm">*</span></label>
                    </td>
                    <td>
                        <input type="text" id="noticeTitle" name="noticeTitle" placeholder="请输入标题"
                               class="form-control">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="my-editormd">内容<span class="alarm">*</span></label>
                    </td>
                    <td>
                        <div class="editormd" id="my-editormd">
                            <textarea class="editormd-markdown-textarea" name="my-editormd-markdown-do"
                                      id="my-editormd-markdown-do"></textarea>
                            <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                            <!-- html textarea 需要开启配置项 saveHTMLToTextarea == true -->
                            <textarea class="editormd-html-textarea" name="my-editormd-html-code" id="my-editormd-html-code"></textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td> &nbsp;
                    </td>
                    <td>
                        <button class="btn btn-success" type="button" id="addNoticeButton">添加</button>
                        <button class="btn btn-default" type="reset" id="resetNotice">重置</button>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>

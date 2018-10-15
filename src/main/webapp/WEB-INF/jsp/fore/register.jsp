<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/1
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li class="active">注册</li>
    </ul>
</div>
</nav>
<div class="register">
    <h3>Welcome To Register</h3>
    <div style="display: none" class="existsDIV">
        账号已存在！
    </div>
    <form action="${pageContext.request.contextPath}/register" class="registerForm">
        <table class="registerTable">
            <tr>
                <td>用户名 <span class="alarm">*</span></td>
                <td><input type="text" class="form-control" id="userName" placeholder="请输入6-18位用户名"></td>
            </tr>
            <tr>
                <td>密码 <span class="alarm">*</span></td>
                <td><input type="password" class="form-control" id="userPassword"
                           placeholder="请输入6-9位密码，其中包括至少一个小写字母，一个大写字母，一个阿拉伯数字"></td>
            </tr>
            <tr>
                <td>昵称 <span class="alarm">*</span></td>
                <td><input type="text" class="form-control" id="userNickName" placeholder="请输入你的昵称"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" class="form-control" id="userEmail" placeholder="请输入你的邮箱地址"></td>
            </tr>
            <%--<tr>--%>
                <%--<td>头像</td>--%>
                <%--<td>--%>
                    <%--<span class="fileinput-button" id="selectImg">--%>
                        <%--<label for="uploadFile" class=" btn btn-default">--%>
                            <%--<i class="glyphicon glyphicon-plus"></i>--%>
                                <%--选择图片--%>
                        <%--</label>--%>
                        <%--<input id="uploadFile" name="image" type="file" style="display:none"/>--%>
                    <%--</span>--%>
                    <%--<span class="btn btn-success" id="saveImg">--%>
                        <%--<i class="glyphicon glyphicon-picture"></i>--%>
                        <%--保存头像--%>
                    <%--</span>--%>
                    <%--<br>--%>
                    <%--<img src="" alt="" id="photo">--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td colspan="2" style="text-align: center">
                    <div class="btn btn-success registerButton" style="width: 100%">立即注册</div>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <a href="${pageContext.request.contextPath}/loginPage">
                        <div class="btn btn-default" style="width: 100%">已有账号，立即登录</div>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>

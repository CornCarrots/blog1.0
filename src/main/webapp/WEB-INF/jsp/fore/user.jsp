<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/6
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/home/users/${user.id}">我的空间</a></li>
        <li class="active">个人资料</li>
    </ul>
</div>
</nav>
<div class="main">
    <div class="userInfo">
        <div class="userLeft pull-left">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}">个人资料</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/articles">我的文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/create">创建文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/comments">评论</a></li>
            </ul>
        </div>
        <div class="userRight pull-left">
            <div class="userImg">
                <div>
                    <img src="${pageContext.request.contextPath}/${user.userPhoto}" alt="" id="photo" width="110px"
                         height="110px">
                </div>
                <div class="fileinput-button" id="selectImg">
                    <label for="uploadFile" class=" btn btn-default">
                        <i class="glyphicon glyphicon-plus"></i>
                        选择图片
                    </label>
                    <input id="uploadFile" name="image" type="file" accept="image/*" style="display:none"/>
                </div>
                <div class="btn btn-success" id="saveImg">
                    <i class="glyphicon glyphicon-picture"></i>
                    保存头像
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/home/users/${user.id}" method="post">
                <table class="userTable">
                    <input type="hidden" id="uid" value="${user.id}">
                    <tr>
                        <td>
                            <label for="userName">账号<span class="alarm">*</span></label>
                        </td>
                        <td>
                            <input type="text" placeholder="请输入帐号名" id="userName" class="form-control" name="userName"
                                   value="${user.userName}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="userPassword">密码<span class="alarm">*</span></label>
                        </td>
                        <td>
                            <input type="text" placeholder="请输入密码" id="userPassword" class="form-control"
                                   name="userPassword"
                                   value="${user.userPassword}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="userNickName">昵称<span class="alarm">*</span></label>
                        </td>
                        <td>
                            <input type="text" placeholder="请输入昵称" id="userNickName" class="form-control"
                                   name="userNickName"
                                   value="${user.userNickName}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="userEmail">邮箱<span class="alarm">*</span></label>
                        </td>
                        <td>
                            <input type="email" placeholder="请输入邮箱地址" id="userEmail" class="form-control"
                                   name="userEmail"
                                   value="${user.userEmail}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <button class="btn btn-success" style="width: 50%" type="submit">修改</button>
                        </td>
                    </tr>
                </table>
            </form>


        </div>
    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>
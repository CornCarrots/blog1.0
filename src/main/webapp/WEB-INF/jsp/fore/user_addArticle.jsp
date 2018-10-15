<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/6
  Time: 17:00
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
        <li class="active">创建文章</li>
    </ul>
</div>
</nav>
<div class="main">
    <div class="userInfo">
        <div class="userLeft pull-left">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}">个人资料</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/articles">我的文章</a></li>
                <li role="presentation" class="active userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/create">创建文章</a></li>
                <li role="presentation" class="userLi"><a
                        href="${pageContext.request.contextPath}/home/users/${user.id}/comments">评论</a></li>
            </ul>
        </div>
        <div class="userRight pull-left">
            <div class="writeArticle">
                <form action="${pageContext.request.contextPath}/fore/articles" method="post" id="addArticleFrom">
                    <input type="hidden" id="second_url" value="/home/users/${user.id}/articles">
                    <table class="foreArticle">
                        <tr>
                            <td>
                                <label for="article_title">标题<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" id="article_title" name="articleTitle" placeholder="请输入标题"
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
                                    <textarea class="editormd-html-textarea" name="my-editormd-html-code"
                                              id="my-editormd-html-code"></textarea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>分类<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class="dropdown bootstrap-select">
                                        <select class="selectpicker" data-style="btn-success" tabindex="-98"
                                                name="category1" id="category1">
                                            <c:forEach items="${categories1}" var="cat">
                                                <option value="${cat.id}">${cat.categoryName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="dropdown bootstrap-select">
                                        <select class="selectpicker" data-style="btn-success" tabindex="-98"
                                                name="category2" id="category2">
                                            <c:forEach items="${categories2}" var="cat">
                                                <option value="${cat.id}">${cat.categoryName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="checkBox">标签</label>
                            </td>

                            <td>
                                <div id="checkBox">
                                    <c:forEach items="${tags}" var="tag" varStatus="st">
                                        <div class="checkbox checkbox-success checkbox-inline" style="margin: 5px">
                                            <input type="checkbox" name="tagCheckBox" class="styled" id="${tag.id}"
                                                   value="${tag.id}"<c:if test="${st.count eq 1}"> checked="" </c:if>>
                                            <label for="${tag.id}"> ${tag.tagName} </label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="radioButton"></label>
                            </td>
                            <td>
                                <div id="radioButton">
                                    <div class="radio radio-info radio-inline">
                                        <input type="radio" id="inlineRadio1" value="1" name="radioInline" checked="">
                                        <label for="inlineRadio1">发布</label>
                                    </div>
                                    <div class="radio radio-inline">
                                        <input type="radio" id="inlineRadio2" value="2" name="radioInline">
                                        <label for="inlineRadio2">草稿</label>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td> &nbsp;
                            </td>
                            <td>
                                <button class="btn btn-success addArticleButton" type="button">立即提交</button>
                                <button class="btn btn-default" type="reset" id="resetArticle">重置</button>
                            </td>
                        </tr>
                    </table>
                </form>

            </div>
        </div>

    </div>
</div>
<div class="clearfix"></div>
<%@include file="../../include/fore/fore_footer.jsp" %>
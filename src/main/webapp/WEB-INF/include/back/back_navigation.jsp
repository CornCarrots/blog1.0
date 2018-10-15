<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/21
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="back_navigation pull-left">
    <nav>
        <div class="accordion" id="accordion2">
            <div class="accordion-group">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                    <div class="accordion-heading">
                        文章
                        <div class="triangle-down"></div>
                    </div>
                </a>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/articles">全部文章</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/articles/page/add">创建文章</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/categories">全部分类</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/tags">全部标签</a>
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                    <div class="accordion-heading">
                        公告
                        <div class="triangle-down"></div>
                    </div>
                </a>
                <div id="collapseThree" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/notices">全部公告</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/notices/page/add">添加公告</a>
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
                    <div class="accordion-heading">
                        链接
                        <div class="triangle-down"></div>

                    </div>
                </a>
                <div id="collapseFive" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/links">全部链接</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/links/page/add">添加链接</a>
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSix">
                    <div class="accordion-heading">
                        菜单
                        <div class="triangle-down"></div>

                    </div>
                </a>
                <div id="collapseSix" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/menus">全部菜单</a>
                    </div>
                    <div class="accordion-inner">
                        <a href="${pageContext.request.contextPath}/admin/menus/page/add">添加菜单</a>
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <a href="${pageContext.request.contextPath}/admin/users">
                    <div class="accordion-heading">
                        用户
                    </div>
                </a>
            </div>
            <div class="accordion-group">
                <a href="${pageContext.request.contextPath}/admin/comments">
                    <div class="accordion-heading">
                        评论
                    </div>
                </a>
            </div>
            <div class="accordion-group">
                <a href="${pageContext.request.contextPath}/admin/options">
                    <div class="accordion-heading">
                        个人资料
                    </div>
                </a>
            </div>
        </div>
    </nav>
</div>

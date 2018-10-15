<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/22
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/fore/fore_header.jsp" %>
<%@include file="../../include/fore/fore_top.jsp" %>
<%@include file="../../include/fore/fore_nav.jsp" %>
<div class="bottom_navigate">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        <li>
            <a href="${pageContext.request.contextPath}/home/categories/${article.parent.id}">${article.parent.categoryName}</a>
        </li>
        <li class="active">${article.articleTitle}</li>
    </ul>
</div>
</nav>
<div class="main">
    <%@include file="../../include/fore/fore_right.jsp" %>
    <div class="test">
        <div class="MainText">
            <div class="text_title">
            <span class="text_title_left">
                <!--<span class="text_title_comment">-->
                    <a href="#comment"><span class="glyphicon glyphicon-comment"> ${article.articleComments}</span></a>
                <!--</span>-->
                <!--<span class="text_title_view">-->
                    <span class="glyphicon glyphicon-eye-open noChange"> ${article.articleViews}</span>
                <!--</span>-->
                   <a href="${pageContext.request.contextPath}/article/like/${article.id}" id="likeArticle"><span
                           class="glyphicon glyphicon-thumbs-up"> ${article.articleLikes}</span></a>
            </span>
                <span class="text_title_right">

                    <!--<span class="text_title_thumbs">-->
                    <!--</span>-->
                    <!--<span class="text_title_thumbs">-->
                    <%--<a href="#no"><span class="glyphicon glyphicon-thumbs-down"> 3</span></a>--%>
                    <!--</span>-->
                    <!--<span class="text_title_share">-->
                    <%--<a href="#share"><span class="glyphicon glyphicon-share"> 分享</span></a>--%>
                    <!-- 分享插件-->
                    <div class="title_bar">
                        <div class="bdsharebuttonbox">
                            <a href="#" class="bds_more" data-cmd="more"></a>
                            <a href="#" class="bds_qzone" data-cmd="qzone"></a>
                            <a href="#" class="bds_tsina" data-cmd="tsina"></a>
                            <a href="#" class="bds_renren" data-cmd="renren"></a>
                            <a href="#" class="bds_weixin" data-cmd="weixin"></a>
                        </div>
                        <script>window._bd_share_config = {
                        "common": {
                            "bdSnsKey": {},
                            "bdText": "",
                            "bdMini": "2",
                            "bdPic": "",
                            "bdStyle": "0",
                            "bdSize": "16"
                        },
                        "share": {},
                        "image": {
                            "viewList": ["qzone", "tsina", "renren", "weixin"],
                            "viewText": "分享到：",
                            "viewSize": "16"
                        },
                        "selectShare": {
                            "bdContainerClass": null,
                            "bdSelectMiniList": ["qzone", "tsina", "renren", "weixin"]
                        }
                    };
                    with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
                        </script>
                    </div>
            </span>
            </div>
            <div class="text_main">
                <div class="text_main_title">
                    ${article.articleTitle}
                    <br>
                    <span style="font-size: 12px;color: gray">作者：${article.user.userNickName}</span>
                </div>
                <div class="text_main_container">
                    ${article.articleHtmlText}
                </div>
            </div>
            <div class="text_category">
                所属分类：${article.parent.categoryName} ${article.children.categoryName}
            </div>
        </div>
        <div class="someText">
            <div class="text_other">
                <p class="text_other_title">相关文章</p>
                <ul>
                    <c:forEach items="${articles1}" var="art">
                        <li><a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="separate"></div>
            <div class="text_like">
                <p class="text_other_title">猜你喜欢</p>
                <ul>
                    <c:forEach items="${articles2}" var="art">
                        <li><a href="${pageContext.request.contextPath}/home/articles/${art.id}">${art.articleTitle}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="otherText">
            <c:if test="${!empty last}">
                <a href="${pageContext.request.contextPath}/home/articles/${last.id}">
                    <div class="text_prev">
                        <p>上一篇</p>
                        <c:if test="${fn:length(last.articleTitle.trim()) > 30}">
                            <span>${fn:substring(last.articleTitle.trim(),0,30)}...</span>
                        </c:if>
                        <c:if test="${fn:length(last.articleTitle.trim()) <= 30}">
                            <span>${fn:substring(last.articleTitle.trim(),0,30)}</span>
                        </c:if>
                    </div>
                </a>
            </c:if>
            <c:if test="${!empty next}">
                <a href="${pageContext.request.contextPath}/home/articles/${next.id}">
                    <div class="text_next">
                        <p>下一篇</p>

                        <c:if test="${fn:length(next.articleTitle) > 30}">
                            <span>${fn:substring(next.articleTitle.trim(),0,30)}...</span>
                        </c:if>
                        <c:if test="${fn:length(next.articleTitle) <= 30}">
                            <span>${fn:substring(next.articleTitle.trim(),0,30)}</span>
                        </c:if>
                    </div>
                </a>
            </c:if>
        </div>
        <div class="commentText" name="comment">
            <p>发表评论</p>
            <textarea class="commentText" cols="30" rows="5" style="width: 98%;">
                    <c:choose>
                        <c:when test="${empty user}">请先登录再评论</c:when>
                        <c:otherwise>评论不多于500字"</c:otherwise>
                    </c:choose>
            </textarea>
            <br>
            <input type="hidden" id="aid" value="${article.id}">
            <button id="addComment" class="btn btn-info pull-right">提交评论</button>
            <div class="clearfix"></div>
        </div>
        <div class="comment">
            <a name="comment"></a>
            <h5>评论专区</h5>
            <c:if test="${fn:length(commentWithBLOBs) eq 0}">
                <p style="text-align: center;font-size: 16px">
                    快来争当第一个评论的人吧！
                </p>
            </c:if>
            <c:forEach items="${commentWithBLOBs}" var="com" varStatus="st">
                <div class="mainComment">
                    <a name="${com.id}"></a>
                    <img src="${pageContext.request.contextPath}/${com.user.userPhoto}" alt="" class="pull-left">
                    <c:choose>
                        <c:when test="${com.user.id eq article.user.id}">
                            <p class="commentName">楼主</p>
                        </c:when>
                        <c:otherwise>
                            <p class="commentName">${com.user.userNickName}</p>
                        </c:otherwise>
                    </c:choose>
                    <p>${com.createDateDesc()}
                        <span>${st.count}楼</span>
                        <a href="#no" class="response">回复</a>
                    </p>
                        ${com.commentMdText}
                    <c:if test="${!empty com.child}">
                        <c:forEach items="${com.child}" var="cld" varStatus="st1">
                            <div class="otherComment">
                                <a name="${cld.id}"></a>
                                <img src="${pageContext.request.contextPath}/${cld.user.userPhoto}" alt=""
                                     class="pull-left">
                                <c:choose>
                                    <c:when test="${cld.user.id eq article.user.id}">
                                        <p class="commentName">楼主</p>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${cld.user.id eq com.user.id}">
                                                <p class="commentName">层主</p>
                                            </c:when>
                                            <c:otherwise>
                                                <p class="commentName">${cld.user.userNickName}</p>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                                <p> ${cld.createDateDesc()} <span>${st1.count}层</span></p>
                                    ${cld.commentMdText}
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                <div class="responseDIV" style="display: none">
                    <textarea class="commentText" cols="95" rows="5"><c:choose>
                        <c:when test="${empty user}">请先登录再评论</c:when>
                        <c:otherwise>评论不多于500字"</c:otherwise>
                    </c:choose>
                    </textarea>
                    <br>
                    <input type="hidden" class="pid" value="${com.id}">
                    <button class="btn btn-info pull-right addResponse">提交评论</button>
                    <div class="clearfix"></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<script type="text/javascript">
    $(document).ready(function () {
        $.goup({
            trigger: 100,
            bottomOffset: 10,
            locationOffset: 60,
            // title: 'Top',
            titleAsText: true
        });
    });
</script>
<%@include file="../../model/fore/fore_login.jsp" %>
<%@include file="../../include/fore/fore_footer.jsp" %>
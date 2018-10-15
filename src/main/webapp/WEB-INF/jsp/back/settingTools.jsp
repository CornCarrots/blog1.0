<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/28
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../include/back/back_header.jsp" %>
<%@include file="../../include/back/back_top.jsp" %>
<%@include file="../../include/back/back_navigation.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/index">首页</a></li>
        <li class="active">基本信息</li>
    </ul>
    <div class="mySetting">
        <div id="myTabContent" class="tab-content">
            <div id="information">
                <table class="information_table">
                    <tr>
                        <td>
                            站点名称
                        </td>
                        <td>
                            <input type="text" class="form-control updateOption" id="${name.optionKey}"
                                   value="${name.optionValue}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            站点描述
                        </td>
                        <td>
                            <input type="text" class="form-control updateOption" id="${describe.optionKey}"
                                   value="${describe.optionValue}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            首页关键词
                        </td>
                        <td>
                            <input type="text" class="form-control updateOption" id="${key.optionKey}"
                                   value="${key.optionValue}">
                        </td>
                    </tr>
                    <tr>
                        <td style="vertical-align: top">
                            首页LOGO
                            <br>
                            <br>
                            <span style="color:#999">(150px*150px)</span>
                        </td>
                        <td class="jcrop-holder">
                            <%--<img src="${pageContext.request.contextPath}/${photo.optionValue}" alt="" width="100px"--%>
                            <%--height="100px" name="siteLOGO"/>--%>
                            <img src="${pageContext.request.contextPath}/${photo.optionValue}" id="realPic"
                                 width="300px" height="300px"/>
                            <!-- 缩略图预览 -->
                            <div id="preview-pane">
                                <div class="preview-container">
                                    <img src="${pageContext.request.contextPath}/${photo.optionValue}" width="150px"
                                         height="150px"/>
                                </div>
                            </div>
                            <div class="Imagecontainer">
                                <!-- 打开图片控制 -->
                                <span class="fileinput-button">
                                     <label for="uploadFile" class=" btn btn-default">
                                         <i class="glyphicon glyphicon-plus"></i>
                                         选择图片
                                     </label>
                                    <input id="uploadFile" type="file" style="display:none"
                                           onchange="ajaxFileUpload()"/>
                                </span>

                                <!--
                                这种做法IE不支持，拒绝访问.
                                <input id="realPicFile" value="选择图片" onchange="ajaxFileUpload()" type="file" style="display: none;" name="realPicFile" />
                                <a class="btn btn-success" href="javascript:selectPic();" > <i class="icon-plus icon-white"></i>
                                     选择图片
                                </a>
                                 -->
                                <!-- 上传并裁剪图片 -->
                                <img src="" id="loading" style="display: none;"/>
                                <a class="btn btn-success" href="javascript:cutPic();">
                                    <i class="glyphicon glyphicon-picture"></i>
                                    保存头像
                                </a>
                                <!-- 获取裁剪的起始坐标和宽度、高度给后台 -->
                                <form id="coords" class="coords">
                                    <div class="inline-labels">
                                        <input type="hidden" size="4" id="x1" name="x1"/>
                                        <input type="hidden" size="4" id="y1" name="y1"/>
                                        <input type="hidden" size="4" id="x2" name="x2"/>
                                        <input type="hidden" size="4" id="y2" name="y2"/>
                                        <input type="hidden" size="4" id="w" name="w"/>
                                        <input type="hidden" size="4" id="h" name="h"/>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>

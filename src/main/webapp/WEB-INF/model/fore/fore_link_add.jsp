<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/10/4
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div id="addLinkModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addLinkModel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="height: 120px">
            <div class="modal-body">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="deleteLinkNo">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" style="text-align: center">申请成功</h4>
            </div>
            <div class="modal-body" style="text-align: center">
                <a href="${pageContext.request.contextPath}/home" class="btn btn-default" type="button">确定</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div><!-- /.modal-content -->
</div>

<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/22
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="deleteCategoryModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="deleteCategoryModel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="height: 120px">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="deleteCategoryNo">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" style="text-align: center">是否删除？</h4>
            </div>
            <div class="modal-body" style="text-align: center;display: none">
                <span id="deleteCategoryError" style="color: red;font-size: 14px"></span>
            </div>
            <div class="modal-footer" style="text-align: center">
                <a href="" class="btn btn-default" id="deleteCategoryConfirm">确定</a>
                <button data-dismiss="modal" class="btn btn-default deleteCategoryNo" type="button">取消</button>
            </div>
            <div class="clearfix"></div>
        </div>
    </div><!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->

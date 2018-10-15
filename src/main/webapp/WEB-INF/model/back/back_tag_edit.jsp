<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/25
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="editTagModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="editTagModel"
     aria-hidden="true">
    <div class="modal-dialog editTagModelDialog">
        <div class="modal-content editTagModelContent">
            <form action="${pageContext.request.contextPath}/admin/tags" method="post" id="editTagForm">
                <input type="hidden" name="_method" value="PUT">
                <input type="hidden" name="id" id="tagIDEdit">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="editTagNo">×</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" style="text-align: center">编辑分类</h4>
                </div>
                <div class="modal-body">
                    <table class="editTagTable">
                        <tr>
                            <td>
                                <label for="tagNameEdit">名称<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入标签名称" id="tagNameEdit" class="form-control" name="tagName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="tagDescripateEdit">描述</label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入标签描述" id="tagDescripateEdit" class="form-control" name="tagDescripe">
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button class="btn btn-default" type="submit">确定</button>
                    <button data-dismiss="modal" class="btn btn-default editTagNo" type="button">取消</button>
                </div>
                <div class="clearfix"></div>
            </form>

        </div>
    </div><!-- /.modal-content -->
</div>

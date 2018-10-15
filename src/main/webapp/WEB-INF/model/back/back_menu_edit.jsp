<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/27
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="editMenuModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="editMenuModel"
     aria-hidden="true">
    <div class="modal-dialog editMenuModelDialog">
        <div class="modal-content editMenuModelContent">
            <form action="" method="post" id="editMenuForm">
                <input type="hidden" name="_method" value="PUT">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="editMenuNo">×</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" style="text-align: center">编辑分类</h4>
                </div>
                <div class="modal-body">
                    <table class="editMenuTable">
                        <tr>
                            <td>
                                <label for="menuNameEdit">名称<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入标签名称" id="menuNameEdit" class="form-control" name="menuName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="menuLinkEdit">URL</label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入菜单URL" id="menuLinkEdit" class="form-control" name="menuLink">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="menuIconEdit">icon</label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入菜单URL" id="menuIconEdit" class="form-control" name="menuIcon">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="menuRoleEdit">菜单位置</label>
                            </td>
                            <td>

                                <select class="selectpicker" data-style="btn-default" tabindex="-98" name="menuRole" id="menuRoleEdit">
                                    <option value="1">顶部菜单</option>
                                    <option value="2">导航栏菜单</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button class="btn btn-default" type="submit">确定</button>
                    <button data-dismiss="modal" class="btn btn-default editMenuNo" type="button">取消</button>
                </div>
                <div class="clearfix"></div>
            </form>

        </div>
    </div><!-- /.modal-content -->
</div>

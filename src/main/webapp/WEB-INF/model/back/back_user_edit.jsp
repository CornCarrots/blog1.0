<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/27
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="editUserModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="editUserModel"
     aria-hidden="true">
    <div class="modal-dialog editUserModelDialog">
        <div class="modal-content editUserModelContent">
            <form action="" method="post" id="editUserForm">
                <input type="hidden" name="_method" value="PUT">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="editUserNo">×</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" style="text-align: center">编辑用户</h4>
                </div>
                <div class="modal-body">
                    <table class="editUserTable">
                        <tr>
                            <td>
                                <label for="userNameEdit">账号<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入帐号名" id="userNameEdit" class="form-control" name="userName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="userPasswordEdit">密码<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入密码" id="userPasswordEdit" class="form-control" name="userPassword">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="userNickNameEdit">昵称<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入昵称" id="userNickNameEdit" class="form-control" name="userNickName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="userPhotoEdit">头像<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入头像路径" id="userPhotoEdit" class="form-control" name="userPhoto">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="userEmailEdit">邮箱<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="email" placeholder="请输入邮箱地址" id="userEmailEdit" class="form-control" name="userEmail">
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button class="btn btn-default" type="submit">确定</button>
                    <button data-dismiss="modal" class="btn btn-default editUserNo" type="button">取消</button>
                </div>
                <div class="clearfix"></div>
            </form>

        </div>
    </div><!-- /.modal-content -->
</div>


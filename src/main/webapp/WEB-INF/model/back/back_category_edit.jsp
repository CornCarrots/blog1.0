<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 林浩
  Date: 2018/9/22
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="editCategoryModel" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="editCategoryModel"
     aria-hidden="true">
    <div class="modal-dialog editCategoryModelDialog">
        <div class="modal-content editCategoryModelContent">
            <form action="${pageContext.request.contextPath}/admin/categories" method="post" id="editCategoryForm" enctype="multipart/form-data">
                <input type="hidden" name="_method" value="PUT">
                <input type="hidden" name="id" id="categoryIDEdit">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true" class="editCategoryNo">×</span><span
                            class="sr-only">Close</span></button>
                    <h4 class="modal-title" style="text-align: center">编辑分类</h4>
                </div>
                <div class="modal-body">
                    <table class="editCategoryTable">
                        <tr>
                            <td>
                                <label for="categoryNameEdit">名称<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入分类名称" id="categoryNameEdit" class="form-control" name="categoryName">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="categoryParentEdit">父节点<span class="alarm">*</span></label>
                            </td>
                            <td>
                                <select  class="selectpicker" data-style="btn-success" tabindex="-98" id="categoryParentEdit" name="pid">
                                    <option value="0">无</option>
                                    <c:forEach items="${categories1}" var="cat">
                                        <option value="${cat.id}">${cat.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="categoryDescripateEdit">描述</label>
                            </td>
                            <td>
                                <input type="text" placeholder="请输入分类描述" id="categoryDescripateEdit" class="form-control" name="categoryDescripe">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="categoryPicEdit">图片</label>
                            </td>
                            <td>
                                <input type="text" placeholder="分类图片" id="categoryPicEdit" class="form-control" name="image">
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button class="btn btn-default" type="submit">确定</button>
                    <button data-dismiss="modal" class="btn btn-default editCategoryNo" type="button">取消</button>
                </div>
                <div class="clearfix"></div>
            </form>

        </div>
    </div><!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
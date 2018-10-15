$(
    function () {
        $(".editOneCategory").click(
            function () {
                var button = $(this).parent();
                var id = $(this).attr("cid");
                var name = button.prev().prev().prev().text().trim();
                var desc = button.prev().prev().prev().prev().text().trim();
                $("#categoryIDEdit").val(id);
                $("#categoryNameEdit").val(name);
                $("#categoryDescripateEdit").val(desc);
                $("#editCategoryModel").modal('show');
            }
        );
        $(".editCategoryNo").click(
            function () {
                // var url = $("#editCategoryForm").attr("action");
                // $("#editCategoryForm").attr("action",url.substring(0,url.lastIndexOf("/")+1));
                $("#categoryIDEdit").val("");
                $("#categoryNameEdit").val("");
                $("#categoryDescripateEdit").val("");
            }
        );
        $(".deleteOneCategory").click(
            function () {
                var url = $(this).attr("cid");
                $("#deleteCategoryConfirm").attr("href",url);
                $("#deleteCategoryModel").modal('show');
            }
        );
        $("#deleteCategoryConfirm").click(
            function () {
                var url = $(this).attr("href");
                $.ajax(
                    {
                        type: "delete",
                        url: url,
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function (data) {
                            if (data.result == "success") {
                                location.href = url.substring(0, url.lastIndexOf("/"));
                            }
                            else if (data.result == "child") {
                                $(".modal-content").css("height","170px");
                                $(".modal-body").show();
                                $("#deleteCategoryError").text("请先删除子分类！");
                            }
                            else {
                                console.log(data);
                            }
                        }
                    }
                );
                return false;
            }
        );
        $(".deleteCategoryNo").click(
            function () {
                $(".modal-content").css("height","120px");
                $(".modal-body").hide();
                $("#deleteCategoryError").text("");
            }
        );
    }
);
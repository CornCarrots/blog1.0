$(
    function () {
        $(".editOneTag").click(
            function () {
                var button = $(this).parent();
                var id = $(this).attr("cid");
                var desc = button.prev().prev().prev().text().trim();
                var name = button.prev().prev().prev().prev().text().trim();
                $("#tagIDEdit").val(id);
                $("#tagNameEdit").val(name);
                $("#tagDescripateEdit").val(desc);
                $("#editTagModel").modal('show');
            }
        );
        $(".editTagNo").click(
            function () {
                // var url = $("#editCategoryForm").attr("action");
                // $("#editCategoryForm").attr("action",url.substring(0,url.lastIndexOf("/")+1));
                $("#tagIDEdit").val("");
                $("#tagNameEdit").val("");
                $("#tagDescripateEdit").val("");
            }
        );
        $(".deleteOneTag").click(
            function () {
                var url = $(this).attr("tid");
                $("#deleteTagConfirm").attr("href",url);
                $("#deleteTagModel").modal('show');
            }
        );
        $("#deleteTagConfirm").click(
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
                                $("#deleteTagError").text("已有文章使用此分类！");
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
        $(".deleteTagNo").click(
            function () {
                $(".modal-content").css("height","120px");
                $(".modal-body").hide();
                $("#deleteTagError").text("");
            }
        );
    }
);
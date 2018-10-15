$(
    function () {
        $(".editMenu").click(
            function () {
                var button = $(this).parent();
                var url = $(this).attr("href");
                $("#editMenuForm").attr("action",url);
                var name = button.prev().prev().prev().text().trim();
                var link = button.prev().prev().text().trim();
                var icon = button.prev().text().trim();
                $("#menuNameEdit").val(name);
                $("#menuLinkEdit").val(link);
                $("#menuIconEdit").val(icon);
                $("#editMenuModel").modal("show");
                return false;
            }
        );
        $(".editMenuNo").click(
            function () {
                $("#editMenuForm").attr("action","");
                $("#menuNameEdit").val("");
                $("#menuLinkEdit").val("");
                $("#menuIconEdit").val("");
            }
        );
        $(".deleteMenuOne").click(
            function () {
                var url = $(this).attr("nid");
                $("#deleteMenuForm").attr("action",url);
                $("#deleteMenuModel").modal("show");
            }
        );
        $("#deleteConfirm").click(
            function () {
                $("#deleteMenuForm").submit();
            }
        );
        $(".deleteMenuNo").click(
            function () {
                $("#deleteMenuForm").attr("action","");
            }
        );
    }
);
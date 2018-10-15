$(
    function () {
        $(".editLink").click(
            function () {
                var button = $(this).parent();
                var url = $(this).attr("href");
                $("#editLinkForm").attr("action",url);
                var name = button.prev().prev().prev().prev().prev().text().trim();
                var url = button.prev().prev().prev().prev().text().trim();
                var desc = button.prev().prev().prev().text().trim();
                $("#linkNameEdit").val(name);
                $("#linkUrlEdit").val(url);
                $("#linkDescribeEdit").val(desc);
                $("#editLinkModel").modal("show");
                return false;
            }
        );
        $(".editLinkNo").click(
            function () {
                $("#linkNameEdit").val("");
                $("#linkUrlEdit").val("");
                $("#linkDescribeEdit").val("");
                $("#editLinkForm").attr("action","");
            }
        );
        $(".deleteLinkOne").click(
            function () {
                var url = $(this).attr("nid");
                $("#deleteLinkForm").attr("action",url);
                $("#deleteLinkModel").modal("show");
            }
        );
        $("#deleteLinkConfirm").click(
            function () {
                $("#deleteLinkForm").submit();
                return false;
            }
        );
        $(".deleteLinkNo").click(
            function () {
                $("#deleteLinkForm").attr("action","");
            }
        );
    }
);
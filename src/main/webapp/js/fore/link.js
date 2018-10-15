$(
    function () {
        $("#addLink").click(
            function () {
                var name = $("#linkName").val();
                var link = $("#linkUrl").val();
                var desc = $("#linkDescribe").val();
                var url = $("#linkForm").attr("action");
                var link = {
                    "name": name,
                    "link": link,
                    "desc": desc
                };
                $.ajax(
                    {
                        type: "post",
                        url: url,
                        dataType: "json",
                        contentType: "application/json;charset=utf8",
                        data: JSON.stringify(link),
                        success: function (data) {
                            if (data.result == "success")
                                $("#addLinkModel").modal("show");
                        }
                    }
                );
            }
        );

    }
);
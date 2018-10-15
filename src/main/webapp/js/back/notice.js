$(
    function () {
        $("#resetNotice").click(
            function () {
                $(".fa-eraser").trigger("click");
            }
        );
        $("#addNoticeButton").click(
            function () {
                var  title = $("#noticeTitle").val();
                var text = $(".editormd-html-textarea").text();
                text = text.substring(0,text.length/2);
                var md = $(".editormd-markdown-textarea").text();
                md = md.substring(0,md.length-text.length);
                var notice = {
                    "noticeTitle":title,
                    "noticeHtmlText":text,
                    "noticeMdText":md
                };
                console.log(notice);
                var url = $("#addNoticeFrom").attr("action");
                $.ajax(
                    {
                        type:"post",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        data:JSON.stringify(notice),
                        success:function (data) {
                            if(data.result=="success")
                            {
                                location.href=url;
                            }
                            else if(data.result="fail")
                            {
                                console.log(data);
                            }
                        }
                    }
                );
                return false;
            }
        );
        $("#editNoticeButton").click(
            function () {
                var  title = $("#noticeTitle").val();
                var text = $(".editormd-html-textarea").text();
                // text = text.substring(0,text.length/2);
                var md = $(".editormd-markdown-textarea").text();
                // md = md.substring(0,md.length-text.length);
                var notice = {
                    "noticeTitle":title,
                    "noticeHtmlText":text,
                    "noticeMdText":md
                };
                console.log(notice);
                var url = $("#editNoticeFrom").attr("action");
                $.ajax(
                    {
                        type:"put",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        data:JSON.stringify(notice),
                        success:function (data) {
                            if(data.result=="success")
                            {
                                location.href=url.substring(0,url.lastIndexOf("/"));
                            }
                            else if(data.result="fail")
                            {
                                console.log(data);
                            }
                        }
                    }
                );
                return false;
            }
        );
        $(".deleteNoticeOne").click(
            function () {
                var url = $(this).attr("nid");
                $("#deleteNoticeForm").attr("action",url);
                $("#deleteNoticeModel").modal("show");
            }
        );
        $("#deleteConfirm").click(
            function () {
                $("#deleteNoticeForm").submit();
                return false;
            }
        );
        $(".deleteNoticeNo").click(
            function () {
                $("#deleteNoticeForm").attr("action","");
            }
        );
    }
);
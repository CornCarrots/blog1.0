$(
    function () {
        $(".deleteComment").click(
            function () {
                var url = $(this).attr("href");
                var comment = $(this).parent().parent();
                if(comment.attr("class")=="waitComment_table_text"||comment.attr("class")=="allComment_table_text")
                    comment = $(this).parent().parent().parent();
                $.ajax(
                    {
                        type:"delete",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        async:true,
                        success:function (data) {
                            if(data.result=="success")
                            {
                                comment.hide();
                                console.log("success");
                            }
                            else {
                                console.log("fail");
                            }
                        }
                    }
                );
                return false;
            }
        );
        $(".editComment").click(
            function () {
                var url = $(this).attr("href");
                var parent = $(this).parent();
                var text = "";
                $.ajax(
                    {
                        type:"put",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        success:function (data) {
                            if(data.result=="success")
                            {
                                console.log("success");
                                location.reload();
                            }
                            else {
                                console.log("fail");
                            }
                        }
                    }
                );
                return false;
            }
        );
    }
);



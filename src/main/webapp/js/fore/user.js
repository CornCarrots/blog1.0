$(
    function () {
        $(".allComment_table_text").hover(
            function () {
                $(this).find(".allComment_table_edit").css("visibility", "visible");
            }
        );
        $(".allComment_table_text").mouseleave(
            function () {
                $(this).find(".allComment_table_edit").css("visibility", "hidden");
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
        // $(".userLi").click(
        //     function () {
        //         $(".userLi").removeClass(active);
        //         $(this).addClass(active);
        //     }
        // );
        $("#resetArticle").click(
            function () {
                $(".selectpicker").each(
                    function () {
                        var text = $($(this).children(":first").get(0)).text();
                        $(this).next().find(".filter-option-inner-inner").text(text);
                        $(this).next().attr("title",text);
                    }
                );
                $(".fa-eraser").trigger("click");
            }
        );
        $(".addArticleButton").click(
            function () {
                var  title = $("#article_title").val();
                var text = $(".editormd-html-textarea").text();
                text = text.substring(0,text.length/2);
                var md = $(".editormd-markdown-textarea").text();
                md = md.substring(0,md.length-text.length);
                var category1 = $("#category1 option:selected").val();
                var category2 = $("#category2 option:selected").val();
                var tags ='';
                $("input[name='tagCheckBox']:checked").each(
                    function () {
                        tags+=$(this).val()+",";
                    }
                );
                tags = tags.substring(0,tags.length-1);
                var type = $("input[type='radio']:checked").val();
                var article = {
                    "articleTitle":title,
                    "articleHtmlText":text,
                    "articleMdText":md,
                    "category1":category1,
                    "category2":category2,
                    "tags":tags,
                    "type":type
                };
                // console.log(article);
                var url = $("#addArticleFrom").attr("action");
                var second = getContentPath()+$("#second_url").val();
                $.ajax(
                    {
                        type:"post",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        data:JSON.stringify(article),
                        success:function (data) {
                            if(data.result=="success")
                            {
                                location.href=second;
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
        $(".updateArticleButton").click(
            function () {
                var  title = $("#article_title").val();
                var text = $(".editormd-html-textarea").text();
                // text = text.substring(0,text.length/2);
                var md = $(".editormd-markdown-textarea").text();
                // md = md.substring(0,md.length-text.length);
                var category1 = $("#category1 option:selected").val();
                var category2 = $("#category2 option:selected").val();
                var tags ='';
                $("input[name='tagCheckBox']:checked").each(
                    function () {
                        tags+=$(this).val()+",";
                    }
                );
                tags = tags.substring(0,tags.length-1);
                var type = $("input[type='radio']:checked").val();
                var articleId = $("#articleId").val();
                var article = {
                    "articleTitle":title,
                    "articleHtmlText":text,
                    "articleMdText":md,
                    "category1":category1,
                    "category2":category2,
                    "tags":tags,
                    "type":type,
                    "articleId":articleId
                };
                console.log(article);
                var url = $("#updateArticleFrom").attr("action");
                var second = getContentPath()+$("#second_url").val();
                $.ajax(
                    {
                        type:"put",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf-8",
                        data:JSON.stringify(article),
                        success:function (data) {
                            if(data.result=="success")
                            {
                                location.href=second;
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
        $(".deleteArticleOne").click(
            function () {
                var id = $(this).attr("aid");
                var url = $(".deleteArticle").attr("href");
                $(".deleteArticle").attr("href",url+"/"+id);
                $("#deleteArticleModel").modal('show');
            }
        );
        $(".deleteArticle").click(
            function () {
                var url = $(this).attr("href");
                $("#deleteArticleForm").attr("action",url).submit();
                return false;
            }
        );
        $(".deleteArticleNo").click(
            function () {
                var url = $(".deleteArticle").attr("href");
                $(".deleteArticle").attr("href",url.substring(0,url.lastIndexOf("/")));

            }
        );
    }
);
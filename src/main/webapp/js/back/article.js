var check1 = false;
var check2 = false;
$(
    function () {

        $("#published_table_checkAll input").click(
            function () {
                if(!check1)
                {
                    $(".published_table_check input").prop("checked",true);
                    check1 = true;
                }
                else
                {
                    $(".published_table_check input").prop("checked",false);
                    check1 = false;
                }
            }
        );
        $("#draft_table_checkAll input").click(
            function () {
                if(!check2)
                {
                    $(".draft_table_check input").prop("checked",true);
                    check2 = true;
                }
                else
                {
                    $(".draft_table_check input").prop("checked",false);
                    check2 = false;
                }
            }
        );
        $(".deletePublishArticleAll").click(
            function () {
                var url = $(".deleteArticle").attr("href");
                var ids = '';
                $("input[name='publishCheckBox']:checked").each(
                    function () {
                        ids+=$(this).val()+",";
                    }
                );
                ids = ids.substring(0,ids.length-1);
                $(".deleteArticle").attr("href",url+"/"+ids);
                $("#deleteArticleModel").modal('show');
            }
        );
        $(".deleteDraftArticleAll").click(
            function () {
                var url = $(".deleteArticle").attr("href");
                var ids = '';
                $("input[name='draftCheckBox']:checked").each(
                    function () {
                        ids+=$(this).val()+",";
                    }
                );
                ids = ids.substring(0,ids.length-1);
                $(".deleteArticle").attr("href",url+"/"+ids);
                $("#deleteArticleModel").modal('show');
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
                console.log(article);
                var url = $("#addArticleFrom").attr("action");
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
    }
);
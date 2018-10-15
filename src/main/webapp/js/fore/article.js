
var url = getContentPath() + "/checkLogin";
var click = false;
$(
    function () {
        $(".loginButtonAjax").click(
            function () {
                var url = $("#loginForm").attr("action");
                var name = $("#loginName").val();
                var pass = $("#loginPass").val();
                var user = {
                    "userName": name,
                    "userPassword": pass
                };
                $.ajax(
                    {
                        type: "post",
                        url: url,
                        dataType: "json",
                        contentType: "application/json;charset=utf8",
                        data: JSON.stringify(user),
                        success: function (data) {
                            if (data.result == "fail")
                                $(".errorDIV").show();
                            else
                                location.reload();
                        }
                    }
                );
                return false;
            }
        );
        $(".commentText").click(
            function () {
                var comment = $(this);
                $.ajax(
                    {
                        type: "get",
                        url: url,
                        dataType: "json",
                        success: function (data) {
                            if (data.result == "no")
                                $("#loginModel").modal("show");
                            else
                                comment.focus();
                        }
                    }
                );
            }
        );
        $("#addComment").click(
            function () {
                var button = $(this);
                $.ajax(
                    {
                        type: "get",
                        url: url,
                        dataType: "json",
                        success: function (data) {
                            if (data.result == "no")
                                $("#loginModel").modal("show");
                            else {
                                var comment = button.prev().prev().prev().val().trim();
                                var aid = $("#aid").val();
                                var pid = 0;
                                var json = {
                                    "comment": comment,
                                    "aid": aid,
                                    "pid": pid
                                };
                                var url = getContentPath() + "/commitComment";
                                $.ajax(
                                    {
                                        type: "post",
                                        url: url,
                                        dataType: "json",
                                        contentType: "application/json;charset=utf8",
                                        data: JSON.stringify(json),
                                        success: function (data) {
                                            if (data.result == "success")
                                                location.reload();
                                            else
                                                console.log(data);
                                        }
                                    }
                                );
                            }
                        }
                    }
                );
                return false;
            }
        );
        $(".response").click(
            function () {
                var res = $(this);
                $.ajax(
                    {
                        type: "get",
                        url: url,
                        dataType: "json",
                        success: function (data) {
                            if (data.result == "no")
                                $("#loginModel").modal("show");
                            else {
                                if (!click) {
                                    res.parent().parent().next().slideToggle();
                                    res.parent().parent().next().children().focus();
                                    click = !click;
                                }
                                else {
                                    res.parent().parent().next().slideToggle();
                                    click = !click;
                                }
                            }
                        }
                    }
                );
                return false
            }
        );
        $(".addResponse").click(
            function () {
                var comment = $(this).prev().prev().prev().val().trim();
                var aid = $("#aid").val();
                var pid = $(this).prev().val();
                var json = {
                    "comment": comment,
                    "aid": aid,
                    "pid": pid
                };
                var url = getContentPath() + "/commitComment";
                $.ajax(
                    {
                        type: "post",
                        url: url,
                        dataType: "json",
                        contentType: "application/json;charset=utf8",
                        data: JSON.stringify(json),
                        success: function (data) {
                            if (data.result == "success")
                                location.reload();
                        }
                    }
                );
            }
        );
        var testEditor;
        testEditor = $(function () {
            editormd("my-editormd", {
                width: "90%",
                height: 400,
                //markdown : md,
                codeFold: true,
                syncScrolling: "single",
                //你的lib目录的路径
                path: getContentPath() + "/js/editor.md/lib/",
                saveHTMLToTextarea: true,
                imageUpload: true,
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                // imageUploadURL: path+"/upload/article",
                imageUploadURL: getContentPath() + "/admin/articles/editormdPic",
                onload: function () {
                    console.log('onload', this);
                },
                /*  theme: "dark",//工具栏主题
                 previewTheme: "dark",//预览主题
                 editorTheme: "pastel-on-dark",//编辑主题 */
                emoji: true,
                // taskList: true,
                // tocm: true,         // Using [TOCM]
                // tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                // flowChart: true,             // 开启流程图支持，默认关闭
                // sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
                //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
                watch: false,
                toolbarAutoFixed: false,
                toolbarIcons: function () {
                    // Or return editormd.toolbarModes[name]; // full, simple, mini
                    // Using "||" set icons align right.
                    return ["bold", "italic", "|", "del", "hr", "|", "link", "image", "code", "emoji", "html-entities", "||", "watch", "fullscreen", "preview", "clear"]
                }

            });
        });

    }
);
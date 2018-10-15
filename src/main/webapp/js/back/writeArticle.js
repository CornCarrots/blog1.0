$(
    function () {
        $(".dropdown-menu li a").click(
            function () {
                var text = $(this).text();
                $(this).parent().parent().prev().html(text + "<span class=\"caret\"></span>");
            }
        );
        var path = location.pathname;
        path = path.substr(0, path.substr(1).indexOf("/") + 1);
        var testEditor;
        testEditor = $(function () {
            editormd("my-editormd", {
                width: "100%",
                height: 440,
                //markdown : md,
                codeFold: true,
                syncScrolling: "single",
                //你的lib目录的路径
                path: path + "/js/editor.md/lib/",
                saveHTMLToTextarea: true,
                imageUpload: true,
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                // imageUploadURL: path+"/upload/article",
                imageUploadURL: path + "/admin/articles/editormdPic",
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

        // var testEditormdView;
        // $(function () {
        //     testEditormdView = editormd.markdownToHTML("doc-content", {//注意：这里是上面DIV的id
        //         htmlDecode: "style,script,iframe",
        //         emoji: true,
        //         taskList: true,
        //         tex: true, // 默认不解析
        //         flowChart: true, // 默认不解析
        //         sequenceDiagram: true, // 默认不解析
        //         codeFold: true
        //     });
        // });

    }
);
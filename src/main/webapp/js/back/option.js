function updatePreview(c) {
    if (parseInt(c.w) > 0) {
        $('#x1').val(c.x);
        $('#y1').val(c.y);
        $('#x2').val(c.x2);
        $('#y2').val(c.y2);
        $('#w').val(c.w);
        $('#h').val(c.h);

        var rx = xsize / c.w;
        var ry = ysize / c.h;

        // 精确计算图片的位置
        $pimg.css({
            width: Math.round(rx * boundx) + 'px',
            height: Math.round(ry * boundy) + 'px',
            marginLeft: '-' + Math.round(rx * c.x) + 'px',
            marginTop: '-' + Math.round(ry * c.y) + 'px'
        });
    }
};

function ajaxFileUpload() {
    $("#loading").ajaxStart(function () {
        $(this).show();
    }).ajaxComplete(function () {
        $(this).hide();
    });
    var file = $("#uploadFile").val();
    $.ajaxFileUpload
    (
        {
            url: '/upload.aspx', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'uploadFile', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                path = getContentPath() + data.path + "?" + Math.random();
                $("#realPic").attr("src", path);
                var imgs = $(".jcrop-holder").find("img");
                imgs.each(function (i, v) {
                    $(this).attr("src", path);
                });
                $('#preview-pane .preview-container img').attr("src", path);
                var preview = $('#preview-pane');
                var cnt = $('#preview-pane .preview-container');
                $pimg = $('#preview-pane .preview-container img'), xsize = $pcnt.width(), ysize = $pcnt.height();
                if (typeof (data.error) != 'undefined') {
                    if (data.error != '') {
                        alert(data.error);
                    } else {
                        alert(data.msg);
                    }
                }
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        }
    )
    return false;
};
$(
    function () {
        $(".updateOption").blur(
            function () {
                var key = $(this).attr("id");
                var value = $(this).val();
                var option = {
                    "key": key,
                    "value": value
                };
                var path = document.location.pathname;
                path = path.substring(0, path.substring(1).indexOf("/") + 1);
                $.ajax(
                    {
                        type: "put",
                        url: path + "/admin/options",
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(option),
                        success: function (data) {
                            if (data.result == "success") {
                                console.log("yes");
                            }
                            else {
                                console.log("error");
                            }
                        }
                    }
                );
            }
        );
        $(":button").click(function () {
            ajaxFileUpload();
        })
    }
);
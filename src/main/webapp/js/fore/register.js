var name;
var uid = $("#uid").val();
function ajaxFileUpload(){
    $.ajaxFileUpload
    (
        {
            url: getContentPath()+"/register/image", //用于文件上传的服务器端请求地址
            type: 'post',
            data: {
                uid: uid,
                name:name
                    },
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'uploadFile', //文件上传域的ID
            dataType: 'text', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                var data=eval("("+data+")")
                if (typeof (data.error) != 'undefined') {
                    if (data.error != '') {
                        alert(data.error);
                    } else {
                        alert(data.msg);
                        $("#photo").attr("src", data.imgurl);
                    }
                }
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                console.log(data);
                console.log(e);
                console.log(status);
            }
        }
    );
};
$(
    function () {
        $("#saveImg").click(function () {
            //效验上传图片类型
            var ths=$('#uploadFile');
            if (ths.val().length <= 0)
            {
                alert("请上传图片");
                return false;
            }
            else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths.val())){
                alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
                ths.val("");
                return false;
            }
            //效验成功调用异步上传函数
            name = ths.val().substring(ths.val().lastIndexOf(".")+1,ths.val().length);
            ajaxFileUpload();
            return false;
        });

        $(".registerButton").click(
            function () {
                var url = $('.registerForm').attr("action");
                var userName = $("#userName").val();
                var userPassword = $("#userPassword").val();
                var userNickName = $("#userNickName").val();
                var userEmail = $("#userEmail").val();
                var user = {
                    "userEmail":userEmail,
                    "userNickName":userNickName,
                    "userName":userName,
                    "userPassword":userPassword
                };
                $.ajax(
                    {
                        type:"post",
                        url:url,
                        dataType:"json",
                        contentType:"application/json;charset=utf8",
                        data:JSON.stringify(user),
                        success:function (data) {
                            if(data.result=="fail")
                                $(".existsDIV").show();
                            else
                                location.href=getContentPath()+"/registerSuccess";
                        }
                    }
                );
            }
        );
    }
);
$(
    function () {
        $(".loginButton").click(
            function () {
                var url = $("#loginForm").attr("action");
                var name = $("#loginName").val();
                var pass = $("#loginPass").val();
                var user = {
                    "userName":name,
                    "userPassword":pass
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
                                $(".errorDIV").show();
                            else
                                location.href=getContentPath();
                        }
                    }
                );
                return false;
            }
        );
    }
);
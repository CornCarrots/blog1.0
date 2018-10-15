$(
    function () {
        $(".editUserButton").click(
            function () {
                var button = $(this).parent();
                var name = button.prev().prev().prev().prev().prev().prev().prev().prev().text().trim();
                var pass = button.prev().prev().prev().prev().prev().prev().prev().text().trim();
                var image =button.prev().prev().prev().prev().prev().prev().children(":first").attr("src").substring(6);
                var nick = button.prev().prev().prev().prev().prev().text().trim();
                var email = button.prev().prev().prev().prev().text().trim();
                $("#userNameEdit").val(name);
                $("#userPasswordEdit").val(pass);
                $("#userNickNameEdit").val(nick);
                $("#userPhotoEdit").val(image);
                $("#userEmailEdit").val(email);
                var url = $(this).attr("href");
                $("#editUserForm").attr("action",url);
                $("#editUserModel").modal("show");
                return false;
            }
        );
        $(".editUserNo").click(
            function () {
                $("#editUserForm").attr("action","");
                $("#userNameEdit").val("");
                $("#userPasswordEdit").val("");
                $("#userNickNameEdit").val("");
                $("#userPhotoEdit").val("");
                $("#userEmailEdit").val("");
            }
        );
        $(".deleteUserOne").click(
            function () {
                var url = $(this).attr("aid");
                $("#deleteUserForm").attr("action",url);
                $("#deleteUserModel").modal("show");
            }
        );
        $(".deleteUserNo").click(
            function () {
                $("#deleteUserForm").attr("action","");
            }
        );
        $("#deleteUserConfirm").click(
            function () {
                $("#deleteUserForm").submit();
                return false;
            }
        );
    }
);
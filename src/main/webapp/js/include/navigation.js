$(
    function () {
        $(".left_navigate span").hover(
            function () {
                // console.log($(".left_navigate span"));

                $(".left_navigate span").each(
                    function()
                    {
                        $(this).removeClass("myactive");
                    }
                );
                $(this).addClass("myactive");
            }
        );
    }
);
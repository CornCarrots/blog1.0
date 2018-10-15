function getContentPath()
{
  var path = location.pathname;
  path = path.substring(0,path.substring(1).indexOf("/")+1);
  return path;
};
$(
    function () {
        // var y = document.body.clientHeight;
        var y = $(window).height();
        // var y = $(document).height();
                $(".back_navigation").css("height", y);
        //         $(".container").css("height", y);
        $(".index_comment_textBlock").hover(
            function () {
                $(this).find(".index_comment_edit").css("visibility", "visible");
            }
        );
        $(".index_comment_textBlock").mouseleave(
            function () {
                $(this).find(".index_comment_edit").css("visibility", "hidden");
            }
        );
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
        $(".waitComment_table_text").hover(
            function () {
                $(this).find(".waitComment_table_edit").css("visibility", "visible");
            }
        );
        $(".waitComment_table_text").mouseleave(
            function () {
                $(this).find(".waitComment_table_edit").css("visibility", "hidden");
            }
        );
        $("#insertCategory").click(
            function()
            {
                $("#categoryName").focus();
            }

        );


        // console.log(testEditor);
        // console.log(    testEditor.setToolbarAutoFixed(false));
        // testEditor.setToolbarAutoFixed(false);

        // editormd.emoji = {
        //     path: "../../../plugin/emoji",
        //     ext:".png"
        // };

    }
);



$(document).ready(function() {

    $('.btn_determine').click(function () {
            re();
    })

})

function re() {

    $.ajax({

        async: false,
        type:"post",
        url: "/UpTopicController",
        contentType:"application/json",
        success:
            function(data){
                alert(data);
                window.location();
            },
        error:
            function(err){
                alert("错误"+err);
            }
    });
}
$(function() {

    $("#login").on('click', function() {





        if ($("#password").val() == '' || $("#username").val() == '') {

            $(".error").val("账号或密码不能为空");
        } else {
            $("#form").submit();
        }


    })

    $('input').on('blur',function () {

        $(this).css("color",'rgb(177, 177, 177)');

    })

    $('input').on('focus',function () {
        $(this).css("color",'rgb(0,0,0)');
        $(this).select();
    })

})
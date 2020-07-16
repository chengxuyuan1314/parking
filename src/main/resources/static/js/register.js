$(function() {
    var flag = 0;

   $("#username").on('blur',function () {



       $.get("/checkUsername", {username:$("#username").val()},function (date) {
            $('.error').text(date);
            if (date=='该账号可用'){
                flag=1;
            }else{
                flag=0;
            }
       });
   });


    $("#login").on('click', function() {

        if ($("#password").val() == '' || $("#username").val() == '' || $('#tel').val() == '' || flag==0) {
            $(".error").text("账号或密码或电话号为空");

        } else if ($("#password").val() != $("#repsw").val()) {

            $(".error").text("两次密码不一致");
        } else {

            $("#form").submit();
        }


    });

});
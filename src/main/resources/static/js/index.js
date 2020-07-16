$(function () {

//左边功能栏增加js效果  点击展开  再次点击隐藏

    $("dt").click(function() {

        $("." + $(this).data("index")).toggle();

        if ($(this).attr("data-flag") == 0) {

            $(this).children()[2].className = "glyphicon glyphicon-chevron-up";
            $(this).attr("data-flag", 1);

        } else {
            $(this).children()[2].className = "glyphicon glyphicon-chevron-down";
            $(this).attr("data-flag", 0);

        }
    })


//信息栏 标签类
    var that;
    class Tab {
        constructor(id) {
            this.main = document.querySelector(id);
            this.init();

        }
        init() {
            this.nav = this.main.querySelector('.header-nav');
            this.lis = this.nav.querySelectorAll('li');
            this.sections = this.main.querySelectorAll('section');
            this.add = this.main.querySelector('.add');
            this.ul = this.nav.querySelector('ul');
            this.body = this.main.querySelector('.body');
            this.spans = this.ul.querySelectorAll('span');
            that = this;
            for (let i = 0; i < this.lis.length; i++) {
                this.lis[i].index = i;
                this.lis[i].onclick = this.toggleTab;
                this.spans[i].onclick = this.removeTab;
            }

        }

        toggleTab() {

            that.clear();
            this.className = 'pick';
            that.sections[this.index].className = 'show';
        }
        clear(){
            for (let i = 0; i < that.lis.length; i++) {
                that.lis[i].index = i;
                that.lis[i].className = '';

            }
            for (let i = 0; i < that.sections.length; i++) {
                that.sections[i].index = i;
                that.sections[i].className = '';
            }
        }
        selectById(id){
            that.clear();
            that.lis[id].className = "pick";
            that.sections[id].className = 'show';
        }



        removeTab(e) {
            e.stopPropagation();
            $(that.lis[this.parentNode.index]).hide();

            that.clear();
        }

    }
//隐藏除12其他标签
    var tab = new Tab('.bigBox');
    $('.header-nav ul li').eq(2).hide();
    $('.header-nav ul li').eq(3).hide();
    $('.header-nav ul li').eq(4).hide();
    $('.header-nav ul li').eq(5).hide();
    $('.header-nav ul li').eq(6).hide();
    $('.header-nav ul li').eq(7).hide();
    $('.header-nav ul li').eq(8).hide();
    $('.header-nav ul li').eq(9).hide();
    $('.header-nav ul li').eq(10).hide();
// //点击功能栏显示对应信息栏信息



    $("dl").on("click","dd",function(){
        $('.header-nav ul li').eq($(this).data("index")).show();
        tab.selectById($(this).data("index"));
    });


    $(".upMoney").on("click","a",function () {

        $(".money").val($(this).text());
    })


    $(".updateUser").on("click",function () {
        if ($('#uname').val()=='' || $('#utel').val()==''){
            $('.updateTip').text('电话姓名不能为空');
        }else{
            $('.updateTip').text('修改成功');

            $(".updateUser").attr('disabled','disabled');
            setInterval(updateUserSubmit,2000);
        }

    })

    $("#rechargeSubmit").on('click',function () {
        $('#rechargeForm').submit();
    })

    function updateUserSubmit(){
        $('#updateUser').submit();
    }
    $(".selectCar").on('click',function () {
        $.post('/findCar',{uid:$('.hideUid').text()} ,function (date) {
            if (date.length==0){
                $(".findmsg").text("你还没绑定车呢")
            }else {
                var date2=eval(date);
                for (var i=0 ; i<date2.length ;i++){
                    $('.carTable').append("<tr data-index= "+ i +"><td class='cid'>"+date2[i].cid+"</td><td>"+date2[i].carName+"</td><td>"+date2[i].license+"</td><td>"+date2[i].inParking+"</td><td><a class='updateCar' href='javascript:void(0)'>修改</a> <a class='deleteCar' href='javascript:void(0)'>删除</a></td></tr>")
                }
            }
        } ,"json");
        $(".selectCar").attr('disabled',true);
    });


    $("#bindingCar").on('click',function () {
        if ($('carID').val()=='' || $('license').val()=='' || $('carName').val()==''){
            $(".addCarMsg").text("车牌号，名字不能为空");
        }else {
            $('#bindingCarForm').submit();
        }
    });


    if($('#addCarMsg').text() == ''){

    }else {
        alert($('#addCarMsg').text());
    }

    $(".carTable").on("click",$(".deleteCar"), function (e) {

        if ($(e.target).hasClass("deleteCar")){
            $.get("/deleteCar",{cid :$(e.target).parent().parent().find(".cid").text(),uid:$('.hideUid').text()},function (date) {
                alert(date);
                $(e.target).parent().parent().remove();
            })
        }
        if ($(e.target).hasClass("updateCar")){
            window.location.href="/updateCar/"+ $(e.target).parent().parent().find(".cid").text();
        }
    })


    $("#selectFindAll").on('click',function () {
        $.post('/adminFindCar',{flag:"1"} , function (date) {
            if (date.length==0){
                $(".adminFindMsg").text("还没任何车呢")
            }else {
                var date2=eval(date);

                $('.adminCarList').each(function () {
                    $(this).remove();
                });
                for (var i=0 ; i<date2.length ;i++){
                    $('.adminCarTable').append("<tr class='adminCarList' data-index= "+ i +"><td class='cid'>"+date2[i].cid+"</td><td>"+date2[i].carName+"</td><td>"+date2[i].license+"</td><td>"+date2[i].inParking+"</td></tr>")
                }
            }
        } ,"json");
    });

    $("#selectFindInParking").on('click',function () {
        $.post('/adminFindCar',{flag:"2"} , function (date) {
            if (date.length==0){
                $(".adminFindMsg").text("还没任何车呢")
            }else {
                var date2=eval(date);

                $('.adminCarList').each(function () {
                    $(this).remove();
                });
                for (var i=0 ; i<date2.length ;i++){
                    $('.adminCarTable').append("<tr class='adminCarList' data-index= "+ i +"><td class='cid'>"+date2[i].cid+"</td><td>"+date2[i].carName+"</td><td>"+date2[i].license+"</td><td>"+date2[i].inParking+"</td></tr>")
                }
            }
        } ,"json");
    });

    $("#selectUserFindAll").on('click',function () {
        $.post('/findAllUser', function (date) {
            if (date.length==0){
                $(".adminUserFindMsg").text("还没有任何用户")
            }else {
                var date2=eval(date);

                $('.adminUserList').each(function () {
                    $(this).remove();
                });

                for (var i=0 ; i<date2.length ;i++){
                    $('.adminUserTable').append("<tr class='adminUserList' data-index= "+ i +"><td class='uid'>"+date2[i].uid+"</td><td>"+date2[i].username+"</td><td>"+date2[i].tel+"</td><td>"+date2[i].name+"</td><td>"+date2[i].money+"</td></tr>")
                }
            }
        } ,"json");
    });
})
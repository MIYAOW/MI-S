/*$("#login-button").click(function () {
 loginSubmit();
 });*/

$("input").keydown(function(e){
    if (e.keyCode==13) {
        $("form").submit();
    }
});



function loginSubmit(){

    var username = $("#username").val();
    var password = $("#password").val();
    if (username.length > 0 && password.length > 0) {
        $.ajax({
            type: "POST",
            url: '/login/auth',
            data: {username: username, password: password},
            success: function (data) {///去更新cookies
                if (data.resultCode == "success") {
                    window.location.href = "/admin/article/list";

                }else{
                    layer.alert('账号或者密码错误', {
                        icon: 2,
                    });
                    return;
                }
            }
        });
    } else {
        layer.alert('账号或者密码不能为空', {
            icon: 2,
        })
    }
}

///忘记密码
$("#iforget").click(function () {
    $("#login_model").hide();
    $("#forget_model").show();

});

///取回密码
$("#Retrievenow").click(function () {
    var usrmail = $("#usrmail").val();
    if (!Test_email(usrmail)) {
        // alert(msgggg.pssjs1);
        return false;
    }
    $.ajax({
        type: "POST",
        url: '/users/AjaxServer/checkis.ashx',
        data: {typex: 5, usrmail: usrmail},
        success: function (data) {//

            alert(data);
            $("#login_model").show();
            $("#forget_model").hide();
            $("#usrmail").val("");
            $("#username").val("");
            $("#userpwd").val("");

        }
    });


});
//返回
$("#denglou").click(function () {
    $("#usrmail").val("");
    $("#username").val("");
    $("#userpwd").val("");
    $("#login_model").show();
    $("#forget_model").hide();

});
//返回主页
$("#back-button").click(function () {
    window.location.href = '/'
});

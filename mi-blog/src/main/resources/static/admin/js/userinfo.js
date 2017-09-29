/**
 * 修改密码
 */
$("#update-password").on('click',function () {
    var html = ' <div class="form-row">' +

        ' <input type="password" name="oldPassword" ' + ' placeholder="旧密码" required />'
        + ' </div>' + ' <div class="form-row">'
        + ' <input type="password" name="newPassword" placeholder="新密码" required/>'
        + ' </div>' + ' <div class="form-row">'
        + ' <input type="password" name="confirmPassword" placeholder="确认密码" required/>'
        + ' </div>' + ' <div class="form-row">'
        + ' </div>';

    new $.flavr({content : '修改密码', dialog : 'form', form : { content: html, method:

            'post' },
        onSubmit : function( $container, $form ){
            var oldPassword = $("input[name='oldPassword']").val();
            var newPassword = $("input[name='newPassword']").val();
            var confirmPassword = $("input[name='confirmPassword']").val();
            if (isEmpty(oldPassword) || isEmpty(newPassword) || isEmpty(confirmPassword) ){
                autoCloseAlert("字段不能为空！！！");
                return false;
            }
            if (newPassword != confirmPassword){
                autoCloseAlert("两次密码不一致",1000);
                return false;
            }

            $.ajax({
                url: "/admin/password/update",
                data: $form.serialize(),
                method: 'POST',
                success: function (data) {
                    if (data.code == '200') {
                        autoCloseAlert(data.msg, 1000);
                        window.location.href = '/loginOut';
                    }
                    autoCloseAlert(data.msg, 1000);
                    return false;
                }
            })
            return false;
        }
    });
})


/**
 * 判断字符串是否为空
 * @param str 字符串
 * @returns {boolean}
 */
function isEmpty(str) {
    if (str == null || str == '' || str == undefined){
        return true;
    }
    return false;
}


$("#update-userinfo").on('click',function () {
    $.ajax({
        url: "/admin/userinfo/get",
        method: "GET",
        success: function (data) {
            $('#editUserInfoContent').html(data);
            $('#editUserInfoModal').modal('show');

        }
    })
});


function saveInfo() {
    var nickname = $("#nickname").val();
    if(isEmpty(nickname)){
        autoCloseAlert("请输入昵称",500);
        return false;
    }
    var phone = $("#phone").val();
    if(isEmpty(phone)){
        autoCloseAlert("请输入电话号码",500);
        return false;
    }
    var email = $("#email").val();
    if (isEmpty(email)){
        autoCloseAlert("请输入邮箱地址",email);
    }

    var address = $("#address").val();
    if (isEmpty(address)){
        autoCloseAlert("请输入地址",email);
    }

    var signature = $("#signature").val();
    if (isEmpty(signature)){
        autoCloseAlert("请输入个性签名!",signature);
    }
    var announcement = $("#announcement").val();
    if (isEmpty(announcement)){
        autoCloseAlert("请输入公告",announcement);
    }
    var data = $("#infoForm").serialize();

    $.ajax({
        url: "/admin/userinfo/update",
        method: "POST",
        data: data,
        success: function (data) {
            if (data.resultCode == 'success'){
                autoCloseAlert(data.errorInfo,1000);
                cancelSaveInfo();
            }
            autoCloseAlert(data.errorInfo,1000);
            return false;
        }
    });
}


function cancelSaveInfo() {
    $('#editUserInfoModal').modal('hide');
}
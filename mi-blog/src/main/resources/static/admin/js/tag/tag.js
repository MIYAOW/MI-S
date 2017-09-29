$(function() {
    $("#label-manage-li").addClass("active");
    $("#label-list-li").addClass("active");
    $("#label-list-li").parent().addClass("in");
    loadList();
});


// 加载列表
function loadList(param, page) {
    if (isEmpty(page) || page == 0) {
        page = 1;
    }
    // 查询列表
    $.ajax({
        type: 'POST',
        url: '/admin/tag/list',
        data: {
            'current': page,
            'param': param
        },
        success: function (data) {
            $("#dataList").html(data);
        }
    });

}
// 搜索
$("#search").on('click',function () {
    var param = $("#keyword").val();
    // 收集参数
    var page = $("#now").val();
    loadList(param, page);
});

// 跳转新增管理员页面
$("#add").on('click', function () {
    $.ajax({
        url: '/admin/tag/add',
        success: function (data) {
            $('#addContent').html(data);
            $('#addModal').modal('show');
            $('#addModal').addClass('animated');
            $('#addModal').addClass('bounceInLeft');
        }
    });
});
// 新增管理员
function saveAdd(){
    if (validateAdd()) {
        $.ajax({
            url: '/admin/tag/save',
            data: $("#addForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    $('#addModal').modal('hide');
                    autoCloseAlert(data.msg,1000);
                    loadList();
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}
// 校验新增管理员输入框
function validateAdd(){
    var tagName = $("#tagName").val();
    var aliasName = $("#aliasName").val();
    if (!isEmpty(tagName)) {
        if (isSpecialSymbols(tagName)) {
            autoCloseAlert("标签不能包含特殊符号", 1000);
            return false;
        }
    } else {
        autoCloseAlert("标签不能为空", 1000);
        return false;
    }
    if(!isEmpty(aliasName)){
        if(isSpecialSymbols(aliasName)){
            autoCloseAlert("标签不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("标签不能为空",1000);
        return false;
    }
    return true;
}
// 跳转编辑页
$("#dataList").on('click', '.edit', function () {
    $.ajax({
        url: '/admin/tag/edit',
        data: 'tagId=' + $(this).parent().data("id"),
        success: function (data) {
            $('#editContent').html(data);
            $('#editModal').modal('show');
            $('#editModal').addClass('animated');
            $('#editModal').addClass('flipInY');
        }
    });
});
// 校验编辑管理员输入框
function validateEdit(){
    var tagName = $("#tagName").val();
    if (!isEmpty(tagName)) {
        if (isSpecialSymbols(tagName)) {
            autoCloseAlert("标签不能包含特殊符号", 1000);
            return false;
        }
    } else {
        autoCloseAlert("标签不能为空", 1000);
        return false;
    }

    return true;
}
// 编辑管理员
function saveEdit() {
    if (validateEdit()) {
        $.ajax({
            url: '/admin/tag/update',
            data: $("#editForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    $('#editModal').modal('hide');
                    loadList();
                    autoCloseAlert(data.msg, 1000);
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}


// 删除
$("#dataList").on('click', '.delete', function () {
    var id = $(this).parent().data("id");
    new $.flavr({
        content: '确定要删除吗?',
        buttons: {
            primary: {
                text: '确定', style: 'primary', action: function () {
                    $.ajax({
                        url: '/admin/tag/delete',
                        data: 'typeId=' + id,
                        success: function (data) {
                            if (data.code == '200') {
                                autoCloseAlert(data.msg, 1000);
                                loadList();
                            } else {
                                autoCloseAlert(data.msg, 1000);
                            }
                        }
                    });
                }
            },
            success: {
                text: '取消', style: 'danger', action: function () {

                }
            }
        }
    });

});

// 关闭编辑管理员窗口
function closeEditWindow() {
    $('#editModal').modal('hide');
}

// 关闭新增管理员窗口
function closeAddWindow() {
    $('#addModal').modal('hide');
}

$(function() {
    $("#flink-manage-li").addClass("active");
    $("#flink-list-li").addClass("active");
    $("#flink-list-li").parent().addClass("in");
    loadList();
});
// 加载菜单列表
function loadList(param, page) {

    // 查询列表
    $.ajax({
        type: 'POST',
        url: '/admin/flink/list',
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

// 跳转新增页面
$("#add").on("click", function () {
    $.ajax({
        url: '/admin/flink/add',
        success: function (data) {
            $('#addContent').html(data);
            $('#addModal').modal('show');
            $('#addModal').addClass('animated');
            $('#addModal').addClass('bounceInLeft');
        }
    });
});
function saveAdd() {
    if (validateAdd()) {
        $.ajax({
            url: '/admin/flink/save',
            data: $("#addForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    $('#addModal').modal('hide');
                    loadList();
                    autoCloseAlert(data.msg, 1000);
                    closeAddWindow();
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}
// 校验新增banner输入框
function validateAdd() {
    var siteName = $("#siteName").val();
    if (!isEmpty(siteName)) {
        if (isSpecialSymbols(siteName)) {
            autoCloseAlert("名称不能包含特殊符号", 1000);
            return false;
        }
    } else {
        autoCloseAlert("名称不能为空", 1000);
        return false;
    }

    var siteUrl = $("#siteUrl").val();
    if (isEmpty(siteUrl)) {
        autoCloseAlert("地址不能为空", 1000);
        return false;
    }

    var siteDesc = $("#siteDesc").val();
    if (isEmpty(siteDesc)) {
        autoCloseAlert("描述不能为空", 1000);
        return false;
    }

    var sort = $("#sort").val();
    if (isEmpty(sort)) {
        autoCloseAlert("排序不能为空", 1000);
        return false;
    }

    return true;
}

// 跳转栏目编辑页
$("#dataList").on('click','.edit',function () {
    var id = $(this).parent().data("id")
    $.ajax({
        url: '/admin/flink/edit',
        data: 'id='+id,
        success: function (data) {
            $('#editContent').html(data);
            $('#editModal').modal('show');
            $('#editModal').addClass('animated');
            $('#editModal').addClass('flipInY');
        }
    });
});


function saveEdit() {
    if (validateEdit()) {
        $.ajax({
            url: '/admin/flink/update',
            data: $("#editForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    loadList();
                    $('#editModal').modal('hide');
                    closeEditWindow();
                    autoCloseAlert(data.msg, 1000);
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}

function validateEdit() {
    var siteName = $("#siteName").val();
    if (!isEmpty(siteName)) {
        if (isSpecialSymbols(siteName)) {
            autoCloseAlert("合作伙伴名称不能包含特殊符号", 1000);
            return false;
        }
    } else {
        autoCloseAlert("合作伙伴名称不能为空", 1000);
        return false;
    }

    var siteUrl = $("#siteUrl").val();
    if (isEmpty(siteUrl)) {
        autoCloseAlert("合作伙伴地址不能为空", 1000);
        return false;
    }

    var siteDesc = $("#siteDesc").val();
    if (isEmpty(siteDesc)) {
        autoCloseAlert("网站描述不能为空", 1000);
        return false;
    }

    var sort = $("#sort").val();
    if (isEmpty(sort)) {
        autoCloseAlert("排序不能为空", 1000);
        return false;
    }

    return true;
}


// 删除栏目
$("#dataList").on('click', '.delete', function () {
    var id = $(this).parent().data("id")

    new $.flavr({
        content: '确定要删除吗?',
        buttons: {
            primary: {
                text: '确定', style: 'primary', action: function () {

                    $.ajax({
                        url: '/admin/flink/delete',
                        data: 'id=' + id,
                        success: function (data) {
                            if (data.code == '200') {
                                autoCloseAlert(data.msg, 500);
                                loadList();
                            } else {
                                autoCloseAlert(data.msg, 500);
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


//关闭编辑窗口
function closeEditWindow() {
    $('#editModal').modal('hide');
}
//关闭新增窗口
function closeAddWindow() {
    $('#addModal').modal('hide');
}





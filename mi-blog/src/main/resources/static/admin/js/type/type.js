$(function(){
    $("#type-manage-li").addClass("active");
    $("#type-list-li").addClass("active");
    $("#type-list-li").parent().addClass("in");
    loadList();
})
// 加载菜单列表
function loadList(param, page) {
    if (isEmpty(page) || page == 0) {
        page = 1;
    }
    // 查询列表
    $.ajax({
        type: 'POST',
        url: '/admin/type/list',
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
$("#search").on("click",function () {
    var param = $("#keyword").val();
    // 收集参数
    var page = $("#now").val();
    loadList(param, page);
});


// 跳转新增分类页面
$("#add").on("click", function () {
    $.ajax({
        url: '/admin/type/add',
        success: function (data) {
            $('#addContent').html(data);
            $('#addModal').modal('show');
            $('#addModal').addClass('animated');
            $('#addModal').addClass('bounceInLeft');
        }
    });
});
// 校验新增分类输入框
function validateAdd(){
    var typeName = $("#typeName").val();
    var aliasName = $("#aliasName").val();
    if(!isEmpty(typeName)){
        if(isSpecialSymbols(typeName)){
            autoCloseAlert("分类名称不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类名称不能为空",1000);
        return false;
    }
    if(!isEmpty(aliasName)){
        if(isSpecialSymbols(aliasName)){
            autoCloseAlert("分类别名不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类别名不能为空",1000);
        return false;
    }
    return true;
}
// 保存分类
function saveAdd() {
    if (validateAdd()) {
        $.ajax({
            url: '/admin/type/save',
            data: $("#addForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    $('#addModal').modal('hide');
                    loadList();
                    closeAddWindow();
                    autoCloseAlert(data.msg, 1000);
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}

// 跳转编辑页
$("#dataList").on('click', '.edit', function () {
    $.ajax({
        url: '/admin/type/edit',
        data: 'typeId=' + $(this).parent().data("id"),
        success: function (data) {
            $('#editContent').html(data);
            $('#editModal').modal('show');
            $('#editModal').addClass('animated');
            $('#editModal').addClass('flipInY');
        }
    });
});

// 校验编辑分类输入框
function validateEdit(){
    var typeName = $("#typeName").val();
    var aliasName = $("#aliasName").val();
    if(!isEmpty(typeName)){
        if(isSpecialSymbols(typeName)){
            autoCloseAlert("标签不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("标签不能为空",1000);
        return false;
    }
    if(!isEmpty(aliasName)){
        if(isSpecialSymbols(aliasName)){
            autoCloseAlert("分类别名不能包含特殊符号",1000);
            return false;
        }
    }else{
        autoCloseAlert("分类别名不能为空",1000);
        return false;
    }

    return true;
}
// 编辑分类
function saveEdit() {
    if (validateEdit()) {
        $.ajax({
            url: '/admin/type/update',
            data: $("#editForm").serialize(),
            success: function (data) {
                if (data.code == '200') {
                    $('#editModal').modal('hide');
                    closeEditWindow();
                    autoCloseAlert(data.msg, 1000);
                    loadList();
                } else {
                    autoCloseAlert(data.msg, 1000);
                }
            }
        });
    }
}


//绑定删除分类的点击事件
$("#dataList").on('click', '.delete', function () {
    var typeId = $(this).parent().data("id");
    $.ajax({
        url: "/admin/type/delCheckExist",
        data: 'typeId=' + typeId,
        success: function (data) {
            if (data.code == '400') {
                new $.flavr({
                    content: '删除分类将会将此分类的文章移除此分类，您确定要删除吗?',

                    buttons: {
                        primary: {
                            text: '确定', style: 'primary', action: function () {
                                deleteById(typeId);
                            }
                        },
                        success: {
                            text: '取消', style: 'danger', action: function () {

                            }
                        }
                    }
                });
            } else {
                deleteById(typeId);
            }
        }
    });
})
// 删除分类的ajax方法
function deleteById(id) {
    $.ajax({
        url: "/admin/type/delete",
        data: 'typeId=' + id,
        success: function (data) {
            if (data.code == '200') {
                loadList();
                autoCloseAlert(data.msg, 1000);
            } else {
                autoCloseAlert(data.msg, 1000);
            }
        }
    });
}

// 关闭编辑分类窗口
function closeEditWindow() {
    $('#editModal').modal('hide');
}

// 关闭新增分类窗口
function closeAddWindow() {
    $('#addModal').modal('hide');
}

$(function() {
    $("#article-manage-li").addClass("active");
    $("#article-list-li").addClass("active");
    loadList();
});

// 加载文章列表
function loadList(keyword, typeId, tagIds, page) {
    // 查询列表
    $.ajax({
        type: 'POST',
        url: '/admin/article/list',
        traditional: true,
        data: {
            'current': page,
            'title': keyword,
            'typeId': typeId,
            'tagIds': tagIds
        },
        success: function (data) {
            $("#dataList").html(data);
            $(".chosen-select").chosen({
                max_selected_options: 5,
                no_results_text: "没有找到",
                allow_single_deselect: true
            });
            $(".chosen-select").trigger("liszt:updated");
        }
    });
}

// 搜索
$("#article-search").on('click',function () {
    var keyword = $("#keyword").val();
    var typeId = $("#typeId option:selected").val();

    var page = $("#now").val();
    var tagIds = [];
    $("#tagId option:selected").each(function () {
        tagIds.push($(this).val());
    });
    console.log(tagIds);
    loadList(keyword, typeId, tagIds, page);
});


// 新增文章  跳转新页
$("#article-add").on('click',function () {
    window.location.href = '/admin/article/add';
});


// 编辑文章
$("#dataList").on('click', '.article-edit', function () {
    window.location.href = "/admin/article/edit?id=" + $(this).parent().data("id");
});


// 删除文章
$("#dataList").on('click','.article-delete',function () {
    var id = $(this).parent().data("id")
    new $.flavr({
        content: '您确定要删除吗?',
        buttons: {
            primary: {
                text: '确定', style: 'primary', action: function () {
                    $.ajax({
                        url : '/admin/article/delete',
                        data: 'id='+id,
                        success  : function(data) {
                            if(data.code == '200'){
                                loadList();
                                autoCloseAlert(data.msg,1000);
                            }else{
                                autoCloseAlert(data.msg,1000);
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
    // 调到列表页

});


//0:可用  1：不可用
$("#dataList").on('click', '.article-state', function () {
    var state = $(this).parent().data("state") == 1 ? 0 : 1;
    var id = $(this).parent().data("id");
    new $.flavr({
        content: '确定要修改状态吗?',
        buttons: {
            primary: {
                text: '确定', style: 'primary', action: function () {
                    $.ajax({
                        url: '/admin/article/updateStatue',
                        data: 'id=' + id + '&status=' + state,
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
            },
            success: {
                text: '取消', style: 'danger', action: function () {

                }
            }
        }
    });
});


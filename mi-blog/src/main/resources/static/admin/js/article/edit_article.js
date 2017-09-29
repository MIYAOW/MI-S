var testEditor;

$(function () {
    testEditor = editormd("article-editormd", {
        width: "98%",
        height: $(window).height()-20,
        path : '/admin/lib/',
        codeFold : true,
        //syncScrolling : false,
        saveHTMLToTextarea : false,    // 保存 HTML 到 Textarea
        searchReplace : true,
        //watch : false,                // 关闭实时预览
        htmlDecode : "style,script,<iframe,sub,sup,<embed,<div |onclick,title,onmouseover,onmouseout,style",            // 开启 HTML 标签解析，为了安全性，默认不开启
        //toolbar  : false,             //关闭工具栏
        //previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
        emoji : true,
        taskList : true,
        tocm: true,         // Using [TOCM]
        tex : true,                   // 开启科学公式TeX语言支持，默认关闭
        flowChart : true,             // 开启流程图支持，默认关闭
        sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
        //dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
        //dialogShowMask : false,     // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
        //dialogDraggable : false,    // 设置弹出层对话框不可拖动，全局通用，默认为true
        //dialogMaskOpacity : 0.4,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
        //dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL : "/admin/article/imageUpload",
        toolbarIcons : function() {
            return ["bold", "italic", "hr", "ucwords","uppercase", "lowercase", "list-ul", "list-ol", "|", "link", "reference-link", "image", "code", "code-block", "table","|", "datetime", "emoji", "pagebreak","|","goto-line", "watch", "preview", "search", "||", "post-article"]
        },
        toolbarIconTexts : {
            "post-article" : "发布"  // 如果没有图标，则可以这样直接插入内容，可以是字符串或HTML标签
        },
        // 自定义工具栏按钮的事件处理
        toolbarHandlers : {
            /**
             * @param {Object}      cm         CodeMirror对象
             * @param {Object}      icon       图标按钮jQuery元素对象
             * @param {Object}      cursor     CodeMirror的光标对象，可获取光标所在行和位置
             * @param {String}      selection  编辑器选中的文本
             */
            "post-article": function (cm, icon, cursor, selection) {

                //var cursor    = cm.getCursor();     //获取当前光标对象，同cursor参数
                //var selection = cm.getSelection();  //获取当前选中的文本，同selection参数

                // 替换选中文本，如果没有选中文本，则直接插入
                //cm.replaceSelection("[" + selection + ":testIcon]");

                // 如果当前没有选中的文本，将光标移到要输入的位置
                // if (selection === "") {
                //     cm.setCursor(cursor.line, cursor.ch + 1);
                // }

                // this == 当前editormd实例
                // console.log("testIcon =>", this, cm, icon, cursor, selection);
                editArticle();
            },
        },
        onload : function() {
            //this.fullscreen();
            //this.unwatch();
            //this.watch().fullscreen();

            //this.setMarkdown("#PHP");
            //this.width("100%");
            //this.height(480);
            //this.resize("100%", 640);
        }
    });

});

function getRootPath() {
	//获取当前网址，如： http://localhost:8080/GameFngine/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： GameFngine/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/GameFngine
	var projectName = pathName.substring(0,
			pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName + "/");
}

// 编辑文章
function editArticle(){
	var articleId = $("#articleId").val();
    $.ajax({
        url: '/admin/article/updateInfo?articleId='+articleId,
        success: function (data) {
            $('#addArticleContent').html(data);
            $('#addArticleModal').modal('show');
            $('#addArticleModal').addClass('animated');
            $('#addArticleModal').addClass('flipInY');
            $(".chosen-select").chosen({
                max_selected_options: 5,
                no_results_text: "没有找到",
                allow_single_deselect: true
            });
            $(".chosen-select").trigger("liszt:updated");
        }
    });
}

function save() {
	var id = $("#articleId").val();

    var typeId = $("#typeId").val();
    if(isEmpty(typeId)){
        autoCloseAlert("请选择栏目",500);
        return false;
    }

    var fromType = $("#fromType").val();
    if (isEmpty(fromType)) {
        autoCloseAlert("请选择栏目", 500);
        return false;
    }

    var title = $("#title").val();
    if(isEmpty(title)){
        autoCloseAlert("请输入标题",500);
        return false;
    }
    // title = encodeURIComponent(title);

    var content = testEditor.getMarkdown();
    // content = encodeURIComponent(content);
    var description = $("#description").val();
    if (isEmpty(description)) {
        autoCloseAlert("请输入文章描述", 500);
        return false;
    }
    // description = encodeURIComponent(description);
    // 标签
    var tagIds = [];
    $("#tagId option:selected").each(function () {
        tagIds.push($(this).val());
    })
    if (isEmpty(tagIds)) {
        autoCloseAlert("未选择新标签 \n 按照原先标签保存", 2000);
        // var ids = (tagId+"").split(",");
        // var tagArray = [];
        // for(var i=0;i<ids.length;i++){
        //     tagObj = {id:ids[i]};
        //     tagArray.push(tagObj);
        // }
        // param["tagList"] = tagArray;
        // console.info(tagArray);
    }

    // 保存文章
    $.ajax({
        type : "POST",
        url :  '/admin/article/update',
        traditional: true,
        data: {
            'articleId': id,
            'title': title,
            'typeId': typeId,
            'classType': fromType,
            'tagIds': tagIds,
            'content': content,
            'description': description
        },
        success  : function(data) {
            if(data.code != '200'){
                autoCloseAlert(data.msg, 500);
                closeEditWindow();
                return false;
            }else{
                new $.flavr({
                    content: '修改文章成功!',

                    buttons: {
                        primary: {
                            text: '再写一篇', style: 'primary', action: function () {
                                window.location.href = "/admin/article/add";
                            }
                        },
                        success: {
                            text: '查看博客', style: 'danger', action: function () {
                                window.location.href = "/admin/article/mgr";
                            }
                        }
                    }
                });
                // 调到列表页

            }

        }
    });
}

function cancleEditArticle(){
    window.location.href = getRootPath() + "/article/mgr";
}

//关闭编辑窗口
function closeEditWindow(){
    $('#addArticleContent').modal('hide');
}
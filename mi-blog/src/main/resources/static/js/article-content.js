$(function() {
    var testEditormdView;
    $('#main').addClass('loaded');

    testEditormdView = editormd.markdownToHTML("article-content", {
        htmlDecode      : "style,script,<iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : true,  // 默认不解析 // 默认不解析
    });

    /*分享初始化*/
    $("#socialShare").socialShare({
        content: $("#"),
        url:getRootPath()+$("#article-url").attr("href"),
        title:$("#article-title").text(),
        summary: 'MIYAOW个人博客分享,欢迎指教',
        pic: 'http://ovr5hz4v2.bkt.clouddn.com/avatar.jpg'
    });

    $('#loader-wrapper .load_title').remove();
});



function getRootPath() {
    //获取当前网址
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0,
        pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}

/**
 * Created by yunfei on 2017/2/15.
 */
function send() {
    var content = $("#content").val();
    if(!content){
        alert("请输入内容！");
        return
    }
    $.ajax({
        url:$("#basePath").val()+"AutoReplyServlet.action",
        type:"POST",
        dataType:"text",
        timeout:10000,
        success:function (data) {
            alert(data);
            $("#content").val("");
        },
        data:{"content":content}
    });
}
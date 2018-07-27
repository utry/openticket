/**
 * @Description : form_future.js
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */


//进行校验并提交表单
function submitOrder(){
    var ticketType = $("[name=ticketType]").val();
    $.ajax({
        type:"post",
        url:"/openticket/saveTicket",
        contentType: "application/json",
        //contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        data:JSON.stringify({
            ticketType:ticketType
        }),
        success:function(data){
            alert("添加成功！");
            window.location.href="/openticket/index";
        },
        error:function(data){
            alert("添加失败！");
        }
    });
}
/**
 * @Description : table_update.js
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/08/01
 */
var ticketValueList = new Array();

//进行校验并提交表单
function submitOrder(){
    var ticketId = $("input[type=hidden]").val();
    $(".selfDefine").each(function () {
        var fieldId = $(this).attr('id');
        var value = $(this).val();
        ticketValueList.push({
            "fieldId":fieldId,
            "value":value
        })
    })
    $.ajax({
        type:"post",
        url:"/openticket/updateTicket",
        contentType: "application/json",
        //contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        data:JSON.stringify({
            id:ticketId,
            ticketValueList:ticketValueList
        }),
        success:function(data){
            alert("修改成功！");
            window.location.href="/openticket/index";
        },
        error:function(data){
            alert("修改失败！");
        }
    });
}
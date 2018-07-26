/**
 * @Description : table_future.js
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

//变换工单的类型
function changeTicketType(obj){
    var ticketType = $(obj).text();
    $("#btnGroupVerticalDrop6").text(ticketType);
    clearTable();
    $.ajax({
        type: "post",
        url: "/openticket/getColumn",
        //contentType: "application/json",
        data: {
            ticketType: ticketType
        },
        success: function (data) {
            clearColumn();
            for(var i=0;i<data.length;i++)
            {
                var th = "<th>"+data[i].name+"</th>";
                $("#sample_editable_1 thead tr th:last").before(th);

                //$("#sample_editable_1 thead").find("tr").append(th);
            }
            $.ajax({
                type:"post",
                url:"/openticket/getTicket",
                //contentType: "application/json",
                data:{
                        ticketType: ticketType
                },
                success: function (data) {
                    var tbody = $("#sample_editable_1 tbody");
                    for(var i=0;i<data.length;i++)
                    {
                        var tr = "<tr><td>"+"<input type=\'checkbox\' class=\'checkboxes\' value=\'1\' /></td>"+
                                "<td>"+data[i].id+"</td>"+
                                "<td>"+data[i].createUser+"</td>"+
                                "<td>"+data[i].createTime+"</td>"+
                                "<td><a class=\'edit\' href=\'javascript:;\'>编辑</a> <a class=\'delete\' href=\'javascript:;\'>删除</a></td></tr>";
                        tbody.append(tr);
                    }
                },
                error: function (data) {
                    alert("加载失败！");
                }
            })
        },
        error: function (data) {
            alert("加载失败！");
        }
    })
}

//清除table中的数据
function clearTable(){
    $("#sample_editable_1 tbody").find("tr").remove();
}

//清除列中的自定义属性
function clearColumn(){
    $("#sample_editable_1 thead tr").find("th").eq(3).nextAll().remove();
    $("#sample_editable_1 thead tr").append("<th>操作</th>");
}
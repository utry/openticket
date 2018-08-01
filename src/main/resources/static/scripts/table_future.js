/**
 * @Description : table_future.js
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

//删除工单
function deleteTicket(obj){
    var tr = $(obj).parents("tr");
    var id = $(obj).parents("tr").find("td").eq(1).text();
   $.ajax({
       type:"post",
       url:"/openticket/deleteTicket",
       //contentType: "application/json",
       //contentType: "application/x-www-form-urlencoded; charset=UTF-8",
       data:{ id:id },
       success:function(data){
           alert("删除成功！");
           tr.remove();
       },
       error:function(data){
           alert("删除失败！");
       }
   });
}

function updateTicket(obj){
    var id = $(obj).parents("tr").find("td").eq(1).text();
    var ticketType = $("#btnGroupVerticalDrop6").text();
    window.location.href="/openticket/updateTicketPage?id="+id+"&ticketType="+ticketType;
}

$(function () {
    //初始化Table
    var myColumn = getColumn();
    TableInit(myColumn);

    //给工单类型选择框绑定click事件，用于改变表格结构和信息
    $(".ticketType").click(function(){
        $("#btnGroupVerticalDrop6").text($(this).text());
        myColumn = getColumn();
        $("#ticketTable").bootstrapTable(
            "refreshOptions",
            {
                columns : myColumn,
            }
        );
    });
});

// 加载动态表格列
function getColumn(){
    var myColumn = [{
        checkbox: true,
        align: 'center'
    },{
        field: 'id',
        title: '序号'
    }, {
        field: 'createTime',
        title: '创建时间'
    }, {
        field: 'createUser',
        title: '创建用户'
    }];
    $.ajax({
        url : "/openticket/getColumn",
        type : 'post',
        async : false,
        data : {
            ticketType: $("#btnGroupVerticalDrop6").text()
        },
        success : function(data){
            if(data){
                for(var i=0;i<data.length;i++) {
                    myColumn.push({
                        "field": data[i].fieldName,
                        "title": data[i].name,
                        "align": 'center',
                        "valign": 'middle'
                    });
                }
            }
        },
        error : function(){
            console.info("加载数据失败"+data);
        }
    });
    myColumn.push({
        "title": '操作',
        "align": 'center',
        "valign": 'middle',
        "formatter":"operationButton"
    });
    return myColumn;
};

//给操作栏添加编辑删除
function operationButton(value, row, index) {
    return "<a class='edit' href='javascript:;' onclick='updateTicket(this)'>编辑</a><a class='edit' href='javascript:;' onclick='deleteTicket(this)'>删除</a>";
}

//表格属性
var TableInit = function (myColumn) {
    $('#ticketTable').bootstrapTable({
        url: '/openticket/getTicket',        //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        contentType:'application/x-www-form-urlencoded',
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        /* pagination: true,                   //是否显示分页（*）
         sidePagination: "server",  */        //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 20],                 //可供选择的每页的行数（*）
        height: 460,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        queryParams: function () { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            return {
                ticketType: $("#btnGroupVerticalDrop6").text()// 额外添加的参数
            }
        },
        columns: myColumn,
        onLoadSuccess: function (data) {  //加载成功时执行
            console.info("加载成功"+data);
        },
        onLoadError: function (data) {  //加载失败时执行
            console.info("加载数据失败"+data);
        }
    });
};

/**
 * @Description : add_field.js
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */


//由是否必要单选框的改变而改变的默认值的样式
$(function(){
    $(":radio").click(function(){
        if($("#optionsRadios4").is(":checked")){
            $("#defaultLabel").css("color","red");
            $("#defaultLabel").text("默认值（*）");
        }else{
            $("#defaultLabel").css("color","black");
            $("#defaultLabel").text("默认值");
        }
    });
});


//显示用于输入非文本框列的选择值
function showTextarea(obj){
    var select = $(obj).val();
    if("文本框" != select){
        $("#selectTextarea").show();
        $("#optionsRadios4").prop("checked",true);
        $("#optionsRadios5").prop("disabled",true);
    }else{
        $("#selectTextarea").hide();
        $("#optionsRadios5").removeProp("disabled");
    }
}

//进行校验并提交表单
function submitOrder(){
    var name = $("[name=name]").val();
    var fieldName = $("[name=fieldName]").val();
    var selectType = $("#typeSelect").val();
    var defaultValue = $("[name=defaultValue]").val();
    var required = $("[name=optionsRadios]:checked").val();
    var ticketType = $("[name=ticketType]").val();
    var selectValues = $("[name=textareaValue]").val();
    var selectValueList = trimSpace($("[name=textareaValue]").val().split("\n"));

    if("" != name && "" !=fieldName){
        if($("#optionsRadios4").is(":checked")){
            if("" == defaultValue){
                alert("请输入默认值");
                return;
            }
        }
        if("文本框" != selectType){
            if("" == selectValues)
           {
               alert("请输入提供选择的值");
               return;
           }else{
               if (selectValueList.indexOf($("[name=defaultValue]").val()) < 0) {
                   alert("默认值错误");
                   return;
               }
           }
        }
        $.ajax({
            type:"post",
            url:"/openticket/saveField",
            contentType: "application/json",
            //contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            data:JSON.stringify({
                name:name,
                fieldName:fieldName,
                selectType:selectType,
                defaultValue:defaultValue,
                required:required,
                ticketType:ticketType,
                selectValueList:selectValueList
            }),
            success:function(data){
                alert("添加成功！");
                window.location.href="/openticket/index";
            },
            error:function(data){
                alert("添加失败！");
            }
        })
    }else{
        alert("请输入需要添加列的名称或字段名");
    }
}

//数组去空子项
function trimSpace(array) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] == "" || typeof (array[i]) == "undefined") {
            array.splice(i, 1);
            i = i - 1;
        }
    }
    return array;
}

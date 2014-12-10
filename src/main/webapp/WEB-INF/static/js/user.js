/**
**发送post请求，返回的数据为json格式
**
*/
function getUsers(){
    var url = "/user/users";
    var table = $("#userTable");
    $.ajax(
        {
            url:url,
            type:'POST',
            dataType:'json',
            data:{
                username:'zhangdekun'
            },
            success:function(data){
                for(var i=0;i<data.length;i++){
                    var row =data[i];
                     var tr = $("<tr></tr>");
                     tr.append("<td>"+row.username+"</td><td>"+row.password+"</td>");
                     table.append(tr);
                }
            }
        }
    );
}
/*
*发送user对象到后台
*
*/
function addUser(){
    var url = "/user/add";
    var param = {username:"zhangdekun",password:"123456"};
    $.ajax({
        url:url,
        type:'POST',
        dataType:'json',
        data:JSON.stringify(param),
        contentType:'application/json',
        success:function(data){
            alert(data);
        }
    });
}
$(function(){
    getUsers();
    addUser();
});
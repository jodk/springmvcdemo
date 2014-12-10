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
$(function(){
    getUsers();
});
function getUsers(){
    var url = "/user/users"
    $.ajax(
        url:url,
        type:'POST',
        dataType:'json',
        data:{},
        success:function(data){

        }
    );
}

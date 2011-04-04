/**
 * @author MoneyC
 */
//
//document.getElementById("upfile").click(function(){
//	alert("D");
//});

$(document).ready(function(){
    $("#upfile_link").click(function(){
        var album_name = document.getElementById("album_name").value; //获取创建相册的名称
        var album_date = document.getElementById("album_date").value; //获取创建相册的日期
        var album_detail = document.getElementById("album_detail").value; //获取创建相册的详细信息
       
        var strSend = "{name:" + album_name + ",date:" + album_date + ",description:" + album_detail + "}";
		alert(strSend);
        //发送json数据至服务器交互
        
        $.post("createAlbum!createAlbum.action", {
            json: strSend
        }, function(data){
            if (data.msg == "1") {
                alert("Album Created Successfully!");
            }
            else {
                alert("Failed to Create the Album");
            }
        }, "json");
        
    });
	
	$("#upload_pic_link").click(function(){
		//重新打开页面，上传照片
		alert("Begin");
		window.open("UpTest.html");
	});
    
    $("#delete_album_link").click(function(){
        //发送信息至服务器请求删除选中相册
    	var album_names=document.getElementsByTagName("h2");
		var album_name=album_names[1].firstChild.nodeValue;
		alert(album_name);
		
		var strSend="{name:"+album_name+"}";
		$.post("deleteAlbum!delete.action",{json:strSend},function(data){
			
		},"json");
    });
});



/**
 * @author Administrator
 */
function personInfo_Sub(){
	alert("a")
    var radios = document.getElementsByName("sex");
    var c = radios.length;
    var tag = false;
    var val;
    var i = 0;
    for (i = 0; i < c; i++) {
        if (radios[i].checked) {
            tag = true;
            val = radios[i].value;
            break;
        }
    }
    if (tag) {
        //继续执行操作
        var birth_year = document.getElementById("birth_year_id");
        var birth_year_index = birth_year.selectedIndex;
        var birth_year_value = birth_year.options[birth_year_index].value; //获取出生年
        var birth_month = document.getElementById("birth_month_id");
        var birth_month_value = birth_month.options[birth_month.selectedIndex].value; //获取出生月
        var birth_day = document.getElementById("birth_day_id");
        var birth_day_value = birth_day.options[birth_day.selectedIndex].value; //获取出生日
        var place = document.getElementById("living_place_id").value; //获取居住地
        var remark = document.getElementById("remark_id").value; //获取remark
        var old_password = document.getElementById("old_password").value; //获取旧的密码
        var new_first_password = document.getElementById("new_first_password").value; //获取第一次新密码
        var new_second_password = document.getElementById("new_second_password").value; //获取第二次新密码
        if (new_first_password == new_second_password) {
        
            //定义传送数据的json格式
            var strSend = "{sex:"+val +",birthday:"+birth_year_value+"-"+birth_month_value+"-"+birth_day_value+",city:"+place+",remark:"+remark+",password:"+new_first_password+"}";
            jQuery.post("changeInfo!changeInfo.action", {
                json: strSend
            }, function(data){
                if (data.msg == "1") {
                    alert("You Have Changed Successfully");
                }
                else {
                    alert("You Haven't done that!");
                }
            }, "json");
        }
        else {
            alert("Reenter new password!");
        }
    }
    else {
        alert("Please Select");
    }
}


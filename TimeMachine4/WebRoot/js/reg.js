/**
 * @author Administrator
 */
$(document).ready(function(){
    function check(){
    
        var temp = document.getElementById("mail");
        //对电子邮件的验证
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (!myreg.test(temp.value)) {
            alert("Warning!Please Input Valid Email");
            myreg.focus();
            return false;
        }
        else {return true;}
    }
    
    $("#submit").click(function (){
    	 //获取注册的信息，验证并发送
        var mail = document.getElementById("mail").value; //获取email邮箱
        var account = document.getElementById("user_name_id").value; //获取注册用户名
        var first_pass = document.getElementById("user_password_id").value; //获取用户第一次密码
        var second_pass = document.getElementById("user_repass_id").value;//获取用户第二次密码，用以验证
        var sex = document.getElementById("choose_sex");
        var sex_index = sex.selectedIndex;
        var sex_value = sex.options[sex_index].value;//获取性别
        var country = document.getElementById("user_country_id").value; //获取国家名
        var city = document.getElementById("user_city_id").value;		//获取城市名
        
        if (!check()) {
            alert("Email Error");
        }
        else {
            if (second_pass == first_pass) {
                if (account != null) {
                    //发送httprequest请求
                    //利用jQuery的post方法                   
                    //将本地注册数据整合为json格式发送
                    var strSend = "";
                    strSend += "{email:" + mail + ",name:" + account + ",password:" + first_pass + ",";
                    strSend += "sex:" + sex_value + ",country:" + country + ",city:" + city + "}";
                    alert(strSend);
                    jQuery.post("register!register.action", {
                        json: strSend
                    }, function(data){
                        if (data.msg == "1") {
                            alert("You Have Registered Successfully!");
                            setTimeout("location.href='login.jsp'", 50);
                        }
                        else {
                            alert("You Have Failed! Try Again!");
                        }
                    }, "json");
                }
                else {
                    alert("Account Can't Be Empty");
                }
            }
            else {
                alert("Password Error");
            }
        }
    });
    
});

function back(){
        setTimeout("location.href='login.jsp'", 50);
    }








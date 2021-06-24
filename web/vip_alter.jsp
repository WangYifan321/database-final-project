<%@ page import="service.BooktypeService" %>
<%@ page import="serviceImpl.BooktypeServiceImpl" %>
<%@ page import="entity.Booktype" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: wkjiaju
  Date: 2020/12/13
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$index$</title>
    <style>
        body {
            background-color: white;
            margin: 0;
            font-size: x-large;
        }
        div {
            width:100%;
        }
        ul {
            list-style-type:none;
            margin: 0;
            padding: 0;
            overflow:hidden;
            background-color: #333;

        }
        #li1 {
            float: left;
        }
        #li2{
            float: right;
        }
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #333;
        }
        .login{
            margin-right: 10px;
        }
        #left{
            width: 280px;
            float: left;
            margin-left: 12%;
            background-color: #f9f9f9;
            height: 1000px;
        }
        #right{
            width: 1200px;
            float: left;
            background-color: #f3f3f3;
            min-height: 400px;
            height: auto;
            margin-bottom: 100px;
            padding-bottom: 50px;

        }
        .personalInfor {
            height: 165px;
            background: url(http://i.mooc.chaoxing.com/style/defstyle/images/personalBg.jpg) no-repeat #faf7f5 bottom center;
            background-image: url(http://i.mooc.chaoxing.com/style/defstyle/images/personalBg.jpg);
            background-position-x: center;
            background-position-y: bottom;
            background-size: initial;
            background-attachment: initial;
            background-origin: initial;
            background-clip: initial;
            background-color: rgb(250, 247, 245);
            padding-top: 15px;
            text-align: center;
            margin-top: 20px;
        }
        #left a{
            text-decoration: none;
            text-align: center;
            color: #333333;
            font-family: 宋体;
            line-height: 50px;
        }

        input{
            width: 40%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid red;
            border-radius: 4px;
        }
    </style>
    <script>
        function fun() {
            let user = document.getElementById("user").value;
            let password1 = document.getElementById("password1").value;
            let sex = document.getElementById("sex").value;
            let address = document.getElementById("address").value;
            let phone = document.getElementById("phone").value;
            let personid = document.getElementById("personid").value;

            if(user == null || user=='' || password1 =='' || sex == '' || address == '' || phone == '' || personid == ''){
                alert("请补全信息再提交！")
                return false;
            }else{
                if(sex == '男' || sex=='女')
                    return true;
                else{
                    alert("请您输入正确的性别！");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div id='daohang'>
    <ul>
        <li id="li1"><a href='#' style="margin-left: 70px;font-family: 宋体">欢迎光临，网上书店销售系统</a></li>
        <%
            String name = (String)session.getAttribute("user");
            String info;
            if(name == null){
                info = "亲，请先登录";
            }else{
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat( "HH");
                String hour = formatter.format(date);
                if(Integer.parseInt(hour)>12){
                    info = name + " ,下午好！";

                }else{
                    info = name + " ,上午好！";
                }
            }
        %>
        <div class="login">
            <li id="li2"><a href='login.html'style="font-family: 宋体;margin-right: 100px" ><%=info%></a></li>
        </div>
    </ul>
</div>
<div id="left" >
    <div class="personalInfor">
        <a href="vip_alter.jsp">账号管理</a><br>
        <a href="cart.jsp">购物车</a><br>
        <a href="dingdan.jsp">我的订单</a>

    </div>
    <div style="text-align: center">
        <%
            BooktypeService bts = new BooktypeServiceImpl();
            List<Booktype> list = bts.queryAll();
            for(Booktype booktype : list){
        %>
        <a href="querybybooktype?booktype=<%=booktype.getName()%>"><%=booktype.getName() %></a>
        <br>
        <%
            }
        %>
    </div>
</div>
<%
    String username = (String)session.getAttribute("username");

%>
<div id="right">
    <h3>您的用户名是：<%=username%>   ，不可修改，其他为必填。</h3>
    <form action="vip_alter" name="vip_alter" onsubmit="return fun()">
        <br>
        <input type="text" id="user" name="user" placeholder="请输入您的姓名:"><br>

        <input type="password" id="password1" name="password1" placeholder="请输入新密码:"><br>
        <input type="text" id="sex" name="sex" placeholder="请输入性别(男或女):"><br>
        <input type="text" id="address" name="address" placeholder="请输入您新的地址:"><br>
        <input type="text" id="phone" name="phone" placeholder="请输入新手机号:"><br>
        <input type="text" id="personid" name="personid" placeholder="请输入新身份证号:"><br>
        <input type="submit" value="保存修改">
    </form>





</div>
</div>

</body>
</html>


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
            font-family: ??????;
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
                alert("???????????????????????????")
                return false;
            }else{
                if(sex == '???' || sex=='???')
                    return true;
                else{
                    alert("??????????????????????????????");
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<div id='daohang'>
    <ul>
        <li id="li1"><a href='#' style="margin-left: 70px;font-family: ??????">???????????????????????????????????????</a></li>
        <%
            String name = (String)session.getAttribute("user");
            String info;
            if(name == null){
                info = "??????????????????";
            }else{
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat( "HH");
                String hour = formatter.format(date);
                if(Integer.parseInt(hour)>12){
                    info = name + " ,????????????";

                }else{
                    info = name + " ,????????????";
                }
            }
        %>
        <div class="login">
            <li id="li2"><a href='login.html'style="font-family: ??????;margin-right: 100px" ><%=info%></a></li>
        </div>
    </ul>
</div>
<div id="left" >
    <div class="personalInfor">
        <a href="vip_alter.jsp">????????????</a><br>
        <a href="cart.jsp">?????????</a><br>
        <a href="dingdan.jsp">????????????</a>

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
    <h3>?????????????????????<%=username%>   ????????????????????????????????????</h3>
    <form action="vip_alter" name="vip_alter" onsubmit="return fun()">
        <br>
        <input type="text" id="user" name="user" placeholder="?????????????????????:"><br>

        <input type="password" id="password1" name="password1" placeholder="??????????????????:"><br>
        <input type="text" id="sex" name="sex" placeholder="???????????????(?????????):"><br>
        <input type="text" id="address" name="address" placeholder="????????????????????????:"><br>
        <input type="text" id="phone" name="phone" placeholder="?????????????????????:"><br>
        <input type="text" id="personid" name="personid" placeholder="????????????????????????:"><br>
        <input type="submit" value="????????????">
    </form>





</div>
</div>

</body>
</html>


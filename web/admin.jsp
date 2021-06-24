<%@ page import="java.util.List" %>
<%@ page import="entity.Booktype" %>
<%@ page import="service.BooktypeService" %>
<%@ page import="serviceImpl.BooktypeServiceImpl" %>
<%@ page import="service.BookService" %>
<%@ page import="serviceImpl.BookServiceImpl" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="serviceImpl.VipServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
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
            height: 1000px;
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
        .book{
            margin-top: 50px;
            background-color: white;
            height: 330px ;
            width: 83%;
            margin-left: 100px;
        }
        .a{
            float: left;
            width: 25%;

        }
        .b{
            float: right;
            width: 65%;
            margin-right: 60px;
        }
    </style>
</head>
<body>
<div id='daohang'>
    <ul>
        <li id="li1"><a href='#' style="margin-left: 70px;font-family: 宋体">欢迎光临，网上书店后台管理系统</a></li>

    </ul>
</div>
<div id="left" >
    <div class="personalInfor">
        <a href="addbook.html" target="iframe_a">增加图书</a><br>
        <a href="allvip.jsp" target="iframe_a">所有会员</a><br>
        <a href="alldingdan.jsp" target="iframe_a">所有订单</a>

    </div>
    <div style="text-align: center">
        <a href="allbook.jsp" target="iframe_a">所有图书</a><br>
        <a href="fahuo.jsp" target="iframe_a">发货单</a><br>

    </div>
</div>

<iframe src="allbook.jsp" name="iframe_a" style="height: 1000px;width: 69%;float: left"></iframe>

</div>

</body>
</html>

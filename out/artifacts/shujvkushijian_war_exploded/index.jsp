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
      <a href="vip_alterservlet">账号管理</a><br>
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

  <div id="right">
    <%
      BookService bs = new BookServiceImpl();
      List<Book> list_book;
      String stl = (String)session.getAttribute("booktype");
      Booktype bt = bts.queryByName(stl);
      if(stl == null || stl.equals("显示全部")){


        list_book = bs.queryAll();}else{
        list_book = bs.queryAllByBooktype(bt);
      }
      for(Book book : list_book){


    %>

         <div class="book">
           <div class="a" >
         <img src="<%=book.getImg_url()%>" style="margin-top: 10px;height: 300px; width: 250px"></div>
           <div class="b">
             <h3><%=book.getName() %></h3>
              <p style="font-family: 宋体"><%=book.getDescription()%></p>
             <h5>作者：<font style="color: blueviolet"><%=book.getAuthor()%></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               出版社：<font style="color: blueviolet"><%=book.getPress()%></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               发货仓库：<font style="color: blueviolet"><%=book.getCangkuname()%></font></h5>
             <h4 style="margin-top: -10px;line-height: 30px">余量：<font style="color: blueviolet"><%=book.getNum()%></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格：<font style="color: blueviolet ;size: A5" ><%=book.getPrice()%>￥</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="cart?money=<%=book.getPrice()%>&book_name=<%=book.getName()%> &img_url=<%=book.getImg_url()%>&username=<%=session.getAttribute("username")%>" style="text-decoration: none;font-size: x-large" ><font style="color: red ;" ><h3 style="display: inline">加入购物车</h3></font></a></h4>
           </div>


         </div>

<%
  }
%>



    </div>
  </div>

  </body>
</html>

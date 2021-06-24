<%@ page import="service.BookService" %>
<%@ page import="serviceImpl.BookServiceImpl" %>
<%@ page import="entity.Book" %>
<%@ page import="entity.Booktype" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wkjiaju
  Date: 2020/12/21
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    BookService bs = new BookServiceImpl();
    List<Book> list_book;
        list_book = bs.queryAll();
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
        <h4 style="margin-top: -10px;line-height: 30px">余量：<font style="color: blueviolet"><%=book.getNum()%></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格：<font style="color: blueviolet ;size: A5" ><%=book.getPrice()%>￥</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?name=<%=book.getName()%>" style="text-decoration: none;font-size: x-large" ><font style="color: red ;" ><h3 style="display: inline">删除</h3></font></a></h4>
    </div>


</div>

<%
    }
%>
</body>
</html>

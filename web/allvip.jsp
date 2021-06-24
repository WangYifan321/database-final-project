<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Vip" %>
<%@ page import="dao.VipDao" %>
<%@ page import="daoImpl.VipDaoImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wkjiaju
  Date: 2020/12/21
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table tr{
            height: 50px;
        }
    </style>
</head>
<body>
<table width="700px" border="1px" cellspacing="0px" cellpadding="0" style="text-align: center">
    <tr><td>姓名</td><td>用户名</td><td>密码</td><td>性别</td><td>身份证号</td><td>电话</td><td>地址</td><td>操作</td></tr>
    <%
        VipDao vd = new VipDaoImpl();
        List<Vip> list = vd.queryAll();
        for(Vip vip:list){


    %>
    <tr><td><%=vip.getName()%></td>
        <td><%=vip.getUsername()%></td>
        <td><%=vip.getPassword()%></td>
        <td><%=vip.getSex()%></td>
        <td><%=vip.getPersonid()%></td>
        <td><%=vip.getPhone()%></td>
        <td><%=vip.getAddress()%></td>
        <td><a href="deletevip?username=<%=vip.getUsername()%>">删除</a></td>

    </tr>

    <%
        }
    %>
</table>
</body>
</html>
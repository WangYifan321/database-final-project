<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Vip" %>
<%@ page import="dao.VipDao" %>
<%@ page import="daoImpl.VipDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DingDanDao" %>
<%@ page import="daoImpl.DingDanDaoImpl" %>
<%@ page import="entity.Dingdan" %><%--
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
    <tr><td>id</td><td>下单时间</td><td>实收款</td><td>应收款</td><td>状态</td><td>用户id</td></tr>
    <%
        DingDanDao ddd = new DingDanDaoImpl();
        List<Dingdan> list = ddd.queryAll();
        for(Dingdan d : list){


    %>
    <tr><td><%=d.getDingdan_id()%></td>
        <td><%=d.getTime()%></td>
        <td><%=d.getShi_money()%></td>
        <td><%=d.getYing_money()%></td>
        <td><%=d.getState()%></td>
        <td><%=d.getVip_id()%></td>

    </tr>

    <%
        }
    %>
</table>
</body>
</html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Vip" %>
<%@ page import="dao.VipDao" %>
<%@ page import="daoImpl.VipDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="util.DBUtil" %><%--
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
    <tr><td>书名</td><td>用户名</td><td>电话</td><td>地址</td><td>操作</td></tr>
    <%
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            String sql = "select * from fahuo";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                %>
    <tr><td><%=rs.getString("bookname")%></td>
        <td><%=rs.getString("vip_name")%></td>
        <td><%=rs.getString("address")%></td>
        <td><%=rs.getString("phone")%></td>

        <td><a href="#">删除</a></td>

    </tr>

    <%

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }


    %>
</table>
</body>
</html>
<%@ page import="dao.TiaoMuDao" %>
<%@ page import="daoImpl.TiaoMuDaoImpl" %>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.CallableStatement" %>
<%@ page import="dao.VipDao" %>
<%@ page import="daoImpl.VipDaoImpl" %>
<%@ page import="entity.Vip" %>

<%--
  Created by IntelliJ IDEA.
  User: wkjiaju
  Date: 2020/12/22
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart_submit</title>
</head>
<body>
<%
    TiaoMuDao tmd = new TiaoMuDaoImpl();
    String[] params = null;
            params = request.getParameterValues("a");
    if(params.length<=0){
        response.sendRedirect("index.jsp");
    }else {

        VipDao vd= new VipDaoImpl();
        Vip v=vd.queryVipByUsername(session.getAttribute("username").toString());
        int vip_id = v.getVip_id();

        for (int i = 0; i < params.length; i++) {
            Connection conn1 = null;
            CallableStatement csm1 = null;
            ResultSet rs1 = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "wangyifan52199");
                csm1 = conn1.prepareCall("{call open_comment(?,?)}");
                csm1.setInt(1,Integer.parseInt(params[i]));
                csm1.setInt(2,vip_id);
                csm1.execute();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs1 != null) {
                    try {
                        rs1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (csm1 != null) {
                    try {
                        csm1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (conn1 != null) {
                    try {
                        conn1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            tmd.update(Integer.parseInt(params[i]));

        }


        Connection conn = null;
        CallableStatement csm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "wangyifan52199");
            csm = conn.prepareCall("{call submit(?)}");
            csm.setString(1, session.getAttribute("username").toString());

            csm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (csm != null) {
                try {
                    csm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("dingdan.jsp");
    }
%>
</body>
</html>

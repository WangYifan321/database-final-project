import dao.VipDao;
import daoImpl.VipDaoImpl;
import entity.Vip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@WebServlet(name = "DeleteVipServlet",urlPatterns = "/deletevip")
public class DeleteVipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        String stl = (String) request.getParameter("username");
        VipDao vd= new VipDaoImpl();
        Vip v=vd.queryVipByUsername(stl);
        //数据库操作
        Connection conn = null;
        CallableStatement csm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "wangyifan52199");
            csm=conn.prepareCall("{call deletevip(?,?)}");
            csm.setInt(1,v.getVip_id());
            csm.setInt(2,0);
            csm.execute();
            response.sendRedirect("allvip.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            if(csm!=null){
                try {
                    csm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

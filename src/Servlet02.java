import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//管理员登录
@WebServlet(name = "Servlet02",urlPatterns = "/login2")
public class Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("user1"));
        //数据库操作
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "wangyifan52199");
            String sql = "select * from adminuser where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, request.getParameter("user1"));
            ps.setString(2, request.getParameter("password1"));
            rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("admin.jsp");
            }else{
                String a = URLEncoder.encode("密码或用户名错误，请重新输入！", "UTF-8");

                out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));</script>");
                response.setHeader("refresh","2,login.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            if(ps!=null){
                try {
                    ps.close();
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

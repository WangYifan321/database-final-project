import dao.BookDao;
import daoImpl.BookDaoImpl;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.*;

@WebServlet(name = "AddBookServlet",urlPatterns = "/addbook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        //数据库操作
        Connection conn = null;
        CallableStatement csm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "wangyifan52199");
            csm=conn.prepareCall("{call addbook(?,?,?)}");
            csm.setString(1,request.getParameter("cangku"));
            csm.setString(2,request.getParameter("booktype"));
            csm.setString(3,request.getParameter("press"));
            csm.execute();
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
        BookDao bd = new BookDaoImpl();
        Book b = new Book(request.getParameter("bookname"),request.getParameter("author"),request.getParameter("booktype"),Integer.parseInt(request.getParameter("price")),request.getParameter("img_url"),
                request.getParameter("press"),request.getParameter("cangku"),Integer.parseInt(request.getParameter("num")),request.getParameter("description"));
        bd.addBook(b);
        response.sendRedirect("allbook.jsp");
    }
}

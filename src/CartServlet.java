import dao.TiaoMuDao;
import daoImpl.TiaoMuDaoImpl;
import entity.Tiaomu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("username")!=null) {
            TiaoMuDao tmd = new TiaoMuDaoImpl();
            Tiaomu tm = new Tiaomu(1, Integer.parseInt(request.getParameter("money")), request.getParameter("book_name"), request.getParameter("img_url"), request.getParameter("username"));
            tmd.insert(tm);
            String a = URLEncoder.encode("加入成功", "UTF-8");
            out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));</script>");
            response.setHeader("refresh", "1,index.jsp");
        }else{
            response.sendRedirect("login.html");
        }
    }
}

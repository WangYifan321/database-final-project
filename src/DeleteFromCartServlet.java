import dao.TiaoMuDao;
import dao.VipDao;
import daoImpl.TiaoMuDaoImpl;
import daoImpl.VipDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteFromCartServlet",urlPatterns = "/deletecart")
public class DeleteFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        int stl = Integer.parseInt((String) request.getParameter("id"));
        TiaoMuDao tmd = new TiaoMuDaoImpl();
        tmd.delete(stl);
        response.sendRedirect("cart.jsp");
    }
}

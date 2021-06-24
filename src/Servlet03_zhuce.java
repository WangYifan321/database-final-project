import dao.VipDao;
import daoImpl.VipDaoImpl;
import entity.Vip;
import service.VipService;
import serviceImpl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "Servlet03_zhuce" ,urlPatterns = "/login3")
public class Servlet03_zhuce extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VipService vs = new VipServiceImpl();
        VipDao vd = new VipDaoImpl();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("user"));
        Vip vip = new Vip(request.getParameter("user"), request.getParameter("password1"), request.getParameter("user1"),
                request.getParameter("sex"), request.getParameter("personid"), request.getParameter("phone"), request.getParameter("address"));
        if (vd.isExit(request.getParameter("user1"))) {
            String a = URLEncoder.encode("此用户名已存在，请重新注册！", "UTF-8");

            out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));</script>");
            response.setHeader("refresh", "1,zhuce.html");
        } else {
            if (vs.addVip(vip)) {
                String a = URLEncoder.encode("恭喜您，注册成功！", "UTF-8");

                out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));</script>");
                response.setHeader("refresh", "1,login.html");
            } else {
                String a = URLEncoder.encode("注册失败！", "UTF-8");

                out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));</script>");
                response.setHeader("refresh", "1,zhuce.html");
            }
        }
    }
}

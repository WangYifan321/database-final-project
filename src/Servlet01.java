import service.VipService;
import serviceImpl.VipServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.*;
//用户vip登录
@WebServlet(name = "Servlet01",urlPatterns = "/login1")
public class Servlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("user1"));
        VipService vs = new VipServiceImpl();
        if(vs.loginByUsername_password(request.getParameter("user1"),request.getParameter("password1"))!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username",request.getParameter("user1"));//将用户名放入session，用户后期的信息修改和购物车修改
            session.setAttribute("user",vs.queryVipByUsername(request.getParameter("user1")).getName());//用于欢迎导航栏

            response.sendRedirect("index.jsp");
        }else{
            String a = URLEncoder.encode("密码或用户名错误，请重新输入！", "UTF-8");

            out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));</script>");
            response.setHeader("refresh","1,login.html");
        }
    }
}


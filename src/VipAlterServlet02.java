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

@WebServlet(name = "VipAlterServlet02" ,urlPatterns = "/vip_alter")
public class VipAlterServlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        VipService vs = new VipServiceImpl();
        Vip vip = new Vip(request.getParameter("user"), request.getParameter("password1"), (String)request.getSession().getAttribute("username"),
                request.getParameter("sex"), request.getParameter("personid"), request.getParameter("phone"), request.getParameter("address"));
        if(vs.updateVipByUsername((String)request.getSession().getAttribute("username"),vip)){
            String a = URLEncoder.encode("恭喜您，修改成功！请重新登录！", "UTF-8");

            out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));</script>");
            response.setHeader("refresh", "1,login.html");
        }

    }
}

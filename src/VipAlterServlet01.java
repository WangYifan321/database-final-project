import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VipAlterServlet01",urlPatterns = "/vip_alterservlet")
public class VipAlterServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        String name = (String)request.getSession().getAttribute("user");
        if(name == null){
            response.sendRedirect("login.html");
        }else{
            response.sendRedirect("vip_alter.jsp");
        }
    }
}

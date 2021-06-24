import entity.Booktype;
import service.BooktypeService;
import serviceImpl.BooktypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryByBooktypeServlet" ,urlPatterns = "/querybybooktype")
public class QueryByBooktypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        response.setContentType("text/html,charSet=UTF-8");
        PrintWriter out = response.getWriter();
        String stl = (String) request.getParameter("booktype");
        HttpSession session = request.getSession();

        if(stl != "显示全部"){
            session.setAttribute("booktype",stl);
            response.sendRedirect("index.jsp");
        }else{
            session.setAttribute("booktype",null);
        }


    }
}

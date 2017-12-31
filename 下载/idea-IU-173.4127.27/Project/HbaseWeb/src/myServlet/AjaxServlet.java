package myServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet",urlPatterns = {"/myServlet/AjaxServlet"})
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_id=request.getParameter("m_id");
        String attr=request.getParameter("attr");
        String value=request.getParameter("value");
        System.out.println("我得到了值"+m_id+" "+attr+" "+value+"");

        PrintWriter out=response.getWriter();
        out.println("成功");
        out.flush();
        out.close();



    }
}

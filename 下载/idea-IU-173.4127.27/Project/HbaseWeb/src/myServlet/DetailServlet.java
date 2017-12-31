package myServlet;

import myBean.Movie;
import myDB.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DetailServlet",urlPatterns = {"/myServlet/DetailServlet"})
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是用post请求的");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m_id=(String)request.getParameter("m_id");
        System.out.println("我的到了id"+m_id);

        HttpSession session=request.getSession();


        Movie m=null;
        try {
           m = DBUtil.getMovieById(m_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (m!=null)
            System.out.println(m.toString());

        session.setAttribute("movie",m);
        response.sendRedirect("/single.jsp");




    }

}

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
import java.util.*;

@WebServlet(name = "MovieServlet",urlPatterns = {"/myServlet/MovieServlet"})
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是用post请求的");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("已经进入movie列表");

        HttpSession session=request.getSession();

        List<Movie> m=new ArrayList<Movie>();
        try {
            m = DBUtil.getMovieList();
        }catch (Exception e){
            e.printStackTrace();
        }
        session.setAttribute("movie",m);
        response.sendRedirect("/review.jsp");


    }

}

package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String count = request.getParameter("count");
        if (!count.matches("[0-1]+")){
            response.getWriter().append("Wrowadzona warość nie jest liczbą binarną");
            return;
        }
        int result=count.charAt(count.length()-1)-48;
        int pow=1;
        for (int i = count.length()-2; i >= 0; i--) {
            pow*=2;
            result+=(count.charAt(i)-48)*pow;
        }
        response.getWriter()
                .append(count)
                .append(" to liczba ").append(String.valueOf(result));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index_02.html")
                .forward(request, response);
    }
}

package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("visits".equals(cookie.getName())) {
                String visits = cookie.getValue();
                response.getWriter().append("Witaj, odwiedziłeś nas już ")
                        .append(visits).append(" razy");
                visits=String.valueOf(Integer.parseInt(visits)+1);
                Cookie cookieNew = new Cookie("visits", visits);
                cookieNew.setMaxAge(365*24*60*60);
                response.addCookie(cookieNew);
                return;
            }
        }
        response.getWriter().append("Witaj pierwszy raz na naszej stronie");
        Cookie cookie = new Cookie("visits", "1");
        cookie.setMaxAge(365*24*60*60);
        response.addCookie(cookie);
    }
}

package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet_06")
public class Servlet_06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String[] number = request.getParameterValues("num");
        for (String s : number) {
            if (!isDouble(s)) {
                response.getWriter().append("Wrowadzone dane nie są liczbami");
                return;
            }
        }
        PrintWriter writer = response.getWriter();
        writer.append("Liczby:<br>")
                .append(" - ").append(number[0]).append("<br>")
                .append(" - ").append(number[1]).append("<br>")
                .append(" - ").append(number[2]).append("<br>")
                .append(" - ").append(number[3]).append("<br>")
                .append("Średnia:<br>")
                .append(" - ").append(avr(number)).append("<br>")
                .append("Suma:<br>")
                .append(" - ").append(sum(number)).append("<br>")
                .append("Iloczyn:<br>")
                .append(" - ").append(multi(number)).append("<br>");


    }

    protected static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected String avr(String[] num) {
        return String.valueOf(Double.valueOf(sum(num)) / 4);

    }

    protected String sum(String[] num) {
        double sum = 0;
        for (String s : num) {
            sum += Double.parseDouble(s);
        }
        return String.valueOf(sum);
    }

    protected String multi(String[] num) {
        double mul = 1;
        for (String s : num) {
            mul *= Double.parseDouble(s);
        }
        return String.valueOf(mul);

    }

}

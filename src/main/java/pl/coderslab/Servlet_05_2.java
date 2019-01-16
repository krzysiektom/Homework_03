package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        List<String[]> basket = (List<String[]>) session.getAttribute("basket");
        if (basket == null || basket.size() == 0) {
            response.getWriter().append("Brak produktów w koszyku");
            return;
        }
        response.getWriter().append("Zawartość koszyka<br>");
        PrintWriter writer = response.getWriter();
        double sum = 0;
        for (String[] array : basket) {
            double tempSum = Double.parseDouble(array[2]) * Integer.parseInt(array[1]);
            writer.append(array[0])
                    .append(" - ")
                    .append(array[1])
                    .append(" x ")
                    .append(array[2])
                    .append("zł = ")
                    .append(String.valueOf(tempSum))
                    .append("zł<br>");
            sum += tempSum;
        }
        writer.append("SUMA: ").append(String.valueOf(sum)).append("zł");

    }
}

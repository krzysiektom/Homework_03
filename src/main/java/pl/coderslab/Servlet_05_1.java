package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        List<String[]> basket = (List<String[]>) session.getAttribute("basket");
        String product = request.getParameter("name");
        String amount = request.getParameter("amount");
        String price = request.getParameter("price");

        if (product != null && product.length() != 0 && isInteger(amount) && isDouble(price)) {
            basket.add(new String[]{product, amount, price});
            session.setAttribute("basket", basket);
            response.getWriter().append("Produkt dodany");
        } else {
            response.getWriter().append("Wprowadzono niekompletne dane");
        }
        response.getWriter().append(form());
        response.getWriter().append("<br><a href=\"/Servlet_05_2\">Zawartość koszyka</a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        List<String[]> basket = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setAttribute("basket", basket);
        response.getWriter().append(form());
    }

    private String form() {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method=\"post\">")
                .append("<label>")
                .append("<input type=\"text\"  name=\"name\" placeholder=\"Nazwa produktu\"> ")
                .append("<label>")
                .append("<br>")
                .append("<label>")
                .append("<input type=\"number\" step=\"1\" min=\"1\" name=\"amount\" placeholder=\"Ilość\"> ")
                .append("<label>")
                .append("<br>")
                .append("<label>")
                .append("<input type=\"number\" step=\"0.01\" min=\"0.01\" name=\"price\" placeholder=\"Cena\"> ")
                .append("<label>")
                .append("<br>")
                .append("<label>")
                .append("<input type = \"submit\" value = \"Wprowadz dane\">")
                .append("</label>")
                .append("</form>");
        return builder.toString();
    }

    protected static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

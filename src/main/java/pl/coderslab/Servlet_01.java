package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String amount = request.getParameter("amount");
        String convert = request.getParameter("convert");
        double amountDouble;
        try {
            amountDouble = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            response.getWriter().append("Podana wartość nie jest liczbą");
            return;
        }
        switch (convert) {
            case "EURUSD":
                response.getWriter().append(result(convert, amountDouble, 4.2936 / 3.7458));
                break;

            case "USDEUR":
                response.getWriter().append(result(convert, amountDouble, 3.7458 / 4.2936));
                break;

            case "EURPLN":
                response.getWriter().append(result(convert, amountDouble, 4.2936));
                break;

            case "PLNEUR":
                response.getWriter().append(result(convert, amountDouble, 1 / 4.2936));
                break;

            case "USDPLN":
                response.getWriter().append(result(convert, amountDouble, 3.7458));
                break;

            case "PLNUSD":
                response.getWriter().append(result(convert, amountDouble, 1 / 3.7458));
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index_01.html")
                .forward(request, response);
    }

    private String result(String convert, double amount, double rate) {
        StringBuilder text = new StringBuilder();
        text.append("Kwota ")
                .append(amount).append(" w ")
                .append(convert.substring(0, 3))
                .append(" po przeliczeniu na ")
                .append(convert.substring(3))
                .append(" wynosi: ")
                .append(amount * rate);
        return text.toString();
    }
}

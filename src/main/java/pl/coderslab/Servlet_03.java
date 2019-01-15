package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet_03")
public class Servlet_03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String[] text = request.getParameterValues("input");
        HttpSession session = request.getSession();
        session.setAttribute("input", text);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String[] input = (String[]) session.getAttribute("input");
        if (input == null) {
            input = new String[]{"", "", "", "", ""};
        }
        PrintWriter writer = response.getWriter();
        writer.append("<form method=\"post\">");
        for (int i = 0; i < 5; i++) {
            writer.append("<label>")
                    .append("<input type=\"text\"  name=\"input\" value=\"")
                    .append(input[i])
                    .append("\">")
                    .append("<label>").append("<br>");
        }
        writer.append("<label>")
                .append("<input type = \"submit\" value = \"Wprowadz dane\">")
                .append("</label>")
                .append("</form>");

    }
}

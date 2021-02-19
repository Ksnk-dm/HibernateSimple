package servlets;

import dao.EmailImpl;
import entity.Emails;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddEmailServlet", value = "/AddEmailServlet")
public class AddEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailImpl email = new EmailImpl();
        String em = request.getParameter("email"); //почта для рассылки
        String cur = request.getParameter("cur"); // так как json возвращает много курсов, возможно ввести на выбор для россылки
        Emails emails = new Emails(em, cur);
        email.insert(emails);
        response.sendRedirect("/index.jsp");
    }

}

package servlets;

import dao.EmailImpl;
import entity.Emails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelEmailServlet", value = "/delemail")
public class DelEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailImpl email = new EmailImpl();
        Emails emails = new Emails();
        String em = request.getParameter("delemail");
        emails.setEmail(em);
        email.delete(emails);
        response.sendRedirect("/index.jsp");
    }
}

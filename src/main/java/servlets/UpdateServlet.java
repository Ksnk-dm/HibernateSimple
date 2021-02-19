package servlets;


import dao.ExchangeImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExchangeImpl exchange = new ExchangeImpl();
        exchange.insertCurrentDay(); //ручное добавление курса за сегодня в бд
        resp.sendRedirect("/index.jsp");
    }
}

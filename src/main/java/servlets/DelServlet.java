package servlets;
import dao.ExchangeImpl;
import entity.Exchange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelServlet", value = "/DelServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExchangeImpl excImpl = new ExchangeImpl();
        Exchange exchange =new Exchange();
        String em = request.getParameter("delname");
        exchange.setExcheName(em);
        excImpl.delete(exchange);
        response.sendRedirect("/index.jsp");
    }

}

package servlets;

import com.google.gson.Gson;
import dao.ExchangeImpl;
import entity.Exchange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("list");
        ExchangeImpl exchange = new ExchangeImpl();
        List<Exchange> list = exchange.getAll();
        Double max = exchange.getMax(parameter);
        Double avg = exchange.getAvg(parameter);
        request.setAttribute("all", list);
        request.setAttribute("max", max);
        request.setAttribute("avg", avg);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }




}

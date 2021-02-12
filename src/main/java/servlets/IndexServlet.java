package servlets;

import com.google.gson.Gson;
import dao.ExchangeImpl;
import entity.Exchange;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@WebServlet(name = "indexServlet", value = "/indexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExchangeImpl excImpl = new ExchangeImpl();
        for (int i = 1; i <= 10; i++) { //да-да все таже конструкция :)
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=202101" + i + "&json");
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                Gson gson = new Gson();
                Exchange[] curs = gson.fromJson(in, Exchange[].class);
                for (Exchange user : curs) {
                    excImpl.insert(user);
                }

            }
        }

        response.sendRedirect("/index.jsp");
    }


}

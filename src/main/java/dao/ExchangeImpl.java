package dao;

import com.google.gson.Gson;
import entity.Exchange;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExchangeImpl extends Dao<Exchange> {
    @Override
    public void insert(Exchange exchange) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(exchange);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Exchange a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete Exchange where excheName=:course").setParameter("course", a.getExcheName()).executeUpdate();
        session.close();
    }

    @Override
    public List<Exchange> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Exchange> list = session.createQuery("SELECT c FROM Exchange c", Exchange.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }


    public Double getMax(String currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Double a = session.createQuery(
                "select MAX(rate) from Exchange where excheName=:currency", Double.class).setParameter("currency", currency).getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }


    public Double getAvg(String currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Double a = session.createQuery(
                "SELECT AVG(rate) FROM Exchange WHERE  excheName=:currency", Double.class).setParameter("currency", currency).getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }

    public Double currentDay(String cur) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Double a = session.createQuery(
                "SELECT rate FROM Exchange where exchangedate=:date and excheName=:cur", Double.class)
                .setParameter("date", dateFormat.format(new Date())).setParameter("cur", cur)
                .getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }

    /*Отказался от цикла для создания периода, добавлена возможность добавления только одного дня
        так при постоянной работе на сервере, каждый день в время заданное в слушателе будет происходить добавление нового дня
        и рассылка подписавшимся */
    public void insertCurrentDay() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println("date: " + dateFormat.format(new Date()));
        URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=" + dateFormat.format(new Date()) + "&json");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            Gson gson = new Gson();
            Exchange[] curs = gson.fromJson(in, Exchange[].class);
            for (Exchange user : curs) {
                insert(user);
            }
        }
    }
}

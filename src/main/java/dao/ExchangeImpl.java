package dao;

import entity.Exchange;
import org.hibernate.Session;
import utils.HibernateUtil;

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
    public Double getMax(String currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Double a = session.createQuery(
                "select MAX(rate) from Exchange where cc=:currency", Double.class).setParameter("currency", currency).getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }


    @Override
    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from Exchange").executeUpdate();
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


    @Override
    public Double getAvg(String currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Double a = session.createQuery(
                "SELECT AVG(rate) FROM Exchange WHERE cc=:currency", Double.class).setParameter("currency", currency).getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }
}

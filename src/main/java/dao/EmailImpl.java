package dao;

import entity.Emails;
import org.hibernate.Session;
import utils.HibernateUtil;
import java.util.List;

public class EmailImpl extends Dao<Emails> {
    @Override
    public void insert(Emails email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(email);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Emails emails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete Emails where email=:email").setParameter("email", emails.getEmail()).executeUpdate();
        session.close();
    }

    @Override
    public List<Emails> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Emails> list = session.createQuery("SELECT c FROM Emails c", Emails.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}

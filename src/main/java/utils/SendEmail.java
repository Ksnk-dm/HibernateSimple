package utils;

import dao.EmailImpl;
import dao.ExchangeImpl;
import entity.Emails;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;


public class SendEmail {
    private ExchangeImpl exchange = new ExchangeImpl();
    private EmailImpl email = new EmailImpl();
    private List<Emails> list = email.getAll();


    public void send() {
        if (list.isEmpty()) {
            System.out.println("пустой лист");
        } else {
            for (Emails a : list) {
                String to = a.getEmail();
                String from = "ukrkosenko@gmail.com";
                String host = "smtp.gmail.com";
                Properties properties = System.getProperties();
                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication("ukrkosenko", "0662272779dima");
                    }
                });
                SendM(session, from, to, a);
            }
        }
    }


    private void SendM(Session session, String from, String to, Emails a) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Рассылка курса валют");
            message.setText("Валюта " + a.getCurrency() + " Курс за сегодня "
                    + exchange.currentDay(a.getCurrency())
                    + " Максимум за период: " + exchange.getMax(a.getCurrency())
                    + " Средний курс за период :" + exchange.getAvg(a.getCurrency()));

            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


}


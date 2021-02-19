package utils;

import dao.ExchangeImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class SendAndInsertJob implements Job {
    private ExchangeImpl exchange = new ExchangeImpl();
    private SendEmail sendEmail = new SendEmail();


    /* При выполнении планировщика выполняется добавление в бд курса за сегодня
    после происходит отправка, есть баг если два раза добавить в бд один день
    рассылка остановится так как возвращаеться несколько одинаковых  эллементов
     */
    public void execute(JobExecutionContext context) {
        exchange.insertCurrentDay();
        sendEmail.send();
    }
}







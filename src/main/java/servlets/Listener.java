package servlets;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import utils.SendAndInsertJob;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@WebListener
public class Listener implements ServletContextListener {
    Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
        System.out.println("Context Initialized");
        try {
            JobDetail job = newJob(SendAndInsertJob.class).withIdentity(
                    "CronQuartzJob", "Group").build();
            Trigger trigger = newTrigger()
                    .withIdentity("TriggerName", "Group")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) //для теста выставлена 1 минута, документация по времени http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html
                    .build();
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContext) {
        System.out.println("Context Destroyed");
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}


package es.ubiqua.nhservices.cron;

import javax.servlet.http.HttpServlet;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import es.ubiqua.nhservices.jobs.BreakfastServiceJob;

import javax.servlet.*;

public class breakfast extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
    {
		cronBreakfastServiceJob();
    }
	
	public void cronBreakfastServiceJob(){
		try {
			String triggerName = "BreakfastServiceTrigger";
			JobDetail breakfastServiceJob = JobBuilder.newJob(BreakfastServiceJob.class).withIdentity("BreakfastServiceJob", "breakfastService").build();
			//Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "breakfastService").withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 * * ? *")).build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "breakfastService").withSchedule(CronScheduleBuilder.cronSchedule("0 36 10 * * ? *")).build();
			Scheduler scheduler;
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(breakfastServiceJob, trigger);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
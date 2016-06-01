package es.ubiqua.nhservices.jobs;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import es.ubiqua.nhservices.manger.BreakfastRequestsManager;
import es.ubiqua.nhservices.manger.BreakfastServiceRequestsManager;
import es.ubiqua.nhservices.model.BreakfastRequests;
import es.ubiqua.nhservices.model.BreakfastServiceRequests;
import es.ubiqua.nhservices.utils.Utils;

public class BreakfastServiceJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		InputStream inputStream = null;
				
		List<BreakfastServiceRequests> breakfastServiceRequests = new BreakfastServiceRequestsManager().listToday();
		BreakfastRequests breakfastRequests = new BreakfastRequests();
		
		if (!breakfastServiceRequests.isEmpty()){
			
			breakfastRequests.setActived(false);
			breakfastRequests = new BreakfastRequestsManager().add(breakfastRequests);
			
			inputStream = Utils.breakfastServiceListPDF(breakfastServiceRequests);
			
			try {
				Utils.sendMailBreakfastService(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					Utils.llamadaBreakfast();
				}
			});
			t.start();
			
			Utils.cronBreakfastAlerts(1);
			
		}
        
    }
}

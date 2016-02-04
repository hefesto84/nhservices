package es.ubiqua.nhservices.jobs;

import java.io.IOException;
import java.util.Date;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;

import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

public class WakeUpNoRespondJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		System.out.println("Job2 --->>> No Respond! Time is " + new Date());

		String randomId = ""+context.getJobDetail().getJobDataMap().get("RandomId");
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(randomId);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		if(wakeUpAlarm.getActived() == false){
			ManagerConnectionFactory factory = new ManagerConnectionFactory("192.168.1.200", "ubiqua", "ubiqua.456");

			ManagerConnection managerConnection = factory.createManagerConnection();
	        
	        OriginateAction originateAction;
	        ManagerResponse originateResponse;
	        
	        long espera = 30000; 

	        originateAction = new OriginateAction();
	        originateAction.setChannel("SIP/2001");
	        originateAction.setContext("default");
	        originateAction.setExten("2000");
	        originateAction.setApplication("Playback");
	        originateAction.setData("tt-monkeys");
	        originateAction.setPriority(new Integer(1));
	        originateAction.setTimeout(espera);
	        originateAction.setCallerId("No respuesta despertador");

	        // connect to Asterisk and log in
			try {
				managerConnection.login();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AuthenticationFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // send the originate action and wait for a maximum of 30 seconds for Asterisk
	        // to send a reply
			try {
				originateResponse = managerConnection.sendAction(originateAction,30000);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			managerConnection.logoff();
			
		}
		
		Utils.stopCronNoRespond(wakeUpAlarm, "noRespondWakeUp");
        
    }
}

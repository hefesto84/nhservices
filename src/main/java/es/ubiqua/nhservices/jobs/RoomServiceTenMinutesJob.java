package es.ubiqua.nhservices.jobs;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import es.ubiqua.nhservices.manger.RoomServiceRequestsManager;
import es.ubiqua.nhservices.model.RoomServiceRequests;
import es.ubiqua.nhservices.utils.Utils;

public class RoomServiceTenMinutesJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		String randomId = ""+context.getJobDetail().getJobDataMap().get("RandomId");
		RoomServiceRequests roomServiceRequests = new RoomServiceRequests();
		roomServiceRequests.setRandomId(randomId);
		RoomServiceRequestsManager roomServiceRequestsManager = new RoomServiceRequestsManager();
		roomServiceRequests = roomServiceRequestsManager.getByRandomId(roomServiceRequests);
		if(roomServiceRequests.getActived() == false){
			
			ManagerConnectionFactory factory = new ManagerConnectionFactory("localhost", "ubiqua", "ubiqua.456");

			ManagerConnection managerConnection = factory.createManagerConnection();
	        
	        OriginateAction originateAction;
	        ManagerResponse originateResponse;
	        
	        long espera = 20000; 
	        
	        originateAction = new OriginateAction();
	        originateAction.setChannel("SIP/1011");
	        originateAction.setContext("default");
	        originateAction.setExten("1012");
	        originateAction.setApplication("Playback");
	        originateAction.setData("tt-monkeys");
	        originateAction.setPriority(new Integer(1));
	        originateAction.setTimeout(espera);
	        originateAction.setCallerId("RoomService");

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
		
		Utils.stopCronRoomServiceTenMinutes(roomServiceRequests, "roomServiceTenMinutes");

    }
}

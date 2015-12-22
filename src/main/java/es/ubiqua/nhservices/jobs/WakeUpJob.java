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

public class WakeUpJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		System.out.println("Job1 --->>> Hello geeks! Time is " + new Date());
        
		/*ManagerConnectionFactory factory = new ManagerConnectionFactory("192.168.1.200", "ubiqua", "ubiqua.456");

		ManagerConnection managerConnection = factory.createManagerConnection();
        
        OriginateAction originateAction;
        ManagerResponse originateResponse;

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/2000");
        originateAction.setContext("default");
        originateAction.setExten("2002");
        originateAction.setApplication("Playback");
        originateAction.setData("tt-monkeys");
        originateAction.setPriority(new Integer(1));

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
			originateResponse = managerConnection.sendAction(originateAction, 30000);
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

        // print out whether the originate succeeded or not

        // and finally log off and disconnect
        //managerConnection.logoff();*/
        
        
        
        
        
    }
}

package es.ubiqua.nhservices.jobs;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.ubiqua.nhservices.constants.constants;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

public class WakeUpJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		String room = ""+context.getJobDetail().getJobDataMap().get("Room");
		String  wakeUpTime = ""+context.getJobDetail().getJobDataMap().get("Hour");
		String randomId = ""+context.getJobDetail().getJobDataMap().get("RandomId");
		String lang = ""+context.getJobDetail().getJobDataMap().get("Lang");
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory(constants.dominio, "ubiqua", "ubiqua.456");

		ManagerConnection managerConnection = factory.createManagerConnection();
        
        OriginateAction originateAction;
        ManagerResponse originateResponse;
        Boolean respondido = false;
        
        long espera = 20000; 
        
        int extension = (Integer) context.getJobDetail().getJobDataMap().get("Extension");

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/"+extension+"");
        originateAction.setContext("default");
        originateAction.setExten(String.valueOf(extension+2000));
        originateAction.setApplication("Playback");
        originateAction.setData("custom/"+lang+"_wakeUp");
        originateAction.setPriority(new Integer(1));
        originateAction.setTimeout(espera);
        originateAction.setCallerId("Despertador");
        
        try{
        	managerConnection.login();
        	
        	try {
				originateResponse = managerConnection.sendAction(originateAction,30000);
				if(originateResponse.getResponse().equals("Success")){
					respondido = true;
				}
			} catch(Exception e){
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				Utils.mailErrorAsterisk("ActionCall Despertador", errors.toString());
				
			}finally {
				managerConnection.logoff();
			}
        	
        }catch(Exception e){
        	StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Utils.mailErrorAsterisk("Login Despertador", errors.toString());
        }
		
        WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(randomId);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		
		if (respondido == false){
			Utils.sendMailWakeUpNoRespond(room, wakeUpTime, randomId);
			Utils.cronWakeUpNoResponse(wakeUpAlarm);
		} else {
			Utils.confirmDespertador(randomId);
		}
		
		Utils.stopCron(wakeUpAlarm, "wakeUp");
        
    }
	
}

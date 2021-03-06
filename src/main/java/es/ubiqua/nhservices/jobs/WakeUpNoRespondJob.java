package es.ubiqua.nhservices.jobs;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.action.OriginateAction;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.ubiqua.nhservices.constants.constants;
import es.ubiqua.nhservices.manger.RoomExtensionManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.RoomExtension;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

public class WakeUpNoRespondJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        
		String randomId = ""+context.getJobDetail().getJobDataMap().get("RandomId");
		int extension = (Integer) context.getJobDetail().getJobDataMap().get("Room") + 2000;
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(randomId);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		if(wakeUpAlarm.getActived() == false){
			
			RoomExtension roomExtension = new RoomExtension();
			roomExtension.setRoom(1010);
			roomExtension = new RoomExtensionManager().get(roomExtension);
			
			ManagerConnectionFactory factory = new ManagerConnectionFactory(constants.dominio, "ubiqua", "ubiqua.456");

			ManagerConnection managerConnection = factory.createManagerConnection();
	        
	        OriginateAction originateAction;
	        
	        long espera = 30000; 

	        originateAction = new OriginateAction();
	        originateAction.setChannel("SIP/"+roomExtension.getExtension());
	        originateAction.setContext("default");
	        originateAction.setExten(String.valueOf(extension));
	        originateAction.setApplication("Playback");
	        originateAction.setData("custom/wakeUpNoRespond");
	        originateAction.setPriority(new Integer(1));
	        originateAction.setTimeout(espera);
	        originateAction.setCallerId("No respuesta despertador");
	        
	        try{
	        	managerConnection.login();
	        	
	        	try {
	        		managerConnection.sendAction(originateAction,30000);
				} catch(Exception e){
					StringWriter errors = new StringWriter();
					e.printStackTrace(new PrintWriter(errors));
					Utils.mailErrorAsterisk("ActionCall Despertador No Respuesta", errors.toString());
					
				}finally {
					managerConnection.logoff();
				}
	        	
	        }catch(Exception e){
	        	StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				Utils.mailErrorAsterisk("Login Despertador No Respuesta", errors.toString());
	        }
			
		}
		
		Utils.stopCronNoRespond(wakeUpAlarm, "noRespondWakeUp");
        
    }
}

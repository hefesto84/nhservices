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
import es.ubiqua.nhservices.model.RoomExtension;
import es.ubiqua.nhservices.utils.Utils;

public class BreakfastNoRespondJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory(constants.dominio, "ubiqua", "ubiqua.456");
		ManagerConnection managerConnection = factory.createManagerConnection();
		
		RoomExtension roomExtension = new RoomExtension();
		roomExtension.setRoom(1011);
		roomExtension = new RoomExtensionManager().get(roomExtension);
        
        OriginateAction originateAction;
        
        long espera = 30000; 

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/"+roomExtension.getExtension());
        originateAction.setContext("default");
        originateAction.setExten("1012");
        originateAction.setApplication("Playback");
        originateAction.setData("custom/breakfast");
        originateAction.setPriority(new Integer(1));
        originateAction.setTimeout(espera);
        originateAction.setCallerId("No respuesta room service");
        
        try{
        	managerConnection.login();
        	
        	try {
				managerConnection.sendAction(originateAction,30000);
			} catch(Exception e){
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				Utils.mailErrorAsterisk("ActionCall Breakfast No Respond", errors.toString());
				
			}finally {
				managerConnection.logoff();
			}
        	
        }catch(Exception e){
        	StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Utils.mailErrorAsterisk("Login Breakfast No Respond", errors.toString());
        }

		Utils.stopCronNoRespondBreakfast();
        
    }
}

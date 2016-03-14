package es.ubiqua.nhservices.utils;

import com.opensymphony.xwork2.ActionSupport;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.print.Doc;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import es.ubiqua.nhservices.constants.constants;
import es.ubiqua.nhservices.jobs.BreakfastAlertsJob;
import es.ubiqua.nhservices.jobs.BreakfastNoRespondJob;
import es.ubiqua.nhservices.jobs.RoomServiceNoRespondJob;
import es.ubiqua.nhservices.jobs.RoomServiceTenMinutesJob;
import es.ubiqua.nhservices.jobs.WakeUpJob;
import es.ubiqua.nhservices.jobs.WakeUpNoRespondJob;
import es.ubiqua.nhservices.manger.RoomExtensionManager;
import es.ubiqua.nhservices.manger.RoomServiceAnswersManager;
import es.ubiqua.nhservices.manger.RoomServiceListManager;
import es.ubiqua.nhservices.manger.RoomServiceQuestionsManager;
import es.ubiqua.nhservices.manger.RoomServiceRequestsManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.BreakfastRequests;
import es.ubiqua.nhservices.model.BreakfastServiceRequestProduct;
import es.ubiqua.nhservices.model.BreakfastServiceRequests;
import es.ubiqua.nhservices.model.RoomExtension;
import es.ubiqua.nhservices.model.RoomServiceAnswers;
import es.ubiqua.nhservices.model.RoomServiceList;
import es.ubiqua.nhservices.model.RoomServicePreguntas;
import es.ubiqua.nhservices.model.RoomServiceQuestions;
import es.ubiqua.nhservices.model.RoomServiceRequestProduct;
import es.ubiqua.nhservices.model.RoomServiceRequests;
import es.ubiqua.nhservices.model.WakeUpAlarm;
/*
import infobip.api.client.SendSingleTextualSms;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;
*/

public class Utils extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<RoomServicePreguntas> obtenerQuestionsProductosRoomService(int id, String lang){
		
		
		List<RoomServiceQuestions> roomServiceQuestions = new RoomServiceQuestionsManager().listByProduct(id, lang);
		
		ArrayList<RoomServicePreguntas> preguntas = new ArrayList<RoomServicePreguntas>();
		
		for (RoomServiceQuestions question:roomServiceQuestions){
			List<RoomServiceAnswers> roomServiceAnswers = new RoomServiceAnswersManager().listByPlato(question, lang);
			RoomServicePreguntas roomServicePreguntas = new RoomServicePreguntas();
			roomServicePreguntas.setId_plato(question.getId_plato());
			roomServicePreguntas.setId_question(question.getId_question());
			roomServicePreguntas.setPregunta(question.getQuestion());
			roomServicePreguntas.setRespuesta(roomServiceAnswers);
			preguntas.add(roomServicePreguntas);
		}
		
		return preguntas;
	}
	
	public static InputStream roomServicePDF(RoomServiceRequests roomService){
		
		InputStream inputStream = null;
		
        Document document = new Document();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, buffer);
            document.open();
            
            document.add(new Paragraph("Nueva comanda Room Service"));
            document.add(new Paragraph("Habitación : "+roomService.getRoom()));
            document.add(new Paragraph("Programado para : "+roomService.getRequestTime()));
            document.add(new Paragraph("Número de personas : "+roomService.getPeople()));
            
            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            
            float[] columnWidths = {1f, 0.3f};
            table.setWidths(columnWidths);
     
            PdfPCell cell1 = new PdfPCell(new Paragraph("Producto"));
            cell1.setBorderColor(BaseColor.BLACK);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            PdfPCell cell2 = new PdfPCell(new Paragraph("Cantidad"));
            cell2.setBorderColor(BaseColor.BLACK);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1);
            table.addCell(cell2);
            
            ArrayList<RoomServiceRequestProduct> list = new ArrayList<RoomServiceRequestProduct>();
            list = new Gson().fromJson(roomService.getProducts(), new TypeToken<ArrayList<RoomServiceRequestProduct>>() {}.getType());
            
            for (RoomServiceRequestProduct product : list){
        		
            	if(product != null){
  
            		if (!product.getIngredients().isEmpty()){
            			String content = getProductById(product.getId());
            			String[] ingredients = product.getIngredients().split("#");
            			for (int i = 0; i < ingredients.length; i++){
            				content += "\n        -"+getProductById(Integer.parseInt(ingredients[i]));
            			}
            			table.addCell(content);
            		} else {
            			table.addCell(getProductById(product.getId()));
            		}
            		
                	table.addCell(String.valueOf(product.getQuantity()));
            	}
            }
     
            document.add(table);
            
            if (roomService.getComments() != null && !roomService.getComments().isEmpty()) {
            	document.add(new Paragraph("Comentarios : "+roomService.getComments()));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        byte[] bytes = null;
        bytes = buffer.toByteArray();
        
        if(bytes!=null){
            inputStream = new ByteArrayInputStream ( bytes );
        }
		
		return inputStream;
	}
	
	
	
	private static String getProductById (int id){
		
		RoomServiceList roomServiceList = new RoomServiceList();
		roomServiceList.setId(id);
		roomServiceList = new RoomServiceListManager().get(roomServiceList);
		String respuesta = roomServiceList.getTitulo() + " " + roomServiceList.getSubtitulo();
		return respuesta;
		
	}
	
	public static void sendMailRoomService(InputStream prova, RoomServiceRequests roomService) throws IOException{
		
		final String username = "rocprat@gmail.com";
		final String password = "Roccopl2006";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
						
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rocprat@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("r.prat@ubiqua.es"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("jordi@ubiqua.es"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("dani@ubiqua.es"));
			message.setSubject("Room Service Request");
			
			Multipart multipart = new MimeMultipart();    
			
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("Hola, "
            		+ "\n\nSe ha recibido una nueva petición de room Service"
            		+ "\n\nHabitación : "+roomService.getRoom()+""
            		+ "\n\nSolicitado para : "+roomService.getRequestTime()+""
            		+ "\n\nNúmero de personas : "+roomService.getPeople()+"\n\n");
            multipart.addBodyPart(messageBodyPart1); 
            
            BodyPart messageBodyPart2 = new MimeBodyPart(); 
            messageBodyPart2.setText("<table style='border-collapse: collapse;'>"
            		+ "<tr>"
            		+ "<td style='font-weight: bold;border: 1px solid #000000;padding: 5px;'>Producto</td><td style='font-weight: bold;border: 1px solid #000000;padding: 5px;'>Cantidad</td>"
            		+ "</tr>");
            messageBodyPart2.setHeader("Content-Type", "text/html");
            multipart.addBodyPart(messageBodyPart2); 
            
            ArrayList<RoomServiceRequestProduct> list = new ArrayList<RoomServiceRequestProduct>();
            list = new Gson().fromJson(roomService.getProducts(), new TypeToken<ArrayList<RoomServiceRequestProduct>>() {}.getType());
            for (RoomServiceRequestProduct product : list){
            	if(product != null){
            		String content = "<tr>"
                    		+ "<td style='border: 1px solid #000000;padding: 5px;'>"+getProductById(product.getId())+"";
            		if (!product.getIngredients().isEmpty()){
            			String[] ingredients = product.getIngredients().split("#");
            			for (int i = 0; i < ingredients.length; i++){
            				content += "<br>    -"+getProductById(Integer.parseInt(ingredients[i]));
            			}
            			content += "</td><td style='text-align: center;border: 1px solid #000000;padding: 5px;'>"+product.getQuantity()+"</td></tr>";
            			BodyPart messageBodyPartVariable = new MimeBodyPart(); 
                		messageBodyPartVariable.setText(content);
                		messageBodyPartVariable.setHeader("Content-Type", "text/html");
                		multipart.addBodyPart(messageBodyPartVariable);
            		} else {
            			BodyPart messageBodyPartVariable = new MimeBodyPart(); 
                		messageBodyPartVariable.setText("<tr>"
                        		+ "<td style='border: 1px solid #000000;padding: 5px;'>"+getProductById(product.getId())+"</td><td style='text-align: center;border: 1px solid #000000;padding: 5px;'>"+product.getQuantity()+"</td>"
                        		+ "</tr>");
                		messageBodyPartVariable.setHeader("Content-Type", "text/html");
                		multipart.addBodyPart(messageBodyPartVariable);
            		}
            	}
            }
            BodyPart messageBodyPart3 = new MimeBodyPart(); 
            messageBodyPart3.setText("</table>");
            messageBodyPart3.setHeader("Content-Type", "text/html");
            multipart.addBodyPart(messageBodyPart3); 
            
            BodyPart messageBodyPart4 = new MimeBodyPart(); 
            	
            if (roomService.getComments() != null && !roomService.getComments().isEmpty()) {
            	BodyPart messageBodyPartComments = new MimeBodyPart();     
            	messageBodyPartComments.setText("\n\nComentarios : "+roomService.getComments()+"\n");
                multipart.addBodyPart(messageBodyPartComments);
            }
            
            messageBodyPart4.setText("\n\nConfirma en el siguiente enlace la recepción de este correo:"
            		+ "\nhttp://localhost:8080/NHServices/api/confirmationRoomService?id="+roomService.getRandomId()); 
            multipart.addBodyPart(messageBodyPart4); 
   
            message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	/*public static void printPDF(Doc doc) throws PrinterException{
		
		PrintService[] printService;
		printService = PrinterJob.lookupPrintServices();
		
		DocPrintJob printJob = printService[0].createPrintJob();

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add (new Copies (1));
        aset.add (OrientationRequested.PORTRAIT);
        aset.add (Sides.ONE_SIDED);
        aset.add (MediaSizeName.ISO_A4);
	    
	    try {
	    	printJob.print(doc, aset);
	    } catch (Exception PrintException) {
	    	PrintException.printStackTrace();
	    }
		
	}*/
	
	
	public static void sendMailWakeUpNoRespond(String room, String time, String randomId){
		
		final String username = "noreplyavisostablet@gmail.com";
		final String password = "nhconstanza";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
						
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreplyavisostablet@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("r.prat@ubiqua.es"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("jordi@ubiqua.es"));
			message.setSubject("Despertador no respondido");
			/*message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");*/
			
			//3) create MimeBodyPart object and set your message text        
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("El despertador programado en:");
            BodyPart messageBodyPart2 = new MimeBodyPart();     
            messageBodyPart2.setText("\nHabitación : "+room);
            BodyPart messageBodyPart3 = new MimeBodyPart();     
            messageBodyPart3.setText("\nProgramado para : "+time);
            BodyPart messageBodyPart4 = new MimeBodyPart();     
            messageBodyPart4.setText("\nNo se ha llebado a cabo.\nSi has leido este mail, corfirma en el siguiente enlace:");
            BodyPart messageBodyPart5 = new MimeBodyPart();     
            messageBodyPart5.setText("\nhttp://"+constants.dominio+":8080/NHServices/api/confirmationWakeUp?id="+randomId);          

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);      
            multipart.addBodyPart(messageBodyPart3);      
            multipart.addBodyPart(messageBodyPart4);      
            multipart.addBodyPart(messageBodyPart5);    

            //6) set the multiplart object to the message object    
            message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void sendSMSWakeUpAlarm(WakeUpAlarm wakeUpAlarm){
		/*
		SendSingleTextualSms client = new SendSingleTextualSms(new BasicAuthConfiguration("nhtel20", "Nx0716rn"));
		
		SMSTextualRequest requestBody = new SMSTextualRequest();
		requestBody.setFrom("NHTEL20");
		requestBody.setTo(Arrays.asList("34650583420"));
		requestBody.setText("Nuevo despertador:\nHAC:"+wakeUpAlarm.getRoom()+"\nHora:"+wakeUpAlarm.getWakeUpTime());
		
		SMSResponse response = client.execute(requestBody);
		
		SMSResponseDetails sentMessageInfo = response.getMessages().get(0);
        System.out.println("Message ID: " + sentMessageInfo.getMessageId());
        System.out.println("Receiver: " + sentMessageInfo.getTo());
        System.out.println("Message status: " + sentMessageInfo.getStatus().getName());
        */
	}
	
	
	public static void CronWakeUp(WakeUpAlarm wakeUpAlarm, String lang){
		
		Date date = new Date(wakeUpAlarm.getWakeUpTime().getTime());
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		String wakeUpTime;
		if ((minute >= 0) && (minute < 10)){
			wakeUpTime = day+"-"+month+"-"+year+" "+hour+":0"+minute;
		}else{
			wakeUpTime = day+"-"+month+"-"+year+" "+hour+":"+minute;
		}
		
		RoomExtension roomExtension = new RoomExtension();
		roomExtension.setRoom(wakeUpAlarm.getRoom());
		roomExtension = new RoomExtensionManager().get(roomExtension);
		
		try{
			String triggerName = wakeUpAlarm.getRandomId() + "Trigger";
			JobDetail wakeUpJob = JobBuilder.newJob(WakeUpJob.class).withIdentity(wakeUpAlarm.getRandomId(), "wakeUp").build();
			wakeUpJob.getJobDataMap().put("Extension",roomExtension.getExtension());
			wakeUpJob.getJobDataMap().put("Room",roomExtension.getRoom());
			wakeUpJob.getJobDataMap().put("Hour",wakeUpTime); 
			wakeUpJob.getJobDataMap().put("RandomId",wakeUpAlarm.getRandomId()); 
			wakeUpJob.getJobDataMap().put("Lang",lang); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "wakeUp").withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(wakeUpJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void cronWakeUpNoResponse(WakeUpAlarm wakeUpAlarm){
		
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingFiveMins = new Date(t + (5 * ONE_MINUTE_IN_MILLIS));
		date.setTime(afterAddingFiveMins);
		
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
				
		try{
			String triggerName = wakeUpAlarm.getRandomId() + "NoRespondTrigger";
			JobDetail wakeUpNoRespondJob = JobBuilder.newJob(WakeUpNoRespondJob.class).withIdentity(wakeUpAlarm.getRandomId(), "noRespondWakeUp").build();
			wakeUpNoRespondJob.getJobDataMap().put("RandomId",wakeUpAlarm.getRandomId()); 
			wakeUpNoRespondJob.getJobDataMap().put("Room",wakeUpAlarm.getRoom()); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "noRespondWakeUp").withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(wakeUpNoRespondJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	
	
	
	
	
	

	
	public static void llamadaRoomService(RoomServiceRequests roomServiceRequests){
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory("localhost", "ubiqua", "ubiqua.456");

		ManagerConnection managerConnection = factory.createManagerConnection();
        
        OriginateAction originateAction;
        ManagerResponse originateResponse;
        Boolean respondido = false;
        
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
			if(originateResponse.getResponse().equals("Success")){
				respondido = true;
			}
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
		
		if (respondido == false){
			Utils.cronRoomServiceNoResponse(roomServiceRequests);
		}
	}
	
	

	
	public static void cronRoomServiceTenMinutes(RoomServiceRequests roomServiceRequests){
		
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTenMins = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
		date.setTime(afterAddingTenMins);
		
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
				
		try{
			String triggerName = roomServiceRequests.getRandomId() + "RoomServiceTenMinutesTrigger";
			JobDetail roomServiceTenMinutesJob = JobBuilder.newJob(RoomServiceTenMinutesJob.class).withIdentity(roomServiceRequests.getRandomId(), "RoomServiceTenMinutes").build();
			roomServiceTenMinutesJob.getJobDataMap().put("RandomId",roomServiceRequests.getRandomId()); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "roomServiceTenMinutes").withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(roomServiceTenMinutesJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void cronRoomServiceNoResponse(RoomServiceRequests roomServiceRequests){
		
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTwoMins = new Date(t + (2 * ONE_MINUTE_IN_MILLIS));
		date.setTime(afterAddingTwoMins);
		
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
				
		try{
			String triggerName = roomServiceRequests.getRandomId() + "NoRespondRoomServiceTrigger";
			JobDetail roomServiceNoRespondJob = JobBuilder.newJob(RoomServiceNoRespondJob.class).withIdentity(roomServiceRequests.getRandomId(), "noRespondRoomService").build();
			roomServiceNoRespondJob.getJobDataMap().put("RandomId",roomServiceRequests.getRandomId()); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "noRespondWakeUp").withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(roomServiceNoRespondJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void stopCron(WakeUpAlarm wakeUpAlarm, String group){
		
		String triggerName = wakeUpAlarm.getRandomId() + "Trigger";
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey(triggerName, group));
			scheduler.deleteJob(new JobKey(wakeUpAlarm.getRandomId(), group));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
	public static void stopCronNoRespond(WakeUpAlarm wakeUpAlarm, String group){
		
		String triggerName = wakeUpAlarm.getRandomId() + "NoRespondTrigger";
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey(triggerName, group));
			scheduler.deleteJob(new JobKey(wakeUpAlarm.getRandomId(), group));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
    public static void stopCronRoomService(RoomServiceRequests roomServiceRequests, String group){
		
		String triggerName = roomServiceRequests.getRandomId() + "RoomServiceTrigger";
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey(triggerName, group));
			scheduler.deleteJob(new JobKey(roomServiceRequests.getRandomId(), group));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
    public static void stopCronRoomServiceTenMinutes(RoomServiceRequests roomServiceRequests, String group){
		
		String triggerName = roomServiceRequests.getRandomId() + "RoomServiceTenMinutesTrigger";
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey(triggerName, group));
			scheduler.deleteJob(new JobKey(roomServiceRequests.getRandomId(), group));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
	public static void stopCronNoRespondRoomService(RoomServiceRequests roomServiceRequests, String group){
		
		String triggerName = roomServiceRequests.getRandomId() + "NoRespondRoomServiceTrigger";
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey(triggerName, group));
			scheduler.deleteJob(new JobKey(roomServiceRequests.getRandomId(), group));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
	
	
	public static void confirmDespertador(String randomId){
		
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(randomId);
		
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		wakeUpAlarm = wakeUpAlarmManager.confirmAlarm(wakeUpAlarm);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static InputStream breakfastServicePDF(BreakfastServiceRequests breakfastService){
		
		InputStream inputStream = null;
		
        Document document = new Document();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, buffer);
            document.open();
            
            document.add(new Paragraph("Nueva comanda Breakfast"));
            document.add(new Paragraph("Habitación : "+breakfastService.getRoom()));
            document.add(new Paragraph("Programado para : "+breakfastService.getRequestTime()));
            document.add(new Paragraph("Número de personas : "+breakfastService.getPeople()));
            
            PdfPTable table = new PdfPTable(2); // 2 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            
            float[] columnWidths = {1f, 0.3f};
            table.setWidths(columnWidths);
     
            PdfPCell cell1 = new PdfPCell(new Paragraph("Producto"));
            cell1.setBorderColor(BaseColor.BLACK);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            PdfPCell cell2 = new PdfPCell(new Paragraph("Cantidad"));
            cell2.setBorderColor(BaseColor.BLACK);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1);
            table.addCell(cell2);
            
            ArrayList<BreakfastServiceRequestProduct> list = new ArrayList<BreakfastServiceRequestProduct>();
            list = new Gson().fromJson(breakfastService.getProducts(), new TypeToken<ArrayList<BreakfastServiceRequestProduct>>() {}.getType());
            
            for (BreakfastServiceRequestProduct product : list){
        		
            	if(product != null){
            		table.addCell(getProductById(product.getId()));
            		table.addCell(String.valueOf(product.getQuantity()));
            	}
            }
     
            document.add(table);
            
            if (breakfastService.getComments() != null && !breakfastService.getComments().isEmpty()) {
            	document.add(new Paragraph("Comentarios : "+breakfastService.getComments()));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        byte[] bytes = null;
        bytes = buffer.toByteArray();
        
        if(bytes!=null){
            inputStream = new ByteArrayInputStream ( bytes );
        }
		
		return inputStream;
	}
	
	public static InputStream breakfastServiceListPDF(List<BreakfastServiceRequests> breakfastService){
		
		InputStream inputStream = null;
		
        Document document = new Document();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, buffer);
            document.open();
            
            Calendar c = Calendar.getInstance();
           
            document.add(new Paragraph("Nueva comanda Breakfast para el dia "+c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH) + 1)+"-"+c.get(Calendar.YEAR)));
            
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            
            float[] columnWidths = {0.4f, 0.4f, 1f, 0.6f, 0.3f};
            table.setWidths(columnWidths);
            
            Font boldFontTitle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Habitación",boldFontTitle));
            cell1.setBorderColor(BaseColor.BLACK);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell2 = new PdfPCell(new Paragraph("Personas",boldFontTitle));
            cell2.setBorderColor(BaseColor.BLACK);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            PdfPCell cell3 = new PdfPCell(new Paragraph("Productos",boldFontTitle));
            cell3.setBorderColor(BaseColor.BLACK);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell4 = new PdfPCell(new Paragraph("Comentarios",boldFontTitle));
            cell4.setBorderColor(BaseColor.BLACK);
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell5 = new PdfPCell(new Paragraph("Hora entrega",boldFontTitle));
            cell5.setBorderColor(BaseColor.BLACK);
            cell5.setPaddingLeft(10);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            
            for (BreakfastServiceRequests request: breakfastService){
            	table.addCell(String.valueOf(request.getRoom()));
            	table.addCell(String.valueOf(request.getPeople()));
            	PdfPTable table1 = new PdfPTable(2);
            	Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            	PdfPCell cellProductoTitle = new PdfPCell(new Paragraph("Producto",boldFont));
            	cellProductoTitle.setBorderWidthLeft(0);
            	cellProductoTitle.setBorderWidthRight(0);
            	cellProductoTitle.setBorderWidthTop(0);
            	cellProductoTitle.setBorderWidthBottom(0);
            	PdfPCell cellCantidadTitle = new PdfPCell(new Paragraph("Cantidad",boldFont));
            	cellCantidadTitle.setBorderWidthLeft(0);
            	cellCantidadTitle.setBorderWidthRight(0);
            	cellCantidadTitle.setBorderWidthTop(0);
            	cellCantidadTitle.setBorderWidthBottom(0);
            	cellCantidadTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(cellProductoTitle);
        		table1.addCell(cellCantidadTitle);
            	ArrayList<RoomServiceRequestProduct> list = new ArrayList<RoomServiceRequestProduct>();
                list = new Gson().fromJson(request.getProducts(), new TypeToken<ArrayList<RoomServiceRequestProduct>>() {}.getType());
                for (RoomServiceRequestProduct product : list){
                	if(product != null){
                		PdfPCell cellProducto = new PdfPCell(new Paragraph(getProductById(product.getId())));
                		cellProducto.setBorderWidthLeft(0);
                		cellProducto.setBorderWidthRight(0);
                		cellProducto.setBorderWidthTop(0);
                		cellProducto.setBorderWidthBottom(0);
                    	PdfPCell cellCantidad = new PdfPCell(new Paragraph(""+product.getQuantity()));
                    	cellCantidad.setBorderWidthLeft(0);
                    	cellCantidad.setBorderWidthRight(0);
                    	cellCantidad.setBorderWidthTop(0);
                    	cellCantidad.setBorderWidthBottom(0);
                    	cellCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
                		table1.addCell(cellProducto);
                		table1.addCell(cellCantidad);
                	}
                }
                table.addCell(table1);
            	table.addCell(request.getComments());
            	
            	DateFormat df = new SimpleDateFormat("HH:mm");
            	
            	table.addCell(df.format(request.getRequestTime()));
            }
            
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        byte[] bytes = null;
        bytes = buffer.toByteArray();
        
        if(bytes!=null){
            inputStream = new ByteArrayInputStream ( bytes );
        }
		
		return inputStream;
	}
	
	public static void sendMailBreakfastService(InputStream file) throws IOException{
		
		final String username = "noreplyavisostablet@gmail.com";
		final String password = "nhconstanza";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
						
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("noreplyavisostablet@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("r.prat@ubiqua.es"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("jordi@ubiqua.es"));
			message.setSubject("Breakfast Requests");
			
			Multipart multipart = new MimeMultipart();    
			
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("Hola, "
            		+ "\n\nDesayunos previstos para hoy, ver el el PDF adjunto\n");
            multipart.addBodyPart(messageBodyPart1); 
            
            BodyPart messageBodyPart4 = new MimeBodyPart();  
            messageBodyPart4.setText("\n\nConfirma en el siguiente enlace la recepción de este correo:"
            		+ "\nhttp://"+constants.dominio+":8080/NHServices/api/confirmationBreakfast"); 
            multipart.addBodyPart(messageBodyPart4);
            
            MimeBodyPart messageBodyPartFile = new MimeBodyPart();   
            ByteArrayDataSource ds = new ByteArrayDataSource(file, "application/pdf");
            Calendar c = Calendar.getInstance();
            String filename = "Breakfast_"+c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH) + 1)+"-"+c.get(Calendar.YEAR)+".pdf";//change accordingly        
            messageBodyPartFile.setDataHandler(new DataHandler(ds));    
            messageBodyPartFile.setFileName(filename); 
            multipart.addBodyPart(messageBodyPartFile);
   
            message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void llamadaBreakfast(){
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory(constants.dominio, "ubiqua", "ubiqua.456");
		ManagerConnection managerConnection = factory.createManagerConnection();
		
		RoomExtension roomExtension = new RoomExtension();
		roomExtension.setRoom(1011);
		roomExtension = new RoomExtensionManager().get(roomExtension);
        
        OriginateAction originateAction;
        ManagerResponse originateResponse;
        Boolean respondido = false;
        
        long espera = 30000; 
        
        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/"+roomExtension.getExtension());
        originateAction.setContext("default");
        originateAction.setExten("1012");
        originateAction.setApplication("Playback");
        originateAction.setData("custom/breakfast");
        originateAction.setPriority(new Integer(1));
        originateAction.setTimeout(espera);
        originateAction.setCallerId("Breakfast");
        
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
				Utils.mailErrorAsterisk("ActionCall Breakfast", errors.toString());
				
			}finally {
				managerConnection.logoff();
			}
        	
        }catch(Exception e){
        	StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Utils.mailErrorAsterisk("Login Breakfast", errors.toString());
        }
		
		if (respondido == false){
			Utils.cronBreakfastNoResponse();
		}
		
	}
	
	public static void cronBreakfastAlerts(int count){
		
		final long ONE_MINUTE_IN_MILLIS=60000;
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTwoMins = new Date(t + (constants.breakfastAlerts * ONE_MINUTE_IN_MILLIS));
		date.setTime(afterAddingTwoMins);
		
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);
				
		try{
			String triggerName = "alertsBreakfastTrigger";
			JobDetail breakfastAlertsJob = JobBuilder.newJob(BreakfastAlertsJob.class).withIdentity("alertsBreakfast").build();
			breakfastAlertsJob.getJobDataMap().put("count",count); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "alertsBreakfast").withSchedule(CronScheduleBuilder.cronSchedule(second+" "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(breakfastAlertsJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void cronBreakfastNoResponse(){
		
		final long ONE_MINUTE_IN_MILLIS=60000;
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date afterAddingTwoMins = new Date(t + (constants.breakfastNoRespond * ONE_MINUTE_IN_MILLIS));
		date.setTime(afterAddingTwoMins);
		
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);
		int second = date.get(Calendar.SECOND);
				
		try{
			String triggerName = "noRespondBreakfastTrigger";
			JobDetail breakfastNoRespondJob = JobBuilder.newJob(BreakfastNoRespondJob.class).withIdentity("noRespondBreakfast").build(); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "noRespondBreakfast").withSchedule(CronScheduleBuilder.cronSchedule(second+" "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(breakfastNoRespondJob, trigger);
			
			} catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void stopCronAlertsBreakfast(){
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey("alertsBreakfastTrigger", "alertsBreakfast"));
			scheduler.deleteJob(new JobKey("alertsBreakfast", "alertsBreakfast"));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
	public static void stopCronNoRespondBreakfast(){
		
		try{
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.unscheduleJob(new TriggerKey("NoRespondBreakfastTrigger", "noRespondBreakfast"));
			scheduler.deleteJob(new JobKey("noRespondBreakfast", "noRespondBreakfast"));
			
		} catch (Exception e) {
			
            e.printStackTrace();
            
        }
		
	}
	
	public static void mailErrorAsterisk(String call, String error){
		
		final String username = "ubiqua.developer@gmail.com";
		final String password = "20Ubiq2015";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
						
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ubiqua.developer@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("r.prat@ubiqua.es"));
			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("dani@ubiqua.es"));
			message.setSubject("Error Call Asterisk : "+call);
			
			Multipart multipart = new MimeMultipart();    
			
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("Error en call Asterisk, "
            		+ "\n\n"+error+"\n");
            multipart.addBodyPart(messageBodyPart1); 
   
            message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}

package es.ubiqua.nhservices.utils;

import com.opensymphony.xwork2.ActionSupport;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
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

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import es.ubiqua.nhservices.jobs.WakeUpJob;
import es.ubiqua.nhservices.jobs.WakeUpNoRespondJob;
import es.ubiqua.nhservices.manger.RoomExtensionManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.Product;
import es.ubiqua.nhservices.model.RoomExtension;
import es.ubiqua.nhservices.model.RoomService;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import infobip.api.client.SendSingleTextualSms;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.sms.mt.send.SMSResponse;
import infobip.api.model.sms.mt.send.SMSResponseDetails;
import infobip.api.model.sms.mt.send.textual.SMSTextualRequest;

public class Utils extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static InputStream roomServicePDF(RoomService roomService){
		
		InputStream inputStream = null;
		
        Document document = new Document();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, buffer);
            document.open();
            
            document.add(new Paragraph("Nueva comanda Room Service:"));
            
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
            
            for (Product item:roomService.getProducts()){
            	table.addCell(item.getName());
            	table.addCell(String.valueOf(item.getQuantity()));
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
	
	/*public static InputStream wakeUpAlarmPDF(WakeUpAlarm wakeUpAlarm){
		
		InputStream inputStream = null;
		
        Document document = new Document();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, buffer);
            document.open();
            
            document.add(new Paragraph("Nuevo despertador programado"));
            
            document.add(new Paragraph("Habitación : "+wakeUpAlarm.getRoom()));
            
            document.add(new Paragraph("Hora : "+wakeUpAlarm.getWakeUpTime()));

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
	}*/
	
	public static void printPDF(Doc doc) throws PrinterException{
		
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
		
	}
	
	public static void sendMailObject(InputStream prova) throws IOException{
		
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
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("r.prat@ubiqua.es"));
			message.setSubject("Testing Subject");
			/*message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");*/
			
			//3) create MimeBodyPart object and set your message text        
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText("This is message body");          

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();   
            ByteArrayDataSource ds = new ByteArrayDataSource(prova, "application/pdf");
            String filename = "prova.pdf";//change accordingly        
            messageBodyPart2.setDataHandler(new DataHandler(ds));    
            messageBodyPart2.setFileName(filename);             

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);      

            //6) set the multiplart object to the message object    
            message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void sendMailWakeUpNoRespond(String room, String time, String randomId){
		
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
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("r.prat@ubiqua.es"));
			message.setSubject("Testing Subject");
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
            messageBodyPart5.setText("\nhttp://localhost:8080/NHServices/api/confirmationWakeUp?id="+randomId);          

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
        
	}
	
	
	public static void CronWakeUp(WakeUpAlarm wakeUpAlarm){
		
		Date date = new Date(wakeUpAlarm.getWakeUpTime().getTime());
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		
		String wakeUpTime = day+"-"+month+"-"+year+" "+hour+":"+minute;
		
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
		
		System.out.println("MESSI : "+day+"-"+month+"-"+year+" "+hour+":"+minute);
		
		try{
			String triggerName = wakeUpAlarm.getRandomId() + "NoRespondTrigger";
			JobDetail wakeUpNoRespondJob = JobBuilder.newJob(WakeUpNoRespondJob.class).withIdentity(wakeUpAlarm.getRandomId(), "noRespondWakeUp").build();
			wakeUpNoRespondJob.getJobDataMap().put("RandomId",wakeUpAlarm.getRandomId()); 
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, "noRespondWakeUp").withSchedule(CronScheduleBuilder.cronSchedule("0 "+minute+" "+hour+" "+day+" "+month+" ? "+year+"")).build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(wakeUpNoRespondJob, trigger);
			
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
	
	public static void confirmDespertador(String randomId){
		
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(randomId);
		
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		wakeUpAlarm = wakeUpAlarmManager.confirmAlarm(wakeUpAlarm);
	}

}

package es.ubiqua.nhservices.actions;

import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;


import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
//import java.time.Instant;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.codec.Base64;
import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.BreakfastRequestsManager;
import es.ubiqua.nhservices.manger.BreakfastServiceRequestsManager;
import es.ubiqua.nhservices.manger.HotelCanalesManager;
import es.ubiqua.nhservices.manger.HotelDirectoryDesayunoManager;
import es.ubiqua.nhservices.manger.HotelDirectoryEventosManager;
import es.ubiqua.nhservices.manger.HotelDirectoryGimnasioManager;
import es.ubiqua.nhservices.manger.HotelDirectoryPicinaManager;
import es.ubiqua.nhservices.manger.HotelDirectoryRestauranteManager;
import es.ubiqua.nhservices.manger.HotelDirectoryServiciosManager;
import es.ubiqua.nhservices.manger.HotelDirectorySpaManager;
import es.ubiqua.nhservices.manger.HotelDirectoryWifiManager;
import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.manger.HotelSeguridadManager;
import es.ubiqua.nhservices.manger.HotelSostenibilidadManager;
import es.ubiqua.nhservices.manger.HotelTelefonosManager;
import es.ubiqua.nhservices.manger.RoomServiceAnswersManager;
import es.ubiqua.nhservices.manger.RoomServiceBebidasManager;
import es.ubiqua.nhservices.manger.RoomServiceIngredientesManager;
import es.ubiqua.nhservices.manger.RoomServiceListManager;
import es.ubiqua.nhservices.manger.RoomServicePlatosManager;
import es.ubiqua.nhservices.manger.RoomServiceQuestionsManager;
import es.ubiqua.nhservices.manger.RoomServiceRequestsManager;
import es.ubiqua.nhservices.manger.UsersManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.BreakfastRequests;
import es.ubiqua.nhservices.model.BreakfastServiceRequest;
import es.ubiqua.nhservices.model.BreakfastServiceRequests;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryDesayuno;
import es.ubiqua.nhservices.model.HotelDirectoryEventos;
import es.ubiqua.nhservices.model.HotelDirectoryGimnasio;
import es.ubiqua.nhservices.model.HotelDirectoryPicina;
import es.ubiqua.nhservices.model.HotelDirectoryRestaurantes;
import es.ubiqua.nhservices.model.HotelDirectoryServicios;
import es.ubiqua.nhservices.model.HotelDirectorySpa;
import es.ubiqua.nhservices.model.HotelDirectoryWifi;
import es.ubiqua.nhservices.model.HotelSeguridad;
import es.ubiqua.nhservices.model.HotelSostenibilidad;
import es.ubiqua.nhservices.model.HotelTelefonos;
import es.ubiqua.nhservices.model.Product;
import es.ubiqua.nhservices.model.RoomService;
import es.ubiqua.nhservices.model.RoomServiceAnswers;
import es.ubiqua.nhservices.model.RoomServiceBebidas;
import es.ubiqua.nhservices.model.RoomServiceIngredientes;
import es.ubiqua.nhservices.model.RoomServiceList;
import es.ubiqua.nhservices.model.RoomServicePlatos;
import es.ubiqua.nhservices.model.RoomServicePreguntas;
import es.ubiqua.nhservices.model.RoomServiceQuestions;
import es.ubiqua.nhservices.model.RoomServiceRequest;
import es.ubiqua.nhservices.model.RoomServiceRequests;
import es.ubiqua.nhservices.model.Users;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;



public class GetHotelDirectory extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RoomServicePlatos> platos;
	private List<RoomServiceList> list;
	private List<RoomServiceBebidas> bebidas;
	private List<RoomServiceIngredientes> ingredientes;
	private List<HotelDirectoryRestaurantes> restaurants;
	private List<HotelDirectoryDesayuno> breakfast;
	private List<HotelDirectoryEventos> events;
	private List<HotelDirectoryGimnasio> gym;
	private List<HotelDirectoryPicina> pool;
	private List<HotelDirectoryServicios> services;
	private List<HotelDirectorySpa> spa;
	private List<HotelDirectoryWifi> wifi;
	private List<HotelCanales> channels;
	private List<HotelSeguridad> security;
	private List<HotelSostenibilidad> sustainability;
	private List<HotelTelefonos> phones;
	private String lang;
	private String name;
	private String query;
	
	private int room;
	private String time;
	private Boolean today;
	private String id;
	
	private InputStream inputStream;
	
	private List<RoomServiceQuestions> roomServiceQuestions;
	private String identificador;
	private Users user;
	private List<WakeUpAlarm> alarms;
	
	public String execute() {
	   
        return SUCCESS;
    }
	
	public String userInformation(){
		
		user = new Users();
		user.setIdentificador(identificador);
		user = new UsersManager().get(user);
		
		if (user == null){
			user = new Users();
			user.setIp_asterisk("10.8.0.1");
			user.setRoom(105);
			user.setUser("105");
			user.setPassword("1234pbx");
			user.setIdentificador("1111");
		}
		
		return SUCCESS;
	}
	
	public String breakfastService() throws IOException{
						
		byte[] decoded = Base64.decode(query);
		
		String json = new String(decoded, "UTF-8");
		
		BreakfastServiceRequest request = new Gson().fromJson(json,BreakfastServiceRequest.class);
				
		Calendar now = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), Integer.parseInt(request.getHour()), Integer.parseInt(request.getMin()), 0);
		c.add(Calendar.DATE, 1);
		
		BreakfastServiceRequests requests = new BreakfastServiceRequests();
		
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(130, random).toString(32);
		
		requests.setRoom(request.getRoom());
		requests.setProducts(new Gson().toJson(request.getProducts()));
		requests.setRequestTime(c.getTime());
		requests.setRandomId(randomId);
		requests.setComments(request.getComments());
		requests.setPeople(request.getPeople());
		
		requests = new BreakfastServiceRequestsManager().add(requests);
		
		DateFormat df = new SimpleDateFormat("HH:mm");
		time = df.format(requests.getRequestTime());
		return SUCCESS;
	}
	
	public String confirmationBreakfast(){
		
		BreakfastRequestsManager breakfastRequestsManager = new BreakfastRequestsManager();
		BreakfastRequests breakfastRequests = breakfastRequestsManager.get();
		breakfastRequests = breakfastRequestsManager.confirmRequest(breakfastRequests);
		
		Utils.stopCronAlertsBreakfast();
		Utils.stopCronNoRespondBreakfast();
		
		Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		time = df.format(now.getTime());
		
		return SUCCESS;
	}
	
	public String roomService() throws IOException{
				
		byte[] decoded = Base64.decode(query);
		
		String json = new String(decoded, "UTF-8");
		
		RoomServiceRequest request = new Gson().fromJson(json,RoomServiceRequest.class);
		
		Calendar now = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), Integer.parseInt(request.getHour()), Integer.parseInt(request.getMin()), 0);
		if (now.getTimeInMillis() > c.getTimeInMillis()){
			c.add(Calendar.DATE, 1);
		}
		
		RoomServiceRequests requests = new RoomServiceRequests();
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(130, random).toString(32);
		
		requests.setRoom(request.getRoom());
		requests.setProducts(new Gson().toJson(request.getProducts()));
		requests.setRequestTime(c.getTime());
		requests.setRandomId(randomId);
		requests.setComments(request.getComments());
		requests.setPeople(request.getPeople());
		
		requests = new RoomServiceRequestsManager().add(requests);
		
		requests.setRandomId(randomId);
		requests = new RoomServiceRequestsManager().getByRandomId(requests);
		
		avisarNuevoRoomServiceRequest(requests);
		
		DateFormat df = new SimpleDateFormat("HH:mm");
		time = df.format(requests.getRequestTime());
		return SUCCESS;
	}
	
	private void avisarNuevoRoomServiceRequest(RoomServiceRequests roomServiceRequests) throws IOException{
		
		inputStream = Utils.roomServicePDF(roomServiceRequests);
		
		Utils.sendMailRoomService(inputStream, roomServiceRequests);
		//Utils.CronRoomService(roomServiceRequests);
		final RoomServiceRequests rr = roomServiceRequests;
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				Utils.llamadaRoomService(rr);
			}
		});
		t.start();
		Utils.cronRoomServiceTenMinutes(roomServiceRequests);
		
	}
	
	public String confirmationRoomService(){
		
		RoomServiceRequests roomServiceRequests = new RoomServiceRequests();
		roomServiceRequests.setRandomId(id);
		
		RoomServiceRequestsManager roomServiceRequestsManager = new RoomServiceRequestsManager();
		roomServiceRequests = roomServiceRequestsManager.getByRandomId(roomServiceRequests);
		roomServiceRequests = roomServiceRequestsManager.confirmRequest(roomServiceRequests);
		
		Utils.stopCronRoomService(roomServiceRequests, "roomService");
		Utils.stopCronNoRespondRoomService(roomServiceRequests, "noRespondRoomService");
		Utils.stopCronRoomServiceTenMinutes(roomServiceRequests, "roomServiceTenMinutes");
		
		return SUCCESS;
	}
	
	public String listRoomService(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		
		list = new RoomServiceListManager().list(h, lang);
		
		for (RoomServiceList product: list){
			if (product.getQuestion() == true){
				ArrayList<RoomServicePreguntas> preguntas = Utils.obtenerQuestionsProductosRoomService(product.getId(), lang);
				product.setQuestionText(preguntas);
			}
		}
		
		
		//platos = new RoomServicePlatosManager().list(h, lang);
		//bebidas = new RoomServiceBebidasManager().list(h, lang);
		//ingredientes = new RoomServiceIngredientesManager().list(h, lang);
		
		return SUCCESS;
	}
	
	public String listRestaurants(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		restaurants = new HotelDirectoryRestauranteManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listBreakfast(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		breakfast = new HotelDirectoryDesayunoManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listEvents(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		events = new HotelDirectoryEventosManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listGym(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		gym = new HotelDirectoryGimnasioManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listPool(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		pool = new HotelDirectoryPicinaManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listServices(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		services = new HotelDirectoryServiciosManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listSpa(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		spa = new HotelDirectorySpaManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listWifi(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		wifi = new HotelDirectoryWifiManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listChannels(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		channels = new HotelCanalesManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listSecurity(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		security = new HotelSeguridadManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listSustainability(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		sustainability = new HotelSostenibilidadManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String listPhones(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		phones = new HotelTelefonosManager().list(h,lang);
		
		return SUCCESS;
	}
	
	public String wakeUp() throws IOException{
				
		String hora = time.substring(0,time.indexOf(":"));
		String minuto = time.substring(time.indexOf(":") + 1,time.length());
		
		Calendar now = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		c.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), Integer.parseInt(hora), Integer.parseInt(minuto), 0);
		
		today = true;
		
		if (now.getTimeInMillis() > c.getTimeInMillis()){
			c.add(Calendar.DATE, 1);
			today = false;
		}
		
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(130, random).toString(32);
				
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRoom(room);
		wakeUpAlarm.setWakeUpTime(c.getTime());
		wakeUpAlarm.setRandomId(randomId);
		
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		
		wakeUpAlarm = wakeUpAlarmManager.add(wakeUpAlarm);
		
		Utils.CronWakeUp(wakeUpAlarm, lang);
		
		identificador = wakeUpAlarm.getRandomId();
		
		return SUCCESS;
		
	}
	
	public String wakeUpListByRoom() throws IOException{
		
		
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRoom(room);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		alarms = wakeUpAlarmManager.listByRoom(wakeUpAlarm);
		
		return SUCCESS;
		
	}
	
	public String wakeUpDelete() throws IOException{
		
		
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(identificador);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		
		Utils.stopCron(wakeUpAlarm, "wakeUp");
		wakeUpAlarmManager.del(wakeUpAlarm);
		
		return SUCCESS;
		
	}
	
	public String confirmationWakeUp(){
		
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRandomId(id);
		
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		
		wakeUpAlarm = wakeUpAlarmManager.getByRandomId(wakeUpAlarm);
		wakeUpAlarm = wakeUpAlarmManager.confirmAlarm(wakeUpAlarm);
		
		Utils.stopCron(wakeUpAlarm, "wakeUp");
		
		return SUCCESS;
	}
	
	/*public String pdf() throws PrinterException, IOException{
	
		RoomService roomService = new RoomService();
		roomService.addProduct(new Product("Suc Taronja",2));
		roomService.addProduct(new Product("Suc Pinya",1));
		
		inputStream = Utils.roomServicePDF(roomService);
		
	    Doc pdfDoc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
	    
	    Utils.printPDF(pdfDoc);
	    
	    inputStream.close();

		return SUCCESS;
		
	}*/
	
	/*public String mail() throws IOException{
		
		RoomService roomService = new RoomService();
		roomService.addProduct(new Product("Suc Taronja",2));
		roomService.addProduct(new Product("Suc Pinya",1));
		
		inputStream = Utils.roomServicePDF(roomService);
		
		Utils.sendMailObject(inputStream);

		return SUCCESS;
		
	}*/
	
	
	
	/*private void avisarNuevoDespertador(WakeUpAlarm wakeUpAlarm) throws IOException{
		
		//Utils.sendSMSWakeUpAlarm(wakeUpAlarm);
		
		inputStream = Utils.wakeUpAlarmPDF(wakeUpAlarm);
		
		Utils.sendMailWakeUpAlarm(inputStream, wakeUpAlarm);
		
		Utils.CronWakeUpAlarm(wakeUpAlarm);
		
	}*/
	
	public void provaAsterisk() throws IOException, AuthenticationFailedException, TimeoutException{
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory("localhost", "ubiqua", "ubiqua.456");

		ManagerConnection managerConnection = factory.createManagerConnection();
        
        OriginateAction originateAction;
        
        System.out.println("LEO MESSI");

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/2001"); // Sortida Extensio a on es truca //
        originateAction.setContext("default");
        originateAction.setExten("2000"); // Extensio desde on es truca //
        originateAction.setApplication("Playback");
        originateAction.setData("tt-monkeys");
        originateAction.setPriority(new Integer(1));

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
			ManagerResponse originateResponse = managerConnection.sendAction(originateAction, 30000);
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

	public List<HotelDirectoryRestaurantes> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<HotelDirectoryRestaurantes> restaurants) {
		this.restaurants = restaurants;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HotelDirectoryDesayuno> getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(List<HotelDirectoryDesayuno> breakfast) {
		this.breakfast = breakfast;
	}

	public List<HotelDirectoryEventos> getEvents() {
		return events;
	}

	public void setEvents(List<HotelDirectoryEventos> events) {
		this.events = events;
	}

	public List<HotelDirectoryGimnasio> getGym() {
		return gym;
	}

	public void setGym(List<HotelDirectoryGimnasio> gym) {
		this.gym = gym;
	}

	public List<HotelDirectoryPicina> getPool() {
		return pool;
	}

	public void setPool(List<HotelDirectoryPicina> pool) {
		this.pool = pool;
	}

	public List<HotelDirectoryServicios> getServices() {
		return services;
	}

	public void setServices(List<HotelDirectoryServicios> services) {
		this.services = services;
	}

	public List<HotelDirectorySpa> getSpa() {
		return spa;
	}

	public void setSpa(List<HotelDirectorySpa> spa) {
		this.spa = spa;
	}

	public List<HotelDirectoryWifi> getWifi() {
		return wifi;
	}

	public void setWifi(List<HotelDirectoryWifi> wifi) {
		this.wifi = wifi;
	}

	public List<HotelCanales> getChannels() {
		return channels;
	}

	public void setChannels(List<HotelCanales> channels) {
		this.channels = channels;
	}

	public List<HotelSeguridad> getSecurity() {
		return security;
	}

	public void setSecurity(List<HotelSeguridad> security) {
		this.security = security;
	}

	public List<HotelSostenibilidad> getSustainability() {
		return sustainability;
	}

	public void setSustainability(List<HotelSostenibilidad> sustainability) {
		this.sustainability = sustainability;
	}

	public List<HotelTelefonos> getPhones() {
		return phones;
	}

	public void setPhones(List<HotelTelefonos> phones) {
		this.phones = phones;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	/*
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	*/
	
	/*public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}*/
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RoomServicePlatos> getPlatos() {
		return platos;
	}

	public void setPlatos(List<RoomServicePlatos> platos) {
		this.platos = platos;
	}

	public List<RoomServiceBebidas> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<RoomServiceBebidas> bebidas) {
		this.bebidas = bebidas;
	}

	public List<RoomServiceIngredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<RoomServiceIngredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Boolean getToday() {
		return today;
	}

	public void setToday(Boolean today) {
		this.today = today;
	}

	public List<RoomServiceList> getList() {
		return list;
	}

	public void setList(List<RoomServiceList> list) {
		this.list = list;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<RoomServiceQuestions> getRoomServiceQuestions() {
		return roomServiceQuestions;
	}

	public void setRoomServiceQuestions(List<RoomServiceQuestions> roomServiceQuestions) {
		this.roomServiceQuestions = roomServiceQuestions;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<WakeUpAlarm> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<WakeUpAlarm> alarms) {
		this.alarms = alarms;
	}

}
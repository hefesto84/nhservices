package es.ubiqua.nhservices.actions;

import java.awt.print.PrinterException;
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
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;

import com.opensymphony.xwork2.ActionSupport;

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
import es.ubiqua.nhservices.manger.RoomServiceBebidasManager;
import es.ubiqua.nhservices.manger.RoomServiceIngredientesManager;
import es.ubiqua.nhservices.manger.RoomServicePlatosManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
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
import es.ubiqua.nhservices.model.RoomServiceBebidas;
import es.ubiqua.nhservices.model.RoomServiceIngredientes;
import es.ubiqua.nhservices.model.RoomServicePlatos;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;


public class GetHotelDirectory extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RoomServicePlatos> platos;
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
	
	private int room;
	private int time;
	private String id;
	
	private InputStream inputStream;
	
	public String execute() {
	    
        return SUCCESS;
    }
	
	public String listRoomService(){
		
		Hotel h = new Hotel();
		h.setName(name);
		h = new HotelManager().get(h);
		platos = new RoomServicePlatosManager().list(h, lang);
		bebidas = new RoomServiceBebidasManager().list(h, lang);
		ingredientes = new RoomServiceIngredientesManager().list(h, lang);
		
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
		
		Timestamp timestamp = Timestamp.from(Instant.ofEpochSecond( time ));
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(130, random).toString(32);
				
		WakeUpAlarm wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setRoom(room);
		wakeUpAlarm.setWakeUpTime(timestamp);
		wakeUpAlarm.setRandomId(randomId);
		
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		
		wakeUpAlarm = wakeUpAlarmManager.add(wakeUpAlarm);
		
		avisarNuevoDespertador(wakeUpAlarm);
		
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
	
	public String pdf() throws PrinterException, IOException{
	
		RoomService roomService = new RoomService();
		roomService.addProduct(new Product("Suc Taronja",2));
		roomService.addProduct(new Product("Suc Pinya",1));
		
		inputStream = Utils.roomServicePDF(roomService);
		
	    Doc pdfDoc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
	    
	    Utils.printPDF(pdfDoc);
	    
	    inputStream.close();

		return SUCCESS;
		
	}
	
	public String mail() throws IOException{
		
		RoomService roomService = new RoomService();
		roomService.addProduct(new Product("Suc Taronja",2));
		roomService.addProduct(new Product("Suc Pinya",1));
		
		inputStream = Utils.roomServicePDF(roomService);
		
		Utils.sendMailObject(inputStream);

		return SUCCESS;
		
	}
	
	private void avisarNuevoDespertador(WakeUpAlarm wakeUpAlarm) throws IOException{
		
		//Utils.sendSMSWakeUpAlarm(wakeUpAlarm);
		
		inputStream = Utils.wakeUpAlarmPDF(wakeUpAlarm);
		
		Utils.sendMailWakeUpAlarm(inputStream, wakeUpAlarm);
		
		Utils.CronWakeUpAlarm(wakeUpAlarm);
		
	}
	

	public void provaAsterisk() throws IOException, AuthenticationFailedException, TimeoutException{
		
		ManagerConnectionFactory factory = new ManagerConnectionFactory("192.168.1.200", "ubiqua", "ubiqua.456");

		ManagerConnection managerConnection = factory.createManagerConnection();
        
        OriginateAction originateAction;

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/2000");
        originateAction.setContext("default");
        originateAction.setExten("2002");
        originateAction.setApplication("Playback");
        originateAction.setData("tt-monkeys");
        originateAction.setPriority(new Integer(1));

        // connect to Asterisk and log in
		managerConnection.login();
        
        // send the originate action and wait for a maximum of 30 seconds for Asterisk
        // to send a reply
		ManagerResponse originateResponse = managerConnection.sendAction(originateAction, 30000);
		
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

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
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
	

}
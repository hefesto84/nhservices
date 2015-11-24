package es.ubiqua.nhservices.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;

import com.google.gson.Gson;
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


public class GetHotelDirectory extends ActionSupport {
	
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
	
	public String execute() {
	    
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

}

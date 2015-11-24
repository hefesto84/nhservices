package es.ubiqua.nhservices.backend.hotelDirectory.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.HotelSostenibilidadManager;
import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.manger.LanguageManager;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelSostenibilidad;
import es.ubiqua.nhservices.model.Language;

public class backendSostenibilidadAction extends ActionSupport {
	
	private List<HotelSostenibilidad> lista;
	private HotelSostenibilidad sostenibilidad;
	private String page;
	private int id;
	private int id_hotel;
	private String lang;
	private int form_id;
	private int form_hotel_id;
	private String form_lang;
	private String form_sostenibilidad;
	private HotelSostenibilidad h;
	private String status;
	
	private List<Hotel> hoteles;
	private List<Language> idiomas;
	private ArrayList<String> array;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new HotelSostenibilidadManager().listAll();
		page = "sostenibilidad";
		return SUCCESS;
	}
	
	public String edit(){
		
		sostenibilidad = new HotelSostenibilidadManager().getSostenibilidadByIdAndLang(id,lang);
		page = "sostenibilidad";
		
		return SUCCESS;
	}
	
	public String nuevo(){
				
		hoteles = new HotelManager().list();
		
		return SUCCESS;
	}
	
	public String langDisponibles(){
		
		idiomas = new LanguageManager().list();
		lista = new HotelSostenibilidadManager().listLang(id);
		
		int count = 0;
		int encontrado = 0;
		array = new ArrayList<String>();
		
		for (Language idioma : idiomas){
			for (HotelSostenibilidad hotel : lista) {
				if (hotel.getLang().equals(idioma.getCode())){
					encontrado = 1;
					break;
				}
			}
			if (encontrado == 0){
				array.add(idioma.getCode());
				count = count +1;
			}
			encontrado = 0;
		}
		
		return SUCCESS;
	
	}
	
	public String add(){
		
		HotelSostenibilidad hotel = new HotelSostenibilidad();
		hotel.setId_hotel(form_hotel_id);
		hotel.setLang(form_lang);
		hotel.setDescription(form_sostenibilidad);
		
		sostenibilidad = new HotelSostenibilidadManager().add(hotel);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		h = new HotelSostenibilidad();
		h.setId(form_id);
		h = new HotelSostenibilidadManager().get(h);
		h.setDescription(form_sostenibilidad);
		
		HotelSostenibilidadManager manager = new HotelSostenibilidadManager();
		manager.update(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		h = new HotelSostenibilidad();
		h.setId(id);
		h = new HotelSostenibilidadManager().get(h);
		
		HotelSostenibilidadManager manager = new HotelSostenibilidadManager();
		manager.del(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<HotelSostenibilidad> getLista() {
		return lista;
	}

	public void setLista(List<HotelSostenibilidad> lista) {
		this.lista = lista;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	
	public String getForm_sostenibilidad() {
		return form_sostenibilidad;
	}

	public void setForm_sostenibilidad(String form_sostenibilidad) {
		this.form_sostenibilidad = form_sostenibilidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public HotelSostenibilidad getSostenibilidad() {
		return sostenibilidad;
	}

	public void setSostenibilidad(HotelSostenibilidad sostenibilidad) {
		this.sostenibilidad = sostenibilidad;
	}

	public HotelSostenibilidad getH() {
		return h;
	}

	public void setH(HotelSostenibilidad h) {
		this.h = h;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public List<Language> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Language> idiomas) {
		this.idiomas = idiomas;
	}
	
	public ArrayList<String> getArray() {
		return array;
	}

	public void setArray(ArrayList<String> array) {
		this.array = array;
	}

	public String getForm_lang() {
		return form_lang;
	}

	public void setForm_lang(String form_lang) {
		this.form_lang = form_lang;
	}

	public int getForm_hotel_id() {
		return form_hotel_id;
	}

	public void setForm_hotel_id(int form_hotel_id) {
		this.form_hotel_id = form_hotel_id;
	}

}

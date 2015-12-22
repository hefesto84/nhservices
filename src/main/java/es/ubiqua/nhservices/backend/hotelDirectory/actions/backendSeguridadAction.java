package es.ubiqua.nhservices.backend.hotelDirectory.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.manger.HotelSeguridadManager;
import es.ubiqua.nhservices.manger.LanguageManager;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelSeguridad;
import es.ubiqua.nhservices.model.Language;

public class backendSeguridadAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<HotelSeguridad> lista;
	private HotelSeguridad seguridad;
	private String page;
	private int id;
	private int id_hotel;
	private String lang;
	private int form_id;
	private int form_hotel_id;
	private String form_lang;
	private String form_security;
	private HotelSeguridad h;
	private String status;
	
	private List<Hotel> hoteles;
	private List<Language> idiomas;
	private ArrayList<String> array;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new HotelSeguridadManager().listAll();
		page = "seguridad";
		return SUCCESS;
	}
	
	public String edit(){
		
		seguridad = new HotelSeguridadManager().getSeguridadByIdAndLang(id,lang);
		
		return SUCCESS;
	}
	
	public String nuevo(){
				
		hoteles = new HotelManager().list();
		
		return SUCCESS;
	}
	
	public String langDisponibles(){
		
		idiomas = new LanguageManager().list();
		lista = new HotelSeguridadManager().listLang(id);
		
		int count = 0;
		int encontrado = 0;
		array = new ArrayList<String>();
		
		for (Language idioma : idiomas){
			for (HotelSeguridad hotel : lista) {
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
		
		HotelSeguridad hotelSeguridad = new HotelSeguridad();
		hotelSeguridad.setId_hotel(form_hotel_id);
		hotelSeguridad.setLang(form_lang);
		hotelSeguridad.setDescription(form_security);
		
		seguridad = new HotelSeguridadManager().add(hotelSeguridad);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		h = new HotelSeguridad();
		h.setId(form_id);
		h = new HotelSeguridadManager().get(h);
		h.setDescription(form_security);
		
		HotelSeguridadManager manager = new HotelSeguridadManager();
		manager.update(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		h = new HotelSeguridad();
		h.setId(id);
		h = new HotelSeguridadManager().get(h);
		
		HotelSeguridadManager manager = new HotelSeguridadManager();
		manager.del(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<HotelSeguridad> getLista() {
		return lista;
	}

	public void setLista(List<HotelSeguridad> lista) {
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

	public HotelSeguridad getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(HotelSeguridad seguridad) {
		this.seguridad = seguridad;
	}

	public HotelSeguridad getH() {
		return h;
	}

	public void setH(HotelSeguridad h) {
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

	public String getForm_security() {
		return form_security;
	}

	public void setForm_security(String form_security) {
		this.form_security = form_security;
	}

}

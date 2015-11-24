package es.ubiqua.nhservices.backend.hotelDirectory.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.HotelTelefonosManager;
import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.manger.LanguageManager;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelTelefonos;
import es.ubiqua.nhservices.model.Language;

public class backendTelefonosAction extends ActionSupport {
	
	private List<HotelTelefonos> lista;
	private HotelTelefonos telefonos;
	private String page;
	private int id;
	private int id_hotel;
	private String lang;
	private int form_id;
	private int form_hotel_id;
	private String form_lang;
	private String form_telefonos;
	private HotelTelefonos h;
	private String status;
	
	private List<Hotel> hoteles;
	private List<Language> idiomas;
	private ArrayList<String> array;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new HotelTelefonosManager().listAll();
		page = "telefonos";
		return SUCCESS;
	}
	
	public String edit(){
		
		telefonos = new HotelTelefonosManager().getTelefonosByIdAndLang(id,lang);
		page = "telefonos";
		
		return SUCCESS;
	}
	
	public String nuevo(){
				
		hoteles = new HotelManager().list();
		
		return SUCCESS;
	}
	
	public String langDisponibles(){
		
		idiomas = new LanguageManager().list();
		lista = new HotelTelefonosManager().listLang(id);
		
		int count = 0;
		int encontrado = 0;
		array = new ArrayList<String>();
		
		for (Language idioma : idiomas){
			for (HotelTelefonos hotel : lista) {
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
		
		HotelTelefonos hotel = new HotelTelefonos();
		hotel.setId_hotel(form_hotel_id);
		hotel.setLang(form_lang);
		hotel.setDescription(form_telefonos);
		
		telefonos = new HotelTelefonosManager().add(hotel);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		h = new HotelTelefonos();
		h.setId(form_id);
		h = new HotelTelefonosManager().get(h);
		h.setDescription(form_telefonos);
		
		HotelTelefonosManager manager = new HotelTelefonosManager();
		manager.update(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		h = new HotelTelefonos();
		h.setId(id);
		h = new HotelTelefonosManager().get(h);
		
		HotelTelefonosManager manager = new HotelTelefonosManager();
		manager.del(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<HotelTelefonos> getLista() {
		return lista;
	}

	public void setLista(List<HotelTelefonos> lista) {
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
	
	public String getForm_telefonos() {
		return form_telefonos;
	}

	public void setForm_telefonos(String form_telefonos) {
		this.form_telefonos = form_telefonos;
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

	public HotelTelefonos getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(HotelTelefonos telefonos) {
		this.telefonos = telefonos;
	}

	public HotelTelefonos getH() {
		return h;
	}

	public void setH(HotelTelefonos h) {
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

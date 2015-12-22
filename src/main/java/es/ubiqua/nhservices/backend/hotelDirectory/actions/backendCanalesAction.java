package es.ubiqua.nhservices.backend.hotelDirectory.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.HotelCanalesManager;
import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.manger.LanguageManager;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.Language;

public class backendCanalesAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5192442894734535290L;
	private List<HotelCanales> lista;
	private HotelCanales canal;
	private String page;
	private int id;
	private int id_hotel;
	private String lang;
	private int form_id;
	private int form_hotel_id;
	private String form_lang;
	private String form_channels;
	private HotelCanales h;
	private String status;
	
	private List<Hotel> hoteles;
	private List<Language> idiomas;
	private ArrayList<String> array;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new HotelCanalesManager().listAll();
		page = "canales";
		return SUCCESS;
	}
	
	public String edit(){
		
		canal = new HotelCanalesManager().getCanalByIdAndLang(id,lang);
		page = "canales";
		
		return SUCCESS;
	}
	
	public String nuevo(){
				
		hoteles = new HotelManager().list();
		
		return SUCCESS;
	}
	
	public String langDisponibles(){
		
		idiomas = new LanguageManager().list();
		lista = new HotelCanalesManager().listLang(id);
		
		int count = 0;
		int encontrado = 0;
		array = new ArrayList<String>();
		
		for (Language idioma : idiomas){
			for (HotelCanales hotel : lista) {
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
		
		HotelCanales hotelCanal = new HotelCanales();
		hotelCanal.setId_hotel(form_hotel_id);
		hotelCanal.setLang(form_lang);
		hotelCanal.setChannels(form_channels);
		
		canal = new HotelCanalesManager().add(hotelCanal);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		h = new HotelCanales();
		h.setId(form_id);
		h = new HotelCanalesManager().get(h);
		h.setChannels(form_channels);
		
		HotelCanalesManager manager = new HotelCanalesManager();
		manager.update(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		h = new HotelCanales();
		h.setId(id);
		h = new HotelCanalesManager().get(h);
		
		HotelCanalesManager manager = new HotelCanalesManager();
		manager.del(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<HotelCanales> getLista() {
		return lista;
	}

	public void setLista(List<HotelCanales> lista) {
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
	
	public String getForm_channels() {
		return form_channels;
	}

	public void setForm_channels(String form_channels) {
		this.form_channels = form_channels;
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

	public HotelCanales getCanal() {
		return canal;
	}

	public void setCanal(HotelCanales canal) {
		this.canal = canal;
	}

	public HotelCanales getH() {
		return h;
	}

	public void setH(HotelCanales h) {
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

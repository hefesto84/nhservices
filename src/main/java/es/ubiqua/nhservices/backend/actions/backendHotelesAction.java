package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.HotelManager;
import es.ubiqua.nhservices.model.Hotel;

public class backendHotelesAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Hotel> lista;
	private Hotel hotel;
	private String form_name;
	private String status;
	private int id;
	private int form_id;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new HotelManager().list();

		return SUCCESS;
	}
	
	public String edit(){
		
		hotel = new Hotel();
		hotel.setId(id);
		hotel = new HotelManager().get(hotel);
		
		return SUCCESS;
	}
	
	public String nuevo(){
		
		return SUCCESS;
	}
	
	public String add(){
		
		Hotel h = new Hotel();
		h.setName(form_name);
		
		hotel = new HotelManager().add(h);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		hotel = new Hotel();
		hotel.setId(form_id);
		hotel = new HotelManager().get(hotel);
		hotel.setName(form_name);
		
		HotelManager manager = new HotelManager();
		manager.update(hotel);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		hotel = new Hotel();
		hotel.setId(id);
		hotel = new HotelManager().get(hotel);
		
		HotelManager manager = new HotelManager();
		manager.del(hotel);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<Hotel> getLista() {
		return lista;
	}

	public void setLista(List<Hotel> lista) {
		this.lista = lista;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

}

package es.ubiqua.nhservices.model;

public class HotelServicios {
	private int id;
	private int id_hotel;
	private int id_hotel_directory_servicios;
	
	public HotelServicios(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public int getId_hotel_directory_servicios() {
		return id_hotel_directory_servicios;
	}

	public void setId_hotel_directory_servicios(int id_hotel_directory_servicios) {
		this.id_hotel_directory_servicios = id_hotel_directory_servicios;
	}
	
}

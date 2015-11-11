package es.ubiqua.nhservices.model;

public class HotelEventos {
	private int id;
	private int id_hotel;
	private int id_hotel_directory_eventos;
	
	public HotelEventos(){
		
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

	public int getId_hotel_directory_eventos() {
		return id_hotel_directory_eventos;
	}

	public void setId_hotel_directory_eventos(int id_hotel_directory_eventos) {
		this.id_hotel_directory_eventos = id_hotel_directory_eventos;
	}
	
}

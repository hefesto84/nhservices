package es.ubiqua.nhservices.model;

public class HotelRestaurante {
	private int id;
	private int id_hotel;
	private int id_hotel_directory_restaurante;
	
	public HotelRestaurante(){
		
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

	public int getId_hotel_directory_restaurante() {
		return id_hotel_directory_restaurante;
	}

	public void setId_hotel_directory_restaurante(int id_hotel_directory_restaurante) {
		this.id_hotel_directory_restaurante = id_hotel_directory_restaurante;
	}
	
}

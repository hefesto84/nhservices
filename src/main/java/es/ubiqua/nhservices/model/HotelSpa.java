package es.ubiqua.nhservices.model;

public class HotelSpa {
	private int id;
	private int id_hotel;
	private int id_hotel_directory_spa;
	
	public HotelSpa(){
		
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

	public int getId_hotel_directory_spa() {
		return id_hotel_directory_spa;
	}

	public void setId_hotel_directory_spa(int id_hotel_directory_spa) {
		this.id_hotel_directory_spa = id_hotel_directory_spa;
	}

}

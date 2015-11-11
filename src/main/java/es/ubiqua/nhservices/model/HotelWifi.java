package es.ubiqua.nhservices.model;

public class HotelWifi {
	private int id;
	private int id_hotel;
	private int id_hotel_directory_wifi;
	
	public HotelWifi(){
		
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

	public int getId_hotel_directory_wifi() {
		return id_hotel_directory_wifi;
	}

	public void setId_hotel_directory_wifi(int id_hotel_directory_wifi) {
		this.id_hotel_directory_wifi = id_hotel_directory_wifi;
	}

}

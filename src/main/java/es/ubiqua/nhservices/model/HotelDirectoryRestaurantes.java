package es.ubiqua.nhservices.model;

public class HotelDirectoryRestaurantes {
	private int id;
	private String lang;
	private String name;
	private String description;
	private String images;
	private String menu;
	private String localization;
	private String timetable;
	private int phone;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImages() {
		return images;
	}
	
	public void setImages(String images) {
		this.images = images;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public String getLocalization() {
		return localization;
	}
	
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	
	public String getTimetable() {
		return timetable;
	}
	
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}

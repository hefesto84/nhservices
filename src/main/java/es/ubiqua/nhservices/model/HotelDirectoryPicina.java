package es.ubiqua.nhservices.model;

public class HotelDirectoryPicina {
	private int id;
	private String lang;
	private String localization;
	private String timetable;
	
	public HotelDirectoryPicina(){
		
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
	
}

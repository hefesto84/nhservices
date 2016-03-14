package es.ubiqua.nhservices.model;

public class Users {
	
	private int id;
	private String identificador;
	private String user;
	private String password;
	private int room;
	private String ip_asterisk;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}

	public String getIp_asterisk() {
		return ip_asterisk;
	}

	public void setIp_asterisk(String ip_asterisk) {
		this.ip_asterisk = ip_asterisk;
	}
	
}

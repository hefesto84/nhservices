package es.ubiqua.nhservices.model;

public class RoomServiceBebidas {
	private int id;
	private String lang;
	private String categoria;
	private String subcategoria;
	private String bebida;
	private String precio;
	
	public int getId() {
		return id;
	}
	
	public String getLang() {
		return lang;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

}

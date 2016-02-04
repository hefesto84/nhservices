package es.ubiqua.nhservices.model;

public class RoomServiceBebidas {
	private int id;
	private int categoria;
	private String subcategoria;
	private String identificador;
	private Float precio;
	
	public int getId() {
		return id;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public Float getPrecio() {
		return precio;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

}

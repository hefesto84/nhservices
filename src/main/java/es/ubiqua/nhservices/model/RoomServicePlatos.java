package es.ubiqua.nhservices.model;

public class RoomServicePlatos {
	private int id;
	private String lang;
	private int categoria;
	private String titulo;
	private String subtitulo;
	private String precio;
	private String imagen;
	private Boolean ligero_calorias;
	private Boolean vegetariano;
	private Boolean sin_gluten;
	private Boolean plato_especial;
	private Boolean disponible_24h;
	private Boolean desayuno;
	
	public int getId() {
		return id;
	}
	
	public String getLang() {
		return lang;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getSubtitulo() {
		return subtitulo;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public Boolean getLigero_calorias() {
		return ligero_calorias;
	}
	
	public Boolean getVegetariano() {
		return vegetariano;
	}
	
	public Boolean getSin_gluten() {
		return sin_gluten;
	}
	
	public Boolean getPlato_especial() {
		return plato_especial;
	}
	
	public Boolean getDisponible_24h() {
		return disponible_24h;
	}
	
	public Boolean getDesayuno() {
		return desayuno;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void setLigero_calorias(Boolean ligero_calorias) {
		this.ligero_calorias = ligero_calorias;
	}
	
	public void setVegetariano(Boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	
	public void setSin_gluten(Boolean sin_gluten) {
		this.sin_gluten = sin_gluten;
	}
	
	public void setPlato_especial(Boolean plato_especial) {
		this.plato_especial = plato_especial;
	}
	
	public void setDisponible_24h(Boolean disponible_24h) {
		this.disponible_24h = disponible_24h;
	}
	
	public void setDesayuno(Boolean desayuno) {
		this.desayuno = desayuno;
	}

}

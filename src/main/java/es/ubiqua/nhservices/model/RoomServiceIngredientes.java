package es.ubiqua.nhservices.model;

public class RoomServiceIngredientes {
	private int id;
	private int categoria;
	private String subcategoria;
	private String identificador;
	private Boolean ligero_calorias;
	private Boolean vegetariano;
	private Boolean sin_gluten;
	private Boolean plato_especial;
	private Boolean disponible_24h;
	
	public int getId() {
		return id;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

}

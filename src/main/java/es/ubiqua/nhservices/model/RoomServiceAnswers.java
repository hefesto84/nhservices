package es.ubiqua.nhservices.model;

public class RoomServiceAnswers {
	private int id;
	private int id_plato;
	private int id_question;
	private String respuesta;
	
	public int getId_plato() {
		return id_plato;
	}
	
	public void setId_plato(int id_plato) {
		this.id_plato = id_plato;
	}
	
	public int getId_question() {
		return id_question;
	}
	
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

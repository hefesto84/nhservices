package es.ubiqua.nhservices.model;

import java.util.List;

public class RoomServicePreguntas {
	
	private int id_plato;
	private int id_question;
	private String pregunta;
	private List<RoomServiceAnswers> respuesta;
	
	public String getPregunta() {
		return pregunta;
	}
	
	public List<RoomServiceAnswers> getRespuesta() {
		return respuesta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public void setRespuesta(List<RoomServiceAnswers> respuesta) {
		this.respuesta = respuesta;
	}

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
	

}

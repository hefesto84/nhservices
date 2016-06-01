package es.ubiqua.nhservices.model;

public class RoomServiceQuestions {
	private int id_plato;
	private int id_question;
	private String question;
	private String selection_type;
	
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
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSelection_type() {
		return selection_type;
	}

	public void setSelection_type(String selection_type) {
		this.selection_type = selection_type;
	}
	
}

package es.ubiqua.nhservices.model;

import java.util.List;

public class RoomServiceRequestProductQuestions {
	
	private int id_question;
	private List<Integer> id_answers;
	
	public int getId_question() {
		return id_question;
	}
	
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	
	public List<Integer> getId_answers() {
		return id_answers;
	}
	
	public void setId_answers(List<Integer> id_answers) {
		this.id_answers = id_answers;
	}
	
}

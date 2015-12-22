package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.LanguageManager;
import es.ubiqua.nhservices.model.Language;

public class backendIdiomasAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2418956274308485359L;
	private List<Language> lista;
	private Language idioma;
	private String form_idioma;
	private String status;
	private int id;
	private int form_id;

	public String execute() {
		    
	        return SUCCESS;
	}
	
	public String list(){
		
		lista = new LanguageManager().list();

		return SUCCESS;
	}
	
	public String edit(){
		
		idioma = new Language();
		idioma.setId(id);
		idioma = new LanguageManager().get(idioma);
		
		return SUCCESS;
	}
	
	public String nuevo(){
		
		return SUCCESS;
	}
	
	public String add(){
		
		Language lang = new Language();
		lang.setCode(form_idioma);
		
		idioma = new LanguageManager().add(lang);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String modify(){
		
		idioma = new Language();
		idioma.setId(form_id);
		idioma = new LanguageManager().get(idioma);
		idioma.setCode(form_idioma);
		
		LanguageManager manager = new LanguageManager();
		manager.update(idioma);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public String delete(){
		
		idioma = new Language();
		idioma.setId(id);
		idioma = new LanguageManager().get(idioma);
		
		LanguageManager manager = new LanguageManager();
		manager.del(idioma);
		
		status = "ok";
		
		return SUCCESS;
	}
	
	public List<Language> getLista() {
		return lista;
	}

	public void setLista(List<Language> lista) {
		this.lista = lista;
	}
	
	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Language getIdioma() {
		return idioma;
	}

	public void setIdioma(Language idioma) {
		this.idioma = idioma;
	}

	public String getForm_idioma() {
		return form_idioma;
	}

	public void setForm_idioma(String form_idioma) {
		this.form_idioma = form_idioma;
	}

}

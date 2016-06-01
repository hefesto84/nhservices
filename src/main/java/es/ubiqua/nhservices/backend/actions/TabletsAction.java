package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.TabletsManager;
import es.ubiqua.nhservices.model.Tablets;

public class TabletsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private List<Tablets> tablets;
	private Tablets tablet;
	private String tablet_name;
	private String identificador;
	private int id;
	
	public String tabletsList(){
		
		tablets = new TabletsManager().list();
		
		return SUCCESS;
		
	}
	
	public String tabletsNew(){
		
		return SUCCESS;
		
	}
	
	public String tabletsAdd(){
		
		tablet = new Tablets();
		tablet.setTablet(tablet_name);
		tablet.setIdentificador(identificador);
		tablet = new TabletsManager().add(tablet); 
		
		status = "ok";
		
		return SUCCESS;
		
	}
	
	public String tabletsDelete(){
		
		tablet = new Tablets();
		tablet.setId(id);
		new TabletsManager().del(tablet);
		
		status = "ok";
		
		return SUCCESS;
		
	}
	
	public String tabletsEdit(){
		
		tablet = new Tablets();
		tablet.setId(id);
		tablet = new TabletsManager().get(tablet);
		
		return SUCCESS;
		
	}
	
	public String tabletsUpdate(){
		
		tablet = new Tablets();
		tablet.setId(id);
		tablet = new TabletsManager().get(tablet);
		tablet.setTablet(tablet_name);
		tablet.setIdentificador(identificador);
		
		new TabletsManager().update(tablet);
		
		status = "ok";
		
		return SUCCESS;
		
	}

	public List<Tablets> getTablets() {
		return tablets;
	}

	public void setTablets(List<Tablets> tablets) {
		this.tablets = tablets;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Tablets getTablet() {
		return tablet;
	}

	public void setTablet(Tablets tablet) {
		this.tablet = tablet;
	}

	public String getTablet_name() {
		return tablet_name;
	}

	public void setTablet_name(String tablet_name) {
		this.tablet_name = tablet_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

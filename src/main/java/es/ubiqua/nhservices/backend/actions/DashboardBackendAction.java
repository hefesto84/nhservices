package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class DashboardBackendAction extends BaseBackendAction{

	private static final long serialVersionUID = 1L;

	private int numOtas = 0;
	
	public String execute(){
		
		if(!isLogged()){ return ERROR; }
		
		return SUCCESS;
	}
}

package es.ubiqua.nhservices.backend.actions;

public class DashboardBackendAction extends BaseBackendAction{

	private static final long serialVersionUID = 1L;
	
	public String execute(){
		
		if(!isLogged()){ return ERROR; }
		
		return SUCCESS;
	}
}

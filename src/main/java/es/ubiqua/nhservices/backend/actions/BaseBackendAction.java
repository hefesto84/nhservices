package es.ubiqua.nhservices.backend.actions;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.backend.manager.UserManager;
import es.ubiqua.nhservices.backend.model.User;

public class BaseBackendAction extends ActionSupport{

	protected UserManager userManager = new UserManager();

	public boolean isLogged(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.containsKey("login") && session.containsKey("context") && session.containsKey("sid")){
			
			return true;
		}
		return false;
	}
	
	public User getLoggedCustomer(){
		User u = new User();
		Integer id = (Integer)ActionContext.getContext().getSession().get("sid");
		u.setId(id);
		try{
			u = new UserManager().get(u);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}
		return u;
	}
	
}

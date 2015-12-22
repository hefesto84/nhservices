package es.ubiqua.nhservices.backend.actions;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import es.ubiqua.nhservices.backend.manager.UserManager;
import es.ubiqua.nhservices.backend.model.User;

public class LoginBackendAction  extends BaseBackendAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	
	private UserManager userManager = new UserManager();
	
	public String execute(){
		return SUCCESS;
	}

	public String signin(){
		if(user!=null && password!=null){
			
			User u = new User();
			u.setUser(user);
			u.setPassword(password);
			
			u = userManager.login(u);
			if(u==null){
				return ERROR;
			}
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("login", true);
			session.put("context",new Date());
			session.put("sid",u.getId());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String signout(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.remove("login");
		session.remove("context");
		return SUCCESS;
	}
	
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}

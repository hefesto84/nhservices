package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.TabletsManager;
import es.ubiqua.nhservices.manger.UsersManager;
import es.ubiqua.nhservices.model.Tablets;
import es.ubiqua.nhservices.model.Users;

public class UsersAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private List<Users> users;
	private List<Tablets> tablets;
	private Users user;
	private int room;
	private int tablet;
	private String usuario;
	private String password;
	private String ip_asterisk;
	
	private int id;
	
	public String usersList(){
		
		users = new UsersManager().list();
		
		return SUCCESS;
		
	}
	
	public String usersNew(){
		
		tablets = new TabletsManager().list();
		
		return SUCCESS;
		
	}
	
	public String usersAdd(){
		
		user = new Users();
		user.setRoom(room);
		user.setTablet(tablet);
		user.setUser(usuario);
		user.setPassword(password);
		user.setIp_asterisk(ip_asterisk);
		
		user = new UsersManager().add(user);
		
		status = "ok";
		
		return SUCCESS;
		
	}
	
	public String usersDelete(){
		
		user = new Users();
		user.setId(id);
		new UsersManager().del(user);
		
		status = "ok";
		
		return SUCCESS;
		
	}
	
	public String usersEdit(){
		
		user = new Users();
		user.setId(id);
		user = new UsersManager().get(user);
		
		tablets = new TabletsManager().list();
		
		return SUCCESS;
		
	}
	
	public String usersUpdate(){
		
		user = new Users();
		user.setId(id);
		user = new UsersManager().get(user);
		user.setRoom(room);
		user.setTablet(tablet);
		user.setUser(usuario);
		user.setPassword(password);
		user.setIp_asterisk(ip_asterisk);
		
		new UsersManager().update(user);
		
		status = "ok";
		
		return SUCCESS;
		
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public List<Tablets> getTablets() {
		return tablets;
	}

	public void setTablets(List<Tablets> tablets) {
		this.tablets = tablets;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getTablet() {
		return tablet;
	}

	public void setTablet(int tablet) {
		this.tablet = tablet;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp_asterisk() {
		return ip_asterisk;
	}

	public void setIp_asterisk(String ip_asterisk) {
		this.ip_asterisk = ip_asterisk;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

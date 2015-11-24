package es.ubiqua.nhservices.backend.manager;

import java.util.List;

import es.ubiqua.nhservices.backend.dao.UserDAO;
import es.ubiqua.nhservices.backend.model.User;

public class UserManager {
	
	private UserDAO userDao = new UserDAO();
	
	public UserManager(){
		
	}
	
	public List<User> list() {
		return userDao.list();
	}

	public User get(User user) {
		return userDao.get(user);
	}
	
	public User login(User user) {
		return userDao.login(user);
	}
	
	public User add(User user) {
		return userDao.add(user);
	}
	
	public void del(User user) {
		userDao.del(user);
	}
}

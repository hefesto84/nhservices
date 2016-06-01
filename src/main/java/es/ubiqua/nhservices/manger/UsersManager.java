package es.ubiqua.nhservices.manger;


import java.util.List;

import es.ubiqua.nhservices.dao.UsersDAO;
import es.ubiqua.nhservices.model.Users;

public class UsersManager {
	
	private UsersDAO usersDao = new UsersDAO();
	
	public UsersManager(){
		
	}
	
	public List<Users> list(){
		return usersDao.list();
	}

	public Users get(Users user){
		return usersDao.get(user);
	}

	public Users getUserByUUID(String uuid){
		return usersDao.getUserByUUID(uuid);
	}
	
	public Users add(Users user){
		return usersDao.add(user);
	}
	
	public void update(Users user){
		usersDao.update(user);
	}
	
	public void del(Users user){
		usersDao.del(user);
	}
}

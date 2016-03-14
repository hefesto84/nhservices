package es.ubiqua.nhservices.manger;


import es.ubiqua.nhservices.dao.UsersDAO;
import es.ubiqua.nhservices.model.Users;

public class UsersManager {
	
	private UsersDAO usersDao = new UsersDAO();
	
	public UsersManager(){
		
	}
	
	/*public List<Hotel> list(){
		return hotelDao.list();
	}*/

	public Users get(Users user){
		return usersDao.get(user);
	}
	
	/*public Hotel add(Hotel hotel){
		return hotelDao.add(hotel);
	}
	
	public void update(Hotel hotel){
		hotelDao.update(hotel);
	}
	
	public void del(Hotel hotel){
		hotelDao.del(hotel);
	}*/
}

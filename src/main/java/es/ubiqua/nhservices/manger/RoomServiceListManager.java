package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceListDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.RoomServiceList;

public class RoomServiceListManager {
	
	private RoomServiceListDAO roomServiceListDao = new RoomServiceListDAO();
	
	public RoomServiceListManager(){
		
	}
	
	public List<RoomServiceList> list(Hotel h, String lang){
		return roomServiceListDao.list(h,lang);
	}

	public RoomServiceList get(RoomServiceList roomServiceList){
		return roomServiceListDao.get(roomServiceList);
	}
	
	/*public HotelDirectoryRestaurantes add(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		return hotelDirectoryRestauranteDao.add(hotelDirectoryRestaurantes);
	}
	
	public void update(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		hotelDirectoryRestauranteDao.update(hotelDirectoryRestaurantes);
	}
	
	public void del(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		hotelDirectoryRestauranteDao.del(hotelDirectoryRestaurantes);
	}*/
}

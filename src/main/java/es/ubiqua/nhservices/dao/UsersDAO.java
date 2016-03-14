package es.ubiqua.nhservices.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Users;

public class UsersDAO extends BaseDAO{
	/*public List<Hotel> list(){
		List<Hotel> hotel = new ArrayList<Hotel>();
		SqlSession session = sql.openSession();
		try{
			hotel = session.selectList("SqlMapHotel.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return hotel;
	}*/
	
	public Users get(Users user){
		SqlSession session = sql.openSession();
		try{
			user = session.selectOne("SqlMapUsers.get",user);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return user;
	}

	
	/*public Hotel add(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotel;
	}
	
	public void update(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotel.update",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotel.del",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}*/
}

package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Users;

public class UsersDAO extends BaseDAO{
	public List<Users> list(){
		List<Users> users = new ArrayList<Users>();
		SqlSession session = sql.openSession();
		try{
			users = session.selectList("SqlMapUsers.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return users;
	}
	
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
	
	public Users getUserByUUID(String uuid){
		SqlSession session = sql.openSession();
		Users user = new Users();
		try{
			user = session.selectOne("SqlMapUsers.getUserByUUID",uuid);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return user;
	}

	
	public Users add(Users user){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapUsers.add",user);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return user;
	}
	
	public void update(Users user){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapUsers.update",user);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(Users user){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapUsers.del",user);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}

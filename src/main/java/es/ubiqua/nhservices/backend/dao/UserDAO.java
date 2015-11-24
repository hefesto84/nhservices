package es.ubiqua.nhservices.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.backend.model.User;

public class UserDAO extends es.ubiqua.nhservices.dao.BaseDAO {
	
	public List<User> list(){
		List<User> customers = new ArrayList<User>();
		SqlSession session = sql.openSession();
		try{
			customers = session.selectList("SqlMapUser.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return customers;
	}
	
	public User login(User user){
		SqlSession session = sql.openSession();
		try{
			user = session.selectOne("SqlMapUser.login",user);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return user;
	}
	
	public User get(User user){
		SqlSession session = sql.openSession();
		try{
			user = session.selectOne("SqlMapUser.get",user);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return user;
	}
	
	public User add(User user){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapUser.add",user);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return user;
	}
	
	public void del(User user){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapUser.del",user);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
	}
}

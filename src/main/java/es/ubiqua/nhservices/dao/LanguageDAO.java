package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Language;

public class LanguageDAO extends BaseDAO{
	
	public List<Language> list(){
		List<Language> language = new ArrayList<Language>();
		SqlSession session = sql.openSession();
		try{
			language = session.selectList("SqlMapLanguage.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return language;
	}
	
	public Language get(Language language){
		SqlSession session = sql.openSession();
		try{
			language = session.selectOne("SqlMapLanguage.get",language);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return language;
	}
	
	public Language add(Language language){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapLanguage.add",language);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return language;
	}
	
	public void update(Language language){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapLanguage.update",language);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(Language language){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapLanguage.del",language);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
}

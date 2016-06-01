package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Tablets;

public class TabletsDAO extends BaseDAO{
	public List<Tablets> list(){
		List<Tablets> tablets = new ArrayList<Tablets>();
		SqlSession session = sql.openSession();
		try{
			tablets = session.selectList("SqlMapTablets.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return tablets;
	}
	
	public Tablets get(Tablets tablet){
		SqlSession session = sql.openSession();
		try{
			tablet = session.selectOne("SqlMapTablets.get",tablet);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return tablet;
	}

	public Tablets add(Tablets tablet){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapTablets.add",tablet);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return tablet;
	}
	
	public void update(Tablets tablet){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapTablets.update",tablet);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(Tablets tablet){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapTablets.del",tablet);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}

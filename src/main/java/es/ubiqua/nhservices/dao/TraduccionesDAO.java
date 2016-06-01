package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Traducciones;

public class TraduccionesDAO extends BaseDAO{
	
	public List<Traducciones> listByLang(String lang){
		List<Traducciones> traducciones = new ArrayList<Traducciones>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("lang", lang);
			traducciones = session.selectList("SqlMapTraducciones.listByLang", map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return traducciones;
	}
	
}

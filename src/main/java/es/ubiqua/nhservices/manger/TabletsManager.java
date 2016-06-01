package es.ubiqua.nhservices.manger;


import java.util.List;

import es.ubiqua.nhservices.dao.TabletsDAO;
import es.ubiqua.nhservices.model.Tablets;

public class TabletsManager {
	
	private TabletsDAO tabletsDao = new TabletsDAO();
	
	public TabletsManager(){
		
	}
	
	public List<Tablets> list(){
		return tabletsDao.list();
	}

	public Tablets get(Tablets tablet){
		return tabletsDao.get(tablet);
	}
	
	public Tablets add(Tablets tablets){
		return tabletsDao.add(tablets);
	}
	
	public void update(Tablets tablet){
		tabletsDao.update(tablet);
	}
	
	public void del(Tablets tablet){
		tabletsDao.del(tablet);
	}
}

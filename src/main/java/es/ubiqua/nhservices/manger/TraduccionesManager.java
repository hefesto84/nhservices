package es.ubiqua.nhservices.manger;


import java.util.List;

import es.ubiqua.nhservices.dao.TraduccionesDAO;
import es.ubiqua.nhservices.model.Traducciones;

public class TraduccionesManager {
	
	private TraduccionesDAO traduccionesDao = new TraduccionesDAO();
	
	public TraduccionesManager(){
		
	}
	
	public List<Traducciones> listByLang(String lang){
		return traduccionesDao.listByLang(lang);
	}

}

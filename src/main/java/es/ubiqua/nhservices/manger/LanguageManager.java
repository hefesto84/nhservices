package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.LanguageDAO;
import es.ubiqua.nhservices.model.Language;

public class LanguageManager {
	
	private LanguageDAO languageDao = new LanguageDAO();
	
	public LanguageManager(){
			
	}
		
	public List<Language> list(){
		return languageDao.list();
	}

	public Language get(Language language){
		return languageDao.get(language);
	}
	
	public Language add(Language language){
		return languageDao.add(language);
	}
	
	public void update(Language language){
		languageDao.update(language);
	}
	
	public void del(Language language){
		languageDao.del(language);
	}

}

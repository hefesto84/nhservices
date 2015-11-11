package es.ubiqua.nhservices.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import es.ubiqua.nhservices.database.ConnectionFactory;

public class BaseDAO {
	protected SqlSessionFactory sql = ConnectionFactory.getSession();
}

package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IWebParametroDao;
import com.usco.edu.entities.WebParametro;
import com.usco.edu.resultSetExtractor.WebParametroSetExtractor;

@Repository
public class WebParametroDaoImpl implements IWebParametroDao {
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<WebParametro> obtenerWebParametro() {
		
		String sql = "select * from web_parametro wp where wp.wep_codigo = 486 ";
		return jdbcTemplate.query(sql, new WebParametroSetExtractor());
		
	}

}

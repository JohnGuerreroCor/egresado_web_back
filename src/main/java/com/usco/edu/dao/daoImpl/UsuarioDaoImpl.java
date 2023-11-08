package com.usco.edu.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUsuarioDao;
import com.usco.edu.entities.Usuario;
import com.usco.edu.rowMapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesLogin")
	public JdbcTemplate jdbcTemplate;

	@Override
	public Usuario findByUsername(String username) {
		String sql = "select top 1 * from carnetizacion.usuario_carnet_digital_login ucdl "
				+ "inner join uaa u on ucdl.usg_uaa = u.uaa_codigo "
				+ "inner join sede s on s.sed_codigo = u.sed_codigo "
				+ "inner join persona p on ucdl.up = p.per_codigo "
				+ "where  ucdl.us = ? order by ucdl.istipo asc";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());
	}

	@Override
	public boolean validarUser(String username) {
		int result = 0;
		String sql = "select COUNT(ucdl.us) from carnetizacion.usuario_carnet_digital_login ucdl " 
				+ "inner join uaa u on ucdl.usg_uaa = u.uaa_codigo "
				+ "inner join sede s on s.sed_codigo = u.sed_codigo "
				+ "inner join persona p on ucdl.up = p.per_codigo "
				+ "where ucdl.us = ? ";
		result =  jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
		return result > 0 ? true : false;
	}

}

package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Usuario;


public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setId(rs.getInt("uid"));
		user.setPassword(rs.getString("uwd2"));
		user.setRole(rs.getString("usg_grupo"));
		user.setUsername(rs.getString("us"));
		user.setState(rs.getInt("state") > 0 ? true : false);
		user.setPersona(new PersonaRowMapper().mapRow(rs, rowNum));
		user.setHoraInicioSesion(rs.getString("horaInicioSesion"));
		return user;
	}

}

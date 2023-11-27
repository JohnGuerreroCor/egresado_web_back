package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IHistorialLaboralDao;
import com.usco.edu.entities.HistorialLaboral;
import com.usco.edu.resultSetExtractor.HistorialLaboralSetExtractor;

@Repository
public class HistorialLaboralDaoImpl implements IHistorialLaboralDao {
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<HistorialLaboral> obtenerHistorialLaboral(String id) {
		
		String sql = "select * from graduado.historial_laboral hl "
				+ "inner join persona p on hl.per_codigo = p.per_codigo "
				+ "where hl.hil_estado = 1 and p.per_identificacion = '" + id + "'";
		
		return jdbcTemplate.query(sql, new HistorialLaboralSetExtractor());
		
	}

	@Override
	public int registrar(HistorialLaboral historialLaboral) {
		
		String sql = "INSERT INTO graduado.historial_laboral "
				+ "(per_codigo, hil_cargo, hil_funcion, hil_empresa, hil_fecha_inicio, hil_fecha_fin) "
				+ "VALUES(?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				historialLaboral.getPersonaCodigo(),
				historialLaboral.getCargo(),
				historialLaboral.getFuncion(),
				historialLaboral.getEmpresa(),
				historialLaboral.getFechaInicio(),
				historialLaboral.getFechaFin()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", historialLaboral.getPersonaCodigo());
			parameter.addValue("cargo", historialLaboral.getCargo());
			parameter.addValue("funcion", historialLaboral.getFuncion());
			parameter.addValue("empresa", historialLaboral.getEmpresa());
			parameter.addValue("fechaInicio", historialLaboral.getFechaInicio());
			parameter.addValue("fechaFin", historialLaboral.getFechaFin());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizar(HistorialLaboral historialLaboral) {
		
		String sql = "UPDATE graduado.historial_laboral "
				+ "SET per_codigo=?, hil_cargo=?, hil_funcion=?, hil_empresa=?, hil_fecha_inicio=?, hil_fecha_fin=?, hil_estado=? "
				+ "WHERE hil_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				historialLaboral.getPersonaCodigo(),
				historialLaboral.getCargo(),
				historialLaboral.getFuncion(),
				historialLaboral.getEmpresa(),
				historialLaboral.getFechaInicio(),
				historialLaboral.getFechaFin(),
				historialLaboral.getEstado(),
				historialLaboral.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", historialLaboral.getPersonaCodigo());
			parameter.addValue("cargo", historialLaboral.getCargo());
			parameter.addValue("funcion", historialLaboral.getFuncion());
			parameter.addValue("empresa", historialLaboral.getEmpresa());
			parameter.addValue("fechaInicio", historialLaboral.getFechaInicio());
			parameter.addValue("fechaFin", historialLaboral.getFechaFin());
			parameter.addValue("estado", historialLaboral.getEstado());
			parameter.addValue("codigo", historialLaboral.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}
	
}

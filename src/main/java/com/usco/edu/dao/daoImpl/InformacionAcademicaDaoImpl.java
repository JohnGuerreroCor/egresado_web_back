package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IInformacionAcademicaDao;
import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.resultSetExtractor.DatosComplementariosSetExtractor;
import com.usco.edu.resultSetExtractor.HabilidadInformaticaSetExtractor;
import com.usco.edu.resultSetExtractor.IdiomaSetExtractor;
import com.usco.edu.resultSetExtractor.RegistroEducativoSetExtractor;

@Repository
public class InformacionAcademicaDaoImpl implements IInformacionAcademicaDao {
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id) {
		
		String sql = "select * from graduado.registro_educativo re "
				+ "inner join persona p on re.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on re.nia_codigo = na.nia_codigo "
				+ "inner join municipio m on re.mun_codigo = m.mun_codigo "
				+ "inner join departamento d on m.dep_codigo = d.dep_codigo "
				+ "inner join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where p.per_identificacion = '" + id + "' and re.ree_estado = 1 order by re.ree_fecha_fin desc";
		
		return jdbcTemplate.query(sql, new RegistroEducativoSetExtractor());
		
	}

	@Override
	public List<Idioma> obtenerListadoIdiomas(String id) {
		
		String sql = "select i.idi_codigo, p.per_codigo, i.idi_idioma, "
				+ "idc.idd_codigo as conversacionCodigo, idc.idd_nombre as conversacion, "
				+ "ide.idd_codigo as escrituraCodigo, ide.idd_nombre as escritura, idl.idd_codigo as lecturaCodigo, "
				+ "idl.idd_nombre as lectura, i.idi_estado from graduado.idioma i "
				+ "inner join persona p on i.per_codigo = p.per_codigo "
				+ "inner join graduado.idioma_dominio idc on i.idi_conversacion = idc.idd_codigo "
				+ "inner join graduado.idioma_dominio ide on i.idi_escritura = ide.idd_codigo "
				+ "inner join graduado.idioma_dominio idl on i.idi_lectura = idl.idd_codigo "
				+ "where p.per_identificacion = '" + id + "' and i.idi_estado = 1";
		
		return jdbcTemplate.query(sql, new IdiomaSetExtractor());
		
	}
	
	@Override
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id) {
		
		String sql = "select * from graduado.habilidad_informatica hi "
				+ "inner join persona p on hi.per_codigo = p.per_codigo "
				+ "inner join graduado.habilidad_informatica_dominio hid on hi.hid_codigo = hid.hid_codigo "
				+ "where p.per_identificacion = '" + id + "' and hi.hai_estado = 1";
		
		return jdbcTemplate.query(sql, new HabilidadInformaticaSetExtractor());
		
	}
	
	@Override
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id) {
		
		String sql = "select * from graduado.datos_complementarios dc "
				+ "inner join estudiante e on dc.est_codigo = e.est_codigo "
				+ "inner join persona p on e.per_codigo = p.per_codigo "
				+ "inner join programa pr on e.pro_codigo = pr.pro_codigo "
				+ "inner join uaa u on pr.uaa_codigo = u.uaa_codigo "
				+ "left join graduado g on dc.est_codigo = g.est_codigo "
				+ "where dc.est_codigo = '" + id + "'";
		
		return jdbcTemplate.query(sql, new DatosComplementariosSetExtractor());
		
	}


	@Override
	public int registrarHabilidadInformatica(HabilidadInformatica habilidadInformatica) {
		
		String sql = "INSERT INTO graduado.habilidad_informatica "
				+ "(per_codigo, hai_nombre_programa, hid_codigo) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				habilidadInformatica.getPersonaCodigo(),
				habilidadInformatica.getNombrePrograma(),
				habilidadInformatica.getDominioCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", habilidadInformatica.getPersonaCodigo());
			parameter.addValue("nombre", habilidadInformatica.getNombrePrograma());
			parameter.addValue("dominio", habilidadInformatica.getDominioCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int actualizarHabilidadInformatica(HabilidadInformatica habilidadInformatica) {
		
		String sql = "UPDATE graduado.habilidad_informatica "
				+ "SET per_codigo=?, hai_nombre_programa=?, hid_codigo=?, hai_estado=? "
				+ "WHERE hai_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				habilidadInformatica.getPersonaCodigo(),
				habilidadInformatica.getNombrePrograma(),
				habilidadInformatica.getDominioCodigo(),
				habilidadInformatica.getEstado(),
				habilidadInformatica.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", habilidadInformatica.getPersonaCodigo());
			parameter.addValue("nombre", habilidadInformatica.getNombrePrograma());
			parameter.addValue("dominio", habilidadInformatica.getDominioCodigo());
			parameter.addValue("estado", habilidadInformatica.getEstado());
			parameter.addValue("codigo", habilidadInformatica.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int registrarIdioma(Idioma idioma) {
		
		String sql = "INSERT INTO graduado.idioma "
				+ "(per_codigo, idi_idioma, idi_conversacion, idi_escritura, idi_lectura) "
				+ "VALUES( ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				idioma.getPersonaCodigo(),
				idioma.getNombre(),
				idioma.getConversacionCodigo(),
				idioma.getEscrituraCodigo(),
				idioma.getLecturaCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", idioma.getPersonaCodigo());
			parameter.addValue("nombre", idioma.getNombre());
			parameter.addValue("conversacion", idioma.getConversacionCodigo());
			parameter.addValue("escritura", idioma.getEscrituraCodigo());
			parameter.addValue("lectura", idioma.getLecturaCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int actualizarIdioma(Idioma idioma) {
		
		String sql = "UPDATE graduado.idioma "
				+ "SET per_codigo=?, idi_idioma=?, idi_conversacion=?, idi_escritura=?, idi_lectura=?, idi_estado=? "
				+ "WHERE idi_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				idioma.getPersonaCodigo(),
				idioma.getNombre(),
				idioma.getConversacionCodigo(),
				idioma.getEscrituraCodigo(),
				idioma.getLecturaCodigo(),
				idioma.getEstado(),
				idioma.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", idioma.getPersonaCodigo());
			parameter.addValue("nombre", idioma.getNombre());
			parameter.addValue("conversacion", idioma.getConversacionCodigo());
			parameter.addValue("escritura", idioma.getEscrituraCodigo());
			parameter.addValue("lectura", idioma.getLecturaCodigo());
			parameter.addValue("estado", idioma.getEstado());
			parameter.addValue("codigo", idioma.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int registrarEducativo(RegistroEducativo registroEducativo) {
		
		String sql = "INSERT INTO graduado.registro_educativo "
				+ "(per_codigo, ree_titulo, nia_codigo, ree_institucion, mun_codigo, ree_fecha_fin, ree_finalizado) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				registroEducativo.getPersonaCodigo(),
				registroEducativo.getTitulo(),
				registroEducativo.getNivelAcademicoCodigo(),
				registroEducativo.getInstitucion(),
				registroEducativo.getMunicipioCodigo(),
				registroEducativo.getFechaFin(),
				registroEducativo.getFinalizado()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", registroEducativo.getPersonaCodigo());
			parameter.addValue("titulo", registroEducativo.getTitulo());
			parameter.addValue("nivelAcademico", registroEducativo.getNivelAcademicoCodigo());
			parameter.addValue("institucion", registroEducativo.getInstitucion());
			parameter.addValue("municipio", registroEducativo.getMunicipioCodigo());
			parameter.addValue("fechaFin", registroEducativo.getFechaFin());
			parameter.addValue("finalizado", registroEducativo.getFinalizado());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int actualizarEducativo(RegistroEducativo registroEducativo) {
		
		String sql = "UPDATE graduado.registro_educativo "
				+ "SET per_codigo=?, ree_titulo=?, nia_codigo=?, ree_institucion=?, mun_codigo=?, ree_fecha_fin=?, ree_finalizado=?, ree_estado=? "
				+ "WHERE ree_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				registroEducativo.getPersonaCodigo(),
				registroEducativo.getTitulo(),
				registroEducativo.getNivelAcademicoCodigo(),
				registroEducativo.getInstitucion(),
				registroEducativo.getMunicipioCodigo(),
				registroEducativo.getFechaFin(),
				registroEducativo.getFinalizado(),
				registroEducativo.getEstado(),
				registroEducativo.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", registroEducativo.getPersonaCodigo());
			parameter.addValue("titulo", registroEducativo.getTitulo());
			parameter.addValue("nivelAcademico", registroEducativo.getNivelAcademicoCodigo());
			parameter.addValue("institucion", registroEducativo.getInstitucion());
			parameter.addValue("municipio", registroEducativo.getMunicipioCodigo());
			parameter.addValue("fechaFin", registroEducativo.getFechaFin());
			parameter.addValue("finalizado", registroEducativo.getFinalizado());
			parameter.addValue("estado", registroEducativo.getEstado());
			parameter.addValue("codigo", registroEducativo.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int registrarDatosComplementarios(DatosComplementarios datosComplementarios) {
		
		String sql = "INSERT INTO graduado.datos_complementarios "
				+ "(est_codigo, dac_trabajo_grado, dac_perfil_profesional) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				datosComplementarios.getEstudianteCodigo(),
				datosComplementarios.getModalidad(),
				datosComplementarios.getPerfilProfesional(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", datosComplementarios.getEstudianteCodigo());
			parameter.addValue("cargo", datosComplementarios.getModalidad());
			parameter.addValue("funcion", datosComplementarios.getPerfilProfesional());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int actualizarDatosComplementarios(DatosComplementarios datosComplementarios) {
		
		String sql = "UPDATE graduado.datos_complementarios "
				+ "SET est_codigo=?, dac_trabajo_grado=?, dac_perfil_profesional=? "
				+ "WHERE dac_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				datosComplementarios.getEstudianteCodigo(),
				datosComplementarios.getModalidad(),
				datosComplementarios.getPerfilProfesional(),
				datosComplementarios.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", datosComplementarios.getEstudianteCodigo());
			parameter.addValue("cargo", datosComplementarios.getModalidad());
			parameter.addValue("funcion", datosComplementarios.getPerfilProfesional());
			parameter.addValue("codigo", datosComplementarios.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizarRegistroEgresado(DatosComplementarios datosComplementarios) {
		
		String sql = "UPDATE dbo.estudiante "
				+ "SET est_registro_egresado=1 "
				+ "WHERE est_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				datosComplementarios.getEstudianteCodigo(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("estudianteCodigo", datosComplementarios.getEstudianteCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

}

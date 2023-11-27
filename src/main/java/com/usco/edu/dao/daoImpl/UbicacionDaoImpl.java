package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUbicacionDao;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;
import com.usco.edu.resultSetExtractor.PaisSetExtractor;
import com.usco.edu.resultSetExtractor.DepartamentoSetExtractor;
import com.usco.edu.resultSetExtractor.MunicipioSetExtractor;

@Repository
public class UbicacionDaoImpl implements IUbicacionDao {
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		
		String sql = "select * from departamento d "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where d.pai_codigo = " + paiCodigo + " ";
		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());
		
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo) {
		
		String sql = "select * FROM municipio m "
				+ "inner join departamento d on m.dep_codigo = d.dep_codigo "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "where m.dep_codigo = " + depCodigo + " ";
		return jdbcTemplate.query(sql, new MunicipioSetExtractor());
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo) {
		
		String sql = "select * from departamento d "
				+ "inner join pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join municipio m on d.dep_codigo = m.dep_codigo "
				+ "where m.mun_codigo =" + munCodigo + " ";
		
		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());
		
	}

	@Override
	public List<Pais> obtenerPaisesPorDepartamento(int depCodigo) {
		
		String sql = "select * from pais p "
				+ "inner join departamento d on p.pai_codigo = d.pai_codigo "
				+ "where d.dep_codigo =" + depCodigo + " ";
		
		return jdbcTemplate.query(sql, new PaisSetExtractor());
		
	}
	
	@Override
	public List<Pais> obtenerPaises() {
		
		String sql = "select * from pais p where p.pai_nombre != ''";
		return jdbcTemplate.query(sql, new PaisSetExtractor());
		
	}
	
	@Override
	public List<Municipio> obtenerMunicipios() {
		
		String sql = "select * from municipio m "
				+ "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais p on d.pai_codigo = p.pai_codigo ";
		return jdbcTemplate.query(sql, new MunicipioSetExtractor());
		
	}


}

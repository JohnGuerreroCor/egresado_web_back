package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Pais;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;

public interface IUbicacionDao {
	
	//UBICACION GEOGRÁFICA
	
	public List<Pais> obtenerPaises();
	
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo);
	
	public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo);
	
	public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo);
	
	public List<Pais> obtenerPaisesPorDepartamento(int depCodigo);
	
	public List<Municipio> obtenerMunicipios();
	

}

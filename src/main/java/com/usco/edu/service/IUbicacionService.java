package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;

public interface IUbicacionService {
	
		//UBICACION GEOGRÁFICA
	
		public List<Pais> obtenerPaises();
	
		public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo);
	
		public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo);
	
		public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo);
	
		public List<Pais> obtenerPaisesPorDepartamento(int depCodigo);
		
		public List<Municipio> obtenerMunicipios();
	

}

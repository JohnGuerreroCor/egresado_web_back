package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IUbicacionDao;
import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;
import com.usco.edu.service.IUbicacionService;

@Service
public class UbicacionServiceImpl implements IUbicacionService {
	
	@Autowired
	private IUbicacionDao ubicacionDao;
	
	@Override
	public List<Pais> obtenerPaises() {
		
		return ubicacionDao.obtenerPaises();
		
	}
	
	@Override
	public List<Municipio> obtenerMunicipios() {
		
		return ubicacionDao.obtenerMunicipios();
		
	}
	
	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		
		return ubicacionDao.obtenerDepartamentosPorPais(paiCodigo);
		
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(int depCodigo) {
		
		return ubicacionDao.obtenerMunicipiosPorDepartamento(depCodigo);
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorMunicipio(int munCodigo) {
		
		return ubicacionDao.obtenerDepartamentosPorMunicipio(munCodigo);
		
	}

	@Override
	public List<Pais> obtenerPaisesPorDepartamento(int depCodigo) {
		
		return ubicacionDao.obtenerPaisesPorDepartamento(depCodigo);
		
	}

}

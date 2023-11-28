package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IInformacionAcademicaDao;
import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.service.IInformacionAcademicaService;

@Service
public class InformacionAcademicaServiceImpl implements IInformacionAcademicaService {
	
	@Autowired
	private IInformacionAcademicaDao informacionAcademicaDao;

	@Override
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id) {
		
		return informacionAcademicaDao.obtenerListadoHabilidadesInformaticas(id);
		
	}

	@Override
	public List<Idioma> obtenerListadoIdiomas(String id) {
		
		return informacionAcademicaDao.obtenerListadoIdiomas(id);
		
	}

	@Override
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id) {
		
		return informacionAcademicaDao.obtenerListadoRegistroEducativo(id);
		
	}

	@Override
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id) {
		
		return informacionAcademicaDao.obtenerListadoDatosComplementarios(id);
		
	}

	@Override
	public int registrarHabilidadInformatica(HabilidadInformatica habilidadInformatica) {
		
		return informacionAcademicaDao.registrarHabilidadInformatica(habilidadInformatica);
		
	}

	@Override
	public int actualizarHabilidadInformatica(HabilidadInformatica habilidadInformatica) {
		
		return informacionAcademicaDao.actualizarHabilidadInformatica(habilidadInformatica);
		
	}

	@Override
	public int registrarIdioma(Idioma idioma) {
		
		return informacionAcademicaDao.registrarIdioma(idioma);
		
	}

	@Override
	public int actualizarIdioma(Idioma idioma) {
		
		return informacionAcademicaDao.actualizarIdioma(idioma);
		
	}

	@Override
	public int registrarEducativo(RegistroEducativo registroEducativo) {
		
		return informacionAcademicaDao.registrarEducativo(registroEducativo);
		
	}

	@Override
	public int actualizarEducativo(RegistroEducativo registroEducativo) {
		
		return informacionAcademicaDao.actualizarEducativo(registroEducativo);
		
	}

	@Override
	public int registrarDatosComplementarios(DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaDao.registrarDatosComplementarios(datosComplementarios);
		
	}

	@Override
	public int actualizarDatosComplementarios(DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaDao.actualizarDatosComplementarios(datosComplementarios);
		
	}

	@Override
	public int actualizarRegistroEgresado(DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaDao.actualizarRegistroEgresado(datosComplementarios);
		
	}
	
}

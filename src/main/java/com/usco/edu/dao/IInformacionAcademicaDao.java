package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;

public interface IInformacionAcademicaDao {
	
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(String id);
	
	public List<Idioma> obtenerListadoIdiomas(String id);
	
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(String id);
	
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(String id);
	
	public int registrarHabilidadInformatica(HabilidadInformatica habilidadInformatica);
	
	public int actualizarHabilidadInformatica(HabilidadInformatica habilidadInformatica);
	
	public int registrarIdioma(Idioma idioma);
	
	public int actualizarIdioma(Idioma idioma);
	
	public int registrarEducativo(RegistroEducativo registroEducativo);
	
	public int actualizarEducativo(RegistroEducativo registroEducativo);
	
	public int registrarDatosComplementarios(DatosComplementarios datosComplementarios);
	
	public int actualizarDatosComplementarios(DatosComplementarios datosComplementarios);
	
	public int actualizarRegistroEgresado(DatosComplementarios datosComplementarios);

}

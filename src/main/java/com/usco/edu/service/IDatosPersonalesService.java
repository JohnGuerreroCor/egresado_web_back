package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.TipoDocumento;

public interface IDatosPersonalesService {
	
	public List<DatosPersonales> obtenerDatosPersonales(String identificacion);
	
	public List<TipoDocumento> obtenerIdentificacionTipos();
	
	public List<EstadoCivil> obtenerEstadosCivil();
	
	public List<GrupoSanguineo> obtenerGruposSanguineos();
	
	public int actualizarDatosContacto(DatosPersonales contacto);
	
	public int actualizarDatosResidencia(DatosPersonales residencia);
	
}

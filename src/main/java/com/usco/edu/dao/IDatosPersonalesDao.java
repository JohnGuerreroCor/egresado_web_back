package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.TipoDocumento;

public interface IDatosPersonalesDao {
	
public List<DatosPersonales> obtenerDatosPersonales(String identificacion);
	
	public List<TipoDocumento> obtenerIdentificacionTipos();
	
	public List<EstadoCivil> obtenerEstadosCivil();
	
	public List<GrupoSanguineo> obtenerGruposSanguineos();
	
	public int actualizarDatosContacto(DatosPersonales contacto);
	
	public int actualizarDatosResidencia(DatosPersonales residencia);
	
	

}

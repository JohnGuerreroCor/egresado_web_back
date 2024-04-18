package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IDatosPersonalesDao;
import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.TipoDocumento;
import com.usco.edu.service.IDatosPersonalesService;

@Service
public class DatosPersonalesServiceImpl implements IDatosPersonalesService {
	
	@Autowired
	private IDatosPersonalesDao datosPersonalesDao;
	

	@Override
	public List<DatosPersonales> obtenerDatosPersonales(String identificacion) {
		
		return datosPersonalesDao.obtenerDatosPersonales(identificacion);
		
	}

	@Override
	public List<TipoDocumento> obtenerIdentificacionTipos() {
		
		return datosPersonalesDao.obtenerIdentificacionTipos();
		
	}

	@Override
	public List<EstadoCivil> obtenerEstadosCivil() {
		
		return datosPersonalesDao.obtenerEstadosCivil();
		
	}

	@Override
	public List<GrupoSanguineo> obtenerGruposSanguineos() {
		
		return datosPersonalesDao.obtenerGruposSanguineos();
		
	}

	@Override
	public int actualizarDatosContacto(DatosPersonales contacto) {
		
		return datosPersonalesDao.actualizarDatosContacto(contacto);
		
	}

	@Override
	public int actualizarDatosResidencia(DatosPersonales residencia) {
		
		return datosPersonalesDao.actualizarDatosResidencia(residencia);
		
	}
	
}

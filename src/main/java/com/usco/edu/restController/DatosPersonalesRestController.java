package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.DatosPersonales;
import com.usco.edu.entities.EstadoCivil;
import com.usco.edu.entities.GrupoSanguineo;
import com.usco.edu.entities.TipoDocumento;
import com.usco.edu.service.IDatosPersonalesService;

@RestController
@RequestMapping(path = "datos")
public class DatosPersonalesRestController {
	
	@Autowired
	IDatosPersonalesService datosPersonalesService;
	
	@GetMapping(path = "obtener-datos-personales/{identificacion}")
	public List<DatosPersonales> obtenerPaises(@PathVariable String identificacion) {
		
		return datosPersonalesService.obtenerDatosPersonales(identificacion);
		
	}
	
	@GetMapping(path = "obtener-tipos-identificacion")
	public List<TipoDocumento> obtenerDepartamentos() {
		
		return datosPersonalesService.obtenerIdentificacionTipos();
		
	}
	
	@GetMapping(path = "obtener-estados-civil")
	public List<EstadoCivil> obtenerEstadosCivil() {
		
		return datosPersonalesService.obtenerEstadosCivil();
		
	}
	
	@GetMapping(path = "obtener-grupos-sanguineos")
	public List<GrupoSanguineo> obtenerGruposSanguineos() {
		
		return datosPersonalesService.obtenerGruposSanguineos();
		
	}
	
	@PutMapping(path = "actualizar-datos-contacto")
	public int actualizarDatosContacto(@RequestBody DatosPersonales contacto) {
		
		return datosPersonalesService.actualizarDatosContacto(contacto);
		
	}
	
	@PutMapping(path = "actualizar-datos-residencia")
	public int actualizarDatosResidencia(@RequestBody DatosPersonales residencia) {
		
		return datosPersonalesService.actualizarDatosResidencia(residencia);
		
	}
	
	

}

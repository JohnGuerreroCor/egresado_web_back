package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Departamento;
import com.usco.edu.entities.Municipio;
import com.usco.edu.entities.Pais;
import com.usco.edu.service.IUbicacionService;

@RestController
@RequestMapping(path = "ubicacion")
public class UbicacionRestController {
	
	@Autowired
	IUbicacionService ubicacionService;
	
	@GetMapping(path = "obtener-paises")
	public List<Pais> obtenerPaises() {
		
		return ubicacionService.obtenerPaises();
		
	}
	
	@GetMapping(path = "obtener-municipios")
	public List<Municipio> obtenerMunicipios() {
		
		return ubicacionService.obtenerMunicipios();
		
	}
	
	@GetMapping(path = "obtener-departamentos-pais/{codigo}")
	public List<Departamento> obtenerDepartamentosPorPais(@PathVariable int codigo) {
		
		return ubicacionService.obtenerDepartamentosPorPais(codigo);
		
	}
	
	@GetMapping(path = "obtener-municipios-departamento/{codigo}")
	public List<Municipio> obtenerMunicipiosPorDepartamento(@PathVariable int codigo) {
		
		return ubicacionService.obtenerMunicipiosPorDepartamento(codigo);
		
	}
	
	@GetMapping(path = "obtener-departamentos-municipio/{codigo}")
	public List<Departamento> obtenerDepartamentosPorMunicipio(@PathVariable int codigo) {
		
		return ubicacionService.obtenerDepartamentosPorMunicipio(codigo);
		
	}
	
	@GetMapping(path = "obtener-paises-departamento/{codigo}")
	public List<Pais> obtenerPaisesPorDepartamento(@PathVariable int codigo) {
		
		return ubicacionService.obtenerPaisesPorDepartamento(codigo);
		
	}
	

}

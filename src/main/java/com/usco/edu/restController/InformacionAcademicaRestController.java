package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.DatosComplementarios;
import com.usco.edu.entities.HabilidadInformatica;
import com.usco.edu.entities.Idioma;
import com.usco.edu.entities.RegistroEducativo;
import com.usco.edu.service.IInformacionAcademicaService;

@RestController
@RequestMapping(path = "informacionAcademica")
public class InformacionAcademicaRestController {
	
	@Autowired
	IInformacionAcademicaService informacionAcademicaService;
	
	@GetMapping(path = "obtener-habilidades-informaticas/{id}")
	public List<HabilidadInformatica> obtenerListadoHabilidadesInformaticas(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoHabilidadesInformaticas(id);
		
	}
	
	@GetMapping(path = "obtener-idiomas/{id}")
	public List<Idioma> obtenerListadoIdiomas(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoIdiomas(id);
		
	}
	
	@GetMapping(path = "obtener-registro-educativo/{id}")
	public List<RegistroEducativo> obtenerListadoRegistroEducativo(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoRegistroEducativo(id);
		
	}
	
	@GetMapping(path = "obtener-datos-complementarios/{id}")
	public List<DatosComplementarios> obtenerListadoDatosComplementarios(@PathVariable String id) {
		
		return informacionAcademicaService.obtenerListadoDatosComplementarios(id);
		
	}
	
	@PutMapping(path = "registrar-habilidad-informatica")
	public int registrarHabilidadInformatica(@RequestBody HabilidadInformatica habilidadInformatica) {
		
		return informacionAcademicaService.registrarHabilidadInformatica(habilidadInformatica);
		
	}
	
	@PutMapping(path = "actualizar-habilidad-informatica")
	public int actualizarHabilidadInformatica(@RequestBody HabilidadInformatica habilidadInformatica) {
		
		return informacionAcademicaService.actualizarHabilidadInformatica(habilidadInformatica);
		
	}
	
	@PutMapping(path = "registrar-idioma")
	public int registrarIdioma(@RequestBody Idioma idioma) {
		
		return informacionAcademicaService.registrarIdioma(idioma);
		
	}
	
	@PutMapping(path = "actualizar-idioma")
	public int actualizarIdioma(@RequestBody Idioma idioma) {
		
		return informacionAcademicaService.actualizarIdioma(idioma);
		
	}
	
	@PutMapping(path = "registrar-educativo")
	public int registrarEducativo(@RequestBody RegistroEducativo registroEducativo) {
		
		return informacionAcademicaService.registrarEducativo(registroEducativo);
		
	}
	
	@PutMapping(path = "actualizar-educativo")
	public int actualizarEducativo(@RequestBody RegistroEducativo registroEducativo) {
		
		return informacionAcademicaService.actualizarEducativo(registroEducativo);
		
	}
	
	@PutMapping(path = "registrar-datos-complementarios")
	public int registrarDatosComplementarios(@RequestBody DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaService.registrarDatosComplementarios(datosComplementarios);
		
	}
	
	@PutMapping(path = "actualizar-datos-complementarios")
	public int actualizarDatosComplementarios(@RequestBody DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaService.actualizarDatosComplementarios(datosComplementarios);
		
	}
	
	@PutMapping(path = "actualizar-registro-egresado")
	public int actualizarRegistroEgresado(@RequestBody DatosComplementarios datosComplementarios) {
		
		return informacionAcademicaService.actualizarRegistroEgresado(datosComplementarios);
		
	}

}

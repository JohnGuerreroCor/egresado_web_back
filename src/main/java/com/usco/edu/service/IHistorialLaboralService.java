package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.HistorialLaboral;

public interface IHistorialLaboralService {
	
	public List<HistorialLaboral> obtenerHistorialLaboral(String id);
	
	public int registrar(HistorialLaboral historialLaboral);
	
	public int actualizar(HistorialLaboral historialLaboral);

}

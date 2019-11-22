package com.bolsadeideas.Sprintboot.app.models.service;

import java.util.List;

import com.bolsadeideas.Sprintboot.app.models.entity.Factura;


public interface IFacturaService {
	
	public List<Factura>findall();
	
	public void save(Factura factura);
	
	public Factura findOne(Long id);
	
	public void delete(Long id);
}

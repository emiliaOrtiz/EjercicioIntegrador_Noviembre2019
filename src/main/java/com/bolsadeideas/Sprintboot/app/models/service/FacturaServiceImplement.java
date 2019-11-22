package com.bolsadeideas.Sprintboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsadeideas.Sprintboot.app.models.dao.IFacturaDao;
import com.bolsadeideas.Sprintboot.app.models.entity.Factura;

@Service
public class FacturaServiceImplement implements IFacturaService{

	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Factura> findall() {
		return (List<Factura>) facturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Factura factura) {
		facturaDao.save(factura);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findOne(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaDao.deleteById(id);
		
	}

}

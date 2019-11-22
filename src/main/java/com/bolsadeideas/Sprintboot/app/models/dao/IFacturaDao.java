package com.bolsadeideas.Sprintboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.Sprintboot.app.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura,Long> {

}

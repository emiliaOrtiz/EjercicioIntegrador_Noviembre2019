package com.bolsadeideas.Sprintboot.app.models.service;

import java.util.List;

import com.bolsadeideas.Sprintboot.app.models.entity.Cliente;


public interface IClienteService {
	
    public List<Cliente>findall();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}

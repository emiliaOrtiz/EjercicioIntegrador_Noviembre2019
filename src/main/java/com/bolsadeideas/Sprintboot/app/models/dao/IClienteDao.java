

package com.bolsadeideas.Sprintboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.Sprintboot.app.models.entity.Cliente;


public interface IClienteDao extends CrudRepository<Cliente, Long>{
	

}

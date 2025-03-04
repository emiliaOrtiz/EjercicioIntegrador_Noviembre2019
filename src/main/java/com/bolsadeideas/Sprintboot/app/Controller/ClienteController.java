package com.bolsadeideas.Sprintboot.app.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.Sprintboot.app.models.entity.Cliente;
import com.bolsadeideas.Sprintboot.app.models.entity.Factura;
import com.bolsadeideas.Sprintboot.app.models.service.IClienteService;
import com.bolsadeideas.Sprintboot.app.models.service.IFacturaService;


@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;


	@RequestMapping(value="listar",method=RequestMethod.GET)
	public String listar(Model model) {
	model.addAttribute("titulo","Listado de clientes");	
	model.addAttribute("clientes",clienteService.findall());
	
	return "listar";
	}
	

	@RequestMapping(value="/form")
	public String crear(Map<String,Object>model) {
		Cliente cliente=new Cliente();
		model.put("cliente",cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
		
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model,RedirectAttributes flash) {
		
		Cliente cliente=null;
		if(id>0) {
			cliente=clienteService.findOne(id);
			if (cliente==null) {
				flash.addFlashAttribute("error","el id del cliente no existe");
				return "redirect:/listar";
			}
		}
		else {
			flash.addFlashAttribute("error","el id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "editar cliente");
		return "/form";
		
	}
	
	@RequestMapping(value="/factura/{id}")
	public String factura(@PathVariable(value="id") Long id,Map<String,Object> model) {
		Factura factura=new Factura();
		factura.setDescripcion("factura de productos para la empresa");
		
		model.put("cliente",clienteService.findOne(id));
		model.put("titulo", "crear factura");
		model.put("factura", factura);
		return "factura";
		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente,BindingResult result,Model model,RedirectAttributes flash,SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Cliente");
			return "form";		
		}
		String mensajeFlash=(cliente.getId()!=null)? "Cliente editado con exito":"Cliente creado con exito";	
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:listar";
		
	}
		
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes flash){
		if(id>0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success","Cliente eliminado con exito");
		}
		return "redirect:/listar";
		
	}
}

package crud.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crud.controlador.entidad.Cliente;
import crud.dao.InterfazClienteDAO;

@Controller
@RequestMapping("/clientes")
public class Controlador {
	
	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		
		//Obtener clientes desde DAO
		ArrayList<Cliente> clientes = clienteDAO.getClientes();
		
		//Agregar clientes al modelo
		modelo.addAttribute("clientes", clientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/nuevoCliente")
	public String irFormularioNuevoCliente(Model modelo) {
		
		//Bind de datos de los clientes
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		
		return "formulario-cliente";
	}
	
	@GetMapping("/editarCliente")
	public String irFormularioEditarCliente(@RequestParam("id") int id, Model modelo) {
		
		//Obtener cliente con el id recibido
		Cliente cliente = clienteDAO.getCliente(id);
				
		//Establecer cliente como atributo del modelo
		modelo.addAttribute("cliente", cliente);
		
		//Enviar al formulario
		
		return "formulario-cliente";
	}
	
	@PostMapping("/insertarActualizarCliente")
	public String insertarActualizarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		//Insertar cliente en la base de datos
		clienteDAO.insertarActualizarCliente(cliente);

		return "redirect:/clientes/lista";
	}
	
	@GetMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("id") int id) {
		
		//Eliminar cliente con el id recibido
		clienteDAO.eliminarCliente(id);
				
		//Reedireccionar a la lista de clientes
		return "redirect:/clientes/lista";
	}
	
	@Autowired
	private InterfazClienteDAO clienteDAO;
}
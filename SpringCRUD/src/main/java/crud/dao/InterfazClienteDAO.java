package crud.dao;

import java.util.ArrayList;
import crud.controlador.entidad.Cliente;

public interface InterfazClienteDAO {
	
	public ArrayList<Cliente> getClientes();

	public void insertarActualizarCliente(Cliente cliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);
}
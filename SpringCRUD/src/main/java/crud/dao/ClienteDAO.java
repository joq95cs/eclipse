package crud.dao;

import java.util.ArrayList;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.controlador.entidad.Cliente;

@Repository
public class ClienteDAO implements InterfazClienteDAO {

	@Override
	@Transactional
	public ArrayList<Cliente> getClientes() {
		//Obtener sesi�n
		
		Session sesion = sessionFactory.getCurrentSession();
		
		//Crear query
		
		Query<Cliente> query = sesion.createQuery("from Cliente", Cliente.class);
		
		//Ejecutar query y devolver resultados
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(query.getResultList());

		return clientes;
	}
	
	@Override
	@Transactional
	public void insertarActualizarCliente(Cliente cliente) {
		
		//Obtener sesi�n
		Session sesion = sessionFactory.getCurrentSession();
		
		//Insertar o actualizar el cliente
		//sesion.save(cliente);
		sesion.saveOrUpdate(cliente);
	}
	
	@Override
	@Transactional
	public Cliente getCliente(int id) {
		
		//Obtener la sesi�n
		Session sesion = sessionFactory.getCurrentSession();
		
		//Obtener la informaci�n del cliente
		Cliente cliente = sesion.get(Cliente.class, id);
		return cliente;
	}
	
	@Override
	@Transactional
	public void eliminarCliente(int id) {
		
		//Obtener sesi�n
		Session sesion = sessionFactory.getCurrentSession();
		
		//Borrar cliente
		Query query = sesion.createQuery("delete from Cliente where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
}
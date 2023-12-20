package hibernate2;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidos {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			//Obtener el cliente
			Cliente cliente = session.get(Cliente.class, 4);
			
			//Crear pedidos del cliente
			Pedido pedido1 = new Pedido(new GregorianCalendar(2022, 05, 10));
			Pedido pedido2 = new Pedido(new GregorianCalendar(2022, 10, 14));
			Pedido pedido3 = new Pedido(new GregorianCalendar(2022, 01, 01));
			
			//Agregar pedidos al cliente
			cliente.agregarPedido(pedido1);
			cliente.agregarPedido(pedido2);
			cliente.agregarPedido(pedido3);

			//Guardar los pedidos en la base
			session.save(pedido1);
			session.save(pedido2);
			session.save(pedido3);

			session.getTransaction().commit();
			
			System.out.println("Pedidos guardados exitosamente");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}
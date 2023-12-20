package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidos {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			//Obtener el cliente
			Cliente cliente = session.get(Cliente.class, 4);
			
			System.out.println(cliente);
			
			System.out.println(cliente.getPedidos());
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}
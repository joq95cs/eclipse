package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerDetalles {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			Cliente cliente = session.get(Cliente.class, 9);
			
			System.out.println(cliente);
			
			System.out.println(cliente.getDetallesCliente());
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}

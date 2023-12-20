package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarCliente {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			Cliente cliente = session.get(Cliente.class, 8);
			
			if(cliente!=null) {
				
				session.delete(cliente);
				System.out.println("Registro eliminado exitosamente");
			
			} else {
				
				System.out.println("El cliente no existe");
			}
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}
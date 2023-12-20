package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PruebaInsertar {
	
	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			Cliente cl1 = new Cliente("Soanna", "Castellanos", "La 18");
			session.beginTransaction();
			session.save(cl1);
			session.getTransaction().commit();
			System.out.println("Registro insertado exitosamente");
			
			session.beginTransaction();
			System.out.println("Registro con id: " + cl1.getId());
			Cliente insertado = session.get(Cliente.class, cl1.getId());
			System.out.println("Registro: " + insertado);
			session.getTransaction().commit();
			
			session.close();
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
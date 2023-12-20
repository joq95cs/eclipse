package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PruebaActualizar {
	
	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			//int id = 8;
			session.beginTransaction();
			//Cliente clienteRecibido = session.get(Cliente.class, id);
			//clienteRecibido.setNombre("Dolores Carlota");
			//clienteRecibido.setApellido("De la Fuente");
			session.getTransaction().commit();
			//session.createQuery("update Cliente set apellido = 'Locas' where apellido like 'C%'").executeUpdate();
			session.createQuery("delete Cliente where direccion = 'Sabino'").executeUpdate();
			System.out.println("Registro actualizado o eliminado exitosamente");
			
			session.close();
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
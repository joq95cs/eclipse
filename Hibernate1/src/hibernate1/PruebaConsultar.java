package hibernate1;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PruebaConsultar {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			ArrayList<Cliente> clientes = new ArrayList<Cliente>(session.createQuery("from Cliente").list());
			
			leerClientes(clientes);
			
			System.out.println();
			ArrayList<Cliente> castellanos = new ArrayList<Cliente>(session.createQuery("from Cliente cl where cl.apellido='Castellanos'").list());
			
			leerClientes(castellanos);
			
			System.out.println();
			ArrayList<Cliente> or = new ArrayList<Cliente>(session.createQuery("from Cliente cl where cl.apellido='Castellanos' or cl.direccion='La 18'").list());
			
			leerClientes(or);
			
			System.out.println();
			ArrayList<Cliente> and = new ArrayList<Cliente>(session.createQuery("from Cliente cl where cl.apellido='Vaca' and cl.direccion='La 18'").list());
			
			leerClientes(and);

			session.getTransaction().commit();
			session.close();
			
		} finally {
			
			sessionFactory.close();
		}
	}

	private static void leerClientes(ArrayList<Cliente> clientes) {
		for(Cliente c: clientes) {
			
			System.out.println(c);
		}
	}
}

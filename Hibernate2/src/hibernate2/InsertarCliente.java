package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarCliente {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			Cliente cliente = new Cliente("Mad", "Minsk", "Newcrest");
			DetallesCliente detallesCliente = new DetallesCliente("www.mad.com", "4521696811", "Mad la genial y fabulosa");
			
			cliente.setDetallesCliente(detallesCliente); //Se asocian las 2 tablas
			
			session.beginTransaction();
			session.save(cliente);
			
			session.getTransaction().commit();
			
			System.out.println("Registro insertado exitosamente");
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}
package castellanos.joqsan.HibernatePeliculas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Eliminar {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pelicula.class).buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			
			/*sesion.beginTransaction();
			Pelicula pelicula = sesion.get(Pelicula.class, 3);
			sesion.remove(pelicula);
			sesion.getTransaction().commit();*/
			
			sesion.beginTransaction();
			sesion.createMutationQuery("delete from Pelicula pl where pl.estudio = 'Fox'").executeUpdate();
			sesion.getTransaction().commit();
			
		} finally {
			
			
		}
	}
}

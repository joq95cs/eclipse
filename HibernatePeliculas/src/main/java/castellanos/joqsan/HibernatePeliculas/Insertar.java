package castellanos.joqsan.HibernatePeliculas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insertar {
	
    public static void main( String[] args ) {
    	
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pelicula.class).buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			
			Pelicula pelicula = new Pelicula("Titanic", "Fox", 1997, "Aventura");
			sesion.beginTransaction();
			sesion.persist(pelicula);
			sesion.getTransaction().commit();
			
		} finally {
			
			sf.close();
			sesion.close();
		}
    }
}
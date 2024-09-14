package castellanos.joqsan.HibernatePeliculas;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Buscar {
	
    public static void main( String[] args ) {
    	
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Pelicula.class).buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			
			/*sesion.beginTransaction();
			Pelicula pelicula = sesion.get(Pelicula.class, 1);
			System.out.println(pelicula);*/
			
			ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>(sesion.createQuery("from Pelicula pl where pl.estudio = 'Disney'").list());
			
			for(Pelicula each: peliculas) {
				
				System.out.println(each);
			}
			
		} finally {
			
			sf.close();
			sesion.close();
		}
    }
}
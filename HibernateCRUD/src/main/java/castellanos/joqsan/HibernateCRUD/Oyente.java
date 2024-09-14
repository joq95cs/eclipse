
package castellanos.joqsan.HibernateCRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gui_hibernatecrud.Marco;

public class Oyente implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		correcto = false;
		
		factory = new Configuration().configure("castellanos/joqsan/HibernateCRUD/hibernate.cfg.xml").addAnnotatedClass(Pelicula.class).buildSessionFactory();
		session = factory.openSession();
		
		session.beginTransaction();
		
		if(e.getSource() == Marco.m.btInsertar) {
			
			//System.out.println("Insertado");
			
			try {
			
				pelicula = new Pelicula (
						
						Marco.m.textoNombre.getText(),
						Marco.m.textoEstudio.getText(),
						Integer.parseInt(Marco.m.textoAgno.getText()),
						Marco.m.textoGenero.getText()
				);
				
				if(!pelicula.validar()) {
					
					throw new Exception("Empty fields");
				}
				
				session.persist(pelicula);
				correcto = true;
				JOptionPane.showMessageDialog(null, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception ex) {
				
				correcto = false;
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		} else if(e.getSource() == Marco.m.btActualizar) {
			
			//System.out.println("Actualizar");
			
			try {
	
				int id = Integer.parseInt(Marco.m.textoID.getText());
				
				pelicula = session.get(Pelicula.class, id);
				pelicula.setNombre(Marco.m.textoNombre.getText());
				pelicula.setEstudio(Marco.m.textoEstudio.getText());
				pelicula.setAgno(Integer.parseInt(Marco.m.textoAgno.getText()));
				pelicula.setGenero(Marco.m.textoGenero.getText());
				
				if(!pelicula.validar()) {
					
					throw new Exception("Empty fields");
				}
				
				session.merge(pelicula);
				correcto = true;
				JOptionPane.showMessageDialog(null, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				
			} catch(Exception ex) {
				
				correcto = false;
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(e.getSource() == Marco.m.btBuscar) {
			
			//System.out.println("Buscar");
			
			try {
			
				int id = Integer.parseInt(Marco.m.textoID.getText());
				
				pelicula = session.get(Pelicula.class, id);
				Marco.m.textoNombre.setText(pelicula.getNombre());
				Marco.m.textoEstudio.setText(pelicula.getEstudio());
				Marco.m.textoAgno.setText(pelicula.getAgno() + "");
				Marco.m.textoGenero.setText(pelicula.getGenero());
				correcto = true;
				
			} catch(Exception ex) {
				
				correcto = false;
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			
			//System.out.println("Eliminar");
			
			try {
				
				int id = Integer.parseInt(Marco.m.textoID.getText());
				
				pelicula = session.get(Pelicula.class, id);
				session.remove(pelicula);
				correcto = true;
				JOptionPane.showMessageDialog(null, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				
			} catch(Exception ex) {
				
				correcto = false;
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(correcto) {
			
			session.getTransaction().commit();
			System.out.println("\nCOMMIT\n");
			
		} else {
			
			session.getTransaction().rollback();
			System.out.println("\nROLLBACK\n");
		}
		
		factory.close();
		session.close();
	}
	
	private Session session;
	private SessionFactory factory;
	private Pelicula pelicula;
	private boolean correcto;
}

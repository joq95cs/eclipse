package tap;

import javax.swing.JOptionPane;

public class Canciones {

	public static void main(String[] args) {
		
		Cancion cancion1 = new Cancion("", "");
		
		Cancion cancion2 = new Cancion("", "");
		
		Cancion cancion3 = new Cancion("", "");
		
		cancion1.setTitulo(JOptionPane.showInputDialog("Introduce el título de la canción 1"));
		
		cancion1.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canción 1"));
		
		int duracion1 = cancion1.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duración de la canción 1 en minutos (sin decimales)")));
		
		cancion2.setTitulo(JOptionPane.showInputDialog("Introduce el título de la canción 2"));
		
		cancion2.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canción 2"));
		
		int duracion2 = cancion2.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duración de la canción 2 en minutos (sin decimales)")));
		
		cancion3.setTitulo(JOptionPane.showInputDialog("Introduce el título de la canción 3"));
		
		cancion3.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canción 3"));
		
		int duracion3 = cancion3.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duración de la canción 3 en minutos (sin decimales)")));
		
		System.out.println("Canción 1\n" + cancion1.getTitulo() + "\n" + cancion1.getAutor() + "\nDuración: " + duracion1 + " segs" +
				"\n\nCanción 2\n" + cancion2.getTitulo() + "\n" + cancion2.getAutor() + "\nDuración: " + duracion2 + " segs" + 
				"\n\nCanción 2\n" + cancion3.getTitulo() + "\n" + cancion3.getAutor() + "\nDuración: " + duracion3 + " segs");
		
	}

}

class Cancion {
	
	public Cancion(String titulo, String autor) {
		
		this.titulo = titulo;
		
		this.autor = autor;
		
	}
	
	public void setTitulo(String titulo) {
		
		this.titulo = titulo;
		
	}
	
	public void setAutor(String autor) {
		
		this.autor = autor;
		
	}
	
	public String getTitulo() {
		
		return "Título: " + titulo;
		
	}
	
	public String getAutor() {
		
		return "Autor: " +  autor;
		
	}
	
	public int determinarTiempoCancion(int duracion) {
		
		return duracion * 60;
		
	}
	
	private String titulo;
	
	private String autor;
	
}

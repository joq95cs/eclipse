package tap;

import javax.swing.JOptionPane;

public class Canciones {

	public static void main(String[] args) {
		
		Cancion cancion1 = new Cancion("", "");
		
		Cancion cancion2 = new Cancion("", "");
		
		Cancion cancion3 = new Cancion("", "");
		
		cancion1.setTitulo(JOptionPane.showInputDialog("Introduce el t�tulo de la canci�n 1"));
		
		cancion1.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canci�n 1"));
		
		int duracion1 = cancion1.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duraci�n de la canci�n 1 en minutos (sin decimales)")));
		
		cancion2.setTitulo(JOptionPane.showInputDialog("Introduce el t�tulo de la canci�n 2"));
		
		cancion2.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canci�n 2"));
		
		int duracion2 = cancion2.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duraci�n de la canci�n 2 en minutos (sin decimales)")));
		
		cancion3.setTitulo(JOptionPane.showInputDialog("Introduce el t�tulo de la canci�n 3"));
		
		cancion3.setAutor(JOptionPane.showInputDialog("Introduce el autor de la canci�n 3"));
		
		int duracion3 = cancion3.determinarTiempoCancion(Integer.parseInt(JOptionPane.showInputDialog("Introduce duraci�n de la canci�n 3 en minutos (sin decimales)")));
		
		System.out.println("Canci�n 1\n" + cancion1.getTitulo() + "\n" + cancion1.getAutor() + "\nDuraci�n: " + duracion1 + " segs" +
				"\n\nCanci�n 2\n" + cancion2.getTitulo() + "\n" + cancion2.getAutor() + "\nDuraci�n: " + duracion2 + " segs" + 
				"\n\nCanci�n 2\n" + cancion3.getTitulo() + "\n" + cancion3.getAutor() + "\nDuraci�n: " + duracion3 + " segs");
		
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
		
		return "T�tulo: " + titulo;
		
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

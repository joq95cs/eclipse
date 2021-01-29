package poo;

public class Prueba_Clases_Abstractas {

	public static void main(String[] args) {
		
		Artista madonna = new Artista();
		
		madonna.entretener(new Cantante() {
			
			public void cantar() {}
			
		} );

	}

}

abstract class Cantante {
	
	public abstract void cantar();
	
	public void bailar() {}
	
}

class Artista {
	
	public void entretener(Cantante c) {}
	
}
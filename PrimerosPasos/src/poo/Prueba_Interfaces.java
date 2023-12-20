package poo;

public class Prueba_Interfaces {

	public static void main(String[] args) {
		
		Joven lola = new Joven();
		
		lola.hacerDeberes(new Estudiante() {
			
			public void hacerTarea() {}
			
			public void asistirClases() {}
			
		});

	}

}

interface Estudiante {
	
	public void hacerTarea();
	
	public void asistirClases();
	
}

class Joven {
	
	public void hacerDeberes(Estudiante e) {
		
	}
	
}

package poo;

public class InstanciacionEnMetodos2 {

	public static void main(String[] args) {
		
		Pais japon = new Pais();
		
		japon.setCiudad(new Ciudad() {
			
			public void generarTrafico() {}
			
			public void generarTurismo() {
				
				System.out.println("Hay turismo");
				
			}
			
		});

	}

}

class Ciudad {
	
	public void generarContaminacion() {}
	
	public void generarTrafico() {}
	
	public void generarEstres() {}
	
}

class Pais {
	
	public void setCiudad(Ciudad c) {}
	
}

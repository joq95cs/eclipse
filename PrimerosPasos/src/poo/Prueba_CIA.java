package poo;

public class Prueba_CIA {

	public static void main(String[] args) {
		
		SerVivo ser = new SerVivo() {
			
			public void comer(String comida) {
				
				System.out.println(comida + " come el ser vivo...");
				
			}
			
		};
		
		ser.comer("Huevo");
		
	}

}

class SerVivo {
	
	public void comer(String comida) {
		
		System.out.println("El ser vivo come " + comida);
		
	}
	
}

class Planta extends SerVivo {
	
}

class Vegetal extends Planta {
	
}

class Verdura extends Vegetal {
	
}

class Fruta extends Vegetal {
	
}
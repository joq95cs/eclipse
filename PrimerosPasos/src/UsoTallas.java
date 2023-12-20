import java.util.*;
public class UsoTallas {
	
	//enum Talla {CHICA, MEDIANA, GRANDE, EXTRA_GRANDE} //Debe ser fuera del método Main
	
	enum Talla {
		
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private Talla(String abreviatura) {
			
			this.abreviatura = abreviatura;
			
		}
		
		public String dameAbreviatura() {
			
			return "Abreviatura: " + abreviatura;
			
		}
			
		private String abreviatura;
		
	}

	public static void main(String[] args) {
		
		/* String talla;
		
		talla = "Pequeña";
		
		talla = "Mediana";
		
		talla = "Grande";
		
		talla = "Azúl"; */
		
		
		/* Talla s = Talla.CHICA;
		
		Talla m = Talla.MEDIANA;
		
		Talla l = Talla.GRANDE;
		
		Talla xl = Talla.EXTRA_GRANDE */
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escriba una talla (MINI, MEDIANA, GRANDE, MUY_GRANDE): ");
		
		String entrada_datos = entrada.next().toUpperCase();
		
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("Talla: " + la_talla);
		
		System.out.println("Abreviatura: " + la_talla.dameAbreviatura());
		
		entrada.close();

	}

}

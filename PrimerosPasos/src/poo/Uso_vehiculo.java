package poo;

public class Uso_vehiculo {

	public static void main(String[] args) {
		
		//Coche Renault = new Coche(); //Instanciar una clase. Ejemplar de clase.
		
		//System.out.println("Este coche tiene " + Renault.ruedas + " ruedas");

		//System.out.print(Renault.dime_largo());
		
		/* Coche mi_coche = new Coche();
		
		mi_coche.establece_color(JOptionPane.showInputDialog("Introduce color del coche"));
		
		System.out.println(mi_coche.dime_datos_generales());
		
		System.out.println(mi_coche.dime_color());
		
		mi_coche.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
		
		System.out.println(mi_coche.dime_asientos());
		
		mi_coche.configura_climatizador(JOptionPane.showInputDialog("¿Tienea climatizador?"));
		
		System.out.println(mi_coche.dime_climatizador());
		
		System.out.println(mi_coche.dime_peso_coche());
		
		System.out.println("El precio del coche es $" + mi_coche.precio_coche() + ".00 pesos."); */
		
		Coche mi_coche1 = new Coche();
		
		mi_coche1.establece_color("Naranja");
		
		Furgoneta mi_furgoneta1 = new Furgoneta(8, 600);
		
		mi_furgoneta1.establece_color("Verde");
		
		mi_furgoneta1.configura_asientos("Sí");
		
		mi_furgoneta1.configura_climatizador("Sí");
		
		System.out.println(mi_coche1.dime_datos_generales() + "\n" + mi_coche1.dime_color());
		
		System.out.println(mi_furgoneta1.dime_datos_generales() + mi_furgoneta1.dimeDatosFurgoneta());
	
	}

}
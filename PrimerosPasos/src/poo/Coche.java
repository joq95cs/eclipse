package poo;

public class Coche {
	
	private int ruedas;
	
	private int alto;
	
	private int largo;
	
	private int ancho;
	
	private int motor;
	
	private int peso_plataforma;
	
	private String color;
	
	private int peso_total;
	
	private boolean asientos_cuero, climatizador;
	
	public Coche() {
		
		ruedas = 4;
		
		largo = 2000;
		
		ancho = 300;
		
		alto = 160;
		
		motor = 1600;
		
		peso_plataforma = 1000;
			
	}
	
	public String dime_datos_generales() { //GETTER
		
		return "El vehículo tiene " + ruedas + " ruedas. Mide " + alto + " m de alto, " + ancho + " m de ancho y "
				+ largo + " m de largo. " + "Tiene un peso de plataforma de " + peso_plataforma + " kg."
				+ " Su motor es de " + motor + ".";
		
	}
	
	public void establece_color(String color_coche) { //SETTER
		
		color = color_coche;
	}
	
	public String dime_color() {
		
		return "El color del coche es " + color + ".";
	}
	
	public void configura_asientos(String asientos_cuero) { //SETTER
		
		if(asientos_cuero.equalsIgnoreCase("Sí")) {
			
			this.asientos_cuero = true;
			
		}
		
		else {
			
			this.asientos_cuero = false;
		}
		
		
	}
	
	public String dime_asientos() { //GETTER
		
		if(asientos_cuero==true) {
			
			return "El coche tiene asientos de cuero.";
		}
		
		else {
			
			return "El coche tiene asientos de serie.";
		}
	}
	
	public void configura_climatizador(String climatizador) { //SETTER
		
		if(climatizador.equalsIgnoreCase("Sí")) {
			
			this.climatizador = true;
			
		}
		
		else {
			
			this.climatizador = false;
			
		}
	
	}
	
	public String dime_climatizador() { //GETTER
		
		if(climatizador==true) {
			
			return "El coche incorpora climatizador.";
			
		}
		
		else {
			
			return "El coche lleva aire acondicionado.";
			
		}
		
	}
	
	public String dime_peso_coche() { //GETTER Y SETTER
		
		int peso_carroceria = 500;
		
		peso_total = peso_plataforma + peso_carroceria;
		
		if(asientos_cuero==true) {
			
			peso_total = peso_plataforma + 50;
			
		}
		
		if(climatizador==true) {
			
			peso_total = peso_plataforma + 20;
			
		}
		
		return "El peso del coche es " + peso_total + " kg.";
		
	}
	
	public int precio_coche() {
		
		int precio_final = 30000;
		
		if(asientos_cuero==true) {
			
			precio_final += 10000;
			
		}
		
		if(climatizador==true) {
			
			precio_final += 5000;
			
		}
		
		return precio_final;
	}
}

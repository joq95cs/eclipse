package poo;

import java.awt.Color;

public class ComparacionObjetos {

	public static void main(String[] args) {
		
		Uruapense objeto1 = new Uruapense("Ángel", "Limón");
		
		Uruapense objeto2 = new Uruapense("Ángel", "Limón");
		
		if(objeto1 == objeto2) {
			
			System.out.println("Objetos iguales");
			
		} else {
			
			System.out.println("Objetos diferentes");
			
		}

	}

}

class Humano {
	
	public Humano(String nombre, String continente) {
		
		this.nombre = nombre;
		
		this.continente = continente;
		
	}
	
	private String nombre;
	
	private String continente;
	
}

class Americano extends Humano {
	
	public Americano(String nombre, String pais) {
		
		super(nombre, "América");
		
		this.pais = pais;
		
	}
	
	private String pais;
	
}

class Mexicano extends Americano {
	
	public Mexicano(String nombre, String estado) {
		
		super(nombre, "México");
		
		this.estado = estado;
		
	}
	
	private String estado;
	
}

class Michoacano extends Mexicano {
	
	public Michoacano(String nombre, String ciudad) {
		
		super(nombre, "Michoacán");
		
		this.ciudad = ciudad;
		
	}
	
	private String ciudad;
	
}

class Uruapense extends Michoacano {
	
	public Uruapense(String nombre, String calle) {
		
		super(nombre, "Uruapan");
		
		this.calle = calle;
		
	}
	
	String calle;
	
}
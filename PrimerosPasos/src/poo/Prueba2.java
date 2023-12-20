package poo;

import javax.swing.JOptionPane;

public class Prueba2 {
	
	public static void main(String[] arrgs) {
		
		Individuo individuo1 = new Individuo(JOptionPane.showInputDialog("Ingrese nombre"), 
				Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad")));
		
		String color = individuo1.colorFavorito(JOptionPane.showInputDialog("Ingrese color favorito"));
		
		System.out.println(individuo1.decirInfo() + " " + color);
		
	}
	
}

class Individuo implements Individuos {
	
	public Individuo(String nombre, int edad) {
		
		this.nombre = nombre;
		
		this.edad = edad;
		
	}
	
	public String decirInfo() {
		
		return (nombre + " tiene " + edad + " años.").toUpperCase();
		
	}
	
	public String colorFavorito(String color) {
		
		colorFavorito = color;
		
		return ("Su color favorito es " + colorFavorito + ".").toUpperCase(); 
		
	}
	
	private String nombre;
	
	private int edad;
	
	private String colorFavorito;
	
}

interface Individuos {
	
	public abstract String decirInfo(); 
	
	public abstract String colorFavorito(String color);
	
}

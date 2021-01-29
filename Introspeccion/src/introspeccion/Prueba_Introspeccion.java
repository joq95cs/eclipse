package introspeccion;

import java.lang.reflect.*;

import java.util.Scanner;

import javax.swing.*;

public class Prueba_Introspeccion {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce el nombre de la clase: ");
		
		String nombreClase = entrada.next();
		
		System.out.println();
		
		//Imprimir clase y superclase
		
		try {
			
			Class cl = Class.forName(nombreClase);
			
			Class superCl = cl.getSuperclass();
			
			System.out.print(nombreClase);
			
			if(superCl != null && superCl != Object.class) {
				
				System.out.print(" extends " + superCl.getName());
				
			}
			
			System.out.println();
			
			System.out.println();
			
			imprimirConstructores(cl);
			
			System.out.println();
			
			imprimirMetodos(cl);
			
			System.out.println();
			
			imprimirCampos(cl);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			System.exit(0);
			
		}
		
	}
	
	public static void imprimirConstructores(Class cl) {
		
		Constructor[] constructores = cl.getDeclaredConstructors();
		
		for(Constructor c: constructores) {
			
			String nombre = c.getName();
			
			System.out.print(Modifier.toString(c.getModifiers()));
			
			System.out.print(" " + nombre + "(");
			
			Class[] parametros = c.getParameterTypes();
			
			for(int i=0; i<parametros.length; i++) {
				
				if(i>0) {
					
					System.out.print(", ");
					
				}
				
				System.out.print(parametros[i].getName());
				
			}
			
			System.out.println(");");
			
		}
		
	}
	
	public static void imprimirMetodos(Class cl) {
		
		Method[] metodos = cl.getDeclaredMethods();
		
		for(Method m: metodos) {
			
			Class tipo = m.getReturnType();
			
			String nombre = m.getName();
			
			System.out.print(Modifier.toString(m.getModifiers()));
			
			System.out.print(" " + tipo.getName() + " " + nombre + "(");
			
			Class[] parametros = m.getParameterTypes();
			
			for(int i=0; i<parametros.length; i++) {
				
				if(i>0) {
					
					System.out.print(", ");
					
				}
				
				System.out.print(parametros[i].getName());
				
			}
			
			System.out.println(");");
			
		}
		
	}
	
	public static void imprimirCampos(Class cl) {
		
		Field[] campos = cl.getDeclaredFields();
		
		for(Field f: campos) {
			
			Class tipo = f.getType();
			
			String nombre = f.getName();
			
			System.out.print(Modifier.toString(f.getModifiers()));
			
			System.out.println(" " + tipo.getName() + " " + nombre + ";");
			
		}
		
	}

}

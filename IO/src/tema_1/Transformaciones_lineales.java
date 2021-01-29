package tema_1;

import java.util.*;

public class Transformaciones_lineales {

	public static void main(String[] args) {
		
		FuncionObjetivo funcion_objetivo = new FuncionObjetivo();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("¡BIENVENIDO!\n\nFUNCIÓN OBJETIVO\n");
		
		System.out.print("Ingrese tipo (MAX/MIN): ");
		
		funcion_objetivo.setTipo(entrada.next().toUpperCase());
		
		System.out.print("\nIngrese cantidad de variables: ");
		
		int no_columnas = entrada.nextInt() + 2;
		
		System.out.println();
		
		funcion_objetivo.defineValores(no_columnas);
		
		int contador = 1;
		
		for(int i=0; i<no_columnas; i++) {
			
			if(i==(no_columnas-2)) {
				
				funcion_objetivo.setValores(i, 0);
				
			}
			
			else if(i==(no_columnas-1)) {
				
				funcion_objetivo.setValores(i, 0);
				
			}
			
			else {
				
				System.out.print("Ingrese valor de X" + contador + ": ");
				
				funcion_objetivo.setValores(i, entrada.nextInt());
				
			}
			
			contador++;
			
		}
		
		System.out.print("\nRESTRICCIONES\n\nIngrese cantidad de restricciones de NO valor absoluto: ");
		
		int no_restricciones = entrada.nextInt();
		
		System.out.println();
		
		Restriccion[] restricciones = new Restriccion[no_restricciones];
		
		String tipo;
		
		int contador_2 = 0;
		
		for(int i=0; i<no_restricciones; i++) {
			
			contador = 1;
			
			restricciones[i] = new Restriccion();
			
			restricciones[i].defineValores(no_columnas);
			
			contador_2++;
			
			System.out.println("RESTRICCIÓN " + contador_2 + "\n");
			
			for(int j=0; j<no_columnas; j++) {
				
				if(j==(no_columnas-2)) {
					
					System.out.print("\nIngrese tipo (>=/<=/=): ");
					
					tipo = entrada.next();
					
					switch(tipo) {
					
					case ">=":
						
						restricciones[i].setValores(j, 1);
						
						break;
						
					case "<=":
						
						restricciones[i].setValores(j, -1);
						
						break;
						
					case "=":
						
						restricciones[i].setValores(j, 0);
						
						break;
						
					}
					
				}
				
				else if(j==(no_columnas-1)) {
					
					System.out.print("\nIngrese resultado: ");
					
					restricciones[i].setValores(j, entrada.nextInt());
					
					System.out.println();
					
				}
				
				else {
					
					System.out.print("Ingrese valor de X" + contador + ": ");
					
					restricciones[i].setValores(j, entrada.nextInt());
					
					contador++;
					
				}
				
			}
			
		}
		
		int no_restricciones_ab = 0;
		
		Restriccion[] restricciones_ab;
			
		System.out.print("Ingrese cantidad de restricciones de valor absoluto: ");
			
		no_restricciones_ab = entrada.nextInt();
			
		restricciones_ab = new Restriccion[no_restricciones_ab];
			
		contador_2 = 0;
			
		for(int i=0; i<no_restricciones_ab; i++) {
				
			contador = 1;
				
			restricciones_ab[i] = new Restriccion();
				
			restricciones_ab[i].defineValores(no_columnas);
				
			contador_2++;
				
			System.out.println("\nRESTRICCIÓN DE VALOR ABSOLUTO " + contador_2 + "\n");
				
			for(int j=0; j<no_columnas; j++) {
					
				if(j==(no_columnas-2)) {
						
					restricciones_ab[i].setValores(j, -1);
						
				}
					
				else if(j==(no_columnas-1)) {
						
					System.out.print("\nIngrese resultado: ");
						
					restricciones_ab[i].setValores(j, entrada.nextInt());
						
				}
					
				else {
						
					System.out.print("Ingrese valor de X" + contador + ": ");
						
					restricciones_ab[i].setValores(j, entrada.nextInt());
						
				}
					
				contador++;
			}
				
		}
		
		if((funcion_objetivo.getTipo()).equals("MAX")) {
			
			int valor_temp;
			
			contador = 0;
			
			for(int i=0; i<no_restricciones; i++) {
					
				valor_temp = restricciones[i].getValor(no_columnas-2);
				
				if(valor_temp==0) {
					
					contador += 2;
					
				}
					
				else if(valor_temp==1) {
						
					contador++;
						
				}
					
				else {
						
					contador++;
				}
				
			}
			
			if(no_restricciones_ab>0) {
				
				contador += (no_restricciones_ab * 2);	
				
			}
			
			Restriccion[] restricciones_can = new Restriccion[contador];
			
			int i = 0;
				
			for(int j=0; j<no_restricciones; j++) {
					
				restricciones_can[i] = new Restriccion();
					
				restricciones_can[i].defineValores(no_columnas);
					
				valor_temp = restricciones[j].getValor(no_columnas-2);
				
				if(valor_temp==0) {
					
					restricciones_can[i+1] = new Restriccion();
					
					restricciones_can[i+1].defineValores(no_columnas);
					
				}
					
				for(int k=0; k<no_columnas; k++) {
						
					if(valor_temp==1) {
							
						restricciones_can[i].setValores(k, (restricciones[j].getValor(k) * (-1)));
							
					}
						
					else if(valor_temp==(-1)) {
							
						restricciones_can[i].setValores(k, (restricciones[j].getValor(k)));
							
					}
						
					else {
							
						if(k==(no_columnas-2)) {
								
							restricciones_can[i].setValores(k, -1);
								
							restricciones_can[i+1].setValores(k, -1);
								
						}
							
						else {
								
							restricciones_can[i].setValores(k, (restricciones[j].getValor(k)));
								
							restricciones_can[i+1].setValores(k, (restricciones[j].getValor(k) * (-1)));
								
						}
						
					}
						
				}
					
				i++;
			
				if(valor_temp==0) {
				
					i++;
				
				}
			
			}
			
			if(no_restricciones_ab>0) {
			
				for(int j=0; j<no_restricciones_ab; j++) {
				
					restricciones_can[i] = new Restriccion();
				
					restricciones_can[i].defineValores(no_columnas);
				
					restricciones_can[i+1] = new Restriccion();
				
					restricciones_can[i+1].defineValores(no_columnas);
				
					for(int k=0; k<no_columnas; k++) {
					
						if(k==(no_columnas-2)) {
						
							restricciones_can[i].setValores(k, -1);
						
							restricciones_can[i+1].setValores(k, -1);
						
						}
					
						else if(k==(no_columnas-1)) {
						
							restricciones_can[i].setValores(k, (restricciones_ab[j].getValor(k)));
						
							restricciones_can[i+1].setValores(k, (restricciones_ab[j].getValor(k)));
						
						}
					
						else {
						
							restricciones_can[i].setValores(k, (restricciones_ab[j].getValor(k)));
						
							restricciones_can[i+1].setValores(k, (restricciones_ab[j].getValor(k) * (-1)));
						
						}
					
					}
					
					i += 2;
				
				}
			
			}
			
			System.out.println("\nTRANSFORMACIÓN A FORMATO CANÓNICO\n");
			
			String[] restricciones_can_f = new String[contador];
			
			String[] restricciones_est_f = new String[contador];
			
			for(int j=0; j<contador; j++) {
				
				restricciones_can_f[j] = "";
				
				restricciones_est_f[j] = "";
				
			}
			
			int contador_3 = 1;
			
			i = 0;
			
			for(int j=0; j<contador; j++) {
				
				contador_2 = 1;
				
				for(int k=0; k<no_columnas; k++) {
					
					valor_temp = restricciones_can[i].getValor(k);
					
					if(k==0) {
						
						if(valor_temp==1) {
							
							restricciones_can_f[j] += ("X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("X" + contador_2 + " ");
							
						}
						
						else if(valor_temp==(-1)) {
							
							restricciones_can_f[j] += ("- X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("- X" + contador_2 + " ");
							
						}
						
						else if(valor_temp>0) {
							
							restricciones_can_f[j] += (valor_temp + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += (valor_temp + "X" + contador_2 + " ");
							
						}
						
						else if(valor_temp<0) {
							
							restricciones_can_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
						}
						
						else { }
						
					}
					
					else if(k==(no_columnas-1)) {
							
						if(valor_temp>0) {
								
							restricciones_can_f[j] += valor_temp;
								
							restricciones_est_f[j] += valor_temp;
								
						}
							
						else if(valor_temp<0) {
								
							restricciones_can_f[j] += ("- " + (valor_temp * -1));
								
							restricciones_est_f[j] += ("- " + (valor_temp * -1));
								
						}
							
						else { 
							
							restricciones_can_f[j] += "0";
							
							restricciones_est_f[j] += "0";
							
						}
						
					}
					
					else if(k==(no_columnas-2)) {
						
						restricciones_can_f[j] += "<= ";
						
						restricciones_est_f[j] += ("+ S" + contador_3 + " = ");
						
						contador_3++;
						
					}
					
					else {
						
						if(valor_temp==1) {
							
							restricciones_can_f[j] += ("+ X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("+ X" + contador_2 + " ");
							
						}
						
						else if(valor_temp==(-1)) {
							
							restricciones_can_f[j] += ("- X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("- X" + contador_2 + " ");
							
						}
						
						else if(valor_temp>0) {
							
							restricciones_can_f[j] += ("+ " + valor_temp + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("+ " + valor_temp + "X" + contador_2 + " ");
							
						}
						
						else if(valor_temp<0) {
							
							restricciones_can_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
						}
						
						else { }
						
					}
					
					contador_2++;
					
				}
				
				i++;
				
			}
			
			String fo = "FO " + funcion_objetivo.getTipo() + " X0 = ";
			
			contador_3 = 1;
			
			for(int j=0; j<(no_columnas-2); j++) {
				
				if(j==no_columnas-3) {
					
					if(funcion_objetivo.getValor(j) == 1) {
						
						fo += ("X" + contador_3);
						
					}
					
					else {
					
						fo += (funcion_objetivo.getValor(j) + "X" + contador_3);
						
					}
					
				}
				
				else{
					
					if(funcion_objetivo.getValor(j) == 1) {
						
						fo += ("X" + contador_3 + " + ");
						
					}
					
					else {
				
						fo += (funcion_objetivo.getValor(j) + "X" + contador_3 + " + ");
						
					}
					
				}
				
				contador_3++;
				
			}
			
			System.out.println(fo + "\n");
			
			System.out.println("SA\n");
			
			for(int j=0; j<contador; j++) {
				
				System.out.println(" " + restricciones_can_f[j]);
				
			}
			
			System.out.println("\nTRANSFORMACIÓN A FORMATO ESTANDAR\n");
			
			System.out.println(fo + "\n");
			
			System.out.println("SA\n");
			
			for(int j=0; j<contador; j++) {
				
				System.out.println(" " + restricciones_est_f[j]);
				
			}
			
		}
		
		if((funcion_objetivo.getTipo()).equals("MIN")) {
			
			int valor_temp;
			
			contador = 0;
			
			for(int i=0; i<no_restricciones; i++) {
					
				valor_temp = restricciones[i].getValor(no_columnas-2);
				
				if(valor_temp==0) {
					
					contador += 2;
					
				}
					
				else if(valor_temp==1) {
						
					contador++;
						
				}
					
				else {
						
					contador++;
				}
				
			}
			
			if(no_restricciones_ab>0) {
				
				contador += (no_restricciones_ab * 2);	
				
			}
			
			Restriccion[] restricciones_can = new Restriccion[contador];
			
			int i = 0;
				
			for(int j=0; j<no_restricciones; j++) {
					
				restricciones_can[i] = new Restriccion();
					
				restricciones_can[i].defineValores(no_columnas);
					
				valor_temp = restricciones[j].getValor(no_columnas-2);
				
				if(valor_temp==0) {
					
					restricciones_can[i+1] = new Restriccion();
					
					restricciones_can[i+1].defineValores(no_columnas);
					
				}
					
				for(int k=0; k<no_columnas; k++) {
						
					if(valor_temp==1) {
							
						restricciones_can[i].setValores(k, (restricciones[j].getValor(k)));
							
					}
						
					else if(valor_temp==(-1)) {
							
						restricciones_can[i].setValores(k, (restricciones[j].getValor(k) * (-1)));
							
					}
						
					else {
							
						if(k==(no_columnas-2)) {
								
							restricciones_can[i].setValores(k, 1);
								
							restricciones_can[i+1].setValores(k, 1);
								
						}
							
						else {
								
							restricciones_can[i].setValores(k, (restricciones[j].getValor(k)));
								
							restricciones_can[i+1].setValores(k, (restricciones[j].getValor(k) * (-1)));
								
						}
						
					}
						
				}
					
				i++;
			
				if(valor_temp==0) {
				
					i++;
				
				}
			
			}
			
			if(no_restricciones_ab>0) {
			
				for(int j=0; j<no_restricciones_ab; j++) {
				
					restricciones_can[i] = new Restriccion();
				
					restricciones_can[i].defineValores(no_columnas);
				
					restricciones_can[i+1] = new Restriccion();
				
					restricciones_can[i+1].defineValores(no_columnas);
				
					for(int k=0; k<no_columnas; k++) {
					
						if(k==(no_columnas-2)) {
						
							restricciones_can[i].setValores(k, 1);
						
							restricciones_can[i+1].setValores(k, 1);
						
						}
					
						else if(k==(no_columnas-1)) {
						
							restricciones_can[i].setValores(k, (restricciones_ab[j].getValor(k) * (-1)));
						
							restricciones_can[i+1].setValores(k, (restricciones_ab[j].getValor(k) * (-1)));
						
						}
					
						else {
						
							restricciones_can[i].setValores(k, (restricciones_ab[j].getValor(k)));
						
							restricciones_can[i+1].setValores(k, (restricciones_ab[j].getValor(k) * (-1)));
						
						}
					
					}
					
					i += 2;
				
				}
			
			}
			
			System.out.println("\nTRANSFORMACIÓN A FORMATO CANÓNICO\n");
			
			String[] restricciones_can_f = new String[contador];
			
			String[] restricciones_est_f = new String[contador];
			
			for(int j=0; j<contador; j++) {
				
				restricciones_can_f[j] = "";
				
				restricciones_est_f[j] = "";
				
			}
			
			int contador_3 = 1;
			
			i = 0;
			
			for(int j=0; j<contador; j++) {
				
				contador_2 = 1;
				
				for(int k=0; k<no_columnas; k++) {
					
					valor_temp = restricciones_can[i].getValor(k);
					
					if(k==0) {
						
						if(valor_temp==1) {
							
							restricciones_can_f[j] += ("X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("X" + contador_2 + " ");
							
						}
						
						else if(valor_temp==(-1)) {
							
							restricciones_can_f[j] += ("- X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("- X" + contador_2 + " ");
							
						}
						
						else if(valor_temp>0) {
							
							restricciones_can_f[j] += (valor_temp + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += (valor_temp + "X" + contador_2 + " ");
							
						}
						
						else if(valor_temp<0) {
							
							restricciones_can_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
						}
						
						else { }
						
					}
					
					else if(k==(no_columnas-1)) {
							
						if(valor_temp>0) {
								
							restricciones_can_f[j] += valor_temp;
								
							restricciones_est_f[j] += valor_temp;
								
						}
							
						else if(valor_temp<0) {
								
							restricciones_can_f[j] += ("- " + (valor_temp * -1));
								
							restricciones_est_f[j] += ("- " + (valor_temp * -1));
								
						}
							
						else { 
							
							restricciones_can_f[j] += "0";
							
							restricciones_est_f[j] += "0";
							
						}
						
					}
					
					else if(k==(no_columnas-2)) {
						
						restricciones_can_f[j] += ">= ";
						
						restricciones_est_f[j] += ("- S" + contador_3 + " = ");
						
						contador_3++;
						
					}
					
					else {
						
						if(valor_temp==1) {
							
							restricciones_can_f[j] += ("+ X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("+ X" + contador_2 + " ");
							
						}
						
						else if(valor_temp==(-1)) {
							
							restricciones_can_f[j] += ("- X" + contador_2 + " "); 
							
							restricciones_est_f[j] += ("- X" + contador_2 + " ");
							
						}
						
						else if(valor_temp>0) {
							
							restricciones_can_f[j] += ("+ " + valor_temp + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("+ " + valor_temp + "X" + contador_2 + " ");
							
						}
						
						else if(valor_temp<0) {
							
							restricciones_can_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
							restricciones_est_f[j] += ("- " + (valor_temp * -1) + "X" + contador_2 + " ");
							
						}
						
						else { }
						
					}
					
					contador_2++;
					
				}
				
				i++;
				
			}
			
			String fo = "FO " + funcion_objetivo.getTipo() + " X0 = ";
			
			contador_3 = 1;
			
			for(int j=0; j<(no_columnas-2); j++) {
				
				if(j==no_columnas-3) {
					
					if(funcion_objetivo.getValor(j) == 1) {
						
						fo += ("X" + contador_3);
						
					}
					
					else {
					
						fo += (funcion_objetivo.getValor(j) + "X" + contador_3);
						
					}
					
				}
				
				else{
					
					if(funcion_objetivo.getValor(j) == 1) {
						
						fo += ("X" + contador_3 + " + ");
						
					}
					
					else {
				
						fo += (funcion_objetivo.getValor(j) + "X" + contador_3 + " + ");
						
					}
					
				}
				
				contador_3++;
				
			}
			
			System.out.println(fo + "\n");
			
			System.out.println("SA\n");
			
			for(int j=0; j<contador; j++) {
				
				System.out.println(" " + restricciones_can_f[j]);
				
			}
			
			System.out.println("\nTRANSFORMACIÓN A FORMATO ESTANDAR (A PARTIR DE CANÓNICO)\n");
			
			System.out.println(fo + "\n");
			
			System.out.println("SA\n");
			
			for(int j=0; j<contador; j++) {
				
				System.out.println(" " + restricciones_est_f[j]);
				
			}
			
		}
			
		System.out.println("\nHASTA LUEGO");
			
	}
		
}


class Modelo {
	
	public void defineValores(int no_columnas) {
		
		valores = new int[no_columnas];
		
	}
	
	public void setValores(int i, int valor) {
		
		valores[i] = valor;
		
	}
	
	public int getValor(int i) {
		
		return valores[i];
		
	}
	
	private int[] valores;
	
}

class FuncionObjetivo extends Modelo {
	
	public void setTipo(String tipo) {
		
		this.tipo = tipo;
		
	}
	
	public String getTipo() {
		
		return tipo;
		
	}
	
	private String tipo;
	
}

class Restriccion extends Modelo {
	
}
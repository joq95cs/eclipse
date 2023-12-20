package programa_final_extendido;

import java.util.*;

public class Programa_final_extendido_IO {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("BIENVENIDO");

		System.out.print("\n\nINVESTIGACIÓN DE OPERACIONES\n");
		
		String opcion_final = "";
		
		String opcion_programa = "";
		
		do {
			
			System.out.print("\nA) Tema 1: Transformaciones lineales\nB) Tema 2: Ruta más corta\nC) Tema 3: Máximos y mínimos\nD) Tema 4: Inventarios\nE) Tema 5: Líneas de espera\nF) Salir");
			
			System.out.print("\n\nElija una opción: ");
			
			opcion_programa = entrada.next().toUpperCase();
			
			if(opcion_programa.equals("A")) {
				
				do {
					
					FuncionObjetivo funcion_objetivo = new FuncionObjetivo();
					
					System.out.print("\nTRANSFORMACIONES LINEALES");
					
					System.out.println("\n\nFUNCIÓN OBJETIVO\n");
					
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
						
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nD) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = entrada.next().toUpperCase();
					
				} while(opcion_final.equals("A"));
					
			}
			
			if(opcion_programa.equals("B")) {
				
				do {
					
					System.out.print("\nRUTA MÁS CORTA");
					
					Nodo[] nodos = new Nodo[10];		
					
					nodos[0] = new Nodo("A", 0);
					
					nodos[0].definePosicionesNodosProcedentes(2);
					
					nodos[0].defineDistancias(2);
					
					nodos[0].setPosicionNodoProcedente(0, 1);
					
					nodos[0].setPosicionNodoProcedente(1, 3);
					
					nodos[1] = new Nodo("2", 1);
					
					nodos[1].definePosicionesNodosProcedentes(2);
					
					nodos[1].defineDistancias(2);
					
					nodos[1].setPosicionNodoProcedente(0, 2);
					
					nodos[1].setPosicionNodoProcedente(1, 3);
					
					nodos[2] = new Nodo("3", 2);
					
					nodos[2].definePosicionesNodosProcedentes(2);
					
					nodos[2].defineDistancias(2);
					
					nodos[2].setPosicionNodoProcedente(0, 4);
					
					nodos[2].setPosicionNodoProcedente(1, 5);
					
					nodos[3] = new Nodo("4", 3);
					
					nodos[3].definePosicionesNodosProcedentes(1);
					
					nodos[3].defineDistancias(1);
					
					nodos[3].setPosicionNodoProcedente(0, 5);
					
					nodos[4] = new Nodo("5", 4);
					
					nodos[4].definePosicionesNodosProcedentes(2);
					
					nodos[4].defineDistancias(2);
					
					nodos[4].setPosicionNodoProcedente(0, 6);
					
					nodos[4].setPosicionNodoProcedente(1, 7);
					
					nodos[5] = new Nodo("6", 5);
					
					nodos[5].definePosicionesNodosProcedentes(2);
					
					nodos[5].defineDistancias(2);
					
					nodos[5].setPosicionNodoProcedente(0, 6);
					
					nodos[5].setPosicionNodoProcedente(1, 7);
					
					nodos[6] = new Nodo("7", 6);
					
					nodos[6].definePosicionesNodosProcedentes(2);
					
					nodos[6].defineDistancias(2);
					
					nodos[6].setPosicionNodoProcedente(0, 7);
					
					nodos[6].setPosicionNodoProcedente(1, 8);
					
					nodos[7] = new Nodo("8", 7);
					
					nodos[7].definePosicionesNodosProcedentes(2);
					
					nodos[7].defineDistancias(2);
					
					nodos[7].setPosicionNodoProcedente(0, 8);
					
					nodos[7].setPosicionNodoProcedente(1, 9);
					
					nodos[8] = new Nodo("9", 8);
					
					nodos[8].definePosicionesNodosProcedentes(1);
					
					nodos[8].defineDistancias(1);
					
					nodos[8].setPosicionNodoProcedente(0, 9);
					
					nodos[9] = new Nodo("B", 9);
					
					nodos[9].definePosicionesNodosProcedentes(1);
					
					nodos[9].defineDistancias(1);
					
					nodos[9].setPosicionNodoProcedente(0, 9);
					
					System.out.println("\n\nEl grafo a utilizar en este programa es el no. 4 de la hoja de ejercicios de moodle...");
					
					System.out.print("\nIngrese distancia de " + nodos[0].getID() + " a " + nodos[1].getID() + ": ");
					
					nodos[0].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[0].getID() + " a " + nodos[3].getID() + ": ");
					
					nodos[0].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[1].getID() + " a " + nodos[2].getID() + ": ");
					
					nodos[1].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[1].getID() + " a " + nodos[3].getID() + ": ");
					
					nodos[1].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[2].getID() + " a " + nodos[4].getID() + ": ");
					
					nodos[2].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[2].getID() + " a " + nodos[5].getID() + ": ");
					
					nodos[2].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[3].getID() + " a " + nodos[5].getID() + ": ");
					
					nodos[3].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[4].getID() + " a " + nodos[6].getID() + ": ");
					
					nodos[4].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[4].getID() + " a " + nodos[7].getID() + ": ");
					
					nodos[4].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[5].getID() + " a " + nodos[6].getID() + ": ");
					
					nodos[5].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[5].getID() + " a " + nodos[7].getID() + ": ");
					
					nodos[5].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[6].getID() + " a " + nodos[7].getID() + ": ");
					
					nodos[6].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[6].getID() + " a " + nodos[8].getID() + ": ");
					
					nodos[6].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[7].getID() + " a " + nodos[8].getID() + ": ");
					
					nodos[7].setDistancias(0, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[7].getID() + " a " + nodos[9].getID() + ": ");
					
					nodos[7].setDistancias(1, entrada.nextDouble());
					
					System.out.print("Ingrese distancia de " + nodos[8].getID() + " a " + nodos[9].getID() + ": ");
					
					nodos[8].setDistancias(0, entrada.nextDouble());
					
					nodos[0].setPosicionNodoProcedencia(0);
					
					nodos[0].setPermanente();
					
					for(int i=0; i<nodos[0].getLengthPosicionesNodosProcedentes(); i++) {
						
						nodos[nodos[0].getPosicionNodoProcedente(i)].setDistanciaAcumulada(nodos[0].getDistanciaAcumulada() + nodos[0].getDistancia(i));
						
						nodos[nodos[0].getPosicionNodoProcedente(i)].setPosicionNodoProcedencia(0);
						
					}
					
					Nodo[] nodos_aux;
					
					int aux_sig = 0;
					
					while(nodos[9].getPermanente() == false) {
						
						nodos_aux = nodos.clone();
						
						Arrays.sort(nodos_aux);
						
						for(int i=0; i<nodos_aux.length; i++) {
							
							if(nodos_aux[i].getDistanciaAcumulada() > 0) {
								
								if(nodos_aux[i].getPermanente() == false) {
									
									aux_sig = nodos_aux[i].getPosicion();
									
									i = nodos_aux.length;
									
								}
								
							}
							
						}
						
						nodos[aux_sig].setPermanente();
						
						if(aux_sig == 9) {
							
						}
						
						else {
							
							for(int j=0; j<nodos[aux_sig].getLengthPosicionesNodosProcedentes(); j++) {
								
								if(nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].getPermanente() == true) {
									
								}
								
								else {
									
									if(nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].getDistanciaAcumulada() == 0) {
										
										nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].setDistanciaAcumulada(nodos[aux_sig].getDistanciaAcumulada() + nodos[aux_sig].getDistancia(j));
										
										nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].setPosicionNodoProcedencia(aux_sig);
										
									}
									
									else {
										
										if(nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].getDistanciaAcumulada() > (nodos[aux_sig].getDistanciaAcumulada() + nodos[aux_sig].getDistancia(j))) {
											
											nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].setDistanciaAcumulada(nodos[aux_sig].getDistanciaAcumulada() + nodos[aux_sig].getDistancia(j));
											
											nodos[nodos[aux_sig].getPosicionNodoProcedente(j)].setPosicionNodoProcedencia(aux_sig);
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
					int x = 9;
					
					String ruta_aux = "B";
					
					while(x > 0) {
						
						ruta_aux += " >- " + nodos[nodos[x].getPosicionNodoProcedencia()].getID();
						
						x = nodos[nodos[x].getPosicionNodoProcedencia()].getPosicion();
						
					}
					
					String ruta = "";
					
					for(int i=ruta_aux.length()-1; i>=0; i--) {
						
						ruta += ruta_aux.charAt(i);
						
					}
					
					System.out.println("\nRESULTADO\n");
					
					System.out.println("Ruta más corta: " + ruta + "\nCosto: " + nodos[9].getDistanciaAcumulada());
					
					System.out.print("\nA) Repetir programa\nB) Regresar al menú\nD) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = entrada.next().toUpperCase();
					
				} while(opcion_final.equals("A"));
				
			}
			
			if(opcion_programa.equals("C")) {
				
				do {
					
					System.out.print("\nMÁXIMOS Y MÍNIMOS");
			        
			        System.out.println("\n\nFunción Objetivo: Ax^2 + Bx + C(x + D)^2 + E\n");
			        
			        System.out.print("Ingrese tipo (MAX/MIN): ");
			        
			        String tipo = entrada.next().toUpperCase();
			        
			        Ecuacion funcion_objetivo = new Ecuacion();
			        
			        System.out.print("\nIngrese valor de A: ");
			        
			        funcion_objetivo.setA(entrada.nextDouble());
			        
			        System.out.print("Ingrese valor de B: ");
			        
			        funcion_objetivo.setB(entrada.nextDouble());
			        
			        System.out.print("Ingrese valor de C: ");
			        
			        funcion_objetivo.setC(entrada.nextDouble());
			        
			        System.out.print("Ingrese valor de D: ");
			        
			        funcion_objetivo.setD(entrada.nextDouble());
			        
			        System.out.print("Ingrese valor de E: ");
			        
			        funcion_objetivo.setE(entrada.nextDouble());
			        
			        funcion_objetivo.setCoeficiente(funcion_objetivo.getA()+funcion_objetivo.getC());
			        
			        funcion_objetivo.setCoeficiente(funcion_objetivo.getB()+2*funcion_objetivo.getC()*funcion_objetivo.getD());
			        
			        funcion_objetivo.setCoeficiente(funcion_objetivo.getC()*Math.pow(funcion_objetivo.getD(), 2)+funcion_objetivo.getE());
			        
			        Ecuacion derivada_1 = new Ecuacion();
			        
			        derivada_1.setA(funcion_objetivo.getA());
			        
			        derivada_1.setB(funcion_objetivo.getB());
			        
			        derivada_1.setC(funcion_objetivo.getC());
			        
			        derivada_1.setD(funcion_objetivo.getD());
			        
			        derivada_1.setE(0);
			        
			        derivada_1.setCoeficiente(2*derivada_1.getA()+2*derivada_1.getC());
			        
			        derivada_1.setCoeficiente(derivada_1.getB()+2*derivada_1.getC()*derivada_1.getD());
			        
			        Ecuacion derivada_2 = new Ecuacion();
			        
			        derivada_2.setA(funcion_objetivo.getA());
			        
			        derivada_2.setC(funcion_objetivo.getC());
			        
			        derivada_2.setCoeficiente(2*derivada_2.getA()+2*derivada_2.getC());
			        
			        System.out.print("\nA) a < x < b\nB) a =< x <= b\nC) a < x <= b\nD) a =< x < b\n\nSeleccione tipo de límites: ");
			        
			        String tipo_limites = entrada.next().toUpperCase();
			        
			        System.out.print("\nIngrese valor de límite a: ");
			        
			        double limite_a = entrada.nextDouble();
			        
			        System.out.print("Ingrese valor de límite b: ");
			        
			        double limite_b = entrada.nextDouble();
			        
			        System.out.println("\nRESULTADO\n");
			        
			        if(tipo.equals("MAX")) {
			                
			            Casos.caso1(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), derivada_2.getCoeficientes());
			            
			            if(Casos.getTipoX0().equals("MAXIMO") && Casos.getTieneSolucion()) {
			                    
			                System.out.println("x: " + Casos.getX0() + "\nCaso: 1" + "\nCondición: " + Casos.getCondicion());
			                    
			            }
			            
			            else {
			                
			                Casos.caso2(tipo_limites, limite_a, limite_b, funcion_objetivo.getCoeficientes(), tipo);
			                
			                if(Casos.getTipoX0().equals("MAXIMO")) {
			                    
			                    System.out.println("x: " + Casos.getX0() + "\nCaso: 2" + "\nCondición: " + Casos.getCondicion()); 
			                    
			                }
			                
			                else {
			                    
			                    Casos.caso3(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), tipo);
			                    
			                    if(Casos.getTipoX0().equals("MAXIMO")) {
			                        
			                        System.out.println("x: " + Casos.getX0() + "\nCaso: 3" + "\nCondición: " + Casos.getCondicion());
			                        
			                    }
			                    
			                    else {
			                        
			                        System.out.println("El problema no tiene solución...");
			                        
			                    }
			                    
			                }
			                
			            }
			            
			        }
			        
			        if(tipo.equals("MIN")) {
			            
			            Casos.caso1(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), derivada_2.getCoeficientes());
			            
			            if(Casos.getTipoX0().equals("MINIMO") && Casos.getTieneSolucion()) {
			                
			                System.out.println("x: " + Casos.getX0() + "\nCaso: 1" + "\nCondición: " + Casos.getCondicion());
			                
			            }
			            
			            else {
			                
			                Casos.caso2(tipo_limites, limite_a, limite_b, funcion_objetivo.getCoeficientes(), tipo);
			                
			                if(Casos.getTipoX0().equals("MINIMO")) {
			                    
			                    System.out.println("x: " + Casos.getX0() + "\nCaso: 2" + "\nCondición: " + Casos.getCondicion()); 
			                    
			                }
			                
			                else {
			                    
			                    Casos.caso3(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), tipo);
			                            
			                    if(Casos.getTipoX0().equals("MINIMO")) {
			                        
			                        System.out.println("x: " + Casos.getX0() + "\nCaso: 3" + "\nCondición: " + Casos.getCondicion());
			                        
			                    }
			                    
			                    else {
			                        
			                        System.out.println("El problema no tiene solución...");
			                        
			                    }
			                    
			                }
			                
			            }
			            
			        }
			        
			        System.out.print("\nA) Repetir programa\nB) Regresar al menú\nD) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = entrada.next().toUpperCase();
					
				} while(opcion_final.equals("A"));
				
			}
			
			if(opcion_programa.equals("D")) {
				
				do {
					
					System.out.print("\nINVENTARIOS");
					
					System.out.print("\n\nA) Modelo básico de lote económico de pedido sin faltantes (EOQ)"
					+ "\nB) Modelo con reabastecimiento instantáneo en un periodo de tiempo y sin faltantes (EOQ con R)");
					
					System.out.print("\n\nElija un método: ");
					
					String opcion = entrada.next().toUpperCase();
					
					if(opcion.equals("A")) {
						
						ModeloEOQ eoq = new ModeloEOQ();
						
						System.out.print("\nA) Diaria\nB) Semanal\nC) Mensual\nD) Anual");
						
						System.out.print("\n\nElija un tipo de demanda: ");
						
						String opcion_demanda = entrada.next().toUpperCase();
						
						if(opcion_demanda.equals("A")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoq.setD(entrada.nextDouble() * 365);
							
						}
						
						if(opcion_demanda.equals("B")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoq.setD(entrada.nextDouble() * 52);
							
						}
						
						if(opcion_demanda.equals("C")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoq.setD(entrada.nextDouble() * 12);
							
						}
						
						if(opcion_demanda.equals("D")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoq.setD(entrada.nextDouble());
								
						}
						
						System.out.print("Ingrese costo unitario (p): ");
						
						eoq.setP(entrada.nextDouble());
						
						System.out.print("Ingrese costo del pedido (k): ");
						
						eoq.setK(entrada.nextDouble());
						
						System.out.print("\nA) Directo\nB) Porcentaje sobre el costo unitario");
						
						System.out.print("\n\nElija una opción para costo de retención: ");
						
						String opcion_retencion = entrada.next().toUpperCase();
						
						if(opcion_retencion.equals("A")) {
							
							System.out.print("\nIngrese costo de retención (h): ");
							
							eoq.setH(entrada.nextDouble());
							
						}
						
						if(opcion_retencion.equals("B")) {
							
							System.out.print("\nIngrese porcentaje sobre el costo unitario (h): ");
							
							eoq.setH(entrada.nextDouble()/100 * eoq.getP());
							
						}
						
						System.out.print("\nRESULTADOS (ANUALIZADOS)\n\n");
						
						eoq.generarQAsterisco();
						
						eoq.generarPeriodicidad();
						
						eoq.generarCostoTotal();
						
						System.out.print("Tamaño del pedido: " + (int)eoq.getQAsterisco() + " unidad(es)");
						
						System.out.print("\nPeriodicidad: " + (int)eoq.getPeriodicidad() + " pedido(s) al año, 1 pedido cada " + (int)(12/eoq.getPeriodicidad()) + " mes(es)");
						
						System.out.print("\nCosto total: $ " + eoq.getCostoTotal());
						
					}

					if(opcion.equals("B")) {
						
						ModeloEOQR eoqr = new ModeloEOQR();
						
						System.out.print("\nA) Diaria\nB) Semanal\nC) Mensual\nD) Anual");
						
						System.out.print("\n\nElija un tipo de demanda: ");
						
						String opcion_demanda = entrada.next().toUpperCase();
						
						if(opcion_demanda.equals("A")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoqr.setD(entrada.nextDouble() * 365);
							
						}
						
						if(opcion_demanda.equals("B")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoqr.setD(entrada.nextDouble() * 52);
							
						}
						
						if(opcion_demanda.equals("C")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoqr.setD(entrada.nextDouble() * 12);
							
						}
						
						if(opcion_demanda.equals("D")) {
							
							System.out.print("\nIngrese demanda (D): ");
							
							eoqr.setD(entrada.nextDouble());
								
						}
						
						System.out.print("Ingrese costo unitario (p): ");
						
						eoqr.setP(entrada.nextDouble());
						
						System.out.print("Ingrese costo del pedido (k): ");
						
						eoqr.setK(entrada.nextDouble());
						
						System.out.print("\nA) Directo\nB) Porcentaje sobre el costo unitario");
						
						System.out.print("\n\nElija una opción para costo de retención: ");
						
						String opcion_retencion = entrada.next().toUpperCase();
						
						if(opcion_retencion.equals("A")) {
							
							System.out.print("\nIngrese costo de retención (h): ");
							
							eoqr.setH(entrada.nextDouble());
							
						}
						
						if(opcion_retencion.equals("B")) {
							
							System.out.print("\nIngrese porcentaje sobre el costo unitario (h): ");
							
							eoqr.setH(entrada.nextDouble()/100 * eoqr.getP());
							
						}
						
						System.out.print("Ingrese tiempo de entrega en días (L): ");
						
						eoqr.setL(entrada.nextDouble());
						
						System.out.print("\nRESULTADOS\n\n");
						
						eoqr.generarQAsterisco();
						
						eoqr.generarPeriodicidad();
						
						eoqr.generarCostoTotal();
						
						eoqr.generarR();
						
						eoqr.generarT();
						
						System.out.print("Tamaño del pedido: " + (int)eoqr.getQAsterisco() + " unidad(es)");
						
						System.out.print("\nPunto de reorden: " + (int)eoqr.getR() + " unidad(es)");
						
						System.out.print("\nTiempo de consumo del inventario: " + (int)eoqr.getT() + " día(s)");
						
						System.out.print("\nPeriodicidad: " + (int)eoqr.getPeriodicidad() + " pedido(s) al año, 1 pedido cada " + (int)(12/eoqr.getPeriodicidad()) + " mes(es)");
						
						System.out.print("\nCosto total: $ " + eoqr.getCostoTotal());
						
					}
					
					System.out.print("\n\nA) Repetir programa\nB) Regresar al menú\nD) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = entrada.next().toUpperCase();
					
				} while(opcion_final.equals("A"));
				
			}
			
			if(opcion_programa.equals("E")) {
				
				do {
					
					System.out.print("\nLíNEAS DE ESPERA");
					
					System.out.print("\n\n1) Método determinístico\n2) Método probabilístico (Poisson)\n\nElija un método: ");
			        
			        int opcionMetodo = entrada.nextInt();
			        
			        if(opcionMetodo == 1) {
			            
			            FormulasLE mDet = new FormulasLE();    
			            
			            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo para capturar datos: ");
			            
			            mDet.setOpcionTiempo(entrada.nextInt());
			            
			            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad para mostrar resultados de tiempos: ");
			            
			            mDet.setOpcionTiempoRes(entrada.nextInt());
			            
			            System.out.print("\nIngrese no. de clientes que se atienden por " + mDet.decirUTiempo() + " (miu): ");
			            
			            mDet.setMiu(entrada.nextInt());
			            
			            System.out.print("Ingrese no. de clientes que llegan al sistema por " + mDet.decirUTiempo() + " (landa): ");
			            
			            mDet.setLanda(entrada.nextInt());
			            
			            System.out.print("\nRESULTADOS\n");
			            
			            if(mDet.tieneSolucion()) {
			                
			                mDet.fijarW();
			                
			                mDet.fijarWq();
			                
			                mDet.fijarWs();
			                
			                mDet.fijarL();
			                
			                mDet.fijarLq();
			                
			                mDet.fijarLs();
			                
			                System.out.print("\nNo. promedio de clientes que se atienden en el sistema por " + mDet.decirUTiempo() + " (L): " + mDet.getL());
			                
			                System.out.print("\nNo. promedio de clientes formados en la fila por " + mDet.decirUTiempo() + " (Lq): " + mDet.getLq());
			                
			                System.out.print("\nNo. promedio de clientes en servicio por " + mDet.decirUTiempo() + " (Ls): " + mDet.getLs());
			                
			                System.out.print("\nTiempo promedio que pasa un cliente en el sistema (w): " + mDet.getW() + " " + mDet.decirUTiempoR() + "(s)");
			                
			                System.out.print("\nTiempo promedio que pasa un cliente formado en la fila (wq): " + mDet.getWq() + " " + mDet.decirUTiempoR() + "(s)");
			                
			                System.out.print("\nTiempo promedio que pasa un cliente en servicio (ws): " + mDet.getWs() + " " + mDet.decirUTiempoR() + "(s)");
			                
			            }
			            
			            else {
			                
			                System.out.print("\nNo existe solución al problema ya que miu no es mayor que landa...");
			                
			            }
			                
			        }
			        
			        if(opcionMetodo == 2) {
			            
			            FormulasLE mPro = new FormulasLE();    
			            
			            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo: ");
			            
			            mPro.setOpcionTiempo(entrada.nextInt());
			            
			            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo para mostrar resultados: ");
			            
			            mPro.setOpcionTiempoRes(entrada.nextInt());
			            
			            System.out.print("\nIngrese no. de clientes que se atienden por " + mPro.decirUTiempo() + " (miu): ");
			            
			            mPro.setMiu(entrada.nextInt());
			            
			            System.out.print("Ingrese no. de clientes que llegan al sistema por " + mPro.decirUTiempo() + " (landa): ");
			            
			            mPro.setLanda(entrada.nextInt());
			            
			            if(mPro.tieneSolucion()) {
			                
			                mPro.fijarP();
			                
			                mPro.fijarP0();
			                
			                mPro.fijarP1();
			                
			                mPro.fijarLs2();
			                
			                mPro.fijarLq2();
			                
			                mPro.fijarWq();
			                
			                mPro.fijarWs2();
			                
			                System.out.print("\n¿Deseas conocer la probabilidad de que haya más de n clientes en la fila? (S/N): ");
			                
			                String opcionPro = entrada.next().toUpperCase();
			                
			                if(opcionPro.equals("S")) {
			                    
			                    System.out.print("Ingrese valor de n: ");
			                    
			                    mPro.setN(entrada.nextInt());
			                    
			                    mPro.definirPn();
			                    
			                    mPro.fijarPn();
			                    
			                    mPro.fijarPm();
			                    
			                    mPro.fijarPm2();
			                    
			                }
			                
			                System.out.print("\nRESULTADOS\n\n");
			                
			                System.out.print("Porcentaje de probabilidad de tiempo que trabaja el servidor (P): " + mPro.getP() + "%");
			                
			                System.out.print("\nPorcentaje de probabilidad de tiempo de que no haya clientes en el sistema (P0): " + mPro.getP0() + "%");
			                
			                System.out.print("\nProbabilidad de que un cliente se encuentre en el sistema en cualquier momento (P1): " + mPro.getP1() + "%");
			                
			                System.out.print("\nNo. promedio de clientes en servicio por " + mPro.decirUTiempo() + " (Ls): " + mPro.getLs2());
			                
			                System.out.print("\nNo. promedio de clientes formados en la fila por " + mPro.decirUTiempo() + " (Lq): " + mPro.getLq2());
			                
			                System.out.print("\nTiempo promedio que pasa el cliente formado (wq): " + mPro.getWq() + " " + mPro.decirUTiempoR() + "(s)");
			                
			                System.out.print("\nTiempo promedio que pasa el cliente en servicio (ws): " + mPro.getWs2() + " " + mPro.decirUTiempoR() + "(s)");
			                
			                if(opcionPro.equals("S")) {
			                    
			                    System.out.print("\nProbabilidad de que haya más de " + mPro.getN() + " clientes en la fila: " + mPro.getPm2() + "%");
			                    
			                }
			                
			            }
			            
			            else {
			                
			                System.out.print("\nRESULTADOS\n\n");
			                
			                System.out.print("No existe solución al problema ya que miu no es mayor que landa...");
			                
			            }
			            
			        }
					
					System.out.print("\n\nA) Repetir programa\nB) Regresar al menú\nD) Salir");
					
					System.out.print("\n\nElija una opción: ");
					
					opcion_final = entrada.next().toUpperCase();
					
				} while(opcion_final.equals("A"));
				
			}
				
		} while(opcion_final.equals("B") && !opcion_programa.equals("F"));
		
		entrada.close();
		
		System.out.print("\nFIN");
		
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

class Nodo implements Comparable {
	
	public Nodo(String id, int posicion) {
		
		this.id = id;
		
		this.posicion = posicion;
		
		permanente = false;
		
		distancia_acumulada = 0;
		
	}
	
	public void definePosicionesNodosProcedentes(int posiciones) {
		
		posiciones_nodos_procedentes = new int[posiciones];
		
	}
	
	public void defineDistancias(int posiciones) {
		
		distancias = new double[posiciones];
		
	}
	
	public void setPosicionNodoProcedente(int posicion, int posicion_nodo_procedente) {
		
		posiciones_nodos_procedentes[posicion] = posicion_nodo_procedente;
		
	}
	
	public void setDistancias(int posicion, double distancia) {
		
		distancias[posicion] = distancia;
		
	}
	
	public void setPermanente() {
		
		permanente = true;
		
	}
	
	public void setDistanciaAcumulada(double distancia_acumulada) {
		
		this.distancia_acumulada = distancia_acumulada;
		
	}
	
	public void setPosicionNodoProcedencia(int posicion) {
		
		posicion_nodo_procedencia = posicion;
		
	}
	
	public String getID() {
		
		return id;
		
	}
	
	public int getLengthPosicionesNodosProcedentes() {
		
		return posiciones_nodos_procedentes.length;
		
	}
	
	public int getPosicionNodoProcedente(int posicion) {
		
		return posiciones_nodos_procedentes[posicion];
		
	}
	
	public double getDistancia(int posicion) {
		
		return distancias[posicion];
		
	}
	
	public double getDistanciaAcumulada() {
		
		return distancia_acumulada;
		
	}
	
	public boolean getPermanente() {
		
		return permanente;
		
	}
	
	public int getPosicionNodoProcedencia() {
		
		return posicion_nodo_procedencia;
		
	}
	
	public int getPosicion() {
		
		return posicion;
		
	}
	
	public void cambiaID(String id) {
		
		this.id = id;
		
	}
	
	public int compareTo(Object objeto) {
		
		Nodo otroNodo = (Nodo) objeto;
		
		if(this.distancia_acumulada < otroNodo.distancia_acumulada) {
			
			return -1;
			
		}
		
		if(this.distancia_acumulada > otroNodo.distancia_acumulada) {
			
			return 1;
			
		}
		
		return 0;
		
	}
	
	private String id;
	
	private int posicion;
	
	private int[] posiciones_nodos_procedentes;
	
	private double[] distancias;
	
	private boolean permanente;
	
	private double distancia_acumulada;
	
	private int posicion_nodo_procedencia;
	
}

class Ecuacion {
    
    public void setA(double a) {
        
        this.a = a;
        
    }
    
    public void setB(double b) {
        
        this.b = b;
        
    }
    
    public void setC(double c) {
        
        this.c = c;
        
    }
    
    public void setD(double d) {
        
        this.d = d;
        
    }
    
    public void setE(double e) {
        
        this.e = e;
        
    }
    
    public double getA() {
        
        return a;
        
    }
    
    public double getB() {
        
        return b;
        
    }
    
    public double getC() {
        
        return c;
        
    }
    
    public double getD() {
        
        return d;
        
    }
    
    public double getE() {
        
        return e;
        
    }
    
    public void setCoeficiente(double valor_coeficiente) {
        
        coeficientes.add(valor_coeficiente);
        
    }
    
    public double getCoeficiente(int indice) {
        
        return coeficientes.get(indice);
        
    }
    
    public double[] getCoeficientes() {
        
        double[] aux_coeficientes = new double[coeficientes.size()];
        
        for(int i=0; i<coeficientes.size(); i++) {
            
            aux_coeficientes[i] = coeficientes.get(i);
            
        }
        
        return aux_coeficientes;
    }
    
    private ArrayList <Double> coeficientes = new ArrayList <Double>();
    
    private double a, b, c, d, e;
    
}

class Casos {
    
    public static void caso1(String tipo_limites, double limite_a, double limite_b, double[] derivada_1, double[] derivada_2) {
        
        switch(tipo_limites) {
            
            case "A":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
            
        }
        
        x0 = -1*derivada_1[1] / derivada_1[0];
        
        tiene_solucion = x0>=Casos.limite_a && x0<=Casos.limite_b;
        
        if(derivada_2[0] > 0) {
            
            tipo_x0 = "MINIMO";
            
            condicion = "Si f'(x0) = 0 y f''(x0) > 0, x0 es un mínimo local";
            
        }
        
        else if(derivada_2[0] < 0) {
            
            tipo_x0 = "MAXIMO";
            
            condicion = "Si f'(x0) = 0 y f''(x0) < 0, x0 es un máximo local";
            
        }
        
        else {
            
            tipo_x0 = "NINGUNO";
            
        }
        
    }
    
    public static void caso2(String tipo_limites, double limite_a, double limite_b, double[] funcion_objetivo, String tipo) {
        
        switch(tipo_limites) {
            
            case "A": 
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
            
        }
        
        if(tipo.equals("MAX")) {
        	
            x0 = limite_a;
            
            double x1 = x0 - 0.1;
            
            double x2 = x0 + 0.1;
            
            double f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
            
            double f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
            
            double f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
            
            if(f_x0>f_x1 && f_x0<f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0<f_x1 && f_x0>f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0>=f_x1 && f_x0>=f_x2) {
                
                tipo_x0 = "MAXIMO";
                
                condicion = "Si f(x0) >= f(x1) y f(x0) >= f(x2), x0 es un máximo local";
                
            }
            
            if(f_x0<=f_x1 && f_x1<=f_x2) {
                
                tipo_x0 = "MINIMO";
                
            }
            
            if(!tipo_x0.equals("MAXIMO")) {
            	
            	x0 = limite_b;
                
                x1 = x0 - 0.1;
                
                x2 = x0 + 0.1;
                
                f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
                
                f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
                
                f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
                
                if(f_x0>f_x1 && f_x0<f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0<f_x1 && f_x0>f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0>=f_x1 && f_x0>=f_x2) {
                    
                    tipo_x0 = "MAXIMO";
                    
                    condicion = "Si f(x0) >= f(x1) y f(x0) >= f(x2), x0 es un máximo local";
                    
                }
                
                if(f_x0<=f_x1 && f_x1<=f_x2) {
                    
                    tipo_x0 = "MINIMO";
                    
                }
            	
            }	
            
        }
        
        if(tipo.equals("MIN")) {
        	
        	x0 = limite_a;
            
            double x1 = x0 - 0.1;
            
            double x2 = x0 + 0.1;
            
            double f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
            
            double f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
            
            double f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
            
            if(f_x0>f_x1 && f_x0<f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0<f_x1 && f_x0>f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0>=f_x1 && f_x0>=f_x2) {
                
                tipo_x0 = "MAXIMO";
                
            }
            
            if(f_x0<=f_x1 && f_x1<=f_x2) {
                
                tipo_x0 = "MINIMO";
                
                condicion = "Si f(x0) <= f(x1) y f(x0) <= f(x2), x0 es un minimo local";
                
            }
            
            if(!tipo_x0.equals("MINIMO")) {
            	
                x0 = limite_a;
                
                x1 = x0 - 0.1;
                
                x2 = x0 + 0.1;
                
                f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
                
                f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
                
                f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
                
                if(f_x0>f_x1 && f_x0<f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0<f_x1 && f_x0>f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0>=f_x1 && f_x0>=f_x2) {
                    
                    tipo_x0 = "MAXIMO";
                    
                }
                
                if(f_x0<=f_x1 && f_x1<=f_x2) {
                    
                    tipo_x0 = "MINIMO";
                    
                    condicion = "Si f(x0) <= f(x1) y f(x0) <= f(x2), x0 es un minimo local";
                    
                }
            	
            }
            
        }
        
    }
    
    public static void caso3(String tipo_limites, double limite_a, double limite_b, double[] derivada_1, String tipo) {
        
        switch(tipo_limites) {
            
            case "A":
                
                Casos.limite_a = limite_a + 0.1;
                
                Casos.limite_b = limite_b - 0.1;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a + 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b - 0.1;
            
        }
            
        double derivada_1_a = derivada_1[0]*Casos.limite_a + derivada_1[1];
        
        double derivada_1_b = derivada_1[0]*Casos.limite_b + derivada_1[1];
        
        if(tipo.equals("MAX")) {
            
            if(derivada_1_a > 0) {
                
                tipo_x0 = "MINIMO";
                
            }
            
            else if(derivada_1_a < 0) {
                
                tipo_x0 = "MAXIMO";
                
                condicion = "Si f'(a) < 0, a es un máxmimo local";
                
                x0 = Casos.limite_a;
                
            }
            
            else {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(!tipo_x0.equals("MAXIMO")) {
            	
            	if(derivada_1_b > 0) {
                    
                    tipo_x0 = "MAXIMO";
                    
                    condicion = "Si f'(b) > 0, b es un máximo local";
                    
                    x0 = Casos.limite_b;
                    
                }
                
                else if(derivada_1_b < 0) {
                    
                    tipo_x0 = "MINIMO";
                    
                }
            	
                else {
                	
                	tipo_x0 = "NINGUNO";
                	
                }
            	
            }
            
        }
        
        if(tipo.equals("MIN")) {
            
            if(derivada_1_a > 0) {
                
                tipo_x0 = "MINIMO";
                
                condicion = "Si f'(a) > 0, a es un mínimo local";
                
                x0 = Casos.limite_a;
                
            }
            
            else if(derivada_1_a < 0) {
                
                tipo_x0 = "MAXIMO";
                
            }
            
            else {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(!tipo_x0.equals("MINIMO")) {
            	
            	 if(derivada_1_b > 0) {
                     
                     tipo_x0 = "MAXIMO";
                     
                 }
                 
                 else if(derivada_1_b < 0) {
                     
                     tipo_x0 = "MINIMO";
                     
                     condicion = "Si f'(b) < 0, b es un minimo local";
                     
                     x0 = Casos.limite_b;
                     
                 }
            	 
                 else {
                	 
                	 tipo_x0 = "NINGUNO";
                	 
                 }
            	
            }
            
        }
        
    }
    
    public static double getX0() {
        
        return x0;
        
    }
    
    public static String getTipoX0() {
        
        return tipo_x0.toUpperCase();
        
    }
    
    public static String getCondicion() {
        
        return condicion;
        
    }
    
    public static boolean getTieneSolucion() {
        
        return tiene_solucion;
        
    }
    
    private static double x0, limite_a, limite_b;
    
    private static String tipo_x0, condicion;
    
    private static boolean tiene_solucion;
    
}

class ModeloEOQ {
	
	public void setQAsterisco(double q_asterisco) {
		
		this.q_asterisco = q_asterisco;
		
	}
	
	public void setPeriodicidad(double periodicidad) {
		
		this.periodicidad = periodicidad;
		
	}
	
	public void setCostoTotal(double costo_total) {
		
		this.costo_total = costo_total;
		
	}
	
	public void setK(double k) {
		
		this.k = k;
		
	}
	
	public void setH(double h) {
		
		this.h = h;
		
	}
	
	public void setD(double d) {
		
		this.d = d;
		
	}
	
	public void setP(double p) {
		
		this.p = p;
		
	}
	
	public double getQAsterisco() {
		
		return q_asterisco;
		
	}
	
	public double getPeriodicidad() {
		
		return periodicidad;
		
	}
	
	public double getCostoTotal() {
		
		return costo_total;
		
	}
	
	public double getK() {
		
		return k;
		
	}
	
	public double getH() {
		
		return h;
		
	}
	
	public double getD() {
		
		return d;
		
	}
	
	public double getP() {
		
		return p;
		
	}
	
	public void generarQAsterisco() {
		
		q_asterisco = Math.round(Math.sqrt((2*k*d) / h));
		
	}
	
	public void generarPeriodicidad() {
		
		periodicidad = Math.round((d / q_asterisco));
		
	}
	
	public void generarCostoTotal() {
		
		costo_total = ((k*d)/q_asterisco) + (p*d) + ((h*q_asterisco)/2);
		
	}
	
	private double q_asterisco;
	
	private double periodicidad;
	
	private double costo_total;
	
	private double k;
	
	private double h;
	
	private double d;
	
	private double p;
	
}

class ModeloEOQR extends ModeloEOQ {
	
	public void setR(double r) {
		
		this.r = r;
		
	}
	
	public void setL(double l) {
		
		this.l = l;
		
	}
	
	public void setT(double t) {
		
		this.t = t;
		
	}
	
	public double getR() {
		
		return r;
		
	}
	
	public double getL() {
		
		return l;
		
	}
	
	public double getT() {
		
		return t;
		
	}
	
	public void generarR() {
		
		 r = Math.round(((getD()*getL()) / 365));
		
	}
	
	public void generarT() {
		
		t = Math.round(365 * (getQAsterisco()/getD()));
		
	}
	
	private double r;
	
	private double l;
	
	private double t;
	
}
	
class FormulasLE {
    
    public void setOpcionTiempo(int opcionTiempo) {
        
        this.opcionTiempo = opcionTiempo;
        
        if(opcionTiempo == 3) {
            
            Scanner entrada = new Scanner(System.in);
            
            System.out.print("\nIngrese no. de horas laborables al día: ");
            
            horasLab = entrada.nextDouble();
            
        }
        
    }
    
    public void setOpcionTiempoRes(int opcionTiempoRes) {
        
        this.opcionTiempoRes = opcionTiempoRes;
        
        if(opcionTiempoRes == 3) {
            
            if(horasLab == 0) {
                
                Scanner entrada = new Scanner(System.in);
                
                System.out.print("\nIngrese no. de horas laborables al día: ");
                
                horasLab = entrada.nextDouble();
                
            }
            
        }
        
    }
    
    public void setMiu(int miu) {
        
        this.miu = (double)miu;
        
    }
    
    public void setLanda(int landa) {
        
        this.landa = (double)landa;
        
    }
    
    public void setN(int n) {
        
        this.n = n;
        
    }
    
    public int getL() {  
        
        return (int)Math.round(l);
        
    }
    
    public int getLq() {
        
        return (int)Math.round(lq);
        
    }
    
    public int getLs() {        
        
        return (int)Math.round(ls);
        
    }
    
    public double getW() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return w;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return w/60;
                
            }
            
            return (w/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return w*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return w;
                
            }
            
            return w/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (w*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return w*horasLab;
                
        }
            
        return w;
        
    }
    
    public double getWq() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return wq;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return wq/60;
                
            }
            
            return (wq/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return wq*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return wq;
                
            }
            
            return wq/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (wq*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return wq*horasLab;
                
        }
            
        return wq;
        
    }
    
    public double getWs() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return ws;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws/60;
                
            }
            
            return (ws/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return ws*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws;
                
            }
            
            return ws/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (ws*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return ws*horasLab;
                
        }
            
        return ws;
        
    }
    
    public double getP() {
        
        return p*100;
        
    }
    
    public double getP0() {
        
        return p0*100;
        
    }
    
    public int getLs2() {
        
        return (int)Math.round(ls2);
        
    }
    
    public int getLq2() {
        
        return (int)Math.round(lq2);
        
    }
    
    public double getWs2() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return ws2;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws2/60;
                
            }
            
            return (ws2/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return ws2*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws2;
                
            }
            
            return ws2/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (ws2*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return ws2*horasLab;
                
        }
            
        return ws2;
        
    }
    
    public double getP1() {
        
        return p1*100;
        
    }
    
    public int getN() {
        
        return n;
        
    }
    
    public double getPm2() {
        
        return pm2*100;
        
    }
    
    public void definirPn() {
        
        pn = new double[n];
        
    }
    
    public void fijarW() {
        
        w = 1/(miu-landa);
        
    }
    
    public void fijarWq() {
        
        wq = landa/(miu*(miu-landa));
        
    }
    
    public void fijarWs() {
        
        ws = w-wq;
        
    }
    
    public void fijarL() {
        
        l = landa*w;
        
    }
    
    public void fijarLq() {
        
        lq = landa*wq;
        
    }
    
    public void fijarLs() {
        
        ls = landa*ws;
        
    }
    
    public void fijarP() {
        
        p = landa/miu;
        
    }
    
    public void fijarP0() {
        
        p0 = 1 - (landa/miu);
        
    }
    
    public void fijarP1() {
        
        p1 = p0*(landa/miu);
        
    }
    
    public void fijarLq2() {
        
        lq2 = Math.pow(landa, 2)/(miu*(miu-landa));
        
    }
    
    public void fijarLs2() {
        
        ls2 = landa/(miu-landa);
        
    }
    
    public void fijarWs2() {
        
        ws2 = 1/(miu-landa);
        
    }
    
    public void fijarPn() {
        
        for(int i=0; i<n; i++) {
            
            pn[i] = p0*Math.pow(landa/miu, i+1);
            
        }
        
    }
    
    public void fijarPm() {
        
        pm = p0;
        
        for(int i=0; i<n; i++) {
            
            pm += pn[i];
            
        }
        
    }
    
    public void fijarPm2() {
        
        pm2 = 1 - pm;
        
    }
    
    public String decirUTiempo() {
        
        if(opcionTiempo == 1) {
            
            return "minuto";
            
        }
        
        if(opcionTiempo == 2) {
            
            return "hora";
            
        }
        
        return "día";
        
    }
    
    public String decirUTiempoR() {
        
        if(opcionTiempoRes == 1) {
            
            return "minuto";
            
        }
        
        if(opcionTiempoRes == 2) {
            
            return "hora";
            
        }
        
        return "día";
        
    }   
    
    public boolean tieneSolucion() {
        
        return miu>landa;
        
    }
    
    private double miu;
    
    private double landa;
    
    private double l;
    
    private double lq;
    
    private double ls;
    
    private double w;
    
    private double wq;
    
    private double ws;
    
    private double horasLab = 0;
    
    private int opcionTiempo;
    
    private int opcionTiempoRes;
    
    private double p;
    
    private double p0;
    
    private double p1;
    
    private double lq2;
    
    private double ls2;
    
    private double ws2;
    
    private int n;
    
    private double[] pn;
    
    private double pm;
    
    private double pm2;
    
}
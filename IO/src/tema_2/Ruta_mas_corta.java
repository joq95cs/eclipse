package tema_2;

import java.util.*;

public class Ruta_mas_corta {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
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

		System.out.println("¡BIENVENIDO!");
		
		System.out.println("\nEl grafo a utilizar en este programa es el no. 4 de la hoja de ejercicios de moodle...");
		
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
		
		System.out.println("\nFIN");
		
	}

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

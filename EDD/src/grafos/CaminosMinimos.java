package grafos;

public class CaminosMinimos {
	
	public String algoritmoFloyd(long[][] matriz) {
		
		int vertices = matriz.length;
		long matrizPesos[][] = matriz;
		String caminos[][] = new String[vertices][vertices];
		String caminosAux[][] = new String[vertices][vertices];
		String caminoRecorrido = "", cadena = "", paths = "";
		int i, j, k;
		float temp1, temp2, temp3, temp4, minimo;
		
		for(i=0; i<vertices; i++) {
			
			for(j=0; j<vertices; j++) {
				
				caminos[i][j] = "";
				caminosAux[i][j] = "";
			}
		}
		
		for(k=0; k<vertices; k++) {
			
			for(i=0; i<vertices; i++) {
				
				for(j=0; j<vertices; j++) {
					
					temp1 = matrizPesos[i][j];
					temp2 = matrizPesos[i][k];
					temp3 = matrizPesos[k][j];
					temp4 = temp2 + temp3;
					
					minimo = Math.min(temp1, temp4);
					
					if(temp1 != temp4) {
						
						if(minimo == temp4) {
							
							caminoRecorrido = "";
							caminosAux[i][j] = k + "";
							caminos[i][j] = caminosR(i, k, caminosAux, caminoRecorrido) + (k+1);
						}
					}
					
					matrizPesos[i][j] = (long)minimo;
				}
			}
		}
		
		for(i=0; i<vertices; i++) {
			
			for(j=0; j<vertices; j++) {
				
				cadena = cadena + "[" + matrizPesos[i][j] + "]";
			}
			
			cadena = cadena + "\n";
		}
		
		for(i=0; i<vertices; i++) {
			
			for(j=0; j<vertices; j++) {
				
				if(matrizPesos[i][j] != 1000000000) {
					
					if(i != j) {
						
						if(caminos[i][j].equals("")) {
							
							paths += "De (" + (i+1) + "--->" + (j+1) + "), irse por: (" + (i+1) + ", " + (j+1) + ").\n";
						
						} else {
							
							paths += "De (" + (i+1) + "--->" + (j+1) + "), irse por: (" + (i+1) + ", " + caminos[i][j] + ", " + (j+1) + ").\n";
						}
					}
				}
				
			}
		}
		
		return "La matriz de caminos más cortos entre los diferentes nodos es:\n" + cadena +
				"\nLos diferentes caminos más cortos entre nodos son:\n" + paths;
	}
	
	public String caminosR(int i, int k, String[][] caminosAux, String caminoRecorrido) {
		
		if(caminosAux[i][k].equals("")) {
			
			return "";
			
		} else {
			
			caminoRecorrido += caminosR(i, Integer.parseInt(caminosAux[i][k].toString()), caminosAux, caminoRecorrido) + (Integer.parseInt(caminosAux[i][k].toString()) + 1) + ", ";
			return caminoRecorrido;
		}
		
	}
}
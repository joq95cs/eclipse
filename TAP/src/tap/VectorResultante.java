package tap;

import java.util.*;

public class VectorResultante {

	public static void main(String[] args) {
		
		setVectores();
		
		getVR();

	}
	
	public static void setVectores() {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Ingrese n: ");
		
		int n = entrada.nextInt();
		
		vectores = new ArrayList<int[]>();
		
		System.out.println();
		
		for(int i=0; i<n; i++) {
			
			System.out.println("Vector " + (i+1));
			
			int[] vector = new int[3];
			
			System.out.print("Ingrese valor de x: ");
			
			vector[0] = entrada.nextInt();
			
			System.out.print("Ingrese valor de y: ");
			
			vector[1] = entrada.nextInt();
			
			System.out.print("Ingrese valor de z: ");
			
			vector[2] = entrada.nextInt();
			
			vectores.add(vector);
			
			System.out.println();
			
		}
		
	}
	
	public static void getVR() {
		
		int[][] matriz = {{0, -1, 0}, {1, 0, 0}, {0, 0, 1}};
		
		ArrayList <int[]> vectoresr = new ArrayList <int[]> ();
		
		for(int i=0; i<vectores.size(); i++) {
			
			int[] vr = new int[3];
			
			vr[0] = vectores.get(i)[0] * matriz[0][0] + vectores.get(i)[1] * matriz[0][1] + vectores.get(i)[2] * matriz[0][2];
			
			vr[1] = vectores.get(i)[0] * matriz[1][0] + vectores.get(i)[1] * matriz[1][1] + vectores.get(i)[2] * matriz[1][2];
			
			vr[2] = vectores.get(i)[0] * matriz[2][0] + vectores.get(i)[1] * matriz[2][1] + vectores.get(i)[2] * matriz[2][2];
			
			vectoresr.add(vr);
			
		}
		
		for(int i=0; i<vectoresr.size(); i++) {
			
			System.out.println("Vector resultante " + (i+1) + ": (" + vectoresr.get(i)[0] + "," + vectoresr.get(i)[1] + "," + vectoresr.get(i)[2] + ")");
			
		}
		
	}
	
	private static ArrayList<int[]> vectores;
	
}

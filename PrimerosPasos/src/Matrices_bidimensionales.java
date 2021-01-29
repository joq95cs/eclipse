
public class Matrices_bidimensionales {

	public static void main(String[] args) {
		
		/*int matriz[][] = new int[4][5];
		
		matriz[0][0] = 15;
		matriz[0][1] = 1532;
		matriz[0][2] = 23;
		matriz[0][3] = 123;
		matriz[0][4] = 0;
		matriz[1][0] = -33;
		matriz[1][1] = -245;
		matriz[1][2] = 552;
		matriz[1][3] = 2;
		matriz[1][4] = -9;
		matriz[2][0] = 22122;
		matriz[2][1] = 333;
		matriz[2][2] = 222;
		matriz[2][3] = 666;
		matriz[2][4] = 687;
		matriz[3][0] = -36;
		matriz[3][1] = -654;
		matriz[3][2] = -6622;
		matriz[3][3] = -99;
		matriz[3][4] = -333312;*/
		
		int [][] matriz = {
				{14,66,45,96,10}, 
				{23,78,96,46,12}, 
				{74,99,88,11,36}, 
				{27,86,91,71,54},
		};

		/*for(int i=0; i<4; i++) {
			
			for(int j=0; j<5; j++) {
				
				System.out.println("Posición (" + i + "," + j + "): " + matriz[i][j]);*/
		
		for(int[]fila: matriz) {
			
			System.out.println();
			
			for(int z: fila) {
				
			System.out.print(z + " ");
			
			}
		}

	}

}

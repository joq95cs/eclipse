
public class NumerosPrimos {

	public static void main(String[] args) {
		
		int aux = 0;
		
		for(int i=200; i>0; i++) {
			
			for(int j=1; j<201; j++) {
				
				if(i%j == 0){
					
					aux += 1;
					
				}
				
			}
			
			if(aux == 2) {
				
				System.out.print(i + " ");
				
			}
			
		}

	}

}

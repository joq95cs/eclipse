
public class Matrices_3 {

	public static void main(String[] args) {
		
		int random[] = new int[150];
		
		for(int i=0; i<random.length; i++) {
			
			random[i] = (int)(Math.round(Math.random()*100));
			
		}
		
		for(int numeros: random) {
			
			System.out.print(numeros + ", ");
			
		}

	}

}

package recursividad;

public class Fibonacci_recursividad {

	public static void main(String[] args) {
		
		System.out.println("Fibonacci de 12 con recursividad: " + fibonacciR(12));
		
		System.out.println("Fibonacci de 12 con ciclo: " + fibonacciC(12));

	}
	
	public static int fibonacciR(int n) {
		
		if(n > 0) {
			
			if(n==1 || n==2) { //Caso base (Respuesta explicita)
				
				return 1;
				
			} else {
				
				return fibonacciR(n-1) + fibonacciR(n-2);
				
			}
			
		}
		
		return 0;
		
	}
	
	public static int fibonacciC(int n) {
		
		int r = 0, a=1, b=0;
		
		if(n > 0) {
			
			while(n > 0) {
				
				r = a + b;
				
				a = b;
				
				b = r;
				
				n--;
				
			}
			
			return r;
			
		}
		
		return 0;
		
	} // n->3->2->1->0			r->0->1->1->2			a->1->0->1->1			b->0->1->1->2

}

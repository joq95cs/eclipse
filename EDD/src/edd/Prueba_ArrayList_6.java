package edd;

import java.util.ArrayList;

public class Prueba_ArrayList_6 {

	public static void main(String[] args) {
		
		ArrayList<Double[]> lista = new ArrayList<Double[]>();
		
		lista.add(new Double[3]);
		
		lista.get(0)[0] = Double.valueOf(12.45);
		
		lista.get(0)[1] = Double.valueOf(13.6);
		
		lista.get(0)[2] = Double.valueOf(34.1);
		
		lista.add(new Double[2]);
		
		lista.get(1)[0] = Double.valueOf(45);
		
		lista.get(1)[1] = Double.valueOf(100);
		
		lista.add(new Double[5]);
		
		lista.get(2)[0] = Double.valueOf(124.67);
		
		lista.get(2)[1] = Double.valueOf(90.0909);
	
		lista.get(2)[2] = Double.valueOf(12.56789);
		
		lista.get(2)[3] = Double.valueOf(12.4578);
		
		lista.get(2)[4] = Double.valueOf(56.56);
		
		for(int i=0; i<lista.size(); i++) {
			
			for(int j=0; j<lista.get(i).length; j++) {
				
				System.out.print(lista.get(i)[j].doubleValue() + "  "); 
				
			}
			
			System.out.print("\n\n");
			
		}
		
	}

}

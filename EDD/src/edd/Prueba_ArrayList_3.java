package edd;

import java.util.ArrayList;

public class Prueba_ArrayList_3 {
	
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList <Integer> numeros = new ArrayList <Integer>();
        
        numeros.add(98);
        
        numeros.add(45);
        
        numeros.add(234);
        
        numeros.add(1234);
        
        for(int i=0; i<numeros.size(); i++) {
            
            System.out.println(numeros.get(i));
            
        }
        
    }
    
}

package tap;

import java.util.Scanner;

public class OperacionesMatematicas {
    
    public OperacionesMatematicas(String nombre) {
        
        this.nombre = nombre;
        entrada = new Scanner(System.in);
        
        
    }
    
    public float getSuma() {
        
        System.out.print("\nIngrese cantidad de números a sumar: ");
        numeros = new float[entrada.nextInt()];
        System.out.println();
        float suma = 0;
        
        for(int i=0; i<numeros.length; i++) {
            
            System.out.print("Ingrese número " + (i+1) + ": ");
            numeros[i] = entrada.nextFloat();
            
        }
        
        for(int i=0; i<numeros.length; i++) {
            
            suma = suma + numeros[i];
            
        }
        
        return suma;
        
    }
    
    public float getResta() {
        
        System.out.print("\nIngrese cantidad de números a restar: ");
        numeros = new float[entrada.nextInt()];
        System.out.println();
        
        for(int i=0; i<numeros.length; i++) {
            
            System.out.print("Ingrese número " + (i+1) + ": ");
            numeros[i] = entrada.nextFloat();
            
        }
        
        float resta = numeros[0];
        
        for(int i=1; i<numeros.length; i++) {
            
            resta = resta - numeros[i];
            
        }
        
        return resta;
        
    }
    
    public float getMultiplicacion() {
        
        System.out.print("\nIngrese cantidad de números a multiplicar: ");
        numeros = new float[entrada.nextInt()];
        System.out.println();
        float multiplicacion = 1;
        
        for(int i=0; i<numeros.length; i++) {
            
            System.out.print("Ingrese número " + (i+1) + ": ");
            numeros[i] = entrada.nextFloat();
            
        }
        
        for(int i=0; i<numeros.length; i++) {
            
            multiplicacion = multiplicacion * numeros[i];
            
        }
        
        return multiplicacion;
        
    }
    
    public Float getDivision() {
    	
    	numeros = new float[2];
    	System.out.print("\nIngrese dividendo: ");
    	numeros[0] = entrada.nextFloat();
    	System.out.print("Ingrese divisor: ");
    	numeros[1] = entrada.nextFloat();
    	
    	if(numeros[1] == 0) {
    		
    		return null;
    		
    	}
    	
    	float division = numeros[0]/numeros[1];
    	
    	return division;
    	
    }
    
    public Float getPotencia() {
    	
    	System.out.print("\nIngrese base: ");
    	float b = entrada.nextFloat();
    	System.out.print("Ingrese exponente: ");
    	int e = entrada.nextInt();
    	float potencia = 1;
    	
    	if(e >=0 ) {
    		
    		if(e == 0) {
    			
    			return potencia;
    			
    		} else {
    			
    			for(int i=0; i<e; i++) {
    				
    				potencia = potencia * b;
    				
    			}
    			
    		}
    		
    	} else {
    		
    		return null;
    		
    	}
    	
    	return potencia;
    	
    }
    
    private Scanner entrada;
    private float[] numeros;
    public String nombre;
    
}

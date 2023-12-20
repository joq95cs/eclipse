package edd;

public class TDAEsfera {
    
    public TDAEsfera(double radioInicial) {
        
        if(radioInicial>0) {
            
            this.radio = radioInicial;
            
        } 
        
        else {
            
            this.radio = 0;
            
        }
        
    }
    
    public double getRadio() {
        
        return this.radio;
        
    }
    
    public double getDiametro() {
        
        return (radio * 2);
        
    }
    
    public double getCircunferencia() {
        
        return (Math.PI * getDiametro());
        
    }
    
    public double getArea() {
    	
    	return (Math.PI * Math.pow(radio, 2));
        
    }
    
    public double getVolumen() {
        
        return ((4 * Math.PI * Math.pow(radio, 3)) / 3);
        
    }
    
    private double radio;
    
}

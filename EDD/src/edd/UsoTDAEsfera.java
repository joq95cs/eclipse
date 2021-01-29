package edd;

public class UsoTDAEsfera {
	
    public static void main(String[] args) {
        
        TDAEsfera esferita = new TDAEsfera(10);
        
        System.out.println("Radio: " + esferita.getRadio());
        
        System.out.println("Diametro: " + esferita.getDiametro());
        
        System.out.println("Circunferencia: " + esferita.getCircunferencia());
        
        System.out.println("Área: " + esferita.getArea());
        
        System.out.println("Volumen: " + esferita.getVolumen());
        
    }
    
}

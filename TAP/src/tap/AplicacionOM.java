package tap;

import java.util.*;

public class AplicacionOM {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        ArrayList <OperacionesMatematicas> objetosOM = new ArrayList <OperacionesMatematicas>();
        
        do {
            
            System.out.print("Ingrese nombre de la operaci�n: ");
            objetosOM.add(new OperacionesMatematicas(entrada.next().toUpperCase()));
            System.out.print("�Agregar otra operaci�n? (S/N): ");
            
            if(entrada.next().equalsIgnoreCase("N")) break;
            
        } while(true);
        
        System.out.print("\n�Realizar operaci�n? (S/N): ");
        
        if(entrada.next().equalsIgnoreCase("S")) {
            
            System.out.print("Ingrese nombre de la operaci�n a realizar: ");
            
            switch(entrada.next().toUpperCase()) {
                
                case "SUMA": 
                    
                    for(int i=0; i<objetosOM.size(); i++) {
                        
                        if(objetosOM.get(i).nombre.equals("SUMA")) {
                            
                            System.out.println("\nResultado: " + objetosOM.get(i).getSuma());
                            break;
                            
                        }
                        
                    }
                    
                    break;
                    
                case "RESTA":
                    
                    for(int i=0; i<objetosOM.size(); i++) {
                        
                        if(objetosOM.get(i).nombre.equals("RESTA")) {
                            
                            System.out.println("\nResultado: " + objetosOM.get(i).getResta());
                            break;
                            
                        }
                        
                    }
                    
                    break;
                    
                case "MULTIPLICACI�N":
                    
                    for(int i=0; i<objetosOM.size(); i++) {
                        
                        if(objetosOM.get(i).nombre.equals("MULTIPLICACI�N")) {
                            
                            System.out.println("\nResultado: " + objetosOM.get(i).getMultiplicacion());
                            break;
                            
                        }
                        
                    }
                    
                    break;
                    
                case "DIVISI�N":
                    
                    for(int i=0; i<objetosOM.size(); i++) {
                        
                        if(objetosOM.get(i).nombre.equals("DIVISI�N")) {
                            
                            System.out.println("\nResultado: " + objetosOM.get(i).getDivision());
                            break;
                            
                        }
                        
                    }
                    
                    break;
                    
                case "POTENCIA":
                    
                    for(int i=0; i<objetosOM.size(); i++) {
                        
                            if(objetosOM.get(i).nombre.equals("POTENCIA")) {
                            
                            System.out.println("\nResultado: " + objetosOM.get(i).getPotencia());
                            break;
                            
                        }
                        
                    }
                
            }
            
        }
        
    } 
    
}
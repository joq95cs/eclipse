package edd;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Prueba_ArrayList {
	
    public static void main(String[] args) {
        
        ArrayList <String> cadenas;
        
        cadenas = new ArrayList<String>();
        
        String frase, respuesta;
        
        do {
            
            frase = JOptionPane.showInputDialog(null, "Ingresa frase");
            
            cadenas.add(frase);
            
            respuesta = JOptionPane.showInputDialog(null, "¿Deseas agregar otra frase? (S/N)");
            
            respuesta = respuesta.toUpperCase();
            
        } while(!respuesta.equals("N"));
        
        System.out.println("FRASES ORIGINALES\n");
        
        for(int i=0; i<cadenas.size(); i++) {
            
            System.out.println(cadenas.get(i));
            
        }
        
        cadenas.set(1, "La que modifiqué");
        
        System.out.println("\nFRASES MODIFICADAS\n");
        
          for(int i=0; i<cadenas.size(); i++) {
            
            System.out.println(cadenas.get(i));
            
          }
          
        cadenas.remove(cadenas.size()-1);
        
        System.out.println("\nFRASES RESTANTES");
        
        for(int i=0; i<cadenas.size(); i++) {
            
            System.out.println(cadenas.get(i));
            
        }
       
    }
    
}

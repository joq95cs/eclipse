
package pilas;

import javax.swing.*;

public class UsoPilaD {
    
    public static void main(String[] args) {
        
        int opcion = 0, dato;
        
        try {
            
            PilaD pila = new PilaD();
            
            do {
                
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1: Empujar un elemento en la pila\n" +
                        "2: Sacar un elemento de la pila\n" +
                        "3: Saber si la pila está vacía\n" +
                        "4: Saber qué elemento está en la cima\n" +
                        "5: Saber el tamaño de la pila\n" + 
                        "6: Limpiar pila\n" +
                        "7: Salir", "Ingrese una opción", JOptionPane.QUESTION_MESSAGE));
                
                switch(opcion) {
                    
                    case 1:
                        
                        dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Empujar", JOptionPane.QUESTION_MESSAGE));
                        
                        pila.push(dato);
                        
                        break;
                        
                    case 2:
                        
                        if(!pila.pilaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "Elemento sacado: " + pila.pop(), "Sacar", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila vacía", "Error", 0);
                            
                        }
                        
                        break;
                        
                    case 3:
                        
                        if(pila.pilaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "Pila vacía", "Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila no vacía", "Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        
                        break;
                        
                    case 4:
                        
                        if(!pila.pilaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "Elemento en la cima: " + pila.getCima(), "Cima", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila vacía", "Error", 0);
                            
                        }
                        
                        break;
                        
                    case 5:
                        
                        JOptionPane.showMessageDialog(null, "Tamaño de la pila: " + pila.getTamagno(), "Tamaño", JOptionPane.INFORMATION_MESSAGE);
                        
                        break;
                        
                    case 6:
                        
                        if(!pila.pilaVacia()) {
                            
                            pila.limpiar();
                            JOptionPane.showMessageDialog(null, "Pila limpiada", "Pila", JOptionPane.WARNING_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila vacía", "Error", 0);
                            
                        }
                        
                        break;
                        
                    case 7:
                        break;
                        
                    default:
                        
                        JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", 0);
                        
                }
                
            } while(opcion != 7);
            
        } catch(NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        }
        
    }
    
}

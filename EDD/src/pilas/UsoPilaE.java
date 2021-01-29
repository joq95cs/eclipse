
package pilas;

import javax.swing.JOptionPane;

public class UsoPilaE {
    
    public static void main(String[] args) {
        
        int opcion=0, elemento, tamagno;
        
        try {
            
            tamagno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de la pila", "Pila", JOptionPane.QUESTION_MESSAGE));
            
            PilaE pila = new PilaE(tamagno);
            
            do {
                
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1: Empujar un elemento en la pila\n" +
                        "2: Sacar un elemento de la pila\n" +
                        "3: Saber si la pila está vacía\n" +
                        "4: Saber si la pila está llena\n" +
                        "5: Saber qué elemento está en la cima\n" +
                        "6: Saber el tamaño de la pila\n" + 
                        "7: Salir", "Ingrese una opción", JOptionPane.QUESTION_MESSAGE));
                
                switch(opcion) {
                    
                    case 1:
                        
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Empujar", JOptionPane.QUESTION_MESSAGE));
                        
                        if(!pila.pilaLlena()) {
                            
                            pila.push(elemento);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila llena", "Error", 0);
                            
                        }
                        
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
                        
                        if(pila.pilaLlena()) {
                            
                            JOptionPane.showMessageDialog(null, "Pila llena", "Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila no llena", "Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        
                        break;
                        
                    case 5:
                        
                        if(!pila.pilaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "Elemento en la cima: " + pila.cimaPila(), "Cima", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Pila vacía", "Error", 0);
                            
                        }
                        
                        break;
                        
                    case 6:
                        
                        JOptionPane.showMessageDialog(null, "Tamaño de la pila: " + pila.tamagnoPila(), "Tamaño", JOptionPane.INFORMATION_MESSAGE);
                        
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
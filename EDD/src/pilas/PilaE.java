
package pilas;

public class PilaE {
    
    public PilaE(int tamagno) {
        
        vectorPila = new int[tamagno];
        cima = -1;
        
    }
    
    public void push(int dato) {
        
        cima ++;
        vectorPila[cima] = dato;
        
    }
    
    public int pop() {
        
        int fuera = vectorPila[cima];
        cima --;
        return fuera;
        
    }
    
    public boolean pilaVacia() {
        
        return cima == -1;
        
    }
    
    public boolean pilaLlena() {
        
        return vectorPila.length-1 == cima;
        
    }
    
    public int cimaPila() {
        
        return vectorPila[cima];
        
    }
    
    public int tamagnoPila() {
        
        return vectorPila.length;
        
    }
    
    int[] vectorPila;
    int cima;
    
}


package pilas;

public class PilaD {
    
    public PilaD() {
        
        cima = null;
        tamagno = 0;
        
    }
    
    public boolean pilaVacia() {
        
        return cima == null;
        
    }
    
    public void push(int dato) {
        
        NodoPilaD nuevo = new NodoPilaD(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamagno ++;
        
    }
    
    public int pop() {
        
        int aux = cima.dato;
        cima = cima.siguiente;
        tamagno --;
        return aux;
        
    }
    
    public int getCima() {
        
        return cima.dato;
        
    }
    
    public int getTamagno() {
        
        return tamagno;
        
    }
    
    public void limpiar() {
        
        while(!pilaVacia()) {
            
            pop();
            
        }
        
    }
    
    private NodoPilaD cima;
    private int tamagno;
    
}

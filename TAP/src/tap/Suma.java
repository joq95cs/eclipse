package tap;

import javax.swing.*;

import java.util.*;

import java.awt.*;

public class Suma {

    public static void main(String[] args) {
        
        MarcoSuma marco = new MarcoSuma();
        
        marco.initComponents();
        
        marco.setVisible(true);
        
    }
    
}

class MarcoSuma extends JFrame {
    
    public MarcoSuma() {
        
        lamina = new LaminaSuma();
        
        setSize(400, 300);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Suma");
        
    }
    
    public void initComponents() {
        
        lamina.setNumeros();
        
        lamina.initComponents();
        
        add(lamina);
        
    }
    
    private LaminaSuma lamina;
    
}

class LaminaSuma extends JPanel {
    
    public LaminaSuma() {
        
        etiquetas = new JLabel[6];
        
        campos = new JTextField[6];
        
        entrada = new Scanner(System.in);
        
        numeros = new int[5];
        
    }
    
    public void initComponents() {
        
        setLayout(new GridLayout(6,2));
        
        int suma = 0;
        
        for(int i=0; i<etiquetas.length; i++) {
            
            etiquetas[i] = new JLabel();
            
            if(i == 5) {
                
                etiquetas[i].setText("Resultado");
                
            } else {
                
                etiquetas[i].setText("Posición [" + i + "]");
                
            }
            
            add(etiquetas[i]);
            
            campos[i] = new JTextField();
            
            if(i == 5) {
                
                campos[i].setText("" + suma);
                
            } else {
                
                campos[i].setText(String.valueOf(numeros[i]));
                
                suma += numeros[i];
                
            } 
            
            campos[i].setEditable(false);
            
            add(campos[i]);
            
        }
        
        
    }
    
    public void setNumeros() {
        
        for(int i=0; i<numeros.length; i++) {
            
            System.out.print("Ingrese número " + (i+1) + ": ");
            
            numeros[i] = entrada.nextInt();
            
        }
        
    }
    
    private JLabel[] etiquetas;
    
    private JTextField[] campos;
    
    private Scanner entrada;
    
    private int[] numeros;
    
}

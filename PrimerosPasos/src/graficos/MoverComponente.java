package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class MoverComponente {

    public static void main(String[] args) {
        
        MarcoMC m = new MarcoMC();
        
        m.setVisible(true);
        
    }
    
}

class MarcoMC extends JFrame {
    
    public MarcoMC() {
        
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setSize(ancho, alto);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Mover componente");
        
        LaminaMC l = new LaminaMC();
        
        add(l);
        
        o = l.getO();
        
        addKeyListener(o);
        
    }
    
    private OyenteMC o;
    
}

class LaminaMC extends JPanel {
    
    public LaminaMC() {
        
        setLayout(null);
        
        boton = new JButton("MUÉVEME");
        
        boton.setEnabled(false);
        
        boton.setBackground(Color.green);
        
        boton.setSize(100, 100);
        
        boton.setLocation(0, 0);
        
        add(boton);
        
        o = new OyenteMC();
        
        o.setBoton(boton);
        
    }
    
    public OyenteMC getO() {
        
        return o;
        
    }
    
    private OyenteMC o;
    
    private JButton boton;
    
}

class OyenteMC extends KeyAdapter {
    
    public OyenteMC() {
        
        ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
    }
    
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
            boton.setBackground(Color.RED);
            
            if(boton.getLocation().x <= ancho-105) {
                
                boton.setLocation(boton.getLocation().x+5, boton.getLocation().y);
                
            }
            
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            
            boton.setBackground(Color.RED);
            
            if(boton.getLocation().x > 0) {
                
                boton.setLocation(boton.getLocation().x-5, boton.getLocation().y);
                
            }
            
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            
            boton.setBackground(Color.RED);
            
            if(boton.getLocation().y > 0) {
            
                boton.setLocation(boton.getLocation().x, boton.getLocation().y-5);
                
            }
            
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            
            boton.setBackground(Color.RED);
            
            if(boton.getLocation().y <= alto-105) {
            
                boton.setLocation(boton.getLocation().x, boton.getLocation().y+5);
                
            }
            
        }
        
    }
    
    public void keyReleased(KeyEvent e) {
        
        boton.setBackground(Color.GREEN);
        
    }
    
    public void setBoton(JButton boton) {
        
        this.boton = boton;
        
    }
    
    private JButton boton;
    
    private int ancho;
    
    private int alto;
        
}
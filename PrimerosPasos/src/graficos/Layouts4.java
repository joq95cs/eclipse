package graficos;

import javax.swing.*;

import java.awt.*;

public class Layouts4 {
    
    public static void main(String[] args) {
        
        MarcoLayouts4 marco = new MarcoLayouts4();
        
        marco.setVisible(true);
        
    }
    
}

class MarcoLayouts4 extends JFrame {
    
    public MarcoLayouts4() {
        
        setSize(300, 250);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(new LaminaLayouts4());
        
    }
    
}

class LaminaLayouts4 extends JPanel {
    
    public LaminaLayouts4() {
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridwidth = 1;
        
        c.gridheight = 1;
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        add(new JButton("Botón 1"), c);
        
        c.gridx = 1;
        
        c.gridy = 0;
        
        add(new JButton("Botón 2"), c);
        
        c.gridx = 2;
        
        c.gridy = 0;
        
        add(new JButton("Botón 3"), c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        add(new JButton("Botón 4"), c);
        
        c.gridx = 1;
        
        c.gridy = 1;
        
        add(new JButton("Botón 5"), c);
        
        c.gridx = 2;
        
        c.gridy = 1;
        
        add(new JButton("Botón 6"), c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        add(new JButton("Botón 7"), c);
        
        c.gridx = 1;
        
        c.gridy = 2;
        
        add(new JButton("Botón 8"), c);
        
        c.gridx = 2;
        
        c.gridy = 2;
        
        add(new JButton("Botón 9"), c);
        
    }
 
}
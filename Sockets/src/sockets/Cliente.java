package sockets;

import javax.swing.*;

import java.awt.event.*;

import java.io.*;

import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		
		MarcoCliente mimarco = new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		
		setResizable(false);
		
		setSize(280, 350);
				
		LaminaMarcoCliente milamina = new LaminaMarcoCliente();
		
		add(milamina);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente() {
	
		JLabel texto = new JLabel("CLIENTE");
		
		add(texto);
	
		campo1 = new JTextField(20);
	
		add(campo1);		
	
		miboton = new JButton("Enviar");
		
		EnviaTexto mievento = new EnviaTexto();
		
		miboton.addActionListener(mievento);
		
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				Socket misocket = new Socket("localhost", 9999);
				
				DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();
				
				misocket.close();
				
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(null, "No hay conexión", "Error", 0);
				
			}
			
		}
		
	}
	
	private JTextField campo1;
	
	private JButton miboton;
	
}

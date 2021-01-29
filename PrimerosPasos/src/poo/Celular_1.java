package poo;

import javax.swing.JOptionPane;

public class Celular_1 {

	public static void main(String[] args) {
		
		Celular celular1 = new Celular();
		
		celular1.getAtributos();
		
		celular1.setModelo(JOptionPane.showInputDialog("Introduce modelo"));
		
		celular1.setColor(JOptionPane.showInputDialog("Introduce color"));
		
		celular1.setMemoriaInterna(Integer.parseInt(JOptionPane.showInputDialog("Introduce memoria interna en GB")));
		
		celular1.setVersionAndroid(JOptionPane.showInputDialog("Introduce versión de Android"));
		
		celular1.setRAM(Integer.parseInt(JOptionPane.showInputDialog("Introduce RAM en GB")));
		
		celular1.setNucleos(Integer.parseInt(JOptionPane.showInputDialog("Introduce cantidad de nucleos")));
		
		System.out.println(celular1.getAtributos() + "\n" + celular1.getModelo() + "\n" + celular1.getColor()
		+ "\n" + celular1.getMemoriaInterna() + "\n" + celular1.getVersionAndroid() + "\n" + celular1.getRAM()
		+ "\n" + celular1.getNucleos());
		
	}

}
import javax.swing.*;
public class PesoIdeal {

	public static void main(String[] args) {
		
		String sexo = "";
		
		do {
			
			sexo = JOptionPane.showInputDialog("Introduce tu sexo (H/M)");
			
		} while(sexo.equalsIgnoreCase("H") == false && sexo.equalsIgnoreCase("M") == false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en centímetros"));
		
		int peso_ideal = 0;
		
		if(sexo.equalsIgnoreCase("H")) {
			
			peso_ideal = altura - 110;
		}
		
		else {
			
			peso_ideal = altura -120;
		}
		
		System.out.println("Tu peso ideal es: " + peso_ideal + " kg");
	}

}

package excepciones;

import javax.swing.*;

public class Prueba_excepciones7 {

	public static void main(String[] args) {
		
		try {
			
			validarMail();
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			
			e.printStackTrace();
			
		}

	}
	
	public static void validarMail() throws Exception {
		
		String mail = JOptionPane.showInputDialog("Ingrese mail");
		
		boolean tiene_punto = false;
		
		int no_arrobas = 0;
		
		for(int i=0; i<mail.length(); i++) {
			
			if(mail.charAt(i) == '@') {
				
				no_arrobas ++;
				
			} else if(mail.charAt(i) == '.') {
				
				tiene_punto = true;
				
			}
			
		}
		
		if(no_arrobas == 1 && tiene_punto) {
			
			JOptionPane.showMessageDialog(null, "Email correcto");
			
		} else if(no_arrobas != 1 && tiene_punto == false) {
			
			throw new MailIncorrecto("No. arrobas incorrecto y sin puntos");
			
		} else if(tiene_punto == false) {
			
			throw new MailIncorrecto("Sin puntos");
			
		} else if(no_arrobas != 1) {
			
			throw new MailIncorrecto("No. arrobas incorrecto");
			
		}
		
	}

}

class MailIncorrecto extends Exception {
	
	public MailIncorrecto() {
		
	}
	
	public MailIncorrecto(String m) {
		
		super(m);
		
	}
	
}

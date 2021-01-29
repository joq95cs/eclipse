package graficos;

import java.awt.*;

import javax.swing.*;

public class PruebaSpinner {

	public static void main(String[] args) {
		
		MarcoSpinner marco = new MarcoSpinner();
		
		marco.setVisible(true);

	}

}

class MarcoSpinner extends JFrame {
	
	public MarcoSpinner() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Spinners");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaSpinner lamina = new LaminaSpinner();
		
		add(lamina);
		
	}
	
}

class LaminaSpinner extends JPanel {
	
	public LaminaSpinner() {
		
		//JSpinner spinner = new JSpinner(new SpinnerDateModel()); //Agrega la fecha y la hora
		
		//String[] lista = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		//String[] lista = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		//JSpinner spinner = new JSpinner(new SpinnerListModel(lista));
		
		Dimension d = new Dimension(200, 20);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
			
			public Object getNextValue() {
				
				return super.getPreviousValue(); //Indicamos que en lugar de que regrese el valor siguiente regrese el anterior
				
			}
			
			public Object getPreviousValue() {
				
				return super.getNextValue();
				
			}
			
		} );
		
		spinner.setPreferredSize(d);
		
		add(spinner);
		
	}
	
	/*private class ModeloSpinner extends SpinnerNumberModel {
		
		public ModeloSpinner() {
			
			super(5, 0, 10, 1); //Llama al constructor de SpinnerNumerModel
			
		}
		
		public Object getNextValue() {
			
			return super.getPreviousValue(); //Indicamos que en lugar de que regrese el valor siguiente regrese el anterior
			
		}
		
		public Object getPreviousValue() {
			
			return super.getNextValue();
			
		}
		
	}*/
	
}
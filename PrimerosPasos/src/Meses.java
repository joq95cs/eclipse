import javax.swing.JOptionPane;

public class Meses {
	
	enum Mes{
		
		ENERO(31), FEBRERO(28), MARZO(31), ABRIL(30), MAYO(31), JUNIO(30),
		JULIO(31), AGOSTO(31), SEMPTIEMBRE(30), OCTUBRE(31), NOVIEMBRE(30), DICIEMBRE(31);

		private Mes(int cantidad_dias) {
			
			this.cantidad_dias = cantidad_dias;
			
		}
		
		public int getDias() {
			
			return cantidad_dias;
			
		}
		
		private int cantidad_dias;
	}

	public static void main(String[] args) {
		
		String entrada = JOptionPane.showInputDialog("Ingrese su mes de nacimiento").toUpperCase();
		
		Mes mes_nacimiento = Enum.valueOf(Mes.class, entrada);
		
		System.out.println("Su mes de nacimiento tiene: " + mes_nacimiento.getDias() + " días");
		
	}
	
}

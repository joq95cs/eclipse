import javax.swing.JOptionPane;

public class UsoSwitch {
	
	public static void main(String[] args) {
		
		byte opcion = Byte.parseByte(JOptionPane.showInputDialog("Ingrese número de su mes de nacimiento"));
		
		switch(opcion) {
			
			case 1: 
				
				System.out.println("Tu mes es Enero y tiene 31 días");
				
				break;
				
			case 2:
				
				System.out.println("Tu mes es Febrero y tiene 28 días y 29 cada 4 años");
				
				break;
				
			case 3:
				
				System.out.println("Tu mes es Marzo y tiene 31 días");
				
				break;
				
			case 4:
				
				System.out.println("Tu mes es Abril y tiene 30 días");
				
				break;
				
			case 5:
				
				System.out.println("Tu mes es Mayo y tiene 31 días");
				
				break;
				
			case 6:
				
				System.out.println("Tu mes es Junio y tiene 30 días");
				
				break;
				
			case 7:
				
				System.out.println("Tu mes es Julio y tiene 31 días");
				
				break;
				
			case 8:
				
				System.out.println("Tu mes es Agosto y tiene 31 días");
				
				break;
				
			case 9:
				
				System.out.println("Tu mes es Septiembre y tiene 30 días");
				
				break;
				
			case 10:
				
				System.out.println("Tu mes es Octubre y tiene 31 días");
				
				break;
				
			case 11: 
				
				System.out.println("Tu mes es Noviembre y tiene 30 días");
				
				break;
				
			case 12:
				
				System.out.println("Tu mes es Diciembre y tiene 31 días");
				
				break;
			
			}
		
	}
	
}

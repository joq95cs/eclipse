import javax.swing.JOptionPane;

public class UsoSwitch {
	
	public static void main(String[] args) {
		
		byte opcion = Byte.parseByte(JOptionPane.showInputDialog("Ingrese n�mero de su mes de nacimiento"));
		
		switch(opcion) {
			
			case 1: 
				
				System.out.println("Tu mes es Enero y tiene 31 d�as");
				
				break;
				
			case 2:
				
				System.out.println("Tu mes es Febrero y tiene 28 d�as y 29 cada 4 a�os");
				
				break;
				
			case 3:
				
				System.out.println("Tu mes es Marzo y tiene 31 d�as");
				
				break;
				
			case 4:
				
				System.out.println("Tu mes es Abril y tiene 30 d�as");
				
				break;
				
			case 5:
				
				System.out.println("Tu mes es Mayo y tiene 31 d�as");
				
				break;
				
			case 6:
				
				System.out.println("Tu mes es Junio y tiene 30 d�as");
				
				break;
				
			case 7:
				
				System.out.println("Tu mes es Julio y tiene 31 d�as");
				
				break;
				
			case 8:
				
				System.out.println("Tu mes es Agosto y tiene 31 d�as");
				
				break;
				
			case 9:
				
				System.out.println("Tu mes es Septiembre y tiene 30 d�as");
				
				break;
				
			case 10:
				
				System.out.println("Tu mes es Octubre y tiene 31 d�as");
				
				break;
				
			case 11: 
				
				System.out.println("Tu mes es Noviembre y tiene 30 d�as");
				
				break;
				
			case 12:
				
				System.out.println("Tu mes es Diciembre y tiene 31 d�as");
				
				break;
			
			}
		
	}
	
}

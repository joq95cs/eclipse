package tap;

import java.awt.event.*;

import javax.swing.*;

public class OyenteVenta extends MouseAdapter {
	
	public OyenteVenta() {
		
		impresion = "DETALLES DE LAS VENTAS";
		
		contador = 1;
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == botonIVA) {
			
			monto = Double.parseDouble(LaminaVenta.getCampoMonto().getText());
			
			iva = monto * 0.16;
			
			total = iva + monto;
			
			campoIVA = LaminaVenta.getCampoIVA();
			
			campoIVA.setText("" + iva);
			
			campoTotal = LaminaVenta.getCampoTotal();
			
			campoTotal.setText("" + total);
			
		} else if(e.getSource() == botonPagar) {
			
			pago = Double.parseDouble(LaminaVenta.getCampoPago().getText());
			
			if(pago >= total) {
				
				cambio = pago - total;
				
				campoCambio = LaminaVenta.getCampoCambio();
				
				campoCambio.setText("" + cambio);
				
				impresion += "\n\nVENTA " + contador + "\n\nMonto: $" + monto + "\nIVA: $" + iva + "\nTotal: $" + total + "\nPago: $" + pago + "\nCambio: $" + cambio;
				
				areaImpresion.setText(impresion);
				
				contador++;
				
			} else {
				
				System.out.println("El monto de pago ingresado es insuficiente...");
				
			}
			
		} else {
			
			impresion = "DETALLES DE LAS VENTAS";
			
			contador = 1;
			
			areaImpresion.setText("DETALLES DE LAS VENTAS");
			
		}
		
	}
	
	public void setBotonIVA(JButton bi) {
		
		botonIVA = bi;
		
	}
	
	public void setBotonPagar(JButton bp) {
		
		botonPagar = bp;
		
	}
	
	public void setAreaImpresion(JTextArea ai) {
		
		areaImpresion = ai;
		
	}
	
	private double monto;
	
	private double iva;
	
	private double total;
	
	private double pago;
	
	private double cambio;
	
	private JButton botonIVA;
	
	private JButton botonPagar;
	
	private JTextField campoIVA;
	
	private JTextField campoTotal;
	
	private JTextField campoCambio;
	
	private JTextArea areaImpresion;

	private String impresion;
	
	private int contador;
	
}

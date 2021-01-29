package tema_4;

import java.util.*;

public class Inventarios {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("¡BIENVENIDO!\n\n");
		
		System.out.print("A) Modelo básico de lote económico de pedido sin faltantes (EOQ)"
		+ "\nB) Modelo con reabastecimiento instantáneo en un periodo de tiempo y sin faltantes (EOQ con R)");
		
		System.out.print("\n\nElija un método: ");
		
		String opcion = entrada.next().toUpperCase();
		
		if(opcion.equals("A")) {
			
			ModeloEOQ eoq = new ModeloEOQ();
			
			System.out.print("\nA) Diaria\nB) Semanal\nC) Mensual\nD) Anual");
			
			System.out.print("\n\nElija un tipo de demanda: ");
			
			String opcion_demanda = entrada.next().toUpperCase();
			
			if(opcion_demanda.equals("A")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoq.setD(entrada.nextDouble() * 365);
				
			}
			
			if(opcion_demanda.equals("B")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoq.setD(entrada.nextDouble() * 52);
				
			}
			
			if(opcion_demanda.equals("C")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoq.setD(entrada.nextDouble() * 12);
				
			}
			
			if(opcion_demanda.equals("D")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoq.setD(entrada.nextDouble());
					
			}
			
			System.out.print("Ingrese costo unitario (p): ");
			
			eoq.setP(entrada.nextDouble());
			
			System.out.print("Ingrese costo del pedido (k): ");
			
			eoq.setK(entrada.nextDouble());
			
			System.out.print("\nA) Directo\nB) Porcentaje sobre el costo unitario");
			
			System.out.print("\n\nElija una opción para costo de retención: ");
			
			String opcion_retencion = entrada.next().toUpperCase();
			
			if(opcion_retencion.equals("A")) {
				
				System.out.print("\nIngrese costo de retención (h): ");
				
				eoq.setH(entrada.nextDouble());
				
			}
			
			if(opcion_retencion.equals("B")) {
				
				System.out.print("\nIngrese porcentaje sobre el costo unitario (h): ");
				
				eoq.setH(entrada.nextDouble()/100 * eoq.getP());
				
			}
			
			System.out.print("\nRESULTADOS (ANUALIZADOS)\n\n");
			
			eoq.generarQAsterisco();
			
			eoq.generarPeriodicidad();
			
			eoq.generarCostoTotal();
			
			System.out.print("Tamaño del pedido: " + (int)eoq.getQAsterisco() + " unidad(es)");
			
			System.out.print("\nPeriodicidad: " + (int)eoq.getPeriodicidad() + " pedido(s) al año, 1 pedido cada " + (int)(12/eoq.getPeriodicidad()) + " mes(es)");
			
			System.out.print("\nCosto total: $ " + eoq.getCostoTotal());
			
			System.out.print("\n\nFIN\n");
			
		}

		if(opcion.equals("B")) {
			
			ModeloEOQR eoqr = new ModeloEOQR();
			
			System.out.print("\nA) Diaria\nB) Semanal\nC) Mensual\nD) Anual");
			
			System.out.print("\n\nElija un tipo de demanda: ");
			
			String opcion_demanda = entrada.next().toUpperCase();
			
			if(opcion_demanda.equals("A")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoqr.setD(entrada.nextDouble() * 365);
				
			}
			
			if(opcion_demanda.equals("B")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoqr.setD(entrada.nextDouble() * 52);
				
			}
			
			if(opcion_demanda.equals("C")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoqr.setD(entrada.nextDouble() * 12);
				
			}
			
			if(opcion_demanda.equals("D")) {
				
				System.out.print("\nIngrese demanda (D): ");
				
				eoqr.setD(entrada.nextDouble());
					
			}
			
			System.out.print("Ingrese costo unitario (p): ");
			
			eoqr.setP(entrada.nextDouble());
			
			System.out.print("Ingrese costo del pedido (k): ");
			
			eoqr.setK(entrada.nextDouble());
			
			System.out.print("\nA) Directo\nB) Porcentaje sobre el costo unitario");
			
			System.out.print("\n\nElija una opción para costo de retención: ");
			
			String opcion_retencion = entrada.next().toUpperCase();
			
			if(opcion_retencion.equals("A")) {
				
				System.out.print("\nIngrese costo de retención (h): ");
				
				eoqr.setH(entrada.nextDouble());
				
			}
			
			if(opcion_retencion.equals("B")) {
				
				System.out.print("\nIngrese porcentaje sobre el costo unitario (h): ");
				
				eoqr.setH(entrada.nextDouble()/100 * eoqr.getP());
				
			}
			
			System.out.print("Ingrese tiempo de entrega en días (L): ");
			
			eoqr.setL(entrada.nextDouble());
			
			System.out.print("\nRESULTADOS\n\n");
			
			eoqr.generarQAsterisco();
			
			eoqr.generarPeriodicidad();
			
			eoqr.generarCostoTotal();
			
			eoqr.generarR();
			
			eoqr.generarT();
			
			System.out.print("Tamaño del pedido: " + (int)eoqr.getQAsterisco() + " unidad(es)");
			
			System.out.print("\nPunto de reorden: " + (int)eoqr.getR() + " unidad(es)");
			
			System.out.print("\nTiempo de consumo del inventario: " + (int)eoqr.getT() + " día(s)");
			
			System.out.print("\nPeriodicidad: " + (int)eoqr.getPeriodicidad() + " pedido(s) al año, 1 pedido cada " + (int)(12/eoqr.getPeriodicidad()) + " mes(es)");
			
			System.out.print("\nCosto total: $ " + eoqr.getCostoTotal());
			
			System.out.print("\n\nFIN\n");
			
		}
		
	}
	
}

class ModeloEOQ {
	
	public void setQAsterisco(double q_asterisco) {
		
		this.q_asterisco = q_asterisco;
		
	}
	
	public void setPeriodicidad(double periodicidad) {
		
		this.periodicidad = periodicidad;
		
	}
	
	public void setCostoTotal(double costo_total) {
		
		this.costo_total = costo_total;
		
	}
	
	public void setK(double k) {
		
		this.k = k;
		
	}
	
	public void setH(double h) {
		
		this.h = h;
		
	}
	
	public void setD(double d) {
		
		this.d = d;
		
	}
	
	public void setP(double p) {
		
		this.p = p;
		
	}
	
	public double getQAsterisco() {
		
		return q_asterisco;
		
	}
	
	public double getPeriodicidad() {
		
		return periodicidad;
		
	}
	
	public double getCostoTotal() {
		
		return costo_total;
		
	}
	
	public double getK() {
		
		return k;
		
	}
	
	public double getH() {
		
		return h;
		
	}
	
	public double getD() {
		
		return d;
		
	}
	
	public double getP() {
		
		return p;
		
	}
	
	public void generarQAsterisco() {
		
		q_asterisco = Math.round(Math.sqrt((2*k*d) / h));
		
	}
	
	public void generarPeriodicidad() {
		
		periodicidad = Math.round((d / q_asterisco));
		
	}
	
	public void generarCostoTotal() {
		
		costo_total = ((k*d)/q_asterisco) + (p*d) + ((h*q_asterisco)/2);
		
	}
	
	private double q_asterisco;
	
	private double periodicidad;
	
	private double costo_total;
	
	private double k;
	
	private double h;
	
	private double d;
	
	private double p;
	
}

class ModeloEOQR extends ModeloEOQ {
	
	public void setR(double r) {
		
		this.r = r;
		
	}
	
	public void setL(double l) {
		
		this.l = l;
		
	}
	
	public void setT(double t) {
		
		this.t = t;
		
	}
	
	public double getR() {
		
		return r;
		
	}
	
	public double getL() {
		
		return l;
		
	}
	
	public double getT() {
		
		return t;
		
	}
	
	public void generarR() {
		
		 r = Math.round(((getD()*getL()) / 365));
		
	}
	
	public void generarT() {
		
		t = Math.round(365 * (getQAsterisco()/getD()));
		
	}
	
	private double r;
	
	private double l;
	
	private double t;
	
}
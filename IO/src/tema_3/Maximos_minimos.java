package tema_3;

import java.util.*;

public class Maximos_minimos {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("¡BIENVENIDO!\n");
        
        System.out.println("Función Objetivo: Ax^2 + Bx + C(x + D)^2 + E\n");
        
        System.out.print("Ingrese tipo (MAX/MIN): ");
        
        String tipo = entrada.next().toUpperCase();
        
        Ecuacion funcion_objetivo = new Ecuacion();
        
        System.out.print("\nIngrese valor de A: ");
        
        funcion_objetivo.setA(entrada.nextDouble());
        
        System.out.print("Ingrese valor de B: ");
        
        funcion_objetivo.setB(entrada.nextDouble());
        
        System.out.print("Ingrese valor de C: ");
        
        funcion_objetivo.setC(entrada.nextDouble());
        
        System.out.print("Ingrese valor de D: ");
        
        funcion_objetivo.setD(entrada.nextDouble());
        
        System.out.print("Ingrese valor de E: ");
        
        funcion_objetivo.setE(entrada.nextDouble());
        
        funcion_objetivo.setCoeficiente(funcion_objetivo.getA()+funcion_objetivo.getC());
        
        funcion_objetivo.setCoeficiente(funcion_objetivo.getB()+2*funcion_objetivo.getC()*funcion_objetivo.getD());
        
        funcion_objetivo.setCoeficiente(funcion_objetivo.getC()*Math.pow(funcion_objetivo.getD(), 2)+funcion_objetivo.getE());
        
        Ecuacion derivada_1 = new Ecuacion();
        
        derivada_1.setA(funcion_objetivo.getA());
        
        derivada_1.setB(funcion_objetivo.getB());
        
        derivada_1.setC(funcion_objetivo.getC());
        
        derivada_1.setD(funcion_objetivo.getD());
        
        derivada_1.setE(0);
        
        derivada_1.setCoeficiente(2*derivada_1.getA()+2*derivada_1.getC());
        
        derivada_1.setCoeficiente(derivada_1.getB()+2*derivada_1.getC()*derivada_1.getD());
        
        Ecuacion derivada_2 = new Ecuacion();
        
        derivada_2.setA(funcion_objetivo.getA());
        
        derivada_2.setC(funcion_objetivo.getC());
        
        derivada_2.setCoeficiente(2*derivada_2.getA()+2*derivada_2.getC());
        
        System.out.print("\nA) a < x < b\nB) a =< x <= b\nC) a < x <= b\nD) a =< x < b\n\nSeleccione tipo de límites: ");
        
        String tipo_limites = entrada.next().toUpperCase();
        
        System.out.print("\nIngrese valor de límite a: ");
        
        double limite_a = entrada.nextDouble();
        
        System.out.print("Ingrese valor de límite b: ");
        
        double limite_b = entrada.nextDouble();
        
        System.out.println("\nRESULTADO\n");
        
        if(tipo.equals("MAX")) {
                
            Casos.caso1(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), derivada_2.getCoeficientes());
            
            if(Casos.getTipoX0().equals("MAXIMO") && Casos.getTieneSolucion()) {
                    
                System.out.println("x: " + Casos.getX0() + "\nCaso: 1" + "\nCondición: " + Casos.getCondicion());
                    
            }
            
            else {
                
                Casos.caso2(tipo_limites, limite_a, limite_b, funcion_objetivo.getCoeficientes(), tipo);
                
                if(Casos.getTipoX0().equals("MAXIMO")) {
                    
                    System.out.println("x: " + Casos.getX0() + "\nCaso: 2" + "\nCondición: " + Casos.getCondicion()); 
                    
                }
                
                else {
                    
                    Casos.caso3(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), tipo);
                    
                    if(Casos.getTipoX0().equals("MAXIMO")) {
                        
                        System.out.println("x: " + Casos.getX0() + "\nCaso: 3" + "\nCondición: " + Casos.getCondicion());
                        
                    }
                    
                    else {
                        
                        System.out.println("El problema no tiene solución...");
                        
                    }
                    
                }
                
            }
            
        }
        
        if(tipo.equals("MIN")) {
            
            Casos.caso1(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), derivada_2.getCoeficientes());
            
            if(Casos.getTipoX0().equals("MINIMO") && Casos.getTieneSolucion()) {
                
                System.out.println("x: " + Casos.getX0() + "\nCaso: 1" + "\nCondición: " + Casos.getCondicion());
                
            }
            
            else {
                
                Casos.caso2(tipo_limites, limite_a, limite_b, funcion_objetivo.getCoeficientes(), tipo);
                
                if(Casos.getTipoX0().equals("MINIMO")) {
                    
                    System.out.println("x: " + Casos.getX0() + "\nCaso: 2" + "\nCondición: " + Casos.getCondicion()); 
                    
                }
                
                else {
                    
                    Casos.caso3(tipo_limites, limite_a, limite_b, derivada_1.getCoeficientes(), tipo);
                            
                    if(Casos.getTipoX0().equals("MINIMO")) {
                        
                        System.out.println("x: " + Casos.getX0() + "\nCaso: 3" + "\nCondición: " + Casos.getCondicion());
                        
                    }
                    
                    else {
                        
                        System.out.println("El problema no tiene solución...");
                        
                    }
                    
                }
                
            }
            
        }
        
        System.out.println("\nFIN");
        
    }
    
}

class Ecuacion {
    
    public void setA(double a) {
        
        this.a = a;
        
    }
    
    public void setB(double b) {
        
        this.b = b;
        
    }
    
    public void setC(double c) {
        
        this.c = c;
        
    }
    
    public void setD(double d) {
        
        this.d = d;
        
    }
    
    public void setE(double e) {
        
        this.e = e;
        
    }
    
    public double getA() {
        
        return a;
        
    }
    
    public double getB() {
        
        return b;
        
    }
    
    public double getC() {
        
        return c;
        
    }
    
    public double getD() {
        
        return d;
        
    }
    
    public double getE() {
        
        return e;
        
    }
    
    public void setCoeficiente(double valor_coeficiente) {
        
        coeficientes.add(valor_coeficiente);
        
    }
    
    public double getCoeficiente(int indice) {
        
        return coeficientes.get(indice);
        
    }
    
    public double[] getCoeficientes() {
        
        double[] aux_coeficientes = new double[coeficientes.size()];
        
        for(int i=0; i<coeficientes.size(); i++) {
            
            aux_coeficientes[i] = coeficientes.get(i);
            
        }
        
        return aux_coeficientes;
    }
    
    private ArrayList <Double> coeficientes = new ArrayList <Double>();
    
    private double a, b, c, d, e;
    
}

class Casos {
    
    public static void caso1(String tipo_limites, double limite_a, double limite_b, double[] derivada_1, double[] derivada_2) {
        
        switch(tipo_limites) {
            
            case "A":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
            
        }
        
        x0 = -1*derivada_1[1] / derivada_1[0];
        
        tiene_solucion = x0>=Casos.limite_a && x0<=Casos.limite_b;
        
        if(derivada_2[0] > 0) {
            
            tipo_x0 = "MINIMO";
            
            condicion = "Si f'(x0) = 0 y f''(x0) > 0, x0 es un mínimo local";
            
        }
        
        else if(derivada_2[0] < 0) {
            
            tipo_x0 = "MAXIMO";
            
            condicion = "Si f'(x0) = 0 y f''(x0) < 0, x0 es un máximo local";
            
        }
        
        else {
            
            tipo_x0 = "NINGUNO";
            
        }
        
    }
    
    public static void caso2(String tipo_limites, double limite_a, double limite_b, double[] funcion_objetivo, String tipo) {
        
        switch(tipo_limites) {
            
            case "A": 
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b + 0.1;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a - 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
            
        }
        
        if(tipo.equals("MAX")) {
        	
            x0 = limite_a;
            
            double x1 = x0 - 0.1;
            
            double x2 = x0 + 0.1;
            
            double f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
            
            double f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
            
            double f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
            
            if(f_x0>f_x1 && f_x0<f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0<f_x1 && f_x0>f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0>=f_x1 && f_x0>=f_x2) {
                
                tipo_x0 = "MAXIMO";
                
                condicion = "Si f(x0) >= f(x1) y f(x0) >= f(x2), x0 es un máximo local";
                
            }
            
            if(f_x0<=f_x1 && f_x1<=f_x2) {
                
                tipo_x0 = "MINIMO";
                
            }
            
            if(!tipo_x0.equals("MAXIMO")) {
            	
            	x0 = limite_b;
                
                x1 = x0 - 0.1;
                
                x2 = x0 + 0.1;
                
                f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
                
                f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
                
                f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
                
                if(f_x0>f_x1 && f_x0<f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0<f_x1 && f_x0>f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0>=f_x1 && f_x0>=f_x2) {
                    
                    tipo_x0 = "MAXIMO";
                    
                    condicion = "Si f(x0) >= f(x1) y f(x0) >= f(x2), x0 es un máximo local";
                    
                }
                
                if(f_x0<=f_x1 && f_x1<=f_x2) {
                    
                    tipo_x0 = "MINIMO";
                    
                }
            	
            }	
            
        }
        
        if(tipo.equals("MIN")) {
        	
        	x0 = limite_a;
            
            double x1 = x0 - 0.1;
            
            double x2 = x0 + 0.1;
            
            double f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
            
            double f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
            
            double f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
            
            if(f_x0>f_x1 && f_x0<f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0<f_x1 && f_x0>f_x2) {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(f_x0>=f_x1 && f_x0>=f_x2) {
                
                tipo_x0 = "MAXIMO";
                
            }
            
            if(f_x0<=f_x1 && f_x1<=f_x2) {
                
                tipo_x0 = "MINIMO";
                
                condicion = "Si f(x0) <= f(x1) y f(x0) <= f(x2), x0 es un minimo local";
                
            }
            
            if(!tipo_x0.equals("MINIMO")) {
            	
                x0 = limite_a;
                
                x1 = x0 - 0.1;
                
                x2 = x0 + 0.1;
                
                f_x0 = funcion_objetivo[0]*Math.pow(x0, 2) + funcion_objetivo[1]*x0 + funcion_objetivo[2];
                
                f_x1 = funcion_objetivo[0]*Math.pow(x1, 2) + funcion_objetivo[1]*x1 + funcion_objetivo[2];
                
                f_x2 = funcion_objetivo[0]*Math.pow(x2, 2) + funcion_objetivo[1]*x2 + funcion_objetivo[2];
                
                if(f_x0>f_x1 && f_x0<f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0<f_x1 && f_x0>f_x2) {
                    
                    tipo_x0 = "NINGUNO";
                    
                }
                
                if(f_x0>=f_x1 && f_x0>=f_x2) {
                    
                    tipo_x0 = "MAXIMO";
                    
                }
                
                if(f_x0<=f_x1 && f_x1<=f_x2) {
                    
                    tipo_x0 = "MINIMO";
                    
                    condicion = "Si f(x0) <= f(x1) y f(x0) <= f(x2), x0 es un minimo local";
                    
                }
            	
            }
            
        }
        
    }
    
    public static void caso3(String tipo_limites, double limite_a, double limite_b, double[] derivada_1, String tipo) {
        
        switch(tipo_limites) {
            
            case "A":
                
                Casos.limite_a = limite_a + 0.1;
                
                Casos.limite_b = limite_b - 0.1;
                
                break;
                
            case "B":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "C":
                
                Casos.limite_a = limite_a + 0.1;
                
                Casos.limite_b = limite_b;
                
                break;
                
            case "D":
                
                Casos.limite_a = limite_a;
                
                Casos.limite_b = limite_b - 0.1;
            
        }
            
        double derivada_1_a = derivada_1[0]*Casos.limite_a + derivada_1[1];
        
        double derivada_1_b = derivada_1[0]*Casos.limite_b + derivada_1[1];
        
        if(tipo.equals("MAX")) {
            
            if(derivada_1_a > 0) {
                
                tipo_x0 = "MINIMO";
                
            }
            
            else if(derivada_1_a < 0) {
                
                tipo_x0 = "MAXIMO";
                
                condicion = "Si f'(a) < 0, a es un máxmimo local";
                
                x0 = Casos.limite_a;
                
            }
            
            else {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(!tipo_x0.equals("MAXIMO")) {
            	
            	if(derivada_1_b > 0) {
                    
                    tipo_x0 = "MAXIMO";
                    
                    condicion = "Si f'(b) > 0, b es un máximo local";
                    
                    x0 = Casos.limite_b;
                    
                }
                
                else if(derivada_1_b < 0) {
                    
                    tipo_x0 = "MINIMO";
                    
                }
            	
                else {
                	
                	tipo_x0 = "NINGUNO";
                	
                }
            	
            }
            
        }
        
        if(tipo.equals("MIN")) {
            
            if(derivada_1_a > 0) {
                
                tipo_x0 = "MINIMO";
                
                condicion = "Si f'(a) > 0, a es un mínimo local";
                
                x0 = Casos.limite_a;
                
            }
            
            else if(derivada_1_a < 0) {
                
                tipo_x0 = "MAXIMO";
                
            }
            
            else {
                
                tipo_x0 = "NINGUNO";
                
            }
            
            if(!tipo_x0.equals("MINIMO")) {
            	
            	 if(derivada_1_b > 0) {
                     
                     tipo_x0 = "MAXIMO";
                     
                 }
                 
                 else if(derivada_1_b < 0) {
                     
                     tipo_x0 = "MINIMO";
                     
                     condicion = "Si f'(b) < 0, b es un minimo local";
                     
                     x0 = Casos.limite_b;
                     
                 }
            	 
                 else {
                	 
                	 tipo_x0 = "NINGUNO";
                	 
                 }
            	
            }
            
        }
        
    }
    
    public static double getX0() {
        
        return x0;
        
    }
    
    public static String getTipoX0() {
        
        return tipo_x0.toUpperCase();
        
    }
    
    public static String getCondicion() {
        
        return condicion;
        
    }
    
    public static boolean getTieneSolucion() {
        
        return tiene_solucion;
        
    }
    
    private static double x0, limite_a, limite_b;
    
    private static String tipo_x0, condicion;
    
    private static boolean tiene_solucion;
    
}
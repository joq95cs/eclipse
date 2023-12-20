package tema_5;

import java.util.*;

public class LineasDeEspera {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("BIENVENIDO\n\n");
        
        System.out.print("1) Método determinístico\n2) Método probabilístico (Poisson)\n\nElija un método: ");
        
        int opcionMetodo = entrada.nextInt();
        
        if(opcionMetodo == 1) {
            
            FormulasLE mDet = new FormulasLE();    
            
            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo para capturar datos: ");
            
            mDet.setOpcionTiempo(entrada.nextInt());
            
            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad para mostrar resultados de tiempos: ");
            
            mDet.setOpcionTiempoRes(entrada.nextInt());
            
            System.out.print("\nIngrese no. de clientes que se atienden por " + mDet.decirUTiempo() + " (miu): ");
            
            mDet.setMiu(entrada.nextInt());
            
            System.out.print("Ingrese no. de clientes que llegan al sistema por " + mDet.decirUTiempo() + " (landa): ");
            
            mDet.setLanda(entrada.nextInt());
            
            System.out.print("\nRESULTADOS\n");
            
            if(mDet.tieneSolucion()) {
                
                mDet.fijarW();
                
                mDet.fijarWq();
                
                mDet.fijarWs();
                
                mDet.fijarL();
                
                mDet.fijarLq();
                
                mDet.fijarLs();
                
                System.out.print("\nNo. promedio de clientes que se atienden en el sistema por " + mDet.decirUTiempo() + " (L): " + mDet.getL());
                
                System.out.print("\nNo. promedio de clientes formados en la fila por " + mDet.decirUTiempo() + " (Lq): " + mDet.getLq());
                
                System.out.print("\nNo. promedio de clientes en servicio por " + mDet.decirUTiempo() + " (Ls): " + mDet.getLs());
                
                System.out.print("\nTiempo promedio que pasa un cliente en el sistema (w): " + mDet.getW() + " " + mDet.decirUTiempoR() + "(s)");
                
                System.out.print("\nTiempo promedio que pasa un cliente formado en la fila (wq): " + mDet.getWq() + " " + mDet.decirUTiempoR() + "(s)");
                
                System.out.print("\nTiempo promedio que pasa un cliente en servicio (ws): " + mDet.getWs() + " " + mDet.decirUTiempoR() + "(s)\n");
                
            }
            
            else {
                
                System.out.print("\nNo existe solución al problema ya que miu no es mayor que landa...\n");
                
            }
                
        }
        
        if(opcionMetodo == 2) {
            
            FormulasLE mPro = new FormulasLE();    
            
            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo: ");
            
            mPro.setOpcionTiempo(entrada.nextInt());
            
            System.out.print("\n1) Minutos\n2) Horas\n3) Días\n\nElija una unidad de tiempo para mostrar resultados: ");
            
            mPro.setOpcionTiempoRes(entrada.nextInt());
            
            System.out.print("\nIngrese no. de clientes que se atienden por " + mPro.decirUTiempo() + " (miu): ");
            
            mPro.setMiu(entrada.nextInt());
            
            System.out.print("Ingrese no. de clientes que llegan al sistema por " + mPro.decirUTiempo() + " (landa): ");
            
            mPro.setLanda(entrada.nextInt());
            
            if(mPro.tieneSolucion()) {
                
                mPro.fijarP();
                
                mPro.fijarP0();
                
                mPro.fijarP1();
                
                mPro.fijarLs2();
                
                mPro.fijarLq2();
                
                mPro.fijarWq();
                
                mPro.fijarWs2();
                
                System.out.print("\n¿Deseas conocer la probabilidad de que haya más de n clientes en la fila? (S/N): ");
                
                String opcionPro = entrada.next().toUpperCase();
                
                if(opcionPro.equals("S")) {
                    
                    System.out.print("Ingrese valor de n: ");
                    
                    mPro.setN(entrada.nextInt());
                    
                    mPro.definirPn();
                    
                    mPro.fijarPn();
                    
                    mPro.fijarPm();
                    
                    mPro.fijarPm2();
                    
                }
                
                System.out.print("\nRESULTADOS\n\n");
                
                System.out.print("Porcentaje de probabilidad de tiempo que trabaja el servidor (P): " + mPro.getP() + "%");
                
                System.out.print("\nPorcentaje de probabilidad de tiempo de que no haya clientes en el sistema (P0): " + mPro.getP0() + "%");
                
                System.out.print("\nProbabilidad de que un cliente se encuentre en el sistema en cualquier momento (P1): " + mPro.getP1() + "%");
                
                System.out.print("\nNo. promedio de clientes en servicio por " + mPro.decirUTiempo() + " (Ls): " + mPro.getLs2());
                
                System.out.print("\nNo. promedio de clientes formados en la fila por " + mPro.decirUTiempo() + " (Lq): " + mPro.getLq2());
                
                System.out.print("\nTiempo promedio que pasa el cliente formado (wq): " + mPro.getWq() + " " + mPro.decirUTiempoR() + "(s)");
                
                System.out.print("\nTiempo promedio que pasa el cliente en servicio (ws): " + mPro.getWs2() + " " + mPro.decirUTiempoR() + "(s)");
                
                if(opcionPro.equals("S")) {
                    
                    System.out.print("\nProbabilidad de que haya más de " + mPro.getN() + " clientes en la fila: " + mPro.getPm2() + "%");
                    
                }
                
                System.out.println();
                
            }
            
            else {
                
                System.out.print("\nRESULTADOS\n\n");
                
                System.out.print("No existe solución al problema ya que miu no es mayor que landa...\n");
                
            }
            
        }
        
        System.out.print("\nFIN\n");
        
    }
    
}

class FormulasLE {
    
    public void setOpcionTiempo(int opcionTiempo) {
        
        this.opcionTiempo = opcionTiempo;
        
        if(opcionTiempo == 3) {
            
            Scanner entrada = new Scanner(System.in);
            
            System.out.print("\nIngrese no. de horas laborables al día: ");
            
            horasLab = entrada.nextDouble();
            
        }
        
    }
    
    public void setOpcionTiempoRes(int opcionTiempoRes) {
        
        this.opcionTiempoRes = opcionTiempoRes;
        
        if(opcionTiempoRes == 3) {
            
            if(horasLab == 0) {
                
                Scanner entrada = new Scanner(System.in);
                
                System.out.print("\nIngrese no. de horas laborables al día: ");
                
                horasLab = entrada.nextDouble();
                
            }
            
        }
        
    }
    
    public void setMiu(int miu) {
        
        this.miu = (double)miu;
        
    }
    
    public void setLanda(int landa) {
        
        this.landa = (double)landa;
        
    }
    
    public void setN(int n) {
        
        this.n = n;
        
    }
    
    public int getL() {  
        
        return (int)Math.round(l);
        
    }
    
    public int getLq() {
        
        return (int)Math.round(lq);
        
    }
    
    public int getLs() {        
        
        return (int)Math.round(ls);
        
    }
    
    public double getW() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return w;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return w/60;
                
            }
            
            return (w/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return w*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return w;
                
            }
            
            return w/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (w*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return w*horasLab;
                
        }
            
        return w;
        
    }
    
    public double getWq() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return wq;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return wq/60;
                
            }
            
            return (wq/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return wq*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return wq;
                
            }
            
            return wq/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (wq*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return wq*horasLab;
                
        }
            
        return wq;
        
    }
    
    public double getWs() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return ws;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws/60;
                
            }
            
            return (ws/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return ws*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws;
                
            }
            
            return ws/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (ws*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return ws*horasLab;
                
        }
            
        return ws;
        
    }
    
    public double getP() {
        
        return p*100;
        
    }
    
    public double getP0() {
        
        return p0*100;
        
    }
    
    public int getLs2() {
        
        return (int)Math.round(ls2);
        
    }
    
    public int getLq2() {
        
        return (int)Math.round(lq2);
        
    }
    
    public double getWs2() {
        
        if(opcionTiempo == 1) {
            
            if(opcionTiempoRes == 1) {
                
                return ws2;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws2/60;
                
            }
            
            return (ws2/60)/horasLab;
            
        }
        
        if(opcionTiempo == 2) {
            
            if(opcionTiempoRes == 1) {
                
                return ws2*60;
                
            }
            
            if(opcionTiempoRes == 2) {
                
                return ws2;
                
            }
            
            return ws2/horasLab;
            
        }
            
        if(opcionTiempoRes == 1) {
                
            return (ws2*horasLab)*60;
                
        }
            
        if(opcionTiempoRes == 2) {
                
            return ws2*horasLab;
                
        }
            
        return ws2;
        
    }
    
    public double getP1() {
        
        return p1*100;
        
    }
    
    public int getN() {
        
        return n;
        
    }
    
    public double getPm2() {
        
        return pm2*100;
        
    }
    
    public void definirPn() {
        
        pn = new double[n];
        
    }
    
    public void fijarW() {
        
        w = 1/(miu-landa);
        
    }
    
    public void fijarWq() {
        
        wq = landa/(miu*(miu-landa));
        
    }
    
    public void fijarWs() {
        
        ws = w-wq;
        
    }
    
    public void fijarL() {
        
        l = landa*w;
        
    }
    
    public void fijarLq() {
        
        lq = landa*wq;
        
    }
    
    public void fijarLs() {
        
        ls = landa*ws;
        
    }
    
    public void fijarP() {
        
        p = landa/miu;
        
    }
    
    public void fijarP0() {
        
        p0 = 1 - (landa/miu);
        
    }
    
    public void fijarP1() {
        
        p1 = p0*(landa/miu);
        
    }
    
    public void fijarLq2() {
        
        lq2 = Math.pow(landa, 2)/(miu*(miu-landa));
        
    }
    
    public void fijarLs2() {
        
        ls2 = landa/(miu-landa);
        
    }
    
    public void fijarWs2() {
        
        ws2 = 1/(miu-landa);
        
    }
    
    public void fijarPn() {
        
        for(int i=0; i<n; i++) {
            
            pn[i] = p0*Math.pow(landa/miu, i+1);
            
        }
        
    }
    
    public void fijarPm() {
        
        pm = p0;
        
        for(int i=0; i<n; i++) {
            
            pm += pn[i];
            
        }
        
    }
    
    public void fijarPm2() {
        
        pm2 = 1 - pm;
        
    }
    
    public String decirUTiempo() {
        
        if(opcionTiempo == 1) {
            
            return "minuto";
            
        }
        
        if(opcionTiempo == 2) {
            
            return "hora";
            
        }
        
        return "día";
        
    }
    
    public String decirUTiempoR() {
        
        if(opcionTiempoRes == 1) {
            
            return "minuto";
            
        }
        
        if(opcionTiempoRes == 2) {
            
            return "hora";
            
        }
        
        return "día";
        
    }   
    
    public boolean tieneSolucion() {
        
        return miu>landa;
        
    }
    
    private double miu;
    
    private double landa;
    
    private double l;
    
    private double lq;
    
    private double ls;
    
    private double w;
    
    private double wq;
    
    private double ws;
    
    private double horasLab = 0;
    
    private int opcionTiempo;
    
    private int opcionTiempoRes;
    
    private double p;
    
    private double p0;
    
    private double p1;
    
    private double lq2;
    
    private double ls2;
    
    private double ws2;
    
    private int n;
    
    private double[] pn;
    
    private double pm;
    
    private double pm2;
    
}
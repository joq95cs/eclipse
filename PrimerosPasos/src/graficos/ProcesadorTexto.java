package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class ProcesadorTexto {

	public static void main(String[] args) {

		MarcoProcesador marco = new MarcoProcesador();
		
		marco.setVisible(true);
		
	}

}

class MarcoProcesador extends JFrame {
	
	public MarcoProcesador() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Procesador de texto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaProcesador lamina = new LaminaProcesador();
		
		add(lamina);
		
	}
	
}

class LaminaProcesador extends JPanel {
	
	public LaminaProcesador() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar barra = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		
		estilo = new JMenu("Estilo");
		
		tamagno = new JMenu("Tamaño");
		
		configurarItem("Arial", fuente, "Arial", 0, 0);
		
		configurarItem("Courier", fuente, "Courier", 0, 0);
		
		configurarItem("Verdana", fuente, "Verdana", 0, 0);
		
		configurarItem("Negrita", estilo, "", Font.BOLD, 0);
		
		configurarItem("Cursiva", estilo, "", Font.ITALIC, 0);
		
		configurarItem("12", tamagno, "", 0, 12);
		
		configurarItem("16", tamagno, "", 0, 16);
		
		configurarItem("20", tamagno, "", 0, 20);
		
		configurarItem("24", tamagno, "", 0, 24);
		
		barra.add(fuente);
		
		barra.add(estilo);
		
		barra.add(tamagno);
		
		laminaMenu.add(barra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		area = new JTextPane();
		
		add(area, BorderLayout.CENTER);
		
	}
	
	public void configurarItem(String rotulo, JMenu menu, String tipoLetra, int estiloLetra, int tamagnoLetra) {
		
		JMenuItem elemento = new JMenuItem(rotulo);
		
		elemento.addActionListener(new OyenteProcesador(rotulo, tipoLetra, estiloLetra, tamagnoLetra));
		
		menu.add(elemento);
		
	}
	
	private class OyenteProcesador implements ActionListener {
		
		public OyenteProcesador(String elemento, String tipoLetra, int estiloLetra, int tamagnoLetra) {
			
			this.tipoLetra = tipoLetra;
			
			this.estiloLetra = estiloLetra;
			
			this.tamagnoLetra = tamagnoLetra;
			
			this.elemento = elemento;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			fuenteTexto = area.getFont();
			
			if(elemento == "Arial" || elemento == "Courier" || elemento == "Verdana") {
				
				estiloLetra = fuenteTexto.getStyle();
				
				tamagnoLetra = fuenteTexto.getSize();
				
			} else if(elemento == "Cursiva" || elemento == "Negrita") {
				
				if(fuenteTexto.getStyle() == 1 || fuenteTexto.getStyle() == 2) {
					
					estiloLetra = 3;
					
				}
				
				tipoLetra = fuenteTexto.getFontName();
				
				tamagnoLetra = fuenteTexto.getSize();
				
			} else if(elemento == "12" || elemento == "16" || elemento == "20" || elemento == "24") {
				
				estiloLetra = fuenteTexto.getStyle();
				
				tipoLetra = fuenteTexto.getFontName();
				
			}
			
			area.setFont(new Font(tipoLetra, estiloLetra, tamagnoLetra));
			
		}
		
		private String tipoLetra;
		
		private String elemento;
		
		private int estiloLetra, tamagnoLetra;
		
		private Font fuenteTexto;
		
	}
	
	private JTextPane area;
	
	private JMenu fuente, estilo, tamagno;
	
}

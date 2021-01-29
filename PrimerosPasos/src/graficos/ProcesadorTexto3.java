package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.text.*;

public class ProcesadorTexto3 {

	public static void main(String[] args) {

		MarcoProcesador3 marco = new MarcoProcesador3();
		
		marco.setVisible(true);
		
	}

}

class MarcoProcesador3 extends JFrame {
	
	public MarcoProcesador3() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Procesador de texto con check boxes y radio buttons");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaProcesador3 lamina = new LaminaProcesador3();
		
		add(lamina);
		
	}
	
}

class LaminaProcesador3 extends JPanel {
	
	public LaminaProcesador3() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar barra = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		
		estilo = new JMenu("Estilo");
		
		tamagno = new JMenu("Tamaño");
		
		configurarItem("Arial", fuente, "Arial", 0, 0);
		
		configurarItem("Courier", fuente, "Courier", 0, 0);
		
		configurarItem("Verdana", fuente, "Verdana", 0, 0);
		
		/*configurarItem("Negrita", estilo, "", Font.BOLD, 0);
		
		configurarItem("Cursiva", estilo, "", Font.ITALIC, 0);
		
		configurarItem("12", tamagno, "", 0, 12);
		
		configurarItem("16", tamagno, "", 0, 16);
		
		configurarItem("20", tamagno, "", 0, 20);
		
		configurarItem("24", tamagno, "", 0, 24);*/
		
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
		
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		
		estilo.add(cursiva);
		
		ButtonGroup grupo = new ButtonGroup();
		
		JRadioButtonMenuItem t12 = new JRadioButtonMenuItem("12");
		
		JRadioButtonMenuItem t16 = new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem t20 = new JRadioButtonMenuItem("20");
		
		JRadioButtonMenuItem t24 = new JRadioButtonMenuItem("24");
		
		grupo.add(t12);
		
		grupo.add(t16);
		
		grupo.add(t20);
		
		grupo.add(t24);
		
		t12.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
		
		t16.addActionListener(new StyledEditorKit.FontSizeAction("", 16));
		
		t20.addActionListener(new StyledEditorKit.FontSizeAction("", 20));
		
		t24.addActionListener(new StyledEditorKit.FontSizeAction("", 24));
		
		tamagno.add(t12);
		
		tamagno.add(t16);
		
		tamagno.add(t20);
		
		tamagno.add(t24);
		
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
		
		menu.add(elemento);
		
		elemento.addActionListener(new StyledEditorKit.FontSizeAction("", tamagnoLetra));
		
		/*if(estiloLetra == Font.BOLD) {
			
			elemento.addActionListener(new StyledEditorKit.BoldAction());
			
		} else if(estiloLetra == Font.ITALIC) {
			
			elemento.addActionListener(new StyledEditorKit.ItalicAction());
			
		}*/
		
		if(tipoLetra.equals("Arial")) {
			
			elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Arial"));
			
		} else if(tipoLetra.equals("Courier")) {
			
			elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Courier"));
			
		} else if(tipoLetra.equals("Verdana")) {
			
			elemento.addActionListener(new StyledEditorKit.FontFamilyAction("", "Verdana"));
			
		}
		
	}
	
	private JTextPane area;
	
	private JMenu fuente, estilo, tamagno;
	
}

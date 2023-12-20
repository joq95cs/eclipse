package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.text.*;

public class ProcesadorTexto4 {

	public static void main(String[] args) {

		MarcoProcesador4 marco = new MarcoProcesador4();
		
		marco.setVisible(true);
		
	}

}

class MarcoProcesador4 extends JFrame {
	
	public MarcoProcesador4() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Procesador de texto con menú emergente");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaProcesador4 lamina = new LaminaProcesador4();
		
		add(lamina);
		
	}
	
}

class LaminaProcesador4 extends JPanel {
	
	public LaminaProcesador4() {
		
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
		
		/*configurarItem("12", tamagno, "", 0, 12);
		
		configurarItem("16", tamagno, "", 0, 16);
		
		configurarItem("20", tamagno, "", 0, 20);
		
		configurarItem("24", tamagno, "", 0, 24);
		
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
		
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		
		estilo.add(cursiva);*/
		
		ButtonGroup grupo = new ButtonGroup();
		
		JRadioButtonMenuItem t12 = new JRadioButtonMenuItem("12");
		
		JRadioButtonMenuItem t16 = new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem t20 = new JRadioButtonMenuItem("20");
		
		JRadioButtonMenuItem t24 = new JRadioButtonMenuItem("24");
		
		//t24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
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
		
		JPopupMenu menuEmergente = new JPopupMenu();
		
		JMenuItem negritaEmergente = new JMenuItem("Negrita");
		
		JMenuItem cursivaEmergente = new JMenuItem("Cursiva");
		
		negritaEmergente.addActionListener(new StyledEditorKit.BoldAction());
		
		cursivaEmergente.addActionListener(new StyledEditorKit.ItalicAction());
		
		menuEmergente.add(negritaEmergente);
		
		menuEmergente.add(cursivaEmergente);
		
		area.setComponentPopupMenu(menuEmergente);
		
	}
	
	public void configurarItem(String rotulo, JMenu menu, String tipoLetra, int estiloLetra, int tamagnoLetra) {
		
		JMenuItem elemento = new JMenuItem(rotulo);
		
		menu.add(elemento);
		
		elemento.addActionListener(new StyledEditorKit.FontSizeAction("", tamagnoLetra));
		
		if(estiloLetra == Font.BOLD) {
			
			elemento.addActionListener(new StyledEditorKit.BoldAction());
			
			elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			
		} else if(estiloLetra == Font.ITALIC) {
			
			elemento.addActionListener(new StyledEditorKit.ItalicAction());
			
			elemento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
			
		}
		
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

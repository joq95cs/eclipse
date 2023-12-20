package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.text.*;

public class ProcesadorTexto5 {

	public static void main(String[] args) {

		MarcoProcesador5 marco = new MarcoProcesador5();
		
		marco.setVisible(true);
		
	}

}

class MarcoProcesador5 extends JFrame {
	
	public MarcoProcesador5() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4 - 25, ancho/2, alto/2 + 50);
		
		setTitle("Procesador de texto con barra de herramientas");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaProcesador5 lamina = new LaminaProcesador5();
		
		add(lamina);
		
	}
	
}

class LaminaProcesador5 extends JPanel {
	
	public LaminaProcesador5() {
		
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
		
		/*JToolBar barraHerramientas = new JToolBar();
		
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/negrita.gif"));
		
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/cursiva.gif"));
		
		JButton subrayadoBarra = new JButton(new ImageIcon("src/graficos/subrayado.gif"));
		
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/rojo2.gif"));
		
		JButton amarilloBarra = new JButton(new ImageIcon("src/graficos/amarillo2.gif"));
		
		JButton verdeBarra = new JButton(new ImageIcon("src/graficos/verde2.gif"));
		
		JButton izquierdaBarra = new JButton(new ImageIcon("src/graficos/izquierda.gif"));
		
		JButton centroBarra = new JButton(new ImageIcon("src/graficos/centro.gif"));
		
		JButton derechaBarra = new JButton(new ImageIcon("src/graficos/derecha.gif"));
		
		JButton justificadoBarra = new JButton(new ImageIcon("src/graficos/justificado.gif"));
		
		subrayadoBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner rojo", Color.RED));
		
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner amarillo", Color.YELLOW));
		
		verdeBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner verde", Color.GREEN));
		
		izquierdaBarra.addActionListener(new StyledEditorKit.AlignmentAction("Poner a la izquierda", 0));
		
		centroBarra.addActionListener(new StyledEditorKit.AlignmentAction("Poner al centro", 1));
		
		derechaBarra.addActionListener(new StyledEditorKit.AlignmentAction("Poner a la derecha", 2));
		
		justificadoBarra.addActionListener(new StyledEditorKit.AlignmentAction("Poner justificado", 3));
		
		barraHerramientas.add(negritaBarra);
		
		barraHerramientas.add(cursivaBarra);
		
		barraHerramientas.add(subrayadoBarra);
		
		barraHerramientas.add(rojoBarra);
		
		barraHerramientas.add(amarilloBarra);
		
		barraHerramientas.add(verdeBarra);
		
		barraHerramientas.add(izquierdaBarra);
		
		barraHerramientas.add(centroBarra);
		
		barraHerramientas.add(derechaBarra);
		
		barraHerramientas.add(justificadoBarra);*/
		
		barraHerramientas = new JToolBar();
		
		barraHerramientas.setOrientation(JToolBar.VERTICAL);
		
		configurarBarra("src/graficos/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());
		
		configurarBarra("src/graficos/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
		
		configurarBarra("src/graficos/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barraHerramientas.addSeparator();
		
		configurarBarra("src/graficos/rojo2.gif").addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
		
		configurarBarra("src/graficos/amarillo2.gif").addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
		
		configurarBarra("src/graficos/verde2.gif").addActionListener(new StyledEditorKit.ForegroundAction("Verde", Color.GREEN));
		
		barraHerramientas.addSeparator();
		
		configurarBarra("src/graficos/izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		
		configurarBarra("src/graficos/centro.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centro", 1));
		
		configurarBarra("src/graficos/derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		
		configurarBarra("src/graficos/justificado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		add(barraHerramientas, BorderLayout.WEST);
		
	}
	
	public JButton configurarBarra(String ruta) {
		
		JButton botonBarra = new JButton(new ImageIcon(ruta));
		
		barraHerramientas.add(botonBarra);
		
		return botonBarra;
		
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
	
	private JButton negritaBarra, cursivaBarra, subrayadoBarra, rojoBarra, amarilloBarra, verdeBarra, izquierdaBarra, centroBarra, derechaBarra, justificadoBarra;
	
	private JToolBar barraHerramientas;
	
}
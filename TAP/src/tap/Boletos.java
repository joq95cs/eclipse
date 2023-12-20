package tap;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Boletos {

	public static void main(String[] args) {
		
		MarcoBoletos marco = new MarcoBoletos();
		
		marco.setVisible(true);
		
	}

}

class MarcoBoletos extends JFrame {
	
	public MarcoBoletos() {
		
		anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(anchoPantalla/3, altoPantalla/3, anchoPantalla/3, altoPantalla/3);
		
		setTitle("Boletos: Sesión no iniciada");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lamina = new LaminaBoletos();
		
		add(lamina);
		
		lamina.setMarco(this);
		
	}
	
	private int anchoPantalla;
	
	private int altoPantalla;
	
	private LaminaBoletos lamina;
	
}

class LaminaBoletos extends JPanel {
	
	public LaminaBoletos() {
		
		anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setLayout(new BorderLayout());
		
		sesionIniciada = false;
		
		barraMenu = new JMenuBar();
		
		barraMenu.setLayout(new FlowLayout());
		
		opcion1 = new JButton("Cobrar");
		
		opcion1.setEnabled(false);
		
		opcion2 = new JButton("Ingresar precio del boleto");
		
		opcion2.setEnabled(false);
		
		opcion2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				precioBoleto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del boleto"));
				
				etiquetaPrecio.setText("Precio del boleto: " + precioBoleto);
				
			}
			
		});
		
		opcion3 = new JButton("Historial");
		
		opcion3.setEnabled(false);
		
		marcoHistorial = new JFrame("Historial de pagos");
		
		marcoHistorial.setBounds(anchoPantalla/3, altoPantalla/3, anchoPantalla/3, altoPantalla/3);
		
		marcoHistorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		areaHistorial = new JTextArea();
		
		areaHistorial.setLineWrap(true);
		
		areaHistorial.setEditable(false);
		
		scrollHistorial = new JScrollPane(areaHistorial);
		
		marcoHistorial.add(scrollHistorial);
		
		opcion3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(marcoHistorial.isVisible()) {
					
					marcoHistorial.setVisible(false);
					
				} else {
					
					marcoHistorial.setVisible(true);
					
				}
				
			}
			
		});
		
		opciones = new JMenu("Sesión");
		
		opcionIngresar = new JMenuItem("Ingresar");
		
		opcionIngresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(sesionIniciada == false) {
					
					marcoIngresar = new JFrame();
					
					marcoIngresar.setBounds(2*anchoPantalla/5, 2*altoPantalla/5, anchoPantalla/5, altoPantalla/5);
					
					marcoIngresar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					marcoIngresar.setTitle("Ingresar");
					
					marcoIngresar.setResizable(false);
					
					marcoIngresar.setVisible(true);
					
					JPanel laminaIngresar = new JPanel();
					
					laminaIngresar.setLayout(new GridLayout(3, 1));
					
					JPanel laminaUsuario = new JPanel();
					
					JPanel laminaPassword = new JPanel();
					
					JPanel laminaBotonIngresar = new JPanel();
					
					JLabel etiquetaUsuario = new JLabel("Usuario ");
					
					campoUsuario = new JTextField(15);
					
					JLabel etiquetaPassword = new JLabel("Password ");
					
					campoPassword = new JPasswordField(15);
					
					AccionIngresar accion = new AccionIngresar();
					
					JButton botonIngresar = new JButton (accion);
					
					InputMap mapaEntrada = laminaIngresar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
					
					mapaEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "key_ingresar");
					
					ActionMap mapaAccion = laminaIngresar.getActionMap();
					
					mapaAccion.put("key_ingresar", accion);
					
					laminaUsuario.add(etiquetaUsuario);
					
					laminaUsuario.add(campoUsuario);
					
					laminaPassword.add(etiquetaPassword);
					
					laminaPassword.add(campoPassword);
					
					laminaBotonIngresar.add(botonIngresar);
					
					laminaIngresar.add(laminaUsuario);
					
					laminaIngresar.add(laminaPassword);
					
					laminaIngresar.add(laminaBotonIngresar);
					
					marcoIngresar.add(laminaIngresar);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Actualmente la sesión está iniciada");
					
				}
				
			}
			
			class AccionIngresar extends AbstractAction {
				
				public AccionIngresar() {
					
					putValue(Action.NAME, "Ingresar");
					
					putValue(Action.SHORT_DESCRIPTION, "Presione tecla Enter para ingresar");
					
				}
				
				public void actionPerformed(ActionEvent e) {
					
					if(campoUsuario.getText().equals("joqsan") && campoPassword.getText().equals("12345")) {
						
						JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
						
						etiquetaSesion.setText("Sesión iniciada");
						
						marco.setTitle("Boletos: Sesión iniciada");
						
						sesionIniciada = true;
						
						opcion1.setEnabled(true);
						
						opcion2.setEnabled(true);
						
						opcion3.setEnabled(true);
						
						marcoIngresar.setVisible(false);
						
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Usuario o password incorrectos");
						
					}
					
				}
				
			}
			
			JTextField campoUsuario;
			
			JTextField campoPassword;
			
		});
		
		opcionSalir = new JMenuItem("Salir");
		
		opcionSalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)  {
				
				if(sesionIniciada) {
					
					JOptionPane.showMessageDialog(null, "Sesión terminada");
					
					etiquetaSesion.setText("Sesión no iniciada");
					
					marco.setTitle("Boletos: Sesión no iniciada");
					
					sesionIniciada = false;
					
					opcion1.setEnabled(false);
					
					opcion2.setEnabled(false);
					
					opcion3.setEnabled(false);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No se ha iniciado sesión");
					
				}
				
			}
			
		});
		
		opciones.add(opcionIngresar);
		
		opciones.add(opcionSalir);
		
		barraMenu.add(opcion1);
		
		barraMenu.add(opcion2);
		
		barraMenu.add(opcion3);
		
		barraMenu.add(opciones);
		
		barraSesion = new JMenuBar();
		
		barraSesion.setLayout(new FlowLayout());
		
		etiquetaSesion = new JLabel("Sesión no iniciada", SwingConstants.CENTER);
		
		barraSesion.add(etiquetaSesion);
		
		laminaCentro = new JPanel();
		
		laminaCentro.setLayout(new BorderLayout());
		
		laminaPrecio = new JPanel();
		
		etiquetaPrecio = new JLabel();
		
		laminaPrecio.add(etiquetaPrecio);
		
		laminaCentro.add(laminaPrecio, BorderLayout.NORTH);
		
		add(barraMenu, BorderLayout.NORTH);
		
		add(barraSesion, BorderLayout.SOUTH);
		
		add(laminaCentro, BorderLayout.CENTER);
		
	}
	
	public void setMarco(MarcoBoletos m) {
		
		marco = m;
		
	}
	
	private JMenuBar barraMenu;
	
	private JButton opcion1;
	
	private JButton opcion2;
	
	private JButton opcion3;
	
	private JMenu opciones;
	
	private JMenuItem opcionIngresar;
	
	private JMenuItem opcionSalir;
	
	private JFrame marcoIngresar;
	
	private JLabel etiquetaSesion;
	
	private JMenuBar barraSesion;
	
	private boolean sesionIniciada;
	
	private MarcoBoletos marco;
	
	private double precioBoleto;
	
	private JLabel etiquetaPrecio;
	
	private JPanel laminaPrecio;
	
	private JPanel laminaCentro;
	
	private JTextArea areaHistorial;
	
	private JScrollPane scrollHistorial;
	
	private JFrame marcoHistorial;
	
	private int anchoPantalla;
	
	private int altoPantalla;
	
}

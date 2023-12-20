package tap;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.imageio.*;

import java.io.*;

public class Catalogo_imagenes {

	public static void main(String[] args) {
		
		Component marco = new MarcoCI();
		
		marco.setVisible(true);

	}

}

class MarcoCI extends JFrame {
	
	public MarcoCI() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Catálogo de imágenes");
		
		Component lamina = new LaminaCI();
		
		add(lamina);
		
	}
	
}

class LaminaCI extends JPanel {
	
	public LaminaCI() {
		
		setLayout(new BorderLayout());
		
		lamina_norte = new JPanel();
		
		lamina_centro = new JPanel();
		
		lamina_centro.setLayout(new GridLayout());
		
		lamina_imagen = new JPanel();
		
		lamina_centro.add(lamina_imagen);
		
		add(lamina_norte, BorderLayout.NORTH);
		
		add(lamina_centro, BorderLayout.CENTER);
		
		lamina_i1 = new JPanel () {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen1, 0, 0, lamina_i1.getWidth(), lamina_i1.getHeight(), lamina_i1);
				
			}
			
		};
		
		lamina_i2 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen2, 0, 0, lamina_i2.getWidth(), lamina_i2.getHeight(), lamina_i2);
				
			}
			
		};
		
		lamina_i3 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen3, 0, 0, lamina_i3.getWidth(), lamina_i3.getHeight(), lamina_i3);
				
			}
			
		};
		
		lamina_i4 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen4, 0, 0, lamina_i4.getWidth(), lamina_i4.getHeight(), lamina_i4);
				
			}
			
		};
		
		lamina_i5 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen5, 0, 0, lamina_i5.getWidth(), lamina_i5.getHeight(), lamina_i5);
				
			}
			
		};
		
		lamina_i6 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				g.drawImage(imagen6, 0, 0, lamina_i6.getWidth(), lamina_i6.getHeight(), lamina_i6);
				
			}
			
		};
		
		lamina_i1.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen1, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_i2.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen2, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_i3.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen3, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_i4.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen4, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_i5.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen5, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_i6.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				lamina_centro.remove(lamina_imagen);
				
				lamina_imagen = new JPanel() {
					
					public void paintComponent(Graphics g) {
						
						super.paintComponent(g);
						
						g.drawImage(imagen6, 0, 0, lamina_imagen.getWidth(), lamina_imagen.getHeight(), lamina_imagen);
						
					}
					
				};
				
				lamina_centro.add(lamina_imagen);
				
			}
			
		});
		
		lamina_norte.add(lamina_i1);
		
		lamina_norte.add(lamina_i2);
		
		lamina_norte.add(lamina_i3);
		
		lamina_norte.add(lamina_i4);
		
		lamina_norte.add(lamina_i5);
		
		lamina_norte.add(lamina_i6);
		
		try {
			
			imagen1 = ImageIO.read(new File("src/tap/captain_america.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/captain_america.jpg");
			
		}
		
		try {
			
			imagen2 = ImageIO.read(new File("src/tap/black_widow.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/black_widow.jpg");
			
		}
		
		try {
			
			imagen3 = ImageIO.read(new File("src/tap/hulk.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/hulk.jpg");
			
		}
		
		try {
			
			imagen4 = ImageIO.read(new File("src/tap/hawk_eye.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/hawk_eye.jpg");
			
		}
		
		try {
			
			imagen5 = ImageIO.read(new File("src/tap/thor.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/thor.jpg");
			
		}
		
		try {
			
			imagen6 = ImageIO.read(new File("src/tap/iron_man.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra el archivo: src/tap/iron_man.jpg");
			
		}
		
		
	}
	
	private JPanel lamina_centro;
	
	private JPanel lamina_norte;
	
	private JPanel lamina_i1;
	
	private JPanel lamina_i2;
	
	private JPanel lamina_i3;
	
	private JPanel lamina_i4;
	
	private JPanel lamina_i5;
	
	private JPanel lamina_i6;
	
	private JPanel lamina_imagen;
	
	private Image imagen1;
	
	private Image imagen2;
	
	private Image imagen3;
	
	private Image imagen4;
	
	private Image imagen5;
	
	private Image imagen6;
	
}
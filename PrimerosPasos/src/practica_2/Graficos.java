package practica_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Graficos {
	
	public static class Marco extends JFrame {
		
		public Marco() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Painter");
			setSize(700, 500);
			setMinimumSize(getSize());
			setLocationRelativeTo(null);
			
			add(new LaminaSuperior(), BorderLayout.NORTH);
			
			add(new LaminaCentral(), BorderLayout.CENTER);
			
		}
		
	}
	
	private static class LaminaSuperior extends JPanel {
		
		public LaminaSuperior() {
			
			setLayout(new GridLayout());
			
			//COMPONENTES GRÁFICOS
			
			comboColores = new JComboBox();
			comboColores.addItem("Negro");
			comboColores.addItem("Azúl");
			comboColores.addItem("Cyan");
			comboColores.addItem("Gris");
			comboColores.addItem("Verde");
			comboColores.addItem("Magenta");
			comboColores.addItem("Naranja");
			comboColores.addItem("Rosa");
			comboColores.addItem("Rojo");
			comboColores.addItem("Amarillo");
			comboColores.setMaximumSize(comboColores.getPreferredSize());
			comboColores.addActionListener(new OyenteColor());
			
			comboFiguras = new JComboBox();
			comboFiguras.addItem("Rectángulo");
			comboFiguras.addItem("Óvalo");
			comboFiguras.addItem("Línea");
			comboFiguras.setMaximumSize(comboFiguras.getPreferredSize());
			
			checkRelleno = new JCheckBox();
			
			JButton botonLimpiar = new JButton("Limpiar");
			botonLimpiar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					lc.repaint();
					
				}
				
			});
			
			Box cajaComponentes = Box.createHorizontalBox();
			
			cajaComponentes.add(Box.createGlue());
			
			cajaComponentes.add(new JLabel("Color"));
			cajaComponentes.add(Box.createHorizontalStrut(10));
			cajaComponentes.add(comboColores);
			
			cajaComponentes.add(Box.createGlue());
			
			cajaComponentes.add(new JLabel("Figura"));
			cajaComponentes.add(Box.createHorizontalStrut(10));
			cajaComponentes.add(comboFiguras);
			
			cajaComponentes.add(Box.createGlue());
			
			cajaComponentes.add(new JLabel("Relleno"));
			cajaComponentes.add(Box.createHorizontalStrut(10));
			cajaComponentes.add(checkRelleno);
			
			cajaComponentes.add(Box.createGlue());
			
			cajaComponentes.add(Box.createHorizontalStrut(10));
			cajaComponentes.add(botonLimpiar);
			
			cajaComponentes.add(Box.createGlue());
			
			add(cajaComponentes);
			
		}
		
	}

	private static class LaminaCentral extends JPanel {
		
		public LaminaCentral() {
			
			setLayout(null);
			setBackground(Color.WHITE);
			
			addMouseListener(new OyenteFiguras1());
			//addMouseMotionListener(new OyenteFiguras2());
			
			lc = this;
			
		}
		
	}
	
	private static class OyenteColor implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			switch(comboColores.getSelectedIndex()) {
			
			case 0:
				
				c = Color.BLACK;
				
				break;
			
			case 1:
				
				c = Color.BLUE;
				
				break;
				
			case 2:
				
				c = Color.CYAN;
				
				break;
				
			case 3:
			
				c = Color.GRAY;
			
				break;
				
			case 4:
				
				c = Color.GREEN;
			
				break;
				
			case 5:
				
				c = Color.MAGENTA;
			
				break;
				
			case 6:
				
				c = Color.ORANGE;
			
				break;
				
			case 7:
				
				c = Color.PINK;
			
				break;

			case 8:
				
				c = Color.RED;
			
				break;
				
			case 9:
				
				c = Color.YELLOW;
			
				break;
				
				
			}
			
		}
		
	}
	
	private static class OyenteFiguras1 extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
			setPunto1(e);
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
			g = (Graphics2D) lc.getGraphics();
			
			g.setColor(c);
			
			aux = true;
			
			if(!checkRelleno.isSelected()) {
			
				if(comboFiguras.getSelectedItem().equals("Rectángulo")) {
					
					g.draw(new Rectangle2D.Double(x1, y1, e.getX()-x1, e.getY()-y1));
					
				} else if(comboFiguras.getSelectedItem().equals("Óvalo")) {
					
					g.draw(new Ellipse2D.Double(x1, y1, e.getX()-x1, e.getY()-y1));
					
				} else {
					
					g.drawLine(x1, y1, e.getX(), e.getY());
					
				}
				
			} else {
				
				if(comboFiguras.getSelectedItem().equals("Rectángulo")) {
					
					g.fill(new Rectangle2D.Double(x1, y1, e.getX()-x1, e.getY()-y1));
					
				} else if(comboFiguras.getSelectedItem().equals("Óvalo")) {
					
					g.fill(new Ellipse2D.Double(x1, y1, e.getX()-x1, e.getY()-y1));
					
				} else {
					
					g.drawLine(x1, y1, e.getX(), e.getY());
					
				}
				
			}
			
		}
		
	}
	
	private static void setPunto1(MouseEvent e) {
		
		if(aux) {
			
			x1 = e.getX();
			y1 = e.getY();
			
			aux = false;
			
		}
		
	}

	
	private static JComboBox comboColores, comboFiguras;
	
	private static JCheckBox checkRelleno;
	
	private static Graphics2D g;
	
	private static LaminaCentral lc;
	
	private static int x1, y1;
	
	private static boolean aux = true;
	
	private static Color c = Color.BLACK;
	
}
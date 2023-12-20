package graficos;

import javax.swing.*;

import java.awt.*;

public class DisposicionLibre {

	public static void main(String[] args) {
		
		new MarcoDL().setVisible(true);

	}

}

class MarcoDL extends JFrame {
	
	public MarcoDL() {
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Diposición libre");
		
		setSize(600, 400);
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width,
			h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setLocation(w/2-getWidth()/2, h/2-getHeight()/2);
		
		add(new LaminaDL());
		
	}
	
}

class LaminaDL extends JPanel {
	
	public LaminaDL() {
		
		setLayout(new EnColumnas()); //Utilizo la disposición propia
		
		JLabel et1 = new JLabel("Nombre");
		
		JLabel et2 = new JLabel("Apellido");
		
		JLabel et3 = new JLabel("Edad");
		
		JLabel et4 = new JLabel("Teléfono");
		
		JTextField ct1 = new JTextField(); //No se le colocan columnas
		
		JTextField ct2 = new JTextField();
		
		JTextField ct3 = new JTextField();
		
		JTextField ct4 = new JTextField();
		
		/*et1.setBounds(20, 20, 80, 10);
		
		ct1.setBounds(100, 17, 100, 20);
		
		et2.setBounds(20, 60, 80, 15);
		
		ct2.setBounds(100, 55, 100, 20);*/
		
		add(et1);
		
		add(ct1);
		
		add(et2);
		
		add(ct2);
		
		add(et3);
		
		add(ct3);
		
		add(et4);
		
		add(ct4);
		
	}
	
}

class EnColumnas implements LayoutManager {
	
	public void layoutContainer(Container c) {
		
		int x = c.getWidth()/2, y = 20, conta = 0, n = c.getComponentCount();
		
		for(int i=0; i<n; i++) {
			
			conta ++;
			
			Component compo = c.getComponent(i);
			
			compo.setBounds(x-100, y, 100, 20);
			
			x += 100;
			
			if(conta % 2 == 0) { //Operador residuo
				
				x = c.getWidth()/2; y += 40;
				
			}
			
		}
		
	}

	public Dimension minimumLayoutSize(Container parent) {

		return null;
		
	}

	public Dimension preferredLayoutSize(Container parent) {

		return null;
		
	}

	public void addLayoutComponent(String name, Component comp) {}
	
	public void removeLayoutComponent(Component comp) {}
	
}
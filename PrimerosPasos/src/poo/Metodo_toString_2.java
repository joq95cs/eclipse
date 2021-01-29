package poo;

public class Metodo_toString_2 {

	public static void main(String[] args) {
		
		javax.swing.JFrame m = new javax.swing.JFrame() {
			
			public String toString() {
				
				return this.getTitle();
				
			}
			
			public void setTitle(String t) {
				
				super.setTitle("Mi marquito");
				
			}
			
		};
		
		m.setTitle(null);
		
		System.out.println(m);

	}

}

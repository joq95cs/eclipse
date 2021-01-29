package poo;

public class ClasesAdaptadoras {

	public static void main(String[] args) {
		
		DimeAlgo algo = new DimeAlgo();
		
		algo.decirRefran();

	}

}

interface Dichos {
	
	void decirRefran();
	
	void decirFraseCelebre();
	
	void decirChiste();
	
	void decirAdivinanza();
	
}

abstract class AdaptadoraDichos implements Dichos {
	
	public void decirRefran() {}
	
	public void decirFraseCelebre() {}
	
	public void decirChiste() {}
	
	public void decirAdivinanza() {}
	
}

class DimeAlgo extends AdaptadoraDichos {
	
	public void decirRefran() {
		
		System.out.println("Lo que no te mata, te hace más fuerte...");
		
	}
	
}
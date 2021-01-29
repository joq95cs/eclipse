package poo;

public class Celular {

	private String marca;
	
	private String sistema_operativo;
	
	private boolean tarjeta_sd;
	
	private boolean camara_frontal; //ATRIBUTOS CONSTANTES
	
	private String modelo;
	
	private String color;
	
	private int memoria_interna;
	
	private String version_android;
	
	private int ram;
	
	private int nucleos; 
	
	private int precio; //ATRIBUTOS VARIABLES
	
	public Celular() {
		
		marca = "BLU";
		
		sistema_operativo = "Android";
		
		tarjeta_sd = false;
		
		camara_frontal = true;
		
	}
	
	public void setModelo(String modelo) {
		
		this.modelo = modelo;
		
	}
	
	public void setColor(String color) {
		
		this.color = color;
		
	}
	
	public void setMemoriaInterna(int memoria_interna) {
		
		this.memoria_interna = memoria_interna;
		
	}
	
	public void setVersionAndroid(String version_android) {
		
		this.version_android = version_android;
		
	}
	
	public void setRAM(int ram) {
		
		this.ram = ram;
		
	}
	
	public void setNucleos(int nucleos) {
		
		this.nucleos = nucleos;
		
	}
	
	public String getModelo() {
		
		return "Modelo: " + modelo;
		
	}
	
	public String getColor() {
		
		return "Color: " + color;
		
	}
	
	public String getMemoriaInterna() {
		
		return "Memoria interna: " + memoria_interna +  " GB";
		
	}
	
	public String getVersionAndroid() {
		
		return "Versión Android: " + version_android;
		
	}
	
	public String getRAM() {
		
		return "RAM: " + ram + " GB";
		
	}
	
	public String getNucleos() {
		
		String procesador = "";
		
		if(nucleos==1) {
			
			procesador = "Procesador: Singlecore";
			
		}
		
		if(nucleos==2) {
		
			procesador = "Procesador: Dualcore";
			
		}
		
		if(nucleos==4) {
			
			procesador = "Procesador: Quadcore";
			
		}
		
		if(nucleos==8) {
			
			procesador = "Procesaor: Octacore";
					
		}
		
		return procesador;
		
	}
		
	public String precio_celuar() {
			
		if(modelo.equalsIgnoreCase("BLU STUDIO 6.0 HD")) {
				
			precio = 4000;		
						
		}
		
		if(modelo.equalsIgnoreCase("BLU STUDIO 5.0")) {
			
			precio = 2500;
			
		}
		
		return "Precio: $" + precio + ".00";
		
	}
	
	public String getAtributos() {
		
		String sd = "";
		
		String cam = "";
		
		if(tarjeta_sd==false) {
			
			sd = "NO";
			
		}
		
		if(camara_frontal==true) {
			
			cam = "SÍ";
		}
		
		return "Marca: " + marca
		+ "\nSistema operativo: " + sistema_operativo
		+ "\nTarjeta SD: " + sd
		+ "\nCámara frontal: " + cam;
		
	}
		
}
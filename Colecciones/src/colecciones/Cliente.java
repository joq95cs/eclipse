package colecciones;

public class Cliente {
	
	public Cliente(String nombre, String no_cuenta, double saldo) {
		
		this.nombre = nombre;
		
		this.no_cuenta = no_cuenta;
		
		this.saldo = saldo;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no_cuenta == null) ? 0 : no_cuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (no_cuenta == null) {
			if (other.no_cuenta != null)
				return false;
		} else if (!no_cuenta.equals(other.no_cuenta))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNo_cuenta() {
		return no_cuenta;
	}

	public void setNo_cuenta(String no_cuenta) {
		this.no_cuenta = no_cuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private String nombre;
	
	private String no_cuenta;
	
	private double saldo;

}

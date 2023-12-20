package web_productos;

public class Productos {
	
	public Productos(String codigo_articulo, String seccion, String nombre_articulo, String precio, String fecha,
			String importado, String pais_origen) {
		
		this.codigo_articulo = codigo_articulo;
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais_origen = pais_origen;
	}
	
	

	public Productos(String seccion, String nombre_articulo, String precio, String fecha, String importado,
			String pais_origen) {
		
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais_origen = pais_origen;
	}

	public String getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	@Override
	public String toString() {
		return "Productos [codigo_articulo=" + codigo_articulo + ", seccion=" + seccion + ", nombre_articulo="
				+ nombre_articulo + ", precio=" + precio + ", fecha=" + fecha + ", importado=" + importado
				+ ", pais_origen=" + pais_origen + "]";
	}

	private String codigo_articulo;
	
	private String seccion;
	
	private String nombre_articulo;
	
	private String precio;
	
	private String fecha;
	
	private String importado;
	
	private String pais_origen;

}

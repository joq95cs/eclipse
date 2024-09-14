package castellanos.joqsan.nodemcu_http;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	public Pelicula(String nombre, String estudio, int agno, String genero) {
		
		this.nombre = nombre;
		this.estudio = estudio;
		this.agno = agno;
		this.genero = estudio;
	}
	
	public Pelicula() {}
	
	public int getId_pelicula() {
		
		return id_pelicula;
	}
	
	public void setId_pelicula(int id_pelicula) {
		
		this.id_pelicula = id_pelicula;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public String getEstudio() {
		
		return estudio;
	}
	
	public void setEstudio(String estudio) {
		
		this.estudio = estudio;
	}
	
	public int getAgno() {
		
		return agno;
	}
	
	public void setAgno(int agno) {
		
		this.agno = agno;
	}
	
	public String getGenero() {
		
		return genero;
	}
	
	public void setGenero(String genero) {
		
		this.genero = genero;
	}
	
	public boolean validar() {
		
		return !nombre.isEmpty() && !estudio.isEmpty() && !genero.isEmpty();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pelicula")
	private int id_pelicula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estudio")
	private String estudio;
	
	@Column(name="agno")
	private int agno;
	
	@Column(name="genero")
	private String genero;
}
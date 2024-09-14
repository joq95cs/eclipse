package castellanos.joqsan.HibernatePeliculas;

import jakarta.persistence.*;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	public Pelicula(String nombre, String estudio, int agno, String genero) {
		
		this.nombre = nombre;
		this.estudio = estudio;
		this.agno = agno;
		this.genero = genero;
	}
	
	public Pelicula () {}
	
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
	
	

	@Override
	public String toString() {
		return "\nNOMBRE: " + nombre
			+"\nESTUDIO: " + estudio
			+"\nAGNO: " + agno
			+"\nGENERO: " + genero;
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

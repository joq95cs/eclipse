package hibernate2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles_clientes")
public class DetallesCliente {
	
	public DetallesCliente(String pagina_web, String telefono, String comentarios) {
		
		this.pagina_web = pagina_web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	public DetallesCliente() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPagina_web() {
		return pagina_web;
	}

	public void setPagina_web(String pagina_web) {
		this.pagina_web = pagina_web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", pagina_web=" + pagina_web + ", telefono=" + telefono + ", comentarios="
				+ comentarios + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pagina_web")
	private String pagina_web;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="comentarios")
	private String comentarios;
	
	@OneToOne(mappedBy="detallesCliente", cascade=CascadeType.ALL) //Campo de la otra clase
	private Cliente cliente;
}
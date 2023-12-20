package web_productos;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modelo_productos;
	
	@Resource(name="jdbc/Productos")
	
	private DataSource pool;

	@Override
	public void init() throws ServletException {
		
		super.init();
		
		try {
		
			modelo_productos = new ModeloProductos(pool);
			
		} catch(Exception e) {
			
			throw new ServletException(e);
			
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Leer el parámetro que le llega desde el formulario
		
		String comando = request.getParameter("instruccion");
		
		//Si no se envía el parámetro, listar productos
		
		if(comando == null) {
			
			comando = "listar";
			
		}
		
		//Redirigir el flujo de ejecución al método adecuado
		
		switch(comando) {
		
		case "listar":
			
			obtenerProductos(request, response);
			
			break;
			
		case "insertar":
			
			insertarProducto(request, response);
			
			break;
			
		case "cargar":
			
			try {
				
				cargarProducto(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		case "actualizar":
			
			try {
				
				actualizarProducto(request, response);
				
			} catch (Exception e) {

				e.printStackTrace();
				
			}
			
			break;
			
		case "eliminar":
			
			try {
				
				eliminarProducto(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			break;
			
		default:
			
			obtenerProductos(request, response);
		
		
		}
		
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Capturar el código del artículo
		
		String codigo_articulo = request.getParameter("codigo_articulo");
		
		//Borrar producto de la base de datos
		
		modelo_productos.eliminarProducto(codigo_articulo);
		
		//Volver al listado de productos
		
		obtenerProductos(request, response);
		
	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Leer los datos que le vienen del formulario actualizar
		
		String codigo_articulo = request.getParameter("codigo_articulo");
		
		String seccion = request.getParameter("seccion");
		
		String nombre_articulo = request.getParameter("nombre_articulo");
		
		String fecha = request.getParameter("fecha");
		
		String precio = request.getParameter("precio");
		
		String importado = request.getParameter("importado");
		
		String pais_origen = request.getParameter("pais_origen");
		
		//Crear objeto de tipo producto con la info del formulario
		
		Productos producto_actualizado = new Productos(codigo_articulo, seccion, nombre_articulo, fecha, precio, importado, pais_origen);
		
		//Actualizar la base de datos con la info del objeto producto
		
		modelo_productos.actualizarProducto(producto_actualizado);
		
		//Volver al listado con la info actualizada
		
		obtenerProductos(request, response);
		
	}

	private void cargarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Leer el código del artículo que viene del listado
		
		String codigo_articulo = request.getParameter("codigo_articulo");
		
		//Enviar articulo al modelo
		
		Productos producto = modelo_productos.getProducto(codigo_articulo);
		
		//Colocar atributo correspondiente al código
		
		request.setAttribute("producto_actualizar", producto);
		
		//Enviar producto al formulario de actualizar(jsp)
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaProducto.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
		
		//Leer la información del producto que viene del formulario
		
		String codigo_articulo = request.getParameter("codigo_articulo");
		
		String seccion = request.getParameter("seccion");
		
		String nombre_articulo = request.getParameter("nombre_articulo");
		
		String fecha = request.getParameter("fecha");
		
		String precio = request.getParameter("precio");
		
		String importado = request.getParameter("importado");
		
		String pais_origen = request.getParameter("pais_origen");
		
		//Crear objeto de tipo producto
		
		Productos nuevo_producto = new Productos(codigo_articulo, seccion, nombre_articulo, fecha, precio, importado, pais_origen);
		
		//Enviar objeto al modelo y después insertar el objeto producto en la base de datos
		
		try {
			
			modelo_productos.insertarProducto(nuevo_producto);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		//Volver al listado de productos
		
		obtenerProductos(request, response);
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		//Obtener la lista de productos desde el modelo
		
		ArrayList<Productos> lista_productos;
		
		try {
			
			lista_productos = modelo_productos.getListaProductos();
		
		//Agregar lista de productos al request
			
			request.setAttribute("lista_productos", lista_productos);
		
		//Enviar request a la página JSP
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			
			dispatcher.forward(request, response);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}

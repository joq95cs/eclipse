package web_productos;

import java.util.*;

import javax.sql.*;

import java.sql.*;

public class ModeloProductos {
	
	public ModeloProductos(DataSource origen_datos) {
		
		this.origen_datos = origen_datos;
		
	}
	
	public ArrayList<Productos> getListaProductos() throws Exception {
		
		ArrayList<Productos> lista_productos = new ArrayList<Productos>();
		
		Connection cn = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		//Establecer la conexión
		
		cn = origen_datos.getConnection();
		
		//Crear la sentencia SQL y Statement
		
		String sentencia = "SELECT * FROM PRODUCTOS";
		
		st = cn.createStatement();
		
		//Ejecutar la sentencia SQL
		
		rs = st.executeQuery(sentencia);
		
		//Recorrer el ResultSet obtenido
		
		while(rs.next()) {
			
			String codigo_articulo = rs.getString("CÓDIGOARTÍCULO");
			
			String seccion = rs.getString("SECCIÓN");
			
			String nombre_articulo = rs.getString("NOMBREARTÍCULO");
			
			String precio = rs.getString("PRECIO");
			
			String fecha = rs.getString("FECHA");
			
			String importado = rs.getString("IMPORTADO");
			
			String pais_origen = rs.getString("PAÍSDEORIGEN");
			
			Productos producto = new Productos(codigo_articulo, seccion, nombre_articulo, precio, fecha, importado, pais_origen);
			
			lista_productos.add(producto);
			
		}
		
		return lista_productos;
		
	}
	
	DataSource origen_datos;

	public void insertarProducto(Productos nuevo_producto) throws Exception {
		
		Connection cn = null;
		
		PreparedStatement ps = null;
		
		//Obtener la conexión
		
		try {
			
			cn = origen_datos.getConnection();
		
			//Crear la instrucción sql que inserte el producto
		
			String instruccion = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			ps = cn.prepareStatement(instruccion);
			
			//Establecer los parametros para el producto
			
			ps.setString(1, nuevo_producto.getCodigo_articulo());
			
			ps.setString(2, nuevo_producto.getSeccion());
			
			ps.setString(3, nuevo_producto.getNombre_articulo());
			
			ps.setString(4, nuevo_producto.getFecha());
			
			ps.setString(5, nuevo_producto.getPrecio());
			
			ps.setString(6, nuevo_producto.getImportado());
			
			ps.setString(7, nuevo_producto.getPais_origen());
		
			//Ejecutar la instrucción sql
			
			ps.execute();
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			ps.close();
			
			cn.close();
			
		}
		
	}

	public Productos getProducto(String codigo_articulo) {
		
		Productos producto = null;
		
		Connection cn = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		//Establecer la conexion
		
		try {
		
			cn = origen_datos.getConnection();
		
		//Crear el sql que busque el producto
			
			String sentencia = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";
		
		//Crear la consulta preparada
			
			ps = cn.prepareStatement(sentencia);
		
		//Establecer los parámetros
			
			ps.setString(1, codigo_articulo);
		
		//Ejecutar la consulta
			
			rs = ps.executeQuery();
		
		//Obtener los datos de respuesta
			
			if(rs.next()) {
				
				String c_articulo = rs.getString("CÓDIGOARTÍCULO");
				
				String seccion = rs.getString("SECCIÓN");
				
				String nombre_articulo = rs.getString("NOMBREARTÍCULO");
				
				String precio = rs.getString("PRECIO");
				
				String fecha = rs.getString("FECHA");
				
				String importado = rs.getString("IMPORTADO");
				
				String pais_origen = rs.getString("PAÍSDEORIGEN");
				
				producto = new Productos(c_articulo, seccion, nombre_articulo, precio, fecha, importado, pais_origen);
				
			} else {
				
				throw new Exception("Producto no encontrado con código: " + codigo_articulo);
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return producto;
		
	}

	public void actualizarProducto(Productos producto_actualizado) throws Exception {
		
		Connection cn = null;
		
		PreparedStatement ps = null;
		
		//Establecer la conexión
		
		try {
		
			cn = origen_datos.getConnection();
			
			//Crear la sentencia sql
			
			String sentencia = "UPDATE PRODUCTOS SET SECCIÓN = ?, NOMBREARTÍCULO = ?, PRECIO = ?, FECHA = ?, IMPORTADO = ?, PAÍSDEORIGEN = ? WHERE CÓDIGOARTÍCULO = ?";
			
			//Crear la consulta preparada
			
			ps = cn.prepareStatement(sentencia);
			
			//Establecer los parámetros
			
			ps.setString(1, producto_actualizado.getSeccion());
			
			ps.setString(2, producto_actualizado.getNombre_articulo());
			
			ps.setString(3, producto_actualizado.getPrecio());
			
			ps.setString(4, producto_actualizado.getFecha());
			
			ps.setString(5, producto_actualizado.getImportado());
			
			ps.setString(6, producto_actualizado.getPais_origen());
			
			ps.setString(7, producto_actualizado.getCodigo_articulo());
			
			//Ejecutar la sentencia sql
			
			ps.execute();
			
		} finally {
			
			ps.close();
			
			cn.close();
			
		}
		
	}

	public void eliminarProducto(String codigo_articulo) throws Exception {
		
		Connection cn = null;
		
		PreparedStatement ps = null;
		
		//Establecer la conexión
		
		try {
		
			cn = origen_datos.getConnection();
			
			//Crear sql de eliminación
			
			String sentencia = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";
			
			//Preparar la consulta
			
			ps = cn.prepareStatement(sentencia);
			
			//Establecer parámetro
			
			ps.setString(1, codigo_articulo);
			
			//Ejecutar la sentencia sql
			
			ps.execute();
			
		} finally {
			
			ps.close();
			
			cn.close();
			
		}
		
	}
	
}

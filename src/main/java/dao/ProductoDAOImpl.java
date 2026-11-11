/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import conexion.ConexionBD;
import modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Geovanny_Callizo
 */
public class ProductoDAOImpl {
 public void insertar(Producto producto) throws SQLException {

    String sql = """
        INSERT INTO productos
        (codigo, nombre, descripcion, precio, existencia, imagen)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, producto.getCodigo());
        ps.setString(2, producto.getNombre());
        ps.setString(3, producto.getDescripcion());
        ps.setDouble(4, producto.getPrecio());
        ps.setInt(5, producto.getExistencia());
        ps.setBytes(6, producto.getImagen());

        ps.executeUpdate();
    }
} 
 public Producto buscarPorCodigo(String codigo) throws SQLException {

    String sql = "SELECT * FROM productos WHERE codigo = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, codigo);

        try (java.sql.ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setExistencia(rs.getInt("existencia"));
                producto.setImagen(rs.getBytes("imagen"));

                return producto;
            }
        }
    }

    return null;
}
 public void actualizar(Producto producto) throws SQLException {

    String sql = """
    UPDATE productos
    SET nombre = ?, descripcion = ?,
        precio = ?, existencia = ?, imagen = ?
    WHERE id = ?
    """;

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getDescripcion());
        ps.setDouble(3, producto.getPrecio());
        ps.setInt(4, producto.getExistencia());
        ps.setBytes(5,producto.getImagen());
        ps.setInt(6, producto.getId());

        int filas = ps.executeUpdate();

        if (filas == 0) {
            throw new SQLException("Producto no encontrado");
        }
    }
}
 public void eliminar(int id) throws SQLException {

    String sql = "DELETE FROM productos WHERE id = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);

        int filas = ps.executeUpdate();

        if (filas == 0) {
            throw new SQLException("Producto no encontrado");
        }
    }
}
 public java.util.List<Producto> listar() throws SQLException {

    java.util.List<Producto> productos =
            new java.util.ArrayList<>();

    String sql = "SELECT * FROM productos ORDER BY id";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Producto producto = new Producto();

            producto.setId(rs.getInt("id"));
            producto.setCodigo(rs.getString("codigo"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setExistencia(rs.getInt("existencia"));
            producto.setImagen(rs.getBytes("imagen"));

            productos.add(producto);
        }
    }

    return productos;
}
 public java.util.List<Producto> buscarPorNombre(String nombre)
        throws SQLException {

    java.util.List<Producto> productos = new java.util.ArrayList<>();

    String sql = "SELECT * FROM productos WHERE nombre LIKE ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, "%" + nombre + "%");

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();

                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setExistencia(rs.getInt("existencia"));
                producto.setImagen(rs.getBytes("imagen"));

                productos.add(producto);
            }
        }
    }

    return productos;
}
 public void actualizarExistencia(int id, int existencia)
        throws SQLException {

    if (existencia < 0) {
        throw new IllegalArgumentException(
            "La existencia no puede ser negativa"
        );
    }

    String sql = "UPDATE productos SET existencia = ? WHERE id = ?";

    try (Connection con = ConexionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, existencia);
        ps.setInt(2, id);

        int filas = ps.executeUpdate();

        if (filas == 0) {
            throw new SQLException("Producto no encontrado");
        }
    }
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexion.ConexionBD;
import modelo.Orden;
import modelo.DetalleOrden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Geovanny_Callizo
 */
public class OrdenDAOImpl {
    private final boolean modoPruebas;

public OrdenDAOImpl() {
    this.modoPruebas = false;
}

public OrdenDAOImpl(boolean modoPruebas) {
    this.modoPruebas = modoPruebas;
}
  public void guardarOrden(Orden orden) throws SQLException {
Connection con = modoPruebas
        ? ConexionBD.getConnectionPruebas()
        : ConexionBD.getConnection();
    
      try{  con.setAutoCommit(false);
        String sqlOrden = """
    INSERT INTO ordenes
    (fecha, cliente_id, empleado_id, subtotal, impuesto, total)
    VALUES (?, ?, ?, ?, ?, ?)
    """;
        try (PreparedStatement psOrden =
        con.prepareStatement(sqlOrden)) {
orden.calcularTotales();

psOrden.setString(1, orden.getFecha());
psOrden.setInt(2, orden.getCliente().getId());
psOrden.setInt(3, orden.getEmpleado().getId());
psOrden.setDouble(4, orden.getSubtotal());
psOrden.setDouble(5, orden.getImpuesto());
psOrden.setDouble(6, orden.getTotal());

psOrden.executeUpdate();
int idOrden;

try (PreparedStatement psId =
        con.prepareStatement("SELECT last_insert_rowid()");
     ResultSet rs = psId.executeQuery()) {

    if (!rs.next()) {
        throw new SQLException("No se pudo obtener el ID de la orden");
    }

    idOrden = rs.getInt(1);
}
String sqlDetalle = """
    INSERT INTO detalle_orden
    (orden_id, producto_id, cantidad, precio_unitario)
    VALUES (?, ?, ?, ?)
    """;
try (PreparedStatement psDetalle =
        con.prepareStatement(sqlDetalle)) {
for (DetalleOrden detalle : orden.getDetalles()) {
    psDetalle.setInt(1, idOrden);
    psDetalle.setInt(2, detalle.getProducto().getId());
    psDetalle.setInt(3, detalle.getCantidad());
    psDetalle.setDouble(4, detalle.getPrecioUnitario());
    psDetalle.executeUpdate();
}
}
}
        con.commit();
    }
    catch (SQLException e) {
    con.rollback();
    throw e;
}
      finally {
    con.close();
}

}  
}

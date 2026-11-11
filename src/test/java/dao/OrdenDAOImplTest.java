/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import modelo.Orden;
import conexion.ConexionBD;
import java.sql.Connection;
import org.junit.jupiter.api.BeforeEach;        
import modelo.Persona;
import modelo.Empleado;
import modelo.DetalleOrden;

/**
 *
 * @author Geovanny_Callizo
 */
public class OrdenDAOImplTest {
    @BeforeEach
void prepararBaseDatos() throws SQLException {
    ConexionBD.inicializarPruebas();
}
 @Test
void verificarClaseDAO() {
    OrdenDAOImpl dao = new OrdenDAOImpl(true);

    assertNotNull(dao);
}
@Test
void verificarCommit() throws SQLException {

    OrdenDAOImpl dao = new OrdenDAOImpl(true);

    assertNotNull(dao);
    try (Connection con = ConexionBD.getConnectionPruebas()) {
    assertNotNull(con);
    assertFalse(con.isClosed());
}

}
}

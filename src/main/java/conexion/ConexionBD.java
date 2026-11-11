/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL =
            "jdbc:sqlite:gestion.db";

    public static Connection getConnection()
            throws SQLException {
       Connection con = DriverManager.getConnection(URL);
       System.out.println("Base de datos utilizada: "
        + new java.io.File("gestion.db").getAbsolutePath());

try (Statement stmt = con.createStatement()) {
    stmt.execute("PRAGMA foreign_keys = ON");
}

return con;
    }
    
    public static Connection getConnectionPruebas()
        throws SQLException {

    Connection con = DriverManager.getConnection(
            "jdbc:sqlite:gestion_pruebas.db");

    try (Statement stmt = con.createStatement()) {
        stmt.execute("PRAGMA foreign_keys = ON");
    } catch (SQLException e) {
        con.close();
        throw e;
    }

    return con;
}
public static void inicializarPruebas()
        throws SQLException {
    try (Connection con = getConnectionPruebas()) {
        inicializarTablas(con);
    }
}
public static void inicializar() throws SQLException {
    try (Connection con = getConnection()) {
        inicializarTablas(con);
    }
}
    private static void inicializarTablas(Connection con)
        throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS personas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                identidad TEXT NOT NULL UNIQUE,
                nombre TEXT NOT NULL,
                apellido TEXT NOT NULL,
                telefono TEXT,
                correo TEXT,
                fecha_nacimiento TEXT
            )
            """;

       try (Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            String sqlEmpleados = """
    CREATE TABLE IF NOT EXISTS empleados (
        persona_id INTEGER PRIMARY KEY
            REFERENCES personas(id) ON DELETE CASCADE,
        codigo TEXT NOT NULL UNIQUE,
        puesto TEXT NOT NULL,
        salario REAL NOT NULL CHECK(salario > 0),
        fecha_ingreso TEXT NOT NULL
    )
    """;

stmt.execute(sqlEmpleados);
String sqlProductos = """
    CREATE TABLE IF NOT EXISTS productos (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        codigo TEXT NOT NULL UNIQUE,
        nombre TEXT NOT NULL,
        descripcion TEXT,              
        precio REAL NOT NULL CHECK(precio >= 0),
        existencia INTEGER NOT NULL DEFAULT 0
            CHECK(existencia >= 0),
        imagen BLOB
    )
    """;

stmt.execute(sqlProductos);
String sqlOrdenes = """
    CREATE TABLE IF NOT EXISTS ordenes (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        fecha TEXT NOT NULL,
        cliente_id INTEGER NOT NULL
            REFERENCES personas(id),
        empleado_id INTEGER NOT NULL
            REFERENCES empleados(persona_id),
        subtotal REAL,
        impuesto REAL,
        total REAL
    )
    """;

stmt.execute(sqlOrdenes);
String sqlDetalleOrden = """
    CREATE TABLE IF NOT EXISTS detalle_orden (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        orden_id INTEGER NOT NULL
            REFERENCES ordenes(id) ON DELETE CASCADE,
        producto_id INTEGER NOT NULL
            REFERENCES productos(id),
        cantidad INTEGER NOT NULL CHECK(cantidad > 0),
        precio_unitario REAL NOT NULL
    )
    """;

stmt.execute(sqlDetalleOrden);
            System.out.println(
                "Base de datos inicializada correctamente"
            );
        }
    }
   
}

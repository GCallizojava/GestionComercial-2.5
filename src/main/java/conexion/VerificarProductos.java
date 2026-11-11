/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author Geovanny_Callizo
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class VerificarProductos {

    public static void main(String[] args) {

        try (Connection con = ConexionBD.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "PRAGMA table_info(productos)"
             )) {

            System.out.println("COLUMNAS DE PRODUCTOS:");

            boolean encontrada = false;

            while (rs.next()) {
                encontrada = true;
                System.out.println(
                    rs.getString("name") + " - " +
                    rs.getString("type")
                );
            }

            if (!encontrada) {
                System.out.println(
                    "La tabla productos no existe."
                );
            }

        } catch (SQLException e) {
            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Geovanny_Callizo
 */
public class OrdenTest {
    
    public OrdenTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarDetalle method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarDetalle() {
        Orden instance = new Orden(
    1, "2026-11-08", null, null
    );

    DetalleOrden detalle = new DetalleOrden(
    null, 2, 100.0
    );

    instance.agregarDetalle(detalle);

    assertEquals(1, instance.getDetalles().size());
    assertEquals(detalle, instance.getDetalles().get(0));
    }

    /**
     * Test of calcularTotales method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    
  
public void testCalcularTotales() {

    Orden instance = new Orden(
        1, "2026-11-08", null, null
    );

    DetalleOrden detalle = new DetalleOrden(
        null, 2, 100.0
    );

    instance.agregarDetalle(detalle);

    instance.calcularTotales();

    assertEquals(200.0, instance.getSubtotal(), 0.001);
    assertEquals(30.0, instance.getImpuesto(), 0.001);
    assertEquals(230.0, instance.getTotal(), 0.001);
    }
    

    /**
     * Test of getSubtotal method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetSubtotal() {
        Orden instance = new Orden(
    1, "2026-11-08", null, null
);

     instance.calcularTotales();

     double resultado = instance.getSubtotal();

     assertEquals(0.0, resultado, 0.001);
    }

    /**
     * Test of getImpuesto method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetImpuesto() {
        Orden instance = new Orden(
    1, "2026-11-08", null, null
);

     instance.calcularTotales();

     double resultado = instance.getImpuesto();

assertEquals(0.0, resultado, 0.001);
    }

    /**
     * Test of getTotal method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetTotal() {
        Orden instance = new Orden(
    1, "2026-11-08", null, null
);

    instance.calcularTotales();

     double resultado = instance.getTotal();

     assertEquals(0.0, resultado, 0.001);
    }

    /**
     * Test of getId method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetId() {
      Orden instance = new Orden(
    1, "2026-11-08", null, null
);

     int resultado = instance.getId();

        assertEquals(1, resultado);
    }

    /**
     * Test of getFecha method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetFecha() {
       Orden instance = new Orden(
    1, "2026-11-08", null, null
);

        String resultado = instance.getFecha();

        assertEquals("2026-11-08", resultado);
    }

    /**
     * Test of getCliente method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetCliente() {
       Orden instance = new Orden(
    1, "2026-11-08", null, null
);

        Persona resultado = instance.getCliente();

        assertNull(resultado);
    }

    /**
     * Test of getEmpleado method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetEmpleado() {
        Orden instance = new Orden(
    1, "2026-11-08", null, null
    );

      Empleado resultado = instance.getEmpleado();

       assertNull(resultado);
    }

    /**
     * Test of getDetalles method, of class Orden.
     */
    @org.junit.jupiter.api.Test
    public void testGetDetalles() {
       Orden instance = new Orden(
    1, "2026-11-08", null, null
   );

    List<DetalleOrden> resultado = instance.getDetalles();

     assertNotNull(resultado);
     assertTrue(resultado.isEmpty());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Geovanny_Callizo
 */
public class Orden {
 private int id;
private String fecha;
private Persona cliente;
private Empleado empleado;
private List<DetalleOrden> detalles = new ArrayList<>();
private double subtotal;
private double impuesto;
private double total;
public Orden(int id, String fecha,
             Persona cliente, Empleado empleado) {

    this.id = id;
    this.fecha = fecha;
    this.cliente = cliente;
    this.empleado = empleado;
}
public void agregarDetalle(DetalleOrden detalle) {
    detalles.add(detalle);
}
public void calcularTotales() {
    subtotal = 0;

    for (DetalleOrden detalle : detalles) {
        subtotal += detalle.getSubtotal();
    }

    impuesto = subtotal * 0.15;
    total = subtotal + impuesto;
}
public double getSubtotal() {
    return subtotal;
}

public double getImpuesto() {
    return impuesto;
}

public double getTotal() {
    return total;
}
public int getId() {
    return id;
}

public String getFecha() {
    return fecha;
}

public Persona getCliente() {
    return cliente;
}

public Empleado getEmpleado() {
    return empleado;
}

public List<DetalleOrden> getDetalles() {
    return detalles;
}
}

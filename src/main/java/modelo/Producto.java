/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Geovanny_Callizo
 */
public class Producto {
    private int id;
private String codigo;
private String nombre;
private String descripcion;
private double precio;
private int existencia;
private byte[] imagen;

public Producto(){
    
}
    public Producto(int id, String codigo, String nombre,String descripcion, double precio, int existencia, byte[] imagen) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        setPrecio(precio);
        setExistencia(existencia);
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
    if (precio <= 0) {
        throw new IllegalArgumentException(
            "El precio debe ser mayor que cero"
        );
    }
    this.precio = precio;

    }

    public int getExistencia() {
        return existencia;
    }

   public void setExistencia(int existencia) {
    if (existencia < 0) {
        throw new IllegalArgumentException(
            "La existencia no puede ser negativa"
        );
    }
    this.existencia = existencia;
}

    public byte[] getImagen() {
    return imagen;
}

public void setImagen(byte[] imagen) {
    this.imagen = imagen;
}

    
}

package modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    protected int id;
    protected String nombre;
    protected int cantidad;
    protected double precio;

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public abstract String tipo();

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void agregarStock(int cant) { cantidad += cant; }

    public void reducirStock(int cant) {
        if (cantidad >= cant) cantidad -= cant;
        else System.out.println("No hay suficiente stock.");
    }

    public void mostrar() {
        System.out.printf("[%s] ID:%d - %s | Stock: %d | S/%.2f\n", tipo(), id, nombre, cantidad, precio);
    }
}

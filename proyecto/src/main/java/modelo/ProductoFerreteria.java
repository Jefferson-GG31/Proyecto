package modelo;

public class ProductoFerreteria extends Producto {
    public ProductoFerreteria(int id, String nombre, int cantidad, double precio) {
        super(id, nombre, cantidad, precio);
    }

    public String tipo() {
        return "FERRETERÍA";
    }
}

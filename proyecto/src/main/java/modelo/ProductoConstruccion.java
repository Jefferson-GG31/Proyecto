package modelo;

public class ProductoConstruccion extends Producto {
    public ProductoConstruccion(int id, String nombre, int cantidad, double precio) {
        super(id, nombre, cantidad, precio);
    }

    public String tipo() {
        return "CONSTRUCCIÓN";
    }
}

package controlador;

import modelo.*;

import java.util.*;
import java.util.stream.Collectors;

public class GestorInventario {
    private Map<Integer, Producto> productos = new HashMap<>();

    public void registrarProducto(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Tipo (1-Ferretería, 2-Construcción): ");
        int tipo = sc.nextInt();

        Producto p = switch (tipo) {
            case 1 -> new ProductoFerreteria(id, nombre, cantidad, precio);
            case 2 -> new ProductoConstruccion(id, nombre, cantidad, precio);
            default -> null;
        };

        if (p != null) {
            productos.put(id, p);
            System.out.println("Producto registrado.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    public void mostrarInventario() {
        productos.values().forEach(Producto::mostrar);
    }

    public void entradaStock(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        Producto p = productos.get(id);
        if (p != null) {
            System.out.print("Cantidad a agregar: ");
            int c = sc.nextInt();
            p.agregarStock(c);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void salidaStock(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        Producto p = productos.get(id);
        if (p != null) {
            System.out.print("Cantidad a retirar: ");
            int c = sc.nextInt();
            p.reducirStock(c);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void buscarPorNombre(Scanner sc) {
        System.out.print("Nombre o parte: ");
        String nom = sc.next();
        productos.values().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nom.toLowerCase()))
                .forEach(Producto::mostrar);
    }

    public void reporteStockBajo() {
        productos.values().stream()
                .filter(p -> p.getCantidad() < 5)
                .forEach(Producto::mostrar);
    }

    public Map<Integer, Producto> getProductos() {
        return productos;
    }

    public void setProductos(Map<Integer, Producto> productos) {
        this.productos = productos;
    }
}

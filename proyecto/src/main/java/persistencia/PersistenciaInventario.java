package persistencia;

import controlador.GestorInventario;
import modelo.Producto;

import java.io.*;
import java.util.Map;

public class PersistenciaInventario {
    private static final String FILE = "inventario.dat";

    public static void guardar(GestorInventario gestor) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(gestor.getProductos());
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void cargar(GestorInventario gestor) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            Map<Integer, Producto> data = (Map<Integer, Producto>) in.readObject();
            gestor.setProductos(data);
            System.out.println("Inventario cargado exitosamente.");
        } catch (Exception e) {
            System.out.println("Inventario nuevo.");
        }
    }
}

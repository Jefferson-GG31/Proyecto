package vista;

import controlador.GestorInventario;
import persistencia.PersistenciaInventario;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorInventario gestor = new GestorInventario();
        PersistenciaInventario.cargar(gestor);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE INVENTARIO FERRETERÍA ROCA ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Ver inventario completo");
            System.out.println("3. Entrada de stock");
            System.out.println("4. Salida de stock");
            System.out.println("5. Buscar por nombre (Lambdas)");
            System.out.println("6. Reporte de productos con stock bajo (<5)");
            System.out.println("0. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> gestor.registrarProducto(sc);
                case 2 -> gestor.mostrarInventario();
                case 3 -> gestor.entradaStock(sc);
                case 4 -> gestor.salidaStock(sc);
                case 5 -> gestor.buscarPorNombre(sc);
                case 6 -> gestor.reporteStockBajo();
                case 0 -> PersistenciaInventario.guardar(gestor);
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}

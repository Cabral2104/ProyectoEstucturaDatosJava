package ProyectoEstructuraDatosJAVA;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void MostrarMenu() {
        System.out.println("A. Listas");
        System.out.println("B. Pilas");
        System.out.println("C. Colas");
        System.out.println("D. Árboles");
        System.out.println("E. Grafos");
        System.out.println("F. Salir");
    }

    public static IEstructuraDeDatos SeleccionarEstructura(String opcion1) {
        switch (opcion1) {
            case "A":
                return new Lista();
            // Agrega más casos para otras estructuras de datos según sea necesario
            case "B":
                return new Pila();
            case "C":
                return (IEstructuraDeDatos) new Cola();
            case "D":
                return new ArbolBinario();
            case "E":
                return new Grafo();
            default:
                return null;
        }
    }
}

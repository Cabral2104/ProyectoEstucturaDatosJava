package ProyectoEstructuraDatosJAVA;
import java.util.Scanner;







	public class Program {
    public static void main(String[] args) {
        IEstructuraDeDatos estructuraActual = null;
        boolean salirPrograma = false;

        while (!salirPrograma) {
            Menu.MostrarMenu();
            Scanner scanner = new Scanner(System.in);
            String opcion1 = scanner.nextLine();

            switch (opcion1.toUpperCase()) {
                case "A":
                case "B":
                case "C":
                case "D":
                case "E":
                    estructuraActual = Menu.SeleccionarEstructura(opcion1);

                    if (estructuraActual != null) {
                        System.out.println("Seleccionaste " + opcion1 + ". Puedes realizar operaciones en " + estructuraActual.getClass().getSimpleName() + ".");

                        while (true) {
                            if (opcion1.equals("E")) {
                                mostrarOperacionesGrafos();
                                String operacionGrafos = scanner.nextLine();

                                if (realizarOperacionGrafos(estructuraActual, operacionGrafos)) {
                                    break;
                                }
                            } else {
                                mostrarOperaciones();
                                String operacion = scanner.nextLine();

                                if (realizarOperacion(estructuraActual, operacion)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione una estructura válida.");
                    }
                    break;

                case "F":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    salirPrograma = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                    break;
            }
        }
    }

    private static void mostrarOperaciones() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Agregar dato");
        System.out.println("2. Eliminar dato");
        System.out.println("3. Mostrar datos");
        System.out.println("4. Cambiar estructura");
        System.out.println("5. Salir");
    }

    private static void mostrarOperacionesGrafos() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Agregar Vertice");
        System.out.println("2. Eliminar Vertice");
        System.out.println("3. Agregar Arista");
        System.out.println("4. Eliminar Arista");
        System.out.println("5. Mostrar Grafo");
        System.out.println("6. Cambiar De Estructura");
        System.out.println("7. Salir");
    }

    private static boolean realizarOperacion(IEstructuraDeDatos estructura, String operacion1) {
        switch (operacion1) {
            case "1":
                System.out.print("Ingrese un dato: ");
                String datoAgregar = new Scanner(System.in).nextLine();
                estructura.AgregarDato(datoAgregar);
                return false;
            case "2":
                System.out.print("Ingrese el dato a eliminar: ");
                String datoEliminar = new Scanner(System.in).nextLine();
                estructura.EliminarDato(datoEliminar);
                return false;
            case "3":
                estructura.MostrarDatos();
                return false;
            case "4":
                System.out.println("Cambiando estructura.");
                return true;
            case "5":
                System.out.println("Saliendo de la estructura actual.");
                return true;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una operación válida.");
                return false;
        }
    }

    private static boolean realizarOperacionGrafos(IEstructuraDeDatos estructura, String operacion1) {
        switch (operacion1) {
            case "1":
                System.out.print("Ingrese un Vertice: ");
                String datoAgregar = new Scanner(System.in).nextLine();
                estructura.AgregarDato(datoAgregar);
                return false;
            case "2":
                System.out.print("Ingrese el dato a eliminar: ");
                String datoEliminar = new Scanner(System.in).nextLine();
                estructura.EliminarDato(datoEliminar);
                return false;
            case "3":
                System.out.print("Ingrese el dato de origen: ");
                String datoOrigen = new Scanner(System.in).nextLine();
                System.out.print("Ingrese el dato de destino: ");
                String datoDestino = new Scanner(System.in).nextLine();
                ((Grafo) estructura).AgregarVertice(datoOrigen, datoDestino);
                return false;
            case "4":
                System.out.print("Ingrese el dato de origen: ");
                String datoOrigenEliminar = new Scanner(System.in).nextLine();
                System.out.print("Ingrese el dato de destino: ");
                String datoDestinoEliminar = new Scanner(System.in).nextLine();
                ((Grafo) estructura).EliminarVertice(datoOrigenEliminar, datoDestinoEliminar);
                return false;
            case "5":
                estructura.MostrarDatos();
                return false;
            case "6":
                System.out.println("Cambiando estructura.");
                return true;
            case "7":
                System.out.println("Saliendo de la estructura actual.");
                return true;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una operación válida.");
                return false;
        }
    }
}

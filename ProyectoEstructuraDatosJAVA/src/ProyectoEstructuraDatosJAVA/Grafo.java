package ProyectoEstructuraDatosJAVA;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Grafo implements IEstructuraDeDatos {
    private Map<String, List<String>> vertices;
    private List<Map.Entry<String, String>> aristas;

    public Grafo() {
        vertices = new HashMap<>();
        aristas = new ArrayList<>();
    }

    @Override
    public void AgregarDato(String dato) {
        if (!vertices.containsKey(dato)) {
            vertices.put(dato, new ArrayList<>());
            System.out.println("Vertice '" + dato + "' agregado al grafo.");
        } else {
            System.out.println("El vertice '" + dato + "' ya existe en el grafo.");
        }
    }

    @Override
    public void EliminarDato(String dato) {
        if (vertices.containsKey(dato)) {
            vertices.remove(dato);
            // Eliminar aristas relacionadas con el vértice
            aristas.removeIf(entry -> entry.getKey().equals(dato) || entry.getValue().equals(dato));
            System.out.println("Vertice '" + dato + "' eliminado del grafo.");
        } else {
            System.out.println("El vertice '" + dato + "' no encontrado en el grafo.");
        }
    }

    public void AgregarVertice(String datoOrigen, String datoDestino) {
        if (vertices.containsKey(datoOrigen) && vertices.containsKey(datoDestino)) {
            aristas.add(new AbstractMap.SimpleEntry<>(datoOrigen, datoDestino));
            System.out.println("Arista entre '" + datoOrigen + "' y '" + datoDestino + "' agregada.");
        } else {
            System.out.println("Al menos uno de los vértices no encontrado en el grafo.");
        }
    }

    public void EliminarVertice(String datoOrigen, String datoDestino) {
        if (vertices.containsKey(datoOrigen) && vertices.containsKey(datoDestino)) {
            aristas.remove(new Pair<>(datoOrigen, datoDestino));
            System.out.println("Arista entre '" + datoOrigen + "' y '" + datoDestino + "' eliminada.");
        } else {
            System.out.println("Al menos uno de los vértices no encontrado en el grafo.");
        }
    }

    public void AgregarArista(String datoOrigen, String datoDestino) {
        AgregarVertice(datoOrigen, datoDestino);
    }

    public void EliminarArista(String datoOrigen, String datoDestino) {
        EliminarVertice(datoOrigen, datoDestino);
    }

    public void MostrarGrafo() {
        if (vertices.isEmpty()) {
            System.out.println("Grafo vacío.");
        } else {
            System.out.println("Lista de Vértices:");
            for (String vertice : vertices.keySet()) {
                System.out.println(vertice);
            }

            System.out.println("Lista de Aristas:");
            for (Map.Entry<String, String> arista : aristas) {
                System.out.println(arista.getKey() + " - " + arista.getValue());
            }

        }
    }
   
    public void BuscarDato(String dato) {
        // Implement the logic to search for the specified data in the graph
        if (vertices.containsKey(dato)) {
            System.out.println("Dato '" + dato + "' encontrado en el grafo.");
        } else {
            System.out.println("Dato '" + dato + "' no encontrado en el grafo.");
        }
    }

    @Override
    public void MostrarDatos() {
        MostrarGrafo();
    }
}


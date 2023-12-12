package ProyectoEstructuraDatosJAVA;

import java.util.LinkedList;
import java.util.Queue;

public class Cola implements IEstructuraDeDatos {
    private Queue<String> datos = new LinkedList<>();

    @Override
    public void AgregarDato(String dato) {
        datos.add(dato);
    }

    @Override
    public void EliminarDato(String dato) {
        if (datos.contains(dato)) {
            // La eliminación en una cola implica desencolar hasta encontrar el elemento
            Queue<String> nuevaCola = new LinkedList<>();
            boolean elementoEliminado = false;

            while (!datos.isEmpty()) {
                String elemento = datos.poll();
                if (!elementoEliminado && elemento.equals(dato)) {
                    // Eliminar solo la primera ocurrencia del elemento
                    elementoEliminado = true;
                } else {
                    nuevaCola.add(elemento);
                }
            }

            // Restaurar la cola original
            while (!nuevaCola.isEmpty()) {
                datos.add(nuevaCola.poll());
            }

            if (elementoEliminado) {
                System.out.println(dato + " eliminado de la cola.");
            } else {
                System.out.println(dato + " no encontrado en la cola.");
            }
        } else {
            System.out.println(dato + " no encontrado en la cola.");
        }
    }

    @Override
    public void MostrarDatos() {
        System.out.println("Cola: " + String.join(", ", datos));
    }

	@Override
	public void BuscarDato(String dato) {
		// TODO Auto-generated method stub
		
	}
}


package ProyectoEstructuraDatosJAVA;
import java.util.Stack;

public class Pila implements IEstructuraDeDatos {
    private Stack<String> datos = new Stack<>();

    @Override
    public void AgregarDato(String dato) {
        datos.push(dato);
    }

    @Override
    public void EliminarDato(String dato) {
        if (datos.contains(dato)) {
            // La eliminación en una pila implica desapilar hasta encontrar el elemento
            Stack<String> nuevaPila = new Stack<>();
            boolean elementoEliminado = false;

            while (!datos.isEmpty()) {
                String elemento = datos.pop();
                if (!elementoEliminado && elemento.equals(dato)) {
                    // Eliminar solo la primera ocurrencia del elemento
                    elementoEliminado = true;
                } else {
                    nuevaPila.push(elemento);
                }
            }

            // Restaurar la pila original
            while (!nuevaPila.isEmpty()) {
                datos.push(nuevaPila.pop());
            }

            if (elementoEliminado) {
                System.out.println(dato + " eliminado de la pila.");
            } else {
                System.out.println(dato + " no encontrado en la pila.");
            }
        } else {
            System.out.println(dato + " no encontrado en la pila.");
        }
    }

    @Override
    public void MostrarDatos() {
        System.out.println("Pila: " + String.join(", ", datos));
    }

	@Override
	public void BuscarDato(String dato) {
		// TODO Auto-generated method stub
		
	}
}

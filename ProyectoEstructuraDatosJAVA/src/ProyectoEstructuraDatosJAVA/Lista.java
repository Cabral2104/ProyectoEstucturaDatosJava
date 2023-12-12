package ProyectoEstructuraDatosJAVA;

import java.util.ArrayList;
import java.util.List;

public class Lista implements IEstructuraDeDatos {
    private List<String> datos = new ArrayList<>();

    @Override
    public void AgregarDato(String dato) {
        datos.add(dato);
    }

    @Override
    public void EliminarDato(String dato) {
        if (datos.contains(dato)) {
            datos.remove(dato);
            System.out.println(dato + " eliminado de la lista.");
        } else {
            System.out.println(dato + " no encontrado en la lista.");
        }
    }

    @Override
    public void MostrarDatos() {
        System.out.println("Lista: " + String.join(", ", datos));
    }

	@Override
	public void BuscarDato(String dato) {
		// TODO Auto-generated method stub
		
	}
    
    // Agrega los métodos restantes de la interfaz si es necesario
}



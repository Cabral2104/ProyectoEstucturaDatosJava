package ProyectoEstructuraDatosJAVA;

public class NodoArbol {
    public int valor;
    public NodoArbol izquierda;
    public NodoArbol derecha;

    public NodoArbol(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

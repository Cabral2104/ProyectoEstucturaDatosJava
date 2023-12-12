package ProyectoEstructuraDatosJAVA;



public class ArbolBinario implements IEstructuraDeDatos {
    private NodoArbol raiz;

    @Override
    public void AgregarDato(String dato) {
        if (dato.matches("-?\\d+")) {
            int valor = Integer.parseInt(dato);
            raiz = AgregarNodo(raiz, valor);
            System.out.println(valor + " agregado al árbol.");
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
        }
    }

    private NodoArbol AgregarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return new NodoArbol(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = AgregarNodo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = AgregarNodo(nodo.derecha, valor);
        }

        return nodo;
    }

    @Override
    public void EliminarDato(String dato) {
        if (dato.matches("-?\\d+")) {
            int valor = Integer.parseInt(dato);
            if (BuscarNodo(raiz, valor) != null) {
                raiz = EliminarNodo(raiz, valor);
                System.out.println(valor + " eliminado del árbol.");
            } else {
                System.out.println(valor + " no encontrado en el árbol.");
            }
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
        }
    }

    private NodoArbol EliminarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = EliminarNodo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = EliminarNodo(nodo.derecha, valor);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            nodo.valor = EncontrarMinimoValor(nodo.derecha);
            nodo.derecha = EliminarNodo(nodo.derecha, nodo.valor);
        }

        return nodo;
    }

    private int EncontrarMinimoValor(NodoArbol nodo) {
        int minimoValor = nodo.valor;
        while (nodo.izquierda != null) {
            minimoValor = nodo.izquierda.valor;
            nodo = nodo.izquierda;
        }
        return minimoValor;
    }

    @Override
    public void MostrarDatos() {
        if (raiz == null) {
            System.out.println("Árbol vacío.");
        } else {
            System.out.println("Representación del Árbol Binario:");
            MostrarArbol(raiz, 0);
        }
    }

    private void MostrarArbol(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            MostrarArbol(nodo.derecha, nivel + 1);
            System.out.print(" ".repeat(nivel * 4));
            System.out.println(nodo.valor);
            MostrarArbol(nodo.izquierda, nivel + 1);
        }
    }

  
    public void BuscarDato(String dato) {
        if (dato.matches("-?\\d+")) {
            int valor = Integer.parseInt(dato);
            if (BuscarNodo(raiz, valor) != null) {
                System.out.println(valor + " encontrado en el árbol.");
            } else {
                System.out.println(valor + " no encontrado en el árbol.");
            }
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
        }
    }

    private NodoArbol BuscarNodo(NodoArbol nodo, int valor) {
        if (nodo == null || nodo.valor == valor) {
            return nodo;
        }

        if (valor < nodo.valor) {
            return BuscarNodo(nodo.izquierda, valor);
        }

        return BuscarNodo(nodo.derecha, valor);
    }
}



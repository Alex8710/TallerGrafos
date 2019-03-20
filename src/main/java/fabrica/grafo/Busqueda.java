package fabrica.grafo;

import java.util.List;

public interface Busqueda {
	
	public Nodo buscarNodo(List<Nodo> nodos, String nombre);
	
	public boolean existeRuta(List<Nodo> nodos, String origen, String destino) throws Exception;
	
	public List<Nodo> buscarRuta(List<Nodo> nodos, String origen, String destino) throws Exception;
	
	boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
}

package fabrica.grafo;

import java.util.ArrayList;
import java.util.List;

public interface Grafo {

	List<Nodo> nodos = new ArrayList<>();
	List<Arco> arcos = new ArrayList<>();
	
	//public void setAlgoritmoDeBusqueda();
	
	public void agregarNodo(String nombre);
	
	public void agregarArco(String origen, String destino, Busqueda b) throws Exception;
	
	public void crearArco(Nodo nodoOrigen, Nodo nodoDestino);
	
	public void agregarArcoConPeso(String origen, String destino, Busqueda b, int peso )throws Exception;
	
	public void crearArcoConPeso(Nodo origen, Nodo destino, int peso );
}

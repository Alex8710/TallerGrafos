package fabrica.grafo;

public class GrafoDirigido implements Grafo {
	
	public GrafoDirigido() { }

	
	public void agregarNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	public void agregarArco(String origen, String destino, Busqueda b) {
		
		Nodo nodoOrigen = b.buscarNodo(nodos, origen);
		Nodo nodoDestino = b.buscarNodo(nodos, destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		crearArco(nodoOrigen, nodoDestino);
	}
	
	public void crearArco(Nodo nodoOrigen, Nodo nodoDestino)
	{
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}


	@Override
	public void agregarArcoConPeso(String origen, String destino, Busqueda b, int peso) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void crearArcoConPeso(Nodo origen, Nodo destino, int peso) {
		// TODO Auto-generated method stub
		
	}
}
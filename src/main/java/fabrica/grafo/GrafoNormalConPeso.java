package fabrica.grafo;

public class GrafoNormalConPeso implements Grafo {
	
	public GrafoNormalConPeso() { }

	
	public void agregarNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	public void agregarArcoConPeso(String origen, String destino, Busqueda b, int peso) {
		
		Nodo nodoOrigen = b.buscarNodo(nodos, origen);
		Nodo nodoDestino = b.buscarNodo(nodos, destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		crearArcoConPeso(nodoOrigen, nodoDestino, peso);
	}
	
	public void crearArcoConPeso(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
		
		arco = new Arco();
		arco.setOrigen(nodoDestino);
		arco.setDestino(nodoOrigen);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoDestino.agregarArco(arco);
	}


	@Override
	public void agregarArco(String origen, String destino, Busqueda b) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void crearArco(Nodo nodoOrigen, Nodo nodoDestino) {
		// TODO Auto-generated method stub
		
	}	
}
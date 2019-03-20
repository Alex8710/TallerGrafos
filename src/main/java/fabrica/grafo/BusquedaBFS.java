package fabrica.grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//import ejemplo.grafoConBFS.Nodo;

public class BusquedaBFS implements Busqueda {

	public Nodo buscarNodo(List<Nodo> nodos, String nombre) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}
	
	public boolean existeRuta(List<Nodo> nodos, String origen, String destino) throws Exception {
		if (buscarRuta(nodos, origen, destino) != null) {
			return true;
		}
		return false;
	}
	
	public List<Nodo> buscarRuta(List<Nodo> nodos, String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(nodos, origen);
		Nodo nodoDestino = buscarNodo(nodos, destino);
		List<Nodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la B�squeda: NodoDestino no encontrado");
		}
		
		if (buscarRuta(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}
	
	public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
		
		// origen y destino son el mismo ?
				if(nodoOrigen.getNombre().equals(nodoDestino.getNombre())){
					System.err.println("Nodo destino encontrado en el mismo nodo origen");
				    nodosRuta.add(nodoOrigen);
		            return true;
		        }
				
				// si no son el mismo, revise las rutas usando una cola
		        Queue<Nodo> queue = new LinkedList<>();
				ArrayList<Nodo> nodosVisitados = new ArrayList<>();
		        
		        queue.add(nodoOrigen);
		        nodosVisitados.add(nodoOrigen);

		        while(!queue.isEmpty()){
		        	
		            Nodo actual = queue.remove();
		            if(actual.equals(nodoDestino)) {
		            	nodosRuta.add(actual);
		                return true;
		            }
		            else{
		                if(actual.getNodosAdyacentes().isEmpty())
		                    return false;
		                else {
		                	for (Nodo nodo: actual.getNodosAdyacentes()) {
		                		if (!nodosVisitados.contains(nodo))
		                			queue.add(nodo);
		                	}
		                }
		                    
		            }
		            if (!nodosRuta.contains(actual))
		            	nodosRuta.add(actual);
		        }

		        return false;
	}
}

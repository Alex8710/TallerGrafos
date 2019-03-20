package fabrica.grafo;

import properties.PropertyManager;
import java.util.List;

public class Fabrica {

	public static void main(String[] args) {
		
		try {
			
			//Define el objeto g de la interfaz Grafo
			Grafo g;
			
			//Define el objeto b de la interfaz Busqueda
			Busqueda b;
			
			//selecciono el tipo de grafo a usar dependiendo de la configuracion
			if (PropertyManager.getProperty("Dirigido")) {
				if (PropertyManager.getProperty("Con_peso")) {
					System.out.println("GRAFO DIRIGIDO CON PESO");
					g = new GrafoDirigidoConPeso();
				} else {
					System.out.println("GRAFO DIRIGIDO");
					g = new GrafoDirigido();
				}
			} else if (PropertyManager.getProperty("Con_peso")) {
				System.out.println("GRAFO NORMAL CON PESO");
				g = new GrafoNormalConPeso();
			} else {
				System.out.println("GRAFO NORMAL");
				g = new GrafoNormal();
			}
			
			//Selecciona el tipo de busqueda a usar dependiendo de la configuracion
			if(PropertyManager.getProperty("DFS")) {
				b = new BusquedaDFS();
				System.out.println("Usando Busqueda DFS");
			}
			else {
				b = new BusquedaBFS();
				System.out.println("Usando Busqueda BFS");
			}
			
			g.agregarNodo("A");
			g.agregarNodo("B");
			g.agregarNodo("C");
			
			if (PropertyManager.getProperty("Con_peso")){
				g.agregarArcoConPeso("A", "B", b, 1);
				g.agregarArcoConPeso("B", "C", b, 1);
				g.agregarArcoConPeso("A", "C", b, 2);
			} else {
				g.agregarArco("A", "B", b);
				g.agregarArco("B", "C", b);
				g.agregarArco("A", "C", b);
			}
			List<Nodo> camino = b.buscarRuta(g.nodos, "A", "C");

			if (camino == null) {
				System.out.println("Camino A -> C no encontrado");
			} else {
				System.out.println("Camino A -> C encontrado");
				for (Nodo nodo: camino) {
					System.out.println(nodo.getNombre());
				}				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			
			//Define el objeto g de la interfaz Grafo
			Grafo g;
			
			//Define el objeto b de la interfaz Busqueda
			Busqueda b;
			
			//selecciono el tipo de grafo a usar dependiendo de la configuracion
			if (PropertyManager.getProperty("Dirigido")) {
				if (PropertyManager.getProperty("Con_peso")) {
					System.out.println("GRAFO DIRIGIDO CON PESO");
					g = new GrafoDirigidoConPeso();
				} else {
					System.out.println("GRAFO DIRIGIDO");
					g = new GrafoDirigido();
				}
			} else if (PropertyManager.getProperty("Con_peso")) {
				System.out.println("GRAFO NORMAL CON PESO");
				g = new GrafoNormalConPeso();
			} else {
				System.out.println("GRAFO NORMAL");
				g = new GrafoNormal();
			}
			
			//Selecciona el tipo de busqueda a usar dependiendo de la configuracion
			if(PropertyManager.getProperty("DFS")) {
				b = new BusquedaDFS();
				System.out.println("Usando Busqueda DFS");
			}
			else {
				b = new BusquedaBFS();
				System.out.println("Usando Busqueda BFS");
			}
			
			g.agregarNodo("A");
			g.agregarNodo("B");
			g.agregarNodo("C");
			g.agregarNodo("D");
			g.agregarNodo("E");
			
			if (PropertyManager.getProperty("Con_peso")){
				g.agregarArcoConPeso("A", "B", b, 1);
				g.agregarArcoConPeso("B", "C", b, 1);
				g.agregarArcoConPeso("C", "D", b, 1);
				g.agregarArcoConPeso("E", "D", b, 2);
				g.agregarArcoConPeso("A", "C", b, 3);
			} else {
				g.agregarArco("A", "B", b);
				g.agregarArco("B", "C", b);
				g.agregarArco("C", "D", b);
				g.agregarArco("E", "D", b);
				g.agregarArco("A", "C", b);
			}
			
			List<Nodo> camino = b.buscarRuta(g.nodos, "A", "E");
			
			if (camino == null) {
				System.out.println("Camino A -> E no encontrado");
			} else {
				System.out.println("Camino A -> E encontrado");
				for (Nodo nodo: camino) {
					System.out.println(nodo.getNombre());
				}				
			}
			System.out.println();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
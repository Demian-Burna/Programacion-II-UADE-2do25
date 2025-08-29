package uso;

import implementacion.Cola;

public class uso{
	
public static void llenarCola(Cola cola) {
		
		for(int i = 0; i <= 5; i++) {
			cola.acolar(i);	
		}
	
	}

	public static void mostrarCola(Cola cola) {
		
		Cola Colaaux = new Cola();
		Colaaux.inicializarCola();
		do {
			int elemento = cola.primero();
			System.out.print("Elemento: " + elemento + "\n");
			Colaaux.acolar(elemento);
			cola.desacolar();
		}
		while(!cola.colaVacia());
		
		do {
			cola.acolar(Colaaux.primero());
			Colaaux.desacolar();
		}
		while(!Colaaux.colaVacia());
		
	}
	
	public static void main(String[] arg) {
		
		Cola cola1 = new Cola();
		cola1.inicializarCola();
		
		
	}
}
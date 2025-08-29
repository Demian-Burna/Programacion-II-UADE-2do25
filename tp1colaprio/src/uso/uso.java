package uso;

import implementación.ColaPrioridad;

public class uso {
	
	public static void llenarCola(ColaPrioridad cola) {
		
		for(int i = 0; i <= 5; i++) {
			cola.acolarPrioridad(i, (int)(Math.random()*11));	
		}
	
	}

	public static void mostrarCola(ColaPrioridad cola) {
		
		ColaPrioridad Colaaux = new ColaPrioridad();
		Colaaux.inicializarCola();
		do {
			int elemento = cola.primero();
			int prioridad = cola.prioridad();
			System.out.print("Elemento: " + elemento + ", Prioridad: " + prioridad + "\n");
			Colaaux.acolarPrioridad(elemento, prioridad);
			cola.desacolar();
		}
		while(!cola.colaVacia());
		
		do {
			cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
			Colaaux.desacolar();
		}
		while(!Colaaux.colaVacia());
		
	}

	public static ColaPrioridad unirColas(ColaPrioridad cola1, ColaPrioridad cola2) {
		
		ColaPrioridad colaunida = new ColaPrioridad();
		colaunida.inicializarCola();
		

		return colaunida;
	}
	
	public static void main(String[] args) {
		
	ColaPrioridad Cola1 = new ColaPrioridad();
	ColaPrioridad Cola2 = new ColaPrioridad();
		
	Cola1.inicializarCola();
	Cola2.inicializarCola();
	
	llenarCola(Cola1);
	System.out.print("primer vista\n");
	mostrarCola(Cola1);
	System.out.print("segunda vista\n");
	mostrarCola(Cola1);
	}
}
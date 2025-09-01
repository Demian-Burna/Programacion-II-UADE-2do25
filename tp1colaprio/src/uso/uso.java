package uso;

import implementación.ColaPrioridad;

public class uso {
	
	public static void llenarCola(ColaPrioridad cola) {
		
		for(int i = 0; i < 5; i++) {
			cola.acolarPrioridad((int)(Math.random()*11), (int)(Math.random()*11));	
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
	
	public static void vaciarCola(ColaPrioridad cola) {	
		while(!cola.colaVacia()) {cola.desacolar();}	
	}
	
	public static ColaPrioridad copiarCola(ColaPrioridad cola) {
		
		ColaPrioridad Colaaux = new ColaPrioridad();
		ColaPrioridad Colacopia = new ColaPrioridad();
		Colaaux.inicializarCola();
		Colacopia.inicializarCola();
		int elemento = 0;
		int prioridad = 0;

		while(!cola.colaVacia()) {
			elemento = cola.primero();
			prioridad = cola.prioridad();
			Colaaux.acolarPrioridad(elemento, prioridad);
			Colacopia.acolarPrioridad(elemento, prioridad);
			cola.desacolar();

		};
		
		while(!Colaaux.colaVacia()) {
			cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
			Colaaux.desacolar();
		};
		
		return Colacopia;
		
	}

	public static ColaPrioridad unirColas(ColaPrioridad cola1, ColaPrioridad cola2) {
		
		ColaPrioridad colaunida = new ColaPrioridad();
		colaunida.inicializarCola();
		
		while(!cola1.colaVacia()) {
			colaunida.acolarPrioridad(cola1.primero(),cola1.prioridad());
			cola1.desacolar();
		}
		while(!cola2.colaVacia()) {
			colaunida.acolarPrioridad(cola2.primero(),cola2.prioridad());
			cola2.desacolar();
		}
		
		return colaunida;
	}
	
	public static boolean igualdad(ColaPrioridad cola1, ColaPrioridad cola2) {
		
		ColaPrioridad colaaux1 = copiarCola(cola1);
		ColaPrioridad colaaux2 = copiarCola(cola2);
		
		while(!colaaux1.colaVacia()) {
			if(!(colaaux1.primero() == colaaux2.primero())) {
				return false;
			}
			colaaux1.desacolar();
			colaaux2.desacolar();
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
	ColaPrioridad Cola1 = new ColaPrioridad();
	ColaPrioridad Cola2 = new ColaPrioridad();
		
	Cola1.inicializarCola();
	Cola2.inicializarCola();
	
	llenarCola(Cola1);
	System.out.print("\nMostrando Cola 1:\n\n");
	mostrarCola(Cola1);
	
	llenarCola(Cola2);
	System.out.print("\nMostrando Cola 2:\n\n");
	mostrarCola(Cola2);
	
	//Punto a
	
	ColaPrioridad Colaunida = unirColas(Cola1,Cola2);
	System.out.print("\nMostrando Cola unida:\n\n");
	mostrarCola(Colaunida);
	
	//Punto b
	
	vaciarCola(Cola1);
	llenarCola(Cola1);
	vaciarCola(Cola2);
	llenarCola(Cola2);
	
	System.out.println("\nMostrando Colas para igualdad Negativa");
	System.out.println("\nCola 1:\n");
	mostrarCola(Cola1);
	System.out.println("\nCola 2:\n");
	mostrarCola(Cola2);
	
	if(igualdad(Cola1, Cola2)){
		System.out.println("\nLa Colas son iguales");
	}
	else {
		System.out.println("\nLa Colas NO son iguales");
	}
	
	Cola2 = copiarCola(Cola1);
	
	System.out.println("\nMostrando Colas para igualdad Positiva");
	System.out.println("\nCola 1:\n");
	mostrarCola(Cola1);
	System.out.println("\nCola 2:\n");
	mostrarCola(Cola2);
	
	if(igualdad(Cola1, Cola2)) {
		System.out.println("\nLa Colas son iguales");
	}
	else {
		System.out.println("\nLa Colas NO son iguales");
	}
	
	}
}
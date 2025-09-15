package uso;

import interfaz.ColaPrioridadTDA;
import imple.DiccionarioMultiple;
import implementación.ColaPrioridad;
import tda.DiccionarioMultipleTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;


public class uso {
	

	public static void llenarConjunto (ConjuntoTDA C) {
		
		int elemento = 0;
		
		for(int i = 0; i < 3; i++) {
			
			elemento = (int)(Math.random()*11);
			if(!(C.pertenece(elemento))) {
				
				C.agregar(elemento);
				
			} else {
				
				i--;
				
			};
			
		};
		
	};
	
	public static void vaciarConjunto (ConjuntoTDA C) {
		
		int elemento = 0;
		
		while(!C.conjuntoVacio()) {
			elemento = C.elegir();
			C.sacar(elemento);
		};
		
	};
	
	public static void mostrarConjunto (ConjuntoTDA C) {
		
		ConjuntoTDA CAux = new Conjunto();
		CAux.inicializarConjunto();
		int elemento = 0;
		
		if(!C.conjuntoVacio()) {
			while(!C.conjuntoVacio()) {
				elemento = C.elegir();
				System.out.println("\t" + elemento);
				
				CAux.agregar(elemento);
				C.sacar(elemento);
			};
			
			while(!CAux.conjuntoVacio()) {
				elemento = CAux.elegir();
				C.agregar(elemento);
				CAux.sacar(elemento);
			};
		} else {
			System.out.println("\n\tConjunto vacio\n");
		}
		
	};
	
	public static ConjuntoTDA copiarConjunto (ConjuntoTDA C) {
		
		ConjuntoTDA CCopia = new Conjunto();
		ConjuntoTDA CAux = new Conjunto();
		CCopia.inicializarConjunto();
		CAux.inicializarConjunto();
		int elemento = 0;
		
		while(!C.conjuntoVacio()) {
			elemento = C.elegir();
			CCopia.agregar(elemento);
			CAux.agregar(elemento);
			C.sacar(elemento);
		};
		
		while(!CAux.conjuntoVacio()) {
			elemento = CAux.elegir();
			C.agregar(elemento);
			CAux.sacar(elemento);
		};
		
		return CCopia;
		
	};
	
	public static void mostrarDM (DiccionarioMultipleTDA DM) {
		
		ConjuntoTDA Claves = DM.claves();
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = DM.recuperar(clave);
			System.out.println("Clave: " + clave);
			while(!Valores.conjuntoVacio()) {
				
				elemento = Valores.elegir();
				System.out.println("\t" + elemento);
				Valores.sacar(elemento);
			}
			
			Claves.sacar(clave);
		}
		

	}
	
	public static void llenarCola(ColaPrioridadTDA cola) {
		
		for(int i = 0; i < 10; i++) {
			cola.acolarPrioridad((int)(Math.random()*11), (int)(Math.random()*11));	
		}
	
	}

	public static void mostrarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA Colaaux = new ColaPrioridad();
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
	
	public static void vaciarCola(ColaPrioridadTDA cola) {	
		while(!cola.colaVacia()) {cola.desacolar();}	
	}
	
	public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA Colaaux = new ColaPrioridad();
		ColaPrioridadTDA Colacopia = new ColaPrioridad();
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

	public static ColaPrioridadTDA unirColas(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		
		ColaPrioridadTDA colaunida = new ColaPrioridad();
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
	
	public static boolean igualdad(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
		
		ColaPrioridadTDA colaaux1 = copiarCola(cola1);
		ColaPrioridadTDA colaaux2 = copiarCola(cola2);
		
		while(!colaaux1.colaVacia()) {
			if(!(colaaux1.primero() == colaaux2.primero())) {
				return false;
			}
			colaaux1.desacolar();
			colaaux2.desacolar();
		}
		
		return true;
	}
	
	public static DiccionarioMultipleTDA recuperarClaves (ColaPrioridadTDA C) {
		
		DiccionarioMultipleTDA DM = new DiccionarioMultiple();
		DM.inicializarDiccionario();
		int elemento = 0;
		int prioridad = 0;
		
		while(!C.colaVacia()) {
			elemento = C.primero();
			prioridad = C.prioridad();
			DM.agregar(elemento, prioridad);
			C.desacolar();
		}
		
		return DM;
		
		
	}
	
	public static void main(String[] args) {
		
		ColaPrioridadTDA Cola1 = new ColaPrioridad();
		ColaPrioridadTDA Cola2 = new ColaPrioridad();
			
		Cola1.inicializarCola();
		Cola2.inicializarCola();
		
		llenarCola(Cola1);
		System.out.print("\nMostrando Cola 1:\n\n");
		mostrarCola(Cola1);
		
		llenarCola(Cola2);
		System.out.print("\nMostrando Cola 2:\n\n");
		mostrarCola(Cola2);
		
		//Punto a
		
		ColaPrioridadTDA Colaunida = unirColas(Cola1,Cola2);
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
		
		vaciarCola(Cola1);
		llenarCola(Cola1);
		
		System.out.println("\nMostrando Colas para pasar a DM");
		
		mostrarCola(Cola1);
		
		DiccionarioMultipleTDA DM = recuperarClaves(Cola1);
		
		System.out.println("\nMostrando DM obtenido\n");
		mostrarDM(DM);
		
		
	}
		
}
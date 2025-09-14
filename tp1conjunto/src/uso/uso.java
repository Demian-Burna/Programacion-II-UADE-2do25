package uso;

import implementacion.Conjunto;
import imple.Pila;
import interfaz.ConjuntoTDA;
import tda.PilaTDA;
import imple.Cola;
import tda.ColaTDA;

public class uso {
	
public static void apilarNumeros (PilaTDA Pila) {
		
		for(int i = 0; i < 5; i++) {
			Pila.apilar(i);
		}
	}
	
	public static void mostrarPila (PilaTDA Pila) {
		
		System.out.println("Mostrando contenido de pila:");
		
		PilaTDA pilaaux = new Pila();
		pilaaux.inicializarPila();
		
		while(!Pila.pilaVacia()) {
			int tope = Pila.tope();
			System.out.println(tope);
			pilaaux.apilar(tope);
			Pila.desapilar();
		}
		
		while(!pilaaux.pilaVacia()) {
			Pila.apilar(pilaaux.tope());
			pilaaux.desapilar();
		}
		
	}
	
	public static void vaciarPila (PilaTDA Pila) {
		
		while(!Pila.pilaVacia()) {
			Pila.desapilar();
		}
	}
	
	public static PilaTDA copiarPila (PilaTDA Pila) {
		
		PilaTDA pilacopiada = new Pila();
		PilaTDA pilaaux = new Pila();
		pilacopiada.inicializarPila();
		pilaaux.inicializarPila();
		
		while(!Pila.pilaVacia()) {
			pilaaux.apilar(Pila.tope());
			Pila.desapilar();
		}
		
		while(!pilaaux.pilaVacia()) {
			int tope = pilaaux.tope();
			pilacopiada.apilar(tope);
			Pila.apilar(tope);
			pilaaux.desapilar();
		}
		
		
		return pilacopiada;
	}
	
	public static void llenarCola(ColaTDA cola) {
		
		for(int i = 0; i < 5; i++) {
			cola.acolar((int)(Math.random() * 101));	
		}
	
	}

	public static void vaciarCola(ColaTDA cola) {	
		while(!cola.colaVacia()) {cola.desacolar();}	
	}
	
	public static void mostrarCola(ColaTDA cola) {
		
		ColaTDA Colaaux = new Cola();
		
		Colaaux.inicializarCola();
		int indice = 1;
		while(!cola.colaVacia()) {
			int elemento = cola.primero();
			
			System.out.print("Elemento N°" + indice + ": " + elemento + "\n");
			Colaaux.acolar(elemento);
			cola.desacolar();
			indice++;
		};
		
		while(!Colaaux.colaVacia()) {
			cola.acolar(Colaaux.primero());
			Colaaux.desacolar();
		};
		
	}
	
	public static ColaTDA copiarCola(ColaTDA cola) {
			
			Cola Colaaux = new Cola();
			Cola Colacopia = new Cola();
			Colaaux.inicializarCola();
			Colacopia.inicializarCola();
			int elemento = 0;
	
			while(!cola.colaVacia()) {
				elemento = cola.primero();
				Colaaux.acolar(elemento);
				Colacopia.acolar(elemento);
				cola.desacolar();
	
			};
			
			while(!Colaaux.colaVacia()) {
				cola.acolar(Colaaux.primero());
				Colaaux.desacolar();
			};
			
			return Colacopia;
	}
	
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
	
	public static ConjuntoTDA union (ConjuntoTDA C1, ConjuntoTDA C2) {
		
		ConjuntoTDA CResultado = new Conjunto();
		CResultado.inicializarConjunto();
		ConjuntoTDA CAux1 = copiarConjunto(C1);
		ConjuntoTDA CAux2 = copiarConjunto(C2);
		int elemento = 0;
		
		while(!CAux1.conjuntoVacio()) {
			elemento = CAux1.elegir();
			CResultado.agregar(elemento);
			CAux1.sacar(elemento);
		};
		
		while(!CAux2.conjuntoVacio()) {
			elemento = CAux2.elegir();
			CResultado.agregar(elemento);
			CAux2.sacar(elemento);
		};
		
		while( !CAux1.conjuntoVacio()) {
			
		}
			
		return CResultado;
		
	}
	
	public static ConjuntoTDA interseccion (ConjuntoTDA C1, ConjuntoTDA C2) {
		
		ConjuntoTDA CResultado = new Conjunto();
		CResultado.inicializarConjunto();
		ConjuntoTDA CAux1 = copiarConjunto(C1);
		ConjuntoTDA CAux2 = copiarConjunto(C2);
		int elemento = 0;
		
		while( !CAux1.conjuntoVacio()) {
			elemento = CAux1.elegir();
			if (CAux2.pertenece(elemento)) {
				CResultado.agregar(elemento);
			};
			CAux1.sacar(elemento);
		};
		
		return CResultado;
		
	}

	public static ConjuntoTDA resta (ConjuntoTDA C1, ConjuntoTDA C2) {
		
		ConjuntoTDA CAux1 = copiarConjunto(C1);
		ConjuntoTDA CAux2 = copiarConjunto(C2);
		int elemento = 0;
		
		while(!CAux2.conjuntoVacio()) {
			
			elemento = CAux2.elegir();
			
			if (CAux2.pertenece(elemento)) {
				CAux1.sacar(elemento);
			};
			CAux2.sacar(elemento);
			
		}
		
		return CAux1;
		
	}
	
	public static ConjuntoTDA diferenciaSimetrica (ConjuntoTDA C1, ConjuntoTDA C2) {
		
		
		ConjuntoTDA CUnion = union(C1,C2);
		ConjuntoTDA CInterseccion = interseccion(C1,C2);
		ConjuntoTDA CDiferenciaSimetrica = resta(CUnion,CInterseccion);
		
		return CDiferenciaSimetrica;
	};
	
	public static boolean igualdad (ConjuntoTDA C1, ConjuntoTDA C2) {
		
		ConjuntoTDA CAux1 = copiarConjunto(C1);
		ConjuntoTDA CAux2 = copiarConjunto(C2);
		int elemento = 0;
		
		while(!CAux1.conjuntoVacio()) {
			elemento = CAux1.elegir();
			if(!(CAux2.pertenece(elemento))) {
				return false;
			}
			CAux1.sacar(elemento);
			
		}
		
		return true;
		
	}
	
	public static int cardinalidad (ConjuntoTDA C1) {
		
		ConjuntoTDA CAux = copiarConjunto(C1);
		int cardinalidad = 0;
		
		while(!CAux.conjuntoVacio()) {
			cardinalidad++;
			CAux.sacar(CAux.elegir());
		}
		
		return cardinalidad;
	}
	
	public static ConjuntoTDA llenarConjuntoConPila (PilaTDA P) {
		
		ConjuntoTDA C = new Conjunto();
		PilaTDA PAux = copiarPila(P);
		C.inicializarConjunto();
		
		while(!PAux.pilaVacia()) {
			C.agregar(PAux.tope());
			PAux.desapilar();
		}
		
		return C;
		
	}
	
	public static ConjuntoTDA llenarConjuntoConCola (ColaTDA Cola) {
		
		ConjuntoTDA C = new Conjunto();
		ColaTDA ColaAux = copiarCola(Cola);
		C.inicializarConjunto();
		
		while(!ColaAux.colaVacia()) {
			C.agregar(ColaAux.primero());
			ColaAux.desacolar();
		}
		
		return C;
		
	}
	
	public static void main (String[] args) {
		
		ConjuntoTDA C1 = new Conjunto();
		ConjuntoTDA C2 = new Conjunto();
		C1.inicializarConjunto();
		C2.inicializarConjunto();
		
		llenarConjunto(C1);
		llenarConjunto(C2);
		
		System.out.println("\nMostrando Conjunto 1 (Cardinalidad = " + cardinalidad(C1) + "):\n");
		mostrarConjunto(C1);
		
		System.out.println("\nMostrando Conjunto 2 (Cardinalidad = " + cardinalidad(C2) + "):\n");
		mostrarConjunto(C2);
		
		//Punto a
		
		ConjuntoTDA CUnion = union(C1,C2);
		
		System.out.println("\nMostrando Conjunto Union (Cardinalidad = " + cardinalidad(CUnion) + "):\n");
		mostrarConjunto(CUnion);

		ConjuntoTDA CInterseccion = interseccion(C1,C2);
		
		System.out.println("\nMostrando Conjunto Interseccion (Cardinalidad = " + cardinalidad(CInterseccion) + "):\n");
		mostrarConjunto(CInterseccion);
		
		ConjuntoTDA CResta1 = resta(C1,C2);
		
		System.out.println("\nMostrando Conjunto Resta1 (Cardinalidad = " + cardinalidad(CResta1) + "):\n");
		mostrarConjunto(CResta1);
		
		ConjuntoTDA CResta2 = resta(C2,C1);
		
		System.out.println("\nMostrando Conjunto Resta2 (Cardinalidad = " + cardinalidad(CResta2) + "):\n");
		mostrarConjunto(CResta2);
		
		ConjuntoTDA CDiferenciaSimetrica = diferenciaSimetrica(C2,C1);
		
		System.out.println("\nMostrando Conjunto Diferencia Simetrica (Cardinalidad = " + cardinalidad(CDiferenciaSimetrica) + "):\n");
		mostrarConjunto(CDiferenciaSimetrica);
		
		//Punto b
		
		System.out.println("\nMostrando conjuntos para igualdad negativa");
		
		System.out.println("\nMostrando Conjunto 1 (Cardinalidad = " + cardinalidad(C1) + "):\n");
		mostrarConjunto(C1);
		
		System.out.println("\nMostrando Conjunto 2 (Cardinalidad = " + cardinalidad(C2) + "):\n");
		mostrarConjunto(C2);
		
		if(igualdad(C1,C2)) {
			System.out.println("\nLos conjuntos son iguales\n");
		} else {
			System.out.println("\nLos conjuntos NO son iguales\n");
		}
		
		vaciarConjunto(C1);
		vaciarConjunto(C2);
		
		System.out.println("\nMostrando conjuntos para igualdad positiva");
		
		llenarConjunto(C1);
		C2 = copiarConjunto(C1);
		
		System.out.println("\nMostrando Conjunto 1:(Cardinalidad = " + cardinalidad(C1) + "):\n");
		mostrarConjunto(C1);
		
		System.out.println("\nMostrando Conjunto 2 (Cardinalidad = " + cardinalidad(C2) + "):\n");
		mostrarConjunto(C2);
		
		if(igualdad(C1,C2)) {
			System.out.println("\nLos conjuntos son iguales\n");
		} else {
			System.out.println("\nLos conjuntos NO son iguales\n");
		}
		
		
		PilaTDA P = new Pila();
		ColaTDA Cola = new Cola();
		P.inicializarPila();
		Cola.inicializarCola();
		
		apilarNumeros(P);
		llenarCola(Cola);
		
		System.out.println("\nMostrando Pila:\n");
		
		mostrarPila(P);
		
		System.out.println("\nMostrando Cola:\n");

		mostrarCola(Cola);
		
		System.out.println("\nMostrando Conjunto creado a partir de Pila y Cola (Cardinalidad = " + cardinalidad(C2) + "):\n");
		
		ConjuntoTDA CPila = llenarConjuntoConPila(P);
		ConjuntoTDA CCola = llenarConjuntoConCola(Cola);
		ConjuntoTDA CUnionPC = union(CPila,CCola);
		
		mostrarConjunto(CUnionPC);
		
		System.out.println("\nMostrando conjuntos para igualdad negativa");
		
		System.out.println("\nMostrando Conjunto Pila (Cardinalidad = " + cardinalidad(CPila) + "):\n");
		mostrarConjunto(CPila);
		
		System.out.println("\nMostrando Conjunto Cola (Cardinalidad = " + cardinalidad(CCola) + "):\n");
		mostrarConjunto(CCola);
		
		if(igualdad(CPila,CCola)) {
			System.out.println("\nLos conjuntos son iguales\n");
		} else {
			System.out.println("\nLos conjuntos NO son iguales\n");
		}
		
		vaciarPila(P);
		vaciarCola(Cola);
		
		P.apilar(1);
		P.apilar(2);
		P.apilar(3);
		P.apilar(4);
		P.apilar(5);
		
		Cola.acolar(1);
		Cola.acolar(2);
		Cola.acolar(3);
		Cola.acolar(4);
		Cola.acolar(5);
		
		vaciarConjunto(CPila);
		vaciarConjunto(CCola);
		
		CPila = llenarConjuntoConPila(P);
		CCola = llenarConjuntoConCola(Cola);
		
		System.out.println("\nMostrando conjuntos para igualdad positiva");
		
		System.out.println("\nMostrando Conjunto Pila (Cardinalidad = " + cardinalidad(CPila) + "):\n");
		mostrarConjunto(CPila);
		
		System.out.println("\nMostrando Conjunto Cola (Cardinalidad = " + cardinalidad(CCola) + "):\n");
		mostrarConjunto(CCola);
		
		if(igualdad(CPila,CCola)) {
			System.out.println("\nLos conjuntos son iguales\n");
		} else {
			System.out.println("\nLos conjuntos NO son iguales\n");
		}
		
	};
	
};









































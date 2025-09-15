package uso;

//Punto A

import implementacion.ConjuntoExtendido;
import interfaz.ConjuntoExtendidoTDA;

//Punto B

import tda.PilaTDA;
import tda.DiccionarioMultipleTDA;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import imple.DiccionarioMultiple;
import imple.Pila;
import imple.ColaPrioridad;
import imple.Conjunto;

public class uso {
	
	public static void llenarConjunto (ConjuntoExtendidoTDA C) {
		
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
	
	public static void mostrarConjunto (ConjuntoExtendidoTDA C) {
		
		ConjuntoExtendidoTDA CAux = new ConjuntoExtendido();
		CAux.inicializarConjunto();
		int elemento = 0;
		
		if(!C.conjuntoVacio()) {
			while(!C.conjuntoVacio()) {
				elemento = C.elegir();
				System.out.println("\t- " + elemento);
				
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

	public static void llenarDM(DiccionarioMultipleTDA DM) {
		
		for(int i = 0; i < 5; i++) {
			int clave = (int)(Math.random()*11);
			for(int j = 0; j < 3; j++) {
				DM.agregar(clave, (int)(Math.random()*11));
			}
		}
		
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
				System.out.println("\t- " + elemento);
				Valores.sacar(elemento);
			}
			
			Claves.sacar(clave);
		}
		

	};
	
	public static void mostrarPila (PilaTDA Pila) {
		
		System.out.println("Mostrando contenido de pila:");
		
		PilaTDA pilaaux = new Pila();
		pilaaux.inicializarPila();
		
		while(!Pila.pilaVacia()) {
			int tope = Pila.tope();
			System.out.println("\t- " + tope);
			pilaaux.apilar(tope);
			Pila.desapilar();
		}
		
		while(!pilaaux.pilaVacia()) {
			Pila.apilar(pilaaux.tope());
			pilaaux.desapilar();
		}
		
	};
	
	public static int ClaveMax (DiccionarioMultipleTDA DM) {
		
		ConjuntoTDA Claves = DM.claves();
		int ClaveMax = 0;
		int Clave = 0;
		
		do {
			Clave = Claves.elegir();
			if(Clave >= ClaveMax) {
				ClaveMax = Clave;
			}
			Claves.sacar(Clave);
		} while(!Claves.conjuntoVacio());
		
		return ClaveMax;
	};

	public static PilaTDA valoresClaveMaxima (DiccionarioMultipleTDA DM) {
		
		PilaTDA P = new Pila();
		ColaPrioridadTDA ColaAux = new ColaPrioridad();
		P.inicializarPila();
		ColaAux.inicializarCola();
		int ClaveMax = ClaveMax(DM);
		int Valor = 0;
		
		ConjuntoTDA Valores = DM.recuperar(ClaveMax);
		
		while(!Valores.conjuntoVacio()) {
			Valor = Valores.elegir();
			ColaAux.acolarPrioridad(Valor, Valor);
			Valores.sacar(Valor);
		}
		
		while(!ColaAux.colaVacia()) {
			P.apilar(ColaAux.primero());
			ColaAux.desacolar();
		}
		
		return P;
	};
		
	public static void main (String[] args) {
		
		System.out.println("\n\n------------------Punto A------------------\n\n");
		
			System.out.println("\nMostrando funcionalidades de Conjunto Extendido");
			
			ConjuntoExtendidoTDA CE1 = new ConjuntoExtendido();
			ConjuntoExtendidoTDA CE2 = new ConjuntoExtendido();
			CE1.inicializarConjunto();
			CE2.inicializarConjunto();
			
			llenarConjunto(CE2);
			llenarConjunto(CE1);
			
			System.out.println("\nMostrando Conjunto E 1 :\n");
			mostrarConjunto(CE1);
			
			System.out.println("\nMostrando Conjunto E 2 :\n");
			mostrarConjunto(CE2);
			
			System.out.println("\nMostrando Diferencia CE1 - CE2 :\n");
			ConjuntoExtendidoTDA CDiferencia = CE1.diferencia(CE2);
			mostrarConjunto(CDiferencia);
			
			System.out.println("\nMostrando Suma CE1:" + CE1.suma() + "\n");
			System.out.println("\nMostrando Suma CE2:" + CE2.suma() + "\n");
			
			CE1.vaciar();
			CE2.vaciar();
			
			System.out.println("\nVerificando Vaciado de Conjuntos:\n");
			
			System.out.println("\nMostrando Conjunto E 1 :\n");
			mostrarConjunto(CE1);
			
			System.out.println("\nMostrando Conjunto E 2 :\n");
			mostrarConjunto(CE2);
		
		System.out.println("\n\n------------------Punto B------------------\n\n");
			
			DiccionarioMultipleTDA DM = new DiccionarioMultiple();
			DM.inicializarDiccionario();
			llenarDM(DM);
			System.out.println("\nMostrando Diccionario Multiple :\n");
			mostrarDM(DM);
			
			System.out.println("\nMostrando Pila de Valores en Ordenados de la Clave Max (" + ClaveMax(DM) + ") :\n");
			PilaTDA P = valoresClaveMaxima(DM);
			mostrarPila(P);
	};
	
};









































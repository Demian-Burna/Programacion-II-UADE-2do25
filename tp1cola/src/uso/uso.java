package uso;

import imple.Pila;
import implementacion.Cola;

public class uso{
	
	public static void llenarCola(Cola cola) {
		
		for(int i = 0; i < 5; i++) {
			cola.acolar(i);	
		}
	
	}

	public static void mostrarCola(Cola cola) {
		
		Cola Colaaux = new Cola();
		
		Colaaux.inicializarCola();
		
		while(!cola.colaVacia()) {
			int elemento = cola.primero();
			System.out.print("Elemento: " + elemento + "\n");
			Colaaux.acolar(elemento);
			cola.desacolar();
		};
		
		while(!Colaaux.colaVacia()) {
			cola.acolar(Colaaux.primero());
			Colaaux.desacolar();
		};
		
	}
	
	public static Cola pasarCola(Cola cola) {
		
		Cola colanueva = new Cola();
		colanueva.inicializarCola();
		
		while(!cola.colaVacia()) {
			int elemento = cola.primero();
			colanueva.acolar(elemento);
			cola.desacolar();
		};
		
		return colanueva;
	}
	
	public static void invertirCola1 (Cola cola) {		
		
		Pila pilaux = new Pila();
		pilaux.inicializarPila();
		
		while(!cola.colaVacia()) {
			pilaux.apilar(cola.primero());
			cola.desacolar();
		}
		
		while(!pilaux.pilaVacia()) {
			cola.acolar(pilaux.tope());
			pilaux.desapilar();
		}
		
	}
	
	public static void main(String[] arg) {
		
		Cola cola1 = new Cola();
		cola1.inicializarCola();
		llenarCola(cola1);
		
		System.out.println("\nMostrando cola original\n");
		mostrarCola(cola1);
		
		Cola cola2 = pasarCola(cola1);
		System.out.println("\nMostrando cola 2\n");
		mostrarCola(cola2);
		
		cola1 = pasarCola(cola2);
		System.out.println("\nMostrando cola original\n");
		mostrarCola(cola1);
		
		invertirCola1(cola1);
		System.out.println("\nMostrando cola invertida\n");
		mostrarCola(cola1);
		
	}
}
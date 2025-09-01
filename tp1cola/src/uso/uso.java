package uso;

import imple.Pila;
import implementacion.Cola;

public class uso{
	
	public static void llenarCola(Cola cola) {
		
		for(int i = 0; i < 5; i++) {
			cola.acolar((int)(Math.random() * 101));	
		}
	
	}

	public static void vaciarCola(Cola cola) {	
		while(!cola.colaVacia()) {cola.desacolar();}	
	}
	
	public static void mostrarCola(Cola cola) {
		
		Cola Colaaux = new Cola();
		
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
	
	public static Cola copiarCola(Cola cola) {
		
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
	
	public static void invertirCola2 (Cola cola) {		
		
		int elementos = 0 ;
		Cola Colaaux = new Cola();
		Colaaux.inicializarCola();
		
		while(!cola.colaVacia()) {
			Colaaux.acolar(cola.primero());
			elementos++;
			cola.desacolar();
		}
		
		int[] arregloaux = new int[elementos];
		
		for(int i = 0; i < elementos; i++ ) {
			arregloaux[i] = Colaaux.primero();
			Colaaux.desacolar();
		}
		
		for(int i = elementos - 1; i >= 0 ; i--) {
			cola.acolar(arregloaux[i]);
		}
		
	}
	
	public static void igualFinal(Cola cola1 , Cola cola2){
		
		Cola colaaux = new Cola();
		colaaux.inicializarCola();
		int ultimoelemento1 = 0;
		int ultimoelemento2 = 0;
		
		while(!cola1.colaVacia()) {
			ultimoelemento1 = cola1.primero();
			colaaux.acolar(ultimoelemento1);
			cola1.desacolar();
		}
		
		while(!colaaux.colaVacia()) {
			cola1.acolar(colaaux.primero());
			colaaux.desacolar();
		}
		
		while(!cola2.colaVacia()) {
			ultimoelemento2 = cola2.primero();
			colaaux.acolar(ultimoelemento2);
			cola2.desacolar();
		}
			
		while(!colaaux.colaVacia()) {
			cola2.acolar(colaaux.primero());
			colaaux.desacolar();
		}
		
		if(ultimoelemento1 == ultimoelemento2) {
			System.out.println("El elemento final de la cola1 (" + ultimoelemento1 + ") es igual al de la cola 2 (" + ultimoelemento2 + ")\n");
		}
		else {
			System.out.println("\nEl elemento final de la cola1 (" + ultimoelemento1 + ") NO es igual al de la cola 2 (" + ultimoelemento2 + ")\n");
		}
		
	}
	
	public static boolean capicua(Cola cola) {
		
		Cola colaaux1 = copiarCola(cola);
		Cola colaaux2 = copiarCola(cola);
		invertirCola1(colaaux1);
		
		while(!colaaux1.colaVacia()) {
			if(!(colaaux2.primero() == colaaux1.primero())) {
				return false;
			}
			colaaux1.desacolar();
			colaaux2.desacolar();
		}
		
		return true;
		
	}
	
	public static boolean inversa(Cola cola1, Cola cola2) {
		
		Cola colaaux1 = copiarCola(cola1);
		Cola colaaux2 = copiarCola(cola2);
		invertirCola1(colaaux2);
		
		while(!colaaux1.colaVacia()) {
			if(!(colaaux1.primero() == colaaux2.primero())) {
				return false;
			}
			colaaux1.desacolar();
			colaaux2.desacolar();
		}
		
		return true;
		
	}
	
	public static void main(String[] arg) {
		
		Cola cola1 = new Cola();
		cola1.inicializarCola();
		llenarCola(cola1);
		
		System.out.println("\nMostrando cola original\n");
		mostrarCola(cola1);
		
		// Punto a
		Cola cola2 = pasarCola(cola1);
		System.out.println("\nMostrando cola 2 (Pasada)\n");
		mostrarCola(cola2);
		cola1 = pasarCola(cola2);
		System.out.println("\nMostrando cola original\n");
		mostrarCola(cola1);
		
		// Punto b
		invertirCola1(cola1);
		System.out.println("\nMostrando cola invertida1\n");
		mostrarCola(cola1);
		
		// Punto c
		invertirCola2(cola1);
		System.out.println("\nMostrando cola invertida2\n");
		mostrarCola(cola1);
		
		// Punto d
		llenarCola(cola2);
		System.out.println("\nMostrando cola1\n");
		mostrarCola(cola1);	
		System.out.println("\nMostrando cola2\n");
		mostrarCola(cola2);
		igualFinal(cola1,cola2);
		
		// punto e 
		vaciarCola(cola1);
		llenarCola(cola1);
		
		System.out.println("\nMostrando cola para capicua Negativo\n");
		mostrarCola(cola1);
		
		if(capicua(cola1)) {
			System.out.println("\nLa cola es capicua");
		}
		else {
			System.out.println("\nLa cola NO es capicua");
		}
		
		vaciarCola(cola1);
		cola1.acolar(10);
		cola1.acolar(20);
		cola1.acolar(30);
		cola1.acolar(30);
		cola1.acolar(20);
		cola1.acolar(10);
		
		System.out.println("\nMostrando cola para capicua Afirmativo\n");
		mostrarCola(cola1);
		
		if(capicua(cola1)) {
			System.out.println("\nLa cola es capicua");
		}
		else {
			System.out.println("\nLa cola NO es capicua");
		}
		
		// punto f
		
		vaciarCola(cola1);
		llenarCola(cola1);
		vaciarCola(cola2);
		llenarCola(cola2);
		
		System.out.println("\nMostrando colas para inversa Negativo");
		System.out.println("\nCola 1:\n");
		mostrarCola(cola1);
		System.out.println("\nCola 2:\n");
		mostrarCola(cola2);
		
		if(inversa(cola1, cola2)){
			System.out.println("\nLa colas son inversas");
		}
		else {
			System.out.println("\nLa colas NO son inversas");
		}
		
		cola2 = copiarCola(cola1);
		invertirCola1(cola2);
		
		System.out.println("\nMostrando colas para inversa Positivo");
		System.out.println("\nCola 1:\n");
		mostrarCola(cola1);
		System.out.println("\nCola 2:\n");
		mostrarCola(cola2);
		
		if(inversa(cola1, cola2)) {
			System.out.println("\nLa colas son inversas");
		}
		else {
			System.out.println("\nLa colas NO son inversas");
		}
		
	}
}
package uso;

import implementacion.Pila;
import interfaz.PilaTDA;

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
	
	public static PilaTDA invertirPila (PilaTDA Pila) {
		
		PilaTDA Pilainvertida = new Pila();
		Pilainvertida.inicializarPila();
		
		while(!Pila.pilaVacia()) {
			Pilainvertida.apilar(Pila.tope());
			Pila.desapilar();
		}
			
		return Pilainvertida;
			
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
	
	public static int contarElementos (PilaTDA Pila) {
		
		
		PilaTDA pilaaux = new Pila();
		pilaaux.inicializarPila();
		int elementos = 0;
		
		while(!Pila.pilaVacia()) {
			int tope = Pila.tope();
			elementos++;
			pilaaux.apilar(tope);
			Pila.desapilar();
		}
		
		while(!pilaaux.pilaVacia()) {
			Pila.apilar(pilaaux.tope());
			pilaaux.desapilar();
		}
		
		return elementos;
		
		
	}
	
	public static int sumaElementos (PilaTDA Pila) {
		
		
		PilaTDA pilaaux = new Pila();
		pilaaux.inicializarPila();
		int suma = 0;
		
		while(!Pila.pilaVacia()) {
			int tope = Pila.tope();
			suma += tope;
			pilaaux.apilar(tope);
			Pila.desapilar();
		}
		
		while(!pilaaux.pilaVacia()) {
			Pila.apilar(pilaaux.tope());
			pilaaux.desapilar();
		}
		
		return suma;
		
	}
	
	public static double promedio (PilaTDA Pila) {
		
		
		int elementos = contarElementos(Pila);
		int suma = sumaElementos(Pila);
		
		return suma/elementos;
		
		
	}
	
	public static void main(String[] args) {
		
		PilaTDA pilaoriginal = new Pila();
		PilaTDA pilaaux = new Pila();
		pilaoriginal.inicializarPila();
		pilaaux.inicializarPila();
		apilarNumeros(pilaoriginal);
		
		//Punto a - pasar una pila a otra
		
		System.out.println("\nPila original:\n");
		mostrarPila(pilaoriginal);
		PilaTDA Pilainvertida = invertirPila(pilaoriginal);
		System.out.println("\nPila invertida:\n");
		mostrarPila(Pilainvertida);
		pilaoriginal = invertirPila(Pilainvertida);
		Pilainvertida = null;
		
		//Punto b - copiar una pila a otra
		
		PilaTDA Pilacopiada = copiarPila(pilaoriginal);
		System.out.println("\nPila copiada:\n");
		mostrarPila(Pilacopiada);
		Pilacopiada = null;
		
		//Punto d
		
		System.out.println("\nCant. de elementos en Pila original:\n" + contarElementos(pilaoriginal));
		
		//Punto e
		
		System.out.println("\nDuma de elementos en Pila original:\n" + sumaElementos(pilaoriginal));
		
		//punto f
		
		System.out.println("\nPromedio de elementos en Pila original:\n" + promedio(pilaoriginal));
	}
}

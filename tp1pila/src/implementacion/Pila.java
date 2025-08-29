package implementacion;

import	interfaz.PilaTDA;

public class Pila implements PilaTDA {

		private int[] pila;
		private int indice;
		
		@Override
		public void inicializarPila() {
			pila = new int[100];
			indice = 0;
			
		}
		
		@Override
		public void apilar(int x) {
			pila[indice] = x;
			indice++;
		}
		
		@Override
		public void desapilar() {
			indice --;
		
		}
		
		@Override
		public int tope() {
			return pila[indice-1];
		}
		
		@Override
		public boolean pilaVacia() {
			return indice == 0;
		}
}

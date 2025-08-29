package implementacion;

import interfaz.ColaTDA;

public class Cola implements ColaTDA{
	
	private int[] Cola;
	private int indice;
	
	@Override
	public void inicializarCola() {
		Cola = new int[100];
		indice = 0;
	}
	
	@Override
	public void acolar(int x) {
		for(int i = indice; i >= 0; i--) {
			Cola[i+1] = Cola[i];
			
		}
		indice++;
		Cola[0] = x;
	}
	
	@Override
	public void desacolar() {
		indice--;
	}
	
	@Override
	public int primero() {
		return Cola[indice-1];
	}
	
	@Override
	public boolean colaVacia() {
		return indice == 0;
		
	}
}
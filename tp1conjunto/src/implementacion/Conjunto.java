package implementacion;

import interfaz.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	protected int[] a;
	protected int cant;
	
	@Override
	public void inicializarConjunto() {
		a = new int[100];
		cant = 0;
	}
	
	@Override
	public void agregar(int x) {
		if (!this.pertenece(x)){ //Verification de no pertenece
			a[cant] = x;
			cant++; //nuevo elemento
		}
	}
	
	@Override
	public boolean conjuntoVacio() {
		return (cant == 0);
	}
	
	@Override
	public int elegir() { //arbitrario
		int max = cant-1;
		int min = 0;
		int pos = (int)(Math.random() * (max-min+1) + min);
		return a[pos]; 
	}
	
	@Override
	public boolean pertenece(int x) {
		int i = 0;
		while (i < cant && a[i] != x)
			i++;
		return (i < cant);
	}
	
	@Override
	public void sacar(int x) {
		int i = 0;
		while (i < cant && a[i] != x)
			i++;
		if (i < cant){ //elemento encontrado
			a[i] = a[cant-1];
			cant--;
		}
	}
}
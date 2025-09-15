package implementacion;

import interfaz.ConjuntoExtendidoTDA;

public class ConjuntoExtendido  implements ConjuntoExtendidoTDA {
	
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
			if(cant < 10) {
				a[cant] = x;
				cant++; //nuevo elemento
			} else {
				System.out.print("Elementos maximo alcanzado");
			}
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
	
	@Override
	public ConjuntoExtendidoTDA diferencia (ConjuntoExtendidoTDA otro) { 
		
		ConjuntoExtendidoTDA CResultado = new ConjuntoExtendido();
		CResultado.inicializarConjunto();
		
		for(int i = 0; i < cant; i++) {
			
			if(!otro.pertenece(a[i])) {
				
				CResultado.agregar(a[i]);
				
			}
		}
		
		return CResultado; //C
		
	}
	
	@Override 
	public int suma() { //L
		
		int suma = 0;
		
		for(int i = 0; i < cant; i++) {
			suma += a[i];
		}
		return suma; //C
		
	}
	
	@Override
	public void vaciar() { //C
	
		this.cant = 0; //C
		
	}
}
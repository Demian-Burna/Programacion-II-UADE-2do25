package implementacion;

import imple.Conjunto;
import interfaz.diccionariosimpleTDA;

public class diccionariosimple implements diccionariosimpleTDA {
	
	private class Elemento {
		int clave;
		int valor;
	}
	
	private Elemento[] elementos;
	private int cant;
	
	private int clave2indice(int clave) {
		int i = cant - 1;
		while (i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;
	
	}

	@Override 
	public void inicializarDiccionario() {
		cant = 0;
		elementos = new Elemento[100];
	}
	
	@Override 
	public void agregar(int clave, int valor) {
		int pos = this.clave2indice(clave);
		if(pos == -1) {
			elementos[cant] = new Elemento();
			elementos[cant].clave = clave;
			elementos[cant].valor = valor;
			cant++;
		} else {
			elementos[pos].valor = valor;
		}
	}
	
	@Override 
	public void eliminar(int clave) {
		int pos = clave2indice(clave);
		if (pos != -1) {
			elementos[pos] = elementos[cant-1];
			cant --;
		}
	}
	
	@Override 
	public int recuperar(int clave) {
		int pos = clave2indice(clave);
		return elementos[pos].valor;
	}
	
	@Override
	public Conjunto claves() {
		Conjunto c = new Conjunto();
		c.inicializarConjunto();
		for (int i=0; i < cant; i++) {
			c.agregar(elementos[i].clave);
		}
		return c;
	}
}
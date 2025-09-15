package uso;

import imple.Conjunto;
import imple.ColaPrioridad;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import implementacion.diccionariomultiple;
import interfaz.diccionariomultipleTDA;
import tda.DiccionarioSimpleTDA;
import imple.DiccionarioSimple;

public class uso {
	public static void mostrarDM (diccionariomultipleTDA DM) {
		
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
				System.out.println("\t" + elemento);
				Valores.sacar(elemento);
			}
			
			Claves.sacar(clave);
		}
		

	}
	
	public static void llenarCola(ColaPrioridadTDA cola) {
		
		for(int i = 0; i < 10; i++) {
			cola.acolarPrioridad((int)(Math.random()*11), (int)(Math.random()*11));	
		}
	
	}

	public static void mostrarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA Colaaux = new ColaPrioridad();
		Colaaux.inicializarCola();
		do {
			int elemento = cola.primero();
			int prioridad = cola.prioridad();
			System.out.print("Elemento: " + elemento + ", Prioridad: " + prioridad + "\n");
			Colaaux.acolarPrioridad(elemento, prioridad);
			cola.desacolar();
		}
		while(!cola.colaVacia());
		
		do {
			cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
			Colaaux.desacolar();
		}
		while(!Colaaux.colaVacia());
		
	}
	
	public static void vaciarCola(ColaPrioridadTDA cola) {	
		while(!cola.colaVacia()) {cola.desacolar();}	
	}
	
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
	
	public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA Colaaux = new ColaPrioridad();
		ColaPrioridadTDA Colacopia = new ColaPrioridad();
		Colaaux.inicializarCola();
		Colacopia.inicializarCola();
		int elemento = 0;
		int prioridad = 0;

		while(!cola.colaVacia()) {
			elemento = cola.primero();
			prioridad = cola.prioridad();
			Colaaux.acolarPrioridad(elemento, prioridad);
			Colacopia.acolarPrioridad(elemento, prioridad);
			cola.desacolar();

		};
		
		while(!Colaaux.colaVacia()) {
			cola.acolarPrioridad(Colaaux.primero(), Colaaux.prioridad());
			Colaaux.desacolar();
		};
		
		return Colacopia;
		
	}

	public static diccionariomultipleTDA copiarDM (diccionariomultipleTDA DM) {
		
		diccionariomultipleTDA DMcopia = new diccionariomultiple();
		DMcopia.inicializarDiccionario();
		ConjuntoTDA Claves = DM.claves();
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = DM.recuperar(clave);
			while(!Valores.conjuntoVacio()) {
				
				elemento = Valores.elegir();
				DMcopia.agregar(clave, elemento);
				Valores.sacar(elemento);
				
			}
			
			Claves.sacar(clave);
		}
		
		return DMcopia;
	}
	
	public static void llenarDM(diccionariomultipleTDA DM) {
		
		for(int i = 0; i < 3; i++) {
			int clave = (int)(Math.random()*11);
			for(int j = 0; j < 3; j++) {
				DM.agregar(clave, (int)(Math.random()*11));
			}
		}
		
	}
	
	public static void llenarDS(DiccionarioSimpleTDA DS) {
		
		for(int i = 0; i < 10; i++) {
			
			DS.agregar((int)(Math.random()*11), (int)(Math.random()*11));
			
		}
		
	}
	
	public static diccionariomultipleTDA unirDMsValorRepetido(diccionariomultipleTDA DM1, diccionariomultipleTDA DM2) {
		
		diccionariomultipleTDA DMUnido = new diccionariomultiple();
		DMUnido.inicializarDiccionario();
		ConjuntoTDA Claves = union(DM1.claves(),DM2.claves());
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = union(DM1.recuperar(clave),DM2.recuperar(clave));
			
			while(!Valores.conjuntoVacio()) {
				
				elemento = Valores.elegir();
				if(DM1.claves().pertenece(clave) && DM2.claves().pertenece(clave)) {
					
					if(DM1.recuperar(clave).pertenece(elemento) && DM2.recuperar(clave).pertenece(elemento) ) {
						
						DMUnido.agregar(clave, elemento);
						
					}
				} else {
					
					DMUnido.agregar(clave, elemento);
					
				}
				
				Valores.sacar(elemento);	
				
			};
			
			Claves.sacar(clave);
			
		};
		
		return DMUnido;
		
	}
	
	public static diccionariomultipleTDA unirDMsClaveRepetida(diccionariomultipleTDA DM1, diccionariomultipleTDA DM2) {
		
		diccionariomultipleTDA DMUnido = new diccionariomultiple();
		DMUnido.inicializarDiccionario();
		ConjuntoTDA Claves = union(DM1.claves(),DM2.claves());
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = union(DM1.recuperar(clave),DM2.recuperar(clave));
			if(DM1.claves().pertenece(clave) && DM2.claves().pertenece(clave)){
				while(!Valores.conjuntoVacio()) {
					
					elemento = Valores.elegir();
					DMUnido.agregar(clave, elemento);
					Valores.sacar(elemento);	
					
				};
			}
			
			Claves.sacar(clave);
			
		};
		
		return DMUnido;
		
	}

	public static diccionariomultipleTDA unirDMsClaveValorRepetido(diccionariomultipleTDA DM1, diccionariomultipleTDA DM2) {
		
		diccionariomultipleTDA DMUnido = new diccionariomultiple();
		DMUnido.inicializarDiccionario();
		ConjuntoTDA Claves = union(DM1.claves(),DM2.claves());
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = union(DM1.recuperar(clave),DM2.recuperar(clave));
			if(DM1.claves().pertenece(clave) && DM2.claves().pertenece(clave)){
				
				while(!Valores.conjuntoVacio()) {
					
					elemento = Valores.elegir();
					
					if(DM1.claves().pertenece(clave) && DM2.claves().pertenece(clave)) {
						
						if(DM1.recuperar(clave).pertenece(elemento) && DM2.recuperar(clave).pertenece(elemento) ) {
							
							DMUnido.agregar(clave, elemento);
							
						}
					
					};
					
					Valores.sacar(elemento);	
				
				}
			}
			
			Claves.sacar(clave);
			
		};
		
		return DMUnido;
		
	};
	
	public static diccionariomultipleTDA unirDMs(diccionariomultipleTDA DM1, diccionariomultipleTDA DM2) {
		
		diccionariomultipleTDA DMUnido = new diccionariomultiple();
		DMUnido.inicializarDiccionario();
		ConjuntoTDA Claves = union(DM1.claves(),DM2.claves());
		ConjuntoTDA Valores = new Conjunto();
		Valores.inicializarConjunto();
		int clave = 0;
		int elemento = 0;
		
		while(!Claves.conjuntoVacio()) {
			
			clave = Claves.elegir();
			Valores = union(DM1.recuperar(clave),DM2.recuperar(clave));
			
			while(!Valores.conjuntoVacio()) {
				
				elemento = Valores.elegir();
				DMUnido.agregar(clave, elemento);
				Valores.sacar(elemento);	
			};
			
			Claves.sacar(clave);
			
		};
		
		return DMUnido;
		
	}
	
	public static void main(String[] arg) {
		
		diccionariomultipleTDA DM1 = new diccionariomultiple();
		diccionariomultipleTDA DM2 = new diccionariomultiple();
		DM1.inicializarDiccionario();
		DM2.inicializarDiccionario();
		
		llenarDM(DM1);
		llenarDM(DM2);
		
		System.out.println("\n\nMostrando DM1\n\n");
		mostrarDM(DM1);
		
		System.out.println("\n\nMostrando DM2\n\n");
		mostrarDM(DM2);
		
		System.out.println("\n\nMostrando DMUnido\n\n");
		diccionariomultipleTDA DMUnido = unirDMs(DM1,DM2);
		mostrarDM(DMUnido);
		
		System.out.println("\n\nMostrando DMUnido Valores Repetidos\n\n");
		diccionariomultipleTDA DMUnidoValorRepetido = unirDMsValorRepetido(DM1,DM2);
		mostrarDM(DMUnidoValorRepetido);
		
		System.out.println("\n\nMostrando DMUnido Clave Repetida\n\n");
		diccionariomultipleTDA DMUnidoClaveRepetida = unirDMsClaveRepetida(DM1,DM2);
		mostrarDM(DMUnidoClaveRepetida);
		
		System.out.println("\n\nMostrando DMUnido Valores y Clave Repetidos\n\n");
		diccionariomultipleTDA unirDMsClaveValorRepetido = unirDMsClaveValorRepetido(DM1,DM2);
		mostrarDM(unirDMsClaveValorRepetido);
		
		DiccionarioSimpleTDA DS = new DiccionarioSimple();
		DS.inicializarDiccionario();
		
		
	
	}
	
}


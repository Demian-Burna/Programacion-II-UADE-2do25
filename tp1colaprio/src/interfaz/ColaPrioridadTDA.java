package interfaz;

public interface ColaPrioridadTDA {
	
	void inicializarCola();
	void acolarPrioridad(int x, int prio);
	void desacolar();
	int primero();
	int prioridad();
	boolean colaVacia();
	
}
package interfaz;

import tda.ConjuntoTDA;

public interface diccionariosimpleTDA {
	
	void inicializarDiccionario();
	void agregar(int clave, int valor);
	void eliminar(int clave);
	int recuperar(int clave);
	ConjuntoTDA claves();
	
}
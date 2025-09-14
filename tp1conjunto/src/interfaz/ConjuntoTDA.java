package interfaz;


public interface ConjuntoTDA {
	public void inicializarConjunto();
	public void agregar(int x);
	public boolean conjuntoVacio();
	public int elegir();
	public boolean pertenece(int x);
	public void sacar(int x);
}
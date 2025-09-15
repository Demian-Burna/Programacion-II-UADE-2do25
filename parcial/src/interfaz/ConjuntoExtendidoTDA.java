package interfaz;

public interface ConjuntoExtendidoTDA{
	public void inicializarConjunto();
	public void agregar(int x);
	public boolean conjuntoVacio();
	public int elegir();
	public boolean pertenece(int x);
	public void sacar(int x);
	public ConjuntoExtendidoTDA diferencia(ConjuntoExtendidoTDA otro);
	public int suma();
	public void vaciar();
}

public class Soldado {
	private String nombre;
	private int nivelVida;
	private int fila;
	private int columna;
	
	// Metodos mutadores
	public void setNombre(String n){
		nombre = n;
	}
	public void setNivelVida(int f){
		nivelVida = f;
	}
	public void setFila(int p){
		fila = p;
	}
	public void setColumna(int c){
		columna = c;
	}
	// Metodos accesores
	public String getNombre(){
		return nombre;
	}
	public int getNivelVida(){
		return nivelVida;
	}
	
	public int getFila(){
		return fila;
	}
	public int getColumna(){
		return columna;
	}
}


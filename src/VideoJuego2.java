import java.util.*;
public class VideoJuego2 {  // Version terminada
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = numeroSoldados();
		System.out.println("-----------------------------------------");
		Soldado[][] tablero = new Soldado[10][10];
		int[][] ind = crearSoldados(tablero, n);
		imprimirSoldados(tablero);
		soldadoMayorNivelVida(tablero);
		promedioNivelVida(tablero);
		soldadosPorOrdenDeCreacion(tablero, ind);
		Soldado[] rank = ordBurbuja(tablero, n);
		ordPorSeleccion(rank);
		soldadosRanking(rank);
	}
	
	
	public static int numeroSoldados() {
		int n = (int)(Math.random() * (10 - 1 + 1) + 1);
		return n;
	}
	
	public static int[][] crearSoldados(Soldado[][] x, int n) {
		int[][] ind = new int[n][2];
		for (int i = 0; i < n; i++) {
            Soldado soldado = new Soldado();
            soldado.setNombre("Soldado" + i);
            soldado.setNivelVida((int)(Math.random() * (5 - 1 + 1) + 1));
            int fila, columna;
            do {
                fila = (int)(Math.random() * (9 - 0 + 1));
                columna = (int)(Math.random() * (9 - 0 + 1));
            } while (x[fila][columna] != null);
            x[fila][columna] = soldado;
            soldado.setFila(fila);
            soldado.setColumna(columna);
            ind[i][0] = fila;
            ind[i][1] = columna;
        }
		return ind;
	}
	
	public static void imprimirSoldados(Soldado[][] x) {
		for (int fila = 0; fila < x.length; fila++) {
            for (int columna = 0; columna < x[fila].length; columna++) {
                if (x[fila][columna] != null)
                    System.out.print("| " +  x[fila][columna].getNombre().charAt(7) + " ");
                else
                    System.out.print("| _ ");
            }
            System.out.println("|");
		}
    }
	
	public static void soldadoMayorNivelVida(Soldado[][] x) {
		System.out.println("-----------------------------------------");
		int max = 0;
		int ind1 = -1;
		int ind2 = -1;
		for(int i = 0; i < x.length; i++)
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] != null) {
                    if(x[i][j].getNivelVida() > max) {
                    	ind1 = i;
                		ind2 = j;
                    }
                    max = Math.max(max, x[i][j].getNivelVida());
                }
			}
		System.out.println("Soldado con mayor nivel de vida: ");
		System.out.println("Nombre: " + x[ind1][ind2].getNombre());
		System.out.println("Nivel de Vida: " + x[ind1][ind2].getNivelVida());
		System.out.println("Fila: " + (x[ind1][ind2].getFila() + 1));
		System.out.println("Columna: " + (x[ind1][ind2].getColumna() + 1));
		
	}
	
	 //el promedio de nivel de vida de todos los soldados creados
	public static void promedioNivelVida(Soldado[][] x) {
		int cont = 0;
		int sum = 0;
		for(int i = 0; i < x.length; i++)
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] != null) {
                    sum = sum + x[i][j].getNivelVida();
                    cont++;
                }
			}
		System.out.println("-----------------------------------------");
		System.out.println("El promedio de nivel de vida de todos los soldados es: " + (sum / cont));
		System.out.println("-----------------------------------------");
		System.out.println("El nivel de vida de todo el ejército es: " + sum);
		
		
	}
	public static void soldadosPorOrdenDeCreacion(Soldado[][] x, int[][] ind) {
		System.out.println("-----------------------------------------");
		System.out.println("\nORDEN EN EL QUE FUERON CREADOS\n");
		for(int i = 0; i < ind.length; i++) {
			System.out.println("Nombre: " + x[ind[i][0]][ind[i][1]].getNombre());
			System.out.println("Nivel de Vida: " + x[ind[i][0]][ind[i][1]].getNivelVida());
			System.out.println("Fila: " + (x[ind[i][0]][ind[i][1]].getFila() + 1));
			System.out.println("Columna: " + (x[ind[i][0]][ind[i][1]].getColumna() + 1));
			System.out.println("-----------------------------------------");
		}
	}
	public static Soldado[] ordBurbuja(Soldado[][] x, int n) {
		Soldado[] aux = new Soldado[n];
		int cont = 0;
		for(int i = 0; i < x.length; i++)
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] != null) {
                    aux[cont] = x[i][j];
                    cont++;
				}
			}
		Soldado temp = new Soldado();
		for(int i = 1; i < aux.length; i++)
			for(int j = 0; j < aux.length - 1; j++) 
				if(aux[i].getNivelVida() < aux[j].getNivelVida()) {
					temp = aux[i];
					aux[i] = aux[j];
					aux[j] = temp;
				}
		return aux;
	}
	
	public static void ordPorSeleccion(Soldado x[]) {
        int min, ind;
        Soldado temp = new Soldado();
        for (int i = 0; i < x.length - 1; i++) {      
              min = x[i].getNivelVida();                                       
              ind = i;        
              for (int j = i + 1; j < x.length; j++)
                    if (x[j].getNivelVida() < min) {         
                        min = x[j].getNivelVida();            
                        ind = j;
                    }
              if (ind != i){                                            
                  temp = x[i];
                  x[i] = x[ind];
                  x[ind] = temp;
              }
        }
	}
	public static void soldadosRanking(Soldado[] x) {
		System.out.println("-----------------------------------------");
		System.out.println("\nSOLDADOS RANKEADOR POR NIVEL DE VIDA\n");
		for(int i = x.length - 1; i >= 0; i--) {
			System.out.println("Nombre: " + x[i].getNombre());
			System.out.println("Nivel de Vida: " + x[i].getNivelVida());
			System.out.println("Fila: " + (x[i].getFila() + 1));
			System.out.println("Columna: " + (x[i].getColumna() + 1));
			System.out.println("-----------------------------------------");
		}
	}
}
	


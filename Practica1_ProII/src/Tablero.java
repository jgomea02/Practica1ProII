import java.util.ArrayList;

public class Tablero {
	private char tablero[][];
	
	public Tablero(int tam) {
		this.tablero = new char[tam][tam]; 
		inicializoTablero();
	}

	public void inicializoTablero() {
		// TODO Auto-generated method stub
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int col = 0; col < tablero.length; col++) {
				tablero[fila][col] = '.';
			}
		}
		
	}
	
	public void dibujoTablero() {
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int col = 0; col < tablero.length; col++) {
				System.out.print(tablero[fila][col] + " ") ;
			}
			System.out.println();
		}
	}
	
	public boolean esFinal() {
		boolean end = false;
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int col = 0; col < tablero.length; col++) {
				if(tablero[fila][col] == '.' || tablero[fila][col] == 'X') {
					end = false;
				}else { 
					end = true;
				}
			}
		}
		return end;
	}

	public void colocoTren(Tren tren) {
		// TODO Auto-generated method stub
		char direccionTren = tren.getDireccion();
		switch(direccionTren) {
		case 'A': colocoArriba(tren);
		break;
		case 'B': colocoAbajo(tren);
		break;
		case 'D': colocoDerecha(tren);
		break;
		case 'I': colocoIzquierda(tren);
		break;
		//case 'X': tablero[tren.getFilaTablero()][tren.getColumna()] = 'X';
		//break;
		}
	}

	private void colocoDerecha(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();

		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] == '.') {
				tablero[fila][col] = 'D';
			} else {
				tablero[fila][col] = 'X';
			}
			col--;
		}
	}
	private void colocoIzquierda(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();
		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] == '.') {
				tablero[fila][col] = 'I';
			} else {
				tablero[fila][col] = 'X';
			}
			col++;
		}
	}
	private void colocoAbajo(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();

		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] == '.') {
				tablero[fila][col] = 'B';
			} else {
				tablero[fila][col] = 'X';
			}
			fila--;
		}
	}
	private void colocoArriba(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();

		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] == '.') {
				tablero[fila][col] = 'A';
			} else {
				tablero[fila][col] = 'X';
			}
			fila++;
		}
	}

	public void muevoTrenes(Tren tren) {
		// TODO Auto-generated method stub
		char casilla = comprueboCasillaAOcupar(tren);
		borroTren(tren);
		tren.muevoTren(casilla);
		colocoTren(tren);
	}
	
	private char comprueboCasillaAOcupar(Tren tren) {
		// TODO Auto-generated method stub
		if(tren.getDireccion() == 'A' && tren.getFilaTablero()- 1 > 0) {
			return tablero[tren.getFilaTablero() - 1][tren.getColumna()];
		}else if(tren.getDireccion() == 'B' && tren.getFilaTablero()+ 1 < tablero.length) {
			return tablero[tren.getFilaTablero() + 1][tren.getColumna()];
		}else if(tren.getDireccion() == 'I' && tren.getColumna()- 1 > 0) {
			return tablero[tren.getFilaTablero()][tren.getColumna() - 1];
		}else if(tren.getDireccion() == 'D' && tren.getColumna()+ 1 < tablero.length) {
			return tablero[tren.getFilaTablero()][tren.getColumna() + 1];
		}else {
		return 'E';
		}
	}

	public void borroTren(Tren tren) {
		// TODO Auto-generated method stub
		char direccionTren = tren.getDireccion();
		switch(direccionTren) {
		case 'A': borroArriba(tren);
		break;
		case 'B': borroAbajo(tren);
		break;
		case 'D': borroDerecha(tren);
		break;
		case 'I': borroIzquierda(tren);
		break;
		}
	}

	private void borroIzquierda(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();
		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] != 'X') {
				tablero[fila][col] = '.';
			}
			col++;
		}
	}

	private void borroDerecha(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();
		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] != 'X') {
				tablero[fila][col] = '.';
			}
			col--;
		}
	}

	private void borroAbajo(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();

		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] != 'X') {
				tablero[fila][col] = '.';
			}
			fila--;
		}
	}

	private void borroArriba(Tren tren) {
		// TODO Auto-generated method stub
		int col = tren.getColumna();
		int fila = tren.getFilaTablero();

		for (int i = 0; i < tren.getLongitud(); i++) {
			if (tablero[fila][col] != 'X') {
				tablero[fila][col] = '.';
			}
			fila++;
		}
	}
}

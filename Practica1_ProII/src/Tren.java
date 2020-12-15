
public class Tren {
	private char direccion;
	private int longitud;
	private int fila;
	private int filaTablero;
	private int columna;
	private boolean esCorrecto = true;
	private boolean estaCaido = false;
	private int tamTablero;
	//private int numTren; 

	public Tren(String linea, int tam) {
		// TODO Auto-generated constructor stub
		String[] lineaVector = linea.split(" ");
		
		
		//Hago todas las comprobaciones
		comprueboLinea(lineaVector);
		comprueboDireccion(lineaVector);
		comprueboLongitud(lineaVector);
		comprueboFila(lineaVector);
		comprueboColumna(lineaVector);
		
		this.direccion = lineaVector[0].charAt(0);
		this.longitud = Integer.parseInt(lineaVector[1]);
		this.fila = Integer.parseInt(lineaVector[3]);
		this.filaTablero = tam-fila-1;
		this.columna = Integer.parseInt(lineaVector[2]);
		
	}

	private void comprueboLinea(String[] lineaVector) {
		// TODO Auto-generated method stub
		if (lineaVector.length != 4) {
			esCorrecto = false;
			System.out.println("Conjunto de trenes incorrecto.");
		}
	}
	
	private void comprueboDireccion(String[] lineaVector) {
		// TODO Auto-generated method stub
		this.direccion = lineaVector[0].charAt(0);

		if (direccion == 'D' || direccion == 'I' || direccion == 'A' || direccion == 'B') {
			esCorrecto = true;
		} else {
			System.out.println("Direccion incorrecta");
			esCorrecto = false;
		}
	}


	private void comprueboLongitud(String[] lineaVector) {
		// TODO Auto-generated method stub
		this.longitud = comprueboEntero(lineaVector[1]);
		
		if(longitud < 1 || longitud > 30) {
			System.out.println("Longitud incorrecta");
			esCorrecto = false;
		}
		
	}
	
	private int comprueboEntero(String string) {
		int aux = -1;
		try {
			aux = Integer.parseInt(string);
			return aux;
		}catch ( Exception e) {
			return aux;
		}
	}
	
	private void comprueboFila(String[] lineaVector) {
		// TODO Auto-generated method stub
		this.fila = Integer.parseInt(lineaVector[2]);
		
		if (fila < 0 || fila > 29) {
			System.out.println("Fila incorrecta");
			esCorrecto = false;
		}
	}


	private void comprueboColumna(String[] lineaVector) {
		// TODO Auto-generated method stub
		this.columna = Integer.parseInt(lineaVector[3]);
		
		if(columna < 0 || columna > 29) {
			esCorrecto = false;
			System.out.println("Col incorrecta");
		}
	}
	
	
	public char getDireccion() {
		return direccion;
	}

	public int getLongitud() {
		return longitud;
	}

	public int getFila() {
		return fila;
	}

	public int getFilaTablero() {
		return filaTablero;
	}

	public int getColumna() {
		return columna;
	}

	public boolean getEsCorrecto() {
		return esCorrecto;
	}

	public boolean getEstaCaido() {
		return estaCaido;
	}

	public int getTamTablero() {
		return tamTablero;
	}

	public void muevoTren(char casilla) {
		// TODO Auto-generated method stub
		char direccionTren = this.getDireccion();
		
		if(casilla == '.') {
			switch(direccionTren) {
				case 'A': this.filaTablero = this.getFilaTablero() - 1;
				break;
				case 'B': this.filaTablero = this.getFilaTablero() + 1;
				break;
				case 'D': this.columna = this.getColumna() + 1;
				break;
				case 'I': this.columna = this.getColumna() - 1;
				break;
			}
		}else if(casilla == 'E' || casilla == 'X'){
			this.longitud = this.getLongitud() - 1;
		}else {//primera colision
			
		}
		
	}


}

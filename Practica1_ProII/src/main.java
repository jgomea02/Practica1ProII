import java.util.ArrayList;
import java.util.Scanner;

public class main {
			
	static final int TAMTABLERO = 30;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> lineas = new ArrayList<String>();
		lineas = lectura();
		ArrayList<String> lineasOrdenadas = new ArrayList<String>();

		lineasOrdenadas = colocaLineas(lineas);

		System.out.println();

		ArrayList<Tren> trenes = new ArrayList<Tren>();
		for (int i = 0; i < lineasOrdenadas.size(); i++) {
			Tren tren1 = new Tren(lineasOrdenadas.get(i), TAMTABLERO);
			
			if(tren1.getEsCorrecto() == true) {
				trenes.add(tren1);
			}else {
				System.out.println(("error"));
			}
		}//fin de creo trenes
		
		Tablero tablero1 = new Tablero(TAMTABLERO);
		//ArrayList<Tablero> tableros = new ArrayList<Tablero>();
		System.out.println("Tablero inicial");
		tablero1.dibujoTablero();
		System.out.println();
		
		for(int i = 0; i < trenes.size(); i++) {
			tablero1.colocoTren(trenes.get(i));
		}
		System.out.println();
		tablero1.dibujoTablero();
		System.out.println();
		
		/*for(int i = 0; i < 20 ; i++) {
			for (int j= 0; j < trenes.size(); j++) {
				tablero1.muevoTrenes(trenes.get(j));
			}
			System.out.println("Tablero " + i);
			tablero1.dibujoTablero();
			System.out.println();
		}*/
		
		boolean fin = false;
		while (fin == false) {
			for (int i = 0; i < trenes.size(); i++) {
				tablero1.muevoTrenes(trenes.get(i));
			}
			System.out.println("Tablero ");
			tablero1.dibujoTablero();
			System.out.println();
			
			fin = tablero1.esFinal();
		}
	}
	
	/*public void colocoTrenes(ArrayList<Tren> trenes) {
		// TODO Auto-generated method stub
	
	}*/

	private static ArrayList<String> colocaLineas(ArrayList<String> lineas) {
		// TODO Auto-generated method stub
		ArrayList<String> lineasOrdenadas = new ArrayList<String>();

		// Coloco las que empiezan por B primero
		for (int i = 0; i < lineas.size(); i++) {
			if (lineas.get(i).charAt(0) == 'B') {
				lineasOrdenadas.add(lineas.get(i));
			}
		}
		// Coloco las que empiezan por A segundo
		for (int i = 0; i < lineas.size(); i++) {
			if (lineas.get(i).charAt(0) == 'A') {
				lineasOrdenadas.add(lineas.get(i));
			}
		}

		// Coloco las que empiezan por I tercero
		for (int i = 0; i < lineas.size(); i++) {
			if (lineas.get(i).charAt(0) == 'I') {
				lineasOrdenadas.add(lineas.get(i));
			}
		}

		// Coloco las que empiezan por D cuarto
		for (int i = 0; i < lineas.size(); i++) {
			if (lineas.get(i).charAt(0) == 'D') {
				lineasOrdenadas.add(lineas.get(i));
			}
		}
		return lineasOrdenadas;
	}

	private static ArrayList<String> lectura() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numeroTrenes = Integer.parseInt(sc.nextLine());
		boolean entradaCorrecta = false;

		if (numeroTrenes <= 10 && numeroTrenes > 0) {
			entradaCorrecta = true;
		}

		if (entradaCorrecta == true) {
			ArrayList<String> lineas = new ArrayList<String>(numeroTrenes);
			for (int i = 0; i < numeroTrenes; i++) {
				lineas.add(sc.nextLine());
			}
			sc.close();
			return lineas;
		} else {
			System.out.println("Conjunto de trenes incorrecto.");
			sc.close();
			return null;
		}

	}

}

/*
10
D 9 11 23
A 8 11 17
A 5 15 15
A 5 15 8
B 7 23 13
A 6 23 6
D 9 8 9
I 13 17 0
A 12 13 11
I 5 20 9

5
D 5 7 4
B 4 3 1
A 5 4 5
A 6 5 9
I 3 0 6
 */



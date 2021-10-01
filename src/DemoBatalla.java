
import java.util.Random;
import java.util.Scanner;

public class DemoBatalla {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Nave[] misNaves = new Nave[10];

		String nomb;
		int fil, col, punt;
		boolean est;

		for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i + 1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.print("Fila: ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.nextInt();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();
			System.out.print("\n");
			// Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i] = new Nave();
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);

		}

		System.out.println("\nNaves creadas:");

		mostrarNaves(misNaves);

		// Hacer un menu para elegir que quiere mostrar
		int indicador;
		do {
			System.out.println("MENÚ DE SELECCIÓN DE DATOS:");
			System.out.println("1) Mostrar detalle de nave por nombre.");
			System.out.println("2) Mostrar detalle de naves por puntos.");
			System.out.println("3) Mostrar naves aleatorias.");
			System.out.println("4) Mostrar matriz de naves.");
			System.out.println("5) Salir.");
			indicador = sc.nextInt();

			switch (indicador) {
			case 1:
				System.out.println("Elegiste 1");
				System.out.println("Mostrar detalle de nave por nombre:\n");
				mostrarPorNombre(misNaves);

				break;
			case 2:
				System.out.println("Elegiste 2");
				System.out.println("Mostrar detalle de naves por puntos:\n");
				mostrarPorPuntos(misNaves);
				break;
			case 3:
				System.out.println("Elegiste 3");
				System.out.println("Mostrar naves aleatorias:\n");
				mostrarNaves(navesDesordenadas(misNaves));
				break;
			case 4:
				System.out.println("Elegiste 4");
				System.out.println("Mostrar matriz de naves:\n");
				mostrarMatrizDeNaves(misNaves);
				break;
			case 5:
				System.out.println("Elegiste 5. Adiós");
				break;
			}
		} while (indicador != 5);
		System.out.print("Ingrese un nombre para buscar: ");
		sc.nextLine();
		String nombre = sc.nextLine();
		// mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en
		// caso contrario
		int pos = busquedaLinealNombre(misNaves, nombre);
		if (pos != -1)
			misNaves[pos].mostrarNave();

		ordenarPorPuntosBurbuja(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreBurbuja(misNaves);
		mostrarNaves(misNaves);
		// mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en
		// caso contrario
		pos = busquedaBinariaNombre(misNaves, nombre);
		if (pos != -1)
			misNaves[pos].mostrarNave();
		ordenarPorPuntosSeleccion(misNaves);
		mostrarNaves(misNaves);
		ordenarPorPuntosInsercion(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreSeleccion(misNaves);
		mostrarNaves(misNaves);
		ordenarPorNombreInsercion(misNaves);
		mostrarNaves(misNaves);
	}

	// Método para mostrar todas las naves
	public static void mostrarNaves(Nave[] flota) {
		for (int i = 0; i < flota.length; i++) {

			System.out.println("Nave " + (i + 1));
			System.out.println("Nombre: " + flota[i].getNombre());
			System.out.println("Fila: " + flota[i].getFila());
			System.out.println("Columna: " + flota[i].getColumna());
			System.out.println("Estado: " + flota[i].getEstado());
			System.out.println("Puntos: " + flota[i].getPuntos());
			System.out.print("\n");
		}
	}

	// Método para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave[] flota) {
		String nombreNave;
		System.out.print("Nombre de la nave:");
		nombreNave = sc.next();
		for (int i = 0; i < flota.length; i++) {
			if (flota[i].getNombre().equals(nombreNave)) {
				System.out.println("Nave " + (i + 1));
				System.out.println("Nombre: " + flota[i].getNombre());
				System.out.println("Fila: " + flota[i].getFila());
				System.out.println("Columna: " + flota[i].getColumna());
				System.out.println("Estado: " + flota[i].getEstado());
				System.out.println("Puntos: " + flota[i].getPuntos());
				System.out.print("\n");
			}
		}
	}

	// Método para mostrar todas las naves con un número de puntos inferior o igual
	// al número de puntos que se pide por teclado
	public static void mostrarPorPuntos(Nave[] flota) {

		int puntosNave;
		puntosNave = sc.nextInt();
		for (int i = 0; i < flota.length; i++) {
			if (flota[i].getPuntos() <= puntosNave) {
				System.out.println("Nave " + (i + 1));
				System.out.println("Nombre: " + flota[i].getNombre());
				System.out.println("Fila: " + flota[i].getFila());
				System.out.println("Columna: " + flota[i].getColumna());
				System.out.println("Estado: " + flota[i].getEstado());
				System.out.println("Puntos: " + flota[i].getPuntos());
				System.out.print("\n");
			}
		}
	}

	// Método que muestra las naves de forma matricial
	public static void mostrarMatrizDeNaves(Nave[] flota) {
		int filaMayor = flota[0].getFila();
		int columnaMayor = flota[0].getColumna();
		for (int i = 1; i < flota.length; i++) {
			if (flota[i].getFila() > filaMayor) {
				filaMayor = flota[i].getFila();
			}
		}

		for (int i = 1; i < flota.length; i++) {
			if (flota[i].getColumna() > columnaMayor) {
				columnaMayor = flota[i].getColumna();
			}
		}

		String[][] nombres = new String[filaMayor][columnaMayor];

		for (int i = 0; i < flota.length; i++)
			nombres[flota[i].getFila() - 1][flota[i].getColumna() - 1] = flota[i].getNombre();

		for (int i = 0; i < nombres.length; i++) {
			for (int j = 0; j < nombres[i].length; j++) {
				if (nombres[i][j] != null)
					System.out.print("[" + nombres[i][j] + "] ");
				else
					System.out.print("[ 	]");
			}

			System.out.println();
		}
	}

	// Crear un método que devuelva un nuevo arreglo de objetos con todos los
	// objetos previamente ingresados
	// pero aleatoriamente desordenados
	public static Nave[] navesDesordenadas(Nave[] flota) {
		Random rand = new Random();
		for (int i = 0; i < flota.length; i++) {
			int aleatorio = rand.nextInt(flota.length);
			Nave temp = flota[aleatorio];
			flota[aleatorio] = flota[i];
			flota[i] = temp;
		}
		return flota;
	}

	// Método para buscar la primera nave con un nombre que se pidió por teclado
	public static int busquedaLinealNombre(Nave[] flota, String s) {
		for (int i = 0; i < flota.length; i++) {
			if (flota[i].getNombre().equals(s))
				return i;
		}
		return -1;
	}

	// Método que ordena por número de puntos de menor a mayor
	public static void ordenarPorPuntosBurbuja(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++)
			for (int j = 0; j < flota.length - i - 1; j++)
				if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
					Nave temp = flota[j];
					flota[j] = flota[j + 1];
					flota[j + 1] = temp;
				}
	}

	// Método que ordena por nombre de A a Z
	public static void ordenarPorNombreBurbuja(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++)
			for (int j = 0; j < flota.length - i - 1; j++)
				if (flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) < 0) {
					Nave temp = flota[j];
					flota[j] = flota[j + 1];
					flota[j + 1] = temp;
				}
	}

	// Método para buscar la primera nave con un nombre que se pidió por teclado
	public static int busquedaBinariaNombre(Nave[] flota, String s) {
		int l = 0, r = flota.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int res = s.compareTo(flota[m].getNombre());
			if (res == 0)
				return m;
			if (res > 0)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	// Método que ordena por número de puntos de menor a mayor
	public static void ordenarPorPuntosSeleccion(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < flota.length; j++)
				if (flota[j].getPuntos() < flota[minIndex].getPuntos())
					minIndex = j;
			Nave temp = flota[minIndex];
			flota[minIndex] = flota[i];
			flota[i] = temp;
		}
	}

	// Método que ordena por nombre de A a Z
	public static void ordenarPorNombreSeleccion(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++) {

			// Find the minimum element in unsorted array
			int min_index = i;
			String minStr = flota[i].getNombre();
			for (int j = i + 1; j < flota.length; j++) {
				if (flota[j].getNombre().compareTo(minStr) < 0) {
					minStr = flota[j].getNombre();
					min_index = j;
				}
			}
			if (min_index != i) {
				Nave temp = flota[min_index];
				flota[min_index] = flota[i];
				flota[i] = temp;
			}
		}
	}

	// Método que muestra las naves ordenadas por número de puntos de mayor a menor
	public static void ordenarPorPuntosInsercion(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			int numberToInsert = flota[i].getPuntos();
			int compareIndex = i;
			while (compareIndex > 0 && flota[compareIndex - 1].getPuntos() > numberToInsert) {
				flota[compareIndex] = flota[compareIndex - 1]; // shifting element
				compareIndex--; // moving backwards, towards index 0
			}
			// compareIndex now denotes proper place for number to be sorted
			flota[compareIndex] = flota[i];
		}
	}

	// Método que muestra las naves ordenadas por nombre de Z a A
	public static void ordenarPorNombreInsercion(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (flota[j].getNombre().compareTo(flota[j - 1].getNombre()) < 0) {
					Nave temp = flota[j];
					flota[j] = flota[j - 1];
					flota[j - 1] = temp;
				}
			}
		}
	}
}
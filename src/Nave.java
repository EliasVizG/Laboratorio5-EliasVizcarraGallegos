public class Nave {
	private String nombre;
	private int fila;
	private int columna;
	private boolean estado;
	private int puntos;

	// Metodos mutadores
	public void setNombre(String n) {
		nombre = n;
	}

	public void setFila(int f) {
		fila = f;
	}

	public void setColumna(int c) {
		columna = c;
	}

	public void setEstado(boolean e) {
		estado = e;
	}

	public void setPuntos(int p) {
		puntos = p;
	}

	// Metodos accesores
	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public boolean getEstado() {
		return estado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void mostrarNave() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Fila: " + fila);
		System.out.println("Columna: " + columna);
		System.out.println("Estado: " + estado);
		System.out.println("Puntos: " + puntos);
		System.out.print("\n");
	}
	// Completar con otros métodos necesarios
}
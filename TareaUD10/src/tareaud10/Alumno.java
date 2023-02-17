package tareaud10;

import java.util.*;

public class Alumno {

	static Scanner sc;
	private String nombre;
	private String curso;
	private int[] notas;

	public Alumno(String nombre, String curso, int asignaturas) {
		this.nombre = nombre;
		this.curso = curso;
		notas = new int[asignaturas];
	}

	public Alumno(String nombre, String curso) {
		this(nombre, curso, 5);
	}

	public Alumno(String nombre) {
		this(nombre, "DAM");
	}

	// MÉTODOS

	public String getNombre() {
		return nombre;
	}

	public String getCurso() {
		return curso;
	}

	public int[] getNotas() {
		return notas;
	}

	// dar valor a notas

	public void setNotas() {

		sc = new Scanner(System.in);

		String notasString = sc.nextLine();

		String arrStr[] = notasString.split(" ");

		while (arrStr.length != notas.length) {
			System.out.println(
					"El número de notas introducido es distinto al número de asignaturas, introduzca las notas de nuevo:");
			notasString = sc.nextLine();
			arrStr = notasString.split(" ");
		}

		int arr[] = new int[arrStr.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(arrStr[i]);
		}

		notas = arr;

	}

	// obtener media en base a notas

	public double getMedia(int[] getNotas) {

		double suma = 0;

		for (int i = 0; i < getNotas.length; i++) {
			suma += getNotas[i];
		}

		double media = suma / getNotas.length;

		return media;

	}

	// ordenar notas de menor a mayor

	public int[] ordenarNotas(int[] getNotas) {

		Arrays.sort(getNotas);

		return getNotas;

	}

	// cambiar nombre de alumno

	public void cambiarNombre() {

		System.out.println("Escribe el nombre modificado:");

		sc = new Scanner(System.in);

		String nombreNuevo = sc.nextLine();

		nombre = nombreNuevo;

	}

	// cambiar una de las notas

	public void cambiarNota(int[] getNotas) {

		System.out.println(
				"Escribe la nota que quieres cambiar, por número de orden (la primera nota mostrada será la 1):");

		sc = new Scanner(System.in);

		int notaCambiar = sc.nextInt();

		while (notaCambiar > notas.length || notaCambiar < 1) {
			System.out.println("El número introducido no coincide con ninguna nota, introduzca el número de nuevo:");
			notaCambiar = sc.nextInt();
		}

		notaCambiar -= 1;

		System.out.println("Escribe la nueva nota deseada (del 0 al 10)");

		int notaNueva = sc.nextInt();

		while (notaNueva > 10 || notaCambiar < 0) {
			System.out.println("La nota introducida no es válida, introduzca la nota de nuevo:");
			notaCambiar = sc.nextInt();
		}

		notas[notaCambiar] = notaNueva;

		System.out.println("La nota fue cambiada correctamente.");

	}

}

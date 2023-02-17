package tareaud10;

import java.util.*;

public class PruebaAlumno {

	public static void main(String[] args) {

		Alumno marcos = new Alumno("Marcos Fernández de Salamanca", "DAW", 6);
		Alumno alejandro = new Alumno("Alejandro Sastre", "DAW");
		Alumno pablo = new Alumno("Pablo Sastre");

		// MARCOS setNotas

		System.out.println("Introduce las " + marcos.getNotas().length + " notas de " + marcos.getNombre() + " separadas por espacios.");

		marcos.setNotas();

		// MARCOS getNotas

		System.out.println("Las notas de " + marcos.getNombre() + " son: " + Arrays.toString(marcos.getNotas()));

		// ALEJANDRO getMedia

		System.out.println("\nIntroduce las " + alejandro.getNotas().length + " notas de " + alejandro.getNombre() + " separadas por espacios.");

		alejandro.setNotas();

		System.out.println("Media de " + alejandro.getNombre() + ": " + alejandro.getMedia(alejandro.getNotas()));

		// ALEJANDRO ordenarNotas de menor a mayor

		System.out.println("Notas ordenadas de " + alejandro.getNombre() + ": " + Arrays.toString(alejandro.ordenarNotas(alejandro.getNotas())));

		// PABLO cambiarNombre

		System.out.println("\nVamos a modificar el nombre de " + pablo.getNombre());

		pablo.cambiarNombre();

		System.out.println("Ahora el nombre es " + pablo.getNombre());

		// PABLO cambiarNota

		System.out.println("Introduce las " + pablo.getNotas().length + " notas de " + pablo.getNombre() + " separadas por espacios.");

		pablo.setNotas();

		pablo.cambiarNota(pablo.getNotas());

		System.out.println(
				"Las notas modificadas de " + pablo.getNombre() + " son: " + Arrays.toString(pablo.getNotas()));

	}

}
package aJendaObjetos;

import java.util.Scanner;

public class Metodos {

	static Scanner leer = new Scanner(System.in);

	/**
	 * Inicializar vector
	 * 
	 * @param vContactos Vector de contactos.
	 */
	public static void inicializarVector(Contacto vContactos[]) {
		for (int i = 0; i < vContactos.length; i++) {
			vContactos[i] = new Contacto();
		}
	}

	/**
	 * Menú principal
	 * 
	 * @return Devuelve al programa principal la opción escogida por el usuario.
	 */
	public static int menu() {

		int opcionMenu = 0;
		boolean error = false;

		System.out.println("--------------------------------------------------");
		System.out.println("              aJenda - MENÚ PRINCIPAL             ");
		System.out.println("--------------------------------------------------");
		System.out.println("1) Ver contactos          4) Modificar un contacto");
		System.out.println("2) Buscar un contacto     5) Eliminar un contacto ");
		System.out.println("3) Añadir un contacto     6) Salir                ");

		System.out.println();

		do {
			error = false;
			System.out.print("Introduce la opción deseada: > ");

			try {
				opcionMenu = leer.nextInt();
			} catch (java.util.InputMismatchException e) {
				error = true;
				System.out.println("Opción no válida. Inténtalo de nuevo.");
				leer = new Scanner(System.in);
			}

			if (error == false && (opcionMenu < 1 || opcionMenu > 6)) {
				error = true;
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}

			System.out.println();

		} while (error == true);

		return opcionMenu;

	}

	/**
	 * Mostrar contactos
	 * 
	 * @param vContactos Vector de contactos.
	 */
	public static void mostrarContactos(Contacto vContactos[]) {
		for (int i = 0; i < vContactos.length; i++) {
			if (!vContactos[i].getNombre().equals("")) {
				System.out.println("CONTACTO " + (i + 1) + ": " + vContactos[i].toString());
			}

		}
	}

	/**
	 * Volver al menú
	 * 
	 * @return Devuelve si el usuario desea salir del programa (true) o si desea
	 *         regresar al menú principal (false).
	 */
	public static boolean volverMenu() {

		return siNo("¿Quieres regresar al menú?");
	}

	private static boolean siNo(String mensaje) {
		String userInput;

		do {
			System.out.print(mensaje + " (S/N): > ");
			userInput = leer.next();

			System.out.println();
			if (userInput.equalsIgnoreCase("s")) {
				return true;
			} else {
				if (userInput.equalsIgnoreCase("n")) {
					return false;
				}
			}
			System.out.println("Opción no válida. Vuelve a intentarlo.");
		} while (true);

	}

	/**
	 * Busca el último contacto libre en el vector.
	 * 
	 * @param vContactos Vector de contactos.
	 * @return Última posición libre del vector. Si no queda ninguno se devuelve el
	 *         valor -1.
	 */
	private static int buscarUltimoContacto(Contacto vContactos[]) {
		for (int i = 0; i < vContactos.length; i++) {
			if (vContactos[i].getNombre().equals("")) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Añadir un nuevo contacto.
	 * 
	 * @param vContactos Vector de contactos.
	 */
	public static void nuevoContacto(Contacto vContactos[]) {

		int ultimoContacto = buscarUltimoContacto(vContactos);
		leer = new Scanner(System.in);

		if (ultimoContacto != -1) {
			System.out.print("Introduce el nombre del nuevo contacto: > ");
			vContactos[ultimoContacto].setNombre(leer.nextLine());
			System.out.print("Introduce el apellido del nuevo contacto: > ");
			vContactos[ultimoContacto].setApellido(leer.nextLine());
			System.out.print("Introduce el teléfono del nuevo contacto: > ");
			vContactos[ultimoContacto].setTelefono(leer.nextLine());

			System.out
					.println("\nEl contacto se ha añadido correctamente como CONTACTO " + (ultimoContacto + 1) + ".\n");

		} else {
			System.out.println("La agenda está llena. No se pueden añadir nuevos contactos.\n");
		}
	}

	/**
	 * Reorganiza los contactos para que no haya huecos libres.
	 * 
	 * @param vContactos Vector de contactos que se reordenará.
	 */
	private static void reordenarContactos(Contacto vContactos[]) {
		for (int i = 0; i < vContactos.length - 1; i++) {
			if (vContactos[i].getNombre().equals("")) {
				vContactos[i] = vContactos[i + 1];
				vContactos[i + 1] = new Contacto();
			}
		}
	}

	/**
	 * Modificar un contacto existente.
	 * 
	 * @param vContactos Vector de contactos.
	 */
	public static void modificarContacto(Contacto vContactos[]) {
		leer = new Scanner(System.in);
		int id = 0;

		System.out.print("Introduce el ID del contacto que deseas modificar: > ");
		id = leer.nextInt();
		System.out.println("\nSe modificará el siguiente contacto:");
		System.out.println("CONTACTO " + id + ": " + vContactos[id - 1].toString());
		System.out.println();
		if (siNo("¿Estás seguro?") == true) {
			leer = new Scanner(System.in);
			System.out.print("Introduce el nuevo nombre del contacto: > ");
			vContactos[id - 1].setNombre(leer.nextLine());
			System.out.print("Introduce el nuevo apellido del contacto: > ");
			vContactos[id - 1].setApellido(leer.nextLine());
			System.out.print("Introduce el nuevo teléfono del contacto: > ");
			vContactos[id - 1].setTelefono(leer.nextLine());

			System.out.println("CONTACTO " + id + " se ha modificado correctamente.");

		} else {
			System.out.println("Se ha cancelado la operación. No se han realizado cambios.");
		}
	}

	/**
	 * Elimina un contacto especificado por el usuario.
	 * 
	 * @param vContactos Vector de contactos.
	 */
	public static void eliminarContacto(Contacto vContactos[]) {
		leer = new Scanner(System.in);
		int id = 0;

		System.out.print("Introduce el ID del contacto que deseas eliminar: > ");
		id = leer.nextInt();
		System.out.println("\nSe eliminará el siguiente contacto:");
		System.out.println("CONTACTO " + id + ": " + vContactos[id - 1].toString());
		System.out.println();
		if (siNo("¿Estás seguro?") == true) {
			vContactos[id - 1] = new Contacto();
			reordenarContactos(vContactos);

			System.out.println("CONTACTO " + id + " se ha eliminado correctamente.");
			System.out.println("Los contactos se han reordenado.\n");
		} else {
			System.out.println("Se ha cancelado la operación. No se han realizado cambios.\n");
		}
	}

	public static void buscarContacto(Contacto vContactos[]) {

		String userInput = "";
		int coincidenciaNombre = 0, coincidenciaApell=0, coincidenciaTlf=0;
		leer = new Scanner(System.in);

		System.out.print("Introduce un término de búsqueda: > ");
		userInput = leer.nextLine();
		System.out.println();

		for (int i = 0; i < vContactos.length; i++) {
			for (int j = 0; j < vContactos[i].getNombre().length() - userInput.length(); j++) {
				if (userInput.substring(0, userInput.length())
						.equalsIgnoreCase(vContactos[i].getNombre().substring(j, j + userInput.length()))) {
					if (coincidenciaNombre == 0) {
						System.out.println("Se han encontrado las siguientes coincidencias de nombre: ");
					}
					coincidenciaNombre++;
					System.out.println("  CONTACTO " + (i + 1) + ": " + vContactos[i].toString());
					break;
				}
			}
		}

		for (int i = 0; i < vContactos.length; i++) {

			for (int j = 0; j < vContactos[i].getApellido().length() - userInput.length(); j++) {
				if (userInput.substring(0, userInput.length())
						.equalsIgnoreCase(vContactos[i].getApellido().substring(j, j + userInput.length()))) {
					if (coincidenciaApell == 0) {
						System.out.println("\nSe han encontrado las siguientes coincidencias de apellido: ");
					}
					coincidenciaApell++;
					System.out.println("  CONTACTO " + (i + 1) + ": " + vContactos[i].toString());
					break;
				}
			}
		}

		for (int i = 0; i < vContactos.length; i++) {

			for (int j = 0; j < vContactos[i].getTelefono().length() - userInput.length(); j++) {
				if (userInput.substring(0, userInput.length())
						.equalsIgnoreCase(vContactos[i].getTelefono().substring(j, j + userInput.length()))) {
					if (coincidenciaTlf == 0) {
						System.out.println("\nSe han encontrado las siguientes coincidencias de teléfono: ");
					}
					coincidenciaTlf++;
					System.out.println("  CONTACTO " + (i + 1) + ": " + vContactos[i].toString());
					break;
				}
			}
		}

		if (coincidenciaNombre == 0 & coincidenciaApell==0 & coincidenciaTlf==0) {
			System.out.println("No se han encontrado coincidencias.\n");
		}
	System.out.println();
	}
}
